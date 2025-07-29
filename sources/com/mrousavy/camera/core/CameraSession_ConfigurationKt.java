package com.mrousavy.camera.core;

import android.util.Log;
import android.util.Range;
import androidx.camera.core.Camera;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.ZoomState;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.lifecycle.Lifecycle;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.extensions.ImageAnalysis_Builder_setTargetFrameRateKt;
import com.mrousavy.camera.core.extensions.ResolutionSelector_forSizeKt;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.core.utils.CamcorderProfileUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: CameraSession+Configuration.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\f0\tH\u0002\u001a\"\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0081@¢\u0006\u0002\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0012H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0012H\u0000¨\u0006\u0018"}, d2 = {"assertFormatRequirement", "", "propName", "", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "throwIfNotMet", "Lcom/mrousavy/camera/core/CameraError;", "requirement", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "configureCamera", "Lcom/mrousavy/camera/core/CameraSession;", "provider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration;", "(Lcom/mrousavy/camera/core/CameraSession;Landroidx/camera/lifecycle/ProcessCameraProvider;Lcom/mrousavy/camera/core/CameraConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureIsActive", "config", "configureOutputs", "configureSideProps", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSession_ConfigurationKt {

    /* compiled from: CameraSession+Configuration.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession_ConfigurationKt", f = "CameraSession+Configuration.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {259, 271}, m = "configureCamera", n = {"$this$configureCamera", "provider", "configuration", "useCases", "isStreamingHDR", "needsImageAnalysis", "enableHdrExtension", "$this$configureCamera", "provider", "configuration", "useCases"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3"})
    /* renamed from: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession_ConfigurationKt.configureCamera(null, null, null, this);
        }
    }

    private static final void assertFormatRequirement(String str, CameraDeviceFormat cameraDeviceFormat, CameraError cameraError, Function1<? super CameraDeviceFormat, Boolean> function1) throws CameraError {
        if (cameraDeviceFormat == null) {
            throw new PropRequiresFormatToBeNonNullError(str);
        }
        if (!function1.invoke(cameraDeviceFormat).booleanValue()) {
            throw cameraError;
        }
    }

    public static final void configureOutputs(CameraSession cameraSession, final CameraConfiguration configuration) throws CameraError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        String cameraId = configuration.getCameraId();
        Intrinsics.checkNotNull(cameraId);
        Log.i(CameraSession.TAG, "Creating new Outputs for Camera #" + cameraId + "...");
        final Range<Integer> targetFpsRange = configuration.getTargetFpsRange();
        CameraDeviceFormat format = configuration.getFormat();
        Log.i(CameraSession.TAG, "Using FPS Range: " + targetFpsRange);
        CameraConfiguration.Output<CameraConfiguration.Photo> photo = configuration.getPhoto();
        CameraConfiguration.Output.Enabled enabled = photo instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) photo : null;
        CameraConfiguration.Output<CameraConfiguration.Video> video = configuration.getVideo();
        CameraConfiguration.Output.Enabled enabled2 = video instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) video : null;
        CameraConfiguration.Output<CameraConfiguration.Preview> preview = configuration.getPreview();
        CameraConfiguration.Output.Enabled enabled3 = preview instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) preview : null;
        if (enabled3 != null) {
            Log.i(CameraSession.TAG, "Creating Preview output...");
            Preview.Builder builder = new Preview.Builder();
            if (configuration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.CINEMATIC)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(configuration.getVideoStabilizationMode()), new Function1<CameraDeviceFormat, Boolean>() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$preview$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(CameraDeviceFormat it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(it.getVideoStabilizationModes().contains(configuration.getVideoStabilizationMode()));
                    }
                });
                builder.setPreviewStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Object upper = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper).intValue()), new Function1<CameraDeviceFormat, Boolean>() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$preview$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Boolean invoke(com.mrousavy.camera.core.types.CameraDeviceFormat r7) {
                        /*
                            r6 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                            android.util.Range<java.lang.Integer> r0 = r1
                            java.lang.Comparable r0 = r0.getLower()
                            java.lang.Integer r0 = (java.lang.Integer) r0
                            r1 = 0
                            if (r0 == 0) goto L1a
                            int r0 = r0.intValue()
                            double r2 = (double) r0
                            java.lang.Double r0 = java.lang.Double.valueOf(r2)
                            goto L1b
                        L1a:
                            r0 = r1
                        L1b:
                            double r2 = r0.doubleValue()
                            double r4 = r7.getMinFps()
                            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                            if (r0 < 0) goto L48
                            android.util.Range<java.lang.Integer> r0 = r1
                            java.lang.Comparable r0 = r0.getUpper()
                            java.lang.Integer r0 = (java.lang.Integer) r0
                            if (r0 == 0) goto L3a
                            int r0 = r0.intValue()
                            double r0 = (double) r0
                            java.lang.Double r1 = java.lang.Double.valueOf(r0)
                        L3a:
                            double r0 = r1.doubleValue()
                            double r2 = r7.getMaxFps()
                            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                            if (r7 > 0) goto L48
                            r7 = 1
                            goto L49
                        L48:
                            r7 = 0
                        L49:
                            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$preview$1$2.invoke(com.mrousavy.camera.core.types.CameraDeviceFormat):java.lang.Boolean");
                    }
                });
                builder.setTargetFrameRate(targetFpsRange);
            }
            if (format != null) {
                ResolutionSelector resolutionSelectorBuild = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), enabled2 != null ? format.getVideoSize() : format.getPhotoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "build(...)");
                builder.setResolutionSelector(resolutionSelectorBuild);
            }
            Preview previewBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(previewBuild, "build(...)");
            previewBuild.setSurfaceProvider(((CameraConfiguration.Preview) enabled3.getConfig()).getSurfaceProvider());
            cameraSession.setPreviewOutput$react_native_vision_camera_release(previewBuild);
        } else {
            cameraSession.setPreviewOutput$react_native_vision_camera_release(null);
        }
        if (enabled != null) {
            Log.i(CameraSession.TAG, "Creating Photo output...");
            ImageCapture.Builder builder2 = new ImageCapture.Builder();
            builder2.setCaptureMode(((CameraConfiguration.Photo) enabled.getConfig()).getPhotoQualityBalance().toCaptureMode());
            if (format != null) {
                Log.i(CameraSession.TAG, "Photo size: " + format.getPhotoSize());
                ResolutionSelector resolutionSelectorBuild2 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getPhotoSize()).setAllowedResolutionMode(1).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild2, "build(...)");
                builder2.setResolutionSelector(resolutionSelectorBuild2);
            }
            ImageCapture imageCaptureBuild = builder2.build();
            Intrinsics.checkNotNullExpressionValue(imageCaptureBuild, "build(...)");
            cameraSession.setPhotoOutput$react_native_vision_camera_release(imageCaptureBuild);
        } else {
            cameraSession.setPhotoOutput$react_native_vision_camera_release(null);
        }
        if (enabled2 != null) {
            Log.i(CameraSession.TAG, "Creating Video output...");
            Recorder recorderOutput = cameraSession.getRecorderOutput();
            if (cameraSession.getRecording() != null && recorderOutput != null) {
                Log.i(CameraSession.TAG, "Re-using active Recorder because we are currently recording...");
            } else {
                Log.i(CameraSession.TAG, "Creating new Recorder...");
                Recorder.Builder builder3 = new Recorder.Builder();
                if (format != null) {
                    builder3.setQualitySelector(format.getVideoQualitySelector());
                }
                Double bitRateOverride = ((CameraConfiguration.Video) enabled2.getConfig()).getBitRateOverride();
                if (bitRateOverride != null) {
                    builder3.setTargetVideoEncodingBitRate((int) (bitRateOverride.doubleValue() * 1000000));
                }
                Double bitRateMultiplier = ((CameraConfiguration.Video) enabled2.getConfig()).getBitRateMultiplier();
                if (bitRateMultiplier != null) {
                    double dDoubleValue = bitRateMultiplier.doubleValue();
                    if (format == null) {
                        throw new PropRequiresFormatToBeNonNullError("videoBitRate");
                    }
                    if (CamcorderProfileUtils.INSTANCE.getRecommendedBitRate(cameraId, format.getVideoSize()) != null) {
                        builder3.setTargetVideoEncodingBitRate((int) (r2.intValue() * dDoubleValue));
                    }
                }
                recorderOutput = builder3.build();
                Intrinsics.checkNotNull(recorderOutput);
            }
            VideoCapture.Builder builder4 = new VideoCapture.Builder(recorderOutput);
            if (((CameraConfiguration.Video) enabled2.getConfig()).isMirrored()) {
                builder4.setMirrorMode(1);
            } else {
                builder4.setMirrorMode(0);
            }
            if (configuration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.STANDARD)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(configuration.getVideoStabilizationMode()), new Function1<CameraDeviceFormat, Boolean>() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$video$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(CameraDeviceFormat it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(it.getVideoStabilizationModes().contains(configuration.getVideoStabilizationMode()));
                    }
                });
                builder4.setVideoStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Object upper2 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper2, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper2).intValue()), new Function1<CameraDeviceFormat, Boolean>() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$video$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Boolean invoke(com.mrousavy.camera.core.types.CameraDeviceFormat r7) {
                        /*
                            r6 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                            android.util.Range<java.lang.Integer> r0 = r1
                            java.lang.Comparable r0 = r0.getLower()
                            java.lang.Integer r0 = (java.lang.Integer) r0
                            r1 = 0
                            if (r0 == 0) goto L1a
                            int r0 = r0.intValue()
                            double r2 = (double) r0
                            java.lang.Double r0 = java.lang.Double.valueOf(r2)
                            goto L1b
                        L1a:
                            r0 = r1
                        L1b:
                            double r2 = r0.doubleValue()
                            double r4 = r7.getMinFps()
                            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                            if (r0 < 0) goto L48
                            android.util.Range<java.lang.Integer> r0 = r1
                            java.lang.Comparable r0 = r0.getUpper()
                            java.lang.Integer r0 = (java.lang.Integer) r0
                            if (r0 == 0) goto L3a
                            int r0 = r0.intValue()
                            double r0 = (double) r0
                            java.lang.Double r1 = java.lang.Double.valueOf(r0)
                        L3a:
                            double r0 = r1.doubleValue()
                            double r2 = r7.getMaxFps()
                            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                            if (r7 > 0) goto L48
                            r7 = 1
                            goto L49
                        L48:
                            r7 = 0
                        L49:
                            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$video$1$2.invoke(com.mrousavy.camera.core.types.CameraDeviceFormat):java.lang.Boolean");
                    }
                });
                builder4.setTargetFrameRate(targetFpsRange);
            }
            if (((CameraConfiguration.Video) enabled2.getConfig()).getEnableHdr()) {
                assertFormatRequirement("videoHdr", format, new InvalidVideoHdrError(), new Function1<CameraDeviceFormat, Boolean>() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$video$1$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(CameraDeviceFormat it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(it.getSupportsVideoHdr());
                    }
                });
                builder4.setDynamicRange(DynamicRange.HDR_UNSPECIFIED_10_BIT);
            }
            if (format != null) {
                Log.i(CameraSession.TAG, "Video size: " + format.getVideoSize());
                ResolutionSelector resolutionSelectorBuild3 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild3, "build(...)");
                builder4.setResolutionSelector(resolutionSelectorBuild3);
            }
            VideoCapture<Recorder> videoCaptureBuild = builder4.build();
            Intrinsics.checkNotNullExpressionValue(videoCaptureBuild, "build(...)");
            cameraSession.setVideoOutput$react_native_vision_camera_release(videoCaptureBuild);
            cameraSession.setRecorderOutput$react_native_vision_camera_release(recorderOutput);
        } else {
            cameraSession.setVideoOutput$react_native_vision_camera_release(null);
            cameraSession.setRecorderOutput$react_native_vision_camera_release(null);
        }
        CameraConfiguration.Output<CameraConfiguration.FrameProcessor> frameProcessor = configuration.getFrameProcessor();
        CameraConfiguration.Output.Enabled enabled4 = frameProcessor instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) frameProcessor : null;
        if (enabled4 != null) {
            PixelFormat pixelFormat = ((CameraConfiguration.FrameProcessor) enabled4.getConfig()).getPixelFormat();
            Log.i(CameraSession.TAG, "Creating " + pixelFormat + " Frame Processor output...");
            ImageAnalysis.Builder builder5 = new ImageAnalysis.Builder();
            builder5.setBackpressureStrategy(1);
            builder5.setOutputImageFormat(pixelFormat.toImageAnalysisFormat());
            if (targetFpsRange != null) {
                Object upper3 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper3, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper3).intValue()), new Function1<CameraDeviceFormat, Boolean>() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$analyzer$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Boolean invoke(com.mrousavy.camera.core.types.CameraDeviceFormat r7) {
                        /*
                            r6 = this;
                            java.lang.String r0 = "it"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                            android.util.Range<java.lang.Integer> r0 = r1
                            java.lang.Comparable r0 = r0.getLower()
                            java.lang.Integer r0 = (java.lang.Integer) r0
                            r1 = 0
                            if (r0 == 0) goto L1a
                            int r0 = r0.intValue()
                            double r2 = (double) r0
                            java.lang.Double r0 = java.lang.Double.valueOf(r2)
                            goto L1b
                        L1a:
                            r0 = r1
                        L1b:
                            double r2 = r0.doubleValue()
                            double r4 = r7.getMinFps()
                            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                            if (r0 < 0) goto L48
                            android.util.Range<java.lang.Integer> r0 = r1
                            java.lang.Comparable r0 = r0.getUpper()
                            java.lang.Integer r0 = (java.lang.Integer) r0
                            if (r0 == 0) goto L3a
                            int r0 = r0.intValue()
                            double r0 = (double) r0
                            java.lang.Double r1 = java.lang.Double.valueOf(r0)
                        L3a:
                            double r0 = r1.doubleValue()
                            double r2 = r7.getMaxFps()
                            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                            if (r7 > 0) goto L48
                            r7 = 1
                            goto L49
                        L48:
                            r7 = 0
                        L49:
                            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureOutputs$analyzer$1$1.invoke(com.mrousavy.camera.core.types.CameraDeviceFormat):java.lang.Boolean");
                    }
                });
                ImageAnalysis_Builder_setTargetFrameRateKt.setTargetFrameRate(builder5, targetFpsRange);
            }
            if (format != null) {
                Log.i(CameraSession.TAG, "Frame Processor size: " + format.getVideoSize());
                ResolutionSelector resolutionSelectorBuild4 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild4, "build(...)");
                builder5.setResolutionSelector(resolutionSelectorBuild4);
            }
            ImageAnalysis imageAnalysisBuild = builder5.build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "build(...)");
            imageAnalysisBuild.setAnalyzer(CameraQueues.INSTANCE.getVideoQueue().getExecutor(), new FrameProcessorPipeline(cameraSession.getCallback()));
            cameraSession.setFrameProcessorOutput$react_native_vision_camera_release(imageAnalysisBuild);
        } else {
            cameraSession.setFrameProcessorOutput$react_native_vision_camera_release(null);
        }
        CameraConfiguration.Output<CameraConfiguration.CodeScanner> codeScanner = configuration.getCodeScanner();
        CameraConfiguration.Output.Enabled enabled5 = codeScanner instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) codeScanner : null;
        if (enabled5 != null) {
            Log.i(CameraSession.TAG, "Creating CodeScanner output...");
            ImageAnalysis imageAnalysisBuild2 = new ImageAnalysis.Builder().build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild2, "build(...)");
            imageAnalysisBuild2.setAnalyzer(CameraQueues.INSTANCE.getAnalyzerExecutor(), new CodeScannerPipeline((CameraConfiguration.CodeScanner) enabled5.getConfig(), cameraSession.getCallback()));
            cameraSession.setCodeScannerOutput$react_native_vision_camera_release(imageAnalysisBuild2);
        } else {
            cameraSession.setCodeScannerOutput$react_native_vision_camera_release(null);
        }
        Log.i(CameraSession.TAG, "Successfully created new Outputs for Camera #" + configuration.getCameraId() + "!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object configureCamera(com.mrousavy.camera.core.CameraSession r20, androidx.camera.lifecycle.ProcessCameraProvider r21, com.mrousavy.camera.core.CameraConfiguration r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) throws com.mrousavy.camera.core.NoCameraDeviceError, com.mrousavy.camera.core.PhotoHdrAndVideoHdrNotSupportedSimultaneously, com.mrousavy.camera.core.CameraPermissionError, com.mrousavy.camera.core.LowLightBoostNotSupportedWithHdr, com.mrousavy.camera.core.NoOutputsError {
        /*
            Method dump skipped, instructions count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_ConfigurationKt.configureCamera(com.mrousavy.camera.core.CameraSession, androidx.camera.lifecycle.ProcessCameraProvider, com.mrousavy.camera.core.CameraConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void configureSideProps(CameraSession cameraSession, CameraConfiguration config) throws CameraNotReadyError, FlashUnavailableError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        Camera camera = cameraSession.getCamera();
        if (camera == null) {
            throw new CameraNotReadyError();
        }
        ZoomState value = camera.getCameraInfo().getZoomState().getValue();
        if (!Intrinsics.areEqual(value != null ? Float.valueOf(value.getZoomRatio()) : null, config.getZoom())) {
            camera.getCameraControl().setZoomRatio(config.getZoom());
        }
        Integer value2 = camera.getCameraInfo().getTorchState().getValue();
        boolean z = value2 != null && value2.intValue() == 1;
        boolean z2 = config.getTorch() == Torch.ON;
        if (z != z2) {
            if (z2 && !camera.getCameraInfo().hasFlashUnit()) {
                throw new FlashUnavailableError();
            }
            camera.getCameraControl().enableTorch(z2);
        }
        int exposureCompensationIndex = camera.getCameraInfo().getExposureState().getExposureCompensationIndex();
        Double exposure = config.getExposure();
        int iRoundToInt = exposure != null ? MathKt.roundToInt(exposure.doubleValue()) : 0;
        if (exposureCompensationIndex != iRoundToInt) {
            camera.getCameraControl().setExposureCompensationIndex(iRoundToInt);
        }
    }

    public static final void configureIsActive(CameraSession cameraSession, CameraConfiguration config) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.isActive()) {
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.RESUMED);
        } else {
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        }
    }
}
