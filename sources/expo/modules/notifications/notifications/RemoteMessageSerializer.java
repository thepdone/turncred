package expo.modules.notifications.notifications;

import android.os.Bundle;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.service.NotificationsService;
import io.sentry.protocol.SentryThread;
import java.util.Map;

/* loaded from: classes5.dex */
public class RemoteMessageSerializer {
    public static Bundle toBundle(RemoteMessage remoteMessage) {
        Bundle bundle = new Bundle();
        bundle.putString("collapseKey", remoteMessage.getCollapseKey());
        bundle.putBundle("data", toBundle(remoteMessage.getData()));
        bundle.putString(Constants.MessagePayloadKeys.FROM, remoteMessage.getFrom());
        bundle.putString("messageId", remoteMessage.getMessageId());
        bundle.putString("messageType", remoteMessage.getMessageType());
        bundle.putBundle(NotificationsService.NOTIFICATION_KEY, toBundle(remoteMessage.getNotification()));
        bundle.putInt("originalPriority", remoteMessage.getOriginalPriority());
        bundle.putInt(SentryThread.JsonKeys.PRIORITY, remoteMessage.getPriority());
        bundle.putLong("sentTime", remoteMessage.getSentTime());
        bundle.putString("to", remoteMessage.getTo());
        bundle.putInt("ttl", remoteMessage.getTtl());
        return bundle;
    }

    private static Bundle toBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    private static Bundle toBundle(RemoteMessage.Notification notification) {
        if (notification == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("body", notification.getBody());
        bundle.putStringArray("bodyLocalizationArgs", notification.getBodyLocalizationArgs());
        bundle.putString("bodyLocalizationKey", notification.getBodyLocalizationKey());
        bundle.putString("channelId", notification.getChannelId());
        bundle.putString("clickAction", notification.getClickAction());
        bundle.putString(ViewProps.COLOR, notification.getColor());
        bundle.putBoolean("usesDefaultLightSettings", notification.getDefaultLightSettings());
        bundle.putBoolean("usesDefaultSound", notification.getDefaultSound());
        bundle.putBoolean("usesDefaultVibrateSettings", notification.getDefaultVibrateSettings());
        if (notification.getEventTime() != null) {
            bundle.putLong("eventTime", notification.getEventTime().longValue());
        } else {
            bundle.putString("eventTime", null);
        }
        bundle.putString("icon", notification.getIcon());
        if (notification.getImageUrl() != null) {
            bundle.putString("imageUrl", notification.getImageUrl().toString());
        } else {
            bundle.putString("imageUrl", null);
        }
        bundle.putIntArray("lightSettings", notification.getLightSettings());
        if (notification.getLink() != null) {
            bundle.putString("link", notification.getLink().toString());
        } else {
            bundle.putString("link", null);
        }
        bundle.putBoolean("localOnly", notification.getLocalOnly());
        if (notification.getNotificationCount() != null) {
            bundle.putInt("notificationCount", notification.getNotificationCount().intValue());
        } else {
            bundle.putString("notificationCount", null);
        }
        if (notification.getNotificationPriority() != null) {
            bundle.putInt("notificationPriority", notification.getNotificationPriority().intValue());
        } else {
            bundle.putString("notificationPriority", null);
        }
        bundle.putString(NotificationsChannelSerializer.SOUND_KEY, notification.getSound());
        bundle.putBoolean("sticky", notification.getSticky());
        bundle.putString("tag", notification.getTag());
        bundle.putString("ticker", notification.getTicker());
        bundle.putString("title", notification.getTitle());
        bundle.putStringArray("titleLocalizationArgs", notification.getTitleLocalizationArgs());
        bundle.putString("titleLocalizationKey", notification.getTitleLocalizationKey());
        if (notification.getVibrateTimings() != null) {
            bundle.putIntArray("vibrateTimings", intArrayFromLongArray(notification.getVibrateTimings()));
        }
        if (notification.getVisibility() != null) {
            bundle.putInt("visibility", notification.getVisibility().intValue());
        } else {
            bundle.putString("visibility", null);
        }
        return bundle;
    }

    public static int[] intArrayFromLongArray(long[] jArr) {
        int[] iArr = new int[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            iArr[i] = (int) jArr[i];
        }
        return iArr;
    }
}
