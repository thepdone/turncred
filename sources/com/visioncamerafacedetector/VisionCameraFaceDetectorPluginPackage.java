package com.visioncamerafacedetector;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.mrousavy.camera.frameprocessors.FrameProcessorPlugin;
import com.mrousavy.camera.frameprocessors.FrameProcessorPluginRegistry;
import com.mrousavy.camera.frameprocessors.VisionCameraProxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VisionCameraFaceDetectorPluginPackage.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/visioncamerafacedetector/VisionCameraFaceDetectorPluginPackage;", "Lcom/facebook/react/ReactPackage;", "()V", "createNativeModules", "", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "Companion", "react-native-vision-camera-face-detector_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VisionCameraFaceDetectorPluginPackage implements ReactPackage {
    static {
        FrameProcessorPluginRegistry.addFrameProcessorPlugin("detectFaces", new FrameProcessorPluginRegistry.PluginInitializer() { // from class: com.visioncamerafacedetector.VisionCameraFaceDetectorPluginPackage$$ExternalSyntheticLambda0
            @Override // com.mrousavy.camera.frameprocessors.FrameProcessorPluginRegistry.PluginInitializer
            public final FrameProcessorPlugin initializePlugin(VisionCameraProxy visionCameraProxy, Map map) {
                return VisionCameraFaceDetectorPluginPackage._init_$lambda$0(visionCameraProxy, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FrameProcessorPlugin _init_$lambda$0(VisionCameraProxy proxy, Map map) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        return new VisionCameraFaceDetectorPlugin(proxy, map);
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }
}
