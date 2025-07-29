package expo.modules.imagemanipulator.transformers;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.imagemanipulator.ResizeOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResizeTransformer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lexpo/modules/imagemanipulator/transformers/ResizeTransformer;", "Lexpo/modules/imagemanipulator/transformers/ImageTransformer;", "resizeOptions", "Lexpo/modules/imagemanipulator/ResizeOptions;", "(Lexpo/modules/imagemanipulator/ResizeOptions;)V", ViewProps.TRANSFORM, "Landroid/graphics/Bitmap;", "bitmap", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResizeTransformer implements ImageTransformer {
    private final ResizeOptions resizeOptions;

    public ResizeTransformer(ResizeOptions resizeOptions) {
        Intrinsics.checkNotNullParameter(resizeOptions, "resizeOptions");
        this.resizeOptions = resizeOptions;
    }

    @Override // expo.modules.imagemanipulator.transformers.ImageTransformer
    public Bitmap transform(Bitmap bitmap) {
        int iIntValue;
        int iIntValue2;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        double width = bitmap.getWidth() / bitmap.getHeight();
        if (this.resizeOptions.getWidth() != null) {
            iIntValue = this.resizeOptions.getWidth().intValue();
            iIntValue2 = (int) (this.resizeOptions.getWidth().intValue() / width);
        } else {
            iIntValue = 0;
            iIntValue2 = 0;
        }
        if (this.resizeOptions.getHeight() != null) {
            iIntValue2 = this.resizeOptions.getHeight().intValue();
            if (iIntValue == 0) {
                iIntValue = (int) (this.resizeOptions.getHeight().intValue() * width);
            }
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iIntValue, iIntValue2, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }
}
