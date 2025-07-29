package expo.modules.image.blurhash;

import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlurhashModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashModel;", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "width", "", "height", "(Landroid/net/Uri;II)V", "getHeight", "()I", "getUri", "()Landroid/net/Uri;", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BlurhashModel {
    private final int height;
    private final Uri uri;
    private final int width;

    public static /* synthetic */ BlurhashModel copy$default(BlurhashModel blurhashModel, Uri uri, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uri = blurhashModel.uri;
        }
        if ((i3 & 2) != 0) {
            i = blurhashModel.width;
        }
        if ((i3 & 4) != 0) {
            i2 = blurhashModel.height;
        }
        return blurhashModel.copy(uri, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final BlurhashModel copy(Uri uri, int width, int height) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new BlurhashModel(uri, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurhashModel)) {
            return false;
        }
        BlurhashModel blurhashModel = (BlurhashModel) other;
        return Intrinsics.areEqual(this.uri, blurhashModel.uri) && this.width == blurhashModel.width && this.height == blurhashModel.height;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "BlurhashModel(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public BlurhashModel(Uri uri, int i, int i2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
