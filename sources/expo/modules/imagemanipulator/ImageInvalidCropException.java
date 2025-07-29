package expo.modules.imagemanipulator;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: ImageManipulatorExceptions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/imagemanipulator/ImageInvalidCropException;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageInvalidCropException extends CodedException {
    public ImageInvalidCropException() {
        super("Invalid crop options has been passed. Please make sure the requested crop rectangle is inside source image", null, 2, null);
    }
}
