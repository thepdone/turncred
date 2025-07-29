package expo.modules.imagepicker.contracts;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.imagepicker.ImagePickerOptions;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageLibraryContract.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "Ljava/io/Serializable;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/imagepicker/ImagePickerOptions;", "(Lexpo/modules/imagepicker/ImagePickerOptions;)V", "getOptions", "()Lexpo/modules/imagepicker/ImagePickerOptions;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageLibraryContractOptions implements Serializable {
    private final ImagePickerOptions options;

    public static /* synthetic */ ImageLibraryContractOptions copy$default(ImageLibraryContractOptions imageLibraryContractOptions, ImagePickerOptions imagePickerOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            imagePickerOptions = imageLibraryContractOptions.options;
        }
        return imageLibraryContractOptions.copy(imagePickerOptions);
    }

    /* renamed from: component1, reason: from getter */
    public final ImagePickerOptions getOptions() {
        return this.options;
    }

    public final ImageLibraryContractOptions copy(ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return new ImageLibraryContractOptions(options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImageLibraryContractOptions) && Intrinsics.areEqual(this.options, ((ImageLibraryContractOptions) other).options);
    }

    public int hashCode() {
        return this.options.hashCode();
    }

    public String toString() {
        return "ImageLibraryContractOptions(options=" + this.options + ")";
    }

    public ImageLibraryContractOptions(ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }
}
