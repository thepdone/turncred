package expo.modules.notifications.notifications.channels;

import expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager;
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelManager;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelGroupSerializer;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;

/* compiled from: NotificationsChannelsProvider.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/notifications/notifications/channels/NotificationsChannelsProvider;", "", "channelManager", "Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelManager;", "getChannelManager", "()Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelManager;", "channelSerializer", "Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelSerializer;", "getChannelSerializer", "()Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelSerializer;", "groupManager", "Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelGroupManager;", "getGroupManager", "()Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelGroupManager;", "groupSerializer", "Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelGroupSerializer;", "getGroupSerializer", "()Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelGroupSerializer;", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NotificationsChannelsProvider {
    NotificationsChannelManager getChannelManager();

    NotificationsChannelSerializer getChannelSerializer();

    NotificationsChannelGroupManager getGroupManager();

    NotificationsChannelGroupSerializer getGroupSerializer();
}
