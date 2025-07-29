package com.mrousavy.camera.react;

import android.content.ComponentCallbacks2;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationRequestCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.UIManagerHelper;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.UnknownCameraError;
import com.mrousavy.camera.core.ViewNotFoundError;
import com.mrousavy.camera.core.types.PermissionStatus;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.TakeSnapshotOptions;
import com.mrousavy.camera.frameprocessors.VisionCameraInstaller;
import com.mrousavy.camera.frameprocessors.VisionCameraProxy;
import com.mrousavy.camera.react.utils.CallbackPromiseKt;
import com.nimbusds.jose.crypto.impl.AESGCM;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: CameraViewModule.kt */
@ReactModule(name = "CameraView")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0018\u001a\u00020\nH\u0007J\b\u0010\u0019\u001a\u00020\nH\u0007J\b\u0010\u001a\u001a\u00020\nH\u0007J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0007J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0018\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010&\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010*\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010+\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "canRequestPermission", "", "permission", "", "cancelRecording", "", "viewTag", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "findCameraView", "Lcom/mrousavy/camera/react/CameraView;", "viewId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "focus", "point", "Lcom/facebook/react/bridge/ReadableMap;", "getCameraPermissionStatus", "getLocationPermissionStatus", "getMicrophonePermissionStatus", "getName", "getPermission", "Lcom/mrousavy/camera/core/types/PermissionStatus;", "installFrameProcessorBindings", "invalidate", "pauseRecording", "requestCameraPermission", "requestLocationPermission", "requestMicrophonePermission", "requestPermission", "resumeRecording", "startRecording", "jsOptions", "onRecordCallback", "Lcom/facebook/react/bridge/Callback;", "stopRecording", "takePhoto", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "takeSnapshot", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraViewModule extends ReactContextBaseJavaModule {
    public static final String TAG = "CameraView";
    private final CoroutineScope backgroundCoroutineScope;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int sharedRequestCode = 10;

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewModule$Companion;", "", "()V", "TAG", "", "sharedRequestCode", "", "getSharedRequestCode", "()I", "setSharedRequestCode", "(I)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getSharedRequestCode() {
            return CameraViewModule.sharedRequestCode;
        }

        public final void setSharedRequestCode(int i) {
            CameraViewModule.sharedRequestCode = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(CameraQueues.INSTANCE.getCameraExecutor()));
    }

    static {
        try {
            System.loadLibrary("VisionCamera");
        } catch (UnsatisfiedLinkError e) {
            Log.e(VisionCameraProxy.TAG, "Failed to load VisionCamera C++ library!", e);
            throw e;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        if (CoroutineScopeKt.isActive(this.backgroundCoroutineScope)) {
            CoroutineScopeKt.cancel$default(this.backgroundCoroutineScope, "CameraViewModule has been destroyed.", null, 2, null);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CameraView";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean installFrameProcessorBindings() {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            VisionCameraInstaller.install(new VisionCameraProxy(reactApplicationContext));
            return true;
        } catch (Error e) {
            Log.e("CameraView", "Failed to install Frame Processor JSI Bindings!", e);
            return false;
        }
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$takePhoto$1", f = "CameraViewModule.kt", i = {1}, l = {94, AESGCM.IV_BIT_LENGTH}, m = "invokeSuspend", n = {"promise$iv"}, s = {"L$0"})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$takePhoto$1, reason: invalid class name and case insensitive filesystem */
    static final class C04561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $options;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04561(int i, Promise promise, ReadableMap readableMap, Continuation<? super C04561> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
            this.$options = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C04561(this.$viewTag, this.$promise, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(6:6|33|7|22|31|32)(2:11|12))(1:13))(2:14|(1:16))|17|35|18|(1:20)(4:21|22|31|32)|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        
            r6 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        
            r0 = r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws com.mrousavy.camera.core.ViewNotFoundError {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r0 = r5.L$0
                com.facebook.react.bridge.Promise r0 = (com.facebook.react.bridge.Promise) r0
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L16
                goto L49
            L16:
                r6 = move-exception
                goto L4f
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L20:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L37
            L24:
                kotlin.ResultKt.throwOnFailure(r6)
                com.mrousavy.camera.react.CameraViewModule r6 = com.mrousavy.camera.react.CameraViewModule.this
                int r1 = r5.$viewTag
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = com.mrousavy.camera.react.CameraViewModule.access$findCameraView(r6, r1, r4)
                if (r6 != r0) goto L37
                return r0
            L37:
                com.mrousavy.camera.react.CameraView r6 = (com.mrousavy.camera.react.CameraView) r6
                com.facebook.react.bridge.Promise r1 = r5.$promise
                com.facebook.react.bridge.ReadableMap r3 = r5.$options
                r5.L$0 = r1     // Catch: java.lang.Throwable -> L4d
                r5.label = r2     // Catch: java.lang.Throwable -> L4d
                java.lang.Object r6 = com.mrousavy.camera.react.CameraView_TakePhotoKt.takePhoto(r6, r3, r5)     // Catch: java.lang.Throwable -> L4d
                if (r6 != r0) goto L48
                return r0
            L48:
                r0 = r1
            L49:
                r0.resolve(r6)     // Catch: java.lang.Throwable -> L16
                goto L8b
            L4d:
                r6 = move-exception
                r0 = r1
            L4f:
                r6.printStackTrace()
                boolean r1 = r6 instanceof com.mrousavy.camera.core.CameraError
                if (r1 == 0) goto L59
                com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
                goto L61
            L59:
                com.mrousavy.camera.core.UnknownCameraError r1 = new com.mrousavy.camera.core.UnknownCameraError
                r1.<init>(r6)
                r6 = r1
                com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
            L61:
                java.lang.String r1 = r6.getDomain()
                java.lang.String r2 = r6.getId()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.StringBuilder r1 = r3.append(r1)
                java.lang.String r3 = "/"
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = r6.getMessage()
                java.lang.Throwable r6 = r6.getCause()
                r0.reject(r1, r2, r6)
            L8b:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraViewModule.C04561.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void takePhoto(int viewTag, ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C04561(viewTag, promise, options, null), 3, null);
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1", f = "CameraViewModule.kt", i = {}, l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1, reason: invalid class name and case insensitive filesystem */
    static final class C04571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $jsOptions;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04571(int i, ReadableMap readableMap, Promise promise, Continuation<? super C04571> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$jsOptions = readableMap;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C04571(this.$viewTag, this.$jsOptions, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CameraViewModule.this.findCameraView(this.$viewTag, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            final CameraView cameraView = (CameraView) obj;
            final CameraViewModule cameraViewModule = CameraViewModule.this;
            final ReadableMap readableMap = this.$jsOptions;
            final Promise promise = this.$promise;
            if (UiThreadUtil.isOnUiThread()) {
                try {
                    TakeSnapshotOptions.Companion companion = TakeSnapshotOptions.INSTANCE;
                    ReactApplicationContext reactApplicationContext = cameraViewModule.getReactApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                    promise.resolve(CameraView_TakeSnapshotKt.takeSnapshot(cameraView, companion.fromJSValue(reactApplicationContext, readableMap)));
                } catch (Throwable th) {
                    promise.reject(th);
                }
            } else {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1$invokeSuspend$$inlined$runOnUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            TakeSnapshotOptions.Companion companion2 = TakeSnapshotOptions.INSTANCE;
                            ReactApplicationContext reactApplicationContext2 = cameraViewModule.getReactApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "access$getReactApplicationContext(...)");
                            promise.resolve(CameraView_TakeSnapshotKt.takeSnapshot(cameraView, companion2.fromJSValue(reactApplicationContext2, readableMap)));
                        } catch (Throwable th2) {
                            promise.reject(th2);
                        }
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void takeSnapshot(int viewTag, ReadableMap jsOptions, Promise promise) {
        Intrinsics.checkNotNullParameter(jsOptions, "jsOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C04571(viewTag, jsOptions, promise, null), 3, null);
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$startRecording$1", f = "CameraViewModule.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$startRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C04541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $jsOptions;
        final /* synthetic */ Callback $onRecordCallback;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04541(int i, ReadableMap readableMap, Callback callback, Continuation<? super C04541> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$jsOptions = readableMap;
            this.$onRecordCallback = callback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C04541(this.$viewTag, this.$jsOptions, this.$onRecordCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CameraViewModule.this.findCameraView(this.$viewTag, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            try {
                RecordVideoOptions.Companion companion = RecordVideoOptions.INSTANCE;
                ReactApplicationContext reactApplicationContext = CameraViewModule.this.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                CameraView_RecordVideoKt.startRecording(cameraView, companion.fromJSValue(reactApplicationContext, this.$jsOptions), this.$onRecordCallback);
            } catch (CameraError e) {
                this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default(e.getDomain() + "/" + e.getId(), e.getMessage(), e, null, 8, null));
            } catch (Throwable th) {
                this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default("capture/unknown", "An unknown error occurred while trying to start a video recording! " + th.getMessage(), th, null, 8, null));
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void startRecording(int viewTag, ReadableMap jsOptions, Callback onRecordCallback) {
        Intrinsics.checkNotNullParameter(jsOptions, "jsOptions");
        Intrinsics.checkNotNullParameter(onRecordCallback, "onRecordCallback");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C04541(viewTag, jsOptions, onRecordCallback, null), 3, null);
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$pauseRecording$1", f = "CameraViewModule.kt", i = {0}, l = {140}, m = "invokeSuspend", n = {"promise$iv"}, s = {"L$0"})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$pauseRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C04521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;
        final /* synthetic */ CameraViewModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04521(Promise promise, CameraViewModule cameraViewModule, int i, Continuation<? super C04521> continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.this$0 = cameraViewModule;
            this.$viewTag = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04521(this.$promise, this.this$0, this.$viewTag, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r0 = r5.L$0
                com.facebook.react.bridge.Promise r0 = (com.facebook.react.bridge.Promise) r0
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L13
                goto L33
            L13:
                r6 = move-exception
                goto L41
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r6)
                com.facebook.react.bridge.Promise r6 = r5.$promise
                com.mrousavy.camera.react.CameraViewModule r1 = r5.this$0
                int r3 = r5.$viewTag
                r5.L$0 = r6     // Catch: java.lang.Throwable -> L3d
                r5.label = r2     // Catch: java.lang.Throwable -> L3d
                java.lang.Object r1 = com.mrousavy.camera.react.CameraViewModule.access$findCameraView(r1, r3, r5)     // Catch: java.lang.Throwable -> L3d
                if (r1 != r0) goto L31
                return r0
            L31:
                r0 = r6
                r6 = r1
            L33:
                com.mrousavy.camera.react.CameraView r6 = (com.mrousavy.camera.react.CameraView) r6     // Catch: java.lang.Throwable -> L13
                com.mrousavy.camera.react.CameraView_RecordVideoKt.pauseRecording(r6)     // Catch: java.lang.Throwable -> L13
                r6 = 0
                r0.resolve(r6)     // Catch: java.lang.Throwable -> L13
                goto L7d
            L3d:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
            L41:
                r6.printStackTrace()
                boolean r1 = r6 instanceof com.mrousavy.camera.core.CameraError
                if (r1 == 0) goto L4b
                com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
                goto L53
            L4b:
                com.mrousavy.camera.core.UnknownCameraError r1 = new com.mrousavy.camera.core.UnknownCameraError
                r1.<init>(r6)
                r6 = r1
                com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
            L53:
                java.lang.String r1 = r6.getDomain()
                java.lang.String r2 = r6.getId()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.StringBuilder r1 = r3.append(r1)
                java.lang.String r3 = "/"
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = r6.getMessage()
                java.lang.Throwable r6 = r6.getCause()
                r0.reject(r1, r2, r6)
            L7d:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraViewModule.C04521.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void pauseRecording(int viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C04521(promise, this, viewTag, null), 3, null);
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$resumeRecording$1", f = "CameraViewModule.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$resumeRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C04531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04531(int i, Promise promise, Continuation<? super C04531> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C04531(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CameraViewModule.this.findCameraView(this.$viewTag, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.resumeRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                UnknownCameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + "/" + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void resumeRecording(int viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C04531(viewTag, promise, null), 3, null);
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$stopRecording$1", f = "CameraViewModule.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$stopRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C04551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04551(int i, Promise promise, Continuation<? super C04551> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C04551(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CameraViewModule.this.findCameraView(this.$viewTag, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.stopRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                UnknownCameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + "/" + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void stopRecording(int viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C04551(viewTag, promise, null), 3, null);
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$cancelRecording$1", f = "CameraViewModule.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$cancelRecording$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new AnonymousClass1(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CameraViewModule.this.findCameraView(this.$viewTag, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.cancelRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                UnknownCameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + "/" + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void cancelRecording(int viewTag, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new AnonymousClass1(viewTag, promise, null), 3, null);
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$focus$1", f = "CameraViewModule.kt", i = {1}, l = {183, 185}, m = "invokeSuspend", n = {"promise$iv"}, s = {"L$0"})
    /* renamed from: com.mrousavy.camera.react.CameraViewModule$focus$1, reason: invalid class name and case insensitive filesystem */
    static final class C04511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $point;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04511(int i, Promise promise, ReadableMap readableMap, Continuation<? super C04511> continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
            this.$point = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraViewModule.this.new C04511(this.$viewTag, this.$promise, this.$point, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(7:6|34|7|22|23|32|33)(2:11|12))(1:13))(2:14|(1:16))|17|36|18|(1:20)(5:21|22|23|32|33)|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        
            r6 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            r0 = r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws com.mrousavy.camera.core.ViewNotFoundError {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r0 = r5.L$0
                com.facebook.react.bridge.Promise r0 = (com.facebook.react.bridge.Promise) r0
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L16
                goto L49
            L16:
                r6 = move-exception
                goto L50
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L20:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L37
            L24:
                kotlin.ResultKt.throwOnFailure(r6)
                com.mrousavy.camera.react.CameraViewModule r6 = com.mrousavy.camera.react.CameraViewModule.this
                int r1 = r5.$viewTag
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = com.mrousavy.camera.react.CameraViewModule.access$findCameraView(r6, r1, r4)
                if (r6 != r0) goto L37
                return r0
            L37:
                com.mrousavy.camera.react.CameraView r6 = (com.mrousavy.camera.react.CameraView) r6
                com.facebook.react.bridge.Promise r1 = r5.$promise
                com.facebook.react.bridge.ReadableMap r3 = r5.$point
                r5.L$0 = r1     // Catch: java.lang.Throwable -> L4e
                r5.label = r2     // Catch: java.lang.Throwable -> L4e
                java.lang.Object r6 = com.mrousavy.camera.react.CameraView_FocusKt.focus(r6, r3, r5)     // Catch: java.lang.Throwable -> L4e
                if (r6 != r0) goto L48
                return r0
            L48:
                r0 = r1
            L49:
                r6 = 0
                r0.resolve(r6)     // Catch: java.lang.Throwable -> L16
                goto L8c
            L4e:
                r6 = move-exception
                r0 = r1
            L50:
                r6.printStackTrace()
                boolean r1 = r6 instanceof com.mrousavy.camera.core.CameraError
                if (r1 == 0) goto L5a
                com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
                goto L62
            L5a:
                com.mrousavy.camera.core.UnknownCameraError r1 = new com.mrousavy.camera.core.UnknownCameraError
                r1.<init>(r6)
                r6 = r1
                com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
            L62:
                java.lang.String r1 = r6.getDomain()
                java.lang.String r2 = r6.getId()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.StringBuilder r1 = r3.append(r1)
                java.lang.String r3 = "/"
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = r6.getMessage()
                java.lang.Throwable r6 = r6.getCause()
                r0.reject(r1, r2, r6)
            L8c:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraViewModule.C04511.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void focus(int viewTag, ReadableMap point, Promise promise) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C04511(viewTag, promise, point, null), 3, null);
    }

    private final boolean canRequestPermission(String permission) {
        ComponentCallbacks2 currentActivity = getCurrentActivity();
        PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
        if (permissionAwareActivity != null) {
            return permissionAwareActivity.shouldShowRequestPermissionRationale(permission);
        }
        return false;
    }

    private final PermissionStatus getPermission(String permission) {
        PermissionStatus permissionStatusFromPermissionStatus = PermissionStatus.INSTANCE.fromPermissionStatus(ContextCompat.checkSelfPermission(getReactApplicationContext(), permission));
        return (permissionStatusFromPermissionStatus == PermissionStatus.DENIED && canRequestPermission(permission)) ? PermissionStatus.NOT_DETERMINED : permissionStatusFromPermissionStatus;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getCameraPermissionStatus() {
        return getPermission("android.permission.CAMERA").getUnionValue();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getMicrophonePermissionStatus() {
        return getPermission("android.permission.RECORD_AUDIO").getUnionValue();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getLocationPermissionStatus() {
        PermissionStatus permission = getPermission("android.permission.ACCESS_FINE_LOCATION");
        if (permission == PermissionStatus.GRANTED) {
            return permission.getUnionValue();
        }
        return getPermission("android.permission.ACCESS_COARSE_LOCATION").getUnionValue();
    }

    private final void requestPermission(String permission, final Promise promise) {
        ComponentCallbacks2 currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity instanceof PermissionAwareActivity) {
            final int i = sharedRequestCode;
            sharedRequestCode = i + 1;
            ((PermissionAwareActivity) currentActivity).requestPermissions(new String[]{permission}, i, new PermissionListener() { // from class: com.mrousavy.camera.react.CameraViewModule$$ExternalSyntheticLambda0
                @Override // com.facebook.react.modules.core.PermissionListener
                public final boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    return CameraViewModule.requestPermission$lambda$1(i, promise, i2, strArr, iArr);
                }
            });
            return;
        }
        promise.reject("NO_ACTIVITY", "No PermissionAwareActivity was found! Make sure the app has launched before calling this function.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requestPermission$lambda$1(int i, Promise promise, int i2, String[] strArr, int[] grantResults) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(strArr, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i2 != i) {
            return false;
        }
        promise.resolve(PermissionStatus.INSTANCE.fromPermissionStatus(!(grantResults.length == 0) ? grantResults[0] : -1).getUnionValue());
        return true;
    }

    @ReactMethod
    public final void requestCameraPermission(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.CAMERA", promise);
    }

    @ReactMethod
    public final void requestMicrophonePermission(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.RECORD_AUDIO", promise);
    }

    @ReactMethod
    public final void requestLocationPermission(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.ACCESS_FINE_LOCATION", promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object findCameraView(final int i, Continuation<? super CameraView> continuation) throws ViewNotFoundError {
        if (UiThreadUtil.isOnUiThread()) {
            Log.d("CameraView", "Finding view " + i + "...");
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            if (reactApplicationContext == null) {
                throw new Error("React Context was null!");
            }
            Intrinsics.checkNotNull(reactApplicationContext);
            UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, 1);
            if (uIManager == null) {
                throw new Error("UIManager not found!");
            }
            Intrinsics.checkNotNull(uIManager);
            View viewResolveView = uIManager.resolveView(i);
            CameraView cameraView = viewResolveView instanceof CameraView ? (CameraView) viewResolveView : null;
            if (cameraView == null) {
                throw new ViewNotFoundError(i);
            }
            Log.d("CameraView", "Found view " + i + "!");
            return cameraView;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.react.CameraViewModule$findCameraView$$inlined$runOnUiThreadAndWait$1
            @Override // java.lang.Runnable
            public final void run() throws ViewNotFoundError {
                if (cancellableContinuationImpl2.isCancelled()) {
                    throw new CancellationException();
                }
                Log.d("CameraView", "Finding view " + i + "...");
                ReactApplicationContext reactApplicationContext2 = this.getReactApplicationContext();
                if (reactApplicationContext2 == null) {
                    throw new Error("React Context was null!");
                }
                Intrinsics.checkNotNull(reactApplicationContext2);
                UIManager uIManager2 = UIManagerHelper.getUIManager(reactApplicationContext2, 1);
                if (uIManager2 == null) {
                    throw new Error("UIManager not found!");
                }
                Intrinsics.checkNotNull(uIManager2);
                View viewResolveView2 = uIManager2.resolveView(i);
                CameraView cameraView2 = viewResolveView2 instanceof CameraView ? (CameraView) viewResolveView2 : null;
                if (cameraView2 != null) {
                    Log.d("CameraView", "Found view " + i + "!");
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m5937constructorimpl(cameraView2));
                    return;
                }
                throw new ViewNotFoundError(i);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
