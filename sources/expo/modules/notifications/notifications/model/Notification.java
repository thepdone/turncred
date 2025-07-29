package expo.modules.notifications.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes5.dex */
public class Notification implements Parcelable {
    public static final Parcelable.Creator<Notification> CREATOR = new Parcelable.Creator<Notification>() { // from class: expo.modules.notifications.notifications.model.Notification.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Notification createFromParcel(Parcel parcel) {
            return new Notification(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Notification[] newArray(int i) {
            return new Notification[i];
        }
    };
    private Date mOriginDate;
    private NotificationRequest mRequest;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Notification(NotificationRequest notificationRequest) {
        this(notificationRequest, new Date());
    }

    public Notification(NotificationRequest notificationRequest, Date date) {
        this.mRequest = notificationRequest;
        this.mOriginDate = date;
    }

    protected Notification(Parcel parcel) {
        this.mRequest = (NotificationRequest) parcel.readParcelable(getClass().getClassLoader());
        this.mOriginDate = new Date(parcel.readLong());
    }

    public Date getOriginDate() {
        return this.mOriginDate;
    }

    public NotificationRequest getNotificationRequest() {
        return this.mRequest;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mRequest, 0);
        parcel.writeLong(this.mOriginDate.getTime());
    }
}
