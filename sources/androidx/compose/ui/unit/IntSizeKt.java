package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;

/* compiled from: IntSize.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006\u001a\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0006\u001a\u0016\u0010\u0019\u001a\u00020\r*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"center", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntSize;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "IntSize", "width", "", "height", "(II)J", "roundToIntSize", "Landroidx/compose/ui/geometry/Size;", "roundToIntSize-uvyYCjk", "times", RRWebVideoEvent.JsonKeys.SIZE, "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "toIntSize", "toIntSize-uvyYCjk", "toSize", "toSize-ozmzZPI", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IntSizeKt {
    /* renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m4914getCenterozmzZPI$annotations(long j) {
    }

    public static final long IntSize(int i, int i2) {
        return IntSize.m4902constructorimpl((i2 & 4294967295L) | (i << 32));
    }

    /* renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m4916timesO0kMr_c(int i, long j) {
        return IntSize.m4909timesYEO4UFw(j, i);
    }

    /* renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m4917toIntRectozmzZPI(long j) {
        return IntRectKt.m4897IntRectVbeCjmY(IntOffset.INSTANCE.m4875getZeronOccac(), j);
    }

    /* renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m4913getCenterozmzZPI(long j) {
        return IntOffset.m4859constructorimpl((((j << 32) >> 33) & 4294967295L) | ((j >> 33) << 32));
    }

    /* renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m4919toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m4907getWidthimpl(j), IntSize.m4906getHeightimpl(j));
    }

    /* renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m4918toIntSizeuvyYCjk(long j) {
        return IntSize.m4902constructorimpl((((int) Size.m2101getHeightimpl(j)) & 4294967295L) | (((int) Size.m2104getWidthimpl(j)) << 32));
    }

    /* renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m4915roundToIntSizeuvyYCjk(long j) {
        return IntSize.m4902constructorimpl((Math.round(Size.m2101getHeightimpl(j)) & 4294967295L) | (Math.round(Size.m2104getWidthimpl(j)) << 32));
    }
}
