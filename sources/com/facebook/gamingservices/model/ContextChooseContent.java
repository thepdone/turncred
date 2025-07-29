package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextChooseContent.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\fH\u0016J\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/share/model/ShareModel;", "builder", "Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "(Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "filters", "", "", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "", "getMaxSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", SDKConstants.PARAM_CONTEXT_MIN_SIZE, "getMinSize", "describeContents", "getFilters", "writeToParcel", "", "out", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Builder", "CREATOR", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContextChooseContent implements ShareModel {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> filters;
    private final Integer maxSize;
    private final Integer minSize;

    public /* synthetic */ ContextChooseContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Integer getMaxSize() {
        return this.maxSize;
    }

    public final Integer getMinSize() {
        return this.minSize;
    }

    private ContextChooseContent(Builder builder) {
        this.filters = builder.getFilters$facebook_gamingservices_release();
        this.maxSize = builder.getMaxSize();
        this.minSize = builder.getMinSize();
    }

    public ContextChooseContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.filters = parcel.createStringArrayList();
        this.maxSize = Integer.valueOf(parcel.readInt());
        this.minSize = Integer.valueOf(parcel.readInt());
    }

    public final List<String> getFilters() {
        List<String> list = this.filters;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeStringList(this.filters);
        Integer num = this.maxSize;
        out.writeInt(num != null ? num.intValue() : 0);
        Integer num2 = this.minSize;
        out.writeInt(num2 != null ? num2.intValue() : 0);
    }

    /* compiled from: ContextChooseContent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u001a\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001cR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "()V", "filters", "", "", "getFilters$facebook_gamingservices_release", "()Ljava/util/List;", "setFilters$facebook_gamingservices_release", "(Ljava/util/List;)V", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "", "getMaxSize$facebook_gamingservices_release", "()Ljava/lang/Integer;", "setMaxSize$facebook_gamingservices_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", SDKConstants.PARAM_CONTEXT_MIN_SIZE, "getMinSize$facebook_gamingservices_release", "setMinSize$facebook_gamingservices_release", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "setFilters", "setMaxSize", "(Ljava/lang/Integer;)Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "setMinSize", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder implements ShareModelBuilder<ContextChooseContent, Builder> {
        private List<String> filters;
        private Integer maxSize;
        private Integer minSize;

        public final List<String> getFilters$facebook_gamingservices_release() {
            return this.filters;
        }

        public final void setFilters$facebook_gamingservices_release(List<String> list) {
            this.filters = list;
        }

        /* renamed from: getMaxSize$facebook_gamingservices_release, reason: from getter */
        public final Integer getMaxSize() {
            return this.maxSize;
        }

        public final void setMaxSize$facebook_gamingservices_release(Integer num) {
            this.maxSize = num;
        }

        /* renamed from: getMinSize$facebook_gamingservices_release, reason: from getter */
        public final Integer getMinSize() {
            return this.minSize;
        }

        public final void setMinSize$facebook_gamingservices_release(Integer num) {
            this.minSize = num;
        }

        public final Builder setFilters(List<String> filters) {
            this.filters = filters;
            return this;
        }

        public final Builder setMaxSize(Integer maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public final Builder setMinSize(Integer minSize) {
            this.minSize = minSize;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextChooseContent build() {
            return new ContextChooseContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextChooseContent model) {
            Builder minSize;
            return (model == null || (minSize = setFilters(model.getFilters()).setMaxSize(model.getMaxSize()).setMinSize(model.getMinSize())) == null) ? this : minSize;
        }

        public final Builder readFrom(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((ContextChooseContent) parcel.readParcelable(ContextChooseContent.class.getClassLoader()));
        }
    }

    /* compiled from: ContextChooseContent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", RRWebVideoEvent.JsonKeys.SIZE, "", "(I)[Lcom/facebook/gamingservices/model/ContextChooseContent;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.facebook.gamingservices.model.ContextChooseContent$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<ContextChooseContent> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContextChooseContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ContextChooseContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContextChooseContent[] newArray(int size) {
            return new ContextChooseContent[size];
        }
    }
}
