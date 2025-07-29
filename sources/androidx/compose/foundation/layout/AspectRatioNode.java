package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AspectRatio.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", ViewProps.ASPECT_RATIO, "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo412measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jM899findSizeToXhtMw = m899findSizeToXhtMw(j);
        if (!IntSize.m4905equalsimpl0(jM899findSizeToXhtMw, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m4700fixedJhjzzOo(IntSize.m4907getWidthimpl(jM899findSizeToXhtMw), IntSize.m4906getHeightimpl(jM899findSizeToXhtMw));
        }
        final Placeable placeableMo3613measureBRTryo0 = measurable.mo3613measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo3613measureBRTryo0.getWidth(), placeableMo3613measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo3613measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m899findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long jM903tryMaxWidthJN0ABg$default = m903tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM903tryMaxWidthJN0ABg$default, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM903tryMaxWidthJN0ABg$default;
            }
            long jM901tryMaxHeightJN0ABg$default = m901tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM901tryMaxHeightJN0ABg$default, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM901tryMaxHeightJN0ABg$default;
            }
            long jM907tryMinWidthJN0ABg$default = m907tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM907tryMinWidthJN0ABg$default, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM907tryMinWidthJN0ABg$default;
            }
            long jM905tryMinHeightJN0ABg$default = m905tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM905tryMinHeightJN0ABg$default, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM905tryMinHeightJN0ABg$default;
            }
            long jM902tryMaxWidthJN0ABg = m902tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM902tryMaxWidthJN0ABg, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM902tryMaxWidthJN0ABg;
            }
            long jM900tryMaxHeightJN0ABg = m900tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM900tryMaxHeightJN0ABg, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM900tryMaxHeightJN0ABg;
            }
            long jM906tryMinWidthJN0ABg = m906tryMinWidthJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM906tryMinWidthJN0ABg, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM906tryMinWidthJN0ABg;
            }
            long jM904tryMinHeightJN0ABg = m904tryMinHeightJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM904tryMinHeightJN0ABg, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM904tryMinHeightJN0ABg;
            }
        } else {
            long jM901tryMaxHeightJN0ABg$default2 = m901tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM901tryMaxHeightJN0ABg$default2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM901tryMaxHeightJN0ABg$default2;
            }
            long jM903tryMaxWidthJN0ABg$default2 = m903tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM903tryMaxWidthJN0ABg$default2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM903tryMaxWidthJN0ABg$default2;
            }
            long jM905tryMinHeightJN0ABg$default2 = m905tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM905tryMinHeightJN0ABg$default2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM905tryMinHeightJN0ABg$default2;
            }
            long jM907tryMinWidthJN0ABg$default2 = m907tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4905equalsimpl0(jM907tryMinWidthJN0ABg$default2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM907tryMinWidthJN0ABg$default2;
            }
            long jM900tryMaxHeightJN0ABg2 = m900tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM900tryMaxHeightJN0ABg2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM900tryMaxHeightJN0ABg2;
            }
            long jM902tryMaxWidthJN0ABg2 = m902tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM902tryMaxWidthJN0ABg2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM902tryMaxWidthJN0ABg2;
            }
            long jM904tryMinHeightJN0ABg2 = m904tryMinHeightJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM904tryMinHeightJN0ABg2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM904tryMinHeightJN0ABg2;
            }
            long jM906tryMinWidthJN0ABg2 = m906tryMinWidthJN0ABg(j, false);
            if (!IntSize.m4905equalsimpl0(jM906tryMinWidthJN0ABg2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                return jM906tryMinWidthJN0ABg2;
            }
        }
        return IntSize.INSTANCE.m4912getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m903tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m902tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m902tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM4690getMaxWidthimpl = Constraints.m4690getMaxWidthimpl(j);
        if (iM4690getMaxWidthimpl != Integer.MAX_VALUE && (iRound = Math.round(iM4690getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM4690getMaxWidthimpl, iRound);
            if (!z || ConstraintsKt.m4708isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4912getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m901tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m900tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m900tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM4689getMaxHeightimpl = Constraints.m4689getMaxHeightimpl(j);
        if (iM4689getMaxHeightimpl != Integer.MAX_VALUE && (iRound = Math.round(iM4689getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM4689getMaxHeightimpl);
            if (!z || ConstraintsKt.m4708isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4912getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m907tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m906tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m906tryMinWidthJN0ABg(long j, boolean z) {
        int iM4692getMinWidthimpl = Constraints.m4692getMinWidthimpl(j);
        int iRound = Math.round(iM4692getMinWidthimpl / this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iM4692getMinWidthimpl, iRound);
            if (!z || ConstraintsKt.m4708isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4912getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m905tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m904tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m904tryMinHeightJN0ABg(long j, boolean z) {
        int iM4691getMinHeightimpl = Constraints.m4691getMinHeightimpl(j);
        int iRound = Math.round(iM4691getMinHeightimpl * this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM4691getMinHeightimpl);
            if (!z || ConstraintsKt.m4708isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4912getZeroYbymL2g();
    }
}
