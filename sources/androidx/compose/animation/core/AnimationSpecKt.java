package androidx.compose.animation.core;

import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.KeyframesWithSplineSpec;
import androidx.exifinterface.media.ExifInterface;
import io.sentry.Session;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnimationSpec.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a@\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\"\u0004\b\u0000\u0010\u00022\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0007\u001a3\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u00022\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0007\u001a=\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0007\u001a4\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001aH\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020#\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010$\u001a\u00020\u001fH\u0007\u001a9\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u001b2\n\b\u0002\u0010)\u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010*\u001a2\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u00020,\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010.\u001a\u00020/H\u0007\u001a9\u00100\u001a\u0004\u0018\u0001H1\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u00101*\u000202*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H1032\b\u00104\u001a\u0004\u0018\u0001H\u0002H\u0002¢\u0006\u0002\u00105\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"delayed", "Landroidx/compose/animation/core/AnimationSpec;", ExifInterface.GPS_DIRECTION_TRUE, "animationSpec", "startDelayNanos", "", "infiniteRepeatable", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "infiniteRepeatable-9IiC70o", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "keyframes", "Landroidx/compose/animation/core/KeyframesSpec;", Session.JsonKeys.INIT, "Lkotlin/Function1;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "", "Lkotlin/ExtensionFunctionType;", "keyframesWithSpline", "Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "periodicBias", "", "repeatable", "Landroidx/compose/animation/core/RepeatableSpec;", "iterations", "", "repeatable-91I0pcU", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/RepeatableSpec;", "snap", "Landroidx/compose/animation/core/SnapSpec;", "delayMillis", "spring", "Landroidx/compose/animation/core/SpringSpec;", "dampingRatio", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)Landroidx/compose/animation/core/SpringSpec;", "tween", "Landroidx/compose/animation/core/TweenSpec;", "durationMillis", "easing", "Landroidx/compose/animation/core/Easing;", "convert", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "data", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimationSpecKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, V extends AnimationVector> V convert(TwoWayConverter<T, V> twoWayConverter, T t) {
        if (t == null) {
            return null;
        }
        return twoWayConverter.getConvertToVector().invoke(t);
    }

    public static /* synthetic */ TweenSpec tween$default(int i, int i2, Easing easing, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 300;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            easing = EasingKt.getFastOutSlowInEasing();
        }
        return tween(i, i2, easing);
    }

    public static final <T> TweenSpec<T> tween(int i, int i2, Easing easing) {
        return new TweenSpec<>(i, i2, easing);
    }

    public static /* synthetic */ SpringSpec spring$default(float f, float f2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1500.0f;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return spring(f, f2, obj);
    }

    public static final <T> SpringSpec<T> spring(float f, float f2, T t) {
        return new SpringSpec<>(f, f2, t);
    }

    public static final <T> KeyframesSpec<T> keyframes(Function1<? super KeyframesSpec.KeyframesSpecConfig<T>, Unit> function1) {
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        function1.invoke(keyframesSpecConfig);
        return new KeyframesSpec<>(keyframesSpecConfig);
    }

    public static final <T> KeyframesWithSplineSpec<T> keyframesWithSpline(Function1<? super KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T>, Unit> function1) {
        KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig keyframesWithSplineSpecConfig = new KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig();
        function1.invoke(keyframesWithSplineSpecConfig);
        return new KeyframesWithSplineSpec<>(keyframesWithSplineSpecConfig);
    }

    public static final <T> KeyframesWithSplineSpec<T> keyframesWithSpline(float f, Function1<? super KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T>, Unit> function1) {
        KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig keyframesWithSplineSpecConfig = new KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig();
        function1.invoke(keyframesWithSplineSpecConfig);
        return new KeyframesWithSplineSpec<>(keyframesWithSplineSpecConfig, f);
    }

    /* renamed from: repeatable-91I0pcU$default, reason: not valid java name */
    public static /* synthetic */ RepeatableSpec m462repeatable91I0pcU$default(int i, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i2 & 8) != 0) {
            j = StartOffset.m495constructorimpl$default(0, 0, 2, null);
        }
        return m461repeatable91I0pcU(i, durationBasedAnimationSpec, repeatMode, j);
    }

    /* renamed from: repeatable-91I0pcU, reason: not valid java name */
    public static final <T> RepeatableSpec<T> m461repeatable91I0pcU(int i, DurationBasedAnimationSpec<T> durationBasedAnimationSpec, RepeatMode repeatMode, long j) {
        return new RepeatableSpec<>(i, durationBasedAnimationSpec, repeatMode, j, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RepeatableSpec repeatable$default(int i, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        return repeatable(i, durationBasedAnimationSpec, repeatMode);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the repeatable function that accepts start offset.")
    public static final /* synthetic */ RepeatableSpec repeatable(int i, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode) {
        return new RepeatableSpec(i, durationBasedAnimationSpec, repeatMode, StartOffset.m495constructorimpl$default(0, 0, 2, null), (DefaultConstructorMarker) null);
    }

    /* renamed from: infiniteRepeatable-9IiC70o$default, reason: not valid java name */
    public static /* synthetic */ InfiniteRepeatableSpec m460infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i & 4) != 0) {
            j = StartOffset.m495constructorimpl$default(0, 0, 2, null);
        }
        return m459infiniteRepeatable9IiC70o(durationBasedAnimationSpec, repeatMode, j);
    }

    /* renamed from: infiniteRepeatable-9IiC70o, reason: not valid java name */
    public static final <T> InfiniteRepeatableSpec<T> m459infiniteRepeatable9IiC70o(DurationBasedAnimationSpec<T> durationBasedAnimationSpec, RepeatMode repeatMode, long j) {
        return new InfiniteRepeatableSpec<>(durationBasedAnimationSpec, repeatMode, j, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int i, Object obj) {
        if ((i & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        return infiniteRepeatable(durationBasedAnimationSpec, repeatMode);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the infinite repeatable function that accepts start offset.")
    public static final /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode) {
        return new InfiniteRepeatableSpec(durationBasedAnimationSpec, repeatMode, StartOffset.m495constructorimpl$default(0, 0, 2, null), (DefaultConstructorMarker) null);
    }

    public static final <T> SnapSpec<T> snap(int i) {
        return new SnapSpec<>(i);
    }

    public static /* synthetic */ SnapSpec snap$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return snap(i);
    }

    public static final <T> AnimationSpec<T> delayed(AnimationSpec<T> animationSpec, long j) {
        return new StartDelayAnimationSpec(animationSpec, j);
    }
}
