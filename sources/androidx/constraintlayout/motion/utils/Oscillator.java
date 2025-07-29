package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void addPoint(double d, float f) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d;
        this.mPeriod[iBinarySearch] = f;
        this.mNormalized = false;
    }

    public void normalize() {
        double d = 0.0d;
        int i = 0;
        while (true) {
            if (i >= this.mPeriod.length) {
                break;
            }
            d += r7[i];
            i++;
        }
        double d2 = 0.0d;
        int i2 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i2 >= fArr.length) {
                break;
            }
            int i3 = i2 - 1;
            float f = (fArr[i3] + fArr[i2]) / 2.0f;
            double[] dArr = this.mPosition;
            d2 += (dArr[i2] - dArr[i3]) * f;
            i2++;
        }
        int i4 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i4 >= fArr2.length) {
                break;
            }
            fArr2[i4] = (float) (fArr2[i4] * (d / d2));
            i4++;
        }
        this.mArea[0] = 0.0d;
        int i5 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i5 < fArr3.length) {
                int i6 = i5 - 1;
                float f2 = (fArr3[i6] + fArr3[i5]) / 2.0f;
                double[] dArr2 = this.mPosition;
                double d3 = dArr2[i5] - dArr2[i6];
                double[] dArr3 = this.mArea;
                dArr3[i5] = dArr3[i6] + (d3 * f2);
                i5++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    double getP(double d) {
        if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int i = -iBinarySearch;
        int i2 = i - 1;
        float[] fArr = this.mPeriod;
        float f = fArr[i2];
        int i3 = i - 2;
        float f2 = fArr[i3];
        double[] dArr = this.mPosition;
        double d2 = dArr[i2];
        double d3 = dArr[i3];
        double d4 = (f - f2) / (d2 - d3);
        return this.mArea[i3] + ((f2 - (d4 * d3)) * (d - d3)) + ((d4 * ((d * d) - (d3 * d3))) / 2.0d);
    }

    public double getValue(double d) {
        double dAbs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d) % 1.0d));
            case 2:
                dAbs = Math.abs((((getP(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((getP(d) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * getP(d));
            case 6:
                double dAbs2 = 1.0d - Math.abs(((getP(d) * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            default:
                return Math.sin(this.PI2 * getP(d));
        }
        return 1.0d - dAbs;
    }

    double getDP(double d) {
        if (d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch > 0 || iBinarySearch == 0) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int i = -iBinarySearch;
        int i2 = i - 1;
        float[] fArr = this.mPeriod;
        float f = fArr[i2];
        int i3 = i - 2;
        float f2 = fArr[i3];
        double[] dArr = this.mPosition;
        double d2 = dArr[i2];
        double d3 = dArr[i3];
        double d4 = (f - f2) / (d2 - d3);
        return (d * d4) + (f2 - (d4 * d3));
    }

    public double getSlope(double d) {
        double dp;
        double dSignum;
        double dp2;
        double dp3;
        double dSin;
        switch (this.mType) {
            case 1:
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            case 2:
                dp = getDP(d) * 4.0d;
                dSignum = Math.signum((((getP(d) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return dp * dSignum;
            case 3:
                dp2 = getDP(d);
                return dp2 * 2.0d;
            case 4:
                dp2 = -getDP(d);
                return dp2 * 2.0d;
            case 5:
                dp3 = (-this.PI2) * getDP(d);
                dSin = Math.sin(this.PI2 * getP(d));
                return dp3 * dSin;
            case 6:
                dp = getDP(d) * 4.0d;
                dSignum = (((getP(d) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return dp * dSignum;
            default:
                dp3 = this.PI2 * getDP(d);
                dSin = Math.cos(this.PI2 * getP(d));
                return dp3 * dSin;
        }
    }
}
