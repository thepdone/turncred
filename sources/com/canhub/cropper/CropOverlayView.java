package com.canhub.cropper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.canhub.cropper.CropImageView;
import com.canhub.cropper.common.CommonVersionCheck;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.sentry.Session;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CropOverlayView.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b/\u0018\u0000 ¥\u00012\u00020\u0001:\u0006¥\u0001¦\u0001§\u0001B\u001d\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\\\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u000200H\u0002J\u0010\u0010`\u001a\u00020^2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020^2\u0006\u0010a\u001a\u00020bH\u0002J0\u0010d\u001a\u00020^2\u0006\u0010a\u001a\u00020b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u00192\u0006\u0010g\u001a\u00020\u0019H\u0002J(\u0010h\u001a\u00020^2\u0006\u0010a\u001a\u00020b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u0019H\u0002J0\u0010i\u001a\u00020^2\u0006\u0010a\u001a\u00020b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u00192\u0006\u0010g\u001a\u00020\u0019H\u0002J\u0010\u0010j\u001a\u00020^2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010k\u001a\u00020^2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010l\u001a\u00020^2\u0006\u0010a\u001a\u00020bH\u0002J(\u0010m\u001a\u00020^2\u0006\u0010a\u001a\u00020b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u0019H\u0002J\u0010\u0010n\u001a\u00020^2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010o\u001a\u00020^J\b\u0010p\u001a\u00020^H\u0002J\u0018\u0010q\u001a\u00020^2\u0006\u0010r\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u0019H\u0002J\u0018\u0010t\u001a\u00020^2\u0006\u0010r\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u0019H\u0002J\b\u0010u\u001a\u00020^H\u0002J\u0010\u0010v\u001a\u00020^2\u0006\u0010a\u001a\u00020bH\u0014J\u0010\u0010w\u001a\u0002002\u0006\u0010x\u001a\u00020yH\u0016J\u0006\u0010z\u001a\u00020^J\u0006\u0010{\u001a\u00020^J \u0010|\u001a\u00020^2\b\u0010}\u001a\u0004\u0018\u00010>2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bJ\u0010\u0010\u0080\u0001\u001a\u0002002\u0007\u0010\u0081\u0001\u001a\u000200J\u0010\u0010\u0082\u0001\u001a\u00020^2\u0007\u0010\u0083\u0001\u001a\u00020\u0019J\u0010\u0010\u0084\u0001\u001a\u00020^2\u0007\u0010\u0085\u0001\u001a\u00020\u0011J\u0012\u0010\u0086\u0001\u001a\u00020^2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0088\u0001\u001a\u00020^2\u0007\u0010\u0089\u0001\u001a\u00020\bJ\u0010\u0010\u008a\u0001\u001a\u00020^2\u0007\u0010\u008b\u0001\u001a\u00020\u0019J\u000f\u0010\u008c\u0001\u001a\u00020^2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0012\u0010\u008d\u0001\u001a\u00020^2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010EJ+\u0010\u008f\u0001\u001a\u00020^2\u0007\u0010\u0090\u0001\u001a\u00020\u00192\u0007\u0010\u0091\u0001\u001a\u00020\u00192\u0007\u0010\u0092\u0001\u001a\u00020\u00192\u0007\u0010\u0093\u0001\u001a\u00020\u0019J\u0010\u0010\u0094\u0001\u001a\u00020^2\u0007\u0010\u0095\u0001\u001a\u000200J\u0010\u0010\u0096\u0001\u001a\u00020^2\u0007\u0010\u0097\u0001\u001a\u000200J\u000f\u0010\u0098\u0001\u001a\u00020^2\u0006\u0010&\u001a\u00020%J\u0010\u0010\u0099\u0001\u001a\u00020^2\u0007\u0010\u009a\u0001\u001a\u00020PJ\u0019\u0010\u009b\u0001\u001a\u00020^2\u0007\u0010\u009c\u0001\u001a\u00020\b2\u0007\u0010\u009d\u0001\u001a\u00020\bJ\u0019\u0010\u009e\u0001\u001a\u00020^2\u0007\u0010\u009f\u0001\u001a\u00020\b2\u0007\u0010 \u0001\u001a\u00020\bJ\u0010\u0010¡\u0001\u001a\u0002002\u0007\u0010¢\u0001\u001a\u000200J\u0010\u0010£\u0001\u001a\u00020^2\u0007\u0010¤\u0001\u001a\u00020\u0019R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0010\u001a\u0004\u0018\u00010%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u001e\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002002\u0006\u0010\u0010\u001a\u000200@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00103R\u000e\u00105\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Q\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¨\u0001"}, d2 = {"Lcom/canhub/cropper/CropOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", Session.JsonKeys.ATTRS, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aspectRatioX", "", "getAspectRatioX", "()I", "setAspectRatioX", "(I)V", "aspectRatioY", "getAspectRatioY", "setAspectRatioY", "<set-?>", "Lcom/canhub/cropper/CropImageView$CropCornerShape;", "cornerShape", "getCornerShape", "()Lcom/canhub/cropper/CropImageView$CropCornerShape;", "cropLabelText", "", "cropLabelTextColor", "cropLabelTextSize", "", "Lcom/canhub/cropper/CropImageView$CropShape;", "cropShape", "getCropShape", "()Lcom/canhub/cropper/CropImageView$CropShape;", "rect", "Landroid/graphics/RectF;", "cropWindowRect", "getCropWindowRect", "()Landroid/graphics/RectF;", "setCropWindowRect", "(Landroid/graphics/RectF;)V", "Lcom/canhub/cropper/CropImageView$Guidelines;", "guidelines", "getGuidelines", "()Lcom/canhub/cropper/CropImageView$Guidelines;", "Landroid/graphics/Rect;", "initialCropWindowRect", "getInitialCropWindowRect", "()Landroid/graphics/Rect;", "setInitialCropWindowRect", "(Landroid/graphics/Rect;)V", "initializedCropWindow", "", "isCropLabelEnabled", "isFixAspectRatio", "()Z", "isNonStraightAngleRotated", "mAspectRatioX", "mAspectRatioY", "mBackgroundPaint", "Landroid/graphics/Paint;", "mBorderCornerLength", "mBorderCornerOffset", "mBorderCornerPaint", "mBorderPaint", "mBoundsPoints", "", "mCalcBounds", "mCenterMoveEnabled", "mCircleCornerFillColor", "Ljava/lang/Integer;", "mCropCornerRadius", "mCropWindowChangeListener", "Lcom/canhub/cropper/CropOverlayView$CropWindowChangeListener;", "mCropWindowHandler", "Lcom/canhub/cropper/CropWindowHandler;", "mDrawRect", "mGuidelinePaint", "mInitialCropWindowPaddingRatio", "mInitialCropWindowRect", "mMoveHandler", "Lcom/canhub/cropper/CropWindowMoveHandler;", "mMultiTouchEnabled", "mOptions", "Lcom/canhub/cropper/CropImageOptions;", "mOriginalLayerType", "mPath", "Landroid/graphics/Path;", "mScaleDetector", "Landroid/view/ScaleGestureDetector;", "mSnapRadius", "mTargetAspectRatio", "mTouchRadius", "mViewHeight", "mViewWidth", "textLabelPaint", "calculateBounds", "callOnCropWindowChanged", "", "inProgress", "drawBackground", "canvas", "Landroid/graphics/Canvas;", "drawBorders", "drawCircleShape", "cornerOffset", "cornerExtension", "radius", "drawCornerBasedOnShape", "drawCornerShape", "drawCorners", "drawCropLabelText", "drawGuidelines", "drawLineShape", "fixCropWindowRectByRules", "fixCurrentCropWindowRect", "initCropWindow", "onActionDown", "x", "y", "onActionMove", "onActionUp", "onDraw", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "resetCropOverlayView", "resetCropWindowRect", "setBounds", "boundsPoints", "viewWidth", "viewHeight", "setCenterMoveEnabled", "centerMoveEnabled", "setCropCornerRadius", "cornerRadius", "setCropCornerShape", "cropCornerShape", "setCropLabelText", "textLabel", "setCropLabelTextColor", "textColor", "setCropLabelTextSize", "textSize", "setCropShape", "setCropWindowChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCropWindowLimits", ViewProps.MAX_WIDTH, ViewProps.MAX_HEIGHT, "scaleFactorWidth", "scaleFactorHeight", "setCropperTextLabelVisibility", "isEnabled", "setFixedAspectRatio", "fixAspectRatio", "setGuidelines", "setInitialAttributeValues", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "setMaxCropResultSize", "maxCropResultWidth", "maxCropResultHeight", "setMinCropResultSize", "minCropResultWidth", "minCropResultHeight", "setMultiTouchEnabled", "multiTouchEnabled", "setSnapRadius", "snapRadius", "Companion", "CropWindowChangeListener", "ScaleListener", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CropOverlayView extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CropImageView.CropCornerShape cornerShape;
    private String cropLabelText;
    private int cropLabelTextColor;
    private float cropLabelTextSize;
    private CropImageView.CropShape cropShape;
    private CropImageView.Guidelines guidelines;
    private boolean initializedCropWindow;
    private boolean isCropLabelEnabled;
    private boolean isFixAspectRatio;
    private int mAspectRatioX;
    private int mAspectRatioY;
    private Paint mBackgroundPaint;
    private float mBorderCornerLength;
    private float mBorderCornerOffset;
    private Paint mBorderCornerPaint;
    private Paint mBorderPaint;
    private final float[] mBoundsPoints;
    private final RectF mCalcBounds;
    private boolean mCenterMoveEnabled;
    private Integer mCircleCornerFillColor;
    private float mCropCornerRadius;
    private CropWindowChangeListener mCropWindowChangeListener;
    private final CropWindowHandler mCropWindowHandler;
    private final RectF mDrawRect;
    private Paint mGuidelinePaint;
    private float mInitialCropWindowPaddingRatio;
    private final Rect mInitialCropWindowRect;
    private CropWindowMoveHandler mMoveHandler;
    private boolean mMultiTouchEnabled;
    private CropImageOptions mOptions;
    private Integer mOriginalLayerType;
    private final Path mPath;
    private ScaleGestureDetector mScaleDetector;
    private float mSnapRadius;
    private float mTargetAspectRatio;
    private float mTouchRadius;
    private int mViewHeight;
    private int mViewWidth;
    private Paint textLabelPaint;

    /* compiled from: CropOverlayView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/canhub/cropper/CropOverlayView$CropWindowChangeListener;", "", "onCropWindowChanged", "", "inProgress", "", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface CropWindowChangeListener {
        void onCropWindowChanged(boolean inProgress);
    }

    /* compiled from: CropOverlayView.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CropImageView.CropShape.values().length];
            iArr[CropImageView.CropShape.RECTANGLE.ordinal()] = 1;
            iArr[CropImageView.CropShape.RECTANGLE_VERTICAL_ONLY.ordinal()] = 2;
            iArr[CropImageView.CropShape.RECTANGLE_HORIZONTAL_ONLY.ordinal()] = 3;
            iArr[CropImageView.CropShape.OVAL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CropImageView.CropCornerShape.values().length];
            iArr2[CropImageView.CropCornerShape.OVAL.ordinal()] = 1;
            iArr2[CropImageView.CropCornerShape.RECTANGLE.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public CropOverlayView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCenterMoveEnabled = true;
        this.mCropWindowHandler = new CropWindowHandler();
        this.mDrawRect = new RectF();
        this.mPath = new Path();
        this.mBoundsPoints = new float[8];
        this.mCalcBounds = new RectF();
        this.mTargetAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
        this.cropLabelText = "";
        this.cropLabelTextSize = 20.0f;
        this.cropLabelTextColor = -1;
        this.mInitialCropWindowRect = new Rect();
    }

    public /* synthetic */ CropOverlayView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* compiled from: CropOverlayView.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/canhub/cropper/CropOverlayView$Companion;", "", "()V", "getNewPaint", "Landroid/graphics/Paint;", ViewProps.COLOR, "", "getNewPaintOrNull", "thickness", "", "getNewPaintWithFill", "getTextPaint", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/canhub/cropper/CropImageOptions;", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Paint getTextPaint(CropImageOptions options) {
            Paint paint = new Paint();
            paint.setStrokeWidth(1.0f);
            paint.setTextSize(options.cropperLabelTextSize);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(options.cropperLabelTextColor);
            return paint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Paint getNewPaint(int color) {
            Paint paint = new Paint();
            paint.setColor(color);
            return paint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Paint getNewPaintOrNull(float thickness, int color) {
            if (thickness <= 0.0f) {
                return null;
            }
            Paint paint = new Paint();
            paint.setColor(color);
            paint.setStrokeWidth(thickness);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            return paint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Paint getNewPaintWithFill(int color) {
            Paint paint = new Paint();
            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            return paint;
        }
    }

    /* renamed from: isFixAspectRatio, reason: from getter */
    public final boolean getIsFixAspectRatio() {
        return this.isFixAspectRatio;
    }

    public final CropImageView.Guidelines getGuidelines() {
        return this.guidelines;
    }

    public final CropImageView.CropShape getCropShape() {
        return this.cropShape;
    }

    public final CropImageView.CropCornerShape getCornerShape() {
        return this.cornerShape;
    }

    public final void setCropWindowChangeListener(CropWindowChangeListener listener) {
        this.mCropWindowChangeListener = listener;
    }

    public final RectF getCropWindowRect() {
        return this.mCropWindowHandler.getRect();
    }

    public final void setCropWindowRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mCropWindowHandler.setRect(rect);
    }

    public final void fixCurrentCropWindowRect() {
        RectF cropWindowRect = getCropWindowRect();
        fixCropWindowRectByRules(cropWindowRect);
        this.mCropWindowHandler.setRect(cropWindowRect);
    }

    public final void setBounds(float[] boundsPoints, int viewWidth, int viewHeight) {
        if (boundsPoints == null || !Arrays.equals(this.mBoundsPoints, boundsPoints)) {
            if (boundsPoints == null) {
                Arrays.fill(this.mBoundsPoints, 0.0f);
            } else {
                System.arraycopy(boundsPoints, 0, this.mBoundsPoints, 0, boundsPoints.length);
            }
            this.mViewWidth = viewWidth;
            this.mViewHeight = viewHeight;
            RectF rect = this.mCropWindowHandler.getRect();
            if (rect.width() == 0.0f || rect.height() == 0.0f) {
                initCropWindow();
            }
        }
    }

    public final void resetCropOverlayView() {
        if (this.initializedCropWindow) {
            setCropWindowRect(BitmapUtils.INSTANCE.getEMPTY_RECT_F());
            initCropWindow();
            invalidate();
        }
    }

    public final void setCropShape(CropImageView.CropShape cropShape) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        if (this.cropShape != cropShape) {
            this.cropShape = cropShape;
            if (!CommonVersionCheck.INSTANCE.isAtLeastJ18()) {
                if (this.cropShape == CropImageView.CropShape.OVAL) {
                    Integer numValueOf = Integer.valueOf(getLayerType());
                    this.mOriginalLayerType = numValueOf;
                    if (numValueOf != null && numValueOf.intValue() == 1) {
                        this.mOriginalLayerType = null;
                    } else {
                        setLayerType(1, null);
                    }
                } else {
                    Integer num = this.mOriginalLayerType;
                    if (num != null) {
                        Intrinsics.checkNotNull(num);
                        setLayerType(num.intValue(), null);
                        this.mOriginalLayerType = null;
                    }
                }
            }
            invalidate();
        }
    }

    public final void setCropCornerShape(CropImageView.CropCornerShape cropCornerShape) {
        Intrinsics.checkNotNullParameter(cropCornerShape, "cropCornerShape");
        if (this.cornerShape != cropCornerShape) {
            this.cornerShape = cropCornerShape;
            invalidate();
        }
    }

    public final void setCropperTextLabelVisibility(boolean isEnabled) {
        this.isCropLabelEnabled = isEnabled;
        invalidate();
    }

    public final void setCropLabelText(String textLabel) {
        if (textLabel != null) {
            this.cropLabelText = textLabel;
        }
    }

    public final void setCropLabelTextSize(float textSize) {
        this.cropLabelTextSize = textSize;
        invalidate();
    }

    public final void setCropLabelTextColor(int textColor) {
        this.cropLabelTextColor = textColor;
        invalidate();
    }

    public final void setGuidelines(CropImageView.Guidelines guidelines) {
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        if (this.guidelines != guidelines) {
            this.guidelines = guidelines;
            if (this.initializedCropWindow) {
                invalidate();
            }
        }
    }

    public final void setFixedAspectRatio(boolean fixAspectRatio) {
        if (this.isFixAspectRatio != fixAspectRatio) {
            this.isFixAspectRatio = fixAspectRatio;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    /* renamed from: getAspectRatioX, reason: from getter */
    public final int getMAspectRatioX() {
        return this.mAspectRatioX;
    }

    public final void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.".toString());
        }
        if (this.mAspectRatioX != i) {
            this.mAspectRatioX = i;
            this.mTargetAspectRatio = i / this.mAspectRatioY;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    /* renamed from: getAspectRatioY, reason: from getter */
    public final int getMAspectRatioY() {
        return this.mAspectRatioY;
    }

    public final void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.".toString());
        }
        if (this.mAspectRatioY != i) {
            this.mAspectRatioY = i;
            this.mTargetAspectRatio = this.mAspectRatioX / i;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public final void setSnapRadius(float snapRadius) {
        this.mSnapRadius = snapRadius;
    }

    public final void setCropCornerRadius(float cornerRadius) {
        this.mCropCornerRadius = cornerRadius;
    }

    public final boolean setMultiTouchEnabled(boolean multiTouchEnabled) {
        if (this.mMultiTouchEnabled == multiTouchEnabled) {
            return false;
        }
        this.mMultiTouchEnabled = multiTouchEnabled;
        if (!multiTouchEnabled || this.mScaleDetector != null) {
            return true;
        }
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        return true;
    }

    public final boolean setCenterMoveEnabled(boolean centerMoveEnabled) {
        if (this.mCenterMoveEnabled == centerMoveEnabled) {
            return false;
        }
        this.mCenterMoveEnabled = centerMoveEnabled;
        return true;
    }

    public final void setMinCropResultSize(int minCropResultWidth, int minCropResultHeight) {
        this.mCropWindowHandler.setMinCropResultSize(minCropResultWidth, minCropResultHeight);
    }

    public final void setMaxCropResultSize(int maxCropResultWidth, int maxCropResultHeight) {
        this.mCropWindowHandler.setMaxCropResultSize(maxCropResultWidth, maxCropResultHeight);
    }

    public final void setCropWindowLimits(float maxWidth, float maxHeight, float scaleFactorWidth, float scaleFactorHeight) {
        this.mCropWindowHandler.setCropWindowLimits(maxWidth, maxHeight, scaleFactorWidth, scaleFactorHeight);
    }

    /* renamed from: getInitialCropWindowRect, reason: from getter */
    public final Rect getMInitialCropWindowRect() {
        return this.mInitialCropWindowRect;
    }

    public final void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.mInitialCropWindowRect;
        if (rect == null) {
            rect = BitmapUtils.INSTANCE.getEMPTY_RECT();
        }
        rect2.set(rect);
        if (this.initializedCropWindow) {
            initCropWindow();
            invalidate();
            callOnCropWindowChanged(false);
        }
    }

    public final void resetCropWindowRect() {
        if (this.initializedCropWindow) {
            initCropWindow();
            invalidate();
            callOnCropWindowChanged(false);
        }
    }

    public final void setInitialAttributeValues(CropImageOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.mOptions = options;
        this.mCropWindowHandler.setInitialAttributeValues(options);
        setCropLabelTextColor(options.cropperLabelTextColor);
        setCropLabelTextSize(options.cropperLabelTextSize);
        setCropLabelText(options.cropperLabelText);
        setCropperTextLabelVisibility(options.showCropLabel);
        setCropCornerRadius(options.cropCornerRadius);
        setCropCornerShape(options.cornerShape);
        setCropShape(options.cropShape);
        setSnapRadius(options.snapRadius);
        setGuidelines(options.guidelines);
        setFixedAspectRatio(options.fixAspectRatio);
        setAspectRatioX(options.aspectRatioX);
        setAspectRatioY(options.aspectRatioY);
        setMultiTouchEnabled(options.multiTouchEnabled);
        setCenterMoveEnabled(options.centerMoveEnabled);
        this.mTouchRadius = options.touchRadius;
        this.mInitialCropWindowPaddingRatio = options.initialCropWindowPaddingRatio;
        Companion companion = INSTANCE;
        this.mBorderPaint = companion.getNewPaintOrNull(options.borderLineThickness, options.borderLineColor);
        this.mBorderCornerOffset = options.borderCornerOffset;
        this.mBorderCornerLength = options.borderCornerLength;
        this.mCircleCornerFillColor = Integer.valueOf(options.circleCornerFillColorHexValue);
        this.mBorderCornerPaint = companion.getNewPaintOrNull(options.borderCornerThickness, options.borderCornerColor);
        this.mGuidelinePaint = companion.getNewPaintOrNull(options.guidelinesThickness, options.guidelinesColor);
        this.mBackgroundPaint = companion.getNewPaint(options.backgroundColor);
        this.textLabelPaint = companion.getTextPaint(options);
    }

    private final void initCropWindow() {
        float fMax = Math.max(BitmapUtils.INSTANCE.getRectLeft(this.mBoundsPoints), 0.0f);
        float fMax2 = Math.max(BitmapUtils.INSTANCE.getRectTop(this.mBoundsPoints), 0.0f);
        float fMin = Math.min(BitmapUtils.INSTANCE.getRectRight(this.mBoundsPoints), getWidth());
        float fMin2 = Math.min(BitmapUtils.INSTANCE.getRectBottom(this.mBoundsPoints), getHeight());
        if (fMin <= fMax || fMin2 <= fMax2) {
            return;
        }
        RectF rectF = new RectF();
        this.initializedCropWindow = true;
        float f = this.mInitialCropWindowPaddingRatio;
        float f2 = fMin - fMax;
        float f3 = f * f2;
        float f4 = fMin2 - fMax2;
        float f5 = f * f4;
        if (this.mInitialCropWindowRect.width() > 0 && this.mInitialCropWindowRect.height() > 0) {
            rectF.left = (this.mInitialCropWindowRect.left / this.mCropWindowHandler.getMScaleFactorWidth()) + fMax;
            rectF.top = (this.mInitialCropWindowRect.top / this.mCropWindowHandler.getMScaleFactorHeight()) + fMax2;
            rectF.right = rectF.left + (this.mInitialCropWindowRect.width() / this.mCropWindowHandler.getMScaleFactorWidth());
            rectF.bottom = rectF.top + (this.mInitialCropWindowRect.height() / this.mCropWindowHandler.getMScaleFactorHeight());
            rectF.left = Math.max(fMax, rectF.left);
            rectF.top = Math.max(fMax2, rectF.top);
            rectF.right = Math.min(fMin, rectF.right);
            rectF.bottom = Math.min(fMin2, rectF.bottom);
        } else if (!this.isFixAspectRatio || fMin <= fMax || fMin2 <= fMax2) {
            rectF.left = fMax + f3;
            rectF.top = fMax2 + f5;
            rectF.right = fMin - f3;
            rectF.bottom = fMin2 - f5;
        } else if (f2 / f4 > this.mTargetAspectRatio) {
            rectF.top = fMax2 + f5;
            rectF.bottom = fMin2 - f5;
            float width = getWidth() / 2.0f;
            this.mTargetAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
            float fMax3 = Math.max(this.mCropWindowHandler.getMinCropWidth(), rectF.height() * this.mTargetAspectRatio) / 2.0f;
            rectF.left = width - fMax3;
            rectF.right = width + fMax3;
        } else {
            rectF.left = fMax + f3;
            rectF.right = fMin - f3;
            float height = getHeight() / 2.0f;
            float fMax4 = Math.max(this.mCropWindowHandler.getMinCropHeight(), rectF.width() / this.mTargetAspectRatio) / 2.0f;
            rectF.top = height - fMax4;
            rectF.bottom = height + fMax4;
        }
        fixCropWindowRectByRules(rectF);
        this.mCropWindowHandler.setRect(rectF);
    }

    private final void fixCropWindowRectByRules(RectF rect) {
        if (rect.width() < this.mCropWindowHandler.getMinCropWidth()) {
            float minCropWidth = (this.mCropWindowHandler.getMinCropWidth() - rect.width()) / 2;
            rect.left -= minCropWidth;
            rect.right += minCropWidth;
        }
        if (rect.height() < this.mCropWindowHandler.getMinCropHeight()) {
            float minCropHeight = (this.mCropWindowHandler.getMinCropHeight() - rect.height()) / 2;
            rect.top -= minCropHeight;
            rect.bottom += minCropHeight;
        }
        if (rect.width() > this.mCropWindowHandler.getMaxCropWidth()) {
            float fWidth = (rect.width() - this.mCropWindowHandler.getMaxCropWidth()) / 2;
            rect.left += fWidth;
            rect.right -= fWidth;
        }
        if (rect.height() > this.mCropWindowHandler.getMaxCropHeight()) {
            float fHeight = (rect.height() - this.mCropWindowHandler.getMaxCropHeight()) / 2;
            rect.top += fHeight;
            rect.bottom -= fHeight;
        }
        calculateBounds(rect);
        if (this.mCalcBounds.width() > 0.0f && this.mCalcBounds.height() > 0.0f) {
            float fMax = Math.max(this.mCalcBounds.left, 0.0f);
            float fMax2 = Math.max(this.mCalcBounds.top, 0.0f);
            float fMin = Math.min(this.mCalcBounds.right, getWidth());
            float fMin2 = Math.min(this.mCalcBounds.bottom, getHeight());
            if (rect.left < fMax) {
                rect.left = fMax;
            }
            if (rect.top < fMax2) {
                rect.top = fMax2;
            }
            if (rect.right > fMin) {
                rect.right = fMin;
            }
            if (rect.bottom > fMin2) {
                rect.bottom = fMin2;
            }
        }
        if (!this.isFixAspectRatio || Math.abs(rect.width() - (rect.height() * this.mTargetAspectRatio)) <= 0.1d) {
            return;
        }
        if (rect.width() > rect.height() * this.mTargetAspectRatio) {
            float fAbs = Math.abs((rect.height() * this.mTargetAspectRatio) - rect.width()) / 2;
            rect.left += fAbs;
            rect.right -= fAbs;
        } else {
            float fAbs2 = Math.abs((rect.width() / this.mTargetAspectRatio) - rect.height()) / 2;
            rect.top += fAbs2;
            rect.bottom -= fAbs2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawBackground(canvas);
        if (this.mCropWindowHandler.showGuidelines()) {
            if (this.guidelines == CropImageView.Guidelines.ON) {
                drawGuidelines(canvas);
            } else if (this.guidelines == CropImageView.Guidelines.ON_TOUCH && this.mMoveHandler != null) {
                drawGuidelines(canvas);
            }
        }
        Companion companion = INSTANCE;
        CropImageOptions cropImageOptions = this.mOptions;
        float f = cropImageOptions != null ? cropImageOptions.borderCornerThickness : 0.0f;
        CropImageOptions cropImageOptions2 = this.mOptions;
        this.mBorderCornerPaint = companion.getNewPaintOrNull(f, cropImageOptions2 != null ? cropImageOptions2.borderCornerColor : -1);
        drawCropLabelText(canvas);
        drawBorders(canvas);
        drawCorners(canvas);
    }

    private final void drawCropLabelText(Canvas canvas) {
        if (this.isCropLabelEnabled) {
            RectF rect = this.mCropWindowHandler.getRect();
            float f = (rect.left + rect.right) / 2;
            float f2 = rect.top - 50;
            Paint paint = this.textLabelPaint;
            if (paint != null) {
                paint.setTextSize(this.cropLabelTextSize);
                paint.setColor(this.cropLabelTextColor);
            }
            String str = this.cropLabelText;
            Paint paint2 = this.textLabelPaint;
            Intrinsics.checkNotNull(paint2);
            canvas.drawText(str, f, f2, paint2);
            canvas.save();
        }
    }

    private final void drawBackground(Canvas canvas) {
        RectF rect = this.mCropWindowHandler.getRect();
        float fMax = Math.max(BitmapUtils.INSTANCE.getRectLeft(this.mBoundsPoints), 0.0f);
        float fMax2 = Math.max(BitmapUtils.INSTANCE.getRectTop(this.mBoundsPoints), 0.0f);
        float fMin = Math.min(BitmapUtils.INSTANCE.getRectRight(this.mBoundsPoints), getWidth());
        float fMin2 = Math.min(BitmapUtils.INSTANCE.getRectBottom(this.mBoundsPoints), getHeight());
        CropImageView.CropShape cropShape = this.cropShape;
        int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i == 4) {
                this.mPath.reset();
                if (CommonVersionCheck.INSTANCE.isAtLeastJ18()) {
                    this.mDrawRect.set(rect.left, rect.top, rect.right, rect.bottom);
                } else {
                    float f = 2;
                    this.mDrawRect.set(rect.left + f, rect.top + f, rect.right - f, rect.bottom - f);
                }
                this.mPath.addOval(this.mDrawRect, Path.Direction.CW);
                canvas.save();
                if (CommonVersionCheck.INSTANCE.isAtLeastO26()) {
                    canvas.clipOutPath(this.mPath);
                } else {
                    canvas.clipPath(this.mPath, Region.Op.XOR);
                }
                Paint paint = this.mBackgroundPaint;
                Intrinsics.checkNotNull(paint);
                canvas.drawRect(fMax, fMax2, fMin, fMin2, paint);
                canvas.restore();
                return;
            }
            throw new IllegalStateException("Unrecognized crop shape");
        }
        if (!isNonStraightAngleRotated() || !CommonVersionCheck.INSTANCE.isAtLeastJ18()) {
            float f2 = rect.top;
            Paint paint2 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint2);
            canvas.drawRect(fMax, fMax2, fMin, f2, paint2);
            float f3 = rect.bottom;
            Paint paint3 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint3);
            canvas.drawRect(fMax, f3, fMin, fMin2, paint3);
            float f4 = rect.top;
            float f5 = rect.left;
            float f6 = rect.bottom;
            Paint paint4 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint4);
            canvas.drawRect(fMax, f4, f5, f6, paint4);
            float f7 = rect.right;
            float f8 = rect.top;
            float f9 = rect.bottom;
            Paint paint5 = this.mBackgroundPaint;
            Intrinsics.checkNotNull(paint5);
            canvas.drawRect(f7, f8, fMin, f9, paint5);
            return;
        }
        this.mPath.reset();
        Path path = this.mPath;
        float[] fArr = this.mBoundsPoints;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.mPath;
        float[] fArr2 = this.mBoundsPoints;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.mPath;
        float[] fArr3 = this.mBoundsPoints;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.mPath;
        float[] fArr4 = this.mBoundsPoints;
        path4.lineTo(fArr4[6], fArr4[7]);
        this.mPath.close();
        canvas.save();
        if (CommonVersionCheck.INSTANCE.isAtLeastO26()) {
            canvas.clipOutPath(this.mPath);
        } else {
            canvas.clipPath(this.mPath, Region.Op.INTERSECT);
        }
        canvas.clipRect(rect, Region.Op.XOR);
        Paint paint6 = this.mBackgroundPaint;
        Intrinsics.checkNotNull(paint6);
        canvas.drawRect(fMax, fMax2, fMin, fMin2, paint6);
        canvas.restore();
    }

    private final void drawGuidelines(Canvas canvas) {
        float strokeWidth;
        if (this.mGuidelinePaint != null) {
            Paint paint = this.mBorderPaint;
            if (paint != null) {
                Intrinsics.checkNotNull(paint);
                strokeWidth = paint.getStrokeWidth();
            } else {
                strokeWidth = 0.0f;
            }
            RectF rect = this.mCropWindowHandler.getRect();
            rect.inset(strokeWidth, strokeWidth);
            float f = 3;
            float fWidth = rect.width() / f;
            float fHeight = rect.height() / f;
            CropImageView.CropShape cropShape = this.cropShape;
            int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                float f2 = rect.left + fWidth;
                float f3 = rect.right - fWidth;
                float f4 = rect.top;
                float f5 = rect.bottom;
                Paint paint2 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint2);
                canvas.drawLine(f2, f4, f2, f5, paint2);
                float f6 = rect.top;
                float f7 = rect.bottom;
                Paint paint3 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint3);
                canvas.drawLine(f3, f6, f3, f7, paint3);
                float f8 = rect.top + fHeight;
                float f9 = rect.bottom - fHeight;
                float f10 = rect.left;
                float f11 = rect.right;
                Paint paint4 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint4);
                canvas.drawLine(f10, f8, f11, f8, paint4);
                float f12 = rect.left;
                float f13 = rect.right;
                Paint paint5 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint5);
                canvas.drawLine(f12, f9, f13, f9, paint5);
                return;
            }
            if (i == 4) {
                float f14 = 2;
                float fWidth2 = (rect.width() / f14) - strokeWidth;
                float fHeight2 = (rect.height() / f14) - strokeWidth;
                float f15 = rect.left + fWidth;
                float f16 = rect.right - fWidth;
                float fSin = (float) (fHeight2 * Math.sin(Math.acos((fWidth2 - fWidth) / fWidth2)));
                float f17 = (rect.top + fHeight2) - fSin;
                float f18 = (rect.bottom - fHeight2) + fSin;
                Paint paint6 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint6);
                canvas.drawLine(f15, f17, f15, f18, paint6);
                float f19 = (rect.top + fHeight2) - fSin;
                float f20 = (rect.bottom - fHeight2) + fSin;
                Paint paint7 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint7);
                canvas.drawLine(f16, f19, f16, f20, paint7);
                float f21 = rect.top + fHeight;
                float f22 = rect.bottom - fHeight;
                float fCos = (float) (fWidth2 * Math.cos(Math.asin((fHeight2 - fHeight) / fHeight2)));
                float f23 = (rect.left + fWidth2) - fCos;
                float f24 = (rect.right - fWidth2) + fCos;
                Paint paint8 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint8);
                canvas.drawLine(f23, f21, f24, f21, paint8);
                float f25 = (rect.left + fWidth2) - fCos;
                float f26 = (rect.right - fWidth2) + fCos;
                Paint paint9 = this.mGuidelinePaint;
                Intrinsics.checkNotNull(paint9);
                canvas.drawLine(f25, f22, f26, f22, paint9);
                return;
            }
            throw new IllegalStateException("Unrecognized crop shape");
        }
    }

    private final void drawBorders(Canvas canvas) {
        Paint paint = this.mBorderPaint;
        if (paint != null) {
            Intrinsics.checkNotNull(paint);
            float strokeWidth = paint.getStrokeWidth();
            RectF rect = this.mCropWindowHandler.getRect();
            float f = strokeWidth / 2;
            rect.inset(f, f);
            CropImageView.CropShape cropShape = this.cropShape;
            int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                Paint paint2 = this.mBorderPaint;
                Intrinsics.checkNotNull(paint2);
                canvas.drawRect(rect, paint2);
            } else {
                if (i == 4) {
                    Paint paint3 = this.mBorderPaint;
                    Intrinsics.checkNotNull(paint3);
                    canvas.drawOval(rect, paint3);
                    return;
                }
                throw new IllegalStateException("Unrecognized crop shape");
            }
        }
    }

    private final void drawCorners(Canvas canvas) {
        float strokeWidth;
        if (this.mBorderCornerPaint != null) {
            Paint paint = this.mBorderPaint;
            if (paint != null) {
                Intrinsics.checkNotNull(paint);
                strokeWidth = paint.getStrokeWidth();
            } else {
                strokeWidth = 0.0f;
            }
            Paint paint2 = this.mBorderCornerPaint;
            Intrinsics.checkNotNull(paint2);
            float strokeWidth2 = paint2.getStrokeWidth();
            float f = 2;
            float f2 = (strokeWidth2 - strokeWidth) / f;
            float f3 = strokeWidth2 / f;
            float f4 = f3 + f2;
            CropImageView.CropShape cropShape = this.cropShape;
            int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                f3 += this.mBorderCornerOffset;
            } else if (i != 4) {
                throw new IllegalStateException("Unrecognized crop shape");
            }
            RectF rect = this.mCropWindowHandler.getRect();
            rect.inset(f3, f3);
            drawCornerBasedOnShape(canvas, rect, f2, f4);
            if (this.cornerShape == CropImageView.CropCornerShape.OVAL) {
                Integer num = this.mCircleCornerFillColor;
                this.mBorderCornerPaint = num != null ? INSTANCE.getNewPaintWithFill(num.intValue()) : null;
                drawCornerBasedOnShape(canvas, rect, f2, f4);
            }
        }
    }

    private final void drawCornerBasedOnShape(Canvas canvas, RectF rect, float cornerOffset, float cornerExtension) {
        CropImageView.CropShape cropShape = this.cropShape;
        int i = cropShape == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
        if (i == 1) {
            drawCornerShape(canvas, rect, cornerOffset, cornerExtension, this.mCropCornerRadius);
            return;
        }
        if (i == 2) {
            float fCenterX = rect.centerX() - this.mBorderCornerLength;
            float f = rect.top - cornerOffset;
            float fCenterX2 = rect.centerX() + this.mBorderCornerLength;
            float f2 = rect.top - cornerOffset;
            Paint paint = this.mBorderCornerPaint;
            Intrinsics.checkNotNull(paint);
            canvas.drawLine(fCenterX, f, fCenterX2, f2, paint);
            float fCenterX3 = rect.centerX() - this.mBorderCornerLength;
            float f3 = rect.bottom + cornerOffset;
            float fCenterX4 = rect.centerX() + this.mBorderCornerLength;
            float f4 = rect.bottom + cornerOffset;
            Paint paint2 = this.mBorderCornerPaint;
            Intrinsics.checkNotNull(paint2);
            canvas.drawLine(fCenterX3, f3, fCenterX4, f4, paint2);
            return;
        }
        if (i != 3) {
            if (i == 4) {
                drawLineShape(canvas, rect, cornerOffset, cornerExtension);
                return;
            }
            throw new IllegalStateException("Unrecognized crop shape");
        }
        float f5 = rect.left - cornerOffset;
        float fCenterY = rect.centerY() - this.mBorderCornerLength;
        float f6 = rect.left - cornerOffset;
        float fCenterY2 = rect.centerY() + this.mBorderCornerLength;
        Paint paint3 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawLine(f5, fCenterY, f6, fCenterY2, paint3);
        float f7 = rect.right + cornerOffset;
        float fCenterY3 = rect.centerY() - this.mBorderCornerLength;
        float f8 = rect.right + cornerOffset;
        float fCenterY4 = rect.centerY() + this.mBorderCornerLength;
        Paint paint4 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawLine(f7, fCenterY3, f8, fCenterY4, paint4);
    }

    private final void drawLineShape(Canvas canvas, RectF rect, float cornerOffset, float cornerExtension) {
        float f = rect.left - cornerOffset;
        float f2 = rect.top - cornerExtension;
        float f3 = rect.left - cornerOffset;
        float f4 = rect.top + this.mBorderCornerLength;
        Paint paint = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawLine(f, f2, f3, f4, paint);
        float f5 = rect.left - cornerExtension;
        float f6 = rect.top - cornerOffset;
        float f7 = rect.left + this.mBorderCornerLength;
        float f8 = rect.top - cornerOffset;
        Paint paint2 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawLine(f5, f6, f7, f8, paint2);
        float f9 = rect.right + cornerOffset;
        float f10 = rect.top - cornerExtension;
        float f11 = rect.right + cornerOffset;
        float f12 = rect.top + this.mBorderCornerLength;
        Paint paint3 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawLine(f9, f10, f11, f12, paint3);
        float f13 = rect.right + cornerExtension;
        float f14 = rect.top - cornerOffset;
        float f15 = rect.right - this.mBorderCornerLength;
        float f16 = rect.top - cornerOffset;
        Paint paint4 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawLine(f13, f14, f15, f16, paint4);
        float f17 = rect.left - cornerOffset;
        float f18 = rect.bottom + cornerExtension;
        float f19 = rect.left - cornerOffset;
        float f20 = rect.bottom - this.mBorderCornerLength;
        Paint paint5 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint5);
        canvas.drawLine(f17, f18, f19, f20, paint5);
        float f21 = rect.left - cornerExtension;
        float f22 = rect.bottom + cornerOffset;
        float f23 = rect.left + this.mBorderCornerLength;
        float f24 = rect.bottom + cornerOffset;
        Paint paint6 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint6);
        canvas.drawLine(f21, f22, f23, f24, paint6);
        float f25 = rect.right + cornerOffset;
        float f26 = rect.bottom + cornerExtension;
        float f27 = rect.right + cornerOffset;
        float f28 = rect.bottom - this.mBorderCornerLength;
        Paint paint7 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint7);
        canvas.drawLine(f25, f26, f27, f28, paint7);
        float f29 = rect.right + cornerExtension;
        float f30 = rect.bottom + cornerOffset;
        float f31 = rect.right - this.mBorderCornerLength;
        float f32 = rect.bottom + cornerOffset;
        Paint paint8 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint8);
        canvas.drawLine(f29, f30, f31, f32, paint8);
    }

    private final void drawCornerShape(Canvas canvas, RectF rect, float cornerOffset, float cornerExtension, float radius) {
        CropImageView.CropCornerShape cropCornerShape = this.cornerShape;
        int i = cropCornerShape == null ? -1 : WhenMappings.$EnumSwitchMapping$1[cropCornerShape.ordinal()];
        if (i == 1) {
            drawCircleShape(canvas, rect, cornerOffset, cornerExtension, radius);
        } else {
            if (i != 2) {
                return;
            }
            drawLineShape(canvas, rect, cornerOffset, cornerExtension);
        }
    }

    private final void drawCircleShape(Canvas canvas, RectF rect, float cornerOffset, float cornerExtension, float radius) {
        float f = rect.left - cornerExtension;
        float f2 = rect.top - cornerExtension;
        Paint paint = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawCircle(f, f2, radius, paint);
        float f3 = rect.right + cornerExtension;
        float f4 = rect.top - cornerExtension;
        Paint paint2 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawCircle(f3, f4, radius, paint2);
        float f5 = rect.left - cornerExtension;
        float f6 = rect.bottom + cornerExtension;
        Paint paint3 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawCircle(f5, f6, radius, paint3);
        float f7 = rect.right + cornerExtension;
        float f8 = rect.bottom + cornerExtension;
        Paint paint4 = this.mBorderCornerPaint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawCircle(f7, f8, radius, paint4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        ScaleGestureDetector scaleGestureDetector;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled()) {
            return false;
        }
        if (this.mMultiTouchEnabled && (scaleGestureDetector = this.mScaleDetector) != null) {
            scaleGestureDetector.onTouchEvent(event);
        }
        int action = event.getAction();
        if (action == 0) {
            onActionDown(event.getX(), event.getY());
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            onActionUp();
        } else if (action != 2) {
            if (action != 3) {
                return false;
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            onActionUp();
        } else {
            onActionMove(event.getX(), event.getY());
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    private final void onActionDown(float x, float y) {
        CropWindowHandler cropWindowHandler = this.mCropWindowHandler;
        float f = this.mTouchRadius;
        CropImageView.CropShape cropShape = this.cropShape;
        Intrinsics.checkNotNull(cropShape);
        CropWindowMoveHandler moveHandler = cropWindowHandler.getMoveHandler(x, y, f, cropShape, this.mCenterMoveEnabled);
        this.mMoveHandler = moveHandler;
        if (moveHandler != null) {
            invalidate();
        }
    }

    private final void onActionUp() {
        if (this.mMoveHandler != null) {
            this.mMoveHandler = null;
            callOnCropWindowChanged(false);
            invalidate();
        }
    }

    private final void onActionMove(float x, float y) {
        if (this.mMoveHandler != null) {
            float f = this.mSnapRadius;
            RectF rect = this.mCropWindowHandler.getRect();
            if (calculateBounds(rect)) {
                f = 0.0f;
            }
            CropWindowMoveHandler cropWindowMoveHandler = this.mMoveHandler;
            Intrinsics.checkNotNull(cropWindowMoveHandler);
            cropWindowMoveHandler.move(rect, x, y, this.mCalcBounds, this.mViewWidth, this.mViewHeight, f, this.isFixAspectRatio, this.mTargetAspectRatio);
            this.mCropWindowHandler.setRect(rect);
            callOnCropWindowChanged(true);
            invalidate();
        }
    }

    private final boolean calculateBounds(RectF rect) {
        float f;
        float f2;
        float rectLeft = BitmapUtils.INSTANCE.getRectLeft(this.mBoundsPoints);
        float rectTop = BitmapUtils.INSTANCE.getRectTop(this.mBoundsPoints);
        float rectRight = BitmapUtils.INSTANCE.getRectRight(this.mBoundsPoints);
        float rectBottom = BitmapUtils.INSTANCE.getRectBottom(this.mBoundsPoints);
        if (!isNonStraightAngleRotated()) {
            this.mCalcBounds.set(rectLeft, rectTop, rectRight, rectBottom);
            return false;
        }
        float[] fArr = this.mBoundsPoints;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        if (f8 < f4) {
            float f9 = fArr[3];
            if (f4 < f9) {
                float f10 = fArr[2];
                f4 = f6;
                f2 = f7;
                f6 = f9;
                f = f8;
                f5 = f10;
                f3 = f5;
            } else {
                f3 = fArr[2];
                f2 = f5;
                f5 = f3;
                f6 = f4;
                f4 = f9;
                f = f6;
            }
        } else {
            f = fArr[3];
            if (f4 > f) {
                f2 = fArr[2];
                f5 = f7;
                f6 = f8;
            } else {
                f2 = f3;
                f = f4;
                f3 = f7;
                f4 = f8;
            }
        }
        float f11 = (f4 - f) / (f3 - f2);
        float f12 = (-1.0f) / f11;
        float f13 = f - (f11 * f2);
        float f14 = f - (f2 * f12);
        float f15 = f6 - (f11 * f5);
        float f16 = f6 - (f5 * f12);
        float fCenterY = (rect.centerY() - rect.top) / (rect.centerX() - rect.left);
        float f17 = -fCenterY;
        float f18 = rect.top - (rect.left * fCenterY);
        float f19 = rect.top - (rect.right * f17);
        float f20 = f11 - fCenterY;
        float f21 = (f18 - f13) / f20;
        if (f21 >= rect.right) {
            f21 = rectLeft;
        }
        float fMax = Math.max(rectLeft, f21);
        float f22 = (f18 - f14) / (f12 - fCenterY);
        if (f22 >= rect.right) {
            f22 = fMax;
        }
        float fMax2 = Math.max(fMax, f22);
        float f23 = f12 - f17;
        float f24 = (f19 - f16) / f23;
        if (f24 >= rect.right) {
            f24 = fMax2;
        }
        float fMax3 = Math.max(fMax2, f24);
        float f25 = (f19 - f14) / f23;
        if (f25 <= rect.left) {
            f25 = rectRight;
        }
        float fMin = Math.min(rectRight, f25);
        float f26 = (f19 - f15) / (f11 - f17);
        if (f26 <= rect.left) {
            f26 = fMin;
        }
        float fMin2 = Math.min(fMin, f26);
        float f27 = (f18 - f15) / f20;
        if (f27 <= rect.left) {
            f27 = fMin2;
        }
        float fMin3 = Math.min(fMin2, f27);
        float fMax4 = Math.max(rectTop, Math.max((f11 * fMax3) + f13, (f12 * fMin3) + f14));
        float fMin4 = Math.min(rectBottom, Math.min((f12 * fMax3) + f16, (f11 * fMin3) + f15));
        this.mCalcBounds.left = fMax3;
        this.mCalcBounds.top = fMax4;
        this.mCalcBounds.right = fMin3;
        this.mCalcBounds.bottom = fMin4;
        return true;
    }

    private final boolean isNonStraightAngleRotated() {
        float[] fArr = this.mBoundsPoints;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private final void callOnCropWindowChanged(boolean inProgress) {
        try {
            CropWindowChangeListener cropWindowChangeListener = this.mCropWindowChangeListener;
            if (cropWindowChangeListener != null) {
                cropWindowChangeListener.onCropWindowChanged(inProgress);
            }
        } catch (Exception e) {
            Log.e("AIC", "Exception in crop window changed", e);
        }
    }

    /* compiled from: CropOverlayView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"Lcom/canhub/cropper/CropOverlayView$ScaleListener;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "(Lcom/canhub/cropper/CropOverlayView;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            RectF rect = CropOverlayView.this.mCropWindowHandler.getRect();
            float focusX = detector.getFocusX();
            float focusY = detector.getFocusY();
            float f = 2;
            float currentSpanY = detector.getCurrentSpanY() / f;
            float currentSpanX = detector.getCurrentSpanX() / f;
            float f2 = focusY - currentSpanY;
            float f3 = focusX - currentSpanX;
            float f4 = focusX + currentSpanX;
            float f5 = focusY + currentSpanY;
            if (f3 >= f4 || f2 > f5 || f3 < 0.0f || f4 > CropOverlayView.this.mCropWindowHandler.getMaxCropWidth() || f2 < 0.0f || f5 > CropOverlayView.this.mCropWindowHandler.getMaxCropHeight()) {
                return true;
            }
            rect.set(f3, f2, f4, f5);
            CropOverlayView.this.mCropWindowHandler.setRect(rect);
            CropOverlayView.this.invalidate();
            return true;
        }
    }
}
