package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* compiled from: PagerLayoutInfo.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"mainAxisViewportSize", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getMainAxisViewportSize", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerLayoutInfoKt {
    public static final int getMainAxisViewportSize(PagerLayoutInfo pagerLayoutInfo) {
        return pagerLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m4906getHeightimpl(pagerLayoutInfo.mo1241getViewportSizeYbymL2g()) : IntSize.m4907getWidthimpl(pagerLayoutInfo.mo1241getViewportSizeYbymL2g());
    }
}
