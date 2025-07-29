package com.canhub.cropper;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* compiled from: CropException.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00060\u0001j\u0002`\u0002:\u0004\u0006\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/canhub/cropper/CropException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "Cancellation", "Companion", "FailedToDecodeImage", "FailedToLoadBitmap", "Lcom/canhub/cropper/CropException$Cancellation;", "Lcom/canhub/cropper/CropException$FailedToDecodeImage;", "Lcom/canhub/cropper/CropException$FailedToLoadBitmap;", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public abstract class CropException extends Exception {
    public static final String EXCEPTION_PREFIX = "crop:";

    public /* synthetic */ CropException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* compiled from: CropException.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/canhub/cropper/CropException$Cancellation;", "Lcom/canhub/cropper/CropException;", "()V", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Cancellation extends CropException {
        public Cancellation() {
            super("crop: cropping has been cancelled by the user", null);
        }
    }

    private CropException(String str) {
        super(str);
    }

    /* compiled from: CropException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/canhub/cropper/CropException$FailedToLoadBitmap;", "Lcom/canhub/cropper/CropException;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "message", "", "(Landroid/net/Uri;Ljava/lang/String;)V", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FailedToLoadBitmap extends CropException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToLoadBitmap(Uri uri, String str) {
            super("crop: Failed to load sampled bitmap: " + uri + IOUtils.LINE_SEPARATOR_WINDOWS + str, null);
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }

    /* compiled from: CropException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/canhub/cropper/CropException$FailedToDecodeImage;", "Lcom/canhub/cropper/CropException;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FailedToDecodeImage extends CropException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToDecodeImage(Uri uri) {
            super("crop: Failed to decode image: " + uri, null);
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }
}
