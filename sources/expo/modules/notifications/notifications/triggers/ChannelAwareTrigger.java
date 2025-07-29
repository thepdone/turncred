package expo.modules.notifications.notifications.triggers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* compiled from: NotificationTriggers.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J=\u0010\b\u001a\u00020\t2.\u0010\n\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u000b\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0004¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/ChannelAwareTrigger;", "Lexpo/modules/notifications/notifications/interfaces/NotificationTrigger;", "Ljava/io/Serializable;", "channelId", "", "(Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "bundleWithChannelId", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "describeContents", "", "getNotificationChannel", "toBundle", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ChannelAwareTrigger implements NotificationTrigger, Serializable {
    public static final Parcelable.Creator<ChannelAwareTrigger> CREATOR = new Creator();
    private final String channelId;

    /* compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChannelAwareTrigger> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChannelAwareTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChannelAwareTrigger(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChannelAwareTrigger[] newArray(int i) {
            return new ChannelAwareTrigger[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.channelId);
    }

    public ChannelAwareTrigger(String str) {
        this.channelId = str;
    }

    public String getChannelId() {
        return this.channelId;
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public String getNotificationChannel() {
        return getChannelId();
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return bundleWithChannelId(new Pair[0]);
    }

    protected final Bundle bundleWithChannelId(Pair<String, ? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.to("channelId", getChannelId()));
        spreadBuilder.addSpread(pairs);
        return BundleKt.bundleOf((Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }
}
