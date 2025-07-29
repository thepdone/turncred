package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: CursorAnchorInfoBuilder.android.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001ax\u0010\t\u001a\u00020\n*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", "", "endOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "build", "Landroid/view/inputmethod/CursorAnchorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CursorAnchorInfoBuilder_androidKt {
    /* renamed from: build-vxqZcH0, reason: not valid java name */
    public static final CursorAnchorInfo m1460buildvxqZcH0(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4) {
        builder.reset();
        builder.setMatrix(matrix);
        int iM4220getMinimpl = TextRange.m4220getMinimpl(j);
        builder.setSelectionRange(iM4220getMinimpl, TextRange.m4219getMaximpl(j));
        if (z) {
            setInsertionMarker(builder, iM4220getMinimpl, textLayoutResult, rect);
        }
        if (z2) {
            int iM4220getMinimpl2 = textRange != null ? TextRange.m4220getMinimpl(textRange.getPackedValue()) : -1;
            int iM4219getMaximpl = textRange != null ? TextRange.m4219getMaximpl(textRange.getPackedValue()) : -1;
            if (iM4220getMinimpl2 >= 0 && iM4220getMinimpl2 < iM4219getMaximpl) {
                builder.setComposingText(iM4220getMinimpl2, charSequence.subSequence(iM4220getMinimpl2, iM4219getMaximpl));
                addCharacterBounds(builder, iM4220getMinimpl2, iM4219getMaximpl, textLayoutResult, rect);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && z3) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (Build.VERSION.SDK_INT >= 34 && z4) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        float fCoerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, IntSize.m4907getWidthimpl(textLayoutResult.getSize()));
        boolean zContainsInclusive = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, fCoerceIn, cursorRect.getTop());
        boolean zContainsInclusive2 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, fCoerceIn, cursorRect.getBottom());
        int i2 = 1;
        boolean z = textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl;
        if (!zContainsInclusive && !zContainsInclusive2) {
            i2 = 0;
        }
        if (!zContainsInclusive || !zContainsInclusive2) {
            i2 |= 2;
        }
        builder.setInsertionMarkerLocation(fCoerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), z ? i2 | 4 : i2);
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final android.view.inputmethod.CursorAnchorInfo.Builder addCharacterBounds(android.view.inputmethod.CursorAnchorInfo.Builder r14, int r15, int r16, androidx.compose.ui.text.TextLayoutResult r17, androidx.compose.ui.geometry.Rect r18) {
        /*
            r0 = r16
            r1 = r18
            int r2 = r0 - r15
            int r2 = r2 * 4
            float[] r2 = new float[r2]
            androidx.compose.ui.text.MultiParagraph r3 = r17.getMultiParagraph()
            long r4 = androidx.compose.ui.text.TextRangeKt.TextRange(r15, r16)
            r6 = 0
            r3.m4087fillBoundingBoxes8ffj60Q(r4, r2, r6)
            r3 = r15
        L17:
            if (r3 >= r0) goto L77
            int r4 = r3 - r15
            int r4 = r4 * 4
            androidx.compose.ui.geometry.Rect r5 = new androidx.compose.ui.geometry.Rect
            r6 = r2[r4]
            int r7 = r4 + 1
            r7 = r2[r7]
            int r8 = r4 + 2
            r8 = r2[r8]
            int r4 = r4 + 3
            r4 = r2[r4]
            r5.<init>(r6, r7, r8, r4)
            boolean r4 = r1.overlaps(r5)
            float r6 = r5.getLeft()
            float r7 = r5.getTop()
            boolean r6 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r1, r6, r7)
            if (r6 == 0) goto L50
            float r6 = r5.getRight()
            float r7 = r5.getBottom()
            boolean r6 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r1, r6, r7)
            if (r6 != 0) goto L52
        L50:
            r4 = r4 | 2
        L52:
            r6 = r17
            androidx.compose.ui.text.style.ResolvedTextDirection r7 = r6.getBidiRunDirection(r3)
            androidx.compose.ui.text.style.ResolvedTextDirection r8 = androidx.compose.ui.text.style.ResolvedTextDirection.Rtl
            if (r7 != r8) goto L5e
            r4 = r4 | 4
        L5e:
            r13 = r4
            float r9 = r5.getLeft()
            float r10 = r5.getTop()
            float r11 = r5.getRight()
            float r12 = r5.getBottom()
            r7 = r14
            r8 = r3
            r7.addCharacterBounds(r8, r9, r10, r11, r12, r13)
            int r3 = r3 + 1
            goto L17
        L77:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnchorInfoBuilder_androidKt.addCharacterBounds(android.view.inputmethod.CursorAnchorInfo$Builder, int, int, androidx.compose.ui.text.TextLayoutResult, androidx.compose.ui.geometry.Rect):android.view.inputmethod.CursorAnchorInfo$Builder");
    }
}
