package expo.modules.notifications.notifications.presentation.builders;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.notifications.R;
import expo.modules.notifications.notifications.channels.managers.AndroidXNotificationsChannelGroupManager;
import expo.modules.notifications.notifications.channels.managers.AndroidXNotificationsChannelManager;
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelManager;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.interfaces.NotificationBuilder;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.service.NotificationsService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: BaseNotificationBuilder.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u0010H\u0005J\u0012\u0010)\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lexpo/modules/notifications/notifications/presentation/builders/BaseNotificationBuilder;", "Lexpo/modules/notifications/notifications/interfaces/NotificationBuilder;", "context", "Landroid/content/Context;", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "(Landroid/content/Context;Lexpo/modules/notifications/notifications/model/Notification;)V", "channelId", "", "getChannelId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "fallbackChannelName", "getFallbackChannelName", "fallbackNotificationChannel", "Landroid/app/NotificationChannel;", "getFallbackNotificationChannel", "()Landroid/app/NotificationChannel;", "getNotification", "()Lexpo/modules/notifications/notifications/model/Notification;", "<set-?>", "Lexpo/modules/notifications/notifications/model/NotificationBehavior;", NotificationsService.NOTIFICATION_BEHAVIOR_KEY, "getNotificationBehavior", "()Lexpo/modules/notifications/notifications/model/NotificationBehavior;", "notificationContent", "Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "getNotificationContent", "()Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationsChannelManager", "Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelManager;", "getNotificationsChannelManager", "()Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelManager;", "createBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "createFallbackChannel", "setAllowedBehavior", "behavior", "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseNotificationBuilder implements NotificationBuilder {
    private static final String FALLBACK_CHANNEL_ID = "expo_notifications_fallback_notification_channel";
    private final Context context;
    private final Notification notification;
    private NotificationBehavior notificationBehavior;
    private static final int FALLBACK_CHANNEL_IMPORTANCE = 4;

    protected BaseNotificationBuilder(Context context, Notification notification) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.context = context;
        this.notification = notification;
    }

    protected final Context getContext() {
        return this.context;
    }

    protected final Notification getNotification() {
        return this.notification;
    }

    protected final NotificationBehavior getNotificationBehavior() {
        return this.notificationBehavior;
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationBuilder
    public NotificationBuilder setAllowedBehavior(NotificationBehavior behavior) {
        this.notificationBehavior = behavior;
        return this;
    }

    public final NotificationCompat.Builder createBuilder() {
        String channelId = getChannelId();
        return channelId != null ? new NotificationCompat.Builder(this.context, channelId) : new NotificationCompat.Builder(this.context);
    }

    protected final String getChannelId() {
        NotificationRequest notificationRequest = this.notification.getNotificationRequest();
        NotificationTrigger trigger = notificationRequest != null ? notificationRequest.getTrigger() : null;
        if (trigger == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("Couldn't get channel for the notifications - trigger is 'null'. Fallback to '%s' channel", Arrays.copyOf(new Object[]{FALLBACK_CHANNEL_ID}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Log.e(NotificationsService.NOTIFICATIONS_KEY, str);
            NotificationChannel fallbackNotificationChannel = getFallbackNotificationChannel();
            Intrinsics.checkNotNull(fallbackNotificationChannel);
            return fallbackNotificationChannel.getId();
        }
        String notificationChannel = trigger.getNotificationChannel();
        if (notificationChannel == null) {
            NotificationChannel fallbackNotificationChannel2 = getFallbackNotificationChannel();
            Intrinsics.checkNotNull(fallbackNotificationChannel2);
            return fallbackNotificationChannel2.getId();
        }
        NotificationChannel notificationChannel2 = getNotificationsChannelManager().getNotificationChannel(notificationChannel);
        if (notificationChannel2 == null) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("Channel '%s' doesn't exists. Fallback to '%s' channel", Arrays.copyOf(new Object[]{notificationChannel, FALLBACK_CHANNEL_ID}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            Log.e(NotificationsService.NOTIFICATIONS_KEY, str2);
            NotificationChannel fallbackNotificationChannel3 = getFallbackNotificationChannel();
            Intrinsics.checkNotNull(fallbackNotificationChannel3);
            return fallbackNotificationChannel3.getId();
        }
        return notificationChannel2.getId();
    }

    public NotificationsChannelManager getNotificationsChannelManager() {
        return new AndroidXNotificationsChannelManager(this.context, new AndroidXNotificationsChannelGroupManager(this.context));
    }

    private final NotificationChannel getFallbackNotificationChannel() {
        NotificationChannel notificationChannel = getNotificationManager().getNotificationChannel(FALLBACK_CHANNEL_ID);
        return notificationChannel == null ? createFallbackChannel() : notificationChannel;
    }

    protected final NotificationChannel createFallbackChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(FALLBACK_CHANNEL_ID, getFallbackChannelName(), FALLBACK_CHANNEL_IMPORTANCE);
        notificationChannel.setShowBadge(true);
        notificationChannel.enableVibration(true);
        getNotificationManager().createNotificationChannel(notificationChannel);
        return notificationChannel;
    }

    private final String getFallbackChannelName() {
        String string = this.context.getString(R.string.expo_notifications_fallback_channel_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final NotificationManager getNotificationManager() {
        Object systemService = this.context.getSystemService(NotificationsService.NOTIFICATION_KEY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    protected final INotificationContent getNotificationContent() {
        INotificationContent content = this.notification.getNotificationRequest().getContent();
        Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
        return content;
    }
}
