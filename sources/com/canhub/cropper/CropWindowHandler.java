package com.canhub.cropper;

import android.graphics.RectF;
import com.canhub.cropper.CropImageView;
import com.canhub.cropper.CropWindowMoveHandler;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: CropWindowHandler.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J0\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0017J\"\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0006\u0010&\u001a\u00020\u0004J*\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0017H\u0002J*\u0010(\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0017H\u0002J*\u0010)\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0006\u0010*\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020\u0007J8\u0010,\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0002J0\u00101\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J8\u00104\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J8\u00107\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J&\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007J\u000e\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020BJ\u0016\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ\u0016\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020EJ\u000e\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020\u0004J\u0006\u0010L\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/canhub/cropper/CropWindowHandler;", "", "()V", "mEdges", "Landroid/graphics/RectF;", "mGetEdges", "mMaxCropResultHeight", "", "mMaxCropResultWidth", "mMaxCropWindowHeight", "mMaxCropWindowWidth", "mMinCropResultHeight", "mMinCropResultWidth", "mMinCropWindowHeight", "mMinCropWindowWidth", "mScaleFactorHeight", "mScaleFactorWidth", "distance", "x1", "y1", "x2", "y2", "focusCenter", "", "getMaxCropHeight", "getMaxCropWidth", "getMinCropHeight", "getMinCropWidth", "getMoveHandler", "Lcom/canhub/cropper/CropWindowMoveHandler;", "x", "y", "targetRadius", "cropShape", "Lcom/canhub/cropper/CropImageView$CropShape;", "isCenterMoveEnabled", "getOvalPressedMoveType", "Lcom/canhub/cropper/CropWindowMoveHandler$Type;", "getRect", "getRectangleHorizontalOnlyPressedMoveType", "getRectanglePressedMoveType", "getRectangleVerticalOnlyPressedMoveType", "getScaleFactorHeight", "getScaleFactorWidth", "isInCenterTargetZone", "left", "top", ViewProps.RIGHT, ViewProps.BOTTOM, "isInCornerTargetZone", "handleX", "handleY", "isInHorizontalTargetZone", "handleXStart", "handleXEnd", "isInVerticalTargetZone", "handleYStart", "handleYEnd", "setCropWindowLimits", "", ViewProps.MAX_WIDTH, ViewProps.MAX_HEIGHT, "scaleFactorWidth", "scaleFactorHeight", "setInitialAttributeValues", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/canhub/cropper/CropImageOptions;", "setMaxCropResultSize", "maxCropResultWidth", "", "maxCropResultHeight", "setMinCropResultSize", "minCropResultWidth", "minCropResultHeight", "setRect", "rect", "showGuidelines", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CropWindowHandler {
    private float mMaxCropResultHeight;
    private float mMaxCropResultWidth;
    private float mMaxCropWindowHeight;
    private float mMaxCropWindowWidth;
    private float mMinCropResultHeight;
    private float mMinCropResultWidth;
    private float mMinCropWindowHeight;
    private float mMinCropWindowWidth;
    private final RectF mEdges = new RectF();
    private final RectF mGetEdges = new RectF();
    private float mScaleFactorWidth = 1.0f;
    private float mScaleFactorHeight = 1.0f;

    /* compiled from: CropWindowHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CropImageView.CropShape.values().length];
            iArr[CropImageView.CropShape.RECTANGLE.ordinal()] = 1;
            iArr[CropImageView.CropShape.OVAL.ordinal()] = 2;
            iArr[CropImageView.CropShape.RECTANGLE_VERTICAL_ONLY.ordinal()] = 3;
            iArr[CropImageView.CropShape.RECTANGLE_HORIZONTAL_ONLY.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean isInCenterTargetZone(float x, float y, float left, float top, float right, float bottom) {
        return x > left && x < right && y > top && y < bottom;
    }

    public final RectF getRect() {
        this.mGetEdges.set(this.mEdges);
        return this.mGetEdges;
    }

    public final float getMinCropWidth() {
        return RangesKt.coerceAtLeast(this.mMinCropWindowWidth, this.mMinCropResultWidth / this.mScaleFactorWidth);
    }

    public final float getMinCropHeight() {
        return RangesKt.coerceAtLeast(this.mMinCropWindowHeight, this.mMinCropResultHeight / this.mScaleFactorHeight);
    }

    public final float getMaxCropWidth() {
        return RangesKt.coerceAtMost(this.mMaxCropWindowWidth, this.mMaxCropResultWidth / this.mScaleFactorWidth);
    }

    public final float getMaxCropHeight() {
        return RangesKt.coerceAtMost(this.mMaxCropWindowHeight, this.mMaxCropResultHeight / this.mScaleFactorHeight);
    }

    /* renamed from: getScaleFactorWidth, reason: from getter */
    public final float getMScaleFactorWidth() {
        return this.mScaleFactorWidth;
    }

    /* renamed from: getScaleFactorHeight, reason: from getter */
    public final float getMScaleFactorHeight() {
        return this.mScaleFactorHeight;
    }

    public final void setMinCropResultSize(int minCropResultWidth, int minCropResultHeight) {
        this.mMinCropResultWidth = minCropResultWidth;
        this.mMinCropResultHeight = minCropResultHeight;
    }

    public final void setMaxCropResultSize(int maxCropResultWidth, int maxCropResultHeight) {
        this.mMaxCropResultWidth = maxCropResultWidth;
        this.mMaxCropResultHeight = maxCropResultHeight;
    }

    public final void setCropWindowLimits(float maxWidth, float maxHeight, float scaleFactorWidth, float scaleFactorHeight) {
        this.mMaxCropWindowWidth = maxWidth;
        this.mMaxCropWindowHeight = maxHeight;
        this.mScaleFactorWidth = scaleFactorWidth;
        this.mScaleFactorHeight = scaleFactorHeight;
    }

    public final void setInitialAttributeValues(CropImageOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.mMinCropWindowWidth = options.minCropWindowWidth;
        this.mMinCropWindowHeight = options.minCropWindowHeight;
        this.mMinCropResultWidth = options.minCropResultWidth;
        this.mMinCropResultHeight = options.minCropResultHeight;
        this.mMaxCropResultWidth = options.maxCropResultWidth;
        this.mMaxCropResultHeight = options.maxCropResultHeight;
    }

    public final void setRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mEdges.set(rect);
    }

    public final boolean showGuidelines() {
        return this.mEdges.width() >= 100.0f && this.mEdges.height() >= 100.0f;
    }

    public final CropWindowMoveHandler getMoveHandler(float x, float y, float targetRadius, CropImageView.CropShape cropShape, boolean isCenterMoveEnabled) {
        CropWindowMoveHandler.Type rectanglePressedMoveType;
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        int i = WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
        if (i == 1) {
            rectanglePressedMoveType = getRectanglePressedMoveType(x, y, targetRadius, isCenterMoveEnabled);
        } else if (i == 2) {
            rectanglePressedMoveType = getOvalPressedMoveType(x, y, isCenterMoveEnabled);
        } else if (i == 3) {
            rectanglePressedMoveType = getRectangleVerticalOnlyPressedMoveType(x, y, targetRadius, isCenterMoveEnabled);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            rectanglePressedMoveType = getRectangleHorizontalOnlyPressedMoveType(x, y, targetRadius, isCenterMoveEnabled);
        }
        if (rectanglePressedMoveType != null) {
            return new CropWindowMoveHandler(rectanglePressedMoveType, this, x, y);
        }
        return null;
    }

    private final CropWindowMoveHandler.Type getRectanglePressedMoveType(float x, float y, float targetRadius, boolean isCenterMoveEnabled) {
        if (isInCornerTargetZone(x, y, this.mEdges.left, this.mEdges.top, targetRadius)) {
            return CropWindowMoveHandler.Type.TOP_LEFT;
        }
        if (isInCornerTargetZone(x, y, this.mEdges.right, this.mEdges.top, targetRadius)) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        }
        if (isInCornerTargetZone(x, y, this.mEdges.left, this.mEdges.bottom, targetRadius)) {
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        if (isInCornerTargetZone(x, y, this.mEdges.right, this.mEdges.bottom, targetRadius)) {
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        if (isCenterMoveEnabled && isInCenterTargetZone(x, y, this.mEdges.left, this.mEdges.top, this.mEdges.right, this.mEdges.bottom) && focusCenter()) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        if (isInHorizontalTargetZone(x, y, this.mEdges.left, this.mEdges.right, this.mEdges.top, targetRadius)) {
            return CropWindowMoveHandler.Type.TOP;
        }
        if (isInHorizontalTargetZone(x, y, this.mEdges.left, this.mEdges.right, this.mEdges.bottom, targetRadius)) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        if (isInVerticalTargetZone(x, y, this.mEdges.left, this.mEdges.top, this.mEdges.bottom, targetRadius)) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        if (isInVerticalTargetZone(x, y, this.mEdges.right, this.mEdges.top, this.mEdges.bottom, targetRadius)) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        if (isCenterMoveEnabled && isInCenterTargetZone(x, y, this.mEdges.left, this.mEdges.top, this.mEdges.right, this.mEdges.bottom) && !focusCenter()) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        return null;
    }

    private final CropWindowMoveHandler.Type getOvalPressedMoveType(float x, float y, boolean isCenterMoveEnabled) {
        float f = 6;
        float fWidth = this.mEdges.width() / f;
        float f2 = this.mEdges.left + fWidth;
        float f3 = 5;
        float f4 = this.mEdges.left + (fWidth * f3);
        float fHeight = this.mEdges.height() / f;
        float f5 = this.mEdges.top + fHeight;
        float f6 = this.mEdges.top + (f3 * fHeight);
        if (x < f2) {
            if (y < f5) {
                return CropWindowMoveHandler.Type.TOP_LEFT;
            }
            if (y < f6) {
                return CropWindowMoveHandler.Type.LEFT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        if (x >= f4) {
            if (y < f5) {
                return CropWindowMoveHandler.Type.TOP_RIGHT;
            }
            if (y < f6) {
                return CropWindowMoveHandler.Type.RIGHT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        if (y < f5) {
            return CropWindowMoveHandler.Type.TOP;
        }
        if (y >= f6) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        if (isCenterMoveEnabled) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        return null;
    }

    private final CropWindowMoveHandler.Type getRectangleVerticalOnlyPressedMoveType(float x, float y, float targetRadius, boolean isCenterMoveEnabled) {
        if (distance(x, y, this.mEdges.centerX(), this.mEdges.top) <= targetRadius) {
            return CropWindowMoveHandler.Type.TOP;
        }
        if (distance(x, y, this.mEdges.centerX(), this.mEdges.bottom) <= targetRadius) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        if (isCenterMoveEnabled && isInCenterTargetZone(x, y, this.mEdges.left, this.mEdges.top, this.mEdges.right, this.mEdges.bottom)) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        return null;
    }

    private final CropWindowMoveHandler.Type getRectangleHorizontalOnlyPressedMoveType(float x, float y, float targetRadius, boolean isCenterMoveEnabled) {
        if (distance(x, y, this.mEdges.left, this.mEdges.centerY()) <= targetRadius) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        if (distance(x, y, this.mEdges.right, this.mEdges.centerY()) <= targetRadius) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        if (isCenterMoveEnabled && isInCenterTargetZone(x, y, this.mEdges.left, this.mEdges.top, this.mEdges.right, this.mEdges.bottom)) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        return null;
    }

    private final boolean isInCornerTargetZone(float x, float y, float handleX, float handleY, float targetRadius) {
        return distance(x, y, handleX, handleY) <= targetRadius;
    }

    private final float distance(float x1, float y1, float x2, float y2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    private final boolean isInHorizontalTargetZone(float x, float y, float handleXStart, float handleXEnd, float handleY, float targetRadius) {
        return x > handleXStart && x < handleXEnd && Math.abs(y - handleY) <= targetRadius;
    }

    private final boolean isInVerticalTargetZone(float x, float y, float handleX, float handleYStart, float handleYEnd, float targetRadius) {
        return Math.abs(x - handleX) <= targetRadius && y > handleYStart && y < handleYEnd;
    }

    private final boolean focusCenter() {
        return !showGuidelines();
    }
}
