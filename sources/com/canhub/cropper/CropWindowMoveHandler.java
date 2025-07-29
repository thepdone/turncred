package com.canhub.cropper;

import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CropWindowMoveHandler.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\u0018\u0000 82\u00020\u0001:\u000289B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJH\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J@\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J \u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0002JH\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J@\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0018\u0010+\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J \u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002JN\u0010-\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0007J@\u00101\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0007H\u0002JH\u00103\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J@\u00104\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J \u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/canhub/cropper/CropWindowMoveHandler;", "", "type", "Lcom/canhub/cropper/CropWindowMoveHandler$Type;", "cropWindowHandler", "Lcom/canhub/cropper/CropWindowHandler;", "touchX", "", "touchY", "(Lcom/canhub/cropper/CropWindowMoveHandler$Type;Lcom/canhub/cropper/CropWindowHandler;FF)V", "mMaxCropHeight", "mMaxCropWidth", "mMinCropHeight", "mMinCropWidth", "mTouchOffset", "Landroid/graphics/PointF;", "adjustBottom", "", "rect", "Landroid/graphics/RectF;", ViewProps.BOTTOM, "bounds", "viewHeight", "", "snapMargin", ViewProps.ASPECT_RATIO, "leftMoves", "", "rightMoves", "adjustBottomByAspectRatio", "adjustLeft", "left", "topMoves", "bottomMoves", "adjustLeftByAspectRatio", "adjustLeftRightByAspectRatio", "adjustRight", ViewProps.RIGHT, "viewWidth", "adjustRightByAspectRatio", "adjustTop", "top", "adjustTopBottomByAspectRatio", "adjustTopByAspectRatio", "calculateTouchOffset", "move", "x", "y", "fixedAspectRatio", "moveCenter", "snapRadius", "moveSizeWithFixedAspectRatio", "moveSizeWithFreeAspectRatio", "snapEdgesToBounds", "edges", ViewProps.MARGIN, "Companion", "Type", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CropWindowMoveHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float mMaxCropHeight;
    private final float mMaxCropWidth;
    private final float mMinCropHeight;
    private final float mMinCropWidth;
    private final PointF mTouchOffset;
    private final Type type;

    /* compiled from: CropWindowMoveHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/canhub/cropper/CropWindowMoveHandler$Type;", "", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "LEFT", "TOP", "RIGHT", "BOTTOM", "CENTER", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    /* compiled from: CropWindowMoveHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[Type.TOP_LEFT.ordinal()] = 1;
            iArr[Type.TOP_RIGHT.ordinal()] = 2;
            iArr[Type.BOTTOM_LEFT.ordinal()] = 3;
            iArr[Type.BOTTOM_RIGHT.ordinal()] = 4;
            iArr[Type.LEFT.ordinal()] = 5;
            iArr[Type.TOP.ordinal()] = 6;
            iArr[Type.RIGHT.ordinal()] = 7;
            iArr[Type.BOTTOM.ordinal()] = 8;
            iArr[Type.CENTER.ordinal()] = 9;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CropWindowMoveHandler(Type type, CropWindowHandler cropWindowHandler, float f, float f2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(cropWindowHandler, "cropWindowHandler");
        this.type = type;
        this.mMinCropWidth = cropWindowHandler.getMinCropWidth();
        this.mMinCropHeight = cropWindowHandler.getMinCropHeight();
        this.mMaxCropWidth = cropWindowHandler.getMaxCropWidth();
        this.mMaxCropHeight = cropWindowHandler.getMaxCropHeight();
        this.mTouchOffset = new PointF(0.0f, 0.0f);
        calculateTouchOffset(cropWindowHandler.getRect(), f, f2);
    }

    /* compiled from: CropWindowMoveHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\t"}, d2 = {"Lcom/canhub/cropper/CropWindowMoveHandler$Companion;", "", "()V", "calculateAspectRatio", "", "left", "top", ViewProps.RIGHT, ViewProps.BOTTOM, "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float calculateAspectRatio(float left, float top, float right, float bottom) {
            return (right - left) / (bottom - top);
        }

        private Companion() {
        }
    }

    public final void move(RectF rect, float x, float y, RectF bounds, int viewWidth, int viewHeight, float snapMargin, boolean fixedAspectRatio, float aspectRatio) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        float f = x + this.mTouchOffset.x;
        float f2 = y + this.mTouchOffset.y;
        if (this.type == Type.CENTER) {
            moveCenter(rect, f, f2, bounds, viewWidth, viewHeight, snapMargin);
        } else if (fixedAspectRatio) {
            moveSizeWithFixedAspectRatio(rect, f, f2, bounds, viewWidth, viewHeight, snapMargin, aspectRatio);
        } else {
            moveSizeWithFreeAspectRatio(rect, f, f2, bounds, viewWidth, viewHeight, snapMargin);
        }
    }

    private final void calculateTouchOffset(RectF rect, float touchX, float touchY) {
        float fCenterY;
        float f;
        float f2;
        float fCenterX = 0.0f;
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                fCenterX = rect.left - touchX;
                fCenterY = rect.top;
                f2 = fCenterY - touchY;
                break;
            case 2:
                fCenterX = rect.right - touchX;
                fCenterY = rect.top;
                f2 = fCenterY - touchY;
                break;
            case 3:
                fCenterX = rect.left - touchX;
                fCenterY = rect.bottom;
                f2 = fCenterY - touchY;
                break;
            case 4:
                fCenterX = rect.right - touchX;
                fCenterY = rect.bottom;
                f2 = fCenterY - touchY;
                break;
            case 5:
                f = rect.left;
                fCenterX = f - touchX;
                f2 = 0.0f;
                break;
            case 6:
                fCenterY = rect.top;
                f2 = fCenterY - touchY;
                break;
            case 7:
                f = rect.right;
                fCenterX = f - touchX;
                f2 = 0.0f;
                break;
            case 8:
                fCenterY = rect.bottom;
                f2 = fCenterY - touchY;
                break;
            case 9:
                fCenterX = rect.centerX() - touchX;
                fCenterY = rect.centerY();
                f2 = fCenterY - touchY;
                break;
            default:
                f2 = 0.0f;
                break;
        }
        this.mTouchOffset.x = fCenterX;
        this.mTouchOffset.y = f2;
    }

    private final void moveCenter(RectF rect, float x, float y, RectF bounds, int viewWidth, int viewHeight, float snapRadius) {
        float fCenterX = x - rect.centerX();
        float fCenterY = y - rect.centerY();
        if (rect.left + fCenterX < 0.0f || rect.right + fCenterX > viewWidth || rect.left + fCenterX < bounds.left || rect.right + fCenterX > bounds.right) {
            fCenterX /= 1.05f;
            this.mTouchOffset.x -= fCenterX / 2;
        }
        if (rect.top + fCenterY < 0.0f || rect.bottom + fCenterY > viewHeight || rect.top + fCenterY < bounds.top || rect.bottom + fCenterY > bounds.bottom) {
            fCenterY /= 1.05f;
            this.mTouchOffset.y -= fCenterY / 2;
        }
        rect.offset(fCenterX, fCenterY);
        snapEdgesToBounds(rect, bounds, snapRadius);
    }

    private final void moveSizeWithFreeAspectRatio(RectF rect, float x, float y, RectF bounds, int viewWidth, int viewHeight, float snapMargin) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                adjustTop(rect, y, bounds, snapMargin, 0.0f, false, false);
                adjustLeft(rect, x, bounds, snapMargin, 0.0f, false, false);
                break;
            case 2:
                adjustTop(rect, y, bounds, snapMargin, 0.0f, false, false);
                adjustRight(rect, x, bounds, viewWidth, snapMargin, 0.0f, false, false);
                break;
            case 3:
                adjustBottom(rect, y, bounds, viewHeight, snapMargin, 0.0f, false, false);
                adjustLeft(rect, x, bounds, snapMargin, 0.0f, false, false);
                break;
            case 4:
                adjustBottom(rect, y, bounds, viewHeight, snapMargin, 0.0f, false, false);
                adjustRight(rect, x, bounds, viewWidth, snapMargin, 0.0f, false, false);
                break;
            case 5:
                adjustLeft(rect, x, bounds, snapMargin, 0.0f, false, false);
                break;
            case 6:
                adjustTop(rect, y, bounds, snapMargin, 0.0f, false, false);
                break;
            case 7:
                adjustRight(rect, x, bounds, viewWidth, snapMargin, 0.0f, false, false);
                break;
            case 8:
                adjustBottom(rect, y, bounds, viewHeight, snapMargin, 0.0f, false, false);
                break;
        }
    }

    private final void moveSizeWithFixedAspectRatio(RectF rect, float x, float y, RectF bounds, int viewWidth, int viewHeight, float snapMargin, float aspectRatio) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                if (INSTANCE.calculateAspectRatio(x, y, rect.right, rect.bottom) < aspectRatio) {
                    adjustTop(rect, y, bounds, snapMargin, aspectRatio, true, false);
                    adjustLeftByAspectRatio(rect, aspectRatio);
                    break;
                } else {
                    adjustLeft(rect, x, bounds, snapMargin, aspectRatio, true, false);
                    adjustTopByAspectRatio(rect, aspectRatio);
                    break;
                }
            case 2:
                if (INSTANCE.calculateAspectRatio(rect.left, y, x, rect.bottom) < aspectRatio) {
                    adjustTop(rect, y, bounds, snapMargin, aspectRatio, false, true);
                    adjustRightByAspectRatio(rect, aspectRatio);
                    break;
                } else {
                    adjustRight(rect, x, bounds, viewWidth, snapMargin, aspectRatio, true, false);
                    adjustTopByAspectRatio(rect, aspectRatio);
                    break;
                }
            case 3:
                if (INSTANCE.calculateAspectRatio(x, rect.top, rect.right, y) < aspectRatio) {
                    adjustBottom(rect, y, bounds, viewHeight, snapMargin, aspectRatio, true, false);
                    adjustLeftByAspectRatio(rect, aspectRatio);
                    break;
                } else {
                    adjustLeft(rect, x, bounds, snapMargin, aspectRatio, false, true);
                    adjustBottomByAspectRatio(rect, aspectRatio);
                    break;
                }
            case 4:
                if (INSTANCE.calculateAspectRatio(rect.left, rect.top, x, y) < aspectRatio) {
                    adjustBottom(rect, y, bounds, viewHeight, snapMargin, aspectRatio, false, true);
                    adjustRightByAspectRatio(rect, aspectRatio);
                    break;
                } else {
                    adjustRight(rect, x, bounds, viewWidth, snapMargin, aspectRatio, false, true);
                    adjustBottomByAspectRatio(rect, aspectRatio);
                    break;
                }
            case 5:
                adjustLeft(rect, x, bounds, snapMargin, aspectRatio, true, true);
                adjustTopBottomByAspectRatio(rect, bounds, aspectRatio);
                break;
            case 6:
                adjustTop(rect, y, bounds, snapMargin, aspectRatio, true, true);
                adjustLeftRightByAspectRatio(rect, bounds, aspectRatio);
                break;
            case 7:
                adjustRight(rect, x, bounds, viewWidth, snapMargin, aspectRatio, true, true);
                adjustTopBottomByAspectRatio(rect, bounds, aspectRatio);
                break;
            case 8:
                adjustBottom(rect, y, bounds, viewHeight, snapMargin, aspectRatio, true, true);
                adjustLeftRightByAspectRatio(rect, bounds, aspectRatio);
                break;
        }
    }

    private final void snapEdgesToBounds(RectF edges, RectF bounds, float margin) {
        if (edges.left < bounds.left + margin) {
            edges.offset(bounds.left - edges.left, 0.0f);
        }
        if (edges.top < bounds.top + margin) {
            edges.offset(0.0f, bounds.top - edges.top);
        }
        if (edges.right > bounds.right - margin) {
            edges.offset(bounds.right - edges.right, 0.0f);
        }
        if (edges.bottom > bounds.bottom - margin) {
            edges.offset(0.0f, bounds.bottom - edges.bottom);
        }
    }

    private final void adjustLeft(RectF rect, float left, RectF bounds, float snapMargin, float aspectRatio, boolean topMoves, boolean bottomMoves) {
        if (left < 0.0f) {
            left /= 1.05f;
            this.mTouchOffset.x -= left / 1.1f;
        }
        if (left < bounds.left) {
            this.mTouchOffset.x -= (left - bounds.left) / 2.0f;
        }
        if (left - bounds.left < snapMargin) {
            left = bounds.left;
        }
        if (rect.right - left < this.mMinCropWidth) {
            left = rect.right - this.mMinCropWidth;
        }
        if (rect.right - left > this.mMaxCropWidth) {
            left = rect.right - this.mMaxCropWidth;
        }
        if (left - bounds.left < snapMargin) {
            left = bounds.left;
        }
        if (aspectRatio > 0.0f) {
            float f = (rect.right - left) / aspectRatio;
            if (f < this.mMinCropHeight) {
                left = Math.max(bounds.left, rect.right - (this.mMinCropHeight * aspectRatio));
                f = (rect.right - left) / aspectRatio;
            }
            if (f > this.mMaxCropHeight) {
                left = Math.max(bounds.left, rect.right - (this.mMaxCropHeight * aspectRatio));
                f = (rect.right - left) / aspectRatio;
            }
            if (topMoves && bottomMoves) {
                left = Math.max(left, Math.max(bounds.left, rect.right - (bounds.height() * aspectRatio)));
            } else {
                if (topMoves && rect.bottom - f < bounds.top) {
                    left = Math.max(bounds.left, rect.right - ((rect.bottom - bounds.top) * aspectRatio));
                    f = (rect.right - left) / aspectRatio;
                }
                if (bottomMoves && rect.top + f > bounds.bottom) {
                    left = Math.max(left, Math.max(bounds.left, rect.right - ((bounds.bottom - rect.top) * aspectRatio)));
                }
            }
        }
        rect.left = left;
    }

    private final void adjustRight(RectF rect, float right, RectF bounds, int viewWidth, float snapMargin, float aspectRatio, boolean topMoves, boolean bottomMoves) {
        float f = viewWidth;
        if (right > f) {
            right = ((right - f) / 1.05f) + f;
            this.mTouchOffset.x -= (right - f) / 1.1f;
        }
        if (right > bounds.right) {
            this.mTouchOffset.x -= (right - bounds.right) / 2.0f;
        }
        if (bounds.right - right < snapMargin) {
            right = bounds.right;
        }
        if (right - rect.left < this.mMinCropWidth) {
            right = rect.left + this.mMinCropWidth;
        }
        if (right - rect.left > this.mMaxCropWidth) {
            right = rect.left + this.mMaxCropWidth;
        }
        if (bounds.right - right < snapMargin) {
            right = bounds.right;
        }
        if (aspectRatio > 0.0f) {
            float f2 = (right - rect.left) / aspectRatio;
            if (f2 < this.mMinCropHeight) {
                right = Math.min(bounds.right, rect.left + (this.mMinCropHeight * aspectRatio));
                f2 = (right - rect.left) / aspectRatio;
            }
            if (f2 > this.mMaxCropHeight) {
                right = Math.min(bounds.right, rect.left + (this.mMaxCropHeight * aspectRatio));
                f2 = (right - rect.left) / aspectRatio;
            }
            if (topMoves && bottomMoves) {
                right = Math.min(right, Math.min(bounds.right, rect.left + (bounds.height() * aspectRatio)));
            } else {
                if (topMoves && rect.bottom - f2 < bounds.top) {
                    right = Math.min(bounds.right, rect.left + ((rect.bottom - bounds.top) * aspectRatio));
                    f2 = (right - rect.left) / aspectRatio;
                }
                if (bottomMoves && rect.top + f2 > bounds.bottom) {
                    right = Math.min(right, Math.min(bounds.right, rect.left + ((bounds.bottom - rect.top) * aspectRatio)));
                }
            }
        }
        rect.right = right;
    }

    private final void adjustTop(RectF rect, float top, RectF bounds, float snapMargin, float aspectRatio, boolean leftMoves, boolean rightMoves) {
        if (top < 0.0f) {
            top /= 1.05f;
            this.mTouchOffset.y -= top / 1.1f;
        }
        if (top < bounds.top) {
            this.mTouchOffset.y -= (top - bounds.top) / 2.0f;
        }
        if (top - bounds.top < snapMargin) {
            top = bounds.top;
        }
        if (rect.bottom - top < this.mMinCropHeight) {
            top = rect.bottom - this.mMinCropHeight;
        }
        if (rect.bottom - top > this.mMaxCropHeight) {
            top = rect.bottom - this.mMaxCropHeight;
        }
        if (top - bounds.top < snapMargin) {
            top = bounds.top;
        }
        if (aspectRatio > 0.0f) {
            float f = (rect.bottom - top) * aspectRatio;
            if (f < this.mMinCropWidth) {
                top = Math.max(bounds.top, rect.bottom - (this.mMinCropWidth / aspectRatio));
                f = (rect.bottom - top) * aspectRatio;
            }
            if (f > this.mMaxCropWidth) {
                top = Math.max(bounds.top, rect.bottom - (this.mMaxCropWidth / aspectRatio));
                f = (rect.bottom - top) * aspectRatio;
            }
            if (leftMoves && rightMoves) {
                top = Math.max(top, Math.max(bounds.top, rect.bottom - (bounds.width() / aspectRatio)));
            } else {
                if (leftMoves && rect.right - f < bounds.left) {
                    top = Math.max(bounds.top, rect.bottom - ((rect.right - bounds.left) / aspectRatio));
                    f = (rect.bottom - top) * aspectRatio;
                }
                if (rightMoves && rect.left + f > bounds.right) {
                    top = Math.max(top, Math.max(bounds.top, rect.bottom - ((bounds.right - rect.left) / aspectRatio)));
                }
            }
        }
        rect.top = top;
    }

    private final void adjustBottom(RectF rect, float bottom, RectF bounds, int viewHeight, float snapMargin, float aspectRatio, boolean leftMoves, boolean rightMoves) {
        float f = viewHeight;
        if (bottom > f) {
            bottom = ((bottom - f) / 1.05f) + f;
            this.mTouchOffset.y -= (bottom - f) / 1.1f;
        }
        if (bottom > bounds.bottom) {
            this.mTouchOffset.y -= (bottom - bounds.bottom) / 2.0f;
        }
        if (bounds.bottom - bottom < snapMargin) {
            bottom = bounds.bottom;
        }
        if (bottom - rect.top < this.mMinCropHeight) {
            bottom = rect.top + this.mMinCropHeight;
        }
        if (bottom - rect.top > this.mMaxCropHeight) {
            bottom = rect.top + this.mMaxCropHeight;
        }
        if (bounds.bottom - bottom < snapMargin) {
            bottom = bounds.bottom;
        }
        if (aspectRatio > 0.0f) {
            float f2 = (bottom - rect.top) * aspectRatio;
            if (f2 < this.mMinCropWidth) {
                bottom = Math.min(bounds.bottom, rect.top + (this.mMinCropWidth / aspectRatio));
                f2 = (bottom - rect.top) * aspectRatio;
            }
            if (f2 > this.mMaxCropWidth) {
                bottom = Math.min(bounds.bottom, rect.top + (this.mMaxCropWidth / aspectRatio));
                f2 = (bottom - rect.top) * aspectRatio;
            }
            if (leftMoves && rightMoves) {
                bottom = Math.min(bottom, Math.min(bounds.bottom, rect.top + (bounds.width() / aspectRatio)));
            } else {
                if (leftMoves && rect.right - f2 < bounds.left) {
                    bottom = Math.min(bounds.bottom, rect.top + ((rect.right - bounds.left) / aspectRatio));
                    f2 = (bottom - rect.top) * aspectRatio;
                }
                if (rightMoves && rect.left + f2 > bounds.right) {
                    bottom = Math.min(bottom, Math.min(bounds.bottom, rect.top + ((bounds.right - rect.left) / aspectRatio)));
                }
            }
        }
        rect.bottom = bottom;
    }

    private final void adjustLeftByAspectRatio(RectF rect, float aspectRatio) {
        rect.left = rect.right - (rect.height() * aspectRatio);
    }

    private final void adjustTopByAspectRatio(RectF rect, float aspectRatio) {
        rect.top = rect.bottom - (rect.width() / aspectRatio);
    }

    private final void adjustRightByAspectRatio(RectF rect, float aspectRatio) {
        rect.right = rect.left + (rect.height() * aspectRatio);
    }

    private final void adjustBottomByAspectRatio(RectF rect, float aspectRatio) {
        rect.bottom = rect.top + (rect.width() / aspectRatio);
    }

    private final void adjustLeftRightByAspectRatio(RectF rect, RectF bounds, float aspectRatio) {
        rect.inset((rect.width() - (rect.height() * aspectRatio)) / 2, 0.0f);
        if (rect.left < bounds.left) {
            rect.offset(bounds.left - rect.left, 0.0f);
        }
        if (rect.right > bounds.right) {
            rect.offset(bounds.right - rect.right, 0.0f);
        }
    }

    private final void adjustTopBottomByAspectRatio(RectF rect, RectF bounds, float aspectRatio) {
        rect.inset(0.0f, (rect.height() - (rect.width() / aspectRatio)) / 2);
        if (rect.top < bounds.top) {
            rect.offset(0.0f, bounds.top - rect.top);
        }
        if (rect.bottom > bounds.bottom) {
            rect.offset(0.0f, bounds.bottom - rect.bottom);
        }
    }
}
