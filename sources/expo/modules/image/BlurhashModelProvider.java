package expo.modules.image;

import android.net.Uri;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import expo.modules.image.blurhash.BlurhashModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlideModelProvider.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\t\u0010\t\u001a\u00020\u0005HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÂ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/image/BlurhashModelProvider;", "Lexpo/modules/image/GlideModelProvider;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "width", "", "height", "(Landroid/net/Uri;II)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getGlideModel", "Lexpo/modules/image/blurhash/BlurhashModel;", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BlurhashModelProvider implements GlideModelProvider {
    private final int height;
    private final Uri uri;
    private final int width;

    /* renamed from: component1, reason: from getter */
    private final Uri getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    private final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    private final int getHeight() {
        return this.height;
    }

    public static /* synthetic */ BlurhashModelProvider copy$default(BlurhashModelProvider blurhashModelProvider, Uri uri, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uri = blurhashModelProvider.uri;
        }
        if ((i3 & 2) != 0) {
            i = blurhashModelProvider.width;
        }
        if ((i3 & 4) != 0) {
            i2 = blurhashModelProvider.height;
        }
        return blurhashModelProvider.copy(uri, i, i2);
    }

    public final BlurhashModelProvider copy(Uri uri, int width, int height) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new BlurhashModelProvider(uri, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurhashModelProvider)) {
            return false;
        }
        BlurhashModelProvider blurhashModelProvider = (BlurhashModelProvider) other;
        return Intrinsics.areEqual(this.uri, blurhashModelProvider.uri) && this.width == blurhashModelProvider.width && this.height == blurhashModelProvider.height;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "BlurhashModelProvider(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public BlurhashModelProvider(Uri uri, int i, int i2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    @Override // expo.modules.image.GlideModelProvider
    public BlurhashModel getGlideModel() {
        return new BlurhashModel(this.uri, this.width, this.height);
    }
}
