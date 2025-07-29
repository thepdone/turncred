package com.facebook.react.uimanager;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilterHelper.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J2\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0014\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0015\u0010,\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b-¨\u0006."}, d2 = {"Lcom/facebook/react/uimanager/FilterHelper;", "", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "sigma", "", "chainedEffects", "createBrightnessColorMatrix", "Landroid/graphics/ColorMatrix;", "amount", "createBrightnessEffect", "createColorMatrixEffect", "colorMatrix", "createContrastColorMatrix", "createContrastEffect", "createDropShadowEffect", "offsetX", "offsetY", "blurRadius", ViewProps.COLOR, "", "createGrayscaleColorMatrix", "createGrayscaleEffect", "createHueRotateColorMatrix", "createHueRotateEffect", "createInvertColorMatrix", "createInvertEffect", "createOpacityColorMatrix", "createOpacityEffect", "createSaturateColorMatrix", "createSaturateEffect", "createSepiaColorMatrix", "createSepiaEffect", "isOnlyColorMatrixFilters", "", "filters", "Lcom/facebook/react/bridge/ReadableArray;", "parseAndCreateDropShadowEffect", "filterValues", "Lcom/facebook/react/bridge/ReadableMap;", "parseColorMatrixFilters", "Landroid/graphics/ColorMatrixColorFilter;", "parseFilters", "sigmaToRadius", "sigmaToRadius$ReactAndroid_release", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FilterHelper {
    public static final FilterHelper INSTANCE = new FilterHelper();

    private FilterHelper() {
    }

    @JvmStatic
    public static final RenderEffect parseFilters(ReadableArray filters) {
        RenderEffect renderEffectCreateSaturateEffect = null;
        if (filters == null) {
            return null;
        }
        int size = filters.size();
        for (int i = 0; i < size; i++) {
            Map.Entry<String, Object> next = filters.getMap(i).getEntryIterator().next();
            String key = next.getKey();
            switch (key.hashCode()) {
                case -2114203985:
                    if (!key.equals("saturate")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper = INSTANCE;
                    Object value = next.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper.createSaturateEffect((float) ((Double) value).doubleValue(), renderEffectCreateSaturateEffect);
                case -1267206133:
                    if (!key.equals(ViewProps.OPACITY)) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper2 = INSTANCE;
                    Object value2 = next.getValue();
                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper2.createOpacityEffect((float) ((Double) value2).doubleValue(), renderEffectCreateSaturateEffect);
                case -1183703082:
                    if (!key.equals("invert")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper3 = INSTANCE;
                    Object value3 = next.getValue();
                    Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper3.createInvertEffect((float) ((Double) value3).doubleValue(), renderEffectCreateSaturateEffect);
                case -905411385:
                    if (!key.equals("grayscale")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper4 = INSTANCE;
                    Object value4 = next.getValue();
                    Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper4.createGrayscaleEffect((float) ((Double) value4).doubleValue(), renderEffectCreateSaturateEffect);
                case -566947070:
                    if (!key.equals("contrast")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper5 = INSTANCE;
                    Object value5 = next.getValue();
                    Intrinsics.checkNotNull(value5, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper5.createContrastEffect((float) ((Double) value5).doubleValue(), renderEffectCreateSaturateEffect);
                case 3027047:
                    if (!key.equals("blur")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper6 = INSTANCE;
                    Object value6 = next.getValue();
                    Intrinsics.checkNotNull(value6, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper6.createBlurEffect((float) ((Double) value6).doubleValue(), renderEffectCreateSaturateEffect);
                case 109324790:
                    if (!key.equals("sepia")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper7 = INSTANCE;
                    Object value7 = next.getValue();
                    Intrinsics.checkNotNull(value7, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper7.createSepiaEffect((float) ((Double) value7).doubleValue(), renderEffectCreateSaturateEffect);
                case 648162385:
                    if (!key.equals("brightness")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper8 = INSTANCE;
                    Object value8 = next.getValue();
                    Intrinsics.checkNotNull(value8, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper8.createBrightnessEffect((float) ((Double) value8).doubleValue(), renderEffectCreateSaturateEffect);
                case 650888307:
                    if (!key.equals("hueRotate")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper9 = INSTANCE;
                    Object value9 = next.getValue();
                    Intrinsics.checkNotNull(value9, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper9.createHueRotateEffect((float) ((Double) value9).doubleValue(), renderEffectCreateSaturateEffect);
                case 906978543:
                    if (!key.equals("dropShadow")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper10 = INSTANCE;
                    Object value10 = next.getValue();
                    Intrinsics.checkNotNull(value10, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
                    renderEffectCreateSaturateEffect = filterHelper10.parseAndCreateDropShadowEffect((ReadableMap) value10, renderEffectCreateSaturateEffect);
                default:
                    throw new IllegalArgumentException("Invalid filter name: " + key);
            }
        }
        return renderEffectCreateSaturateEffect;
    }

    @JvmStatic
    public static final ColorMatrixColorFilter parseColorMatrixFilters(ReadableArray filters) {
        ColorMatrix colorMatrixCreateSaturateColorMatrix;
        if (filters == null) {
            return null;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        int size = filters.size();
        for (int i = 0; i < size; i++) {
            Map.Entry<String, Object> next = filters.getMap(i).getEntryIterator().next();
            String key = next.getKey();
            Object value = next.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
            float fDoubleValue = (float) ((Double) value).doubleValue();
            switch (key.hashCode()) {
                case -2114203985:
                    if (!key.equals("saturate")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createSaturateColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                case -1267206133:
                    if (!key.equals(ViewProps.OPACITY)) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createOpacityColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                case -1183703082:
                    if (!key.equals("invert")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createInvertColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                case -905411385:
                    if (!key.equals("grayscale")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createGrayscaleColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                case -566947070:
                    if (!key.equals("contrast")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createContrastColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                case 109324790:
                    if (!key.equals("sepia")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createSepiaColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                case 648162385:
                    if (!key.equals("brightness")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createBrightnessColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                case 650888307:
                    if (!key.equals("hueRotate")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createHueRotateColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                default:
                    throw new IllegalArgumentException("Invalid color matrix filter: " + key);
            }
        }
        return new ColorMatrixColorFilter(colorMatrix);
    }

    @JvmStatic
    public static final boolean isOnlyColorMatrixFilters(ReadableArray filters) {
        if (filters == null || filters.size() == 0) {
            return false;
        }
        int size = filters.size();
        for (int i = 0; i < size; i++) {
            String key = filters.getMap(i).getEntryIterator().next().getKey();
            if (Intrinsics.areEqual(key, "blur") || Intrinsics.areEqual(key, "dropShadow")) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ RenderEffect createBlurEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createBlurEffect(f, renderEffect);
    }

    public final RenderEffect createBlurEffect(float sigma, RenderEffect chainedEffects) {
        if (sigma <= 0.5d) {
            return null;
        }
        float fSigmaToRadius$ReactAndroid_release = sigmaToRadius$ReactAndroid_release(sigma);
        if (chainedEffects == null) {
            return RenderEffect.createBlurEffect(fSigmaToRadius$ReactAndroid_release, fSigmaToRadius$ReactAndroid_release, Shader.TileMode.DECAL);
        }
        return RenderEffect.createBlurEffect(fSigmaToRadius$ReactAndroid_release, fSigmaToRadius$ReactAndroid_release, chainedEffects, Shader.TileMode.DECAL);
    }

    public static /* synthetic */ RenderEffect createBrightnessEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createBrightnessEffect(f, renderEffect);
    }

    public final RenderEffect createBrightnessEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createBrightnessColorMatrix(amount), chainedEffects);
    }

    private final ColorMatrix createBrightnessColorMatrix(float amount) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(amount, amount, amount, 1.0f);
        return colorMatrix;
    }

    public static /* synthetic */ RenderEffect createOpacityEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createOpacityEffect(f, renderEffect);
    }

    public final RenderEffect createOpacityEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createOpacityColorMatrix(amount), chainedEffects);
    }

    public static /* synthetic */ RenderEffect createDropShadowEffect$default(FilterHelper filterHelper, float f, float f2, float f3, int i, RenderEffect renderEffect, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            renderEffect = null;
        }
        return filterHelper.createDropShadowEffect(f, f2, f3, i, renderEffect);
    }

    public final RenderEffect createDropShadowEffect(float offsetX, float offsetY, float blurRadius, int color, RenderEffect chainedEffects) {
        RenderEffect renderEffectCreateOffsetEffect;
        RenderEffect renderEffectCreateOffsetEffect2;
        if (chainedEffects == null) {
            renderEffectCreateOffsetEffect2 = RenderEffect.createOffsetEffect(0.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect2, "createOffsetEffect(...)");
            renderEffectCreateOffsetEffect = RenderEffect.createOffsetEffect(offsetX, offsetY);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect, "createOffsetEffect(...)");
        } else {
            RenderEffect renderEffectCreateOffsetEffect3 = RenderEffect.createOffsetEffect(0.0f, 0.0f, chainedEffects);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect3, "createOffsetEffect(...)");
            renderEffectCreateOffsetEffect = RenderEffect.createOffsetEffect(offsetX, offsetY, chainedEffects);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect, "createOffsetEffect(...)");
            renderEffectCreateOffsetEffect2 = renderEffectCreateOffsetEffect3;
        }
        RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(color, BlendMode.SRC_IN), renderEffectCreateOffsetEffect);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect, "createColorFilterEffect(...)");
        RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(blurRadius, blurRadius, renderEffectCreateColorFilterEffect, Shader.TileMode.DECAL);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect, "createBlurEffect(...)");
        RenderEffect renderEffectCreateBlendModeEffect = RenderEffect.createBlendModeEffect(renderEffectCreateBlurEffect, renderEffectCreateOffsetEffect2, BlendMode.SRC_OVER);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlendModeEffect, "createBlendModeEffect(...)");
        return renderEffectCreateBlendModeEffect;
    }

    public static /* synthetic */ RenderEffect parseAndCreateDropShadowEffect$default(FilterHelper filterHelper, ReadableMap readableMap, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.parseAndCreateDropShadowEffect(readableMap, renderEffect);
    }

    public final RenderEffect parseAndCreateDropShadowEffect(ReadableMap filterValues, RenderEffect chainedEffects) {
        Intrinsics.checkNotNullParameter(filterValues, "filterValues");
        return createDropShadowEffect(PixelUtil.INSTANCE.dpToPx(filterValues.getDouble("offsetX")), PixelUtil.INSTANCE.dpToPx(filterValues.getDouble("offsetY")), filterValues.hasKey("standardDeviation") ? sigmaToRadius$ReactAndroid_release((float) filterValues.getDouble("standardDeviation")) : 0.0f, filterValues.hasKey(ViewProps.COLOR) ? filterValues.getInt(ViewProps.COLOR) : ViewCompat.MEASURED_STATE_MASK, chainedEffects);
    }

    public final ColorMatrix createOpacityColorMatrix(float amount) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.0f, 1.0f, 1.0f, amount);
        return colorMatrix;
    }

    public static /* synthetic */ RenderEffect createContrastEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createContrastEffect(f, renderEffect);
    }

    public final RenderEffect createContrastEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createContrastColorMatrix(amount), chainedEffects);
    }

    private final ColorMatrix createContrastColorMatrix(float amount) {
        float f = 255 * ((-(amount / 2.0f)) + 0.5f);
        return new ColorMatrix(new float[]{amount, 0.0f, 0.0f, 0.0f, f, 0.0f, amount, 0.0f, 0.0f, f, 0.0f, 0.0f, amount, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static /* synthetic */ RenderEffect createGrayscaleEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createGrayscaleEffect(f, renderEffect);
    }

    public final RenderEffect createGrayscaleEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createGrayscaleColorMatrix(amount), chainedEffects);
    }

    private final ColorMatrix createGrayscaleColorMatrix(float amount) {
        float f = 1 - amount;
        float f2 = 0.7152f - (f * 0.7152f);
        float f3 = 0.0722f - (f * 0.0722f);
        float f4 = 0.2126f - (f * 0.2126f);
        return new ColorMatrix(new float[]{(0.7874f * f) + 0.2126f, f2, f3, 0.0f, 0.0f, f4, (0.2848f * f) + 0.7152f, f3, 0.0f, 0.0f, f4, f2, (f * 0.9278f) + 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static /* synthetic */ RenderEffect createSepiaEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createSepiaEffect(f, renderEffect);
    }

    public final RenderEffect createSepiaEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createSepiaColorMatrix(amount), chainedEffects);
    }

    private final ColorMatrix createSepiaColorMatrix(float amount) {
        float f = 1 - amount;
        return new ColorMatrix(new float[]{(0.607f * f) + 0.393f, 0.769f - (f * 0.769f), 0.189f - (f * 0.189f), 0.0f, 0.0f, 0.349f - (f * 0.349f), (0.314f * f) + 0.686f, 0.168f - (f * 0.168f), 0.0f, 0.0f, 0.272f - (f * 0.272f), 0.534f - (f * 0.534f), (f * 0.869f) + 0.131f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static /* synthetic */ RenderEffect createSaturateEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createSaturateEffect(f, renderEffect);
    }

    public final RenderEffect createSaturateEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createSaturateColorMatrix(amount), chainedEffects);
    }

    private final ColorMatrix createSaturateColorMatrix(float amount) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(amount);
        return colorMatrix;
    }

    public static /* synthetic */ RenderEffect createHueRotateEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createHueRotateEffect(f, renderEffect);
    }

    public final RenderEffect createHueRotateEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createHueRotateColorMatrix(amount), chainedEffects);
    }

    private final ColorMatrix createHueRotateColorMatrix(float amount) {
        double radians = Math.toRadians(amount);
        float fCos = (float) Math.cos(radians);
        float fSin = (float) Math.sin(radians);
        float f = 0.715f - (fCos * 0.715f);
        float f2 = fSin * 0.715f;
        float f3 = 0.072f - (fCos * 0.072f);
        float f4 = 0.213f - (fCos * 0.213f);
        return new ColorMatrix(new float[]{((fCos * 0.787f) + 0.213f) - (fSin * 0.213f), f - f2, (fSin * 0.928f) + f3, 0.0f, 0.0f, (0.143f * fSin) + f4, (0.285f * fCos) + 0.715f + (0.14f * fSin), f3 - (0.283f * fSin), 0.0f, 0.0f, f4 - (0.787f * fSin), f + f2, (fCos * 0.928f) + 0.072f + (fSin * 0.072f), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static /* synthetic */ RenderEffect createInvertEffect$default(FilterHelper filterHelper, float f, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createInvertEffect(f, renderEffect);
    }

    public final RenderEffect createInvertEffect(float amount, RenderEffect chainedEffects) {
        return createColorMatrixEffect(createInvertColorMatrix(amount), chainedEffects);
    }

    private final ColorMatrix createInvertColorMatrix(float amount) {
        float f = 1 - (2 * amount);
        float f2 = amount * 255;
        return new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, f2, 0.0f, f, 0.0f, 0.0f, f2, 0.0f, 0.0f, f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    static /* synthetic */ RenderEffect createColorMatrixEffect$default(FilterHelper filterHelper, ColorMatrix colorMatrix, RenderEffect renderEffect, int i, Object obj) {
        if ((i & 2) != 0) {
            renderEffect = null;
        }
        return filterHelper.createColorMatrixEffect(colorMatrix, renderEffect);
    }

    private final RenderEffect createColorMatrixEffect(ColorMatrix colorMatrix, RenderEffect chainedEffects) {
        if (chainedEffects == null) {
            RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix));
            Intrinsics.checkNotNull(renderEffectCreateColorFilterEffect);
            return renderEffectCreateColorFilterEffect;
        }
        RenderEffect renderEffectCreateColorFilterEffect2 = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix), chainedEffects);
        Intrinsics.checkNotNull(renderEffectCreateColorFilterEffect2);
        return renderEffectCreateColorFilterEffect2;
    }

    public final float sigmaToRadius$ReactAndroid_release(float sigma) {
        return (PixelUtil.toPixelFromDIP(sigma) - 0.5f) / 0.57735f;
    }
}
