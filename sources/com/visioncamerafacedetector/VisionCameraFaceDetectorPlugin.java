package com.visioncamerafacedetector;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import com.caverock.androidsvg.SVGParser;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceContour;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.FaceLandmark;
import com.mrousavy.camera.core.FrameInvalidError;
import com.mrousavy.camera.core.types.Position;
import com.mrousavy.camera.frameprocessors.Frame;
import com.mrousavy.camera.frameprocessors.FrameProcessorPlugin;
import com.mrousavy.camera.frameprocessors.VisionCameraProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisionCameraFaceDetectorPlugin.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ&\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J<\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0002J,\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0002J,\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/visioncamerafacedetector/VisionCameraFaceDetectorPlugin;", "Lcom/mrousavy/camera/frameprocessors/FrameProcessorPlugin;", "proxy", "Lcom/mrousavy/camera/frameprocessors/VisionCameraProxy;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "", "", "(Lcom/mrousavy/camera/frameprocessors/VisionCameraProxy;Ljava/util/Map;)V", "autoMode", "", "cameraFacing", "Lcom/mrousavy/camera/core/types/Position;", "faceDetector", "Lcom/google/mlkit/vision/face/FaceDetector;", "orientationManager", "Lcom/visioncamerafacedetector/VisionCameraFaceDetectorOrientation;", "runClassifications", "runContours", "runLandmarks", "trackingEnabled", "windowHeight", "", "windowWidth", "callback", "frame", "Lcom/mrousavy/camera/frameprocessors/Frame;", "params", "getImageOrientation", "", "processBoundingBox", "boundingBox", "Landroid/graphics/Rect;", "sourceWidth", "sourceHeight", ViewProps.SCALE_X, ViewProps.SCALE_Y, "processFaceContours", OptionalModuleUtils.FACE, "Lcom/google/mlkit/vision/face/Face;", "processLandmarks", "react-native-vision-camera-face-detector_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VisionCameraFaceDetectorPlugin extends FrameProcessorPlugin {
    private boolean autoMode;
    private Position cameraFacing;
    private FaceDetector faceDetector;
    private final VisionCameraFaceDetectorOrientation orientationManager;
    private boolean runClassifications;
    private boolean runContours;
    private boolean runLandmarks;
    private boolean trackingEnabled;
    private double windowHeight;
    private double windowWidth;

    public VisionCameraFaceDetectorPlugin(VisionCameraProxy proxy, Map<String, ? extends Object> map) {
        int i;
        int i2;
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Object objValueOf = Double.valueOf(1.0d);
        this.windowWidth = 1.0d;
        this.windowHeight = 1.0d;
        this.cameraFacing = Position.FRONT;
        this.orientationManager = new VisionCameraFaceDetectorOrientation(proxy.getReactContext());
        this.autoMode = Intrinsics.areEqual(String.valueOf(map != null ? map.get("autoMode") : null), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        this.windowWidth = ((Double) ((map == null || (obj3 = map.get("windowWidth")) == null) ? objValueOf : obj3)).doubleValue();
        if (map != null && (obj2 = map.get("windowHeight")) != null) {
            objValueOf = obj2;
        }
        this.windowHeight = ((Double) objValueOf).doubleValue();
        if (Intrinsics.areEqual(String.valueOf(map != null ? map.get("cameraFacing") : null), "back")) {
            this.cameraFacing = Position.BACK;
        }
        int i3 = 2;
        int i4 = Intrinsics.areEqual(String.valueOf(map != null ? map.get("performanceMode") : null), "accurate") ? 2 : 1;
        if (Intrinsics.areEqual(String.valueOf(map != null ? map.get("landmarkMode") : null), SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL)) {
            this.runLandmarks = true;
            i = 2;
        } else {
            i = 1;
        }
        if (Intrinsics.areEqual(String.valueOf(map != null ? map.get("classificationMode") : null), SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL)) {
            this.runClassifications = true;
            i2 = 2;
        } else {
            i2 = 1;
        }
        if (Intrinsics.areEqual(String.valueOf(map != null ? map.get("contourMode") : null), SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL)) {
            this.runContours = true;
        } else {
            i3 = 1;
        }
        FaceDetectorOptions.Builder minFaceSize = new FaceDetectorOptions.Builder().setPerformanceMode(i4).setLandmarkMode(i).setContourMode(i3).setClassificationMode(i2).setMinFaceSize((float) ((Double) ((map == null || (obj = map.get("minFaceSize")) == null) ? Double.valueOf(0.15d) : obj)).doubleValue());
        Intrinsics.checkNotNullExpressionValue(minFaceSize, "setMinFaceSize(...)");
        if (Intrinsics.areEqual(String.valueOf(map != null ? map.get("trackingEnabled") : null), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            this.trackingEnabled = true;
            minFaceSize.enableTracking();
        }
        this.faceDetector = FaceDetection.getClient(minFaceSize.build());
    }

    private final Map<String, Object> processBoundingBox(Rect boundingBox, double sourceWidth, double sourceHeight, double scaleX, double scaleY) {
        HashMap map = new HashMap();
        double dWidth = boundingBox.width() * scaleX;
        double dHeight = boundingBox.height() * scaleY;
        double d = boundingBox.left;
        double d2 = boundingBox.top;
        map.put("width", Double.valueOf(dWidth));
        map.put("height", Double.valueOf(dHeight));
        double d3 = d * scaleX;
        map.put("x", Double.valueOf(d3));
        double d4 = d2 * scaleY;
        map.put("y", Double.valueOf(d4));
        if (!this.autoMode) {
            return map;
        }
        if (this.cameraFacing == Position.FRONT) {
            int orientation = this.orientationManager.getOrientation();
            if (orientation == 0) {
                map.put("x", Double.valueOf((((-d) * scaleX) + (sourceWidth * scaleX)) - dWidth));
                map.put("y", Double.valueOf(d4));
            } else if (orientation == 1) {
                map.put("x", Double.valueOf((((-d2) * scaleX) + (sourceWidth * scaleX)) - dWidth));
                map.put("y", Double.valueOf((((-d) * scaleY) + (sourceHeight * scaleY)) - dHeight));
            } else if (orientation == 2) {
                map.put("x", Double.valueOf(d3));
                map.put("y", Double.valueOf((((-d2) * scaleY) + (sourceHeight * scaleY)) - dHeight));
            } else if (orientation == 3) {
                map.put("x", Double.valueOf(d2 * scaleX));
                map.put("y", Double.valueOf(d * scaleY));
            }
            return map;
        }
        int orientation2 = this.orientationManager.getOrientation();
        if (orientation2 == 0) {
            map.put("x", Double.valueOf(d3));
            map.put("y", Double.valueOf(d4));
        } else if (orientation2 == 1) {
            map.put("x", Double.valueOf((((-d2) * scaleX) + (sourceWidth * scaleX)) - dWidth));
            map.put("y", Double.valueOf(d * scaleY));
        } else if (orientation2 == 2) {
            map.put("x", Double.valueOf((((-d) * scaleX) + (sourceWidth * scaleX)) - dWidth));
            map.put("y", Double.valueOf((((-d2) * scaleY) + (sourceHeight * scaleY)) - dHeight));
        } else if (orientation2 == 3) {
            map.put("x", Double.valueOf(d2 * scaleX));
            map.put("y", Double.valueOf((((-d) * scaleY) + (sourceHeight * scaleY)) - dHeight));
        }
        return map;
    }

    private final Map<String, Object> processLandmarks(Face face, double scaleX, double scaleY) {
        int[] iArr = {1, 3, 4, 0, 5, 11, 6, 7, 9, 10};
        String[] strArr = {"LEFT_CHEEK", "LEFT_EAR", "LEFT_EYE", "MOUTH_BOTTOM", "MOUTH_LEFT", "MOUTH_RIGHT", "NOSE_BASE", "RIGHT_CHEEK", "RIGHT_EAR", "RIGHT_EYE"};
        HashMap map = new HashMap();
        for (int i = 0; i < 10; i++) {
            FaceLandmark landmark = face.getLandmark(iArr[i]);
            String str = strArr[i];
            if (landmark != null) {
                Intrinsics.checkNotNullExpressionValue(landmark.getPosition(), "getPosition(...)");
                HashMap map2 = new HashMap();
                map2.put("x", Double.valueOf(r5.x * scaleX));
                map2.put("y", Double.valueOf(r5.y * scaleY));
                map.put(str, map2);
            }
        }
        return map;
    }

    private final Map<String, Object> processFaceContours(Face face, double scaleX, double scaleY) {
        int[] iArr = {1, 14, 6, 3, 2, 11, 10, 13, 12, 15, 7, 5, 4, 9, 8};
        String[] strArr = {"FACE", "LEFT_CHEEK", "LEFT_EYE", "LEFT_EYEBROW_BOTTOM", "LEFT_EYEBROW_TOP", "LOWER_LIP_BOTTOM", "LOWER_LIP_TOP", "NOSE_BOTTOM", "NOSE_BRIDGE", "RIGHT_CHEEK", "RIGHT_EYE", "RIGHT_EYEBROW_BOTTOM", "RIGHT_EYEBROW_TOP", "UPPER_LIP_BOTTOM", "UPPER_LIP_TOP"};
        HashMap map = new HashMap();
        for (int i = 0; i < 15; i++) {
            FaceContour contour = face.getContour(iArr[i]);
            String str = strArr[i];
            if (contour != null) {
                List<PointF> points = contour.getPoints();
                Intrinsics.checkNotNullExpressionValue(points, "getPoints(...)");
                ArrayList arrayList = new ArrayList();
                int size = points.size();
                for (int i2 = 0; i2 < size; i2++) {
                    HashMap map2 = new HashMap();
                    map2.put("x", Double.valueOf(points.get(i2).x * scaleX));
                    map2.put("y", Double.valueOf(points.get(i2).y * scaleY));
                    arrayList.add(map2);
                }
                map.put(str, arrayList);
            }
        }
        return map;
    }

    private final int getImageOrientation() {
        int orientation = this.orientationManager.getOrientation();
        if (orientation != 0) {
            if (orientation == 1) {
                Position position = Position.FRONT;
            } else if (orientation != 2) {
                if (orientation == 3) {
                    Position position2 = Position.FRONT;
                    return RotationOptions.ROTATE_180;
                }
            } else if (this.cameraFacing != Position.FRONT) {
                return RotationOptions.ROTATE_270;
            }
            return 0;
        }
        if (this.cameraFacing == Position.FRONT) {
            return RotationOptions.ROTATE_270;
        }
        return 90;
    }

    @Override // com.mrousavy.camera.frameprocessors.FrameProcessorPlugin
    public Object callback(Frame frame, Map<String, ? extends Object> params) {
        Iterator it;
        VisionCameraFaceDetectorPlugin visionCameraFaceDetectorPlugin = this;
        Intrinsics.checkNotNullParameter(frame, "frame");
        ArrayList arrayList = new ArrayList();
        try {
            InputImage inputImageFromMediaImage = InputImage.fromMediaImage(frame.getImage(), getImageOrientation());
            Intrinsics.checkNotNullExpressionValue(inputImageFromMediaImage, "fromMediaImage(...)");
            double height = inputImageFromMediaImage.getHeight();
            double width = inputImageFromMediaImage.getWidth();
            boolean z = visionCameraFaceDetectorPlugin.autoMode;
            double d = z ? visionCameraFaceDetectorPlugin.windowWidth / height : 1.0d;
            double d2 = z ? visionCameraFaceDetectorPlugin.windowHeight / width : 1.0d;
            FaceDetector faceDetector = visionCameraFaceDetectorPlugin.faceDetector;
            Intrinsics.checkNotNull(faceDetector);
            Task<List<Face>> taskProcess = faceDetector.process(inputImageFromMediaImage);
            Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
            List list = (List) Tasks.await(taskProcess);
            Intrinsics.checkNotNull(list);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Face face = (Face) it2.next();
                HashMap map = new HashMap();
                if (visionCameraFaceDetectorPlugin.runLandmarks) {
                    Intrinsics.checkNotNull(face);
                    it = it2;
                    map.put("landmarks", processLandmarks(face, d, d2));
                } else {
                    it = it2;
                }
                if (visionCameraFaceDetectorPlugin.runClassifications) {
                    map.put("leftEyeOpenProbability", face.getLeftEyeOpenProbability() != null ? Double.valueOf(r1.floatValue()) : -1);
                    map.put("rightEyeOpenProbability", face.getRightEyeOpenProbability() != null ? Double.valueOf(r1.floatValue()) : -1);
                    map.put("smilingProbability", face.getSmilingProbability() != null ? Double.valueOf(r1.floatValue()) : -1);
                }
                if (visionCameraFaceDetectorPlugin.runContours) {
                    Intrinsics.checkNotNull(face);
                    map.put("contours", processFaceContours(face, d, d2));
                }
                if (visionCameraFaceDetectorPlugin.trackingEnabled) {
                    int trackingId = face.getTrackingId();
                    if (trackingId == null) {
                        trackingId = -1;
                    }
                    Intrinsics.checkNotNull(trackingId);
                    map.put("trackingId", trackingId);
                }
                map.put("rollAngle", Double.valueOf(face.getHeadEulerAngleZ()));
                map.put("pitchAngle", Double.valueOf(face.getHeadEulerAngleX()));
                map.put("yawAngle", Double.valueOf(face.getHeadEulerAngleY()));
                Rect boundingBox = face.getBoundingBox();
                Intrinsics.checkNotNullExpressionValue(boundingBox, "getBoundingBox(...)");
                double d3 = width;
                map.put("bounds", processBoundingBox(boundingBox, height, width, d, d2));
                arrayList.add(map);
                visionCameraFaceDetectorPlugin = this;
                it2 = it;
                width = d3;
            }
        } catch (FrameInvalidError e) {
            Log.e("FaceDetector", "Frame invalid error: ", e);
        } catch (Exception e2) {
            Log.e("FaceDetector", "Error processing face detection: ", e2);
        }
        return arrayList;
    }
}
