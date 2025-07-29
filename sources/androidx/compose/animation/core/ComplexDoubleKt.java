package androidx.compose.animation.core;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* compiled from: ComplexDouble.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n¨\u0006\r"}, d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComplexDoubleKt {
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d, double d2, double d3) {
        double d4 = (d2 * d2) - ((4.0d * d) * d3);
        double d5 = 1.0d / (d * 2.0d);
        double d6 = -d2;
        ComplexDouble complexDoubleComplexSqrt = complexSqrt(d4);
        complexDoubleComplexSqrt._real += d6;
        complexDoubleComplexSqrt._real *= d5;
        complexDoubleComplexSqrt._imaginary *= d5;
        ComplexDouble complexDoubleComplexSqrt2 = complexSqrt(d4);
        double d7 = -1;
        complexDoubleComplexSqrt2._real *= d7;
        complexDoubleComplexSqrt2._imaginary *= d7;
        complexDoubleComplexSqrt2._real += d6;
        complexDoubleComplexSqrt2._real *= d5;
        complexDoubleComplexSqrt2._imaginary *= d5;
        return TuplesKt.to(complexDoubleComplexSqrt, complexDoubleComplexSqrt2);
    }

    public static final ComplexDouble complexSqrt(double d) {
        if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
            return new ComplexDouble(AudioStats.AUDIO_AMPLITUDE_NONE, Math.sqrt(Math.abs(d)));
        }
        return new ComplexDouble(Math.sqrt(d), AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static final ComplexDouble plus(double d, ComplexDouble complexDouble) {
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble minus(double d, ComplexDouble complexDouble) {
        double d2 = -1;
        complexDouble._real *= d2;
        complexDouble._imaginary *= d2;
        complexDouble._real += d;
        return complexDouble;
    }

    public static final ComplexDouble times(double d, ComplexDouble complexDouble) {
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        return complexDouble;
    }
}
