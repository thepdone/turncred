package com.mrousavy.camera.frameprocessors;

import com.facebook.jni.HybridData;
import com.mrousavy.camera.core.CameraQueues;

/* loaded from: classes5.dex */
public class VisionCameraScheduler {
    private final HybridData mHybridData = initHybrid();

    private native HybridData initHybrid();

    /* JADX INFO: Access modifiers changed from: private */
    public native void trigger();

    private void scheduleTrigger() {
        CameraQueues.INSTANCE.getVideoQueue().getHandler().post(new Runnable() { // from class: com.mrousavy.camera.frameprocessors.VisionCameraScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.trigger();
            }
        });
    }
}
