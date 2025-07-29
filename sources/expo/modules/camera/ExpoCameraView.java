package expo.modules.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.AudioManager;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DisplayOrientedMeteringPointFactory;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ZoomState;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.compose.ui.layout.LayoutKt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.LiveData;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import expo.modules.camera.CameraExceptions;
import expo.modules.camera.ExpoCameraView;
import expo.modules.camera.ExpoCameraView$orientationEventListener$2;
import expo.modules.camera.analyzers.BarcodeAnalyzer;
import expo.modules.camera.analyzers.BarcodeAnalyzerKt;
import expo.modules.camera.common.BarcodeScannedEvent;
import expo.modules.camera.common.CameraMountErrorEvent;
import expo.modules.camera.common.PictureSavedEvent;
import expo.modules.camera.records.BarcodeSettings;
import expo.modules.camera.records.BarcodeType;
import expo.modules.camera.records.CameraMode;
import expo.modules.camera.records.CameraRatio;
import expo.modules.camera.records.CameraType;
import expo.modules.camera.records.FlashMode;
import expo.modules.camera.records.FocusMode;
import expo.modules.camera.records.VideoQuality;
import expo.modules.camera.utils.FileSystemUtils;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import io.sentry.protocol.Response;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: ExpoCameraView.kt */
@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0002J\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J\t\u0010\u0093\u0001\u001a\u00020TH\u0007J\t\u0010\u0094\u0001\u001a\u00020=H\u0002J\u0010\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020w0\u0096\u0001H\u0002J\u000f\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020e0\u001bH\u0007JD\u0010\u0098\u0001\u001a$\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001j\n\u0012\u0005\u0012\u00030\u009b\u0001`\u009c\u0001\u0012\u0005\u0012\u00030\u009b\u00010\u0099\u00012\r\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020|0\u001b2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010 \u0001\u001a\u00020|H\u0002J\n\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J\u0013\u0010£\u0001\u001a\u00020T2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0012\u0010L\u001a\u00020T2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J6\u0010¨\u0001\u001a\u00020T2\u0007\u0010©\u0001\u001a\u00020\u000e2\u0007\u0010ª\u0001\u001a\u00020|2\u0007\u0010«\u0001\u001a\u00020|2\u0007\u0010¬\u0001\u001a\u00020|2\u0007\u0010\u00ad\u0001\u001a\u00020|H\u0014J\u001b\u0010®\u0001\u001a\u00020T2\u0007\u0010¯\u0001\u001a\u00020|2\u0007\u0010°\u0001\u001a\u00020|H\u0014J\u0010\u0010[\u001a\u00020T2\b\u0010±\u0001\u001a\u00030\u009b\u0001J\u0015\u0010²\u0001\u001a\u00020T2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0016J\u0015\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u00012\u0007\u0010·\u0001\u001a\u00020eH\u0002J\u0007\u0010¸\u0001\u001a\u00020TJ%\u0010¹\u0001\u001a\u00020T2\b\u0010º\u0001\u001a\u00030»\u00012\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\b\u0010À\u0001\u001a\u00030Á\u0001J\u0007\u0010Â\u0001\u001a\u00020TJ\u0013\u0010Ã\u0001\u001a\u00020T2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001J\u0010\u0010Æ\u0001\u001a\u00020T2\u0007\u0010Ç\u0001\u001a\u000204J\u0012\u0010È\u0001\u001a\u00020T2\u0007\u0010\u0013\u001a\u00030\u0089\u0001H\u0002J\u0014\u0010É\u0001\u001a\u00020T2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010;H\u0016J\u000f\u0010Ë\u0001\u001a\u00020T2\u0006\u0010{\u001a\u00020\u000eJ\u0012\u0010Ì\u0001\u001a\u00020T2\u0007\u0010Í\u0001\u001a\u00020\u000eH\u0002J\t\u0010Î\u0001\u001a\u00020TH\u0002J%\u0010Ï\u0001\u001a\u00020T2\b\u0010º\u0001\u001a\u00030Ð\u00012\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001J\u0013\u0010Ñ\u0001\u001a\u00020T2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020#@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R+\u0010/\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R$\u00105\u001a\u0002042\u0006\u0010\u0013\u001a\u000204@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010A\u001a\u00020@2\u0006\u0010\u0013\u001a\u00020@@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R\u001a\u0010I\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010\u0012R!\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR!\u0010S\u001a\b\u0012\u0004\u0012\u00020T0M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010R\u001a\u0004\bU\u0010PR!\u0010W\u001a\b\u0012\u0004\u0012\u00020X0M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010R\u001a\u0004\bY\u0010PR!\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010R\u001a\u0004\b]\u0010PR\u001b\u0010_\u001a\u00020`8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\ba\u0010bR$\u0010f\u001a\u00020e2\u0006\u0010\u0013\u001a\u00020e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u000e\u0010k\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010n\u001a\b\u0012\u0004\u0012\u00020*0oX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010q\u001a\u0004\u0018\u00010p2\b\u0010\u0013\u001a\u0004\u0018\u00010p@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010}\u001a\u0004\u0018\u00010|2\b\u0010\u0013\u001a\u0004\u0018\u00010|@FX\u0086\u000e¢\u0006\u0013\n\u0003\u0010\u0082\u0001\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R+\u0010\u0084\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0013\u001a\u00030\u0083\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R+\u0010\u008a\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u0013\u001a\u00030\u0089\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001¨\u0006Ò\u0001"}, d2 = {"Lexpo/modules/camera/ExpoCameraView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "<set-?>", "Landroidx/camera/video/Recording;", "activeRecording", "getActiveRecording", "()Landroidx/camera/video/Recording;", "animateShutter", "", "getAnimateShutter", "()Z", "setAnimateShutter", "(Z)V", "value", "Lexpo/modules/camera/records/FocusMode;", "autoFocus", "getAutoFocus", "()Lexpo/modules/camera/records/FocusMode;", "setAutoFocus", "(Lexpo/modules/camera/records/FocusMode;)V", "barcodeFormats", "", "Lexpo/modules/camera/records/BarcodeType;", "camera", "Landroidx/camera/core/Camera;", "getCamera", "()Landroidx/camera/core/Camera;", "setCamera", "(Landroidx/camera/core/Camera;)V", "Lexpo/modules/camera/records/CameraMode;", "cameraMode", "getCameraMode", "()Lexpo/modules/camera/records/CameraMode;", "setCameraMode", "(Lexpo/modules/camera/records/CameraMode;)V", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "currentActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getCurrentActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "enableTorch", "getEnableTorch", "setEnableTorch", "enableTorch$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lexpo/modules/camera/records/FlashMode;", "flashMode", "getFlashMode", "()Lexpo/modules/camera/records/FlashMode;", "setFlashMode", "(Lexpo/modules/camera/records/FlashMode;)V", "glSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "imageAnalysisUseCase", "Landroidx/camera/core/ImageAnalysis;", "imageCaptureUseCase", "Landroidx/camera/core/ImageCapture;", "Lexpo/modules/camera/records/CameraType;", "lensFacing", "getLensFacing", "()Lexpo/modules/camera/records/CameraType;", "setLensFacing", "(Lexpo/modules/camera/records/CameraType;)V", "mirror", "getMirror", "setMirror", "mute", "getMute", "setMute", "onBarcodeScanned", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/camera/common/BarcodeScannedEvent;", "getOnBarcodeScanned", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onBarcodeScanned$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onCameraReady", "", "getOnCameraReady", "onCameraReady$delegate", "onMountError", "Lexpo/modules/camera/common/CameraMountErrorEvent;", "getOnMountError", "onMountError$delegate", "onPictureSaved", "Lexpo/modules/camera/common/PictureSavedEvent;", "getOnPictureSaved", "onPictureSaved$delegate", "orientationEventListener", "Landroid/view/OrientationEventListener;", "getOrientationEventListener", "()Landroid/view/OrientationEventListener;", "orientationEventListener$delegate", "Lkotlin/Lazy;", "", "pictureSize", "getPictureSize", "()Ljava/lang/String;", "setPictureSize", "(Ljava/lang/String;)V", "previewPaused", "previewView", "Landroidx/camera/view/PreviewView;", "providerFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lexpo/modules/camera/records/CameraRatio;", "ratio", "getRatio", "()Lexpo/modules/camera/records/CameraRatio;", "setRatio", "(Lexpo/modules/camera/records/CameraRatio;)V", "recorder", "Landroidx/camera/video/Recorder;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "shouldCreateCamera", "shouldScanBarcodes", "", "videoEncodingBitrate", "getVideoEncodingBitrate", "()Ljava/lang/Integer;", "setVideoEncodingBitrate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Lexpo/modules/camera/records/VideoQuality;", "videoQuality", "getVideoQuality", "()Lexpo/modules/camera/records/VideoQuality;", "setVideoQuality", "(Lexpo/modules/camera/records/VideoQuality;)V", "", "zoom", "getZoom", "()F", "setZoom", "(F)V", "buildResolutionSelector", "Landroidx/camera/core/resolutionselector/ResolutionSelector;", "cancelCoroutineScope", "", "createCamera", "createImageAnalyzer", "createVideoCapture", "Landroidx/camera/video/VideoCapture;", "getAvailablePictureSizes", "getCornerPointsAndBoundingBox", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "cornerPoints", "boundingBox", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult$BoundingBox;", "getDeviceOrientation", "getPreviewSizeAsArray", "", "observeCameraState", "cameraInfo", "Landroidx/camera/core/CameraInfo;", OptionalModuleUtils.BARCODE, "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", ViewProps.ON_LAYOUT, "changed", "left", "top", ViewProps.RIGHT, ViewProps.BOTTOM, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", Response.TYPE, "onViewAdded", "child", "Landroid/view/View;", "parseSizeSafely", "Landroid/util/Size;", RRWebVideoEvent.JsonKeys.SIZE, "pausePreview", "record", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/camera/RecordingOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "cacheDirectory", "Ljava/io/File;", "releaseCamera", "Lkotlinx/coroutines/Job;", "resumePreview", "setBarcodeScannerSettings", "settings", "Lexpo/modules/camera/records/BarcodeSettings;", "setCameraFlashMode", "mode", "setCameraZoom", "setPreviewTexture", "surfaceTexture", "setShouldScanBarcodes", "setTorchEnabled", ViewProps.ENABLED, "startFocusMetering", "takePicture", "Lexpo/modules/camera/PictureOptions;", "transformBarcodeScannerResultToViewCoordinates", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoCameraView extends ExpoView implements CameraViewInterface {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ExpoCameraView.class, "enableTorch", "getEnableTorch()Z", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onCameraReady", "getOnCameraReady()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onMountError", "getOnMountError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onBarcodeScanned", "getOnBarcodeScanned()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onPictureSaved", "getOnPictureSaved()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    private Recording activeRecording;
    private boolean animateShutter;
    private FocusMode autoFocus;
    private List<? extends BarcodeType> barcodeFormats;
    private Camera camera;
    private CameraMode cameraMode;
    private ProcessCameraProvider cameraProvider;

    /* renamed from: enableTorch$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty enableTorch;
    private FlashMode flashMode;
    private SurfaceTexture glSurfaceTexture;
    private ImageAnalysis imageAnalysisUseCase;
    private ImageCapture imageCaptureUseCase;
    private CameraType lensFacing;
    private boolean mirror;
    private boolean mute;

    /* renamed from: onBarcodeScanned$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onBarcodeScanned;

    /* renamed from: onCameraReady$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onCameraReady;

    /* renamed from: onMountError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMountError;

    /* renamed from: onPictureSaved$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onPictureSaved;

    /* renamed from: orientationEventListener$delegate, reason: from kotlin metadata */
    private final Lazy orientationEventListener;
    private String pictureSize;
    private boolean previewPaused;
    private PreviewView previewView;
    private final ListenableFuture<ProcessCameraProvider> providerFuture;
    private CameraRatio ratio;
    private Recorder recorder;
    private final CoroutineScope scope;
    private boolean shouldCreateCamera;
    private boolean shouldScanBarcodes;
    private Integer videoEncodingBitrate;
    private VideoQuality videoQuality;
    private float zoom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoCameraView(Context context, final AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.orientationEventListener = LazyKt.lazy(new Function0<ExpoCameraView$orientationEventListener$2.AnonymousClass1>() { // from class: expo.modules.camera.ExpoCameraView$orientationEventListener$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v0, types: [expo.modules.camera.ExpoCameraView$orientationEventListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() throws Exceptions.MissingActivity {
                return new OrientationEventListener(appContext.getThrowingActivity()) { // from class: expo.modules.camera.ExpoCameraView$orientationEventListener$2.1
                    {
                        super(activity);
                    }

                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int orientation) {
                        if (orientation == -1) {
                            return;
                        }
                        int i = (45 > orientation || orientation >= 135) ? (135 > orientation || orientation >= 225) ? (225 > orientation || orientation >= 315) ? 0 : 1 : 2 : 3;
                        ImageAnalysis imageAnalysis = this.this$0.imageAnalysisUseCase;
                        if (imageAnalysis != null) {
                            imageAnalysis.setTargetRotation(i);
                        }
                        ImageCapture imageCapture = this.this$0.imageCaptureUseCase;
                        if (imageCapture == null) {
                            return;
                        }
                        imageCapture.setTargetRotation(i);
                    }
                };
            }
        });
        this.providerFuture = ProcessCameraProvider.INSTANCE.getInstance(context);
        this.barcodeFormats = CollectionsKt.emptyList();
        PreviewView previewView = new PreviewView(context);
        previewView.setElevation(0.0f);
        this.previewView = previewView;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.lensFacing = CameraType.BACK;
        this.flashMode = FlashMode.OFF;
        this.cameraMode = CameraMode.PICTURE;
        this.autoFocus = FocusMode.OFF;
        this.videoQuality = VideoQuality.VIDEO1080P;
        this.pictureSize = "";
        this.animateShutter = true;
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = false;
        this.enableTorch = new ObservableProperty<Boolean>(z) { // from class: expo.modules.camera.ExpoCameraView$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                boolean zBooleanValue = newValue.booleanValue();
                oldValue.booleanValue();
                this.setTorchEnabled(zBooleanValue);
            }
        };
        ExpoCameraView expoCameraView = this;
        this.onCameraReady = new ViewEventDelegate(expoCameraView, null);
        this.onMountError = new ViewEventDelegate(expoCameraView, null);
        this.onBarcodeScanned = new ViewEventDelegate(expoCameraView, new Function1<BarcodeScannedEvent, Short>() { // from class: expo.modules.camera.ExpoCameraView.onBarcodeScanned.2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(BarcodeScannedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return Short.valueOf((short) (event.getData().hashCode() % LayoutKt.LargeDimension));
            }
        });
        this.onPictureSaved = new ViewEventDelegate(expoCameraView, new Function1<PictureSavedEvent, Short>() { // from class: expo.modules.camera.ExpoCameraView.onPictureSaved.2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(PictureSavedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                String string = event.getData().getString(ShareConstants.MEDIA_URI);
                return Short.valueOf((short) ((string != null ? string.hashCode() : -1) % LayoutKt.LargeDimension));
            }
        });
        getOrientationEventListener().enable();
        this.previewView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: expo.modules.camera.ExpoCameraView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                if (parent != null) {
                    parent.measure(View.MeasureSpec.makeMeasureSpec(ExpoCameraView.this.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ExpoCameraView.this.getMeasuredHeight(), 1073741824));
                }
                if (parent != null) {
                    parent.layout(0, 0, parent.getMeasuredWidth(), parent.getMeasuredHeight());
                }
            }
        });
        addView(this.previewView, new ViewGroup.LayoutParams(-1, -1));
    }

    private final AppCompatActivity getCurrentActivity() throws Exceptions.MissingActivity {
        Activity throwingActivity = getAppContext().getThrowingActivity();
        Intrinsics.checkNotNull(throwingActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        return (AppCompatActivity) throwingActivity;
    }

    public final OrientationEventListener getOrientationEventListener() {
        return (OrientationEventListener) this.orientationEventListener.getValue();
    }

    public final Camera getCamera() {
        return this.camera;
    }

    public final void setCamera(Camera camera) {
        this.camera = camera;
    }

    public final Recording getActiveRecording() {
        return this.activeRecording;
    }

    public final CameraType getLensFacing() {
        return this.lensFacing;
    }

    public final void setLensFacing(CameraType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.lensFacing = value;
        this.shouldCreateCamera = true;
    }

    public final FlashMode getFlashMode() {
        return this.flashMode;
    }

    public final void setFlashMode(FlashMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.flashMode = value;
        setCameraFlashMode(value);
    }

    public final CameraMode getCameraMode() {
        return this.cameraMode;
    }

    public final void setCameraMode(CameraMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.cameraMode = value;
        this.shouldCreateCamera = true;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
        setCameraZoom(f);
    }

    public final FocusMode getAutoFocus() {
        return this.autoFocus;
    }

    public final void setAutoFocus(FocusMode value) {
        CameraControl cameraControl;
        Intrinsics.checkNotNullParameter(value, "value");
        this.autoFocus = value;
        Camera camera = this.camera;
        if (camera == null || (cameraControl = camera.getCameraControl()) == null) {
            return;
        }
        if (this.autoFocus == FocusMode.OFF) {
            Intrinsics.checkNotNull(cameraControl.cancelFocusAndMetering());
        } else {
            startFocusMetering();
        }
    }

    public final VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    public final void setVideoQuality(VideoQuality value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.videoQuality = value;
        this.shouldCreateCamera = true;
    }

    public final Integer getVideoEncodingBitrate() {
        return this.videoEncodingBitrate;
    }

    public final void setVideoEncodingBitrate(Integer num) {
        this.videoEncodingBitrate = num;
        this.shouldCreateCamera = true;
    }

    public final CameraRatio getRatio() {
        return this.ratio;
    }

    public final void setRatio(CameraRatio cameraRatio) {
        this.ratio = cameraRatio;
        this.shouldCreateCamera = true;
    }

    public final String getPictureSize() {
        return this.pictureSize;
    }

    public final void setPictureSize(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pictureSize = value;
        this.shouldCreateCamera = true;
    }

    public final boolean getMirror() {
        return this.mirror;
    }

    public final void setMirror(boolean z) {
        this.mirror = z;
        this.shouldCreateCamera = true;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final void setMute(boolean z) {
        this.mute = z;
    }

    public final boolean getAnimateShutter() {
        return this.animateShutter;
    }

    public final void setAnimateShutter(boolean z) {
        this.animateShutter = z;
    }

    public final boolean getEnableTorch() {
        return ((Boolean) this.enableTorch.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setEnableTorch(boolean z) {
        this.enableTorch.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEventCallback<Unit> getOnCameraReady() {
        return this.onCameraReady.getValue(this, $$delegatedProperties[1]);
    }

    private final ViewEventCallback<CameraMountErrorEvent> getOnMountError() {
        return this.onMountError.getValue(this, $$delegatedProperties[2]);
    }

    private final ViewEventCallback<BarcodeScannedEvent> getOnBarcodeScanned() {
        return this.onBarcodeScanned.getValue(this, $$delegatedProperties[3]);
    }

    private final ViewEventCallback<PictureSavedEvent> getOnPictureSaved() {
        return this.onPictureSaved.getValue(this, $$delegatedProperties[4]);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChild(this.previewView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(ViewGroup.resolveSize(this.previewView.getMeasuredWidth(), widthMeasureSpec), ViewGroup.resolveSize(this.previewView.getMeasuredHeight(), heightMeasureSpec));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        this.previewView.layout(0, 0, i, i2);
        SurfaceTexture surfaceTexture = this.glSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        if (Intrinsics.areEqual(child, this.previewView)) {
            return;
        }
        if (child != null) {
            child.bringToFront();
        }
        removeView(this.previewView);
        addView(this.previewView, 0);
    }

    public final void takePicture(PictureOptions options, Promise promise, File cacheDirectory) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        Object systemService = getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        int streamVolume = ((AudioManager) systemService).getStreamVolume(3);
        boolean shutterSound = options.getShutterSound();
        ImageCapture imageCapture = this.imageCaptureUseCase;
        if (imageCapture != null) {
            imageCapture.m148lambda$takePicture$1$androidxcameracoreImageCapture(ContextCompat.getMainExecutor(getContext()), new C04661(shutterSound, streamVolume, this, options, promise, cacheDirectory));
        }
    }

    /* compiled from: ExpoCameraView.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"expo/modules/camera/ExpoCameraView$takePicture$1", "Landroidx/camera/core/ImageCapture$OnImageCapturedCallback;", "onCaptureStarted", "", "onCaptureSuccess", "image", "Landroidx/camera/core/ImageProxy;", "onError", "exception", "Landroidx/camera/core/ImageCaptureException;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: expo.modules.camera.ExpoCameraView$takePicture$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04661 extends ImageCapture.OnImageCapturedCallback {
        final /* synthetic */ File $cacheDirectory;
        final /* synthetic */ boolean $hasShutterSound;
        final /* synthetic */ PictureOptions $options;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $volume;
        final /* synthetic */ ExpoCameraView this$0;

        C04661(boolean z, int i, ExpoCameraView expoCameraView, PictureOptions pictureOptions, Promise promise, File file) {
            this.$hasShutterSound = z;
            this.$volume = i;
            this.this$0 = expoCameraView;
            this.$options = pictureOptions;
            this.$promise = promise;
            this.$cacheDirectory = file;
        }

        @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
        public void onCaptureStarted() {
            if (this.$hasShutterSound && this.$volume != 0) {
                new MediaActionSound().play(0);
            }
            if (this.this$0.getAnimateShutter()) {
                View rootView = this.this$0.getRootView();
                final ExpoCameraView expoCameraView = this.this$0;
                rootView.postDelayed(new Runnable() { // from class: expo.modules.camera.ExpoCameraView$takePicture$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExpoCameraView.C04661.onCaptureStarted$lambda$1(expoCameraView);
                    }
                }, 100L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCaptureStarted$lambda$1(final ExpoCameraView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getRootView().setForeground(new ColorDrawable(-1));
            this$0.getRootView().postDelayed(new Runnable() { // from class: expo.modules.camera.ExpoCameraView$takePicture$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoCameraView.C04661.onCaptureStarted$lambda$1$lambda$0(this$0);
                }
            }, 50L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCaptureStarted$lambda$1$lambda$0(ExpoCameraView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getRootView().setForeground(null);
        }

        @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
        public void onCaptureSuccess(ImageProxy image) {
            Intrinsics.checkNotNullParameter(image, "image");
            ImageProxy.PlaneProxy[] planes = image.getPlanes();
            Intrinsics.checkNotNullExpressionValue(planes, "getPlanes(...)");
            byte[] byteArray = BarcodeAnalyzerKt.toByteArray(planes);
            if (this.$options.getFastMode()) {
                this.$promise.resolve((Object) null);
            }
            File file = this.$cacheDirectory;
            ExpoCameraView expoCameraView = this.this$0;
            BuildersKt__Builders_commonKt.launch$default(expoCameraView.scope, null, null, new ExpoCameraView$takePicture$1$onCaptureSuccess$1$1(expoCameraView, byteArray, this.$promise, this.$options, file, null), 3, null);
            image.close();
        }

        @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
        public void onError(ImageCaptureException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.$promise.reject(new CameraExceptions.ImageCaptureFailed());
        }
    }

    public final void setCameraFlashMode(FlashMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        ImageCapture imageCapture = this.imageCaptureUseCase;
        if (imageCapture == null) {
            return;
        }
        imageCapture.setFlashMode(mode.mapToLens());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTorchEnabled(boolean enabled) {
        CameraInfo cameraInfo;
        Camera camera;
        CameraControl cameraControl;
        Camera camera2 = this.camera;
        if (camera2 == null || (cameraInfo = camera2.getCameraInfo()) == null || !cameraInfo.hasFlashUnit() || (camera = this.camera) == null || (cameraControl = camera.getCameraControl()) == null) {
            return;
        }
        cameraControl.enableTorch(enabled);
    }

    public final void record(RecordingOptions options, final Promise promise, File cacheDirectory) {
        Unit unit;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        FileOutputOptions fileOutputOptionsBuild = ((FileOutputOptions.Builder) ((FileOutputOptions.Builder) new FileOutputOptions.Builder(FileSystemUtils.INSTANCE.generateOutputFile(cacheDirectory, "Camera", ".mp4")).setFileSizeLimit(options.getMaxFileSize())).setDurationLimitMillis(options.getMaxDuration() * 1000)).build();
        Intrinsics.checkNotNullExpressionValue(fileOutputOptionsBuild, "build(...)");
        Recorder recorder = this.recorder;
        if (recorder == null) {
            unit = null;
        } else {
            if (!this.mute && ActivityCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") != 0) {
                promise.reject(new Exceptions.MissingPermissions("android.permission.RECORD_AUDIO"));
                return;
            }
            PendingRecording pendingRecordingPrepareRecording = recorder.prepareRecording(getContext(), fileOutputOptionsBuild);
            if (!this.mute) {
                pendingRecordingPrepareRecording.withAudioEnabled();
            }
            this.activeRecording = pendingRecordingPrepareRecording.start(ContextCompat.getMainExecutor(getContext()), new Consumer() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda4
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ExpoCameraView.record$lambda$6$lambda$5(promise, (VideoRecordEvent) obj);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void record$lambda$6$lambda$5(Promise promise, VideoRecordEvent videoRecordEvent) {
        String message;
        String message2;
        Intrinsics.checkNotNullParameter(promise, "$promise");
        if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
            VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) videoRecordEvent;
            int error = finalize.getError();
            if (error == 0 || error == 2 || error == 9) {
                Bundle bundle = new Bundle();
                bundle.putString(ShareConstants.MEDIA_URI, finalize.getOutputResults().getOutputUri().toString());
                promise.resolve(bundle);
                return;
            }
            Throwable cause = finalize.getCause();
            if (cause == null || (message2 = cause.getMessage()) == null) {
                Throwable cause2 = finalize.getCause();
                if (cause2 == null || (message = cause2.getMessage()) == null) {
                    message = "Unknown error";
                }
                message2 = "Video recording Failed: " + message;
            }
            promise.reject(new CameraExceptions.VideoRecordingFailed(message2));
        }
    }

    public final void createCamera() {
        if (!this.shouldCreateCamera || this.previewPaused) {
            return;
        }
        this.shouldCreateCamera = false;
        this.providerFuture.addListener(new Runnable() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ExpoCameraView.createCamera$lambda$15(this.f$0);
            }
        }, ContextCompat.getMainExecutor(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCamera$lambda$15(final ExpoCameraView this$0) {
        PreviewView.ScaleType scaleType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProcessCameraProvider processCameraProvider = this$0.providerFuture.get();
        Intrinsics.checkNotNullExpressionValue(processCameraProvider, "get(...)");
        ProcessCameraProvider processCameraProvider2 = processCameraProvider;
        PreviewView previewView = this$0.previewView;
        if (this$0.ratio == CameraRatio.FOUR_THREE || this$0.ratio == CameraRatio.SIXTEEN_NINE) {
            scaleType = PreviewView.ScaleType.FIT_CENTER;
        } else {
            scaleType = PreviewView.ScaleType.FILL_CENTER;
        }
        previewView.setScaleType(scaleType);
        ResolutionSelector resolutionSelectorBuildResolutionSelector = this$0.buildResolutionSelector();
        Preview previewBuild = new Preview.Builder().setResolutionSelector(resolutionSelectorBuildResolutionSelector).build();
        previewBuild.setSurfaceProvider(this$0.previewView.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "also(...)");
        final SurfaceTexture surfaceTexture = this$0.glSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(this$0.previewView.getWidth(), this$0.previewView.getHeight());
            previewBuild.setSurfaceProvider(new Preview.SurfaceProvider() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda1
                @Override // androidx.camera.core.Preview.SurfaceProvider
                public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                    ExpoCameraView.createCamera$lambda$15$lambda$10$lambda$9(surfaceTexture, this$0, surfaceRequest);
                }
            });
        }
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this$0.lensFacing.mapToCharacteristic()).build();
        Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "build(...)");
        this$0.imageCaptureUseCase = new ImageCapture.Builder().setResolutionSelector(resolutionSelectorBuildResolutionSelector).setFlashMode(this$0.flashMode.mapToLens()).build();
        VideoCapture<Recorder> videoCaptureCreateVideoCapture = this$0.createVideoCapture();
        this$0.imageAnalysisUseCase = this$0.createImageAnalyzer();
        UseCaseGroup.Builder builder = new UseCaseGroup.Builder();
        builder.addUseCase(previewBuild);
        if (this$0.cameraMode == CameraMode.PICTURE) {
            ImageCapture imageCapture = this$0.imageCaptureUseCase;
            if (imageCapture != null) {
                builder.addUseCase(imageCapture);
            }
            ImageAnalysis imageAnalysis = this$0.imageAnalysisUseCase;
            if (imageAnalysis != null) {
                builder.addUseCase(imageAnalysis);
            }
        } else {
            builder.addUseCase(videoCaptureCreateVideoCapture);
        }
        UseCaseGroup useCaseGroupBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(useCaseGroupBuild, "build(...)");
        try {
            processCameraProvider2.unbindAll();
            Camera cameraBindToLifecycle = processCameraProvider2.bindToLifecycle(this$0.getCurrentActivity(), cameraSelectorBuild, useCaseGroupBuild);
            this$0.camera = cameraBindToLifecycle;
            if (cameraBindToLifecycle != null) {
                CameraInfo cameraInfo = cameraBindToLifecycle.getCameraInfo();
                Intrinsics.checkNotNullExpressionValue(cameraInfo, "getCameraInfo(...)");
                this$0.observeCameraState(cameraInfo);
            }
            this$0.setCameraZoom(this$0.zoom);
            this$0.cameraProvider = processCameraProvider2;
        } catch (Exception unused) {
            this$0.getOnMountError().invoke(new CameraMountErrorEvent("Camera component could not be rendered - is there any other instance running?"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCamera$lambda$15$lambda$10$lambda$9(SurfaceTexture it, ExpoCameraView this$0, SurfaceRequest request) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "request");
        final Surface surface = new Surface(it);
        request.provideSurface(surface, ContextCompat.getMainExecutor(this$0.getContext()), new Consumer() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ExpoCameraView.createCamera$lambda$15$lambda$10$lambda$9$lambda$8(surface, (SurfaceRequest.Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCamera$lambda$15$lambda$10$lambda$9$lambda$8(Surface surface, SurfaceRequest.Result result) {
        Intrinsics.checkNotNullParameter(surface, "$surface");
        surface.release();
    }

    private final ImageAnalysis createImageAnalyzer() {
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setResolutionSelector(new ResolutionSelector.Builder().setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build()).setBackpressureStrategy(0).build();
        Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "build(...)");
        if (this.shouldScanBarcodes) {
            imageAnalysisBuild.setAnalyzer(ContextCompat.getMainExecutor(getContext()), new BarcodeAnalyzer(this.lensFacing, this.barcodeFormats, new Function1<BarCodeScannerResult, Unit>() { // from class: expo.modules.camera.ExpoCameraView$createImageAnalyzer$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BarCodeScannerResult barCodeScannerResult) {
                    invoke2(barCodeScannerResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BarCodeScannerResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.onBarcodeScanned(it);
                }
            }));
        }
        return imageAnalysisBuild;
    }

    private final ResolutionSelector buildResolutionSelector() {
        ResolutionStrategy HIGHEST_AVAILABLE_STRATEGY;
        if (this.pictureSize.length() > 0) {
            Size sizeSafely = parseSizeSafely(this.pictureSize);
            if (sizeSafely != null) {
                HIGHEST_AVAILABLE_STRATEGY = new ResolutionStrategy(sizeSafely, 3);
            } else {
                HIGHEST_AVAILABLE_STRATEGY = ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY;
                Intrinsics.checkNotNullExpressionValue(HIGHEST_AVAILABLE_STRATEGY, "HIGHEST_AVAILABLE_STRATEGY");
            }
        } else {
            HIGHEST_AVAILABLE_STRATEGY = ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY;
            Intrinsics.checkNotNull(HIGHEST_AVAILABLE_STRATEGY);
        }
        if (this.ratio == CameraRatio.ONE_ONE) {
            ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setResolutionFilter(new ResolutionFilter() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda0
                @Override // androidx.camera.core.resolutionselector.ResolutionFilter
                public final List filter(List list, int i) {
                    return ExpoCameraView.buildResolutionSelector$lambda$19(list, i);
                }
            }).setResolutionStrategy(HIGHEST_AVAILABLE_STRATEGY).build();
            Intrinsics.checkNotNull(resolutionSelectorBuild);
            return resolutionSelectorBuild;
        }
        ResolutionSelector.Builder builder = new ResolutionSelector.Builder();
        CameraRatio cameraRatio = this.ratio;
        if (cameraRatio != null) {
            builder.setAspectRatioStrategy(cameraRatio.mapToStrategy());
        }
        builder.setResolutionStrategy(HIGHEST_AVAILABLE_STRATEGY);
        ResolutionSelector resolutionSelectorBuild2 = builder.build();
        Intrinsics.checkNotNull(resolutionSelectorBuild2);
        return resolutionSelectorBuild2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List buildResolutionSelector$lambda$19(List supportedSizes, int i) {
        Intrinsics.checkNotNullParameter(supportedSizes, "supportedSizes");
        ArrayList arrayList = new ArrayList();
        for (Object obj : supportedSizes) {
            Size size = (Size) obj;
            if (size.getWidth() == size.getHeight()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final Size parseSizeSafely(String size) {
        if (!new Regex("\\d+x\\d+").matches(size)) {
            return null;
        }
        try {
            return Size.parseSize(size);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final VideoCapture<Recorder> createVideoCapture() {
        Quality qualityMapToQuality = this.videoQuality.mapToQuality();
        FallbackStrategy fallbackStrategyHigherQualityOrLowerThan = FallbackStrategy.higherQualityOrLowerThan(qualityMapToQuality);
        Intrinsics.checkNotNullExpressionValue(fallbackStrategyHigherQualityOrLowerThan, "higherQualityOrLowerThan(...)");
        QualitySelector qualitySelectorFrom = QualitySelector.from(qualityMapToQuality, fallbackStrategyHigherQualityOrLowerThan);
        Intrinsics.checkNotNullExpressionValue(qualitySelectorFrom, "from(...)");
        Recorder.Builder builder = new Recorder.Builder();
        Integer num = this.videoEncodingBitrate;
        if (num != null) {
            builder.setTargetVideoEncodingBitRate(num.intValue());
        }
        Recorder recorderBuild = builder.setExecutor(ContextCompat.getMainExecutor(getContext())).setQualitySelector(qualitySelectorFrom).build();
        this.recorder = recorderBuild;
        Intrinsics.checkNotNullExpressionValue(recorderBuild, "also(...)");
        VideoCapture.Builder builder2 = new VideoCapture.Builder(recorderBuild);
        if (this.mirror) {
            builder2.setMirrorMode(2);
        }
        builder2.setVideoStabilizationEnabled(true);
        VideoCapture<Recorder> videoCaptureBuild = builder2.build();
        Intrinsics.checkNotNullExpressionValue(videoCaptureBuild, "build(...)");
        return videoCaptureBuild;
    }

    private final void startFocusMetering() {
        Camera camera = this.camera;
        if (camera != null) {
            FocusMeteringAction focusMeteringActionBuild = new FocusMeteringAction.Builder(new DisplayOrientedMeteringPointFactory(this.previewView.getDisplay(), camera.getCameraInfo(), this.previewView.getWidth(), this.previewView.getHeight()).createPoint(1.0f, 1.0f), 1).build();
            Intrinsics.checkNotNullExpressionValue(focusMeteringActionBuild, "build(...)");
            camera.getCameraControl().startFocusAndMetering(focusMeteringActionBuild);
        }
    }

    private final void setCameraZoom(float value) {
        CameraControl cameraControl;
        CameraInfo cameraInfo;
        LiveData<ZoomState> zoomState;
        ZoomState value2;
        Camera camera = this.camera;
        float maxZoomRatio = (camera == null || (cameraInfo = camera.getCameraInfo()) == null || (zoomState = cameraInfo.getZoomState()) == null || (value2 = zoomState.getValue()) == null) ? 1.0f : value2.getMaxZoomRatio();
        float fMax = Float.max(1.0f, Float.min(maxZoomRatio, RangesKt.coerceIn(value, 0.0f, 1.0f) * maxZoomRatio));
        Camera camera2 = this.camera;
        if (camera2 == null || (cameraControl = camera2.getCameraControl()) == null) {
            return;
        }
        cameraControl.setZoomRatio(fMax);
    }

    private final void observeCameraState(CameraInfo cameraInfo) {
        cameraInfo.getCameraState().observe(getCurrentActivity(), new ExpoCameraViewKt$sam$androidx_lifecycle_Observer$0(new Function1<CameraState, Unit>() { // from class: expo.modules.camera.ExpoCameraView.observeCameraState.1

            /* compiled from: ExpoCameraView.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: expo.modules.camera.ExpoCameraView$observeCameraState$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CameraState.Type.values().length];
                    try {
                        iArr[CameraState.Type.OPEN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CameraState cameraState) {
                invoke2(cameraState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CameraState cameraState) {
                if (WhenMappings.$EnumSwitchMapping$0[cameraState.getType().ordinal()] == 1) {
                    ExpoCameraView.this.getOnCameraReady().invoke(Unit.INSTANCE);
                    ExpoCameraView expoCameraView = ExpoCameraView.this;
                    expoCameraView.setTorchEnabled(expoCameraView.getEnableTorch());
                }
            }
        }));
    }

    public final List<String> getAvailablePictureSizes() {
        CameraInfo cameraInfo;
        ArrayList arrayList;
        Size[] outputSizes;
        Camera camera = this.camera;
        if (camera != null && (cameraInfo = camera.getCameraInfo()) != null) {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) Camera2CameraInfo.from(cameraInfo).getCameraCharacteristic(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null || (outputSizes = streamConfigurationMap.getOutputSizes(256)) == null) {
                arrayList = null;
            } else {
                Intrinsics.checkNotNull(outputSizes);
                ArrayList arrayList2 = new ArrayList(outputSizes.length);
                for (Size size : outputSizes) {
                    String string = size.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    arrayList2.add(string);
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void resumePreview() {
        this.shouldCreateCamera = true;
        this.previewPaused = false;
        createCamera();
    }

    public final void pausePreview() {
        this.previewPaused = true;
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
    }

    public final void setShouldScanBarcodes(boolean shouldScanBarcodes) {
        this.shouldScanBarcodes = shouldScanBarcodes;
        this.shouldCreateCamera = true;
    }

    public final void setBarcodeScannerSettings(BarcodeSettings settings) {
        List<BarcodeType> listEmptyList;
        if (settings == null || (listEmptyList = settings.getBarcodeTypes()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.barcodeFormats = listEmptyList;
    }

    private final int getDeviceOrientation() {
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = getAppContext().getThrowingActivity().getDisplay();
            if (display != null) {
                return display.getRotation();
            }
            return 0;
        }
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) systemService).getDefaultDisplay().getRotation();
    }

    /* compiled from: ExpoCameraView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.ExpoCameraView$releaseCamera$1", f = "ExpoCameraView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.camera.ExpoCameraView$releaseCamera$1, reason: invalid class name and case insensitive filesystem */
    static final class C04651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04651(Continuation<? super C04651> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExpoCameraView.this.new C04651(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ExpoCameraView.this.shouldCreateCamera = true;
                ProcessCameraProvider processCameraProvider = ExpoCameraView.this.cameraProvider;
                if (processCameraProvider != null) {
                    processCameraProvider.unbindAll();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Job releaseCamera() {
        return BuildersKt__Builders_commonKt.launch$default(getAppContext().getMainQueue(), null, null, new C04651(null), 3, null);
    }

    private final void transformBarcodeScannerResultToViewCoordinates(BarCodeScannerResult barcode) {
        List<Integer> cornerPoints = barcode.getCornerPoints();
        int width = this.previewView.getWidth();
        int height = this.previewView.getHeight();
        boolean z = this.lensFacing == CameraType.FRONT;
        boolean z2 = getDeviceOrientation() % 2 == 0;
        boolean z3 = getDeviceOrientation() % 2 != 0;
        if (z && z2) {
            Intrinsics.checkNotNull(cornerPoints);
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int referenceImageHeight = barcode.getReferenceImageHeight();
                    Integer num = cornerPoints.get(first);
                    Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                    cornerPoints.set(first, Integer.valueOf(referenceImageHeight - num.intValue()));
                    if (first == last) {
                        break;
                    } else {
                        first += step;
                    }
                }
            }
        }
        if (z && z3) {
            Intrinsics.checkNotNull(cornerPoints);
            IntProgression intProgressionStep2 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
            int first2 = intProgressionStep2.getFirst();
            int last2 = intProgressionStep2.getLast();
            int step2 = intProgressionStep2.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    int referenceImageWidth = barcode.getReferenceImageWidth();
                    Integer num2 = cornerPoints.get(first2);
                    Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
                    cornerPoints.set(first2, Integer.valueOf(referenceImageWidth - num2.intValue()));
                    if (first2 == last2) {
                        break;
                    } else {
                        first2 += step2;
                    }
                }
            }
        }
        Intrinsics.checkNotNull(cornerPoints);
        IntProgression intProgressionStep3 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
        int first3 = intProgressionStep3.getFirst();
        int last3 = intProgressionStep3.getLast();
        int step3 = intProgressionStep3.getStep();
        if ((step3 > 0 && first3 <= last3) || (step3 < 0 && last3 <= first3)) {
            while (true) {
                cornerPoints.set(first3, Integer.valueOf(MathKt.roundToInt((cornerPoints.get(first3).intValue() * width) / barcode.getReferenceImageWidth())));
                if (first3 == last3) {
                    break;
                } else {
                    first3 += step3;
                }
            }
        }
        IntProgression intProgressionStep4 = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
        int first4 = intProgressionStep4.getFirst();
        int last4 = intProgressionStep4.getLast();
        int step4 = intProgressionStep4.getStep();
        if ((step4 > 0 && first4 <= last4) || (step4 < 0 && last4 <= first4)) {
            while (true) {
                cornerPoints.set(first4, Integer.valueOf(MathKt.roundToInt((cornerPoints.get(first4).intValue() * height) / barcode.getReferenceImageHeight())));
                if (first4 == last4) {
                    break;
                } else {
                    first4 += step4;
                }
            }
        }
        barcode.setCornerPoints(cornerPoints);
        barcode.setReferenceImageHeight(getHeight());
        barcode.setReferenceImageWidth(getWidth());
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> cornerPoints, BarCodeScannerResult.BoundingBox boundingBox) {
        float f = this.previewView.getResources().getDisplayMetrics().density;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, cornerPoints.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                Bundle bundle = new Bundle();
                bundle.putFloat("x", cornerPoints.get(i + 1).intValue() / f);
                bundle.putFloat("y", cornerPoints.get(i).intValue() / f);
                arrayList.add(bundle);
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle3.putFloat("x", boundingBox.getX() / f);
        bundle3.putFloat("y", boundingBox.getY() / f);
        Unit unit = Unit.INSTANCE;
        bundle2.putParcelable("origin", bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putFloat("width", boundingBox.getWidth() / f);
        bundle4.putFloat("height", boundingBox.getHeight() / f);
        Unit unit2 = Unit.INSTANCE;
        bundle2.putParcelable(RRWebVideoEvent.JsonKeys.SIZE, bundle4);
        return TuplesKt.to(arrayList, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBarcodeScanned(BarCodeScannerResult barcode) {
        if (this.shouldScanBarcodes) {
            transformBarcodeScannerResultToViewCoordinates(barcode);
            List<Integer> cornerPoints = barcode.getCornerPoints();
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "getCornerPoints(...)");
            BarCodeScannerResult.BoundingBox boundingBox = barcode.getBoundingBox();
            Intrinsics.checkNotNullExpressionValue(boundingBox, "getBoundingBox(...)");
            Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = getCornerPointsAndBoundingBox(cornerPoints, boundingBox);
            ArrayList<Bundle> arrayListComponent1 = cornerPointsAndBoundingBox.component1();
            Bundle bundleComponent2 = cornerPointsAndBoundingBox.component2();
            ViewEventCallback<BarcodeScannedEvent> onBarcodeScanned = getOnBarcodeScanned();
            int id = getId();
            String value = barcode.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            String raw = barcode.getRaw();
            Intrinsics.checkNotNullExpressionValue(raw, "getRaw(...)");
            onBarcodeScanned.invoke(new BarcodeScannedEvent(id, value, raw, BarcodeType.INSTANCE.mapFormatToString(barcode.getType()), arrayListComponent1, bundleComponent2));
        }
    }

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.glSurfaceTexture = surfaceTexture;
        this.shouldCreateCamera = true;
        createCamera();
    }

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public int[] getPreviewSizeAsArray() {
        return new int[]{this.previewView.getWidth(), this.previewView.getHeight()};
    }

    public final void onPictureSaved(Bundle response) {
        Intrinsics.checkNotNullParameter(response, "response");
        ViewEventCallback<PictureSavedEvent> onPictureSaved = getOnPictureSaved();
        int i = response.getInt("id");
        Bundle bundle = response.getBundle("data");
        Intrinsics.checkNotNull(bundle);
        onPictureSaved.invoke(new PictureSavedEvent(i, bundle));
    }

    public final Object cancelCoroutineScope() {
        try {
            CoroutineScopeKt.cancel(this.scope, new ModuleDestroyedException(null, 1, null));
            return Unit.INSTANCE;
        } catch (Exception unused) {
            return Integer.valueOf(Log.e(CameraViewModule.INSTANCE.getTAG$expo_camera_release(), "The scope does not have a job in it"));
        }
    }
}
