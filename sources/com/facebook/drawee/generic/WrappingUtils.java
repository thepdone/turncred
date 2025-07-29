package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class WrappingUtils {
    private static final String TAG = "WrappingUtils";
    private static final Drawable sEmptyDrawable = new ColorDrawable(0);

    @Nullable
    static Drawable maybeWrapWithScaleType(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        return maybeWrapWithScaleType(drawable, scaleType, null);
    }

    @Nullable
    static Drawable maybeWrapWithScaleType(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithScaleType");
        }
        if (drawable == null || scaleType == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return drawable;
        }
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scaleType);
        if (pointF != null) {
            scaleTypeDrawable.setFocusPoint(pointF);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return scaleTypeDrawable;
    }

    @Nullable
    static Drawable maybeWrapWithMatrix(@Nullable Drawable drawable, @Nullable Matrix matrix) {
        return (drawable == null || matrix == null) ? drawable : new MatrixDrawable(drawable, matrix);
    }

    static ScaleTypeDrawable wrapChildWithScaleType(DrawableParent drawableParent, ScalingUtils.ScaleType scaleType) {
        Drawable drawableMaybeWrapWithScaleType = maybeWrapWithScaleType(drawableParent.setDrawable(sEmptyDrawable), scaleType);
        drawableParent.setDrawable(drawableMaybeWrapWithScaleType);
        Preconditions.checkNotNull(drawableMaybeWrapWithScaleType, "Parent has no child drawable!");
        return (ScaleTypeDrawable) drawableMaybeWrapWithScaleType;
    }

    static void updateOverlayColorRounding(DrawableParent drawableParent, @Nullable RoundingParams roundingParams) {
        Drawable drawable = drawableParent.getDrawable();
        if (roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (drawable instanceof RoundedCornersDrawable) {
                RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable;
                applyRoundingParams(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
                return;
            }
            drawableParent.setDrawable(maybeWrapWithRoundedOverlayColor(drawableParent.setDrawable(sEmptyDrawable), roundingParams));
            return;
        }
        if (drawable instanceof RoundedCornersDrawable) {
            Drawable drawable2 = sEmptyDrawable;
            drawableParent.setDrawable(((RoundedCornersDrawable) drawable).setCurrent(drawable2));
            drawable2.setCallback(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void updateLeafRounding(DrawableParent drawableParent, @Nullable RoundingParams roundingParams, Resources resources) {
        DrawableParent drawableParentFindDrawableParentForLeaf = findDrawableParentForLeaf(drawableParent);
        Drawable drawable = drawableParentFindDrawableParentForLeaf.getDrawable();
        if (roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (drawable instanceof Rounded) {
                applyRoundingParams((Rounded) drawable, roundingParams);
                return;
            } else {
                if (drawable != 0) {
                    drawableParentFindDrawableParentForLeaf.setDrawable(sEmptyDrawable);
                    drawableParentFindDrawableParentForLeaf.setDrawable(applyLeafRounding(drawable, roundingParams, resources));
                    return;
                }
                return;
            }
        }
        if (drawable instanceof Rounded) {
            resetRoundingParams((Rounded) drawable);
        }
    }

    static Drawable maybeWrapWithRoundedOverlayColor(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithRoundedOverlayColor");
            }
            if (drawable != null && roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
                RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                applyRoundingParams(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
                return roundedCornersDrawable;
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return drawable;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    static Drawable maybeApplyLeafRounding(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams, Resources resources) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("WrappingUtils#maybeApplyLeafRounding");
            }
            if (drawable != null && roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
                if (drawable instanceof ForwardingDrawable) {
                    DrawableParent drawableParentFindDrawableParentForLeaf = findDrawableParentForLeaf((ForwardingDrawable) drawable);
                    drawableParentFindDrawableParentForLeaf.setDrawable(applyLeafRounding(drawableParentFindDrawableParentForLeaf.setDrawable(sEmptyDrawable), roundingParams, resources));
                    return drawable;
                }
                Drawable drawableApplyLeafRounding = applyLeafRounding(drawable, roundingParams, resources);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return drawableApplyLeafRounding;
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return drawable;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private static Drawable applyLeafRounding(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            RoundedBitmapDrawable roundedBitmapDrawable = new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint(), roundingParams.getRepeatEdgePixels());
            applyRoundingParams(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        }
        if (drawable instanceof NinePatchDrawable) {
            RoundedNinePatchDrawable roundedNinePatchDrawable = new RoundedNinePatchDrawable((NinePatchDrawable) drawable);
            applyRoundingParams(roundedNinePatchDrawable, roundingParams);
            return roundedNinePatchDrawable;
        }
        if (drawable instanceof ColorDrawable) {
            RoundedColorDrawable roundedColorDrawableFromColorDrawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable) drawable);
            applyRoundingParams(roundedColorDrawableFromColorDrawable, roundingParams);
            return roundedColorDrawableFromColorDrawable;
        }
        FLog.w(TAG, "Don't know how to round that drawable: %s", drawable);
        return drawable;
    }

    static void applyRoundingParams(Rounded rounded, RoundingParams roundingParams) {
        rounded.setCircle(roundingParams.getRoundAsCircle());
        rounded.setRadii(roundingParams.getCornersRadii());
        rounded.setBorder(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
        rounded.setPadding(roundingParams.getPadding());
        rounded.setScaleDownInsideBorders(roundingParams.getScaleDownInsideBorders());
        rounded.setPaintFilterBitmap(roundingParams.getPaintFilterBitmap());
        rounded.setRepeatEdgePixels(roundingParams.getRepeatEdgePixels());
    }

    static void resetRoundingParams(Rounded rounded) {
        rounded.setCircle(false);
        rounded.setRadius(0.0f);
        rounded.setBorder(0, 0.0f);
        rounded.setPadding(0.0f);
        rounded.setScaleDownInsideBorders(false);
        rounded.setPaintFilterBitmap(false);
        rounded.setRepeatEdgePixels(RoundedBitmapDrawable.getDefaultRepeatEdgePixels());
    }

    static DrawableParent findDrawableParentForLeaf(DrawableParent drawableParent) {
        while (true) {
            Object drawable = drawableParent.getDrawable();
            if (drawable == drawableParent || !(drawable instanceof DrawableParent)) {
                break;
            }
            drawableParent = (DrawableParent) drawable;
        }
        return drawableParent;
    }
}
