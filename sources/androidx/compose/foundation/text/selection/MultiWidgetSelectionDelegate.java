package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* compiled from: MultiWidgetSelectionDelegate.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u001d\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\n\u0010*\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010+\u001a\u00020,H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u000b*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_previousLastVisibleOffset", "", "_previousTextLayoutResult", "getSelectableId", "()J", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getCenterYForOffset", "", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "getLineLeft", "getLineRight", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiWidgetSelectionDelegate implements Selectable {
    public static final int $stable = 8;
    private int _previousLastVisibleOffset = -1;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiWidgetSelectionDelegate(long j, Function0<? extends LayoutCoordinates> function0, Function0<TextLayoutResult> function02) {
        this.selectableId = j;
        this.coordinatesCallback = function0;
        this.layoutResultCallback = function02;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    private final synchronized int getLastVisibleOffset(TextLayoutResult textLayoutResult) {
        int lineCount;
        if (this._previousTextLayoutResult != textLayoutResult) {
            if (!textLayoutResult.getDidOverflowHeight() || textLayoutResult.getMultiParagraph().getDidExceedMaxLines()) {
                lineCount = textLayoutResult.getLineCount() - 1;
            } else {
                int iCoerceAtMost = RangesKt.coerceAtMost(textLayoutResult.getLineForVerticalPosition(IntSize.m4906getHeightimpl(textLayoutResult.getSize())), textLayoutResult.getLineCount() - 1);
                while (iCoerceAtMost >= 0 && textLayoutResult.getLineTop(iCoerceAtMost) >= IntSize.m4906getHeightimpl(textLayoutResult.getSize())) {
                    iCoerceAtMost--;
                }
                lineCount = RangesKt.coerceAtLeast(iCoerceAtMost, 0);
            }
            this._previousLastVisibleOffset = textLayoutResult.getLineEnd(lineCount, true);
            this._previousTextLayoutResult = textLayoutResult;
        }
        return this._previousLastVisibleOffset;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public void appendSelectableInfoToBuilder(SelectionLayoutBuilder builder) {
        TextLayoutResult textLayoutResultInvoke;
        long jM2039minusMKHz9U;
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null || (textLayoutResultInvoke = this.layoutResultCallback.invoke()) == null) {
            return;
        }
        long jMo3622localPositionOfR5De75A = builder.getContainerCoordinates().mo3622localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m2051getZeroF1C5BW0());
        long jM2039minusMKHz9U2 = Offset.m2039minusMKHz9U(builder.getCurrentPosition(), jMo3622localPositionOfR5De75A);
        if (OffsetKt.m2056isUnspecifiedk4lQ0M(builder.getPreviousHandlePosition())) {
            jM2039minusMKHz9U = Offset.INSTANCE.m2050getUnspecifiedF1C5BW0();
        } else {
            jM2039minusMKHz9U = Offset.m2039minusMKHz9U(builder.getPreviousHandlePosition(), jMo3622localPositionOfR5De75A);
        }
        MultiWidgetSelectionDelegateKt.m1651appendSelectableInfoParwq6A(builder, textLayoutResultInvoke, jM2039minusMKHz9U2, jM2039minusMKHz9U, getSelectableId());
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Selection getSelectAllSelection() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return null;
        }
        int length = textLayoutResultInvoke.getLayoutInput().getText().length();
        return new Selection(new Selection.AnchorInfo(textLayoutResultInvoke.getBidiRunDirection(0), 0, getSelectableId()), new Selection.AnchorInfo(textLayoutResultInvoke.getBidiRunDirection(Math.max(length - 1, 0)), length, getSelectableId()), false);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public long mo1649getHandlePositiondBAh8RU(Selection selection, boolean isStartHandle) {
        TextLayoutResult textLayoutResultInvoke;
        if ((isStartHandle && selection.getStart().getSelectableId() != getSelectableId()) || (!isStartHandle && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.INSTANCE.m2050getUnspecifiedF1C5BW0();
        }
        if (getLayoutCoordinates() != null && (textLayoutResultInvoke = this.layoutResultCallback.invoke()) != null) {
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResultInvoke, RangesKt.coerceIn((isStartHandle ? selection.getStart() : selection.getEnd()).getOffset(), 0, getLastVisibleOffset(textLayoutResultInvoke)), isStartHandle, selection.getHandlesCrossed());
        }
        return Offset.INSTANCE.m2050getUnspecifiedF1C5BW0();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinatesInvoke = this.coordinatesCallback.invoke();
        if (layoutCoordinatesInvoke == null || !layoutCoordinatesInvoke.isAttached()) {
            return null;
        }
        return layoutCoordinatesInvoke;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public AnnotatedString getText() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        return textLayoutResultInvoke == null ? new AnnotatedString("", null, null, 6, null) : textLayoutResultInvoke.getLayoutInput().getText();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Rect getBoundingBox(int offset) {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return Rect.INSTANCE.getZero();
        }
        int length = textLayoutResultInvoke.getLayoutInput().getText().length();
        if (length < 1) {
            return Rect.INSTANCE.getZero();
        }
        return textLayoutResultInvoke.getBoundingBox(RangesKt.coerceIn(offset, 0, length - 1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineLeft(int offset) {
        int lineForOffset;
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke != null && (lineForOffset = textLayoutResultInvoke.getLineForOffset(offset)) < textLayoutResultInvoke.getLineCount()) {
            return textLayoutResultInvoke.getLineLeft(lineForOffset);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineRight(int offset) {
        int lineForOffset;
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke != null && (lineForOffset = textLayoutResultInvoke.getLineForOffset(offset)) < textLayoutResultInvoke.getLineCount()) {
            return textLayoutResultInvoke.getLineRight(lineForOffset);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getCenterYForOffset(int offset) {
        int lineForOffset;
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null || (lineForOffset = textLayoutResultInvoke.getLineForOffset(offset)) >= textLayoutResultInvoke.getLineCount()) {
            return -1.0f;
        }
        float lineTop = textLayoutResultInvoke.getLineTop(lineForOffset);
        return ((textLayoutResultInvoke.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getRangeOfLineContaining--jx7JFs, reason: not valid java name */
    public long mo1650getRangeOfLineContainingjx7JFs(int offset) {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return TextRange.INSTANCE.m4227getZerod9O1mEE();
        }
        int lastVisibleOffset = getLastVisibleOffset(textLayoutResultInvoke);
        if (lastVisibleOffset < 1) {
            return TextRange.INSTANCE.m4227getZerod9O1mEE();
        }
        int lineForOffset = textLayoutResultInvoke.getLineForOffset(RangesKt.coerceIn(offset, 0, lastVisibleOffset - 1));
        return TextRangeKt.TextRange(textLayoutResultInvoke.getLineStart(lineForOffset), textLayoutResultInvoke.getLineEnd(lineForOffset, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public int getLastVisibleOffset() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return 0;
        }
        return getLastVisibleOffset(textLayoutResultInvoke);
    }
}
