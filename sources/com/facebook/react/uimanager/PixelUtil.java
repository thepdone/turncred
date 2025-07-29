package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: PixelUtil.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\bH\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\bH\u0007J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007J\n\u0010\u000b\u001a\u00020\u0004*\u00020\bJ\n\u0010\u000b\u001a\u00020\u0004*\u00020\u0004J\n\u0010\f\u001a\u00020\u0004*\u00020\bJ\n\u0010\f\u001a\u00020\u0004*\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/PixelUtil;", "", "()V", "getDisplayMetricDensity", "", "toDIPFromPixel", "value", "toPixelFromDIP", "", "toPixelFromSP", "maxFontScale", "dpToPx", "pxToDp", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PixelUtil {
    public static final PixelUtil INSTANCE = new PixelUtil();

    @JvmStatic
    public static final float toPixelFromSP(float f) {
        return toPixelFromSP$default(f, 0.0f, 2, null);
    }

    private PixelUtil() {
    }

    @JvmStatic
    public static final float toPixelFromDIP(float value) {
        if (Float.isNaN(value)) {
            return Float.NaN;
        }
        return TypedValue.applyDimension(1, value, DisplayMetricsHolder.getWindowDisplayMetrics());
    }

    @JvmStatic
    public static final float toPixelFromDIP(double value) {
        return toPixelFromDIP((float) value);
    }

    public static /* synthetic */ float toPixelFromSP$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        return toPixelFromSP(f, f2);
    }

    @JvmStatic
    public static final float toPixelFromSP(float value, float maxFontScale) {
        if (Float.isNaN(value)) {
            return Float.NaN;
        }
        DisplayMetrics windowDisplayMetrics = DisplayMetricsHolder.getWindowDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(2, value, windowDisplayMetrics);
        return maxFontScale >= 1.0f ? Math.min(fApplyDimension, value * windowDisplayMetrics.density * maxFontScale) : fApplyDimension;
    }

    @JvmStatic
    public static final float toPixelFromSP(double value) {
        return toPixelFromSP$default((float) value, 0.0f, 2, null);
    }

    @JvmStatic
    public static final float toDIPFromPixel(float value) {
        if (Float.isNaN(value)) {
            return Float.NaN;
        }
        return value / DisplayMetricsHolder.getWindowDisplayMetrics().density;
    }

    @JvmStatic
    public static final float getDisplayMetricDensity() {
        return DisplayMetricsHolder.getWindowDisplayMetrics().density;
    }

    public final float dpToPx(float f) {
        return toPixelFromDIP(f);
    }

    public final float dpToPx(double d) {
        return toPixelFromDIP(d);
    }

    public final float pxToDp(float f) {
        return toDIPFromPixel(f);
    }

    public final float pxToDp(double d) {
        return toDIPFromPixel((float) d);
    }
}
