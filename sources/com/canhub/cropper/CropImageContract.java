package com.canhub.cropper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContract;
import com.canhub.cropper.CropImage;
import com.canhub.cropper.CropImageView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CropImageContract.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/canhub/cropper/CropImageContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/canhub/cropper/CropImageContractOptions;", "Lcom/canhub/cropper/CropImageView$CropResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", SDKConstants.PARAM_INTENT, "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CropImageContract extends ActivityResultContract<CropImageContractOptions, CropImageView.CropResult> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public Intent createIntent(Context context, CropImageContractOptions input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        input.getCropImageOptions().validate();
        Intent intent = new Intent(context, (Class<?>) CropImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE, input.getUri());
        bundle.putParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS, input.getCropImageOptions());
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE, bundle);
        return intent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    public CropImageView.CropResult parseResult(int resultCode, Intent intent) {
        Object parcelableExtra = intent != null ? intent.getParcelableExtra(CropImage.CROP_IMAGE_EXTRA_RESULT) : null;
        CropImage.ActivityResult activityResult = parcelableExtra instanceof CropImage.ActivityResult ? (CropImage.ActivityResult) parcelableExtra : null;
        if (activityResult == null || resultCode == 0) {
            return CropImage.CancelledResult.INSTANCE;
        }
        return activityResult;
    }
}
