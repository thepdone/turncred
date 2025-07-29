package expo.modules.notifications.notifications.triggers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationTriggers.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/DateTrigger;", "Lexpo/modules/notifications/notifications/triggers/ChannelAwareTrigger;", "Lexpo/modules/notifications/notifications/interfaces/SchedulableNotificationTrigger;", "channelId", "", "timestamp", "", "(Ljava/lang/String;J)V", "getChannelId", "()Ljava/lang/String;", "getTimestamp", "()J", "nextTriggerDate", "Ljava/util/Date;", "toBundle", "Landroid/os/Bundle;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateTrigger extends ChannelAwareTrigger implements SchedulableNotificationTrigger {
    public static final Parcelable.Creator<DateTrigger> CREATOR = new Creator();
    private final String channelId;
    private final long timestamp;

    /* compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DateTrigger> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DateTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DateTrigger(parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DateTrigger[] newArray(int i) {
            return new DateTrigger[i];
        }
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.channelId);
        parcel.writeLong(this.timestamp);
    }

    public DateTrigger(String str, long j) {
        super(str);
        this.channelId = str;
        this.timestamp = j;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger
    public String getChannelId() {
        return this.channelId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return bundleWithChannelId(TuplesKt.to("type", "date"), TuplesKt.to("repeats", false), TuplesKt.to("value", Long.valueOf(this.timestamp)));
    }

    @Override // expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger
    public Date nextTriggerDate() {
        Date date = new Date();
        Date date2 = new Date(this.timestamp);
        if (date2.before(date)) {
            return null;
        }
        return date2;
    }
}
