package expo.modules.linking;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: LinkingReactActivityLifecycleListener.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lexpo/modules/linking/LinkingReactActivityLifecycleListener;", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "()V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onReceiveURL", "url", "Landroid/net/Uri;", "expo-linking_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LinkingReactActivityLifecycleListener implements ReactActivityLifecycleListener {
    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        onReceiveURL((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getData());
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public boolean onNewIntent(Intent intent) {
        onReceiveURL(intent != null ? intent.getData() : null);
        return true;
    }

    private final void onReceiveURL(Uri url) {
        if (url == null) {
            return;
        }
        ExpoLinkingModule.INSTANCE.setInitialURL(url);
        Iterator<T> it = ExpoLinkingModule.INSTANCE.getOnURLReceivedObservers().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(url);
        }
    }
}
