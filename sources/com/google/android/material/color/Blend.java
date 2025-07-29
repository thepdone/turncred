package com.google.android.material.color;

import androidx.camera.video.AudioStats;

/* loaded from: classes3.dex */
final class Blend {
    private static final float HARMONIZE_MAX_DEGREES = 15.0f;
    private static final float HARMONIZE_PERCENTAGE = 0.5f;

    private Blend() {
    }

    public static int harmonize(int i, int i2) {
        Hct hctFromInt = Hct.fromInt(i);
        Hct hctFromInt2 = Hct.fromInt(i2);
        return Hct.from(MathUtils.sanitizeDegrees(hctFromInt.getHue() + (Math.min(MathUtils.differenceDegrees(hctFromInt.getHue(), hctFromInt2.getHue()) * 0.5f, HARMONIZE_MAX_DEGREES) * rotationDirection(hctFromInt.getHue(), hctFromInt2.getHue()))), hctFromInt.getChroma(), hctFromInt.getTone()).toInt();
    }

    public static int blendHctHue(int i, int i2, float f) {
        return Hct.from(Cam16.fromInt(blendCam16Ucs(i, i2, f)).getHue(), Cam16.fromInt(i).getChroma(), ColorUtils.lstarFromInt(i)).toInt();
    }

    public static int blendCam16Ucs(int i, int i2, float f) {
        Cam16 cam16FromInt = Cam16.fromInt(i);
        Cam16 cam16FromInt2 = Cam16.fromInt(i2);
        float jStar = cam16FromInt.getJStar();
        float aStar = cam16FromInt.getAStar();
        float bStar = cam16FromInt.getBStar();
        return Cam16.fromUcs(jStar + ((cam16FromInt2.getJStar() - jStar) * f), aStar + ((cam16FromInt2.getAStar() - aStar) * f), bStar + ((cam16FromInt2.getBStar() - bStar) * f)).getInt();
    }

    private static float rotationDirection(float f, float f2) {
        float f3 = f2 - f;
        float f4 = f3 + 360.0f;
        float f5 = f3 - 360.0f;
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        float fAbs3 = Math.abs(f5);
        return (fAbs > fAbs2 || fAbs > fAbs3) ? (fAbs2 > fAbs || fAbs2 > fAbs3) ? ((double) f5) >= AudioStats.AUDIO_AMPLITUDE_NONE ? 1.0f : -1.0f : ((double) f4) >= AudioStats.AUDIO_AMPLITUDE_NONE ? 1.0f : -1.0f : ((double) f3) >= AudioStats.AUDIO_AMPLITUDE_NONE ? 1.0f : -1.0f;
    }
}
