package com.facebook.react.uimanager.layoutanimation;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;

/* loaded from: classes4.dex */
public class LayoutAnimationController {
    private Runnable mCompletionRunnable;
    private boolean mShouldAnimateLayout;
    private final AbstractLayoutAnimation mLayoutCreateAnimation = new LayoutCreateAnimation();
    private final AbstractLayoutAnimation mLayoutUpdateAnimation = new LayoutUpdateAnimation();
    private final AbstractLayoutAnimation mLayoutDeleteAnimation = new LayoutDeleteAnimation();
    private final SparseArray<LayoutHandlingAnimation> mLayoutHandlers = new SparseArray<>(0);
    private long mMaxAnimationDuration = -1;

    public void initializeFromConfig(ReadableMap readableMap, final Callback callback) {
        if (readableMap == null) {
            reset();
            return;
        }
        this.mShouldAnimateLayout = false;
        int i = readableMap.hasKey("duration") ? readableMap.getInt("duration") : 0;
        if (readableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.CREATE))) {
            this.mLayoutCreateAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.CREATE)), i);
            this.mShouldAnimateLayout = true;
        }
        if (readableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.UPDATE))) {
            this.mLayoutUpdateAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.UPDATE)), i);
            this.mShouldAnimateLayout = true;
        }
        if (readableMap.hasKey(LayoutAnimationType.toString(LayoutAnimationType.DELETE))) {
            this.mLayoutDeleteAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(LayoutAnimationType.DELETE)), i);
            this.mShouldAnimateLayout = true;
        }
        if (!this.mShouldAnimateLayout || callback == null) {
            return;
        }
        this.mCompletionRunnable = new Runnable() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.1
            @Override // java.lang.Runnable
            public void run() {
                callback.invoke(Boolean.TRUE);
            }
        };
    }

    public void reset() {
        this.mLayoutCreateAnimation.reset();
        this.mLayoutUpdateAnimation.reset();
        this.mLayoutDeleteAnimation.reset();
        this.mCompletionRunnable = null;
        this.mShouldAnimateLayout = false;
        this.mMaxAnimationDuration = -1L;
    }

    public boolean shouldAnimateLayout(View view) {
        if (view == null) {
            return false;
        }
        return (this.mShouldAnimateLayout && view.getParent() != null) || this.mLayoutHandlers.get(view.getId()) != null;
    }

    public void applyLayoutUpdate(View view, int i, int i2, int i3, int i4) {
        AbstractLayoutAnimation abstractLayoutAnimation;
        UiThreadUtil.assertOnUiThread();
        final int id = view.getId();
        LayoutHandlingAnimation layoutHandlingAnimation = this.mLayoutHandlers.get(id);
        if (layoutHandlingAnimation != null) {
            layoutHandlingAnimation.onLayoutUpdate(i, i2, i3, i4);
            return;
        }
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            abstractLayoutAnimation = this.mLayoutCreateAnimation;
        } else {
            abstractLayoutAnimation = this.mLayoutUpdateAnimation;
        }
        Animation animationCreateAnimation = abstractLayoutAnimation.createAnimation(view, i, i2, i3, i4);
        if (animationCreateAnimation instanceof LayoutHandlingAnimation) {
            animationCreateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    LayoutAnimationController.this.mLayoutHandlers.put(id, (LayoutHandlingAnimation) animation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LayoutAnimationController.this.mLayoutHandlers.remove(id);
                }
            });
        } else {
            view.layout(i, i2, i3 + i, i4 + i2);
        }
        if (animationCreateAnimation != null) {
            long duration = animationCreateAnimation.getDuration();
            if (duration > this.mMaxAnimationDuration) {
                this.mMaxAnimationDuration = duration;
                scheduleCompletionCallback(duration);
            }
            view.startAnimation(animationCreateAnimation);
        }
    }

    public void deleteView(View view, final LayoutAnimationListener layoutAnimationListener) {
        UiThreadUtil.assertOnUiThread();
        Animation animationCreateAnimation = this.mLayoutDeleteAnimation.createAnimation(view, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        if (animationCreateAnimation != null) {
            disableUserInteractions(view);
            animationCreateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    layoutAnimationListener.onAnimationEnd();
                }
            });
            long duration = animationCreateAnimation.getDuration();
            if (duration > this.mMaxAnimationDuration) {
                scheduleCompletionCallback(duration);
                this.mMaxAnimationDuration = duration;
            }
            view.startAnimation(animationCreateAnimation);
            return;
        }
        layoutAnimationListener.onAnimationEnd();
    }

    private void disableUserInteractions(View view) {
        view.setClickable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                disableUserInteractions(viewGroup.getChildAt(i));
            }
        }
    }

    private void scheduleCompletionCallback(long j) {
        if (this.mCompletionRunnable != null) {
            Handler uiThreadHandler = UiThreadUtil.getUiThreadHandler();
            uiThreadHandler.removeCallbacks(this.mCompletionRunnable);
            uiThreadHandler.postDelayed(this.mCompletionRunnable, j);
        }
    }
}
