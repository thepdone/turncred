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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001b"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/YearlyTrigger;", "Lexpo/modules/notifications/notifications/triggers/ChannelAwareTrigger;", "Lexpo/modules/notifications/notifications/interfaces/SchedulableNotificationTrigger;", "channelId", "", "day", "", "month", "hour", "minute", "(Ljava/lang/String;IIII)V", "getChannelId", "()Ljava/lang/String;", "getDay", "()I", "getHour", "getMinute", "getMonth", "nextTriggerDate", "Ljava/util/Date;", "toBundle", "Landroid/os/Bundle;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YearlyTrigger extends ChannelAwareTrigger implements SchedulableNotificationTrigger {
    public static final Parcelable.Creator<YearlyTrigger> CREATOR = new Creator();
    private final String channelId;
    private final int day;
    private final int hour;
    private final int minute;
    private final int month;

    /* compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<YearlyTrigger> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YearlyTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new YearlyTrigger(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YearlyTrigger[] newArray(int i) {
            return new YearlyTrigger[i];
        }
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.channelId);
        parcel.writeInt(this.day);
        parcel.writeInt(this.month);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
    }

    public YearlyTrigger(String str, int i, int i2, int i3, int i4) {
        super(str);
        this.channelId = str;
        this.day = i;
        this.month = i2;
        this.hour = i3;
        this.minute = i4;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger
    public String getChannelId() {
        return this.channelId;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getMonth() {
        return this.month;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return bundleWithChannelId(TuplesKt.to("type", "yearly"), TuplesKt.to("day", Integer.valueOf(this.day)), TuplesKt.to("month", Integer.valueOf(this.month)), TuplesKt.to("hour", Integer.valueOf(this.hour)), TuplesKt.to("minute", Integer.valueOf(this.minute)));
    }

    @Override // expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger
    public Date nextTriggerDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, this.day);
        calendar.set(2, this.month);
        calendar.set(11, this.hour);
        calendar.set(12, this.minute);
        calendar.set(13, 0);
        calendar.set(14, 0);
        if (calendar.before(Calendar.getInstance())) {
            calendar.add(1, 1);
        }
        return calendar.getTime();
    }
}
