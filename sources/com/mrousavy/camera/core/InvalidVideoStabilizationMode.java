package com.mrousavy.camera.core;

import com.mrousavy.camera.core.types.VideoStabilizationMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/InvalidVideoStabilizationMode;", "Lcom/mrousavy/camera/core/CameraError;", "mode", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "(Lcom/mrousavy/camera/core/types/VideoStabilizationMode;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvalidVideoStabilizationMode extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidVideoStabilizationMode(VideoStabilizationMode mode) {
        super("format", "invalid-video-stabilization-mode", "The given format does not support the videoStabilizationMode \"" + mode.getUnionValue() + "\"! Select a format that contains " + mode.getUnionValue() + " in `format.supportedVideoStabilizationModes`.", null, 8, null);
        Intrinsics.checkNotNullParameter(mode, "mode");
    }
}
