package androidx.compose.foundation.text.input.internal;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.SentryEnvelopeItemHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GapBuffer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0096\u0002J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "", "text", "(Ljava/lang/CharSequence;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "getLength", "()I", "contentEquals", "", "other", "get", "", FirebaseAnalytics.Param.INDEX, "replace", "", ViewProps.START, ViewProps.END, "textStart", "textEnd", "subSequence", "startIndex", "endIndex", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PartialGapBuffer implements CharSequence {
    public static final int BUF_SIZE = 255;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private GapBuffer buffer;
    private CharSequence text;
    public static final int $stable = 8;
    private int bufStart = -1;
    private int bufEnd = -1;

    public PartialGapBuffer(CharSequence charSequence) {
        this.text = charSequence;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public int getLength() {
        GapBuffer gapBuffer = this.buffer;
        return gapBuffer == null ? this.text.length() : (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    public static /* synthetic */ void replace$default(PartialGapBuffer partialGapBuffer, int i, int i2, CharSequence charSequence, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = charSequence.length();
        }
        partialGapBuffer.replace(i, i2, charSequence, i6, i4);
    }

    public final void replace(int start, int end, CharSequence text, int textStart, int textEnd) {
        if (start > end) {
            throw new IllegalArgumentException(("start=" + start + " > end=" + end).toString());
        }
        if (textStart > textEnd) {
            throw new IllegalArgumentException(("textStart=" + textStart + " > textEnd=" + textEnd).toString());
        }
        if (start < 0) {
            throw new IllegalArgumentException(("start must be non-negative, but was " + start).toString());
        }
        if (textStart < 0) {
            throw new IllegalArgumentException(("textStart must be non-negative, but was " + textStart).toString());
        }
        GapBuffer gapBuffer = this.buffer;
        int i = textEnd - textStart;
        if (gapBuffer == null) {
            int iMax = Math.max(255, i + 128);
            char[] cArr = new char[iMax];
            int iMin = Math.min(start, 64);
            int iMin2 = Math.min(this.text.length() - end, 64);
            int i2 = start - iMin;
            ToCharArray_androidKt.toCharArray(this.text, cArr, 0, i2, start);
            int i3 = iMax - iMin2;
            int i4 = iMin2 + end;
            ToCharArray_androidKt.toCharArray(this.text, cArr, i3, end, i4);
            ToCharArray_androidKt.toCharArray(text, cArr, iMin, textStart, textEnd);
            this.buffer = new GapBuffer(cArr, iMin + i, i3);
            this.bufStart = i2;
            this.bufEnd = i4;
            return;
        }
        int i5 = this.bufStart;
        int i6 = start - i5;
        int i7 = end - i5;
        if (i6 < 0 || i7 > gapBuffer.length()) {
            this.text = toString();
            this.buffer = null;
            this.bufStart = -1;
            this.bufEnd = -1;
            replace(start, end, text, textStart, textEnd);
            return;
        }
        gapBuffer.replace(i6, i7, text, textStart, textEnd);
    }

    public char get(int index) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.charAt(index);
        }
        if (index < this.bufStart) {
            return this.text.charAt(index);
        }
        int length = gapBuffer.length();
        int i = this.bufStart;
        if (index < length + i) {
            return gapBuffer.get(index - i);
        }
        return this.text.charAt(index - ((length - this.bufEnd) + i));
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        return toString().subSequence(startIndex, endIndex);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        CharSequence charSequence = this.text;
        sb.append(charSequence, this.bufEnd, charSequence.length());
        return sb.toString();
    }

    public final boolean contentEquals(CharSequence other) {
        return Intrinsics.areEqual(toString(), other.toString());
    }
}
