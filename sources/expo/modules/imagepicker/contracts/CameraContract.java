package expo.modules.imagepicker.contracts;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.imagepicker.CameraType;
import expo.modules.imagepicker.ImagePickerUtilsKt;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import expo.modules.kotlin.providers.AppContextProvider;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraContract.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lexpo/modules/imagepicker/contracts/CameraContract;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", SDKConstants.PARAM_INTENT, "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraContract implements AppContextActivityResultContract<CameraContractOptions, ImagePickerContractResult> {
    private final AppContextProvider appContextProvider;

    public CameraContract(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final ContentResolver getContentResolver() {
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext == null) {
            throw new IllegalArgumentException("React Application Context is null".toString());
        }
        ContentResolver contentResolver = reactContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        return contentResolver;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, CameraContractOptions input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intentPutExtra = new Intent(input.getOptions().getNativeMediaTypes().toCameraIntentAction()).putExtra("output", Uri.parse(input.getUri()));
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        if (Intrinsics.areEqual(input.getOptions().getNativeMediaTypes().toCameraIntentAction(), "android.media.action.VIDEO_CAPTURE")) {
            intentPutExtra.putExtra("android.intent.extra.durationLimit", input.getOptions().getVideoMaxDuration());
        }
        if (input.getOptions().getCameraType() == CameraType.FRONT) {
            intentPutExtra.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
            intentPutExtra.putExtra("android.intent.extras.CAMERA_FACING", 1);
            intentPutExtra.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        } else {
            intentPutExtra.putExtra("android.intent.extras.LENS_FACING_BACK", 1);
            intentPutExtra.putExtra("android.intent.extras.CAMERA_FACING", 0);
            intentPutExtra.putExtra("android.intent.extra.USE_FRONT_CAMERA", false);
        }
        return intentPutExtra;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public ImagePickerContractResult parseResult(CameraContractOptions input, int resultCode, Intent intent) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (resultCode == 0) {
            return ImagePickerContractResult.Cancelled.INSTANCE;
        }
        Uri uri = Uri.parse(input.getUri());
        Intrinsics.checkNotNull(uri);
        return new ImagePickerContractResult.Success(CollectionsKt.listOf(TuplesKt.to(ImagePickerUtilsKt.toMediaType(uri, getContentResolver()), uri)));
    }
}
