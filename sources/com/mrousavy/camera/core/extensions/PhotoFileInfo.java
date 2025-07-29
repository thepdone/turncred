package com.mrousavy.camera.core.extensions;

import androidx.camera.core.ImageCapture;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageCapture+takePicture.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/mrousavy/camera/core/extensions/PhotoFileInfo;", "", ShareConstants.MEDIA_URI, "Ljava/net/URI;", "metadata", "Landroidx/camera/core/ImageCapture$Metadata;", "(Ljava/net/URI;Landroidx/camera/core/ImageCapture$Metadata;)V", "getMetadata", "()Landroidx/camera/core/ImageCapture$Metadata;", "getUri", "()Ljava/net/URI;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PhotoFileInfo {
    private final ImageCapture.Metadata metadata;
    private final URI uri;

    public static /* synthetic */ PhotoFileInfo copy$default(PhotoFileInfo photoFileInfo, URI uri, ImageCapture.Metadata metadata, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = photoFileInfo.uri;
        }
        if ((i & 2) != 0) {
            metadata = photoFileInfo.metadata;
        }
        return photoFileInfo.copy(uri, metadata);
    }

    /* renamed from: component1, reason: from getter */
    public final URI getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final ImageCapture.Metadata getMetadata() {
        return this.metadata;
    }

    public final PhotoFileInfo copy(URI uri, ImageCapture.Metadata metadata) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new PhotoFileInfo(uri, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhotoFileInfo)) {
            return false;
        }
        PhotoFileInfo photoFileInfo = (PhotoFileInfo) other;
        return Intrinsics.areEqual(this.uri, photoFileInfo.uri) && Intrinsics.areEqual(this.metadata, photoFileInfo.metadata);
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "PhotoFileInfo(uri=" + this.uri + ", metadata=" + this.metadata + ")";
    }

    public PhotoFileInfo(URI uri, ImageCapture.Metadata metadata) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.uri = uri;
        this.metadata = metadata;
    }

    public final ImageCapture.Metadata getMetadata() {
        return this.metadata;
    }

    public final URI getUri() {
        return this.uri;
    }
}
