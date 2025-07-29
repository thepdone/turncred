package expo.modules.notifications.notifications.model.triggers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.google.firebase.messaging.RemoteMessage;
import expo.modules.notifications.notifications.RemoteMessageSerializer;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseNotificationTrigger.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lexpo/modules/notifications/notifications/model/triggers/FirebaseNotificationTrigger;", "Lexpo/modules/notifications/notifications/interfaces/NotificationTrigger;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "(Lcom/google/firebase/messaging/RemoteMessage;)V", "getRemoteMessage", "()Lcom/google/firebase/messaging/RemoteMessage;", "describeContents", "", "getNotificationChannel", "", "toBundle", "Landroid/os/Bundle;", "writeToParcel", "", "dest", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirebaseNotificationTrigger implements NotificationTrigger {
    private final RemoteMessage remoteMessage;
    public static final Parcelable.Creator<FirebaseNotificationTrigger> CREATOR = new Parcelable.Creator<FirebaseNotificationTrigger>() { // from class: expo.modules.notifications.notifications.model.triggers.FirebaseNotificationTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirebaseNotificationTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FirebaseNotificationTrigger(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirebaseNotificationTrigger[] newArray(int size) {
            return new FirebaseNotificationTrigger[size];
        }
    };

    public /* synthetic */ FirebaseNotificationTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FirebaseNotificationTrigger(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        this.remoteMessage = remoteMessage;
    }

    public final RemoteMessage getRemoteMessage() {
        return this.remoteMessage;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private FirebaseNotificationTrigger(Parcel parcel) {
        RemoteMessage remoteMessage = (RemoteMessage) parcel.readParcelable(FirebaseNotificationTrigger.class.getClassLoader());
        if (remoteMessage != null) {
            this(remoteMessage);
            return;
        }
        throw new IllegalArgumentException("RemoteMessage from readParcelable must not be null");
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public String getNotificationChannel() {
        String channelId;
        RemoteMessage.Notification notification = this.remoteMessage.getNotification();
        if (notification == null || (channelId = notification.getChannelId()) == null) {
            channelId = this.remoteMessage.getData().get("channelId");
        }
        return channelId == null ? NotificationTrigger.DefaultImpls.getNotificationChannel(this) : channelId;
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to("type", "push"), TuplesKt.to("remoteMessage", RemoteMessageSerializer.toBundle(this.remoteMessage)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.remoteMessage, 0);
    }
}
