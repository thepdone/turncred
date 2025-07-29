package expo.modules.notifications.notifications.channels;

import android.content.Context;
import expo.modules.core.interfaces.InternalModule;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class AbstractNotificationsChannelsProvider implements NotificationsChannelsProvider, InternalModule {
    protected final Context mContext;

    public AbstractNotificationsChannelsProvider(Context context) {
        this.mContext = context;
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<? extends Class> getExportedInterfaces() {
        return Collections.singletonList(NotificationsChannelsProvider.class);
    }
}
