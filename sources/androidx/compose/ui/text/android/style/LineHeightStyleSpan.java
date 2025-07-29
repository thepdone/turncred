package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: LineHeightStyleSpan.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J8\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J'\u0010$\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b%R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", ViewProps.LINE_HEIGHT, "", "startIndex", "", "endIndex", "trimFirstLineTop", "", "trimLastLineBottom", "topRatio", "(FIIZZF)V", "ascent", "descent", "firstAscent", "<set-?>", "firstAscentDiff", "getFirstAscentDiff", "()I", "lastDescent", "lastDescentDiff", "getLastDescentDiff", "getLineHeight", "()F", "getTrimLastLineBottom", "()Z", "calculateTargetMetrics", "", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "chooseHeight", "text", "", ViewProps.START, ViewProps.END, "spanStartVertical", "copy", "copy$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    public static final int $stable = 8;
    private final int endIndex;
    private int firstAscentDiff;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;
    private int firstAscent = Integer.MIN_VALUE;
    private int ascent = Integer.MIN_VALUE;
    private int descent = Integer.MIN_VALUE;
    private int lastDescent = Integer.MIN_VALUE;

    public LineHeightStyleSpan(float f, int i, int i2, boolean z, boolean z2, float f2) {
        this.lineHeight = f;
        this.startIndex = i;
        this.endIndex = i2;
        this.trimFirstLineTop = z;
        this.trimLastLineBottom = z2;
        this.topRatio = f2;
        if ((0.0f > f2 || f2 > 1.0f) && f2 != -1.0f) {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanStartVertical, int lineHeight, Paint.FontMetricsInt fontMetricsInt) {
        if (LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt) <= 0) {
            return;
        }
        boolean z = start == this.startIndex;
        boolean z2 = end == this.endIndex;
        if (z && z2 && this.trimFirstLineTop && this.trimLastLineBottom) {
            return;
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            calculateTargetMetrics(fontMetricsInt);
        }
        fontMetricsInt.ascent = z ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = z2 ? this.lastDescent : this.descent;
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        double dCeil;
        int iCeil = (int) Math.ceil(this.lineHeight);
        int iLineHeight = iCeil - LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        float fAbs = this.topRatio;
        if (fAbs == -1.0f) {
            fAbs = Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        }
        if (iLineHeight <= 0) {
            dCeil = Math.ceil(iLineHeight * fAbs);
        } else {
            dCeil = Math.ceil(iLineHeight * (1.0f - fAbs));
        }
        int i = fontMetricsInt.descent + ((int) dCeil);
        this.descent = i;
        int i2 = i - iCeil;
        this.ascent = i2;
        if (this.trimFirstLineTop) {
            i2 = fontMetricsInt.ascent;
        }
        this.firstAscent = i2;
        this.lastDescent = this.trimLastLineBottom ? fontMetricsInt.descent : this.descent;
        this.firstAscentDiff = fontMetricsInt.ascent - this.firstAscent;
        this.lastDescentDiff = this.lastDescent - fontMetricsInt.descent;
    }

    public static /* synthetic */ LineHeightStyleSpan copy$ui_text_release$default(LineHeightStyleSpan lineHeightStyleSpan, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = lineHeightStyleSpan.trimFirstLineTop;
        }
        return lineHeightStyleSpan.copy$ui_text_release(i, i2, z);
    }

    public final LineHeightStyleSpan copy$ui_text_release(int startIndex, int endIndex, boolean trimFirstLineTop) {
        return new LineHeightStyleSpan(this.lineHeight, startIndex, endIndex, trimFirstLineTop, this.trimLastLineBottom, this.topRatio);
    }
}
