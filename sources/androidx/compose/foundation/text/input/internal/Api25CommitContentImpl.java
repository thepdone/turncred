package androidx.compose.foundation.text.input.internal;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;

/* compiled from: StatelessInputConnection.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/input/internal/Api25CommitContentImpl;", "", "()V", "commitContent", "", "inputConnection", "Landroid/view/inputmethod/InputConnection;", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "", "opts", "Landroid/os/Bundle;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class Api25CommitContentImpl {
    public static final Api25CommitContentImpl INSTANCE = new Api25CommitContentImpl();

    private Api25CommitContentImpl() {
    }

    public final boolean commitContent(InputConnection inputConnection, InputContentInfo inputContentInfo, int flags, Bundle opts) {
        return inputConnection.commitContent(inputContentInfo, flags, opts);
    }
}
