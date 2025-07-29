package androidx.compose.animation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/animation/TransitionEffect;", "", "()V", SDKConstants.PARAM_KEY, "Landroidx/compose/animation/TransitionEffectKey;", "getKey$animation_release", "()Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/ContentScaleTransitionEffect;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TransitionEffect {
    public static final int $stable = 0;

    public /* synthetic */ TransitionEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TransitionEffectKey<?> getKey$animation_release();

    private TransitionEffect() {
    }
}
