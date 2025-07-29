package expo.modules.image.thumbhash;

import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThumbhashModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashModel;", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThumbhashModel {
    private final Uri uri;

    public static /* synthetic */ ThumbhashModel copy$default(ThumbhashModel thumbhashModel, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = thumbhashModel.uri;
        }
        return thumbhashModel.copy(uri);
    }

    /* renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    public final ThumbhashModel copy(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new ThumbhashModel(uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ThumbhashModel) && Intrinsics.areEqual(this.uri, ((ThumbhashModel) other).uri);
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return "ThumbhashModel(uri=" + this.uri + ")";
    }

    public ThumbhashModel(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
