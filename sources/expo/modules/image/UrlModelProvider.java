package expo.modules.image;

import com.bumptech.glide.load.model.GlideUrl;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.image.okhttp.GlideUrlWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlideModelProvider.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/image/UrlModelProvider;", "Lexpo/modules/image/GlideModelProvider;", "glideUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "(Lcom/bumptech/glide/load/model/GlideUrl;)V", "component1", "copy", "equals", "", "other", "", "getGlideModel", "Lexpo/modules/image/okhttp/GlideUrlWrapper;", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UrlModelProvider implements GlideModelProvider {
    private final GlideUrl glideUrl;

    /* renamed from: component1, reason: from getter */
    private final GlideUrl getGlideUrl() {
        return this.glideUrl;
    }

    public static /* synthetic */ UrlModelProvider copy$default(UrlModelProvider urlModelProvider, GlideUrl glideUrl, int i, Object obj) {
        if ((i & 1) != 0) {
            glideUrl = urlModelProvider.glideUrl;
        }
        return urlModelProvider.copy(glideUrl);
    }

    public final UrlModelProvider copy(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        return new UrlModelProvider(glideUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UrlModelProvider) && Intrinsics.areEqual(this.glideUrl, ((UrlModelProvider) other).glideUrl);
    }

    public int hashCode() {
        return this.glideUrl.hashCode();
    }

    public String toString() {
        return "UrlModelProvider(glideUrl=" + this.glideUrl + ")";
    }

    public UrlModelProvider(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        this.glideUrl = glideUrl;
    }

    @Override // expo.modules.image.GlideModelProvider
    public GlideUrlWrapper getGlideModel() {
        return new GlideUrlWrapper(this.glideUrl);
    }
}
