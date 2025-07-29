package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.Device;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TextFieldCoreModifier.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\"\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020-H\u0002JN\u00102\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\f\u00103\u001a\u00020-*\u000204H\u0016J\f\u00105\u001a\u00020-*\u000206H\u0016J\f\u00107\u001a\u00020-*\u000208H\u0002J(\u00109\u001a\u00020-*\u0002082\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u001f0;2\u0006\u0010=\u001a\u00020>H\u0002J&\u0010?\u001a\u00020-*\u0002082\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0014\u0010C\u001a\u00020-*\u0002082\u0006\u0010=\u001a\u00020>H\u0002J&\u0010D\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ&\u0010M\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010LJ&\u0010O\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010LJ6\u0010Q\u001a\u00020-*\u00020R2\u0006\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020VH\u0002ø\u0001\u0000¢\u0006\u0004\bW\u0010XR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", Device.JsonKeys.ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "changeObserverJob", "Lkotlinx/coroutines/Job;", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "previousTextLayoutSize", "", "showCursor", "getShowCursor", "()Z", "textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "calculateOffsetToFollow", "currSelection", "currTextLayoutSize", "calculateOffsetToFollow-72CqOWE", "(JI)I", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "startCursorJob", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawCursor", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawHighlight", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection", "selection", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawText", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "updateScrollState", "Landroidx/compose/ui/unit/Density;", "containerSize", "textLayoutSize", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "updateScrollState-tIlFzwE", "(Landroidx/compose/ui/unit/Density;IIJLandroidx/compose/ui/unit/LayoutDirection;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Job changeObserverJob;
    private Brush cursorBrush;
    private boolean isDragHovered;
    private boolean isFocused;
    private Orientation orientation;
    private TextRange previousSelection;
    private int previousTextLayoutSize;
    private ScrollState scrollState;
    private final TextFieldMagnifierNode textFieldMagnifierNode;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private boolean writeable;
    private final CursorAnimationState cursorAnimation = new CursorAnimationState();
    private Rect previousCursorRect = new Rect(-1.0f, -1.0f, -1.0f, -1.0f);

    public TextFieldCoreModifierNode(boolean z, boolean z2, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z3, ScrollState scrollState, Orientation orientation) {
        this.isFocused = z;
        this.isDragHovered = z2;
        this.textLayoutState = textLayoutState;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = brush;
        this.writeable = z3;
        this.scrollState = scrollState;
        this.orientation = orientation;
        this.textFieldMagnifierNode = (TextFieldMagnifierNode) delegate(AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, this.isFocused || this.isDragHovered));
    }

    private final boolean getShowCursor() {
        return this.writeable && (this.isFocused || this.isDragHovered) && TextFieldCoreModifierKt.isSpecified(this.cursorBrush);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        if (this.isFocused && getShowCursor()) {
            startCursorJob();
        }
    }

    public final void updateNode(boolean isFocused, boolean isDragHovered, TextLayoutState textLayoutState, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation) {
        boolean showCursor = getShowCursor();
        boolean z = this.isFocused;
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        TextLayoutState textLayoutState2 = this.textLayoutState;
        TextFieldSelectionState textFieldSelectionState2 = this.textFieldSelectionState;
        ScrollState scrollState2 = this.scrollState;
        this.isFocused = isFocused;
        this.isDragHovered = isDragHovered;
        this.textLayoutState = textLayoutState;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = cursorBrush;
        this.writeable = writeable;
        this.scrollState = scrollState;
        this.orientation = orientation;
        this.textFieldMagnifierNode.update(textFieldState, textFieldSelectionState, textLayoutState, isFocused || isDragHovered);
        if (!getShowCursor()) {
            Job job = this.changeObserverJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.changeObserverJob = null;
            this.cursorAnimation.cancelAndHide();
        } else if (!z || !Intrinsics.areEqual(transformedTextFieldState, textFieldState) || !showCursor) {
            startCursorJob();
        }
        if (Intrinsics.areEqual(transformedTextFieldState, textFieldState) && Intrinsics.areEqual(textLayoutState2, textLayoutState) && Intrinsics.areEqual(textFieldSelectionState2, textFieldSelectionState) && Intrinsics.areEqual(scrollState2, scrollState)) {
            return;
        }
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo412measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        if (this.orientation == Orientation.Vertical) {
            return m1519measureVerticalScroll3p2s80s(measureScope, measurable, j);
        }
        return m1518measureHorizontalScroll3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return;
        }
        Pair<TextHighlightType, TextRange> highlight = visualText.getHighlight();
        if (highlight != null) {
            drawHighlight(contentDrawScope, highlight, layoutResult);
        }
        if (TextRange.m4216getCollapsedimpl(visualText.getSelection())) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            drawText(contentDrawScope2, layoutResult);
            if (visualText.shouldShowSelection()) {
                drawCursor(contentDrawScope2);
            }
        } else {
            if (visualText.shouldShowSelection()) {
                m1517drawSelectionSbBc2M(contentDrawScope, visualText.getSelection(), layoutResult);
            }
            drawText(contentDrawScope, layoutResult);
        }
        this.textFieldMagnifierNode.draw(contentDrawScope);
    }

    /* renamed from: measureVerticalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1519measureVerticalScroll3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo3613measureBRTryo0 = measurable.mo3613measureBRTryo0(Constraints.m4681copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 7, null));
        final int iMin = Math.min(placeableMo3613measureBRTryo0.getHeight(), Constraints.m4689getMaxHeightimpl(j));
        return MeasureScope.layout$default(measureScope, placeableMo3613measureBRTryo0.getWidth(), iMin, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$measureVerticalScroll$1
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
                this.this$0.m1520updateScrollStatetIlFzwE(measureScope, iMin, placeableMo3613measureBRTryo0.getHeight(), this.this$0.textFieldState.getVisualText().getSelection(), measureScope.getLayoutDirection());
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo3613measureBRTryo0, 0, -this.this$0.scrollState.getValue(), 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* renamed from: measureHorizontalScroll-3p2s80s, reason: not valid java name */
    private final MeasureResult m1518measureHorizontalScroll3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo3613measureBRTryo0 = measurable.mo3613measureBRTryo0(Constraints.m4681copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        final int iMin = Math.min(placeableMo3613measureBRTryo0.getWidth(), Constraints.m4690getMaxWidthimpl(j));
        return MeasureScope.layout$default(measureScope, iMin, placeableMo3613measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$measureHorizontalScroll$1
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
                this.this$0.m1520updateScrollStatetIlFzwE(measureScope, iMin, placeableMo3613measureBRTryo0.getWidth(), this.this$0.textFieldState.getVisualText().getSelection(), measureScope.getLayoutDirection());
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo3613measureBRTryo0, -this.this$0.scrollState.getValue(), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* renamed from: calculateOffsetToFollow-72CqOWE, reason: not valid java name */
    private final int m1516calculateOffsetToFollow72CqOWE(long currSelection, int currTextLayoutSize) {
        TextRange textRange = this.previousSelection;
        if (textRange == null || TextRange.m4217getEndimpl(currSelection) != TextRange.m4217getEndimpl(textRange.getPackedValue())) {
            return TextRange.m4217getEndimpl(currSelection);
        }
        TextRange textRange2 = this.previousSelection;
        if (textRange2 == null || TextRange.m4222getStartimpl(currSelection) != TextRange.m4222getStartimpl(textRange2.getPackedValue())) {
            return TextRange.m4222getStartimpl(currSelection);
        }
        if (currTextLayoutSize != this.previousTextLayoutSize) {
            return TextRange.m4222getStartimpl(currSelection);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* renamed from: updateScrollState-tIlFzwE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1520updateScrollStatetIlFzwE(androidx.compose.ui.unit.Density r9, int r10, int r11, long r12, androidx.compose.ui.unit.LayoutDirection r14) {
        /*
            r8 = this;
            int r0 = r11 - r10
            androidx.compose.foundation.ScrollState r1 = r8.scrollState
            r1.setMaxValue$foundation_release(r0)
            int r0 = r8.m1516calculateOffsetToFollow72CqOWE(r12, r11)
            if (r0 < 0) goto Lca
            boolean r1 = r8.getShowCursor()
            if (r1 != 0) goto L15
            goto Lca
        L15:
            androidx.compose.foundation.text.input.internal.TextLayoutState r1 = r8.textLayoutState
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getLayoutResult()
            if (r1 != 0) goto L1e
            return
        L1e:
            kotlin.ranges.IntRange r2 = new kotlin.ranges.IntRange
            androidx.compose.ui.text.TextLayoutInput r3 = r1.getLayoutInput()
            androidx.compose.ui.text.AnnotatedString r3 = r3.getText()
            int r3 = r3.length()
            r4 = 0
            r2.<init>(r4, r3)
            kotlin.ranges.ClosedRange r2 = (kotlin.ranges.ClosedRange) r2
            int r0 = kotlin.ranges.RangesKt.coerceIn(r0, r2)
            androidx.compose.ui.geometry.Rect r0 = r1.getCursorRect(r0)
            androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r2 = 1
            if (r14 != r1) goto L41
            r14 = r2
            goto L42
        L41:
            r14 = r4
        L42:
            androidx.compose.ui.geometry.Rect r9 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierKt.access$getCursorRectInScroller(r9, r0, r14, r11)
            float r14 = r9.getLeft()
            androidx.compose.ui.geometry.Rect r1 = r8.previousCursorRect
            float r1 = r1.getLeft()
            int r14 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r14 != 0) goto L66
            float r14 = r9.getTop()
            androidx.compose.ui.geometry.Rect r1 = r8.previousCursorRect
            float r1 = r1.getTop()
            int r14 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r14 != 0) goto L66
            int r14 = r8.previousTextLayoutSize
            if (r11 == r14) goto Lca
        L66:
            androidx.compose.foundation.gestures.Orientation r14 = r8.orientation
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r14 != r1) goto L6d
            r4 = r2
        L6d:
            if (r4 == 0) goto L74
            float r14 = r9.getTop()
            goto L78
        L74:
            float r14 = r9.getLeft()
        L78:
            if (r4 == 0) goto L7f
            float r1 = r9.getBottom()
            goto L83
        L7f:
            float r1 = r9.getRight()
        L83:
            androidx.compose.foundation.ScrollState r2 = r8.scrollState
            int r2 = r2.getValue()
            int r3 = r2 + r10
            float r3 = (float) r3
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 <= 0) goto L92
        L90:
            float r1 = r1 - r3
            goto Lab
        L92:
            float r2 = (float) r2
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 >= 0) goto L9f
            float r5 = r1 - r14
            float r6 = (float) r10
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L9f
            goto L90
        L9f:
            if (r4 >= 0) goto Laa
            float r1 = r1 - r14
            float r10 = (float) r10
            int r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r10 > 0) goto Laa
            float r1 = r14 - r2
            goto Lab
        Laa:
            r1 = 0
        Lab:
            androidx.compose.ui.text.TextRange r10 = androidx.compose.ui.text.TextRange.m4210boximpl(r12)
            r8.previousSelection = r10
            r8.previousCursorRect = r9
            r8.previousTextLayoutSize = r11
            kotlinx.coroutines.CoroutineScope r2 = r8.getCoroutineScope()
            kotlinx.coroutines.CoroutineStart r4 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1 r9 = new androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1
            r10 = 0
            r9.<init>(r8, r1, r0, r10)
            r5 = r9
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 1
            r7 = 0
            r3 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.m1520updateScrollStatetIlFzwE(androidx.compose.ui.unit.Density, int, int, long, androidx.compose.ui.unit.LayoutDirection):void");
    }

    /* renamed from: drawSelection-Sb-Bc2M, reason: not valid java name */
    private final void m1517drawSelectionSbBc2M(DrawScope drawScope, long j, TextLayoutResult textLayoutResult) {
        int iM4220getMinimpl = TextRange.m4220getMinimpl(j);
        int iM4219getMaximpl = TextRange.m4219getMaximpl(j);
        if (iM4220getMinimpl != iM4219getMaximpl) {
            DrawScope.m2823drawPathLG529CI$default(drawScope, textLayoutResult.getPathForRange(iM4220getMinimpl, iM4219getMaximpl), ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor(), 0.0f, null, null, 0, 60, null);
        }
    }

    private final void drawHighlight(DrawScope drawScope, Pair<TextHighlightType, TextRange> pair, TextLayoutResult textLayoutResult) {
        int value = pair.component1().getValue();
        long packedValue = pair.component2().getPackedValue();
        if (TextRange.m4216getCollapsedimpl(packedValue)) {
            return;
        }
        Path pathForRange = textLayoutResult.getPathForRange(TextRange.m4220getMinimpl(packedValue), TextRange.m4219getMaximpl(packedValue));
        if (TextHighlightType.m1437equalsimpl0(value, TextHighlightType.INSTANCE.m1441getHandwritingDeletePreviewsxJuwY())) {
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush != null) {
                DrawScope.m2822drawPathGBMwjPU$default(drawScope, pathForRange, brush, 0.2f, null, null, 0, 56, null);
                return;
            }
            long jM4252getColor0d7_KjU = textLayoutResult.getLayoutInput().getStyle().m4252getColor0d7_KjU();
            if (jM4252getColor0d7_KjU == 16) {
                jM4252getColor0d7_KjU = Color.INSTANCE.m2302getBlack0d7_KjU();
            }
            long j = jM4252getColor0d7_KjU;
            DrawScope.m2823drawPathLG529CI$default(drawScope, pathForRange, Color.m2275copywmQWz5c$default(j, Color.m2278getAlphaimpl(j) * 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, null, null, 0, 60, null);
            return;
        }
        DrawScope.m2823drawPathLG529CI$default(drawScope, pathForRange, ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor(), 0.0f, null, null, 0, 60, null);
    }

    private final void drawCursor(DrawScope drawScope) {
        float cursorAlpha = this.cursorAnimation.getCursorAlpha();
        if (cursorAlpha != 0.0f && getShowCursor()) {
            Rect cursorRect = this.textFieldSelectionState.getCursorRect();
            DrawScope.m2818drawLine1RTmtNc$default(drawScope, this.cursorBrush, cursorRect.m2069getTopCenterF1C5BW0(), cursorRect.m2062getBottomCenterF1C5BW0(), cursorRect.getWidth(), 0, null, cursorAlpha, null, 0, 432, null);
        }
    }

    /* compiled from: TextFieldCoreModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1", f = "TextFieldCoreModifier.kt", i = {}, l = {563}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFieldCoreModifierNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 1;
                final TextFieldCoreModifierNode textFieldCoreModifierNode = TextFieldCoreModifierNode.this;
                this.label = 1;
                if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0<Integer>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.startCursorJob.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        textFieldCoreModifierNode.textFieldState.getVisualText();
                        Integer numValueOf = Integer.valueOf(((textFieldCoreModifierNode.getIsAttached() && ((WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldCoreModifierNode, CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused()) ? 1 : 2) * intRef.element);
                        Ref.IntRef intRef2 = intRef;
                        numValueOf.intValue();
                        intRef2.element *= -1;
                        return numValueOf;
                    }
                }), new AnonymousClass2(TextFieldCoreModifierNode.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: TextFieldCoreModifier.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "isWindowFocused", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2", f = "TextFieldCoreModifier.kt", i = {}, l = {565}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$startCursorJob$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ TextFieldCoreModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldCoreModifierNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.I$0 = ((Number) obj).intValue();
                return anonymousClass2;
            }

            public final Object invoke(int i, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
                return invoke(num.intValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Math.abs(this.I$0) == 1) {
                        this.label = 1;
                        if (this.this$0.cursorAnimation.snapToVisibleAndAnimate(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void startCursorJob() {
        this.changeObserverJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setCoreNodeCoordinates(coordinates);
        this.textFieldMagnifierNode.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.textFieldMagnifierNode.applySemantics(semanticsPropertyReceiver);
    }

    private final void drawText(DrawScope drawScope, TextLayoutResult textLayoutResult) {
        TextPainter.INSTANCE.paint(drawScope.getDrawContext().getCanvas(), textLayoutResult);
    }
}
