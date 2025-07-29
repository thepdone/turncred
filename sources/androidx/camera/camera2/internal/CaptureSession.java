package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.internal.compat.workaround.TorchStateReset;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
final class CaptureSession implements CaptureSessionInterface {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    private final List<CaptureConfig> mCaptureConfigs;
    private final StateCallback mCaptureSessionStateCallback;
    List<DeferrableSurface> mConfiguredDeferrableSurfaces;
    private final Map<DeferrableSurface, Surface> mConfiguredSurfaceMap;
    private final DynamicRangesCompat mDynamicRangesCompat;
    CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;
    ListenableFuture<Void> mReleaseFuture;
    private final RequestMonitor mRequestMonitor;
    SessionConfig mSessionConfig;
    final Object mSessionLock;
    SynchronizedCaptureSession.Opener mSessionOpener;
    State mState;
    private final StillCaptureFlow mStillCaptureFlow;
    private Map<DeferrableSurface, Long> mStreamUseCaseMap;
    SynchronizedCaptureSession mSynchronizedCaptureSession;
    private final TemplateParamsOverride mTemplateParamsOverride;
    private final TorchStateReset mTorchStateReset;

    enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    CaptureSession(DynamicRangesCompat dynamicRangesCompat) {
        this(dynamicRangesCompat, new Quirks(Collections.emptyList()));
    }

