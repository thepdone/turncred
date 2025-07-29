package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* compiled from: LayoutCoordinates.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\u000b\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\f"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "positionOnScreen", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo3624localToRootMKHz9U(Offset.INSTANCE.m2051getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo3626localToWindowMKHz9U(Offset.INSTANCE.m2051getZeroF1C5BW0());
    }

    public static final long positionOnScreen(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo3625localToScreenMKHz9U(Offset.INSTANCE.m2051getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fM4907getWidthimpl = IntSize.m4907getWidthimpl(layoutCoordinatesFindRootCoordinates.mo3621getSizeYbymL2g());
        float fM4906getHeightimpl = IntSize.m4906getHeightimpl(layoutCoordinatesFindRootCoordinates.mo3621getSizeYbymL2g());
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        float left = rectBoundsInRoot.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > fM4907getWidthimpl) {
            left = fM4907getWidthimpl;
        }
        float top = rectBoundsInRoot.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > fM4906getHeightimpl) {
            top = fM4906getHeightimpl;
        }
        float right = rectBoundsInRoot.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= fM4907getWidthimpl) {
            fM4907getWidthimpl = right;
        }
        float bottom = rectBoundsInRoot.getBottom();
        float f = bottom >= 0.0f ? bottom : 0.0f;
        if (f <= fM4906getHeightimpl) {
            fM4906getHeightimpl = f;
        }
        if (left == fM4907getWidthimpl || top == fM4906getHeightimpl) {
            return Rect.INSTANCE.getZero();
        }
        long jMo3626localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo3626localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long jMo3626localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo3626localToWindowMKHz9U(OffsetKt.Offset(fM4907getWidthimpl, top));
        long jMo3626localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo3626localToWindowMKHz9U(OffsetKt.Offset(fM4907getWidthimpl, fM4906getHeightimpl));
        long jMo3626localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo3626localToWindowMKHz9U(OffsetKt.Offset(left, fM4906getHeightimpl));
        float fM2035getXimpl = Offset.m2035getXimpl(jMo3626localToWindowMKHz9U);
        float fM2035getXimpl2 = Offset.m2035getXimpl(jMo3626localToWindowMKHz9U2);
        float fM2035getXimpl3 = Offset.m2035getXimpl(jMo3626localToWindowMKHz9U4);
        float fM2035getXimpl4 = Offset.m2035getXimpl(jMo3626localToWindowMKHz9U3);
        float fMin = Math.min(fM2035getXimpl, Math.min(fM2035getXimpl2, Math.min(fM2035getXimpl3, fM2035getXimpl4)));
        float fMax = Math.max(fM2035getXimpl, Math.max(fM2035getXimpl2, Math.max(fM2035getXimpl3, fM2035getXimpl4)));
        float fM2036getYimpl = Offset.m2036getYimpl(jMo3626localToWindowMKHz9U);
        float fM2036getYimpl2 = Offset.m2036getYimpl(jMo3626localToWindowMKHz9U2);
        float fM2036getYimpl3 = Offset.m2036getYimpl(jMo3626localToWindowMKHz9U4);
        float fM2036getYimpl4 = Offset.m2036getYimpl(jMo3626localToWindowMKHz9U3);
        return new Rect(fMin, Math.min(fM2036getYimpl, Math.min(fM2036getYimpl2, Math.min(fM2036getYimpl3, fM2036getYimpl4))), fMax, Math.max(fM2036getYimpl, Math.max(fM2036getYimpl2, Math.max(fM2036getYimpl3, fM2036getYimpl4))));
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo3622localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m2051getZeroF1C5BW0()) : Offset.INSTANCE.m2051getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m4907getWidthimpl(layoutCoordinates.mo3621getSizeYbymL2g()), IntSize.m4906getHeightimpl(layoutCoordinates.mo3621getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy = nodeCoordinator.getWrappedBy();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator != null) {
                wrappedBy = nodeCoordinator.getWrappedBy();
            } else {
                return nodeCoordinator3;
            }
        }
    }
}
