package expo.modules.notifications.notifications.channels.serializers;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ExpoNotificationsChannelGroupSerializer implements NotificationsChannelGroupSerializer {
    private NotificationsChannelSerializer mChannelSerializer;

    public ExpoNotificationsChannelGroupSerializer(NotificationsChannelSerializer notificationsChannelSerializer) {
        this.mChannelSerializer = notificationsChannelSerializer;
    }

    @Override // expo.modules.notifications.notifications.channels.serializers.NotificationsChannelGroupSerializer
    public Bundle toBundle(NotificationChannelGroup notificationChannelGroup) {
        if (notificationChannelGroup == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", getId(notificationChannelGroup));
        bundle.putString("name", notificationChannelGroup.getName().toString());
        if (Build.VERSION.SDK_INT >= 28) {
            bundle.putString("description", notificationChannelGroup.getDescription());
            bundle.putBoolean(NotificationsChannelGroupSerializer.IS_BLOCKED_KEY, notificationChannelGroup.isBlocked());
        }
        bundle.putParcelableArrayList(NotificationsChannelGroupSerializer.CHANNELS_KEY, toList(notificationChannelGroup.getChannels()));
        return bundle;
    }

    protected String getId(NotificationChannelGroup notificationChannelGroup) {
        return notificationChannelGroup.getId();
    }

    private ArrayList<Bundle> toList(List<NotificationChannel> list) {
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        Iterator<NotificationChannel> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.mChannelSerializer.toBundle(it.next()));
        }
        return arrayList;
    }
}
