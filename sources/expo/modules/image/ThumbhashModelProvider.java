package expo.modules.image;

import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import expo.modules.image.thumbhash.ThumbhashModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlideModelProvider.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/image/ThumbhashModelProvider;", "Lexpo/modules/image/GlideModelProvider;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "component1", "copy", "equals", "", "other", "", "getGlideModel", "Lexpo/modules/image/thumbhash/ThumbhashModel;", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThumbhashModelProvider implements GlideModelProvider {
    private final Uri uri;

    /* renamed from: component1, reason: from getter */
    private final Uri getUri() {
        return this.uri;
    }

    public static /* synthetic */ ThumbhashModelProvider copy$default(ThumbhashModelProvider thumbhashModelProvider, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = thumbhashModelProvider.uri;
        }
        return thumbhashModelProvider.copy(uri);
    }

    public final ThumbhashModelProvider copy(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new ThumbhashModelProvider(uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ThumbhashModelProvider) && Intrinsics.areEqual(this.uri, ((ThumbhashModelProvider) other).uri);
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return "ThumbhashModelProvider(uri=" + this.uri + ")";
    }

    public ThumbhashModelProvider(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    @Override // expo.modules.image.GlideModelProvider
    public ThumbhashModel getGlideModel() {
        return new ThumbhashModel(this.uri);
    }
}
