package expo.modules.imagemanipulator.transformers;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: ImageTransformer.kt */
@FunctionalInterface
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lexpo/modules/imagemanipulator/transformers/ImageTransformer;", "", ViewProps.TRANSFORM, "Landroid/graphics/Bitmap;", "bitmap", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ImageTransformer {
    Bitmap transform(Bitmap bitmap);
}
