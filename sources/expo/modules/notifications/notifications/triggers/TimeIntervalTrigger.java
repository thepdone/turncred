package expo.modules.notifications.notifications.triggers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationTriggers.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/TimeIntervalTrigger;", "Lexpo/modules/notifications/notifications/triggers/ChannelAwareTrigger;", "Lexpo/modules/notifications/notifications/interfaces/SchedulableNotificationTrigger;", "channelId", "", "timeInterval", "", "isRepeating", "", "triggerDate", "Ljava/util/Date;", "(Ljava/lang/String;JZLjava/util/Date;)V", "getChannelId", "()Ljava/lang/String;", "()Z", "getTimeInterval", "()J", "nextTriggerDate", "toBundle", "Landroid/os/Bundle;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeIntervalTrigger extends ChannelAwareTrigger implements SchedulableNotificationTrigger {
    public static final Parcelable.Creator<TimeIntervalTrigger> CREATOR = new Creator();
    private final String channelId;
    private final boolean isRepeating;
    private final long timeInterval;
    private Date triggerDate;

    /* compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimeIntervalTrigger> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeIntervalTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TimeIntervalTrigger(parcel.readString(), parcel.readLong(), parcel.readInt() != 0, (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeIntervalTrigger[] newArray(int i) {
            return new TimeIntervalTrigger[i];
        }
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.channelId);
        parcel.writeLong(this.timeInterval);
        parcel.writeInt(this.isRepeating ? 1 : 0);
        parcel.writeSerializable(this.triggerDate);
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger
    public String getChannelId() {
        return this.channelId;
    }

    public final long getTimeInterval() {
        return this.timeInterval;
    }

    /* renamed from: isRepeating, reason: from getter */
    public final boolean getIsRepeating() {
        return this.isRepeating;
    }

    public /* synthetic */ TimeIntervalTrigger(String str, long j, boolean z, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, z, (i & 8) != 0 ? new Date(new Date().getTime() + (1000 * j)) : date);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeIntervalTrigger(String str, long j, boolean z, Date triggerDate) {
        super(str);
        Intrinsics.checkNotNullParameter(triggerDate, "triggerDate");
        this.channelId = str;
        this.timeInterval = j;
        this.isRepeating = z;
        this.triggerDate = triggerDate;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return bundleWithChannelId(TuplesKt.to("type", "timeInterval"), TuplesKt.to("repeats", Boolean.valueOf(this.isRepeating)), TuplesKt.to("seconds", Long.valueOf(this.timeInterval)));
    }

    @Override // expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger
    public Date nextTriggerDate() {
        Date date = new Date();
        if (this.isRepeating) {
            while (this.triggerDate.before(date)) {
                Date date2 = this.triggerDate;
                date2.setTime(date2.getTime() + (this.timeInterval * 1000));
            }
        }
        if (this.triggerDate.before(date)) {
            return null;
        }
        return this.triggerDate;
    }
}
