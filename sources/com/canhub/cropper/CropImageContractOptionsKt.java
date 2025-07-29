package com.canhub.cropper;

import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CropImageContractOptions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/canhub/cropper/CropImageContractOptions;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "builder", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "cropper_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CropImageContractOptionsKt {
    public static /* synthetic */ CropImageContractOptions options$default(Uri uri, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        if ((i & 2) != 0) {
            function1 = new Function1<CropImageContractOptions, Unit>() { // from class: com.canhub.cropper.CropImageContractOptionsKt.options.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CropImageContractOptions cropImageContractOptions) {
                    Intrinsics.checkNotNullParameter(cropImageContractOptions, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CropImageContractOptions cropImageContractOptions) {
                    invoke2(cropImageContractOptions);
                    return Unit.INSTANCE;
                }
            };
        }
        return options(uri, function1);
    }

    public static final CropImageContractOptions options(Uri uri, Function1<? super CropImageContractOptions, Unit> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        CropImageContractOptions cropImageContractOptions = new CropImageContractOptions(uri, new CropImageOptions());
        builder.invoke(cropImageContractOptions);
        return cropImageContractOptions;
    }
}
