package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: SharedTransitionScope.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ&\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!R7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R/\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "scaleToBounds$delegate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {

    /* renamed from: isEnabled$delegate, reason: from kotlin metadata */
    private final MutableState isEnabled;
    private Constraints lookaheadConstraints;

    /* renamed from: scaleToBounds$delegate, reason: from kotlin metadata */
    private final MutableState scaleToBounds;

    public SkipToLookaheadNode(ScaleToBoundsImpl scaleToBoundsImpl, Function0<Boolean> function0) {
        this.scaleToBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(scaleToBoundsImpl, null, 2, null);
        this.isEnabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function0, null, 2, null);
    }

    /* renamed from: getLookaheadConstraints-DWUhwKw, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    /* renamed from: setLookaheadConstraints-_Sx5XlM, reason: not valid java name */
    public final void m446setLookaheadConstraints_Sx5XlM(Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ScaleToBoundsImpl getScaleToBounds() {
        return (ScaleToBoundsImpl) this.scaleToBounds.getValue();
    }

    public final void setScaleToBounds(ScaleToBoundsImpl scaleToBoundsImpl) {
        this.scaleToBounds.setValue(scaleToBoundsImpl);
    }

    public final Function0<Boolean> isEnabled() {
        return (Function0) this.isEnabled.getValue();
    }

    public final void setEnabled(Function0<Boolean> function0) {
        this.isEnabled.setValue(function0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo412measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        if (measureScope.isLookingAhead()) {
            this.lookaheadConstraints = Constraints.m4678boximpl(j);
        }
        Constraints constraints = this.lookaheadConstraints;
        Intrinsics.checkNotNull(constraints);
        final Placeable placeableMo3613measureBRTryo0 = measurable.mo3613measureBRTryo0(constraints.getValue());
        final long jIntSize = IntSizeKt.IntSize(placeableMo3613measureBRTryo0.getWidth(), placeableMo3613measureBRTryo0.getHeight());
        final long jM4704constrain4WqzIAM = ConstraintsKt.m4704constrain4WqzIAM(j, jIntSize);
        return MeasureScope.layout$default(measureScope, IntSize.m4907getWidthimpl(jM4704constrain4WqzIAM), IntSize.m4906getHeightimpl(jM4704constrain4WqzIAM), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1
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
                final long jScaleFactor;
                ScaleToBoundsImpl scaleToBounds = this.this$0.getScaleToBounds();
                if (!this.this$0.isEnabled().invoke().booleanValue() || scaleToBounds == null) {
                    Placeable.PlacementScope.place$default(placementScope, placeableMo3613measureBRTryo0, 0, 0, 0.0f, 4, null);
                    return;
                }
                ContentScale contentScale = scaleToBounds.getContentScale();
                if (IntSize.m4907getWidthimpl(jIntSize) == 0 || IntSize.m4906getHeightimpl(jIntSize) == 0) {
                    jScaleFactor = ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
                } else {
                    jScaleFactor = contentScale.mo3604computeScaleFactorH7hwNQA(IntSizeKt.m4919toSizeozmzZPI(jIntSize), IntSizeKt.m4919toSizeozmzZPI(jM4704constrain4WqzIAM));
                }
                long jMo1881alignKFBX0sM = scaleToBounds.getAlignment().mo1881alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(IntSize.m4907getWidthimpl(jIntSize) * ScaleFactor.m3702getScaleXimpl(jScaleFactor)), MathKt.roundToInt(IntSize.m4906getHeightimpl(jIntSize) * ScaleFactor.m3703getScaleYimpl(jScaleFactor))), jM4704constrain4WqzIAM, measureScope.getLayoutDirection());
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo3613measureBRTryo0, IntOffset.m4865getXimpl(jMo1881alignKFBX0sM), IntOffset.m4866getYimpl(jMo1881alignKFBX0sM), 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setScaleX(ScaleFactor.m3702getScaleXimpl(jScaleFactor));
                        graphicsLayerScope.setScaleY(ScaleFactor.m3703getScaleYimpl(jScaleFactor));
                        graphicsLayerScope.mo2470setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
                    }
                }, 4, (Object) null);
            }
        }, 4, null);
    }
}
