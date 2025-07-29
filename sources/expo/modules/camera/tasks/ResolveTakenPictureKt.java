package expo.modules.camera.tasks;

import io.sentry.protocol.Device;
import kotlin.Metadata;

/* compiled from: ResolveTakenPicture.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"BASE64_KEY", "", "DATA_KEY", "DIRECTORY_NAME", "DIRECTORY_NOT_FOUND_MSG", "ERROR_TAG", "EXIF_KEY", "EXTENSION", "HEIGHT_KEY", "ID_KEY", "OUT_OF_MEMORY_EXCEPTION_MSG", "OUT_OF_MEMORY_TAG", "PARAMETER_EXCEPTION_MSG", "UNKNOWN_EXCEPTION_MSG", "UNKNOWN_IO_EXCEPTION_MSG", "URI_KEY", "WIDTH_KEY", "getMirroredOrientation", "", Device.JsonKeys.ORIENTATION, "expo-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResolveTakenPictureKt {
    private static final String BASE64_KEY = "base64";
    private static final String DATA_KEY = "data";
    private static final String DIRECTORY_NAME = "Camera";
    private static final String DIRECTORY_NOT_FOUND_MSG = "Documents directory of the app could not be found.";
    private static final String ERROR_TAG = "E_TAKING_PICTURE_FAILED";
    private static final String EXIF_KEY = "exif";
    private static final String EXTENSION = ".jpg";
    private static final String HEIGHT_KEY = "height";
    private static final String ID_KEY = "id";
    private static final String OUT_OF_MEMORY_EXCEPTION_MSG = "Cannot allocate enough space to process the taken picture.";
    private static final String OUT_OF_MEMORY_TAG = "ERR_CAMERA_OUT_OF_MEMORY";
    private static final String PARAMETER_EXCEPTION_MSG = "An incompatible parameter has been passed in. ";
    private static final String UNKNOWN_EXCEPTION_MSG = "An unknown exception has occurred.";
    private static final String UNKNOWN_IO_EXCEPTION_MSG = "An unknown I/O exception has occurred.";
    private static final String URI_KEY = "uri";
    private static final String WIDTH_KEY = "width";

    public static final int getMirroredOrientation(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 6;
            case 6:
                return 5;
            case 7:
                return 8;
            case 8:
                return 7;
            default:
                return 0;
        }
    }
}
