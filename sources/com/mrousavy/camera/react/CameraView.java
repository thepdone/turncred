package com.mrousavy.camera.react;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Preview;
import androidx.camera.view.PreviewView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.uimanager.ViewProps;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.CodeScannerFrame;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeScannerOptions;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.PreviewViewType;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.ResizeMode;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.frameprocessors.Frame;
import com.mrousavy.camera.frameprocessors.FrameProcessor;
import com.mrousavy.camera.react.FpsSampleCollector;
import com.mrousavy.camera.react.extensions.ViewGroup_installHierarchyFitterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CameraView.kt */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 Å\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Å\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010¥\u0001\u001a\u00020yH\u0002J\b\u0010¦\u0001\u001a\u00030§\u0001J\n\u0010¨\u0001\u001a\u00030§\u0001H\u0014J\u0013\u0010©\u0001\u001a\u00030§\u00012\u0007\u0010ª\u0001\u001a\u000206H\u0016J%\u0010«\u0001\u001a\u00030§\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010\u00ad\u00012\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\n\u0010±\u0001\u001a\u00030§\u0001H\u0014J\u0014\u0010²\u0001\u001a\u00030§\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u0014\u0010µ\u0001\u001a\u00030§\u00012\b\u0010¶\u0001\u001a\u00030·\u0001H\u0016J\n\u0010¸\u0001\u001a\u00030§\u0001H\u0016J\u0013\u0010¹\u0001\u001a\u00030§\u00012\u0007\u0010]\u001a\u00030º\u0001H\u0016J\u0014\u0010»\u0001\u001a\u00030§\u00012\b\u0010¼\u0001\u001a\u00030º\u0001H\u0016J\u0014\u0010½\u0001\u001a\u00030§\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0016J\n\u0010À\u0001\u001a\u00030§\u0001H\u0016J\n\u0010Á\u0001\u001a\u00030§\u0001H\u0016J\b\u0010Â\u0001\u001a\u00030§\u0001J\n\u0010Ã\u0001\u001a\u00030§\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030§\u0001H\u0003R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\u001a\u0010,\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R\u001a\u0010/\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R$\u00102\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013R\u001a\u0010K\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0011\"\u0004\bL\u0010\u0013R\u000e\u0010M\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0011\"\u0004\bP\u0010\u0013R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Z\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR\u001a\u0010]\u001a\u00020^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0011\"\u0004\be\u0010\u0013R\u001a\u0010f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0011\"\u0004\bh\u0010\u0013R\u001a\u0010i\u001a\u00020jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020pX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010u\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0011\"\u0004\bw\u0010\u0013R\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R(\u0010\u007f\u001a\u00020~2\u0006\u0010\u0007\u001a\u00020~@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001d\u0010\u008a\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0011\"\u0005\b\u008c\u0001\u0010\u0013R$\u0010\u008d\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0092\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R$\u0010\u0093\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0092\u0001\u001a\u0006\b\u0094\u0001\u0010\u008f\u0001\"\u0006\b\u0095\u0001\u0010\u0091\u0001R\u001d\u0010\u0096\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0011\"\u0005\b\u0098\u0001\u0010\u0013R\"\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R \u0010\u009f\u0001\u001a\u00030 \u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001¨\u0006Æ\u0001"}, d2 = {"Lcom/mrousavy/camera/react/CameraView;", "Landroid/widget/FrameLayout;", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lcom/mrousavy/camera/core/types/PreviewViewType;", "androidPreviewViewType", "getAndroidPreviewViewType", "()Lcom/mrousavy/camera/core/types/PreviewViewType;", "setAndroidPreviewViewType", "(Lcom/mrousavy/camera/core/types/PreviewViewType;)V", "audio", "", "getAudio", "()Z", "setAudio", "(Z)V", "cameraId", "", "getCameraId", "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "cameraSession", "Lcom/mrousavy/camera/core/CameraSession;", "getCameraSession$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraSession;", "codeScannerOptions", "Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "getCodeScannerOptions", "()Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "setCodeScannerOptions", "(Lcom/mrousavy/camera/core/types/CodeScannerOptions;)V", "currentConfigureCall", "", "enableDepthData", "getEnableDepthData", "setEnableDepthData", "enableFrameProcessor", "getEnableFrameProcessor", "setEnableFrameProcessor", "enableLocation", "getEnableLocation", "setEnableLocation", "enablePortraitEffectsMatteDelivery", "getEnablePortraitEffectsMatteDelivery", "setEnablePortraitEffectsMatteDelivery", "enableZoomGesture", "getEnableZoomGesture", "setEnableZoomGesture", "exposure", "", "getExposure", "()D", "setExposure", "(D)V", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "getFormat", "()Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "setFormat", "(Lcom/mrousavy/camera/core/types/CameraDeviceFormat;)V", "fpsSampleCollector", "Lcom/mrousavy/camera/react/FpsSampleCollector;", "frameProcessor", "Lcom/mrousavy/camera/frameprocessors/FrameProcessor;", "getFrameProcessor$react_native_vision_camera_release", "()Lcom/mrousavy/camera/frameprocessors/FrameProcessor;", "setFrameProcessor$react_native_vision_camera_release", "(Lcom/mrousavy/camera/frameprocessors/FrameProcessor;)V", "isActive", "setActive", "isMirrored", "setMirrored", "isMounted", "lowLightBoost", "getLowLightBoost", "setLowLightBoost", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "maxFps", "", "getMaxFps", "()Ljava/lang/Integer;", "setMaxFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "minFps", "getMinFps", "setMinFps", "outputOrientation", "Lcom/mrousavy/camera/core/types/OutputOrientation;", "getOutputOrientation", "()Lcom/mrousavy/camera/core/types/OutputOrientation;", "setOutputOrientation", "(Lcom/mrousavy/camera/core/types/OutputOrientation;)V", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, "getPhoto", "setPhoto", "photoHdr", "getPhotoHdr", "setPhotoHdr", "photoQualityBalance", "Lcom/mrousavy/camera/core/types/QualityBalance;", "getPhotoQualityBalance", "()Lcom/mrousavy/camera/core/types/QualityBalance;", "setPhotoQualityBalance", "(Lcom/mrousavy/camera/core/types/QualityBalance;)V", "pixelFormat", "Lcom/mrousavy/camera/core/types/PixelFormat;", "getPixelFormat", "()Lcom/mrousavy/camera/core/types/PixelFormat;", "setPixelFormat", "(Lcom/mrousavy/camera/core/types/PixelFormat;)V", "preview", "getPreview", "setPreview", "previewView", "Landroidx/camera/view/PreviewView;", "getPreviewView$react_native_vision_camera_release", "()Landroidx/camera/view/PreviewView;", "setPreviewView$react_native_vision_camera_release", "(Landroidx/camera/view/PreviewView;)V", "Lcom/mrousavy/camera/core/types/ResizeMode;", ViewProps.RESIZE_MODE, "getResizeMode", "()Lcom/mrousavy/camera/core/types/ResizeMode;", "setResizeMode", "(Lcom/mrousavy/camera/core/types/ResizeMode;)V", "torch", "Lcom/mrousavy/camera/core/types/Torch;", "getTorch", "()Lcom/mrousavy/camera/core/types/Torch;", "setTorch", "(Lcom/mrousavy/camera/core/types/Torch;)V", "video", "getVideo", "setVideo", "videoBitRateMultiplier", "getVideoBitRateMultiplier", "()Ljava/lang/Double;", "setVideoBitRateMultiplier", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "videoBitRateOverride", "getVideoBitRateOverride", "setVideoBitRateOverride", "videoHdr", "getVideoHdr", "setVideoHdr", "videoStabilizationMode", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "getVideoStabilizationMode", "()Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lcom/mrousavy/camera/core/types/VideoStabilizationMode;)V", "zoom", "", "getZoom", "()F", "setZoom", "(F)V", "createPreviewView", "destroy", "", "onAttachedToWindow", "onAverageFpsChanged", "averageFps", "onCodeScanned", "codes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "onDetachedFromWindow", "onError", "error", "", "onFrame", "frame", "Lcom/mrousavy/camera/frameprocessors/Frame;", "onInitialized", "onOutputOrientationChanged", "Lcom/mrousavy/camera/core/types/Orientation;", "onPreviewOrientationChanged", "previewOrientation", "onShutter", "type", "Lcom/mrousavy/camera/core/types/ShutterType;", "onStarted", "onStopped", "update", "updatePreview", "updateZoomGesture", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView extends FrameLayout implements CameraSession.Callback, FpsSampleCollector.Callback {
    public static final String TAG = "CameraView";
    private PreviewViewType androidPreviewViewType;
    private boolean audio;
    private String cameraId;
    private final CameraSession cameraSession;
    private CodeScannerOptions codeScannerOptions;
    private long currentConfigureCall;
    private boolean enableDepthData;
    private boolean enableFrameProcessor;
    private boolean enableLocation;
    private boolean enablePortraitEffectsMatteDelivery;
    private boolean enableZoomGesture;
    private double exposure;
    private CameraDeviceFormat format;
    private final FpsSampleCollector fpsSampleCollector;
    private FrameProcessor frameProcessor;
    private boolean isActive;
    private boolean isMirrored;
    private boolean isMounted;
    private boolean lowLightBoost;
    private final CoroutineScope mainCoroutineScope;
    private Integer maxFps;
    private Integer minFps;
    private OutputOrientation outputOrientation;
    private boolean photo;
    private boolean photoHdr;
    private QualityBalance photoQualityBalance;
    private PixelFormat pixelFormat;
    private boolean preview;
    private PreviewView previewView;
    private ResizeMode resizeMode;
    private Torch torch;
    private boolean video;
    private Double videoBitRateMultiplier;
    private Double videoBitRateOverride;
    private boolean videoHdr;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pixelFormat = PixelFormat.YUV;
        this.preview = true;
        this.photoQualityBalance = QualityBalance.SPEED;
        this.torch = Torch.OFF;
        this.zoom = 1.0f;
        this.outputOrientation = OutputOrientation.DEVICE;
        this.androidPreviewViewType = PreviewViewType.SURFACE_VIEW;
        this.resizeMode = ResizeMode.COVER;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.currentConfigureCall = System.currentTimeMillis();
        this.fpsSampleCollector = new FpsSampleCollector(this);
        setClipToOutline(true);
        this.cameraSession = new CameraSession(context, this);
        ViewGroup_installHierarchyFitterKt.installHierarchyFitter(this);
        updatePreview();
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final void setCameraId(String str) {
        this.cameraId = str;
    }

    public final boolean getEnableDepthData() {
        return this.enableDepthData;
    }

    public final void setEnableDepthData(boolean z) {
        this.enableDepthData = z;
    }

    public final boolean getEnablePortraitEffectsMatteDelivery() {
        return this.enablePortraitEffectsMatteDelivery;
    }

    public final void setEnablePortraitEffectsMatteDelivery(boolean z) {
        this.enablePortraitEffectsMatteDelivery = z;
    }

    /* renamed from: isMirrored, reason: from getter */
    public final boolean getIsMirrored() {
        return this.isMirrored;
    }

    public final void setMirrored(boolean z) {
        this.isMirrored = z;
    }

    public final boolean getPhoto() {
        return this.photo;
    }

    public final void setPhoto(boolean z) {
        this.photo = z;
    }

    public final boolean getVideo() {
        return this.video;
    }

    public final void setVideo(boolean z) {
        this.video = z;
    }

    public final boolean getAudio() {
        return this.audio;
    }

    public final void setAudio(boolean z) {
        this.audio = z;
    }

    public final boolean getEnableFrameProcessor() {
        return this.enableFrameProcessor;
    }

    public final void setEnableFrameProcessor(boolean z) {
        this.enableFrameProcessor = z;
    }

    public final PixelFormat getPixelFormat() {
        return this.pixelFormat;
    }

    public final void setPixelFormat(PixelFormat pixelFormat) {
        Intrinsics.checkNotNullParameter(pixelFormat, "<set-?>");
        this.pixelFormat = pixelFormat;
    }

    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    public final void setEnableLocation(boolean z) {
        this.enableLocation = z;
    }

    public final boolean getPreview() {
        return this.preview;
    }

    public final void setPreview(boolean z) {
        this.preview = z;
        updatePreview();
    }

    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final void setFormat(CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    public final Integer getMinFps() {
        return this.minFps;
    }

    public final void setMinFps(Integer num) {
        this.minFps = num;
    }

    public final Integer getMaxFps() {
        return this.maxFps;
    }

    public final void setMaxFps(Integer num) {
        this.maxFps = num;
    }

    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final void setVideoStabilizationMode(VideoStabilizationMode videoStabilizationMode) {
        this.videoStabilizationMode = videoStabilizationMode;
    }

    public final boolean getVideoHdr() {
        return this.videoHdr;
    }

    public final void setVideoHdr(boolean z) {
        this.videoHdr = z;
    }

    public final boolean getPhotoHdr() {
        return this.photoHdr;
    }

    public final void setPhotoHdr(boolean z) {
        this.photoHdr = z;
    }

    public final Double getVideoBitRateOverride() {
        return this.videoBitRateOverride;
    }

    public final void setVideoBitRateOverride(Double d) {
        this.videoBitRateOverride = d;
    }

    public final Double getVideoBitRateMultiplier() {
        return this.videoBitRateMultiplier;
    }

    public final void setVideoBitRateMultiplier(Double d) {
        this.videoBitRateMultiplier = d;
    }

    public final QualityBalance getPhotoQualityBalance() {
        return this.photoQualityBalance;
    }

    public final void setPhotoQualityBalance(QualityBalance qualityBalance) {
        Intrinsics.checkNotNullParameter(qualityBalance, "<set-?>");
        this.photoQualityBalance = qualityBalance;
    }

    public final boolean getLowLightBoost() {
        return this.lowLightBoost;
    }

    public final void setLowLightBoost(boolean z) {
        this.lowLightBoost = z;
    }

    /* renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final Torch getTorch() {
        return this.torch;
    }

    public final void setTorch(Torch torch) {
        Intrinsics.checkNotNullParameter(torch, "<set-?>");
        this.torch = torch;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final double getExposure() {
        return this.exposure;
    }

    public final void setExposure(double d) {
        this.exposure = d;
    }

    public final OutputOrientation getOutputOrientation() {
        return this.outputOrientation;
    }

    public final void setOutputOrientation(OutputOrientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "<set-?>");
        this.outputOrientation = outputOrientation;
    }

    public final PreviewViewType getAndroidPreviewViewType() {
        return this.androidPreviewViewType;
    }

    public final void setAndroidPreviewViewType(PreviewViewType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.androidPreviewViewType = value;
        updatePreview();
    }

    public final boolean getEnableZoomGesture() {
        return this.enableZoomGesture;
    }

    public final void setEnableZoomGesture(boolean z) {
        this.enableZoomGesture = z;
        updateZoomGesture();
    }

    public final ResizeMode getResizeMode() {
        return this.resizeMode;
    }

    public final void setResizeMode(ResizeMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.resizeMode = value;
        updatePreview();
    }

    public final CodeScannerOptions getCodeScannerOptions() {
        return this.codeScannerOptions;
    }

    public final void setCodeScannerOptions(CodeScannerOptions codeScannerOptions) {
        this.codeScannerOptions = codeScannerOptions;
    }

    /* renamed from: getCameraSession$react_native_vision_camera_release, reason: from getter */
    public final CameraSession getCameraSession() {
        return this.cameraSession;
    }

    /* renamed from: getFrameProcessor$react_native_vision_camera_release, reason: from getter */
    public final FrameProcessor getFrameProcessor() {
        return this.frameProcessor;
    }

    public final void setFrameProcessor$react_native_vision_camera_release(FrameProcessor frameProcessor) {
        this.frameProcessor = frameProcessor;
    }

    /* renamed from: getPreviewView$react_native_vision_camera_release, reason: from getter */
    public final PreviewView getPreviewView() {
        return this.previewView;
    }

    public final void setPreviewView$react_native_vision_camera_release(PreviewView previewView) {
        this.previewView = previewView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Log.i("CameraView", "CameraView attached to window!");
        super.onAttachedToWindow();
        if (!this.isMounted) {
            this.isMounted = true;
            CameraView_EventsKt.invokeOnViewReady(this);
        }
        this.fpsSampleCollector.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Log.i("CameraView", "CameraView detached from window!");
        super.onDetachedFromWindow();
        this.fpsSampleCollector.stop();
    }

    public final void destroy() {
        this.cameraSession.close();
    }

    public final void update() {
        Log.i("CameraView", "Updating CameraSession...");
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.currentConfigureCall = jCurrentTimeMillis;
        BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, null, null, new AnonymousClass1(jCurrentTimeMillis, null), 3, null);
    }

    /* compiled from: CameraView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraView$update$1", f = "CameraView.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.react.CameraView$update$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $now;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$now = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraView.this.new AnonymousClass1(this.$now, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraSession cameraSession = CameraView.this.getCameraSession();
                final CameraView cameraView = CameraView.this;
                final long j = this.$now;
                this.label = 1;
                if (cameraSession.configure(new Function1<CameraConfiguration, Unit>() { // from class: com.mrousavy.camera.react.CameraView.update.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CameraConfiguration cameraConfiguration) throws CameraConfiguration.AbortThrow {
                        invoke2(cameraConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CameraConfiguration config) throws CameraConfiguration.AbortThrow {
                        Intrinsics.checkNotNullParameter(config, "config");
                        if (cameraView.currentConfigureCall != j) {
                            Log.i("CameraView", "A new configure { ... } call arrived, aborting this one...");
                            throw new CameraConfiguration.AbortThrow();
                        }
                        config.setCameraId(cameraView.getCameraId());
                        PreviewView previewView = cameraView.getPreviewView();
                        if (previewView != null) {
                            CameraConfiguration.Output.Enabled.Companion companion = CameraConfiguration.Output.Enabled.INSTANCE;
                            Preview.SurfaceProvider surfaceProvider = previewView.getSurfaceProvider();
                            Intrinsics.checkNotNullExpressionValue(surfaceProvider, "getSurfaceProvider(...)");
                            config.setPreview(companion.create(new CameraConfiguration.Preview(surfaceProvider)));
                        } else {
                            config.setPreview(CameraConfiguration.Output.Disabled.INSTANCE.create());
                        }
                        if (cameraView.getPhoto()) {
                            config.setPhoto(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Photo(cameraView.getIsMirrored(), cameraView.getPhotoHdr(), cameraView.getPhotoQualityBalance())));
                        } else {
                            config.setPhoto(CameraConfiguration.Output.Disabled.INSTANCE.create());
                        }
                        if (cameraView.getVideo() || cameraView.getEnableFrameProcessor()) {
                            config.setVideo(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Video(cameraView.getIsMirrored(), cameraView.getVideoHdr(), cameraView.getVideoBitRateOverride(), cameraView.getVideoBitRateMultiplier())));
                        } else {
                            config.setVideo(CameraConfiguration.Output.Disabled.INSTANCE.create());
                        }
                        if (cameraView.getEnableFrameProcessor()) {
                            config.setFrameProcessor(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.FrameProcessor(cameraView.getIsMirrored(), cameraView.getPixelFormat())));
                        } else {
                            config.setFrameProcessor(CameraConfiguration.Output.Disabled.INSTANCE.create());
                        }
                        if (cameraView.getAudio()) {
                            config.setAudio(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Audio(Unit.INSTANCE)));
                        } else {
                            config.setAudio(CameraConfiguration.Output.Disabled.INSTANCE.create());
                        }
                        config.setEnableLocation(cameraView.getEnableLocation() && cameraView.getIsActive());
                        CodeScannerOptions codeScannerOptions = cameraView.getCodeScannerOptions();
                        if (codeScannerOptions != null) {
                            config.setCodeScanner(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.CodeScanner(codeScannerOptions.getCodeTypes())));
                        } else {
                            config.setCodeScanner(CameraConfiguration.Output.Disabled.INSTANCE.create());
                        }
                        config.setOutputOrientation(cameraView.getOutputOrientation());
                        config.setFormat(cameraView.getFormat());
                        config.setMinFps(cameraView.getMinFps());
                        config.setMaxFps(cameraView.getMaxFps());
                        config.setEnableLowLightBoost(cameraView.getLowLightBoost());
                        config.setTorch(cameraView.getTorch());
                        config.setExposure(Double.valueOf(cameraView.getExposure()));
                        config.setZoom(cameraView.getZoom());
                        config.setActive(cameraView.getIsActive());
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void updateZoomGesture() {
        if (this.enableZoomGesture) {
            final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.mrousavy.camera.react.CameraView$updateZoomGesture$scaleGestureDetector$1
                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(ScaleGestureDetector detector) {
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    CameraView cameraView = this.this$0;
                    cameraView.setZoom(cameraView.getZoom() * detector.getScaleFactor());
                    this.this$0.update();
                    return true;
                }
            });
            setOnTouchListener(new View.OnTouchListener() { // from class: com.mrousavy.camera.react.CameraView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return CameraView.updateZoomGesture$lambda$0(scaleGestureDetector, view, motionEvent);
                }
            });
        } else {
            setOnTouchListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateZoomGesture$lambda$0(ScaleGestureDetector scaleGestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "$scaleGestureDetector");
        return scaleGestureDetector.onTouchEvent(motionEvent);
    }

    /* compiled from: CameraView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraView$updatePreview$1", f = "CameraView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.react.CameraView$updatePreview$1, reason: invalid class name and case insensitive filesystem */
    static final class C04501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04501(Continuation<? super C04501> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraView.this.new C04501(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (CameraView.this.getPreview() && CameraView.this.getPreviewView() == null) {
                CameraView cameraView = CameraView.this;
                cameraView.setPreviewView$react_native_vision_camera_release(cameraView.createPreviewView());
                CameraView cameraView2 = CameraView.this;
                cameraView2.addView(cameraView2.getPreviewView());
            } else if (!CameraView.this.getPreview() && CameraView.this.getPreviewView() != null) {
                CameraView cameraView3 = CameraView.this;
                cameraView3.removeView(cameraView3.getPreviewView());
                CameraView.this.setPreviewView$react_native_vision_camera_release(null);
            }
            PreviewView previewView = CameraView.this.getPreviewView();
            if (previewView != null) {
                CameraView cameraView4 = CameraView.this;
                previewView.setImplementationMode(cameraView4.getAndroidPreviewViewType().toPreviewImplementationMode());
                previewView.setScaleType(cameraView4.getResizeMode().toScaleType());
            }
            CameraView.this.update();
            return Unit.INSTANCE;
        }
    }

    private final void updatePreview() {
        BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, null, null, new C04501(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreviewView createPreviewView() {
        PreviewView previewView = new PreviewView(getContext());
        ViewGroup_installHierarchyFitterKt.installHierarchyFitter(previewView);
        previewView.setImplementationMode(this.androidPreviewViewType.toPreviewImplementationMode());
        previewView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        previewView.getPreviewStreamState().observe(this.cameraSession, new CameraView$sam$androidx_lifecycle_Observer$0(new Function1<PreviewView.StreamState, Unit>() { // from class: com.mrousavy.camera.react.CameraView$createPreviewView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PreviewView.StreamState streamState) {
                invoke2(streamState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PreviewView.StreamState streamState) {
                Log.i("CameraView", "PreviewView Stream State changed to " + streamState);
                boolean z = streamState == PreviewView.StreamState.STREAMING;
                if (z != booleanRef.element) {
                    if (z) {
                        CameraView_EventsKt.invokeOnPreviewStarted(this);
                    } else {
                        CameraView_EventsKt.invokeOnPreviewStopped(this);
                    }
                    booleanRef.element = z;
                }
            }
        }));
        return previewView;
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.fpsSampleCollector.onTick();
        FrameProcessor frameProcessor = this.frameProcessor;
        if (frameProcessor != null) {
            frameProcessor.call(frame);
        }
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        CameraView_EventsKt.invokeOnError(this, error);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onInitialized() {
        CameraView_EventsKt.invokeOnInitialized(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onStarted() {
        CameraView_EventsKt.invokeOnStarted(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onStopped() {
        CameraView_EventsKt.invokeOnStopped(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onShutter(ShutterType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        CameraView_EventsKt.invokeOnShutter(this, type);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onOutputOrientationChanged(Orientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        CameraView_EventsKt.invokeOnOutputOrientationChanged(this, outputOrientation);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onPreviewOrientationChanged(Orientation previewOrientation) {
        Intrinsics.checkNotNullParameter(previewOrientation, "previewOrientation");
        CameraView_EventsKt.invokeOnPreviewOrientationChanged(this, previewOrientation);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onCodeScanned(List<? extends Barcode> codes, CodeScannerFrame scannerFrame) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(scannerFrame, "scannerFrame");
        CameraView_EventsKt.invokeOnCodeScanned(this, codes, scannerFrame);
    }

    @Override // com.mrousavy.camera.react.FpsSampleCollector.Callback
    public void onAverageFpsChanged(double averageFps) {
        CameraView_EventsKt.invokeOnAverageFpsChanged(this, averageFps);
    }
}
