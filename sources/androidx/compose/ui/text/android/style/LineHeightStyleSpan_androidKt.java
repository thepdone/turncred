package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: LineHeightStyleSpan.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {ViewProps.LINE_HEIGHT, "", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LineHeightStyleSpan_androidKt {
    public static final int lineHeight(Paint.FontMetricsInt fontMetricsInt) {
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }
}
