package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(Direction direction, float f) {
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo412measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM4692getMinWidthimpl;
        int iM4690getMaxWidthimpl;
        int iM4689getMaxHeightimpl;
        int iCoerceIn;
        if (Constraints.m4686getHasBoundedWidthimpl(j) && this.direction != Direction.Vertical) {
            iM4692getMinWidthimpl = RangesKt.coerceIn(Math.round(Constraints.m4690getMaxWidthimpl(j) * this.fraction), Constraints.m4692getMinWidthimpl(j), Constraints.m4690getMaxWidthimpl(j));
            iM4690getMaxWidthimpl = iM4692getMinWidthimpl;
        } else {
            iM4692getMinWidthimpl = Constraints.m4692getMinWidthimpl(j);
            iM4690getMaxWidthimpl = Constraints.m4690getMaxWidthimpl(j);
        }
        if (Constraints.m4685getHasBoundedHeightimpl(j) && this.direction != Direction.Horizontal) {
            iCoerceIn = RangesKt.coerceIn(Math.round(Constraints.m4689getMaxHeightimpl(j) * this.fraction), Constraints.m4691getMinHeightimpl(j), Constraints.m4689getMaxHeightimpl(j));
            iM4689getMaxHeightimpl = iCoerceIn;
        } else {
            int iM4691getMinHeightimpl = Constraints.m4691getMinHeightimpl(j);
            iM4689getMaxHeightimpl = Constraints.m4689getMaxHeightimpl(j);
            iCoerceIn = iM4691getMinHeightimpl;
        }
        final Placeable placeableMo3613measureBRTryo0 = measurable.mo3613measureBRTryo0(ConstraintsKt.Constraints(iM4692getMinWidthimpl, iM4690getMaxWidthimpl, iCoerceIn, iM4689getMaxHeightimpl));
        return MeasureScope.layout$default(measureScope, placeableMo3613measureBRTryo0.getWidth(), placeableMo3613measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
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
}
