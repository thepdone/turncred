package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: AnimatedDrawableValueAnimatorHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/facebook/fresco/animation/drawable/animator/AnimatedDrawableValueAnimatorHelper;", "", "()V", "createAnimatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "drawable", "Landroid/graphics/drawable/Drawable;", "createValueAnimator", "Landroid/animation/ValueAnimator;", "maxDurationMs", "", "animated-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimatedDrawableValueAnimatorHelper {
    public static final AnimatedDrawableValueAnimatorHelper INSTANCE = new AnimatedDrawableValueAnimatorHelper();

    private AnimatedDrawableValueAnimatorHelper() {
    }

    @JvmStatic
    public static final ValueAnimator createValueAnimator(Drawable drawable, int maxDurationMs) {
        if (drawable instanceof AnimatedDrawable2) {
            return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable, maxDurationMs);
        }
        return null;
    }

    @JvmStatic
    public static final ValueAnimator createValueAnimator(Drawable drawable) {
        if (!(drawable instanceof AnimatedDrawable2)) {
            return null;
        }
        AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) drawable;
        return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator(drawable, animatedDrawable2.getLoopCount(), animatedDrawable2.getLoopDurationMs());
    }

    @JvmStatic
    public static final ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(Drawable drawable) {
        if (drawable instanceof AnimatedDrawable2) {
            return AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener((AnimatedDrawable2) drawable);
        }
        return null;
    }
}
