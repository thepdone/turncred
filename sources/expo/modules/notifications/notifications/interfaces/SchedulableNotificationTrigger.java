package expo.modules.notifications.notifications.interfaces;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes5.dex */
public interface SchedulableNotificationTrigger extends NotificationTrigger, Serializable {
    Date nextTriggerDate();
}
