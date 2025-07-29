package expo.modules.notifications.notifications.interfaces;

import android.os.Bundle;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;

/* loaded from: classes5.dex */
public interface NotificationListener {
    default void onNotificationReceived(Notification notification) {
    }

    default void onNotificationResponseIntentReceived(Bundle bundle) {
    }

    default boolean onNotificationResponseReceived(NotificationResponse notificationResponse) {
        return false;
    }

    default void onNotificationsDropped() {
    }
}
