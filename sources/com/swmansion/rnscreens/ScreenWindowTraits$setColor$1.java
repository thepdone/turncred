package com.swmansion.rnscreens;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenWindowTraits.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/ScreenWindowTraits$setColor$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenWindowTraits$setColor$1 extends GuardedRunnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $animated;
    final /* synthetic */ Integer $color;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScreenWindowTraits$setColor$1(Activity activity, Integer num, boolean z, JSExceptionHandler jSExceptionHandler) {
        super(jSExceptionHandler);
        this.$activity = activity;
        this.$color = num;
        this.$animated = z;
    }

    @Override // com.facebook.react.bridge.GuardedRunnable
    public void runGuarded() {
        final Window window = this.$activity.getWindow();
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(window.getStatusBarColor()), this.$color);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$setColor$1$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScreenWindowTraits$setColor$1.runGuarded$lambda$0(window, valueAnimator);
            }
        });
        if (this.$animated) {
            valueAnimatorOfObject.setDuration(300L).setStartDelay(0L);
        } else {
            valueAnimatorOfObject.setDuration(0L).setStartDelay(300L);
        }
        valueAnimatorOfObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runGuarded$lambda$0(Window window, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setStatusBarColor(((Integer) animatedValue).intValue());
    }
}
