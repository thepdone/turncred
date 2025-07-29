package expo.modules.notifications.notifications.triggers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationTriggers.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/DailyTrigger;", "Lexpo/modules/notifications/notifications/triggers/ChannelAwareTrigger;", "Lexpo/modules/notifications/notifications/interfaces/SchedulableNotificationTrigger;", "channelId", "", "hour", "", "minute", "(Ljava/lang/String;II)V", "getChannelId", "()Ljava/lang/String;", "getHour", "()I", "getMinute", "nextTriggerDate", "Ljava/util/Date;", "toBundle", "Landroid/os/Bundle;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DailyTrigger extends ChannelAwareTrigger implements SchedulableNotificationTrigger {
    public static final Parcelable.Creator<DailyTrigger> CREATOR = new Creator();
    private final String channelId;
    private final int hour;
    private final int minute;

    /* compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyTrigger> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DailyTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DailyTrigger(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DailyTrigger[] newArray(int i) {
            return new DailyTrigger[i];
        }
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.channelId);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
    }

    public DailyTrigger(String str, int i, int i2) {
        super(str);
        this.channelId = str;
        this.hour = i;
        this.minute = i2;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger
    public String getChannelId() {
        return this.channelId;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return bundleWithChannelId(TuplesKt.to("type", "daily"), TuplesKt.to("hour", Integer.valueOf(this.hour)), TuplesKt.to("minute", Integer.valueOf(this.minute)));
    }

    @Override // expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger
    public Date nextTriggerDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.hour);
        calendar.set(12, this.minute);
        calendar.set(13, 0);
        calendar.set(14, 0);
        if (calendar.before(Calendar.getInstance())) {
            calendar.add(5, 1);
        }
        return calendar.getTime();
    }
}