    CaptureSession(DynamicRangesCompat dynamicRangesCompat, Quirks quirks) {
        this.mSessionLock = new Object();
        this.mCaptureConfigs = new ArrayList();
        this.mConfiguredSurfaceMap = new HashMap();
        this.mConfiguredDeferrableSurfaces = Collections.emptyList();
        this.mState = State.UNINITIALIZED;
        this.mStreamUseCaseMap = new HashMap();
        this.mStillCaptureFlow = new StillCaptureFlow();
        this.mTorchStateReset = new TorchStateReset();
        this.mState = State.INITIALIZED;
        this.mDynamicRangesCompat = dynamicRangesCompat;
        this.mCaptureSessionStateCallback = new StateCallback();
        this.mRequestMonitor = new RequestMonitor(quirks.contains(CaptureNoResponseQuirk.class));
        this.mTemplateParamsOverride = new TemplateParamsOverride(quirks);
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setStreamUseCaseMap(Map<DeferrableSurface, Long> map) {
        synchronized (this.mSessionLock) {
            this.mStreamUseCaseMap = map;
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mSessionLock) {
            sessionConfig = this.mSessionConfig;
        }
        return sessionConfig;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setSessionConfig(SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            switch (this.mState) {
                case UNINITIALIZED:
                    throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.mState);
                case INITIALIZED:
                case GET_SURFACE:
                case OPENING:
                    this.mSessionConfig = sessionConfig;
                    break;
                case OPENED:
                    this.mSessionConfig = sessionConfig;
                    if (sessionConfig != null) {
                        if (!this.mConfiguredSurfaceMap.keySet().containsAll(sessionConfig.getSurfaces())) {
                            Logger.e(TAG, "Does not have the proper configured lists");
                            return;
                        } else {
                            Logger.d(TAG, "Attempting to submit CaptureRequest after setting");
                            issueRepeatingCaptureRequests(this.mSessionConfig);
                            break;
                        }
                    } else {
                        return;
                    }
                case CLOSED:
                case RELEASING:
                case RELEASED:
                    throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> open(final SessionConfig sessionConfig, final CameraDevice cameraDevice, SynchronizedCaptureSession.Opener opener) {
        synchronized (this.mSessionLock) {
            if (this.mState.ordinal() == 1) {
                this.mState = State.GET_SURFACE;
                ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
                this.mConfiguredDeferrableSurfaces = arrayList;
                this.mSessionOpener = opener;
                FutureChain futureChainTransformAsync = FutureChain.from(opener.startWithDeferrableSurface(arrayList, 5000L)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda2
                    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                    public final ListenableFuture apply(Object obj) {
                        return this.f$0.m64lambda$open$0$androidxcameracamera2internalCaptureSession(sessionConfig, cameraDevice, (List) obj);
                    }
                }, this.mSessionOpener.getExecutor());
                Futures.addCallback(futureChainTransformAsync, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.CaptureSession.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(Void r1) {
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable th) {
                        synchronized (CaptureSession.this.mSessionLock) {
                            CaptureSession.this.mSessionOpener.stop();
                            int iOrdinal = CaptureSession.this.mState.ordinal();
                            if ((iOrdinal == 3 || iOrdinal == 5 || iOrdinal == 6) && !(th instanceof CancellationException)) {
                                Logger.w(CaptureSession.TAG, "Opening session with fail " + CaptureSession.this.mState, th);
                                CaptureSession.this.finishClose();
                            }
                        }
                    }
                }, this.mSessionOpener.getExecutor());
                return Futures.nonCancellationPropagating(futureChainTransformAsync);
            }
            Logger.e(TAG, "Open not allowed in state: " + this.mState);
            return Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: openCaptureSession, reason: merged with bridge method [inline-methods] */
    public ListenableFuture<Void> m64lambda$open$0$androidxcameracamera2internalCaptureSession(List<Surface> list, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        synchronized (this.mSessionLock) {
            int iOrdinal = this.mState.ordinal();
            if (iOrdinal != 0 && iOrdinal != 1) {
                if (iOrdinal == 2) {
                    this.mConfiguredSurfaceMap.clear();
                    for (int i = 0; i < list.size(); i++) {
                        this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(i), list.get(i));
                    }
                    this.mState = State.OPENING;
                    Logger.d(TAG, "Opening capture session.");
                    SynchronizedCaptureSession.StateCallback stateCallbackCreateComboCallback = SynchronizedCaptureSessionStateCallbacks.createComboCallback(this.mCaptureSessionStateCallback, new SynchronizedCaptureSessionStateCallbacks.Adapter(sessionConfig.getSessionStateCallbacks()));
                    Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(sessionConfig.getImplementationOptions());
                    CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(sessionConfig.getRepeatingCaptureConfig());
                    ArrayList arrayList = new ArrayList();
                    String physicalCameraId = camera2ImplConfig.getPhysicalCameraId(null);
                    for (SessionConfig.OutputConfig outputConfig : sessionConfig.getOutputConfigs()) {
                        OutputConfigurationCompat outputConfigurationCompat = getOutputConfigurationCompat(outputConfig, this.mConfiguredSurfaceMap, physicalCameraId);
                        if (this.mStreamUseCaseMap.containsKey(outputConfig.getSurface())) {
                            outputConfigurationCompat.setStreamUseCase(this.mStreamUseCaseMap.get(outputConfig.getSurface()).longValue());
                        }
                        arrayList.add(outputConfigurationCompat);
                    }
                    SessionConfigurationCompat sessionConfigurationCompatCreateSessionConfigurationCompat = this.mSessionOpener.createSessionConfigurationCompat(sessionConfig.getSessionType(), getUniqueOutputConfigurations(arrayList), stateCallbackCreateComboCallback);
                    if (sessionConfig.getTemplateType() == 5 && sessionConfig.getInputConfiguration() != null) {
                        sessionConfigurationCompatCreateSessionConfigurationCompat.setInputConfiguration(InputConfigurationCompat.wrap(sessionConfig.getInputConfiguration()));
                    }
                    try {
                        CaptureRequest captureRequestBuildWithoutTarget = Camera2CaptureRequestBuilder.buildWithoutTarget(builderFrom.build(), cameraDevice, this.mTemplateParamsOverride);
                        if (captureRequestBuildWithoutTarget != null) {
                            sessionConfigurationCompatCreateSessionConfigurationCompat.setSessionParameters(captureRequestBuildWithoutTarget);
                        }
                        return this.mSessionOpener.openCaptureSession(cameraDevice, sessionConfigurationCompatCreateSessionConfigurationCompat, this.mConfiguredDeferrableSurfaces);
                    } catch (CameraAccessException e) {
                        return Futures.immediateFailedFuture(e);
                    }
                }
                if (iOrdinal != 4) {
                    return Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));
                }
            }
            return Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));
        }
    }

    private List<OutputConfigurationCompat> getUniqueOutputConfigurations(List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            if (!arrayList.contains(outputConfigurationCompat.getSurface())) {
                arrayList.add(outputConfigurationCompat.getSurface());
                arrayList2.add(outputConfigurationCompat);
            }
        }
        return arrayList2;
    }

    private OutputConfigurationCompat getOutputConfigurationCompat(SessionConfig.OutputConfig outputConfig, Map<DeferrableSurface, Surface> map, String str) {
        long jLongValue;
        DynamicRangeProfiles dynamicRangeProfiles;
        Surface surface = map.get(outputConfig.getSurface());
        Preconditions.checkNotNull(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        OutputConfigurationCompat outputConfigurationCompat = new OutputConfigurationCompat(outputConfig.getSurfaceGroupId(), surface);
        if (str != null) {
            outputConfigurationCompat.setPhysicalCameraId(str);
        } else {
            outputConfigurationCompat.setPhysicalCameraId(outputConfig.getPhysicalCameraId());
        }
        if (outputConfig.getMirrorMode() == 0) {
            outputConfigurationCompat.setMirrorMode(1);
        } else if (outputConfig.getMirrorMode() == 1) {
            outputConfigurationCompat.setMirrorMode(2);
        }
        if (!outputConfig.getSharedSurfaces().isEmpty()) {
            outputConfigurationCompat.enableSurfaceSharing();
            Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
            while (it.hasNext()) {
                Surface surface2 = map.get(it.next());
                Preconditions.checkNotNull(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                outputConfigurationCompat.addSurface(surface2);
            }
        }
        if (Build.VERSION.SDK_INT < 33 || (dynamicRangeProfiles = this.mDynamicRangesCompat.toDynamicRangeProfiles()) == null) {
            jLongValue = 1;
        } else {
            DynamicRange dynamicRange = outputConfig.getDynamicRange();
            Long lDynamicRangeToFirstSupportedProfile = DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(dynamicRange, dynamicRangeProfiles);
            if (lDynamicRangeToFirstSupportedProfile == null) {
                Logger.e(TAG, "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + dynamicRange);
                jLongValue = 1;
            } else {
                jLongValue = lDynamicRangeToFirstSupportedProfile.longValue();
            }
        }
        outputConfigurationCompat.setDynamicRangeProfile(jLongValue);
        return outputConfigurationCompat;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        synchronized (this.mSessionLock) {
            int iOrdinal = this.mState.ordinal();
            if (iOrdinal == 0) {
                throw new IllegalStateException("close() should not be possible in state: " + this.mState);
            }
            if (iOrdinal == 1) {
                this.mState = State.RELEASED;
            } else if (iOrdinal == 2) {
                Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:" + this.mState);
                this.mSessionOpener.stop();
                this.mState = State.RELEASED;
            } else if (iOrdinal == 3 || iOrdinal == 4) {
                Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:" + this.mState);
                this.mSessionOpener.stop();
                this.mState = State.CLOSED;
                this.mRequestMonitor.stop();
                this.mSessionConfig = null;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[Catch: all -> 0x00a1, TryCatch #0 {, blocks: (B:4:0x0009, B:5:0x000f, B:28:0x009a, B:7:0x0014, B:10:0x001a, B:14:0x0026, B:13:0x001f, B:15:0x002b, B:17:0x0050, B:18:0x0054, B:20:0x0058, B:21:0x0063, B:22:0x0065, B:24:0x0067, B:25:0x0080, B:26:0x0085, B:27:0x0099), top: B:34:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[Catch: all -> 0x00a1, TryCatch #0 {, blocks: (B:4:0x0009, B:5:0x000f, B:28:0x009a, B:7:0x0014, B:10:0x001a, B:14:0x0026, B:13:0x001f, B:15:0x002b, B:17:0x0050, B:18:0x0054, B:20:0x0058, B:21:0x0063, B:22:0x0065, B:24:0x0067, B:25:0x0080, B:26:0x0085, B:27:0x0099), top: B:34:0x0009, inners: #1 }] */
    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> release(boolean r6) {
        /*
            r5 = this;
            java.lang.String r0 = "The Opener shouldn't null in state:"
            java.lang.String r1 = "The Opener shouldn't null in state:"
            java.lang.String r2 = "release() should not be possible in state: "
            java.lang.Object r3 = r5.mSessionLock
            monitor-enter(r3)
            androidx.camera.camera2.internal.CaptureSession$State r4 = r5.mState     // Catch: java.lang.Throwable -> La1
            int r4 = r4.ordinal()     // Catch: java.lang.Throwable -> La1
            switch(r4) {
                case 0: goto L85;
                case 1: goto L80;
                case 2: goto L67;
                case 3: goto L2b;
                case 4: goto L14;
                case 5: goto L14;
                case 6: goto L54;
                default: goto L12;
            }     // Catch: java.lang.Throwable -> La1
        L12:
            goto L9a
        L14:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r1 = r5.mSynchronizedCaptureSession     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto L2b
            if (r6 == 0) goto L26
            r1.abortCaptures()     // Catch: android.hardware.camera2.CameraAccessException -> L1e java.lang.Throwable -> La1
            goto L26
        L1e:
            r6 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            androidx.camera.core.Logger.e(r1, r2, r6)     // Catch: java.lang.Throwable -> La1
        L26:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r6 = r5.mSynchronizedCaptureSession     // Catch: java.lang.Throwable -> La1
            r6.close()     // Catch: java.lang.Throwable -> La1
        L2b:
            androidx.camera.camera2.internal.CaptureSession$State r6 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch: java.lang.Throwable -> La1
            r5.mState = r6     // Catch: java.lang.Throwable -> La1
            androidx.camera.camera2.internal.compat.workaround.RequestMonitor r6 = r5.mRequestMonitor     // Catch: java.lang.Throwable -> La1
            r6.stop()     // Catch: java.lang.Throwable -> La1
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1
            r1.<init>(r0)     // Catch: java.lang.Throwable -> La1
            androidx.camera.camera2.internal.CaptureSession$State r0 = r5.mState     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Throwable -> La1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La1
            androidx.core.util.Preconditions.checkNotNull(r6, r0)     // Catch: java.lang.Throwable -> La1
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch: java.lang.Throwable -> La1
            boolean r6 = r6.stop()     // Catch: java.lang.Throwable -> La1
            if (r6 == 0) goto L54
            r5.finishClose()     // Catch: java.lang.Throwable -> La1
            goto L9a
        L54:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r6 = r5.mReleaseFuture     // Catch: java.lang.Throwable -> La1
            if (r6 != 0) goto L63
            androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda1 r6 = new androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda1     // Catch: java.lang.Throwable -> La1
            r6.<init>()     // Catch: java.lang.Throwable -> La1
            com.google.common.util.concurrent.ListenableFuture r6 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r6)     // Catch: java.lang.Throwable -> La1
            r5.mReleaseFuture = r6     // Catch: java.lang.Throwable -> La1
        L63:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r6 = r5.mReleaseFuture     // Catch: java.lang.Throwable -> La1
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La1
            return r6
        L67:
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1
            r0.<init>(r1)     // Catch: java.lang.Throwable -> La1
            androidx.camera.camera2.internal.CaptureSession$State r1 = r5.mState     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La1
            androidx.core.util.Preconditions.checkNotNull(r6, r0)     // Catch: java.lang.Throwable -> La1
            androidx.camera.camera2.internal.SynchronizedCaptureSession$Opener r6 = r5.mSessionOpener     // Catch: java.lang.Throwable -> La1
            r6.stop()     // Catch: java.lang.Throwable -> La1
        L80:
            androidx.camera.camera2.internal.CaptureSession$State r6 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch: java.lang.Throwable -> La1
            r5.mState = r6     // Catch: java.lang.Throwable -> La1
            goto L9a
        L85:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1
            r0.<init>(r2)     // Catch: java.lang.Throwable -> La1
            androidx.camera.camera2.internal.CaptureSession$State r1 = r5.mState     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La1
            r6.<init>(r0)     // Catch: java.lang.Throwable -> La1
            throw r6     // Catch: java.lang.Throwable -> La1
        L9a:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La1
            r6 = 0
            com.google.common.util.concurrent.ListenableFuture r6 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r6)
            return r6
        La1:
            r6 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La1
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.release(boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* renamed from: lambda$release$1$androidx-camera-camera2-internal-CaptureSession, reason: not valid java name */
    /* synthetic */ Object m65lambda$release$1$androidxcameracamera2internalCaptureSession(CallbackToFutureAdapter.Completer completer) throws Exception {
        String str;
        synchronized (this.mSessionLock) {
            Preconditions.checkState(this.mReleaseCompleter == null, "Release completer expected to be null");
            this.mReleaseCompleter = completer;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void issueCaptureRequests(List<CaptureConfig> list) {
        synchronized (this.mSessionLock) {
            switch (this.mState) {
                case UNINITIALIZED:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);
                case INITIALIZED:
                case GET_SURFACE:
                case OPENING:
                    this.mCaptureConfigs.addAll(list);
                    break;
                case OPENED:
                    this.mCaptureConfigs.addAll(list);
                    issuePendingCaptureRequest();
                    break;
                case CLOSED:
                case RELEASING:
                case RELEASED:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public List<CaptureConfig> getCaptureConfigs() {
        List<CaptureConfig> listUnmodifiableList;
        synchronized (this.mSessionLock) {
            listUnmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return listUnmodifiableList;
    }

    State getState() {
        State state;
        synchronized (this.mSessionLock) {
            state = this.mState;
        }
        return state;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public boolean isInOpenState() {
        boolean z;
        synchronized (this.mSessionLock) {
            z = this.mState == State.OPENED || this.mState == State.OPENING;
        }
        return z;
    }

    void finishClose() {
        if (this.mState == State.RELEASED) {
            Logger.d(TAG, "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.mState = State.RELEASED;
        this.mSynchronizedCaptureSession = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.mReleaseCompleter;
        if (completer != null) {
            completer.set(null);
            this.mReleaseCompleter = null;
        }
    }

    int issueRepeatingCaptureRequests(SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            if (sessionConfig == null) {
                Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return -1;
            }
            if (this.mState != State.OPENED) {
                Logger.d(TAG, "Skipping issueRepeatingCaptureRequests due to session closed");
                return -1;
            }
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
                Logger.d(TAG, "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    this.mSynchronizedCaptureSession.stopRepeating();
                } catch (CameraAccessException e) {
                    Logger.e(TAG, "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                return -1;
            }
            try {
                Logger.d(TAG, "Issuing request for session.");
                CaptureRequest captureRequestBuild = Camera2CaptureRequestBuilder.build(repeatingCaptureConfig, this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap, true, this.mTemplateParamsOverride);
                if (captureRequestBuild == null) {
                    Logger.d(TAG, "Skipping issuing empty request for session.");
                    return -1;
                }
                return this.mSynchronizedCaptureSession.setSingleRepeatingRequest(captureRequestBuild, this.mRequestMonitor.createMonitorListener(createCamera2CaptureCallback(repeatingCaptureConfig.getCameraCaptureCallbacks(), new CameraCaptureSession.CaptureCallback[0])));
            } catch (CameraAccessException e2) {
                Logger.e(TAG, "Unable to access camera: " + e2.getMessage());
                Thread.dumpStack();
                return -1;
            }
        }
    }

    void issuePendingCaptureRequest() {
        this.mRequestMonitor.getRequestsProcessedFuture().addListener(new Runnable() { // from class: androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m63x337815aa();
            }
        }, CameraXExecutors.directExecutor());
    }

    /* renamed from: lambda$issuePendingCaptureRequest$2$androidx-camera-camera2-internal-CaptureSession, reason: not valid java name */
    /* synthetic */ void m63x337815aa() {
        synchronized (this.mSessionLock) {
            if (this.mCaptureConfigs.isEmpty()) {
                return;
            }
            try {
                issueBurstCaptureRequest(this.mCaptureConfigs);
            } finally {
                this.mCaptureConfigs.clear();
            }
        }
    }

    int issueBurstCaptureRequest(List<CaptureConfig> list) {
        CameraBurstCaptureCallback cameraBurstCaptureCallback;
        ArrayList arrayList;
        boolean z;
        synchronized (this.mSessionLock) {
            if (this.mState != State.OPENED) {
                Logger.d(TAG, "Skipping issueBurstCaptureRequest due to session closed");
                return -1;
            }
            if (list.isEmpty()) {
                return -1;
            }
            try {
                cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
                arrayList = new ArrayList();
                Logger.d(TAG, "Issuing capture request.");
                z = false;
                for (CaptureConfig captureConfig : list) {
                    if (captureConfig.getSurfaces().isEmpty()) {
                        Logger.d(TAG, "Skipping issuing empty capture request.");
                    } else {
                        Iterator<DeferrableSurface> it = captureConfig.getSurfaces().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                DeferrableSurface next = it.next();
                                if (!this.mConfiguredSurfaceMap.containsKey(next)) {
                                    Logger.d(TAG, "Skipping capture request with invalid surface: " + next);
                                    break;
                                }
                            } else {
                                if (captureConfig.getTemplateType() == 2) {
                                    z = true;
                                }
                                CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(captureConfig);
                                if (captureConfig.getTemplateType() == 5 && captureConfig.getCameraCaptureResult() != null) {
                                    builderFrom.setCameraCaptureResult(captureConfig.getCameraCaptureResult());
                                }
                                SessionConfig sessionConfig = this.mSessionConfig;
                                if (sessionConfig != null) {
                                    builderFrom.addImplementationOptions(sessionConfig.getRepeatingCaptureConfig().getImplementationOptions());
                                }
                                builderFrom.addImplementationOptions(captureConfig.getImplementationOptions());
                                CaptureRequest captureRequestBuild = Camera2CaptureRequestBuilder.build(builderFrom.build(), this.mSynchronizedCaptureSession.getDevice(), this.mConfiguredSurfaceMap, false, this.mTemplateParamsOverride);
                                if (captureRequestBuild == null) {
                                    Logger.d(TAG, "Skipping issuing request without surface.");
                                    return -1;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                Iterator<CameraCaptureCallback> it2 = captureConfig.getCameraCaptureCallbacks().iterator();
                                while (it2.hasNext()) {
                                    CaptureCallbackConverter.toCaptureCallback(it2.next(), arrayList2);
                                }
                                cameraBurstCaptureCallback.addCamera2Callbacks(captureRequestBuild, arrayList2);
                                arrayList.add(captureRequestBuild);
                            }
                        }
                    }
                }
            } catch (CameraAccessException e) {
                Logger.e(TAG, "Unable to access camera: " + e.getMessage());
                Thread.dumpStack();
            }
            if (!arrayList.isEmpty()) {
                if (this.mStillCaptureFlow.shouldStopRepeatingBeforeCapture(arrayList, z)) {
                    this.mSynchronizedCaptureSession.stopRepeating();
                    cameraBurstCaptureCallback.setCaptureSequenceCallback(new CameraBurstCaptureCallback.CaptureSequenceCallback() { // from class: androidx.camera.camera2.internal.CaptureSession$$ExternalSyntheticLambda0
                        @Override // androidx.camera.camera2.internal.CameraBurstCaptureCallback.CaptureSequenceCallback
                        public final void onCaptureSequenceCompletedOrAborted(CameraCaptureSession cameraCaptureSession, int i, boolean z2) {
                            this.f$0.m62xac56a034(cameraCaptureSession, i, z2);
                        }
                    });
                }
                if (this.mTorchStateReset.isTorchResetRequired(arrayList, z)) {
                    cameraBurstCaptureCallback.addCamera2Callbacks((CaptureRequest) arrayList.get(arrayList.size() - 1), Collections.singletonList(new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.CaptureSession.2
                        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                            synchronized (CaptureSession.this.mSessionLock) {
                                if (CaptureSession.this.mSessionConfig == null) {
                                    return;
                                }
                                CaptureConfig repeatingCaptureConfig = CaptureSession.this.mSessionConfig.getRepeatingCaptureConfig();
                                Logger.d(CaptureSession.TAG, "Submit FLASH_MODE_OFF request");
                                CaptureSession captureSession = CaptureSession.this;
                                captureSession.issueCaptureRequests(Collections.singletonList(captureSession.mTorchStateReset.createTorchResetRequest(repeatingCaptureConfig)));
                            }
                        }
                    }));
                }
                return this.mSynchronizedCaptureSession.captureBurstRequests(arrayList, cameraBurstCaptureCallback);
            }
            Logger.d(TAG, "Skipping issuing burst request due to no valid request elements");
            return -1;
        }
    }

    /* renamed from: lambda$issueBurstCaptureRequest$3$androidx-camera-camera2-internal-CaptureSession, reason: not valid java name */
    /* synthetic */ void m62xac56a034(CameraCaptureSession cameraCaptureSession, int i, boolean z) {
        synchronized (this.mSessionLock) {
            if (this.mState == State.OPENED) {
                issueRepeatingCaptureRequests(this.mSessionConfig);
            }
        }
    }

    void abortCaptures() {
        synchronized (this.mSessionLock) {
            if (this.mState != State.OPENED) {
                Logger.e(TAG, "Unable to abort captures. Incorrect state:" + this.mState);
                return;
            }
            try {
                this.mSynchronizedCaptureSession.abortCaptures();
            } catch (CameraAccessException e) {
                Logger.e(TAG, "Unable to abort captures.", e);
            }
        }
    }

    void stopRepeating() {
        synchronized (this.mSessionLock) {
            if (this.mState != State.OPENED) {
                Logger.e(TAG, "Unable to stop repeating. Incorrect state:" + this.mState);
                return;
            }
            try {
                this.mSynchronizedCaptureSession.stopRepeating();
            } catch (CameraAccessException e) {
                Logger.e(TAG, "Unable to stop repeating.", e);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void cancelIssuedCaptureRequests() {
        ArrayList<CaptureConfig> arrayList;
        synchronized (this.mSessionLock) {
            if (this.mCaptureConfigs.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(this.mCaptureConfigs);
                this.mCaptureConfigs.clear();
            }
        }
        if (arrayList != null) {
            for (CaptureConfig captureConfig : arrayList) {
                Iterator<CameraCaptureCallback> it = captureConfig.getCameraCaptureCallbacks().iterator();
                while (it.hasNext()) {
                    it.next().onCaptureCancelled(captureConfig.getId());
                }
            }
        }
    }

    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator<CameraCaptureCallback> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CaptureCallbackConverter.toCaptureCallback(it.next()));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.createComboCallback(arrayList);
    }

    final class StateCallback extends SynchronizedCaptureSession.StateCallback {
        StateCallback() {
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                switch (CaptureSession.this.mState) {
                    case UNINITIALIZED:
                    case INITIALIZED:
                    case GET_SURFACE:
                    case OPENED:
                    case RELEASED:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.mState);
                    case OPENING:
                        CaptureSession.this.mState = State.OPENED;
                        CaptureSession.this.mSynchronizedCaptureSession = synchronizedCaptureSession;
                        Logger.d(CaptureSession.TAG, "Attempting to send capture request onConfigured");
                        CaptureSession captureSession = CaptureSession.this;
                        captureSession.issueRepeatingCaptureRequests(captureSession.mSessionConfig);
                        CaptureSession.this.issuePendingCaptureRequest();
                        break;
                    case CLOSED:
                        CaptureSession.this.mSynchronizedCaptureSession = synchronizedCaptureSession;
                        break;
                    case RELEASING:
                        synchronizedCaptureSession.close();
                        break;
                }
                Logger.d(CaptureSession.TAG, "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.mState);
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                if (CaptureSession.this.mState.ordinal() == 0) {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.mState);
                }
                Logger.d(CaptureSession.TAG, "CameraCaptureSession.onReady() " + CaptureSession.this.mState);
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onSessionFinished(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                if (CaptureSession.this.mState == State.UNINITIALIZED) {
                    throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.mState);
                }
                Logger.d(CaptureSession.TAG, "onSessionFinished()");
                CaptureSession.this.finishClose();
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
        public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.mSessionLock) {
                switch (CaptureSession.this.mState) {
                    case UNINITIALIZED:
                    case INITIALIZED:
                    case GET_SURFACE:
                    case OPENED:
                        throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.mState);
                    case OPENING:
                    case CLOSED:
                    case RELEASING:
                        CaptureSession.this.finishClose();
                        break;
                    case RELEASED:
                        Logger.d(CaptureSession.TAG, "ConfigureFailed callback after change to RELEASED state");
                        break;
                }
                Logger.e(CaptureSession.TAG, "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.mState);
            }
        }
    }
}
