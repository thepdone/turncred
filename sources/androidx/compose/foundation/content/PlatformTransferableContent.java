package androidx.compose.foundation.content;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransferableContent.android.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/content/PlatformTransferableContent;", "", "linkUri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "(Landroid/net/Uri;Landroid/os/Bundle;)V", "getExtras", "()Landroid/os/Bundle;", "getLinkUri", "()Landroid/net/Uri;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformTransferableContent {
    public static final int $stable = 8;
    private final Bundle extras;
    private final Uri linkUri;

    public PlatformTransferableContent(Uri uri, Bundle bundle) {
        this.linkUri = uri;
        this.extras = bundle;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformTransferableContent)) {
            return false;
        }
        PlatformTransferableContent platformTransferableContent = (PlatformTransferableContent) other;
        return Intrinsics.areEqual(this.linkUri, platformTransferableContent.linkUri) && Intrinsics.areEqual(this.extras, platformTransferableContent.extras);
    }

    public int hashCode() {
        Uri uri = this.linkUri;
        return ((uri != null ? uri.hashCode() : 0) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "PlatformTransferableContent(linkUri=" + this.linkUri + ", extras=" + this.extras + ')';
    }
}
