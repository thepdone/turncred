package io.sentry.util;

import androidx.camera.video.AudioStats;

/* loaded from: classes5.dex */
public final class SampleRateUtils {
    public static boolean isValidSampleRate(Double d) {
        return isValidRate(d, true);
    }

    public static boolean isValidTracesSampleRate(Double d) {
        return isValidTracesSampleRate(d, true);
    }

    public static boolean isValidTracesSampleRate(Double d, boolean z) {
        return isValidRate(d, z);
    }

    public static boolean isValidProfilesSampleRate(Double d) {
        return isValidRate(d, true);
    }

    private static boolean isValidRate(Double d, boolean z) {
        return d == null ? z : !d.isNaN() && d.doubleValue() >= AudioStats.AUDIO_AMPLITUDE_NONE && d.doubleValue() <= 1.0d;
    }
}
