package expo.modules.notifications.notifications.interfaces;

import android.app.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: NotificationBuilder.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lexpo/modules/notifications/notifications/interfaces/NotificationBuilder;", "", "build", "Landroid/app/Notification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAllowedBehavior", "behavior", "Lexpo/modules/notifications/notifications/model/NotificationBehavior;", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NotificationBuilder {
    Object build(Continuation<? super Notification> continuation);

    NotificationBuilder setAllowedBehavior(NotificationBehavior behavior);
}
