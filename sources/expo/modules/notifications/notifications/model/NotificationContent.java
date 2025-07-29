package expo.modules.notifications.notifications.model;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.coroutines.Continuation;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class NotificationContent implements Parcelable, Serializable, INotificationContent {
    public static final Parcelable.Creator<NotificationContent> CREATOR = new Parcelable.Creator<NotificationContent>() { // from class: expo.modules.notifications.notifications.model.NotificationContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationContent createFromParcel(Parcel parcel) {
            return new NotificationContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationContent[] newArray(int i) {
            return new NotificationContent[i];
        }
    };
    private static final long serialVersionUID = 397666843266836802L;
    private boolean mAutoDismiss;
    private Number mBadgeCount;
    private JSONObject mBody;
    private String mCategoryId;
    private Number mColor;
    private NotificationPriority mPriority;
    private boolean mShouldPlayDefaultSound;
    private boolean mShouldUseDefaultVibrationPattern;
    private Uri mSound;
    private boolean mSticky;
    private String mSubtitle;
    private String mText;
    private String mTitle;
    private long[] mVibrationPattern;

    private void readObjectNoData() throws ObjectStreamException {
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean containsImage() {
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected NotificationContent() {
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getTitle() {
        return this.mTitle;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getText() {
        return this.mText;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getSubText() {
        return this.mSubtitle;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public Number getBadgeCount() {
        return this.mBadgeCount;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean getShouldPlayDefaultSound() {
        return this.mShouldPlayDefaultSound;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean getShouldUseDefaultVibrationPattern() {
        return this.mShouldUseDefaultVibrationPattern;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getSoundName() {
        Uri uri = this.mSound;
        if (uri != null) {
            return uri.getLastPathSegment();
        }
        return null;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public Object getImage(Context context, Continuation<? super Bitmap> continuation) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!applicationInfo.metaData.containsKey(ExpoNotificationBuilder.META_DATA_LARGE_ICON_KEY)) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(), applicationInfo.metaData.getInt(ExpoNotificationBuilder.META_DATA_LARGE_ICON_KEY));
        } catch (PackageManager.NameNotFoundException | ClassCastException e) {
            Log.e("expo-notifications", "Could not have fetched large notification icon.", e);
            return null;
        }
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public JSONObject getBody() {
        return this.mBody;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public NotificationPriority getPriority() {
        return this.mPriority;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public Number getColor() {
        return this.mColor;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean isAutoDismiss() {
        return this.mAutoDismiss;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getCategoryId() {
        return this.mCategoryId;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean isSticky() {
        return this.mSticky;
    }

    protected NotificationContent(Parcel parcel) {
        this.mTitle = parcel.readString();
        this.mText = parcel.readString();
        this.mSubtitle = parcel.readString();
        this.mBadgeCount = (Number) parcel.readSerializable();
        this.mShouldPlayDefaultSound = parcel.readByte() != 0;
        this.mSound = (Uri) parcel.readParcelable(getClass().getClassLoader());
        this.mShouldUseDefaultVibrationPattern = parcel.readByte() != 0;
        this.mVibrationPattern = parcel.createLongArray();
        try {
            this.mBody = new JSONObject(parcel.readString());
        } catch (NullPointerException | JSONException unused) {
        }
        Number number = (Number) parcel.readSerializable();
        if (number != null) {
            this.mPriority = NotificationPriority.fromNativeValue(number.intValue());
        }
        this.mColor = (Number) parcel.readSerializable();
        this.mAutoDismiss = parcel.readByte() == 1;
        this.mCategoryId = parcel.readString();
        this.mSticky = parcel.readByte() == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mText);
        parcel.writeString(this.mSubtitle);
        parcel.writeSerializable(this.mBadgeCount);
        parcel.writeByte(this.mShouldPlayDefaultSound ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mSound, 0);
        parcel.writeByte(this.mShouldUseDefaultVibrationPattern ? (byte) 1 : (byte) 0);
        parcel.writeLongArray(this.mVibrationPattern);
        JSONObject jSONObject = this.mBody;
        parcel.writeString(jSONObject != null ? jSONObject.toString() : null);
        NotificationPriority notificationPriority = this.mPriority;
        parcel.writeSerializable(notificationPriority != null ? Integer.valueOf(notificationPriority.getNativeValue()) : null);
        parcel.writeSerializable(this.mColor);
        parcel.writeByte(this.mAutoDismiss ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mCategoryId);
        parcel.writeByte(this.mSticky ? (byte) 1 : (byte) 0);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.mTitle);
        objectOutputStream.writeObject(this.mText);
        objectOutputStream.writeObject(this.mSubtitle);
        objectOutputStream.writeObject(this.mBadgeCount);
        objectOutputStream.writeByte(this.mShouldPlayDefaultSound ? 1 : 0);
        Uri uri = this.mSound;
        objectOutputStream.writeObject(uri == null ? null : uri.toString());
        objectOutputStream.writeByte(this.mShouldUseDefaultVibrationPattern ? 1 : 0);
        long[] jArr = this.mVibrationPattern;
        if (jArr == null) {
            objectOutputStream.writeInt(-1);
        } else {
            objectOutputStream.writeInt(jArr.length);
            for (long j : this.mVibrationPattern) {
                objectOutputStream.writeLong(j);
            }
        }
        JSONObject jSONObject = this.mBody;
        objectOutputStream.writeObject(jSONObject != null ? jSONObject.toString() : null);
        NotificationPriority notificationPriority = this.mPriority;
        objectOutputStream.writeObject(notificationPriority != null ? Integer.valueOf(notificationPriority.getNativeValue()) : null);
        objectOutputStream.writeObject(this.mColor);
        objectOutputStream.writeByte(this.mAutoDismiss ? 1 : 0);
        String str = this.mCategoryId;
        objectOutputStream.writeObject(str != null ? str.toString() : null);
        objectOutputStream.writeByte(this.mSticky ? 1 : 0);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.mTitle = (String) objectInputStream.readObject();
        this.mText = (String) objectInputStream.readObject();
        this.mSubtitle = (String) objectInputStream.readObject();
        this.mBadgeCount = (Number) objectInputStream.readObject();
        this.mShouldPlayDefaultSound = objectInputStream.readByte() == 1;
        String str = (String) objectInputStream.readObject();
        if (str == null) {
            this.mSound = null;
        } else {
            this.mSound = Uri.parse(str);
        }
        this.mShouldUseDefaultVibrationPattern = objectInputStream.readByte() == 1;
        int i = objectInputStream.readInt();
        if (i < 0) {
            this.mVibrationPattern = null;
        } else {
            this.mVibrationPattern = new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.mVibrationPattern[i2] = objectInputStream.readLong();
            }
        }
        String str2 = (String) objectInputStream.readObject();
        if (str2 == null) {
            this.mBody = null;
        } else {
            try {
                this.mBody = new JSONObject(str2);
            } catch (NullPointerException | JSONException unused) {
            }
        }
        Number number = (Number) objectInputStream.readObject();
        if (number != null) {
            this.mPriority = NotificationPriority.fromNativeValue(number.intValue());
        }
        this.mColor = (Number) objectInputStream.readObject();
        this.mAutoDismiss = objectInputStream.readByte() == 1;
        String str3 = (String) objectInputStream.readObject();
        if (str3 == null) {
            this.mCategoryId = null;
        } else {
            this.mCategoryId = new String(str3);
        }
        this.mSticky = objectInputStream.readByte() == 1;
    }

    public static class Builder {
        private final NotificationContent content = new NotificationContent();

        public Builder() {
            useDefaultSound();
            useDefaultVibrationPattern();
        }

        public Builder setTitle(String str) {
            this.content.mTitle = str;
            return this;
        }

        public Builder setSubtitle(String str) {
            this.content.mSubtitle = str;
            return this;
        }

        public Builder setText(String str) {
            this.content.mText = str;
            return this;
        }

        public Builder setBody(JSONObject jSONObject) {
            this.content.mBody = jSONObject;
            return this;
        }

        public Builder setPriority(NotificationPriority notificationPriority) {
            this.content.mPriority = notificationPriority;
            return this;
        }

        public Builder setBadgeCount(Number number) {
            this.content.mBadgeCount = number;
            return this;
        }

        public Builder useDefaultVibrationPattern() {
            this.content.mShouldUseDefaultVibrationPattern = true;
            this.content.mVibrationPattern = null;
            return this;
        }

        Builder disableVibrations() {
            this.content.mShouldUseDefaultVibrationPattern = false;
            this.content.mVibrationPattern = null;
            return this;
        }

        public Builder setVibrationPattern(long[] jArr) {
            this.content.mShouldUseDefaultVibrationPattern = false;
            this.content.mVibrationPattern = jArr;
            return this;
        }

        public Builder useDefaultSound() {
            this.content.mShouldPlayDefaultSound = true;
            this.content.mSound = null;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.content.mShouldPlayDefaultSound = false;
            this.content.mSound = uri;
            return this;
        }

        public Builder setColor(Number number) {
            this.content.mColor = number;
            return this;
        }

        public Builder setAutoDismiss(boolean z) {
            this.content.mAutoDismiss = z;
            return this;
        }

        public Builder setCategoryId(String str) {
            this.content.mCategoryId = str;
            return this;
        }

        public Builder setSticky(boolean z) {
            this.content.mSticky = z;
            return this;
        }

        public NotificationContent build() {
            return this.content;
        }
    }
}
