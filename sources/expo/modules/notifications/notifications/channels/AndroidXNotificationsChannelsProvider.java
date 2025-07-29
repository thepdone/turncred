package expo.modules.notifications.notifications.channels;

import android.content.Context;
import expo.modules.notifications.notifications.channels.managers.AndroidXNotificationsChannelGroupManager;
import expo.modules.notifications.notifications.channels.managers.AndroidXNotificationsChannelManager;
import expo.modules.notifications.notifications.channels.serializers.ExpoNotificationsChannelGroupSerializer;
import expo.modules.notifications.notifications.channels.serializers.ExpoNotificationsChannelSerializer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidXNotificationsChannelsProvider.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lexpo/modules/notifications/notifications/channels/AndroidXNotificationsChannelsProvider;", "Lexpo/modules/notifications/notifications/channels/AbstractNotificationsChannelsProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "channelManager", "Lexpo/modules/notifications/notifications/channels/managers/AndroidXNotificationsChannelManager;", "getChannelManager", "()Lexpo/modules/notifications/notifications/channels/managers/AndroidXNotificationsChannelManager;", "channelManager$delegate", "Lkotlin/Lazy;", "channelSerializer", "Lexpo/modules/notifications/notifications/channels/serializers/ExpoNotificationsChannelSerializer;", "getChannelSerializer", "()Lexpo/modules/notifications/notifications/channels/serializers/ExpoNotificationsChannelSerializer;", "channelSerializer$delegate", "groupManager", "Lexpo/modules/notifications/notifications/channels/managers/AndroidXNotificationsChannelGroupManager;", "getGroupManager", "()Lexpo/modules/notifications/notifications/channels/managers/AndroidXNotificationsChannelGroupManager;", "groupManager$delegate", "groupSerializer", "Lexpo/modules/notifications/notifications/channels/serializers/ExpoNotificationsChannelGroupSerializer;", "getGroupSerializer", "()Lexpo/modules/notifications/notifications/channels/serializers/ExpoNotificationsChannelGroupSerializer;", "groupSerializer$delegate", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AndroidXNotificationsChannelsProvider extends AbstractNotificationsChannelsProvider {

    /* renamed from: channelManager$delegate, reason: from kotlin metadata */
    private final Lazy channelManager;

    /* renamed from: channelSerializer$delegate, reason: from kotlin metadata */
    private final Lazy channelSerializer;

    /* renamed from: groupManager$delegate, reason: from kotlin metadata */
    private final Lazy groupManager;

    /* renamed from: groupSerializer$delegate, reason: from kotlin metadata */
    private final Lazy groupSerializer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidXNotificationsChannelsProvider(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.groupManager = LazyKt.lazy(new Function0<AndroidXNotificationsChannelGroupManager>() { // from class: expo.modules.notifications.notifications.channels.AndroidXNotificationsChannelsProvider$groupManager$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidXNotificationsChannelGroupManager invoke() {
                return new AndroidXNotificationsChannelGroupManager(context);
            }
        });
        this.channelManager = LazyKt.lazy(new Function0<AndroidXNotificationsChannelManager>() { // from class: expo.modules.notifications.notifications.channels.AndroidXNotificationsChannelsProvider$channelManager$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidXNotificationsChannelManager invoke() {
                return new AndroidXNotificationsChannelManager(context, this.getGroupManager());
            }
        });
        this.channelSerializer = LazyKt.lazy(new Function0<ExpoNotificationsChannelSerializer>() { // from class: expo.modules.notifications.notifications.channels.AndroidXNotificationsChannelsProvider$channelSerializer$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpoNotificationsChannelSerializer invoke() {
                return new ExpoNotificationsChannelSerializer();
            }
        });
        this.groupSerializer = LazyKt.lazy(new Function0<ExpoNotificationsChannelGroupSerializer>() { // from class: expo.modules.notifications.notifications.channels.AndroidXNotificationsChannelsProvider$groupSerializer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpoNotificationsChannelGroupSerializer invoke() {
                return new ExpoNotificationsChannelGroupSerializer(this.this$0.getChannelSerializer());
            }
        });
    }

    @Override // expo.modules.notifications.notifications.channels.NotificationsChannelsProvider
    public AndroidXNotificationsChannelGroupManager getGroupManager() {
        return (AndroidXNotificationsChannelGroupManager) this.groupManager.getValue();
    }

    @Override // expo.modules.notifications.notifications.channels.NotificationsChannelsProvider
    public AndroidXNotificationsChannelManager getChannelManager() {
        return (AndroidXNotificationsChannelManager) this.channelManager.getValue();
    }

    @Override // expo.modules.notifications.notifications.channels.NotificationsChannelsProvider
    public ExpoNotificationsChannelSerializer getChannelSerializer() {
        return (ExpoNotificationsChannelSerializer) this.channelSerializer.getValue();
    }

    @Override // expo.modules.notifications.notifications.channels.NotificationsChannelsProvider
    public ExpoNotificationsChannelGroupSerializer getGroupSerializer() {
        return (ExpoNotificationsChannelGroupSerializer) this.groupSerializer.getValue();
    }
}
