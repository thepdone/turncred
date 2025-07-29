package androidx.compose.ui.unit;

import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.protocol.MetricSummary;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: Constraints.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u001a5\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a-\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082\b\u001a\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0002\u001a\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a\u0011\u0010,\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010-\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\b\u001a\u001c\u0010.\u001a\u00020\u0015*\u00020\u00152\u0006\u0010/\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001e\u0010.\u001a\u000202*\u00020\u00152\u0006\u0010\u001f\u001a\u000202H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00101\u001a\u001e\u00104\u001a\u00020\u0003*\u00020\u00152\u0006\u00105\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a\u001e\u00108\u001a\u00020\u0003*\u00020\u00152\u0006\u00109\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u00107\u001a\u001e\u0010;\u001a\u00020<*\u00020\u00152\u0006\u0010\u001f\u001a\u000202H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a*\u0010?\u001a\u00020\u0015*\u00020\u00152\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010C\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"FocusMask", "", "Infinity", "", "MaxAllowedForMaxFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxAllowedForMinFocusBits", "MaxAllowedForMinNonFocusBits", "MaxFocusBits", "MaxFocusHeight", "MaxFocusMask", "MaxFocusWidth", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusHeight", "MinFocusMask", "MinFocusWidth", "MinNonFocusBits", "MinNonFocusMask", androidx.constraintlayout.widget.Constraints.TAG, "Landroidx/compose/ui/unit/Constraints;", ViewProps.MIN_WIDTH, ViewProps.MAX_WIDTH, ViewProps.MIN_HEIGHT, ViewProps.MAX_HEIGHT, "(IIII)J", "addMaxWithMinimum", MetricSummary.JsonKeys.MAX, "value", "bitsNeedForSizeUnchecked", RRWebVideoEvent.JsonKeys.SIZE, "createConstraints", "heightMask", "bitOffset", "indexToBitOffset", FirebaseAnalytics.Param.INDEX, "invalidConstraint", "", "widthVal", "heightVal", "invalidSize", "", "maxAllowedForSize", "minHeightOffsets", "widthMask", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusHeight = 0;
    private static final int MaxFocusMask = 262143;
    private static final int MaxFocusWidth = 3;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusHeight = 1;
    private static final int MinFocusMask = 65535;
    private static final int MinFocusWidth = 2;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;

    private static final int bitsNeedForSizeUnchecked(int i) {
        if (i < MaxNonFocusMask) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < MaxFocusMask ? 18 : 255;
    }

    private static final int heightMask(int i) {
        return (1 << (18 - i)) - 1;
    }

    private static final int indexToBitOffset(int i) {
        return ((i & 1) << 1) + (((i & 2) >> 1) * 3);
    }

    private static final int minHeightOffsets(int i) {
        return i + 15;
    }

    private static final int widthMask(int i) {
        return (1 << (i + 13)) - 1;
    }

    private static final void invalidConstraint(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    private static final Void invalidSize(int i) {
        throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            invalidConstraint(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i7 & (~(i7 >> 31));
        int i9 = i4 + 1;
        int i10 = i9 & (~(i9 >> 31));
        int i11 = 0;
        if (iBitsNeedForSizeUnchecked2 != 13) {
            if (iBitsNeedForSizeUnchecked2 == 18) {
                i11 = 3;
            } else if (iBitsNeedForSizeUnchecked2 == 15) {
                i11 = 1;
            } else if (iBitsNeedForSizeUnchecked2 == 16) {
                i11 = 2;
            }
        }
        int i12 = ((i11 & 1) << 1) + (((i11 & 2) >> 1) * 3);
        return Constraints.m4679constructorimpl((i8 << 33) | i11 | (i << 2) | (i3 << (i12 + 15)) | (i10 << (i12 + 46)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxAllowedForSize(int i) {
        if (i < MaxNonFocusMask) {
            return MaxAllowedForMaxNonFocusBits;
        }
        if (i < 32767) {
            return MaxAllowedForMinNonFocusBits;
        }
        if (i < 65535) {
            return MaxAllowedForMinFocusBits;
        }
        if (i < MaxFocusMask) {
            return MaxAllowedForMaxFocusBits;
        }
        invalidSize(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (!(i2 >= i)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i2 + ") must be >= than minWidth(" + i + ')');
        }
        if (!(i4 >= i3)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + ')');
        }
        if (!(i >= 0 && i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m4705constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt.coerceIn(Constraints.m4692getMinWidthimpl(j2), Constraints.m4692getMinWidthimpl(j), Constraints.m4690getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m4690getMaxWidthimpl(j2), Constraints.m4692getMinWidthimpl(j), Constraints.m4690getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m4691getMinHeightimpl(j2), Constraints.m4691getMinHeightimpl(j), Constraints.m4689getMaxHeightimpl(j)), RangesKt.coerceIn(Constraints.m4689getMaxHeightimpl(j2), Constraints.m4691getMinHeightimpl(j), Constraints.m4689getMaxHeightimpl(j)));
    }

    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m4704constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m4907getWidthimpl(j2), Constraints.m4692getMinWidthimpl(j), Constraints.m4690getMaxWidthimpl(j)), RangesKt.coerceIn(IntSize.m4906getHeightimpl(j2), Constraints.m4691getMinHeightimpl(j), Constraints.m4689getMaxHeightimpl(j)));
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m4707constrainWidthK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m4692getMinWidthimpl(j), Constraints.m4690getMaxWidthimpl(j));
    }

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m4706constrainHeightK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m4691getMinHeightimpl(j), Constraints.m4689getMaxHeightimpl(j));
    }

    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m4708isSatisfiedBy4WqzIAM(long j, long j2) {
        int iM4692getMinWidthimpl = Constraints.m4692getMinWidthimpl(j);
        int iM4690getMaxWidthimpl = Constraints.m4690getMaxWidthimpl(j);
        int iM4907getWidthimpl = IntSize.m4907getWidthimpl(j2);
        if (iM4692getMinWidthimpl <= iM4907getWidthimpl && iM4907getWidthimpl <= iM4690getMaxWidthimpl) {
            int iM4691getMinHeightimpl = Constraints.m4691getMinHeightimpl(j);
            int iM4689getMaxHeightimpl = Constraints.m4689getMaxHeightimpl(j);
            int iM4906getHeightimpl = IntSize.m4906getHeightimpl(j2);
            if (iM4691getMinHeightimpl <= iM4906getHeightimpl && iM4906getHeightimpl <= iM4689getMaxHeightimpl) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m4710offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m4709offsetNN6EwU(j, i, i2);
    }

    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m4709offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m4692getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m4690getMaxWidthimpl(j), i), RangesKt.coerceAtLeast(Constraints.m4691getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m4689getMaxHeightimpl(j), i2));
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt.coerceAtLeast(i + i2, 0);
    }
}
