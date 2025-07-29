package com.mrousavy.camera.frameprocessors;

import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.UIManagerHelper;
import com.mrousavy.camera.core.ViewNotFoundError;
import com.mrousavy.camera.react.CameraView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisionCameraProxy.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0017H\u0007J!\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0082 J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0007R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/mrousavy/camera/frameprocessors/VisionCameraProxy;", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "context", "getContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "mContext", "Ljava/lang/ref/WeakReference;", "mHybridData", "Lcom/facebook/jni/HybridData;", "mScheduler", "Lcom/mrousavy/camera/frameprocessors/VisionCameraScheduler;", "findCameraViewById", "Lcom/mrousavy/camera/react/CameraView;", "viewId", "", "initFrameProcessorPlugin", "Lcom/mrousavy/camera/frameprocessors/FrameProcessorPlugin;", "name", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "initHybrid", "jsContext", "", "jsCallInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "scheduler", "removeFrameProcessor", "", "setFrameProcessor", "frameProcessor", "Lcom/mrousavy/camera/frameprocessors/FrameProcessor;", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VisionCameraProxy {
    public static final String TAG = "VisionCameraProxy";
    private WeakReference<ReactApplicationContext> mContext;
    private HybridData mHybridData;
    private VisionCameraScheduler mScheduler;
    private final ReactApplicationContext reactContext;

    private final native HybridData initHybrid(long jsContext, CallInvokerHolderImpl jsCallInvokerHolder, VisionCameraScheduler scheduler);

    public VisionCameraProxy(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        CallInvokerHolder jSCallInvokerHolder = getReactContext().getCatalystInstance().getJSCallInvokerHolder();
        Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
        CallInvokerHolderImpl callInvokerHolderImpl = (CallInvokerHolderImpl) jSCallInvokerHolder;
        JavaScriptContextHolder javaScriptContextHolder = getReactContext().getJavaScriptContextHolder();
        if (javaScriptContextHolder == null) {
            throw new Error("JSI Runtime is null! VisionCamera does not yet support bridgeless mode..");
        }
        long j = javaScriptContextHolder.get();
        this.mScheduler = new VisionCameraScheduler();
        this.mContext = new WeakReference<>(getReactContext());
        this.mHybridData = initHybrid(j, callInvokerHolderImpl, this.mScheduler);
    }

    /* renamed from: getContext, reason: from getter */
    public final ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    private final CameraView findCameraViewById(int viewId) throws ViewNotFoundError {
        Log.d(TAG, "Finding view " + viewId + "...");
        ReactApplicationContext reactApplicationContext = this.mContext.get();
        CameraView cameraView = null;
        if (reactApplicationContext != null) {
            UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, viewId);
            cameraView = (CameraView) (uIManager != null ? uIManager.resolveView(viewId) : null);
        }
        Log.d(TAG, (cameraView != null ? new StringBuilder("Found view ") : new StringBuilder("Couldn't find view ")).append(viewId).append("!").toString());
        if (cameraView != null) {
            return cameraView;
        }
        throw new ViewNotFoundError(viewId);
    }

    public final void setFrameProcessor(final int viewId, final FrameProcessor frameProcessor) {
        Intrinsics.checkNotNullParameter(frameProcessor, "frameProcessor");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.frameprocessors.VisionCameraProxy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VisionCameraProxy.setFrameProcessor$lambda$0(this.f$0, viewId, frameProcessor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameProcessor$lambda$0(VisionCameraProxy this$0, int i, FrameProcessor frameProcessor) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(frameProcessor, "$frameProcessor");
        this$0.findCameraViewById(i).setFrameProcessor$react_native_vision_camera_release(frameProcessor);
    }

    public final void removeFrameProcessor(final int viewId) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.frameprocessors.VisionCameraProxy$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VisionCameraProxy.removeFrameProcessor$lambda$1(this.f$0, viewId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeFrameProcessor$lambda$1(VisionCameraProxy this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.findCameraViewById(i).setFrameProcessor$react_native_vision_camera_release(null);
    }

    public final FrameProcessorPlugin initFrameProcessorPlugin(String name, Map<String, ? extends Object> options) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(options, "options");
        return FrameProcessorPluginRegistry.getPlugin(name, this, options);
    }
}
