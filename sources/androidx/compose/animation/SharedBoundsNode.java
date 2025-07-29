package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SharedContentNode.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\u0016H\u0002J&\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\f\u00106\u001a\u00020)*\u000207H\u0016J&\u00108\u001a\u00020.*\u0002092\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u0014\u0010<\u001a\u00020.*\u0002092\u0006\u0010=\u001a\u00020>H\u0002J\f\u0010?\u001a\u00020)*\u00020\u0016H\u0002R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "state", "Landroidx/compose/animation/SharedElementInternalState;", "(Landroidx/compose/animation/SharedElementInternalState;)V", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "value", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "rootCoords", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getRootCoords", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "rootLookaheadCoords", "getRootLookaheadCoords", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "getState", "()Landroidx/compose/animation/SharedElementInternalState;", "setState$animation_release", "isMeasurementApproachInProgress", "", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "onDetach", "onReset", "requireLookaheadLayoutCoordinates", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measure", "Landroidx/compose/ui/layout/MeasureScope;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "place", "placeable", "Landroidx/compose/ui/layout/Placeable;", "updateCurrentBounds", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private SharedElementInternalState state;

    public SharedBoundsNode(SharedElementInternalState sharedElementInternalState) {
        this.state = sharedElementInternalState;
        this.layer = sharedElementInternalState.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementInternalState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getRootLookaheadCoords() {
        return getSharedElement().getScope().getLookaheadRoot$animation_release();
    }

    public final SharedElementInternalState getState() {
        return this.state;
    }

    public final void setState$animation_release(SharedElementInternalState sharedElementInternalState) {
        if (Intrinsics.areEqual(sharedElementInternalState, this.state)) {
            return;
        }
        this.state = sharedElementInternalState;
        if (getIsAttached()) {
            provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementInternalState);
            this.state.setParentState((SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
            this.state.setLayer(this.layer);
            this.state.setLookaheadCoords(new Function0<LayoutCoordinates>() { // from class: androidx.compose.animation.SharedBoundsNode$state$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutCoordinates invoke() {
                    return this.this$0.requireLookaheadLayoutCoordinates();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.state.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoundsAnimation getBoundsAnimation() {
        return this.state.getBoundsAnimation();
    }

    private final void setLayer(GraphicsLayer graphicsLayer) {
        if (graphicsLayer == null) {
            GraphicsLayer graphicsLayer2 = this.layer;
            if (graphicsLayer2 != null) {
                DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer2);
            }
        } else {
            this.state.setLayer(graphicsLayer);
        }
        this.layer = graphicsLayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement getSharedElement() {
        return this.state.getSharedElement();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.state);
        this.state.setParentState((SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.state.setLookaheadCoords(new Function0<LayoutCoordinates>() { // from class: androidx.compose.animation.SharedBoundsNode.onAttach.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                return SharedBoundsNode.this.requireLookaheadLayoutCoordinates();
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        setLayer(null);
        this.state.setParentState(null);
        this.state.setLookaheadCoords(new Function0() { // from class: androidx.compose.animation.SharedBoundsNode.onDetach.1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
        }
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode, androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo412measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo3613measureBRTryo0 = measurable.mo3613measureBRTryo0(j);
        final long jSize = SizeKt.Size(placeableMo3613measureBRTryo0.getWidth(), placeableMo3613measureBRTryo0.getHeight());
        return MeasureScope.layout$default(measureScope, placeableMo3613measureBRTryo0.getWidth(), placeableMo3613measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$measure$1
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
                Offset offsetM2024boximpl;
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                if (coordinates != null) {
                    SharedBoundsNode sharedBoundsNode = this;
                    long j2 = jSize;
                    long jMo3622localPositionOfR5De75A = sharedBoundsNode.getRootLookaheadCoords().mo3622localPositionOfR5De75A(coordinates, Offset.INSTANCE.m2051getZeroF1C5BW0());
                    if (sharedBoundsNode.getSharedElement().getCurrentBounds() == null) {
                        sharedBoundsNode.getSharedElement().setCurrentBounds(RectKt.m2075Recttz77jQw(jMo3622localPositionOfR5De75A, j2));
                    }
                    offsetM2024boximpl = Offset.m2024boximpl(jMo3622localPositionOfR5De75A);
                } else {
                    offsetM2024boximpl = null;
                }
                Placeable.PlacementScope.place$default(placementScope, placeableMo3613measureBRTryo0, 0, 0, 0.0f, 4, null);
                if (offsetM2024boximpl != null) {
                    SharedBoundsNode sharedBoundsNode2 = this;
                    sharedBoundsNode2.getSharedElement().m426onLookaheadResultv_w8tDc(sharedBoundsNode2.getState(), jSize, offsetM2024boximpl.getPackedValue());
                }
            }
        }, 4, null);
    }

    private final MeasureResult place(MeasureScope measureScope, final Placeable placeable) {
        long jMo429calculateSizeJyjRU_E = this.state.getPlaceHolderSize().mo429calculateSizeJyjRU_E(requireLookaheadLayoutCoordinates().mo3621getSizeYbymL2g(), IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()));
        return MeasureScope.layout$default(measureScope, IntSize.m4907getWidthimpl(jMo429calculateSizeJyjRU_E), IntSize.m4906getHeightimpl(jMo429calculateSizeJyjRU_E), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.place.1
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
                long jM2070getTopLeftF1C5BW0;
                LayoutCoordinates coordinates;
                if (SharedBoundsNode.this.getSharedElement().getFoundMatch()) {
                    if (SharedBoundsNode.this.getSharedElement().getTargetBounds() != null) {
                        BoundsAnimation boundsAnimation = SharedBoundsNode.this.getBoundsAnimation();
                        Rect currentBounds = SharedBoundsNode.this.getSharedElement().getCurrentBounds();
                        Intrinsics.checkNotNull(currentBounds);
                        Rect targetBounds = SharedBoundsNode.this.getSharedElement().getTargetBounds();
                        Intrinsics.checkNotNull(targetBounds);
                        boundsAnimation.animate(currentBounds, targetBounds);
                    }
                    Rect value = SharedBoundsNode.this.getBoundsAnimation().getValue();
                    LayoutCoordinates coordinates2 = placementScope.getCoordinates();
                    Offset offsetM2024boximpl = coordinates2 != null ? Offset.m2024boximpl(SharedBoundsNode.this.getRootCoords().mo3622localPositionOfR5De75A(coordinates2, Offset.INSTANCE.m2051getZeroF1C5BW0())) : null;
                    if (value != null) {
                        if (SharedBoundsNode.this.getBoundsAnimation().getTarget()) {
                            SharedBoundsNode.this.getSharedElement().setCurrentBounds(value);
                        }
                        jM2070getTopLeftF1C5BW0 = value.m2070getTopLeftF1C5BW0();
                    } else {
                        if (SharedBoundsNode.this.getBoundsAnimation().getTarget() && (coordinates = placementScope.getCoordinates()) != null) {
                            SharedBoundsNode.this.updateCurrentBounds(coordinates);
                        }
                        Rect currentBounds2 = SharedBoundsNode.this.getSharedElement().getCurrentBounds();
                        Intrinsics.checkNotNull(currentBounds2);
                        jM2070getTopLeftF1C5BW0 = currentBounds2.m2070getTopLeftF1C5BW0();
                    }
                    long jM2039minusMKHz9U = offsetM2024boximpl != null ? Offset.m2039minusMKHz9U(jM2070getTopLeftF1C5BW0, offsetM2024boximpl.getPackedValue()) : Offset.INSTANCE.m2051getZeroF1C5BW0();
                    Placeable.PlacementScope.place$default(placementScope, placeable, Math.round(Offset.m2035getXimpl(jM2039minusMKHz9U)), Math.round(Offset.m2036getYimpl(jM2039minusMKHz9U)), 0.0f, 4, null);
                    return;
                }
                LayoutCoordinates coordinates3 = placementScope.getCoordinates();
                if (coordinates3 != null) {
                    SharedBoundsNode.this.updateCurrentBounds(coordinates3);
                }
                Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    public boolean mo425isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        return getSharedElement().getFoundMatch() && this.state.getSharedElement().getScope().isTransitionActive();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    public MeasureResult mo424approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        if (getSharedElement().getFoundMatch()) {
            Rect value = getBoundsAnimation().getValue();
            if (value == null) {
                value = getSharedElement().getCurrentBounds();
            }
            if (value != null) {
                long jM4915roundToIntSizeuvyYCjk = IntSizeKt.m4915roundToIntSizeuvyYCjk(value.m2068getSizeNHjbRc());
                int iM4907getWidthimpl = IntSize.m4907getWidthimpl(jM4915roundToIntSizeuvyYCjk);
                int iM4906getHeightimpl = IntSize.m4906getHeightimpl(jM4915roundToIntSizeuvyYCjk);
                if (iM4907getWidthimpl == Integer.MAX_VALUE || iM4906getHeightimpl == Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + getBoundsAnimation().getValue() + ", current bounds: " + getSharedElement().getCurrentBounds()).toString());
                }
                j = Constraints.INSTANCE.m4700fixedJhjzzOo(RangesKt.coerceAtLeast(iM4907getWidthimpl, 0), RangesKt.coerceAtLeast(iM4906getHeightimpl, 0));
            }
        }
        return place(approachMeasureScope, measurable.mo3613measureBRTryo0(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCurrentBounds(LayoutCoordinates layoutCoordinates) {
        getSharedElement().setCurrentBounds(RectKt.m2075Recttz77jQw(getRootCoords().mo3622localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m2051getZeroF1C5BW0()), SizeKt.Size(IntSize.m4907getWidthimpl(layoutCoordinates.mo3621getSizeYbymL2g()), IntSize.m4906getHeightimpl(layoutCoordinates.mo3621getSizeYbymL2g()))));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        SharedElementInternalState sharedElementInternalState = this.state;
        SharedTransitionScope.OverlayClip overlayClip = sharedElementInternalState.getOverlayClip();
        SharedTransitionScope.SharedContentState userState = this.state.getUserState();
        Rect currentBounds = getSharedElement().getCurrentBounds();
        Intrinsics.checkNotNull(currentBounds);
        sharedElementInternalState.setClipPathInOverlay$animation_release(overlayClip.getClipPath(userState, currentBounds, contentDrawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(this)));
        GraphicsLayer layer = this.state.getLayer();
        if (layer == null) {
            throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + getSharedElement().getKey() + ",target: " + this.state.getBoundsAnimation().getTarget() + ", is attached: " + getIsAttached()).toString());
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m2831recordJVtK1S4$default(contentDrawScope2, layer, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.draw.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                contentDrawScope.drawContent();
            }
        }, 1, null);
        if (this.state.getShouldRenderInPlace()) {
            GraphicsLayerKt.drawLayer(contentDrawScope2, layer);
        }
    }
}
