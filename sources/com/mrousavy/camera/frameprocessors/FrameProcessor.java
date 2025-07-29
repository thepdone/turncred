package com.mrousavy.camera.frameprocessors;

import com.facebook.jni.HybridData;
import dalvik.annotation.optimization.FastNative;

/* loaded from: classes5.dex */
public final class FrameProcessor {
    private final HybridData mHybridData;

    @FastNative
    public native void call(Frame frame);

    public FrameProcessor(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
