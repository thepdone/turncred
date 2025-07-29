package androidx.camera.lifecycle;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import com.google.common.util.concurrent.ListenableFuture;
import io.sentry.ProfilingTraceData;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: ProcessCameraProvider.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J5\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H\u0017¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u000f\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0006H\u0017J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0019H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%H\u0007J%\u0010,\u001a\u00020\u001f2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H\u0017¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u001fH\u0017R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider;", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "lifecycleCameraProvider", "Landroidx/camera/lifecycle/LifecycleCameraProviderImpl;", "(Landroidx/camera/lifecycle/LifecycleCameraProviderImpl;)V", "availableCameraInfos", "", "Landroidx/camera/core/CameraInfo;", "getAvailableCameraInfos", "()Ljava/util/List;", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "isConcurrentCameraModeOn", "", "()Z", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "useCases", "", "Landroidx/camera/core/UseCase;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "configure", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getCameraInfo", "hasCamera", "initAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "context", "Landroid/content/Context;", "isBound", "useCase", "shutdownAsync", "unbind", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "Companion", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProcessCameraProvider implements LifecycleCameraProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider(new LifecycleCameraProviderImpl());
    private final LifecycleCameraProviderImpl lifecycleCameraProvider;

    @JvmStatic
    /* renamed from: clearConfiguration-LRDsOJo, reason: not valid java name */
    public static final void m238clearConfigurationLRDsOJo(long j) {
        INSTANCE.m240clearConfigurationLRDsOJo(j);
    }

    @JvmStatic
    public static final void configureInstance(CameraXConfig cameraXConfig) {
        INSTANCE.configureInstance(cameraXConfig);
    }

    @JvmStatic
    public static final ListenableFuture<ProcessCameraProvider> getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    private ProcessCameraProvider(LifecycleCameraProviderImpl lifecycleCameraProviderImpl) {
        this.lifecycleCameraProvider = lifecycleCameraProviderImpl;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        return this.lifecycleCameraProvider.isBound(useCase);
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbind(UseCase... useCases) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        this.lifecycleCameraProvider.unbind((UseCase[]) Arrays.copyOf(useCases, useCases.length));
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbindAll() {
        this.lifecycleCameraProvider.unbindAll();
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCases) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        return this.lifecycleCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, (UseCase[]) Arrays.copyOf(useCases, useCases.length));
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseGroup, "useCaseGroup");
        return this.lifecycleCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroup);
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> singleCameraConfigs) {
        Intrinsics.checkNotNullParameter(singleCameraConfigs, "singleCameraConfigs");
        return this.lifecycleCameraProvider.bindToLifecycle(singleCameraConfigs);
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        return this.lifecycleCameraProvider.getAvailableCameraInfos();
    }

    @Override // androidx.camera.core.CameraProvider
    public final List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        return this.lifecycleCameraProvider.getAvailableConcurrentCameraInfos();
    }

    @Override // androidx.camera.core.CameraProvider
    public final boolean isConcurrentCameraModeOn() {
        return this.lifecycleCameraProvider.isConcurrentCameraModeOn();
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        return this.lifecycleCameraProvider.hasCamera(cameraSelector);
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector cameraSelector) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        return this.lifecycleCameraProvider.getCameraInfo(cameraSelector);
    }

    public final ListenableFuture<Void> shutdownAsync() {
        return this.lifecycleCameraProvider.shutdownAsync$camera_lifecycle_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListenableFuture<Void> initAsync(Context context) {
        return this.lifecycleCameraProvider.initAsync$camera_lifecycle_release(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configure(CameraXConfig cameraXConfig) {
        this.lifecycleCameraProvider.configure$camera_lifecycle_release(cameraXConfig);
    }

    /* compiled from: ProcessCameraProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider$Companion;", "", "()V", "sAppInstance", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "clearConfiguration", "", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "Lkotlin/time/Duration;", "clearConfiguration-LRDsOJo", "(J)V", "configureInstance", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getInstance", "Lcom/google/common/util/concurrent/ListenableFuture;", "context", "Landroid/content/Context;", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ListenableFuture<ProcessCameraProvider> getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Preconditions.checkNotNull(context);
            ListenableFuture listenableFutureInitAsync = ProcessCameraProvider.sAppInstance.initAsync(context);
            final ProcessCameraProvider$Companion$getInstance$1 processCameraProvider$Companion$getInstance$1 = new Function1<Void, ProcessCameraProvider>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$Companion$getInstance$1
                @Override // kotlin.jvm.functions.Function1
                public final ProcessCameraProvider invoke(Void r1) {
                    return ProcessCameraProvider.sAppInstance;
                }
            };
            ListenableFuture<ProcessCameraProvider> listenableFutureTransform = Futures.transform(listenableFutureInitAsync, new Function() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$Companion$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ProcessCameraProvider.Companion.getInstance$lambda$0(processCameraProvider$Companion$getInstance$1, obj);
                }
            }, CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(listenableFutureTransform, "transform(\n             …tExecutor()\n            )");
            return listenableFutureTransform;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProcessCameraProvider getInstance$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (ProcessCameraProvider) tmp0.invoke(obj);
        }

        @JvmStatic
        public final void configureInstance(CameraXConfig cameraXConfig) {
            Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
            Trace.beginSection("CX:configureInstance");
            try {
                ProcessCameraProvider.sAppInstance.configure(cameraXConfig);
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.endSection();
            }
        }

        /* renamed from: clearConfiguration-LRDsOJo$default, reason: not valid java name */
        public static /* synthetic */ void m239clearConfigurationLRDsOJo$default(Companion companion, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                Duration.Companion companion2 = Duration.INSTANCE;
                j = DurationKt.toDuration(10, DurationUnit.SECONDS);
            }
            companion.m240clearConfigurationLRDsOJo(j);
        }

        @JvmStatic
        /* renamed from: clearConfiguration-LRDsOJo, reason: not valid java name */
        public final void m240clearConfigurationLRDsOJo(long timeout) {
            ProcessCameraProvider.sAppInstance.shutdownAsync().get(Duration.m7298getInWholeNanosecondsimpl(timeout), TimeUnit.NANOSECONDS);
        }
    }
}
