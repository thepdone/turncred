package androidx.compose.foundation.content;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* compiled from: ReceiveContent.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"contentReceiver", "Landroidx/compose/ui/Modifier;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReceiveContentKt {
    public static final Modifier contentReceiver(Modifier modifier, ReceiveContentListener receiveContentListener) {
        return modifier.then(new ReceiveContentElement(receiveContentListener));
    }
}
