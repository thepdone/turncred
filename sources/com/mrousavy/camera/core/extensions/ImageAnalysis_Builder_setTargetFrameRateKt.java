package com.mrousavy.camera.core.extensions;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.interop.Camera2Interop;
import androidx.camera.core.ImageAnalysis;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageAnalysis.Builder+setTargetFrameRate.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"setTargetFrameRate", "", "Landroidx/camera/core/ImageAnalysis$Builder;", RRWebVideoEvent.JsonKeys.FRAME_RATE, "Landroid/util/Range;", "", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageAnalysis_Builder_setTargetFrameRateKt {
    public static final void setTargetFrameRate(ImageAnalysis.Builder builder, Range<Integer> frameRate) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(frameRate, "frameRate");
        new Camera2Interop.Extender(builder).setCaptureRequestOption(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, frameRate);
    }
}
