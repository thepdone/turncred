package com.mrousavy.camera.react;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.view.PreviewView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.SnapshotFailedError;
import com.mrousavy.camera.core.SnapshotFailedPreviewNotEnabledError;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.core.types.TakeSnapshotOptions;
import com.mrousavy.camera.core.utils.FileUtils;
import io.sentry.protocol.Device;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraView+TakeSnapshot.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "takeSnapshot", "Lcom/facebook/react/bridge/WritableMap;", "Lcom/mrousavy/camera/react/CameraView;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/mrousavy/camera/core/types/TakeSnapshotOptions;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView_TakeSnapshotKt {
    private static final String TAG = "CameraView.takeSnapshot";

    public static final WritableMap takeSnapshot(CameraView cameraView, TakeSnapshotOptions options) throws SnapshotFailedError, SnapshotFailedPreviewNotEnabledError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Log.i(TAG, "Capturing snapshot of Camera View...");
        PreviewView previewView = cameraView.getPreviewView();
        if (previewView == null) {
            throw new SnapshotFailedPreviewNotEnabledError();
        }
        Bitmap bitmap = previewView.getBitmap();
        if (bitmap == null) {
            throw new SnapshotFailedError();
        }
        cameraView.onShutter(ShutterType.SNAPSHOT);
        FileUtils.Companion companion = FileUtils.INSTANCE;
        File file = options.getFile().getFile();
        Intrinsics.checkNotNullExpressionValue(file, "<get-file>(...)");
        companion.writeBitmapTofile(bitmap, file, options.getQuality());
        Log.i(TAG, "Successfully saved snapshot to file!");
        Orientation outputOrientation = cameraView.getCameraSession().getOutputOrientation();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("path", options.getFile().getFile().getAbsolutePath());
        writableMapCreateMap.putInt("width", bitmap.getWidth());
        writableMapCreateMap.putInt("height", bitmap.getHeight());
        writableMapCreateMap.putString(Device.JsonKeys.ORIENTATION, outputOrientation.getUnionValue());
        writableMapCreateMap.putBoolean("isMirrored", false);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
