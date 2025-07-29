package com.facebook.imagepipeline.animated.util;

import android.graphics.Bitmap;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedDrawableUtil.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/facebook/imagepipeline/animated/util/AnimatedDrawableUtil;", "", "()V", "fixFrameDurations", "", "frameDurationMs", "", "getFrameForTimestampMs", "", "frameTimestampsMs", "timestampMs", "getFrameTimeStampsFromDurations", "frameDurationsMs", "getSizeOfBitmap", "bitmap", "Landroid/graphics/Bitmap;", "getTotalDurationFromFrameDurations", "Companion", "animated-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimatedDrawableUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int FRAME_DURATION_MS_FOR_MIN = 100;
    private static final int MIN_FRAME_DURATION_MS = 11;

    @JvmStatic
    public static final boolean isOutsideRange(int i, int i2, int i3) {
        return INSTANCE.isOutsideRange(i, i2, i3);
    }

    public final void fixFrameDurations(int[] frameDurationMs) {
        Intrinsics.checkNotNullParameter(frameDurationMs, "frameDurationMs");
        int length = frameDurationMs.length;
        for (int i = 0; i < length; i++) {
            if (frameDurationMs[i] < 11) {
                frameDurationMs[i] = 100;
            }
        }
    }

    public final int getTotalDurationFromFrameDurations(int[] frameDurationMs) {
        Intrinsics.checkNotNullParameter(frameDurationMs, "frameDurationMs");
        int i = 0;
        for (int i2 : frameDurationMs) {
            i += i2;
        }
        return i;
    }

    public final int[] getFrameTimeStampsFromDurations(int[] frameDurationsMs) {
        Intrinsics.checkNotNullParameter(frameDurationsMs, "frameDurationsMs");
        int[] iArr = new int[frameDurationsMs.length];
        int length = frameDurationsMs.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = i;
            i += frameDurationsMs[i2];
        }
        return iArr;
    }

    public final int getFrameForTimestampMs(int[] frameTimestampsMs, int timestampMs) {
        int iBinarySearch = Arrays.binarySearch(frameTimestampsMs, timestampMs);
        return iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
    }

    public final int getSizeOfBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return bitmap.getAllocationByteCount();
    }

    /* compiled from: AnimatedDrawableUtil.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/imagepipeline/animated/util/AnimatedDrawableUtil$Companion;", "", "()V", "FRAME_DURATION_MS_FOR_MIN", "", "MIN_FRAME_DURATION_MS", "isOutsideRange", "", "startFrame", "endFrame", "frameNumber", "animated-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isOutsideRange(int startFrame, int endFrame, int frameNumber) {
            if (startFrame == -1 || endFrame == -1) {
                return true;
            }
            if (startFrame <= endFrame) {
                if (frameNumber < startFrame || frameNumber > endFrame) {
                    return true;
                }
            } else if (frameNumber < startFrame && frameNumber > endFrame) {
                return true;
            }
            return false;
        }

        private Companion() {
        }
    }
}
