package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;

/* compiled from: AndroidTextPaint.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setAlpha", "", "Landroid/text/TextPaint;", ViewHierarchyNode.JsonKeys.ALPHA, "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint textPaint, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        textPaint.setAlpha(Math.round(f * 255));
    }
}
