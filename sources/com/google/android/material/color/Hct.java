package com.google.android.material.color;

import androidx.camera.video.AudioStats;

/* loaded from: classes3.dex */
final class Hct {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DE_MAX_ERROR = 1.0E-9f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private float chroma;
    private float hue;
    private float tone;

    public static Hct from(float f, float f2, float f3) {
        return new Hct(f, f2, f3);
    }

    public static Hct fromInt(int i) {
        Cam16 cam16FromInt = Cam16.fromInt(i);
        return new Hct(cam16FromInt.getHue(), cam16FromInt.getChroma(), ColorUtils.lstarFromInt(i));
    }

    private Hct(float f, float f2, float f3) {
        setInternalState(gamutMap(f, f2, f3));
    }

    public float getHue() {
        return this.hue;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getTone() {
        return this.tone;
    }

    public int toInt() {
        return gamutMap(this.hue, this.chroma, this.tone);
    }

    public void setHue(float f) {
        setInternalState(gamutMap(MathUtils.sanitizeDegrees(f), this.chroma, this.tone));
    }

    public void setChroma(float f) {
        setInternalState(gamutMap(this.hue, f, this.tone));
    }

    public void setTone(float f) {
        setInternalState(gamutMap(this.hue, this.chroma, f));
    }

    private void setInternalState(int i) {
        Cam16 cam16FromInt = Cam16.fromInt(i);
        float fLstarFromInt = ColorUtils.lstarFromInt(i);
        this.hue = cam16FromInt.getHue();
        this.chroma = cam16FromInt.getChroma();
        this.tone = fLstarFromInt;
    }

    private static int gamutMap(float f, float f2, float f3) {
        return gamutMapInViewingConditions(f, f2, f3, ViewingConditions.DEFAULT);
    }

    static int gamutMapInViewingConditions(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (f2 < 1.0d || Math.round(f3) <= AudioStats.AUDIO_AMPLITUDE_NONE || Math.round(f3) >= 100.0d) {
            return ColorUtils.intFromLstar(f3);
        }
        float fSanitizeDegrees = MathUtils.sanitizeDegrees(f);
        Cam16 cam16 = null;
        boolean z = true;
        float f4 = 0.0f;
        float f5 = f2;
        while (Math.abs(f4 - f2) >= CHROMA_SEARCH_ENDPOINT) {
            Cam16 cam16FindCamByJ = findCamByJ(fSanitizeDegrees, f5, f3);
            if (!z) {
                if (cam16FindCamByJ == null) {
                    f2 = f5;
                } else {
                    f4 = f5;
                    cam16 = cam16FindCamByJ;
                }
                f5 = ((f2 - f4) / 2.0f) + f4;
            } else {
                if (cam16FindCamByJ != null) {
                    return cam16FindCamByJ.viewed(viewingConditions);
                }
                f5 = ((f2 - f4) / 2.0f) + f4;
                z = false;
            }
        }
        if (cam16 == null) {
            return ColorUtils.intFromLstar(f3);
        }
        return cam16.viewed(viewingConditions);
    }

    private static Cam16 findCamByJ(float f, float f2, float f3) {
        float f4 = 100.0f;
        float f5 = 1000.0f;
        float f6 = 0.0f;
        Cam16 cam16 = null;
        float f7 = 1000.0f;
        while (Math.abs(f6 - f4) > 0.01f) {
            float f8 = ((f4 - f6) / 2.0f) + f6;
            int i = Cam16.fromJch(f8, f2, f).getInt();
            float fLstarFromInt = ColorUtils.lstarFromInt(i);
            float fAbs = Math.abs(f3 - fLstarFromInt);
            if (fAbs < 0.2f) {
                Cam16 cam16FromInt = Cam16.fromInt(i);
                float fDistance = cam16FromInt.distance(Cam16.fromJch(cam16FromInt.getJ(), cam16FromInt.getChroma(), f));
                if (fDistance <= 1.0f && fDistance <= f5) {
                    cam16 = cam16FromInt;
                    f7 = fAbs;
                    f5 = fDistance;
                }
            }
            if (f7 == 0.0f && f5 < DE_MAX_ERROR) {
                break;
            }
            if (fLstarFromInt < f3) {
                f6 = f8;
            } else {
                f4 = f8;
            }
        }
        return cam16;
    }
}
