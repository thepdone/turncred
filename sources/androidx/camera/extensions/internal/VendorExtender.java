package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface VendorExtender {
    default SessionProcessor createSessionProcessor(Context context) {
        return null;
    }

    default Range<Long> getEstimatedCaptureLatencyRange(Size size) {
        return null;
    }

    default void init(CameraInfo cameraInfo) {
    }

    default boolean isCaptureProcessProgressAvailable() {
        return false;
    }

    default boolean isCurrentExtensionModeAvailable() {
        return false;
    }

    default boolean isExtensionAvailable(String str, Map<String, CameraCharacteristics> map) {
        return false;
    }

    default boolean isExtensionStrengthAvailable() {
        return false;
    }

    default boolean isPostviewAvailable() {
        return false;
    }

    default List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions() {
        return Collections.emptyList();
    }

    default List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions() {
        return Collections.emptyList();
    }

    default Size[] getSupportedYuvAnalysisResolutions() {
        return new Size[0];
    }

    default Map<Integer, List<Size>> getSupportedPostviewResolutions(Size size) {
        return Collections.emptyMap();
    }

    default List<CaptureResult.Key> getSupportedCaptureResultKeys() {
        return Collections.emptyList();
    }

    default boolean willReceiveOnCaptureCompleted() {
        if (ClientVersion.isMaximumCompatibleVersion(Version.VERSION_1_2) || ExtensionVersion.isMaximumCompatibleVersion(Version.VERSION_1_2)) {
            return false;
        }
        return !getSupportedCaptureResultKeys().isEmpty();
    }
}
