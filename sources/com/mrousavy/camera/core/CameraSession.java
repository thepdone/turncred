package com.mrousavy.camera.core;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.camera.core.Camera;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.OrientationManager;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.frameprocessors.Frame;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: CameraSession.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0085\u0001\u0086\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010u\u001a\u00020vH\u0000¢\u0006\u0002\bwJ\r\u0010x\u001a\u00020vH\u0000¢\u0006\u0002\byJ\b\u0010z\u001a\u00020vH\u0016J2\u0010{\u001a\u00020v2!\u0010|\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b~\u0012\b\b\u007f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020v0}H\u0087@¢\u0006\u0003\u0010\u0080\u0001J\t\u0010\u0081\u0001\u001a\u00020vH\u0002J\u0011\u0010\u0082\u0001\u001a\u00020v2\u0006\u0010S\u001a\u00020TH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020v2\u0007\u0010\u0084\u0001\u001a\u00020TH\u0016R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R \u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001a\u00102\u001a\u000203X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000203X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u0014\u0010;\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020HX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020PX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010S\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010pX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006\u0087\u0001"}, d2 = {"Lcom/mrousavy/camera/core/CameraSession;", "Ljava/io/Closeable;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/mrousavy/camera/core/OrientationManager$Callback;", "context", "Landroid/content/Context;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "(Landroid/content/Context;Lcom/mrousavy/camera/core/CameraSession$Callback;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager$react_native_vision_camera_release", "()Landroid/media/AudioManager;", "getCallback$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraSession$Callback;", "camera", "Landroidx/camera/core/Camera;", "getCamera$react_native_vision_camera_release", "()Landroidx/camera/core/Camera;", "setCamera$react_native_vision_camera_release", "(Landroidx/camera/core/Camera;)V", "cameraProvider", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "getCameraProvider$react_native_vision_camera_release", "()Lcom/google/common/util/concurrent/ListenableFuture;", "codeScannerOutput", "Landroidx/camera/core/ImageAnalysis;", "getCodeScannerOutput$react_native_vision_camera_release", "()Landroidx/camera/core/ImageAnalysis;", "setCodeScannerOutput$react_native_vision_camera_release", "(Landroidx/camera/core/ImageAnalysis;)V", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration;", "getConfiguration$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraConfiguration;", "setConfiguration$react_native_vision_camera_release", "(Lcom/mrousavy/camera/core/CameraConfiguration;)V", "getContext$react_native_vision_camera_release", "()Landroid/content/Context;", "currentUseCases", "", "Landroidx/camera/core/UseCase;", "getCurrentUseCases$react_native_vision_camera_release", "()Ljava/util/List;", "setCurrentUseCases$react_native_vision_camera_release", "(Ljava/util/List;)V", "frameProcessorOutput", "getFrameProcessorOutput$react_native_vision_camera_release", "setFrameProcessorOutput$react_native_vision_camera_release", "isDestroyed", "", "isDestroyed$react_native_vision_camera_release", "()Z", "setDestroyed$react_native_vision_camera_release", "(Z)V", "isRecordingCanceled", "isRecordingCanceled$react_native_vision_camera_release", "setRecordingCanceled$react_native_vision_camera_release", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$react_native_vision_camera_release", "()Landroidx/lifecycle/LifecycleRegistry;", "mainExecutor", "Ljava/util/concurrent/Executor;", "getMainExecutor$react_native_vision_camera_release", "()Ljava/util/concurrent/Executor;", "metadataProvider", "Lcom/mrousavy/camera/core/MetadataProvider;", "getMetadataProvider$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/MetadataProvider;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex$react_native_vision_camera_release", "()Lkotlinx/coroutines/sync/Mutex;", "orientationManager", "Lcom/mrousavy/camera/core/OrientationManager;", "getOrientationManager$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/OrientationManager;", "outputOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "getOutputOrientation", "()Lcom/mrousavy/camera/core/types/Orientation;", "photoOutput", "Landroidx/camera/core/ImageCapture;", "getPhotoOutput$react_native_vision_camera_release", "()Landroidx/camera/core/ImageCapture;", "setPhotoOutput$react_native_vision_camera_release", "(Landroidx/camera/core/ImageCapture;)V", "previewOutput", "Landroidx/camera/core/Preview;", "getPreviewOutput$react_native_vision_camera_release", "()Landroidx/camera/core/Preview;", "setPreviewOutput$react_native_vision_camera_release", "(Landroidx/camera/core/Preview;)V", "recorderOutput", "Landroidx/camera/video/Recorder;", "getRecorderOutput$react_native_vision_camera_release", "()Landroidx/camera/video/Recorder;", "setRecorderOutput$react_native_vision_camera_release", "(Landroidx/camera/video/Recorder;)V", "recording", "Landroidx/camera/video/Recording;", "getRecording$react_native_vision_camera_release", "()Landroidx/camera/video/Recording;", "setRecording$react_native_vision_camera_release", "(Landroidx/camera/video/Recording;)V", "videoOutput", "Landroidx/camera/video/VideoCapture;", "getVideoOutput$react_native_vision_camera_release", "()Landroidx/camera/video/VideoCapture;", "setVideoOutput$react_native_vision_camera_release", "(Landroidx/camera/video/VideoCapture;)V", "checkCameraPermission", "", "checkCameraPermission$react_native_vision_camera_release", "checkMicrophonePermission", "checkMicrophonePermission$react_native_vision_camera_release", "close", "configure", "lambda", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureOrientation", "onOutputOrientationChanged", "onPreviewOrientationChanged", "previewOrientation", "Callback", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSession implements Closeable, LifecycleOwner, OrientationManager.Callback {
    public static final String TAG = "CameraSession";
    private final AudioManager audioManager;
    private final Callback callback;
    private Camera camera;
    private final ListenableFuture<ProcessCameraProvider> cameraProvider;
    private ImageAnalysis codeScannerOutput;
    private CameraConfiguration configuration;
    private final Context context;
    private List<? extends UseCase> currentUseCases;
    private ImageAnalysis frameProcessorOutput;
    private boolean isDestroyed;
    private boolean isRecordingCanceled;
    private final LifecycleRegistry lifecycleRegistry;
    private final Executor mainExecutor;
    private final MetadataProvider metadataProvider;
    private final Mutex mutex;
    private final OrientationManager orientationManager;
    private ImageCapture photoOutput;
    private Preview previewOutput;
    private Recorder recorderOutput;
    private Recording recording;
    private VideoCapture<Recorder> videoOutput;

    /* compiled from: CameraSession.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&¨\u0006\u001a"}, d2 = {"Lcom/mrousavy/camera/core/CameraSession$Callback;", "", "onCodeScanned", "", "codes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "onError", "error", "", "onFrame", "frame", "Lcom/mrousavy/camera/frameprocessors/Frame;", "onInitialized", "onOutputOrientationChanged", "outputOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "onPreviewOrientationChanged", "previewOrientation", "onShutter", "type", "Lcom/mrousavy/camera/core/types/ShutterType;", "onStarted", "onStopped", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Callback {
        void onCodeScanned(List<? extends Barcode> codes, CodeScannerFrame scannerFrame);

        void onError(Throwable error);

        void onFrame(Frame frame);

        void onInitialized();

        void onOutputOrientationChanged(Orientation outputOrientation);

        void onPreviewOrientationChanged(Orientation previewOrientation);

        void onShutter(ShutterType type);

        void onStarted();

        void onStopped();
    }

    /* compiled from: CameraSession.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession", f = "CameraSession.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 232, 149}, m = "configure", n = {"this", "lambda", "this", "lambda", "provider", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "config", "diff"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    /* renamed from: com.mrousavy.camera.core.CameraSession$configure$1, reason: invalid class name and case insensitive filesystem */
    static final class C04491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04491(Continuation<? super C04491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession.this.configure(null, this);
        }
    }

    public CameraSession(Context context, Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.callback = callback;
        this.cameraProvider = ProcessCameraProvider.INSTANCE.getInstance(context);
        this.currentUseCases = CollectionsKt.emptyList();
        this.metadataProvider = new MetadataProvider(context);
        this.orientationManager = new OrientationManager(context, this);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.lifecycleRegistry = lifecycleRegistry;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        Executor mainExecutor = ContextCompat.getMainExecutor(context);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
        this.mainExecutor = mainExecutor;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.mrousavy.camera.core.CameraSession.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Log.i(CameraSession.TAG, "Camera Lifecycle changed to " + event.getTargetState() + "!");
            }
        });
    }

    /* renamed from: getCallback$react_native_vision_camera_release, reason: from getter */
    public final Callback getCallback() {
        return this.callback;
    }

    /* renamed from: getContext$react_native_vision_camera_release, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: getConfiguration$react_native_vision_camera_release, reason: from getter */
    public final CameraConfiguration getConfiguration() {
        return this.configuration;
    }

    public final void setConfiguration$react_native_vision_camera_release(CameraConfiguration cameraConfiguration) {
        this.configuration = cameraConfiguration;
    }

    public final ListenableFuture<ProcessCameraProvider> getCameraProvider$react_native_vision_camera_release() {
        return this.cameraProvider;
    }

    /* renamed from: getCamera$react_native_vision_camera_release, reason: from getter */
    public final Camera getCamera() {
        return this.camera;
    }

    public final void setCamera$react_native_vision_camera_release(Camera camera) {
        this.camera = camera;
    }

    /* renamed from: getPreviewOutput$react_native_vision_camera_release, reason: from getter */
    public final Preview getPreviewOutput() {
        return this.previewOutput;
    }

    public final void setPreviewOutput$react_native_vision_camera_release(Preview preview) {
        this.previewOutput = preview;
    }

    /* renamed from: getPhotoOutput$react_native_vision_camera_release, reason: from getter */
    public final ImageCapture getPhotoOutput() {
        return this.photoOutput;
    }

    public final void setPhotoOutput$react_native_vision_camera_release(ImageCapture imageCapture) {
        this.photoOutput = imageCapture;
    }

    public final VideoCapture<Recorder> getVideoOutput$react_native_vision_camera_release() {
        return this.videoOutput;
    }

    public final void setVideoOutput$react_native_vision_camera_release(VideoCapture<Recorder> videoCapture) {
        this.videoOutput = videoCapture;
    }

    /* renamed from: getFrameProcessorOutput$react_native_vision_camera_release, reason: from getter */
    public final ImageAnalysis getFrameProcessorOutput() {
        return this.frameProcessorOutput;
    }

    public final void setFrameProcessorOutput$react_native_vision_camera_release(ImageAnalysis imageAnalysis) {
        this.frameProcessorOutput = imageAnalysis;
    }

    /* renamed from: getCodeScannerOutput$react_native_vision_camera_release, reason: from getter */
    public final ImageAnalysis getCodeScannerOutput() {
        return this.codeScannerOutput;
    }

    public final void setCodeScannerOutput$react_native_vision_camera_release(ImageAnalysis imageAnalysis) {
        this.codeScannerOutput = imageAnalysis;
    }

    public final List<UseCase> getCurrentUseCases$react_native_vision_camera_release() {
        return this.currentUseCases;
    }

    public final void setCurrentUseCases$react_native_vision_camera_release(List<? extends UseCase> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.currentUseCases = list;
    }

    /* renamed from: getMetadataProvider$react_native_vision_camera_release, reason: from getter */
    public final MetadataProvider getMetadataProvider() {
        return this.metadataProvider;
    }

    /* renamed from: getOrientationManager$react_native_vision_camera_release, reason: from getter */
    public final OrientationManager getOrientationManager() {
        return this.orientationManager;
    }

    /* renamed from: getRecorderOutput$react_native_vision_camera_release, reason: from getter */
    public final Recorder getRecorderOutput() {
        return this.recorderOutput;
    }

    public final void setRecorderOutput$react_native_vision_camera_release(Recorder recorder) {
        this.recorderOutput = recorder;
    }

    /* renamed from: getMutex$react_native_vision_camera_release, reason: from getter */
    public final Mutex getMutex() {
        return this.mutex;
    }

    /* renamed from: isDestroyed$react_native_vision_camera_release, reason: from getter */
    public final boolean getIsDestroyed() {
        return this.isDestroyed;
    }

    public final void setDestroyed$react_native_vision_camera_release(boolean z) {
        this.isDestroyed = z;
    }

    /* renamed from: getLifecycleRegistry$react_native_vision_camera_release, reason: from getter */
    public final LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    /* renamed from: getRecording$react_native_vision_camera_release, reason: from getter */
    public final Recording getRecording() {
        return this.recording;
    }

    public final void setRecording$react_native_vision_camera_release(Recording recording) {
        this.recording = recording;
    }

    /* renamed from: isRecordingCanceled$react_native_vision_camera_release, reason: from getter */
    public final boolean getIsRecordingCanceled() {
        return this.isRecordingCanceled;
    }

    public final void setRecordingCanceled$react_native_vision_camera_release(boolean z) {
        this.isRecordingCanceled = z;
    }

    /* renamed from: getAudioManager$react_native_vision_camera_release, reason: from getter */
    public final AudioManager getAudioManager() {
        return this.audioManager;
    }

    /* renamed from: getMainExecutor$react_native_vision_camera_release, reason: from getter */
    public final Executor getMainExecutor() {
        return this.mainExecutor;
    }

    public final Orientation getOutputOrientation() {
        return this.orientationManager.getOutputOrientation();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(TAG, "Closing CameraSession...");
        this.isDestroyed = true;
        this.orientationManager.stopOrientationUpdates();
        if (UiThreadUtil.isOnUiThread()) {
            getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.CameraSession$close$$inlined$runOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
                }
            });
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:76:0x0191, B:38:0x00b1, B:39:0x00b9, B:40:0x00bc, B:42:0x00cc, B:43:0x00d3, B:45:0x00d7, B:46:0x00de, B:81:0x019c), top: B:93:0x00b1, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3 A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:76:0x0191, B:38:0x00b1, B:39:0x00b9, B:40:0x00bc, B:42:0x00cc, B:43:0x00d3, B:45:0x00d7, B:46:0x00de, B:81:0x019c), top: B:93:0x00b1, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0120 A[Catch: all -> 0x004a, TryCatch #6 {all -> 0x004a, blocks: (B:14:0x0045, B:58:0x011a, B:60:0x0120, B:61:0x0123, B:63:0x0129, B:64:0x012c, B:66:0x0132, B:67:0x013b, B:69:0x0141, B:70:0x014a), top: B:104:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0129 A[Catch: all -> 0x004a, TryCatch #6 {all -> 0x004a, blocks: (B:14:0x0045, B:58:0x011a, B:60:0x0120, B:61:0x0123, B:63:0x0129, B:64:0x012c, B:66:0x0132, B:67:0x013b, B:69:0x0141, B:70:0x014a), top: B:104:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0132 A[Catch: all -> 0x004a, TryCatch #6 {all -> 0x004a, blocks: (B:14:0x0045, B:58:0x011a, B:60:0x0120, B:61:0x0123, B:63:0x0129, B:64:0x012c, B:66:0x0132, B:67:0x013b, B:69:0x0141, B:70:0x014a), top: B:104:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0141 A[Catch: all -> 0x004a, TryCatch #6 {all -> 0x004a, blocks: (B:14:0x0045, B:58:0x011a, B:60:0x0120, B:61:0x0123, B:63:0x0129, B:64:0x012c, B:66:0x0132, B:67:0x013b, B:69:0x0141, B:70:0x014a), top: B:104:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object configure(kotlin.jvm.functions.Function1<? super com.mrousavy.camera.core.CameraConfiguration, kotlin.Unit> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.configure(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void checkCameraPermission$react_native_vision_camera_release() throws CameraPermissionError {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            throw new CameraPermissionError();
        }
    }

    public final void checkMicrophonePermission$react_native_vision_camera_release() throws MicrophonePermissionError {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") != 0) {
            throw new MicrophonePermissionError();
        }
    }

    @Override // com.mrousavy.camera.core.OrientationManager.Callback
    public void onOutputOrientationChanged(Orientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Log.i(TAG, "Output orientation changed! " + outputOrientation);
        configureOrientation();
        this.callback.onOutputOrientationChanged(outputOrientation);
    }

    @Override // com.mrousavy.camera.core.OrientationManager.Callback
    public void onPreviewOrientationChanged(Orientation previewOrientation) {
        Intrinsics.checkNotNullParameter(previewOrientation, "previewOrientation");
        Log.i(TAG, "Preview orientation changed! " + previewOrientation);
        configureOrientation();
        this.callback.onPreviewOrientationChanged(previewOrientation);
    }

    private final void configureOrientation() {
        int surfaceRotation = this.orientationManager.getPreviewOrientation().toSurfaceRotation();
        Preview preview = this.previewOutput;
        if (preview != null) {
            preview.setTargetRotation(surfaceRotation);
        }
        ImageAnalysis imageAnalysis = this.codeScannerOutput;
        if (imageAnalysis != null) {
            imageAnalysis.setTargetRotation(surfaceRotation);
        }
        int surfaceRotation2 = this.orientationManager.getOutputOrientation().toSurfaceRotation();
        ImageCapture imageCapture = this.photoOutput;
        if (imageCapture != null) {
            imageCapture.setTargetRotation(surfaceRotation2);
        }
        VideoCapture<Recorder> videoCapture = this.videoOutput;
        if (videoCapture == null) {
            return;
        }
        videoCapture.setTargetRotation(surfaceRotation2);
    }
}
