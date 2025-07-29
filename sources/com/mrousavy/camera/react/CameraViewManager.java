package com.mrousavy.camera.react;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeScannerOptions;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.PreviewViewType;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.ResizeMode;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.swmansion.rnscreens.Screen;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraViewManager.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b \u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0007J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0014H\u0007J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0014H\u0007J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0014H\u0007J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0014H\u0007J\u0018\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0007J\u001a\u0010'\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0019H\u0007J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0014H\u0007J\u0018\u0010+\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0014H\u0007J\u0018\u0010-\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0014H\u0007J\u0018\u0010/\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u00100\u001a\u000201H\u0007J\u0018\u00102\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u00103\u001a\u000201H\u0007J\u001a\u00104\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u00106\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0014H\u0007J\u0018\u00108\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0014H\u0007J\u001a\u0010:\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010<\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010=\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010>\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0014H\u0007J\u001a\u0010@\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010B\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010C\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010D\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0014H\u0007J\u0018\u0010F\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010G\u001a\u00020&H\u0007J\u0018\u0010H\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010I\u001a\u00020&H\u0007J\u0018\u0010J\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0014H\u0007J\u001a\u0010L\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010M\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010N\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010O\u001a\u00020&H\u0007¨\u0006Q"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/mrousavy/camera/react/CameraView;", "()V", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onAfterUpdateTransaction", "", ViewHierarchyConstants.VIEW_KEY, "onDropViewInstance", "setAndroidPreviewViewType", "androidPreviewViewType", "setAudio", "audio", "", "setCameraId", "cameraId", "setCodeScanner", "codeScannerOptions", "Lcom/facebook/react/bridge/ReadableMap;", "setEnableDepthData", "enableDepthData", "setEnableFrameProcessor", "enableFrameProcessor", "setEnableLocation", "enableLocation", "setEnablePortraitEffectsMatteDelivery", "enablePortraitEffectsMatteDelivery", "setEnableZoomGesture", "enableZoomGesture", "setExposure", "exposure", "", "setFormat", "format", "setIsActive", "isActive", "setIsMirrored", "isMirrored", "setLowLightBoost", "lowLightBoost", "setMaxFps", "maxFps", "", "setMinFps", "minFps", "setOrientation", "outputOrientation", "setPhoto", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, "setPhotoHdr", "photoHdr", "setPhotoQualityBalance", "photoQualityBalance", "setPixelFormat", "pixelFormat", "setPreview", "preview", "setResizeMode", ViewProps.RESIZE_MODE, "setTorch", "torch", "setVideo", "video", "setVideoBitRateMultiplier", "videoBitRateMultiplier", "setVideoBitRateOverride", "videoBitRateOverride", "setVideoHdr", "videoHdr", "setVideoStabilizationMode", "videoStabilizationMode", "setZoom", "zoom", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraViewManager extends ViewGroupManager<CameraView> {
    public static final String TAG = "CameraView";

    @Override // com.facebook.react.uimanager.ViewManager
    public CameraView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CameraView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(CameraView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((CameraViewManager) view);
        view.update();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(CameraViewReadyEvent.EVENT_NAME, MapBuilder.of("registrationName", "onViewReady")).put(CameraInitializedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onInitialized")).put(CameraStartedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onStarted")).put(CameraStoppedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onStopped")).put(CameraShutterEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShutter")).put(CameraErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onError")).put(CameraCodeScannedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onCodeScanned")).put(CameraPreviewStartedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewStarted")).put(CameraPreviewStoppedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewStopped")).put(CameraOutputOrientationChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onOutputOrientationChanged")).put(CameraPreviewOrientationChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewOrientationChanged")).put(AverageFpsChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAverageFpsChanged")).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CameraView";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(CameraView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.destroy();
        super.onDropViewInstance((CameraViewManager) view);
    }

    @ReactProp(name = "cameraId")
    public final void setCameraId(CameraView view, String cameraId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        view.setCameraId(cameraId);
    }

    @ReactProp(name = "isMirrored")
    public final void setIsMirrored(CameraView view, boolean isMirrored) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMirrored(isMirrored);
    }

    @ReactProp(defaultBoolean = true, name = "preview")
    public final void setPreview(CameraView view, boolean preview) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreview(preview);
    }

    @ReactProp(name = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)
    public final void setPhoto(CameraView view, boolean photo) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPhoto(photo);
    }

    @ReactProp(name = "video")
    public final void setVideo(CameraView view, boolean video) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideo(video);
    }

    @ReactProp(name = "audio")
    public final void setAudio(CameraView view, boolean audio) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAudio(audio);
    }

    @ReactProp(name = "enableLocation")
    public final void setEnableLocation(CameraView view, boolean enableLocation) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableLocation(enableLocation);
    }

    @ReactProp(name = "enableFrameProcessor")
    public final void setEnableFrameProcessor(CameraView view, boolean enableFrameProcessor) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableFrameProcessor(enableFrameProcessor);
    }

    @ReactProp(name = "pixelFormat")
    public final void setPixelFormat(CameraView view, String pixelFormat) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (pixelFormat != null) {
            view.setPixelFormat(PixelFormat.INSTANCE.fromUnionValue(pixelFormat));
        } else {
            view.setPixelFormat(PixelFormat.YUV);
        }
    }

    @ReactProp(name = "enableDepthData")
    public final void setEnableDepthData(CameraView view, boolean enableDepthData) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableDepthData(enableDepthData);
    }

    @ReactProp(name = "enableZoomGesture")
    public final void setEnableZoomGesture(CameraView view, boolean enableZoomGesture) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableZoomGesture(enableZoomGesture);
    }

    @ReactProp(name = "videoStabilizationMode")
    public final void setVideoStabilizationMode(CameraView view, String videoStabilizationMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (videoStabilizationMode != null) {
            view.setVideoStabilizationMode(VideoStabilizationMode.INSTANCE.fromUnionValue(videoStabilizationMode));
        } else {
            view.setVideoStabilizationMode(null);
        }
    }

    @ReactProp(name = "enablePortraitEffectsMatteDelivery")
    public final void setEnablePortraitEffectsMatteDelivery(CameraView view, boolean enablePortraitEffectsMatteDelivery) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnablePortraitEffectsMatteDelivery(enablePortraitEffectsMatteDelivery);
    }

    @ReactProp(name = "format")
    public final void setFormat(CameraView view, ReadableMap format) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (format != null) {
            view.setFormat(CameraDeviceFormat.INSTANCE.fromJSValue(format));
        } else {
            view.setFormat(null);
        }
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    public final void setResizeMode(CameraView view, String resizeMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (resizeMode != null) {
            view.setResizeMode(ResizeMode.INSTANCE.fromUnionValue(resizeMode));
        } else {
            view.setResizeMode(ResizeMode.COVER);
        }
    }

    @ReactProp(name = "androidPreviewViewType")
    public final void setAndroidPreviewViewType(CameraView view, String androidPreviewViewType) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (androidPreviewViewType != null) {
            view.setAndroidPreviewViewType(PreviewViewType.INSTANCE.fromUnionValue(androidPreviewViewType));
        } else {
            view.setAndroidPreviewViewType(PreviewViewType.SURFACE_VIEW);
        }
    }

    @ReactProp(defaultInt = -1, name = "minFps")
    public final void setMinFps(CameraView view, int minFps) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMinFps(minFps > 0 ? Integer.valueOf(minFps) : null);
    }

    @ReactProp(defaultInt = -1, name = "maxFps")
    public final void setMaxFps(CameraView view, int maxFps) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMaxFps(maxFps > 0 ? Integer.valueOf(maxFps) : null);
    }

    @ReactProp(name = "photoHdr")
    public final void setPhotoHdr(CameraView view, boolean photoHdr) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPhotoHdr(photoHdr);
    }

    @ReactProp(name = "photoQualityBalance")
    public final void setPhotoQualityBalance(CameraView view, String photoQualityBalance) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (photoQualityBalance != null) {
            view.setPhotoQualityBalance(QualityBalance.INSTANCE.fromUnionValue(photoQualityBalance));
        } else {
            view.setPhotoQualityBalance(QualityBalance.BALANCED);
        }
    }

    @ReactProp(name = "videoHdr")
    public final void setVideoHdr(CameraView view, boolean videoHdr) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideoHdr(videoHdr);
    }

    @ReactProp(defaultDouble = Screen.SHEET_FIT_TO_CONTENTS, name = "videoBitRateOverride")
    public final void setVideoBitRateOverride(CameraView view, double videoBitRateOverride) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (videoBitRateOverride != -1.0d) {
            view.setVideoBitRateOverride(Double.valueOf(videoBitRateOverride));
        } else {
            view.setVideoBitRateOverride(null);
        }
    }

    @ReactProp(defaultDouble = Screen.SHEET_FIT_TO_CONTENTS, name = "videoBitRateMultiplier")
    public final void setVideoBitRateMultiplier(CameraView view, double videoBitRateMultiplier) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (videoBitRateMultiplier != -1.0d) {
            view.setVideoBitRateMultiplier(Double.valueOf(videoBitRateMultiplier));
        } else {
            view.setVideoBitRateMultiplier(null);
        }
    }

    @ReactProp(name = "lowLightBoost")
    public final void setLowLightBoost(CameraView view, boolean lowLightBoost) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLowLightBoost(lowLightBoost);
    }

    @ReactProp(name = "isActive")
    public final void setIsActive(CameraView view, boolean isActive) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActive(isActive);
    }

    @ReactProp(name = "torch")
    public final void setTorch(CameraView view, String torch) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (torch != null) {
            view.setTorch(Torch.INSTANCE.fromUnionValue(torch));
        } else {
            view.setTorch(Torch.OFF);
        }
    }

    @ReactProp(name = "zoom")
    public final void setZoom(CameraView view, double zoom) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setZoom((float) zoom);
    }

    @ReactProp(name = "exposure")
    public final void setExposure(CameraView view, double exposure) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setExposure(exposure);
    }

    @ReactProp(name = "outputOrientation")
    public final void setOrientation(CameraView view, String outputOrientation) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (outputOrientation != null) {
            view.setOutputOrientation(OutputOrientation.INSTANCE.fromUnionValue(outputOrientation));
        } else {
            view.setOutputOrientation(OutputOrientation.DEVICE);
        }
    }

    @ReactProp(name = "codeScannerOptions")
    public final void setCodeScanner(CameraView view, ReadableMap codeScannerOptions) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (codeScannerOptions != null) {
            view.setCodeScannerOptions(CodeScannerOptions.INSTANCE.fromJSValue(codeScannerOptions));
        } else {
            view.setCodeScannerOptions(null);
        }
    }
}
