package com.mrousavy.camera.core;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.PreviewCapabilities;
import androidx.camera.core.SurfaceOrientedMeteringPointFactory;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.capability.PreviewCapabilitiesImpl;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.video.AudioStats;
import androidx.camera.video.Quality;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapabilities;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.mrousavy.camera.core.extensions.CameraInfo_idKt;
import com.mrousavy.camera.core.types.AutoFocusSystem;
import com.mrousavy.camera.core.types.DeviceType;
import com.mrousavy.camera.core.types.HardwareLevel;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.Position;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.core.utils.CamcorderProfileUtils;
import com.mrousavy.camera.react.extensions.List_toJSValueKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraDeviceDetails.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0006\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0002J\b\u0010:\u001a\u00020;H\u0002J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\u0018\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020;H\u0002J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0002J\b\u0010E\u001a\u00020\u001cH\u0002J\u0018\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020G2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010H\u001a\u00020\u001cH\u0002J\b\u0010I\u001a\u00020\u0015H\u0002J\b\u0010J\u001a\u00020\u0015H\u0002J\u0006\u0010K\u001a\u000205R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\n \u001a*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010 \u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u000f0\u000f0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/mrousavy/camera/core/CameraDeviceDetails;", "", "cameraInfo", "Landroidx/camera/core/CameraInfo;", "extensionsManager", "Landroidx/camera/extensions/ExtensionsManager;", "(Landroidx/camera/core/CameraInfo;Landroidx/camera/extensions/ExtensionsManager;)V", "autoFocusSystem", "Lcom/mrousavy/camera/core/types/AutoFocusSystem;", "camera2Details", "Landroidx/camera/camera2/internal/Camera2CameraInfoImpl;", "cameraHardwareLevel", "", "Ljava/lang/Integer;", "cameraId", "", "cameraInfoInternal", "Landroidx/camera/core/impl/CameraInfoInternal;", "hardwareLevel", "Lcom/mrousavy/camera/core/types/HardwareLevel;", "hasFlash", "", "isMultiCam", "isoRange", "Landroid/util/Range;", "maxExposure", "kotlin.jvm.PlatformType", "maxFieldOfView", "", "maxZoom", "", "minExposure", "minFocusDistance", "minZoom", "name", "physicalDeviceIds", "", ViewProps.POSITION, "Lcom/mrousavy/camera/core/types/Position;", "previewCapabilities", "Landroidx/camera/core/PreviewCapabilities;", "sensorOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "sensorRotationDegrees", "supports10BitHdr", "supportsDepthCapture", "supportsFocus", "supportsHdrExtension", "supportsLowLightBoostExtension", "supportsRawCapture", "videoCapabilities", "Landroidx/camera/video/VideoCapabilities;", "buildFormatMap", "Lcom/facebook/react/bridge/ReadableMap;", "photoSize", "Landroid/util/Size;", "videoSize", "fpsRange", "createStabilizationModes", "Lcom/facebook/react/bridge/ReadableArray;", "getDeviceTypes", "", "Lcom/mrousavy/camera/core/types/DeviceType;", "getFieldOfView", "focalLength", "sensorSize", "Landroid/util/SizeF;", "getFormats", "getIsoRange", "getMaxFieldOfView", "focalLengths", "", "getMinFocusDistanceCm", "getSupports10BitHDR", "getSupportsFocus", "toMap", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraDeviceDetails {
    private static final String TAG = "CameraDeviceDetails";
    private final AutoFocusSystem autoFocusSystem;
    private final Camera2CameraInfoImpl camera2Details;
    private final Integer cameraHardwareLevel;
    private final String cameraId;
    private final CameraInfo cameraInfo;
    private final CameraInfoInternal cameraInfoInternal;
    private final HardwareLevel hardwareLevel;
    private final boolean hasFlash;
    private final boolean isMultiCam;
    private final Range<Integer> isoRange;
    private final Integer maxExposure;
    private final double maxFieldOfView;
    private final float maxZoom;
    private final Integer minExposure;
    private final double minFocusDistance;
    private final float minZoom;
    private final String name;
    private final Set<String> physicalDeviceIds;
    private final Position position;
    private final PreviewCapabilities previewCapabilities;
    private final Orientation sensorOrientation;
    private final int sensorRotationDegrees;
    private final boolean supports10BitHdr;
    private final boolean supportsDepthCapture;
    private final boolean supportsFocus;
    private final boolean supportsHdrExtension;
    private final boolean supportsLowLightBoostExtension;
    private final boolean supportsRawCapture;
    private final VideoCapabilities videoCapabilities;

    public CameraDeviceDetails(CameraInfo cameraInfo, ExtensionsManager extensionsManager) throws NoCameraDeviceError {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        Map<String, CameraCharacteristics> cameraCharacteristicsMap;
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
        this.cameraInfo = cameraInfo;
        String id = CameraInfo_idKt.getId(cameraInfo);
        if (id == null) {
            throw new NoCameraDeviceError();
        }
        this.cameraId = id;
        Position positionFromLensFacing = Position.INSTANCE.fromLensFacing(cameraInfo.getLensFacing());
        this.position = positionFromLensFacing;
        this.name = id + " (" + positionFromLensFacing + ") " + cameraInfo.getImplementationType();
        this.hasFlash = cameraInfo.hasFlashUnit();
        ZoomState value = cameraInfo.getZoomState().getValue();
        this.minZoom = value != null ? value.getMinZoomRatio() : 0.0f;
        ZoomState value2 = cameraInfo.getZoomState().getValue();
        this.maxZoom = value2 != null ? value2.getMaxZoomRatio() : 1.0f;
        this.minExposure = (Integer) cameraInfo.getExposureState().getExposureCompensationRange().getLower();
        this.maxExposure = (Integer) cameraInfo.getExposureState().getExposureCompensationRange().getUpper();
        boolean supportsFocus = getSupportsFocus();
        this.supportsFocus = supportsFocus;
        this.autoFocusSystem = supportsFocus ? AutoFocusSystem.CONTRAST_DETECTION : AutoFocusSystem.NONE;
        PreviewCapabilities previewCapabilitiesFrom = PreviewCapabilitiesImpl.from(cameraInfo);
        Intrinsics.checkNotNullExpressionValue(previewCapabilitiesFrom, "from(...)");
        this.previewCapabilities = previewCapabilitiesFrom;
        VideoCapabilities videoCapabilities = Recorder.getVideoCapabilities(cameraInfo, 0);
        Intrinsics.checkNotNullExpressionValue(videoCapabilities, "getVideoCapabilities(...)");
        this.videoCapabilities = videoCapabilities;
        this.supports10BitHdr = getSupports10BitHDR();
        int sensorRotationDegrees = cameraInfo.getSensorRotationDegrees();
        this.sensorRotationDegrees = sensorRotationDegrees;
        this.sensorOrientation = Orientation.INSTANCE.fromRotationDegrees(sensorRotationDegrees);
        Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.CameraInfoInternal");
        this.cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        Integer num = null;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        this.camera2Details = camera2CameraInfoImpl;
        Set<String> setEmptySet = (camera2CameraInfoImpl == null || (cameraCharacteristicsMap = camera2CameraInfoImpl.getCameraCharacteristicsMap()) == null || (setEmptySet = cameraCharacteristicsMap.keySet()) == null) ? SetsKt.emptySet() : setEmptySet;
        this.physicalDeviceIds = setEmptySet;
        this.isMultiCam = setEmptySet.size() > 1;
        if (camera2CameraInfoImpl != null && (cameraCharacteristicsCompat = camera2CameraInfoImpl.getCameraCharacteristicsCompat()) != null) {
            num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        }
        this.cameraHardwareLevel = num;
        this.hardwareLevel = HardwareLevel.INSTANCE.fromCameraHardwareLevel(num != null ? num.intValue() : 2);
        this.minFocusDistance = getMinFocusDistanceCm();
        this.isoRange = getIsoRange();
        this.maxFieldOfView = getMaxFieldOfView();
        this.supportsHdrExtension = extensionsManager.isExtensionAvailable(cameraInfo.getCameraSelector(), 2);
        this.supportsLowLightBoostExtension = extensionsManager.isExtensionAvailable(cameraInfo.getCameraSelector(), 3);
    }

    public final ReadableMap toMap() {
        List<DeviceType> deviceTypes = getDeviceTypes();
        ReadableArray formats = getFormats();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", this.cameraId);
        writableMapCreateMap.putArray("physicalDevices", List_toJSValueKt.toJSValue(deviceTypes));
        writableMapCreateMap.putString(ViewProps.POSITION, this.position.getUnionValue());
        writableMapCreateMap.putString("name", this.name);
        writableMapCreateMap.putBoolean("hasFlash", this.hasFlash);
        writableMapCreateMap.putBoolean("hasTorch", this.hasFlash);
        writableMapCreateMap.putDouble("minFocusDistance", this.minFocusDistance);
        writableMapCreateMap.putBoolean("isMultiCam", this.isMultiCam);
        writableMapCreateMap.putBoolean("supportsRawCapture", this.supportsRawCapture);
        writableMapCreateMap.putBoolean("supportsLowLightBoost", this.supportsLowLightBoostExtension);
        writableMapCreateMap.putBoolean("supportsFocus", this.supportsFocus);
        writableMapCreateMap.putDouble("minZoom", this.minZoom);
        writableMapCreateMap.putDouble("maxZoom", this.maxZoom);
        writableMapCreateMap.putDouble("neutralZoom", 1.0d);
        Integer minExposure = this.minExposure;
        Intrinsics.checkNotNullExpressionValue(minExposure, "minExposure");
        writableMapCreateMap.putInt("minExposure", minExposure.intValue());
        Integer maxExposure = this.maxExposure;
        Intrinsics.checkNotNullExpressionValue(maxExposure, "maxExposure");
        writableMapCreateMap.putInt("maxExposure", maxExposure.intValue());
        writableMapCreateMap.putString("hardwareLevel", this.hardwareLevel.getUnionValue());
        writableMapCreateMap.putString("sensorOrientation", this.sensorOrientation.getUnionValue());
        writableMapCreateMap.putArray("formats", formats);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    private final ReadableArray getFormats() {
        Iterator it;
        ArrayList<Size> arrayList;
        List<Size> supportedResolutions;
        Set<Range<Integer>> supportedFrameRateRanges;
        Iterator<T> it2;
        List<Size> list;
        CameraDeviceDetails cameraDeviceDetails = this;
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Set<DynamicRange> supportedDynamicRanges = cameraDeviceDetails.videoCapabilities.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        Iterator it3 = supportedDynamicRanges.iterator();
        while (it3.hasNext()) {
            DynamicRange dynamicRange = (DynamicRange) it3.next();
            try {
                List<Quality> supportedQualities = cameraDeviceDetails.videoCapabilities.getSupportedQualities(dynamicRange);
                Intrinsics.checkNotNullExpressionValue(supportedQualities, "getSupportedQualities(...)");
                List<Quality> list2 = supportedQualities;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Quality quality : list2) {
                    Intrinsics.checkNotNull(quality, "null cannot be cast to non-null type androidx.camera.video.Quality.ConstantQuality");
                    arrayList2.add((Quality.ConstantQuality) quality);
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    List<Size> typicalSizes = ((Quality.ConstantQuality) it4.next()).getTypicalSizes();
                    Intrinsics.checkNotNullExpressionValue(typicalSizes, "getTypicalSizes(...)");
                    CollectionsKt.addAll(arrayList3, typicalSizes);
                }
                arrayList = arrayList3;
                supportedResolutions = cameraDeviceDetails.cameraInfoInternal.getSupportedResolutions(256);
                Intrinsics.checkNotNullExpressionValue(supportedResolutions, "getSupportedResolutions(...)");
                supportedFrameRateRanges = cameraDeviceDetails.cameraInfo.getSupportedFrameRateRanges();
                Intrinsics.checkNotNullExpressionValue(supportedFrameRateRanges, "getSupportedFrameRateRanges(...)");
                it2 = supportedFrameRateRanges.iterator();
            } catch (Throwable th) {
                th = th;
                it = it3;
            }
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer num = (Integer) ((Range) it2.next()).getLower();
            while (it2.hasNext()) {
                Integer num2 = (Integer) ((Range) it2.next()).getLower();
                if (num.compareTo(num2) > 0) {
                    num = num2;
                }
            }
            Integer num3 = num;
            Iterator<T> it5 = supportedFrameRateRanges.iterator();
            if (!it5.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer num4 = (Integer) ((Range) it5.next()).getUpper();
            while (it5.hasNext()) {
                Integer num5 = (Integer) ((Range) it5.next()).getUpper();
                if (num4.compareTo(num5) < 0) {
                    num4 = num5;
                }
            }
            Integer num6 = num4;
            for (Size size : arrayList) {
                try {
                    CamcorderProfileUtils.Companion companion = CamcorderProfileUtils.INSTANCE;
                    String str = cameraDeviceDetails.cameraId;
                    Intrinsics.checkNotNull(size);
                    Integer maximumFps = companion.getMaximumFps(str, size);
                    if (maximumFps == null) {
                        maximumFps = num6;
                    }
                    Intrinsics.checkNotNull(num3);
                    int iIntValue = num3.intValue();
                    Intrinsics.checkNotNull(maximumFps);
                    Range<Integer> range = new Range<>(Integer.valueOf(Math.min(iIntValue, maximumFps.intValue())), maximumFps);
                    for (Size size2 : supportedResolutions) {
                        try {
                            Intrinsics.checkNotNull(size2);
                            writableArrayCreateArray.pushMap(cameraDeviceDetails.buildFormatMap(size2, size, range));
                            it = it3;
                            list = supportedResolutions;
                        } catch (Throwable th2) {
                            it = it3;
                            try {
                                list = supportedResolutions;
                            } catch (Throwable th3) {
                                th = th3;
                                list = supportedResolutions;
                                try {
                                    Log.w(TAG, "Video size " + size.getWidth() + "x" + size.getHeight() + " cannot be used as a format!", th);
                                    cameraDeviceDetails = this;
                                    it3 = it;
                                    supportedResolutions = list;
                                } catch (Throwable th4) {
                                    th = th4;
                                    Log.w(TAG, "Dynamic Range Profile " + dynamicRange + " cannot be used as a format!", th);
                                    cameraDeviceDetails = this;
                                    it3 = it;
                                }
                            }
                            try {
                                Log.w(TAG, "Photo size " + size2.getWidth() + "x" + size2.getHeight() + " cannot be used as a format!", th2);
                            } catch (Throwable th5) {
                                th = th5;
                                Log.w(TAG, "Video size " + size.getWidth() + "x" + size.getHeight() + " cannot be used as a format!", th);
                                cameraDeviceDetails = this;
                                it3 = it;
                                supportedResolutions = list;
                            }
                        }
                        cameraDeviceDetails = this;
                        it3 = it;
                        supportedResolutions = list;
                    }
                    it = it3;
                    list = supportedResolutions;
                } catch (Throwable th6) {
                    th = th6;
                    it = it3;
                }
                cameraDeviceDetails = this;
                it3 = it;
                supportedResolutions = list;
            }
            it = it3;
            cameraDeviceDetails = this;
            it3 = it;
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    private final ReadableMap buildFormatMap(Size photoSize, Size videoSize, Range<Integer> fpsRange) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("photoHeight", photoSize.getHeight());
        writableMapCreateMap.putInt("photoWidth", photoSize.getWidth());
        writableMapCreateMap.putInt("videoHeight", videoSize.getHeight());
        writableMapCreateMap.putInt("videoWidth", videoSize.getWidth());
        Object lower = fpsRange.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "getLower(...)");
        writableMapCreateMap.putInt("minFps", ((Number) lower).intValue());
        Object upper = fpsRange.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
        writableMapCreateMap.putInt("maxFps", ((Number) upper).intValue());
        Object lower2 = this.isoRange.getLower();
        Intrinsics.checkNotNullExpressionValue(lower2, "getLower(...)");
        writableMapCreateMap.putInt("minISO", ((Number) lower2).intValue());
        Object upper2 = this.isoRange.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper2, "getUpper(...)");
        writableMapCreateMap.putInt("maxISO", ((Number) upper2).intValue());
        writableMapCreateMap.putDouble("fieldOfView", this.maxFieldOfView);
        writableMapCreateMap.putBoolean("supportsVideoHdr", this.supports10BitHdr);
        writableMapCreateMap.putBoolean("supportsPhotoHdr", this.supportsHdrExtension);
        writableMapCreateMap.putBoolean("supportsDepthCapture", this.supportsDepthCapture);
        writableMapCreateMap.putString("autoFocusSystem", this.autoFocusSystem.getUnionValue());
        writableMapCreateMap.putArray("videoStabilizationModes", createStabilizationModes());
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    private final boolean getSupports10BitHDR() {
        Set<DynamicRange> supportedDynamicRanges = this.videoCapabilities.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        Set<DynamicRange> set = supportedDynamicRanges;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (DynamicRange dynamicRange : set) {
            if (dynamicRange.is10BitHdr() || Intrinsics.areEqual(dynamicRange, DynamicRange.HDR_UNSPECIFIED_10_BIT)) {
                return true;
            }
        }
        return false;
    }

    private final boolean getSupportsFocus() {
        MeteringPoint meteringPointCreatePoint = new SurfaceOrientedMeteringPointFactory(1.0f, 1.0f).createPoint(0.5f, 0.5f);
        Intrinsics.checkNotNullExpressionValue(meteringPointCreatePoint, "createPoint(...)");
        return this.cameraInfo.isFocusMeteringSupported(new FocusMeteringAction.Builder(meteringPointCreatePoint).build());
    }

    private final double getMinFocusDistanceCm() {
        Float f;
        CameraInfo cameraInfo = this.cameraInfo;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        return (camera2CameraInfoImpl == null || (f = (Float) camera2CameraInfoImpl.getCameraCharacteristicsCompat().get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)) == null || Intrinsics.areEqual(f, 0.0f) || Float.isNaN(f.floatValue()) || Float.isInfinite(f.floatValue())) ? AudioStats.AUDIO_AMPLITUDE_NONE : (1.0d / f.floatValue()) * 100.0d;
    }

    private final Range<Integer> getIsoRange() {
        CameraInfo cameraInfo = this.cameraInfo;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        if (camera2CameraInfoImpl == null) {
            return new Range<>((Comparable) 0, (Comparable) 0);
        }
        Range<Integer> range = (Range) camera2CameraInfoImpl.getCameraCharacteristicsCompat().get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
        return range == null ? new Range<>((Comparable) 0, (Comparable) 0) : range;
    }

    private final ReadableArray createStabilizationModes() {
        Set setMutableSetOf = SetsKt.mutableSetOf(VideoStabilizationMode.OFF);
        if (this.videoCapabilities.isStabilizationSupported()) {
            setMutableSetOf.add(VideoStabilizationMode.CINEMATIC);
        }
        if (this.previewCapabilities.isStabilizationSupported()) {
            setMutableSetOf.add(VideoStabilizationMode.CINEMATIC_EXTENDED);
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator it = setMutableSetOf.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString(((VideoStabilizationMode) it.next()).getUnionValue());
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    private final List<DeviceType> getDeviceTypes() {
        DeviceType deviceType;
        List<DeviceType> listListOf = CollectionsKt.listOf(DeviceType.WIDE_ANGLE);
        Camera2CameraInfoImpl camera2CameraInfoImpl = this.camera2Details;
        if (camera2CameraInfoImpl == null) {
            return listListOf;
        }
        Map<String, CameraCharacteristics> cameraCharacteristicsMap = camera2CameraInfoImpl.getCameraCharacteristicsMap();
        Intrinsics.checkNotNullExpressionValue(cameraCharacteristicsMap, "getCameraCharacteristicsMap(...)");
        ArrayList arrayList = new ArrayList(cameraCharacteristicsMap.size());
        Iterator<Map.Entry<String, CameraCharacteristics>> it = cameraCharacteristicsMap.entrySet().iterator();
        while (it.hasNext()) {
            CameraCharacteristics value = it.next().getValue();
            SizeF sizeF = (SizeF) value.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (sizeF == null) {
                deviceType = DeviceType.WIDE_ANGLE;
            } else {
                Intrinsics.checkNotNull(sizeF);
                float[] fArr = (float[]) value.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                if (fArr == null) {
                    deviceType = DeviceType.WIDE_ANGLE;
                } else {
                    Intrinsics.checkNotNull(fArr);
                    double maxFieldOfView = getMaxFieldOfView(fArr, sizeF);
                    if (maxFieldOfView > 94.0d) {
                        deviceType = DeviceType.ULTRA_WIDE_ANGLE;
                    } else if (60.0d <= maxFieldOfView && maxFieldOfView <= 94.0d) {
                        deviceType = DeviceType.WIDE_ANGLE;
                    } else if (maxFieldOfView < 60.0d) {
                        deviceType = DeviceType.TELEPHOTO;
                    } else {
                        throw new Error("Invalid Field Of View! (" + maxFieldOfView + ")");
                    }
                }
            }
            arrayList.add(deviceType);
        }
        return arrayList;
    }

    private final double getFieldOfView(float focalLength, SizeF sensorSize) {
        return (sensorSize.getWidth() == 0.0f || sensorSize.getHeight() == 0.0f) ? AudioStats.AUDIO_AMPLITUDE_NONE : Math.toDegrees(Math.atan2(Math.sqrt((sensorSize.getWidth() * sensorSize.getWidth()) + (sensorSize.getHeight() * sensorSize.getHeight())), focalLength * 2.0d) * 2.0d);
    }

    private final double getMaxFieldOfView(float[] focalLengths, SizeF sensorSize) {
        Float fMinOrNull = ArraysKt.minOrNull(focalLengths);
        return fMinOrNull != null ? getFieldOfView(fMinOrNull.floatValue(), sensorSize) : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private final double getMaxFieldOfView() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        SizeF sizeF;
        float[] fArr;
        Camera2CameraInfoImpl camera2CameraInfoImpl = this.camera2Details;
        return (camera2CameraInfoImpl == null || (cameraCharacteristicsCompat = camera2CameraInfoImpl.getCameraCharacteristicsCompat()) == null || (sizeF = (SizeF) cameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)) == null || (fArr = (float[]) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS)) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : getMaxFieldOfView(fArr, sizeF);
    }
}
