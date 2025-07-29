package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: StylusHandwriting.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J&\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "sharePointerInputWithSiblings", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StylusHandwritingNodeWithNegativePadding extends StylusHandwritingNode implements LayoutModifierNode {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public boolean sharePointerInputWithSiblings() {
        return true;
    }

    public StylusHandwritingNodeWithNegativePadding(Function0<Boolean> function0) {
        super(function0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo412measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final int i = measureScope.mo688roundToPx0680j_4(StylusHandwritingKt.getHandwritingBoundsVerticalOffset());
        final int i2 = measureScope.mo688roundToPx0680j_4(StylusHandwritingKt.getHandwritingBoundsHorizontalOffset());
        int i3 = i2 * 2;
        int i4 = i * 2;
        final Placeable placeableMo3613measureBRTryo0 = measurable.mo3613measureBRTryo0(ConstraintsKt.m4709offsetNN6EwU(j, i3, i4));
        return MeasureScope.layout$default(measureScope, placeableMo3613measureBRTryo0.getWidth() - i3, placeableMo3613measureBRTryo0.getHeight() - i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.handwriting.StylusHandwritingNodeWithNegativePadding$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo3613measureBRTryo0, -i2, -i, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
