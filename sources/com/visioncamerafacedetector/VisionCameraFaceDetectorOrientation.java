package com.visioncamerafacedetector;

import android.content.Context;
import android.view.OrientationEventListener;
import io.sentry.protocol.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisionCameraFaceDetectorOrientation.kt */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0004J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/visioncamerafacedetector/VisionCameraFaceDetectorOrientation;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Device.JsonKeys.ORIENTATION, "", "getOrientation", "()I", "setOrientation", "(I)V", "orientationListener", "com/visioncamerafacedetector/VisionCameraFaceDetectorOrientation$orientationListener$1", "Lcom/visioncamerafacedetector/VisionCameraFaceDetectorOrientation$orientationListener$1;", "degreesToSurfaceRotation", "degrees", "finalize", "", "startDeviceOrientationListener", "stopDeviceOrientationListener", "react-native-vision-camera-face-detector_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VisionCameraFaceDetectorOrientation {
    private final Context context;
    private int orientation;
    private final VisionCameraFaceDetectorOrientation$orientationListener$1 orientationListener;

    /* JADX INFO: Access modifiers changed from: private */
    public final int degreesToSurfaceRotation(int degrees) {
        if (45 <= degrees && degrees < 136) {
            return 3;
        }
        if (135 > degrees || degrees >= 226) {
            return (225 > degrees || degrees >= 316) ? 0 : 1;
        }
        return 2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.visioncamerafacedetector.VisionCameraFaceDetectorOrientation$orientationListener$1] */
    public VisionCameraFaceDetectorOrientation(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.orientationListener = new OrientationEventListener(context) { // from class: com.visioncamerafacedetector.VisionCameraFaceDetectorOrientation$orientationListener$1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int rotationDegrees) {
                VisionCameraFaceDetectorOrientation visionCameraFaceDetectorOrientation = this.this$0;
                visionCameraFaceDetectorOrientation.setOrientation(visionCameraFaceDetectorOrientation.degreesToSurfaceRotation(rotationDegrees));
            }
        };
        this.orientation = 0;
        startDeviceOrientationListener();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(int i) {
        this.orientation = i;
    }

    protected final void finalize() {
        stopDeviceOrientationListener();
    }

    private final void startDeviceOrientationListener() {
        stopDeviceOrientationListener();
        if (canDetectOrientation()) {
            enable();
        }
    }

    private final void stopDeviceOrientationListener() {
        disable();
    }
}
