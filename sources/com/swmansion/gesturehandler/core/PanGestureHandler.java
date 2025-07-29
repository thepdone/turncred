package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import com.microsoft.codepush.react.CodePushConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PanGestureHandler.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001TB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000fH\u0016J\b\u00107\u001a\u000205H\u0014J\u0018\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0014J\b\u0010<\u001a\u000205H\u0014J\b\u0010=\u001a\u000205H\u0016J\b\u0010>\u001a\u000205H\u0016J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010D\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\nJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\nJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\nJ\b\u0010R\u001a\u00020\u000fH\u0002J\b\u0010S\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u001e\u00102\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+¨\u0006U"}, d2 = {"Lcom/swmansion/gesturehandler/core/PanGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activateAfterLongPress", "", "activateDelayed", "Ljava/lang/Runnable;", "activeOffsetXEnd", "", "activeOffsetXStart", "activeOffsetYEnd", "activeOffsetYStart", "averageTouches", "", "defaultMinDistSq", "failOffsetXEnd", "failOffsetXStart", "failOffsetYEnd", "failOffsetYStart", "handler", "Landroid/os/Handler;", "lastX", "lastY", "maxPointers", "", "minDistSq", "minPointers", "minVelocitySq", "minVelocityX", "minVelocityY", "offsetX", "offsetY", "startX", "startY", "<set-?>", "Lcom/swmansion/gesturehandler/core/StylusData;", "stylusData", "getStylusData", "()Lcom/swmansion/gesturehandler/core/StylusData;", "translationX", "getTranslationX", "()F", "translationY", "getTranslationY", "velocityTracker", "Landroid/view/VelocityTracker;", "velocityX", "getVelocityX", "velocityY", "getVelocityY", "activate", "", "force", "onCancel", "onHandle", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetConfig", "resetProgress", "setActivateAfterLongPress", CodePushConstants.LATEST_ROLLBACK_TIME_KEY, "setActiveOffsetXEnd", "setActiveOffsetXStart", "setActiveOffsetYEnd", "setActiveOffsetYStart", "setAverageTouches", "setFailOffsetXEnd", "setFailOffsetXStart", "setFailOffsetYEnd", "setFailOffsetYStart", "setMaxPointers", "setMinDist", "minDist", "setMinPointers", "setMinVelocity", "minVelocity", "setMinVelocityX", "setMinVelocityY", "shouldActivate", "shouldFail", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PanGestureHandler extends GestureHandler<PanGestureHandler> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_ACTIVATE_AFTER_LONG_PRESS = 0;
    private static final int DEFAULT_MAX_POINTERS = 10;
    private static final int DEFAULT_MIN_POINTERS = 1;
    private static final float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private static final float MIN_VALUE_IGNORE = Float.MAX_VALUE;
    private long activateAfterLongPress;
    private boolean averageTouches;
    private final float defaultMinDistSq;
    private Handler handler;
    private float lastX;
    private float lastY;
    private float minDistSq;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private VelocityTracker velocityTracker;
    private float velocityX;
    private float velocityY;
    private float activeOffsetXStart = Float.MAX_VALUE;
    private float activeOffsetXEnd = Float.MIN_VALUE;
    private float failOffsetXStart = Float.MIN_VALUE;
    private float failOffsetXEnd = Float.MAX_VALUE;
    private float activeOffsetYStart = Float.MAX_VALUE;
    private float activeOffsetYEnd = Float.MIN_VALUE;
    private float failOffsetYStart = Float.MIN_VALUE;
    private float failOffsetYEnd = Float.MAX_VALUE;
    private float minVelocityX = Float.MAX_VALUE;
    private float minVelocityY = Float.MAX_VALUE;
    private float minVelocitySq = Float.MAX_VALUE;
    private int minPointers = 1;
    private int maxPointers = 10;
    private final Runnable activateDelayed = new Runnable() { // from class: com.swmansion.gesturehandler.core.PanGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            PanGestureHandler.activateDelayed$lambda$0(this.f$0);
        }
    };
    private StylusData stylusData = new StylusData(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, null);

    public PanGestureHandler(Context context) {
        this.minDistSq = Float.MIN_VALUE;
        Intrinsics.checkNotNull(context);
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f = scaledTouchSlop * scaledTouchSlop;
        this.defaultMinDistSq = f;
        this.minDistSq = f;
    }

    public final float getVelocityX() {
        return this.velocityX;
    }

    public final float getVelocityY() {
        return this.velocityY;
    }

    public final float getTranslationX() {
        return (this.lastX - this.startX) + this.offsetX;
    }

    public final float getTranslationY() {
        return (this.lastY - this.startY) + this.offsetY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activateDelayed$lambda$0(PanGestureHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.activate();
    }

    public final StylusData getStylusData() {
        return this.stylusData;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.activeOffsetXStart = Float.MAX_VALUE;
        this.activeOffsetXEnd = Float.MIN_VALUE;
        this.failOffsetXStart = Float.MIN_VALUE;
        this.failOffsetXEnd = Float.MAX_VALUE;
        this.activeOffsetYStart = Float.MAX_VALUE;
        this.activeOffsetYEnd = Float.MIN_VALUE;
        this.failOffsetYStart = Float.MIN_VALUE;
        this.failOffsetYEnd = Float.MAX_VALUE;
        this.minVelocityX = Float.MAX_VALUE;
        this.minVelocityY = Float.MAX_VALUE;
        this.minVelocitySq = Float.MAX_VALUE;
        this.minDistSq = this.defaultMinDistSq;
        this.minPointers = 1;
        this.maxPointers = 10;
        this.activateAfterLongPress = 0L;
        this.averageTouches = false;
    }

    public final PanGestureHandler setActiveOffsetXStart(float activeOffsetXStart) {
        this.activeOffsetXStart = activeOffsetXStart;
        return this;
    }

    public final PanGestureHandler setActiveOffsetXEnd(float activeOffsetXEnd) {
        this.activeOffsetXEnd = activeOffsetXEnd;
        return this;
    }

    public final PanGestureHandler setFailOffsetXStart(float failOffsetXStart) {
        this.failOffsetXStart = failOffsetXStart;
        return this;
    }

    public final PanGestureHandler setFailOffsetXEnd(float failOffsetXEnd) {
        this.failOffsetXEnd = failOffsetXEnd;
        return this;
    }

    public final PanGestureHandler setActiveOffsetYStart(float activeOffsetYStart) {
        this.activeOffsetYStart = activeOffsetYStart;
        return this;
    }

    public final PanGestureHandler setActiveOffsetYEnd(float activeOffsetYEnd) {
        this.activeOffsetYEnd = activeOffsetYEnd;
        return this;
    }

    public final PanGestureHandler setFailOffsetYStart(float failOffsetYStart) {
        this.failOffsetYStart = failOffsetYStart;
        return this;
    }

    public final PanGestureHandler setFailOffsetYEnd(float failOffsetYEnd) {
        this.failOffsetYEnd = failOffsetYEnd;
        return this;
    }

    public final PanGestureHandler setMinDist(float minDist) {
        this.minDistSq = minDist * minDist;
        return this;
    }

    public final PanGestureHandler setMinPointers(int minPointers) {
        this.minPointers = minPointers;
        return this;
    }

    public final PanGestureHandler setMaxPointers(int maxPointers) {
        this.maxPointers = maxPointers;
        return this;
    }

    public final PanGestureHandler setAverageTouches(boolean averageTouches) {
        this.averageTouches = averageTouches;
        return this;
    }

    public final PanGestureHandler setActivateAfterLongPress(long time) {
        this.activateAfterLongPress = time;
        return this;
    }

    public final PanGestureHandler setMinVelocity(float minVelocity) {
        this.minVelocitySq = minVelocity * minVelocity;
        return this;
    }

    public final PanGestureHandler setMinVelocityX(float minVelocityX) {
        this.minVelocityX = minVelocityX;
        return this;
    }

    public final PanGestureHandler setMinVelocityY(float minVelocityY) {
        this.minVelocityY = minVelocityY;
        return this;
    }

    private final boolean shouldActivate() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = this.activeOffsetXStart;
        if (f2 != Float.MAX_VALUE && f < f2) {
            return true;
        }
        float f3 = this.activeOffsetXEnd;
        if (f3 != Float.MIN_VALUE && f > f3) {
            return true;
        }
        float f4 = (this.lastY - this.startY) + this.offsetY;
        float f5 = this.activeOffsetYStart;
        if (f5 != Float.MAX_VALUE && f4 < f5) {
            return true;
        }
        float f6 = this.activeOffsetYEnd;
        if (f6 != Float.MIN_VALUE && f4 > f6) {
            return true;
        }
        float f7 = (f * f) + (f4 * f4);
        float f8 = this.minDistSq;
        if (f8 != Float.MAX_VALUE && f7 >= f8) {
            return true;
        }
        float f9 = this.velocityX;
        float f10 = this.minVelocityX;
        if (f10 != Float.MAX_VALUE && ((f10 < 0.0f && f9 <= f10) || (0.0f <= f10 && f10 <= f9))) {
            return true;
        }
        float f11 = this.velocityY;
        float f12 = this.minVelocityY;
        if (f12 != Float.MAX_VALUE && ((f12 < 0.0f && f9 <= f12) || (0.0f <= f12 && f12 <= f9))) {
            return true;
        }
        float f13 = (f9 * f9) + (f11 * f11);
        float f14 = this.minVelocitySq;
        return f14 != Float.MAX_VALUE && f13 >= f14;
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = (this.lastY - this.startY) + this.offsetY;
        if (this.activateAfterLongPress > 0 && (f * f) + (f2 * f2) > this.defaultMinDistSq) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            return true;
        }
        float f3 = this.failOffsetXStart;
        if (f3 != Float.MIN_VALUE && f < f3) {
            return true;
        }
        float f4 = this.failOffsetXEnd;
        if (f4 != Float.MAX_VALUE && f > f4) {
            return true;
        }
        float f5 = this.failOffsetYStart;
        if (f5 != Float.MIN_VALUE && f2 < f5) {
            return true;
        }
        float f6 = this.failOffsetYEnd;
        return f6 != Float.MAX_VALUE && f2 > f6;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            if (event.getToolType(0) == 2) {
                this.stylusData = StylusData.INSTANCE.fromEvent(event);
            }
            int state = getState();
            int actionMasked = sourceEvent.getActionMasked();
            if (actionMasked == 5 || actionMasked == 6) {
                this.offsetX += this.lastX - this.startX;
                this.offsetY += this.lastY - this.startY;
                this.lastX = GestureUtils.INSTANCE.getLastPointerX(sourceEvent, this.averageTouches);
                float lastPointerY = GestureUtils.INSTANCE.getLastPointerY(sourceEvent, this.averageTouches);
                this.lastY = lastPointerY;
                this.startX = this.lastX;
                this.startY = lastPointerY;
            } else {
                this.lastX = GestureUtils.INSTANCE.getLastPointerX(sourceEvent, this.averageTouches);
                this.lastY = GestureUtils.INSTANCE.getLastPointerY(sourceEvent, this.averageTouches);
            }
            if (state == 0 && sourceEvent.getPointerCount() >= this.minPointers) {
                resetProgress();
                this.offsetX = 0.0f;
                this.offsetY = 0.0f;
                this.velocityX = 0.0f;
                this.velocityY = 0.0f;
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.velocityTracker = velocityTrackerObtain;
                INSTANCE.addVelocityMovement(velocityTrackerObtain, sourceEvent);
                begin();
                if (this.activateAfterLongPress > 0) {
                    if (this.handler == null) {
                        this.handler = new Handler(Looper.getMainLooper());
                    }
                    Handler handler = this.handler;
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(this.activateDelayed, this.activateAfterLongPress);
                }
            } else {
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    INSTANCE.addVelocityMovement(velocityTracker, sourceEvent);
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker2);
                    velocityTracker2.computeCurrentVelocity(1000);
                    VelocityTracker velocityTracker3 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker3);
                    this.velocityX = velocityTracker3.getXVelocity();
                    VelocityTracker velocityTracker4 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker4);
                    this.velocityY = velocityTracker4.getYVelocity();
                }
            }
            if (actionMasked == 1 || actionMasked == 12) {
                if (state == 4) {
                    end();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (actionMasked == 5 && sourceEvent.getPointerCount() > this.maxPointers) {
                if (state == 4) {
                    cancel();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (actionMasked == 6 && state == 4 && sourceEvent.getPointerCount() < this.minPointers) {
                fail();
                return;
            }
            if (state == 2) {
                if (shouldFail()) {
                    fail();
                } else if (shouldActivate()) {
                    activate();
                }
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void activate(boolean force) {
        if (getState() != 4) {
            resetProgress();
        }
        super.activate(force);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onCancel() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
        this.stylusData = new StylusData(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, null);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetProgress() {
        this.startX = this.lastX;
        this.startY = this.lastY;
    }

    /* compiled from: PanGestureHandler.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/swmansion/gesturehandler/core/PanGestureHandler$Companion;", "", "()V", "DEFAULT_ACTIVATE_AFTER_LONG_PRESS", "", "DEFAULT_MAX_POINTERS", "", "DEFAULT_MIN_POINTERS", "MAX_VALUE_IGNORE", "", "MIN_VALUE_IGNORE", "addVelocityMovement", "", "tracker", "Landroid/view/VelocityTracker;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addVelocityMovement(VelocityTracker tracker, MotionEvent event) {
            float rawX = event.getRawX() - event.getX();
            float rawY = event.getRawY() - event.getY();
            event.offsetLocation(rawX, rawY);
            Intrinsics.checkNotNull(tracker);
            tracker.addMovement(event);
            event.offsetLocation(-rawX, -rawY);
        }
    }
}
