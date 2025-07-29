package com.mrousavy.camera.frameprocessors;

import com.facebook.jni.HybridData;
import dalvik.annotation.optimization.FastNative;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class SharedArray {
    private final HybridData mHybridData;

    @FastNative
    private native HybridData initHybrid(VisionCameraProxy visionCameraProxy, int i);

    @FastNative
    private native HybridData initHybrid(VisionCameraProxy visionCameraProxy, ByteBuffer byteBuffer);

    @FastNative
    public native ByteBuffer getByteBuffer();

    @FastNative
    public native int getSize();

    private SharedArray(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public SharedArray(VisionCameraProxy visionCameraProxy, int i) {
        this.mHybridData = initHybrid(visionCameraProxy, i);
    }

    public SharedArray(VisionCameraProxy visionCameraProxy, ByteBuffer byteBuffer) {
        this.mHybridData = initHybrid(visionCameraProxy, byteBuffer);
    }
}
