package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: LayoutUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", ViewProps.OVERFLOW, "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m1620finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return Constraints.INSTANCE.m4699fitPrioritizingWidthZbe2FdA(0, m1622finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m4689getMaxHeightimpl(j));
    }

    /* renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m1622finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int iM4690getMaxWidthimpl = ((z || TextOverflow.m4668equalsimpl0(i, TextOverflow.INSTANCE.m4676getEllipsisgIe3tQ8())) && Constraints.m4686getHasBoundedWidthimpl(j)) ? Constraints.m4690getMaxWidthimpl(j) : Integer.MAX_VALUE;
        return Constraints.m4692getMinWidthimpl(j) == iM4690getMaxWidthimpl ? iM4690getMaxWidthimpl : RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m4692getMinWidthimpl(j), iM4690getMaxWidthimpl);
    }

    /* renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m1621finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !TextOverflow.m4668equalsimpl0(i, TextOverflow.INSTANCE.m4676getEllipsisgIe3tQ8())) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        return 1;
    }
}
