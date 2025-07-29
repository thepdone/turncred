package androidx.compose.ui.text.android.animation;

import android.text.Layout;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.LayoutCompat_androidKt;
import androidx.compose.ui.text.android.LayoutHelper;
import java.text.Bidi;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;

/* compiled from: SegmentBreaker.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/android/animation/SegmentBreaker;", "", "()V", "breakInWords", "", "", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "breakOffsets", "segmentType", "Landroidx/compose/ui/text/android/animation/SegmentType;", "breakSegmentWithChar", "Landroidx/compose/ui/text/android/animation/Segment;", "dropSpaces", "", "breakSegmentWithDocument", "breakSegmentWithLine", "breakSegmentWithParagraph", "breakSegmentWithWord", "breakSegments", "breakWithBreakIterator", "text", "", "breaker", "Ljava/text/BreakIterator;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SegmentBreaker {
    public static final int $stable = 0;
    public static final SegmentBreaker INSTANCE = new SegmentBreaker();

    /* compiled from: SegmentBreaker.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SegmentType.values().length];
            try {
                iArr[SegmentType.Document.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SegmentType.Paragraph.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SegmentType.Line.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SegmentType.Word.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SegmentType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SegmentBreaker() {
    }

    private final List<Integer> breakInWords(LayoutHelper layoutHelper) {
        List<Integer> listBreakWithBreakIterator = breakWithBreakIterator(layoutHelper.getLayout().getText(), BreakIterator.getLineInstance(Locale.getDefault()));
        TreeSet treeSet = new TreeSet();
        int size = listBreakWithBreakIterator.size();
        for (int i = 0; i < size; i++) {
            treeSet.add(Integer.valueOf(listBreakWithBreakIterator.get(i).intValue()));
        }
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i2 = 0; i2 < paragraphCount; i2++) {
            Bidi bidiAnalyzeBidi = layoutHelper.analyzeBidi(i2);
            if (bidiAnalyzeBidi != null) {
                int paragraphStart = layoutHelper.getParagraphStart(i2);
                int runCount = bidiAnalyzeBidi.getRunCount();
                for (int i3 = 0; i3 < runCount; i3++) {
                    treeSet.add(Integer.valueOf(bidiAnalyzeBidi.getRunStart(i3) + paragraphStart));
                }
            }
        }
        return CollectionsKt.toList(treeSet);
    }

    private final List<Integer> breakWithBreakIterator(CharSequence text, BreakIterator breaker) {
        CharSequenceCharacterIterator charSequenceCharacterIterator = new CharSequenceCharacterIterator(text, 0, text.length());
        List<Integer> listMutableListOf = CollectionsKt.mutableListOf(0);
        breaker.setText(charSequenceCharacterIterator);
        while (breaker.next() != -1) {
            listMutableListOf.add(Integer.valueOf(breaker.current()));
        }
        return listMutableListOf;
    }

    public final List<Integer> breakOffsets(LayoutHelper layoutHelper, SegmentType segmentType) {
        Layout layout = layoutHelper.getLayout();
        CharSequence text = layout.getText();
        int i = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        int i2 = 0;
        if (i == 1) {
            return CollectionsKt.listOf((Object[]) new Integer[]{0, Integer.valueOf(text.length())});
        }
        if (i == 2) {
            List<Integer> listMutableListOf = CollectionsKt.mutableListOf(0);
            int paragraphCount = layoutHelper.getParagraphCount();
            while (i2 < paragraphCount) {
                listMutableListOf.add(Integer.valueOf(layoutHelper.getParagraphEnd(i2)));
                i2++;
            }
            return listMutableListOf;
        }
        if (i != 3) {
            if (i == 4) {
                return breakInWords(layoutHelper);
            }
            if (i == 5) {
                return breakWithBreakIterator(text, BreakIterator.getCharacterInstance(Locale.getDefault()));
            }
            throw new NoWhenBranchMatchedException();
        }
        List<Integer> listMutableListOf2 = CollectionsKt.mutableListOf(0);
        int lineCount = layout.getLineCount();
        while (i2 < lineCount) {
            listMutableListOf2.add(Integer.valueOf(layout.getLineEnd(i2)));
            i2++;
        }
        return listMutableListOf2;
    }

    public final List<Segment> breakSegments(LayoutHelper layoutHelper, SegmentType segmentType, boolean dropSpaces) {
        int i = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        if (i == 1) {
            return breakSegmentWithDocument(layoutHelper);
        }
        if (i == 2) {
            return breakSegmentWithParagraph(layoutHelper);
        }
        if (i == 3) {
            return breakSegmentWithLine(layoutHelper, dropSpaces);
        }
        if (i == 4) {
            return breakSegmentWithWord(layoutHelper, dropSpaces);
        }
        if (i == 5) {
            return breakSegmentWithChar(layoutHelper, dropSpaces);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<Segment> breakSegmentWithDocument(LayoutHelper layoutHelper) {
        return CollectionsKt.listOf(new Segment(0, layoutHelper.getLayout().getText().length(), 0, 0, layoutHelper.getLayout().getWidth(), layoutHelper.getLayout().getHeight()));
    }

    private final List<Segment> breakSegmentWithParagraph(LayoutHelper layoutHelper) {
        ArrayList arrayList = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i = 0; i < paragraphCount; i++) {
            int paragraphStart = layoutHelper.getParagraphStart(i);
            int paragraphEnd = layoutHelper.getParagraphEnd(i);
            arrayList.add(new Segment(paragraphStart, paragraphEnd, 0, layout.getLineTop(LayoutCompat_androidKt.getLineForOffset(layout, paragraphStart, false)), layout.getWidth(), layout.getLineBottom(LayoutCompat_androidKt.getLineForOffset(layout, paragraphEnd, true))));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithLine(LayoutHelper layoutHelper, boolean dropSpaces) {
        ArrayList arrayList = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int lineCount = layoutHelper.getLayout().getLineCount();
        for (int i = 0; i < lineCount; i++) {
            arrayList.add(new Segment(layout.getLineStart(i), layout.getLineEnd(i), dropSpaces ? (int) Math.ceil(layout.getLineLeft(i)) : 0, layout.getLineTop(i), dropSpaces ? (int) Math.ceil(layout.getLineRight(i)) : layout.getWidth(), layout.getLineBottom(i)));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithWord(LayoutHelper layoutHelper, boolean dropSpaces) {
        int i;
        Layout layout = layoutHelper.getLayout();
        int iCeil = (int) Math.ceil(layout.getPaint().measureText(" "));
        List<Integer> listBreakOffsets = breakOffsets(layoutHelper, SegmentType.Word);
        if (listBreakOffsets.size() != 0) {
            boolean z = true;
            if (listBreakOffsets.size() != 1) {
                ArrayList arrayList = new ArrayList();
                boolean z2 = false;
                Integer num = listBreakOffsets.get(0);
                int lastIndex = CollectionsKt.getLastIndex(listBreakOffsets);
                int i2 = 0;
                while (i2 < lastIndex) {
                    i2++;
                    Integer num2 = listBreakOffsets.get(i2);
                    int iIntValue = num2.intValue();
                    int iIntValue2 = num.intValue();
                    int lineForOffset = LayoutCompat_androidKt.getLineForOffset(layout, iIntValue2, z2);
                    boolean z3 = layout.getParagraphDirection(lineForOffset) == -1 ? z : z2;
                    boolean zIsRtlCharAt = layout.isRtlCharAt(iIntValue2);
                    if (zIsRtlCharAt != z3) {
                        z = z2;
                    }
                    int iCeil2 = (int) Math.ceil(layoutHelper.getHorizontalPosition(iIntValue2, z, z2));
                    boolean z4 = zIsRtlCharAt == z3;
                    int i3 = lastIndex;
                    int iCeil3 = (int) Math.ceil(layoutHelper.getHorizontalPosition(iIntValue, z4, true));
                    int iMin = Math.min(iCeil2, iCeil3);
                    int iMax = Math.max(iCeil2, iCeil3);
                    if (dropSpaces && iIntValue != 0 && layout.getText().charAt(iIntValue - 1) == ' ') {
                        i = lineForOffset;
                        if (layout.getLineEnd(i) != iIntValue) {
                            if (zIsRtlCharAt) {
                                iMin += iCeil;
                            } else {
                                iMax -= iCeil;
                            }
                        }
                    } else {
                        i = lineForOffset;
                    }
                    arrayList.add(new Segment(iIntValue2, iIntValue, iMin, layout.getLineTop(i), iMax, layout.getLineBottom(i)));
                    num = num2;
                    lastIndex = i3;
                    z = true;
                    z2 = false;
                }
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<androidx.compose.ui.text.android.animation.Segment> breakSegmentWithChar(androidx.compose.ui.text.android.LayoutHelper r21, boolean r22) {
        /*
            r20 = this;
            r0 = r21
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            androidx.compose.ui.text.android.animation.SegmentType r2 = androidx.compose.ui.text.android.animation.SegmentType.Character
            r3 = r20
            java.util.List r2 = r3.breakOffsets(r0, r2)
            int r4 = r2.size()
            if (r4 == 0) goto Lbe
            int r4 = r2.size()
            r5 = 1
            if (r4 != r5) goto L20
            goto Lbe
        L20:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            r6 = 0
            java.lang.Object r7 = r2.get(r6)
            int r8 = kotlin.collections.CollectionsKt.getLastIndex(r2)
            r9 = r6
        L31:
            if (r9 >= r8) goto Lc1
            int r9 = r9 + 1
            java.lang.Object r10 = r2.get(r9)
            r11 = r10
            java.lang.Number r11 = (java.lang.Number) r11
            int r14 = r11.intValue()
            java.lang.Number r7 = (java.lang.Number) r7
            int r13 = r7.intValue()
            android.text.Layout r7 = r21.getLayout()
            if (r22 == 0) goto L61
            int r11 = r13 + 1
            if (r14 != r11) goto L61
            java.lang.CharSequence r11 = r7.getText()
            char r11 = r11.charAt(r13)
            boolean r11 = r0.isLineEndSpace(r11)
            if (r11 == 0) goto L61
            r19 = r8
            goto Lb2
        L61:
            int r11 = androidx.compose.ui.text.android.LayoutCompat_androidKt.getLineForOffset(r7, r13, r6)
            int r12 = r7.getParagraphDirection(r11)
            r15 = -1
            if (r12 != r15) goto L6e
            r12 = r5
            goto L6f
        L6e:
            r12 = r6
        L6f:
            boolean r15 = r7.isRtlCharAt(r13)
            if (r15 != r12) goto L76
            goto L77
        L76:
            r5 = r6
        L77:
            float r5 = r0.getHorizontalPosition(r13, r5, r6)
            r16 = r7
            double r6 = (double) r5
            double r5 = java.lang.Math.ceil(r6)
            float r5 = (float) r5
            int r5 = (int) r5
            if (r15 != r12) goto L88
            r6 = 1
            goto L89
        L88:
            r6 = 0
        L89:
            r7 = 1
            float r6 = r0.getHorizontalPosition(r14, r6, r7)
            r19 = r8
            double r7 = (double) r6
            double r6 = java.lang.Math.ceil(r7)
            float r6 = (float) r6
            int r6 = (int) r6
            androidx.compose.ui.text.android.animation.Segment r7 = new androidx.compose.ui.text.android.animation.Segment
            int r15 = java.lang.Math.min(r5, r6)
            r8 = r16
            int r16 = r8.getLineTop(r11)
            int r17 = java.lang.Math.max(r5, r6)
            int r18 = r8.getLineBottom(r11)
            r12 = r7
            r12.<init>(r13, r14, r15, r16, r17, r18)
            r1.add(r7)
        Lb2:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r4.add(r5)
            r7 = r10
            r8 = r19
            r5 = 1
            r6 = 0
            goto L31
        Lbe:
            kotlin.collections.CollectionsKt.emptyList()
        Lc1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.animation.SegmentBreaker.breakSegmentWithChar(androidx.compose.ui.text.android.LayoutHelper, boolean):java.util.List");
    }
}
