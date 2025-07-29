package com.mrousavy.camera.react;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CodeScannerFrame;
import com.mrousavy.camera.core.UnknownCameraError;
import com.mrousavy.camera.core.types.CodeType;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraView+Events.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a \u0010\t\u001a\u00020\u0005*\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0010\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0012\u0010\u0014\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0013\u001a\n\u0010\u0016\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0017\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u001c\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u001d\u001a\u00020\u0005*\u00020\u0006\u001a\u0018\u0010\u001e\u001a\u00020\u0005*\u00020\u00062\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0002¨\u0006!"}, d2 = {"errorToMap", "Lcom/facebook/react/bridge/WritableMap;", "error", "", "invokeOnAverageFpsChanged", "", "Lcom/mrousavy/camera/react/CameraView;", "averageFps", "", "invokeOnCodeScanned", "barcodes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "invokeOnError", "invokeOnInitialized", "invokeOnOutputOrientationChanged", "outputOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "invokeOnPreviewOrientationChanged", "previewOrientation", "invokeOnPreviewStarted", "invokeOnPreviewStopped", "invokeOnShutter", "type", "Lcom/mrousavy/camera/core/types/ShutterType;", "invokeOnStarted", "invokeOnStopped", "invokeOnViewReady", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/facebook/react/uimanager/events/Event;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView_EventsKt {
    public static final void invokeOnInitialized(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnInitialized()");
        sendEvent(cameraView, new CameraInitializedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnStarted(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnStarted()");
        sendEvent(cameraView, new CameraStartedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnStopped(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnStopped()");
        sendEvent(cameraView, new CameraStoppedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnPreviewStarted(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnPreviewStarted()");
        sendEvent(cameraView, new CameraPreviewStartedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnPreviewStopped(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnPreviewStopped()");
        sendEvent(cameraView, new CameraPreviewStoppedEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnShutter(CameraView cameraView, ShutterType type) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Log.i("CameraView", "invokeOnShutter(" + type + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", type.getUnionValue());
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraShutterEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnOutputOrientationChanged(CameraView cameraView, Orientation outputOrientation) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Log.i("CameraView", "invokeOnOutputOrientationChanged(" + outputOrientation + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("outputOrientation", outputOrientation.getUnionValue());
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraOutputOrientationChangedEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnPreviewOrientationChanged(CameraView cameraView, Orientation previewOrientation) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(previewOrientation, "previewOrientation");
        Log.i("CameraView", "invokeOnPreviewOrientationChanged(" + previewOrientation + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("previewOrientation", previewOrientation.getUnionValue());
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraPreviewOrientationChangedEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnError(CameraView cameraView, Throwable error) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("CameraView", "invokeOnError(...):");
        error.printStackTrace();
        UnknownCameraError unknownCameraError = error instanceof CameraError ? (CameraError) error : new UnknownCameraError(error);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("code", unknownCameraError.getCode());
        writableMapCreateMap.putString("message", unknownCameraError.getMessage());
        Throwable cause = unknownCameraError.getCause();
        if (cause != null) {
            writableMapCreateMap.putMap("cause", errorToMap(cause));
        }
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new CameraErrorEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnViewReady(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        sendEvent(cameraView, new CameraViewReadyEvent(UIManagerHelper.getSurfaceId(cameraView), cameraView.getId()));
    }

    public static final void invokeOnAverageFpsChanged(CameraView cameraView, double d) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Log.i("CameraView", "invokeOnAverageFpsChanged(" + d + ")");
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("averageFps", d);
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap);
        sendEvent(cameraView, new AverageFpsChangedEvent(surfaceId, id, writableMapCreateMap));
    }

    public static final void invokeOnCodeScanned(CameraView cameraView, List<? extends Barcode> barcodes, CodeScannerFrame scannerFrame) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(barcodes, "barcodes");
        Intrinsics.checkNotNullParameter(scannerFrame, "scannerFrame");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (Barcode barcode : barcodes) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", CodeType.INSTANCE.fromBarcodeType(barcode.getFormat()).getUnionValue());
            writableMapCreateMap.putString("value", barcode.getRawValue());
            Rect boundingBox = barcode.getBoundingBox();
            if (boundingBox != null) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putInt("x", boundingBox.left);
                writableMapCreateMap2.putInt("y", boundingBox.top);
                writableMapCreateMap2.putInt("width", boundingBox.right - boundingBox.left);
                writableMapCreateMap2.putInt("height", boundingBox.bottom - boundingBox.top);
                writableMapCreateMap.putMap("frame", writableMapCreateMap2);
            }
            Point[] cornerPoints = barcode.getCornerPoints();
            if (cornerPoints != null) {
                WritableArray writableArrayCreateArray2 = Arguments.createArray();
                Intrinsics.checkNotNull(cornerPoints);
                for (Point point : cornerPoints) {
                    WritableMap writableMapCreateMap3 = Arguments.createMap();
                    writableMapCreateMap3.putInt("x", point.x);
                    writableMapCreateMap3.putInt("y", point.y);
                    writableArrayCreateArray2.pushMap(writableMapCreateMap3);
                }
                writableMapCreateMap.putArray("corners", writableArrayCreateArray2);
            }
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putArray("codes", writableArrayCreateArray);
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        writableMapCreateMap5.putInt("width", scannerFrame.getWidth());
        writableMapCreateMap5.putInt("height", scannerFrame.getHeight());
        writableMapCreateMap4.putMap("frame", writableMapCreateMap5);
        int surfaceId = UIManagerHelper.getSurfaceId(cameraView);
        int id = cameraView.getId();
        Intrinsics.checkNotNull(writableMapCreateMap4);
        sendEvent(cameraView, new CameraCodeScannedEvent(surfaceId, id, writableMapCreateMap4));
    }

    private static final void sendEvent(CameraView cameraView, Event<?> event) {
        Context context = cameraView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, cameraView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(event);
        }
    }

    private static final WritableMap errorToMap(Throwable th) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("message", th.getMessage());
        writableMapCreateMap.putString("stacktrace", ExceptionsKt.stackTraceToString(th));
        Throwable cause = th.getCause();
        if (cause != null) {
            writableMapCreateMap.putMap("cause", errorToMap(cause));
        }
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
