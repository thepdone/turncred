package expo.modules.notifications.service.delegates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.notifications.notifications.NotificationManager;
import expo.modules.notifications.notifications.debug.DebugLogging;
import expo.modules.notifications.service.NotificationsService;

/* loaded from: classes5.dex */
public class ExpoNotificationLifecycleListener implements ReactActivityLifecycleListener {
    private NotificationManager mNotificationManager;

    public ExpoNotificationLifecycleListener(Context context, NotificationManager notificationManager) {
        this.mNotificationManager = notificationManager;
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onCreate(Activity activity, Bundle bundle) {
        Bundle extras;
        Intent intent = activity.getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        if (extras.containsKey(NotificationsService.NOTIFICATION_RESPONSE_KEY)) {
            Log.d("ReactNativeJS", "[native] ExpoNotificationLifecycleListener contains an unmarshaled notification response. Skipping.");
        } else {
            DebugLogging.logBundle("ExpoNotificationLifeCycleListener.onCreate:", extras);
            this.mNotificationManager.onNotificationResponseFromExtras(extras);
        }
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public boolean onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey(NotificationsService.NOTIFICATION_RESPONSE_KEY)) {
                Log.d("ReactNativeJS", "[native] ExpoNotificationLifecycleListener contains an unmarshaled notification response. Skipping.");
                intent.removeExtra(NotificationsService.NOTIFICATION_RESPONSE_KEY);
                return super.onNewIntent(intent);
            }
            DebugLogging.logBundle("ExpoNotificationLifeCycleListener.onNewIntent:", extras);
            this.mNotificationManager.onNotificationResponseFromExtras(extras);
        }
        return super.onNewIntent(intent);
    }
}
