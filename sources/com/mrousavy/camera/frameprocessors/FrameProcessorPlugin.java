package com.mrousavy.camera.frameprocessors;

import java.util.Map;

/* loaded from: classes5.dex */
public abstract class FrameProcessorPlugin {
    public abstract Object callback(Frame frame, Map<String, Object> map) throws Throwable;
}
