package androidx.camera.video.internal.encoder;

import android.util.Range;

/* loaded from: classes.dex */
public interface VideoEncoderInfo extends EncoderInfo {
    boolean canSwapWidthHeight();

    int getHeightAlignment();

    Range<Integer> getSupportedBitrateRange();

    Range<Integer> getSupportedHeights();

    Range<Integer> getSupportedHeightsFor(int i);

    Range<Integer> getSupportedWidths();

    Range<Integer> getSupportedWidthsFor(int i);

    int getWidthAlignment();

    boolean isSizeSupported(int i, int i2);

    default boolean isSizeSupportedAllowSwapping(int i, int i2) {
        return isSizeSupported(i, i2) || (canSwapWidthHeight() && isSizeSupported(i2, i));
    }
}
