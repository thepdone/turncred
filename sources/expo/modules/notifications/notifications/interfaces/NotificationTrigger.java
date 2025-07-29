package expo.modules.notifications.notifications.interfaces;

import android.os.Bundle;
import android.os.Parcelable;
import kotlin.Metadata;

/* compiled from: NotificationTrigger.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/notifications/notifications/interfaces/NotificationTrigger;", "Landroid/os/Parcelable;", "getNotificationChannel", "", "toBundle", "Landroid/os/Bundle;", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NotificationTrigger extends Parcelable {

    /* compiled from: NotificationTrigger.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getNotificationChannel(NotificationTrigger notificationTrigger) {
            return null;
        }
    }

    String getNotificationChannel();

    Bundle toBundle();
}
