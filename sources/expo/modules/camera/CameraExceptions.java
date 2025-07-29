package expo.modules.camera;

import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraExceptions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lexpo/modules/camera/CameraExceptions;", "", "()V", "ImageCaptureFailed", "ImageRetrievalException", "UnsupportedAspectRatioException", "VideoRecordingFailed", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraExceptions {

    /* compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/camera/CameraExceptions$ImageCaptureFailed;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ImageCaptureFailed extends CodedException {
        public ImageCaptureFailed() {
            super("Failed to capture image", null, 2, null);
        }
    }

    /* compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/camera/CameraExceptions$VideoRecordingFailed;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "", "(Ljava/lang/String;)V", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VideoRecordingFailed extends CodedException {
        public VideoRecordingFailed(String str) {
            super("Video recording failed: " + str, null, 2, null);
        }
    }

    /* compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/camera/CameraExceptions$ImageRetrievalException;", "Lexpo/modules/kotlin/exception/CodedException;", "url", "", "(Ljava/lang/String;)V", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ImageRetrievalException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageRetrievalException(String url) {
            super("Could not get the image from given url: '" + url + "'", null, 2, null);
            Intrinsics.checkNotNullParameter(url, "url");
        }
    }

    /* compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/camera/CameraExceptions$UnsupportedAspectRatioException;", "Lexpo/modules/kotlin/exception/CodedException;", ViewProps.ASPECT_RATIO, "", "(Ljava/lang/String;)V", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnsupportedAspectRatioException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedAspectRatioException(String aspectRatio) {
            super("Unsupported aspect ratio: '" + aspectRatio + "'", null, 2, null);
            Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        }
    }
}
