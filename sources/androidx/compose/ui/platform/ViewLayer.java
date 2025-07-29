package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.jwk.JWKParameterNames;
import io.sentry.rrweb.RRWebVideoEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayer.android.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002noB]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00128\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\b\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020@H\u0014J\u001a\u0010A\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020 H\u0016J\b\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u001a\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020LH\u0016ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020 H\u0016J\"\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020L2\u0006\u0010R\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\u00020\u00102\u0006\u0010K\u001a\u00020XH\u0016ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ0\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u0002072\u0006\u0010^\u001a\u0002072\u0006\u0010_\u001a\u0002072\u0006\u0010`\u001a\u000207H\u0014J\b\u0010a\u001a\u00020\u0010H\u0002J\u001a\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020dH\u0016ø\u0001\u0000¢\u0006\u0004\be\u0010ZJP\u0010f\u001a\u00020\u001028\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u001a\u0010g\u001a\u00020\u00102\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bh\u0010IJ\b\u0010i\u001a\u00020\u0010H\u0016J\u0010\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020\u0010H\u0002R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"RB\u0010\b\u001a6\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020 @BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\u00020.X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u000105X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010+\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006p"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", RRWebVideoEvent.JsonKeys.CONTAINER, "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "drawnWithZ", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mHasOverlappingRendering", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "destroy", "dispatchDraw", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "hasOverlappingRendering", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", ViewProps.POSITION, "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", ViewProps.ON_LAYOUT, "changed", "l", JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, "b", "resetClipBounds", "resize", RRWebVideoEvent.JsonKeys.SIZE, "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", ViewProps.TRANSFORM, "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    private static boolean hasRetrievedMethod;
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;
    private static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder;
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering;
    private long mTransformOrigin;
    private final LayerMatrixCache<View> matrixCache;
    private int mutatedFields;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Function2<View, Matrix, Unit> getMatrix = new Function2<View, Matrix, Unit>() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, Matrix matrix) {
            invoke2(view, matrix);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, Matrix matrix) {
            matrix.set(view.getMatrix());
        }
    };
    private static final ViewOutlineProvider OutlineProvider = new ViewOutlineProvider() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$OutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            Outline androidOutline = ((ViewLayer) view).outlineResolver.getAndroidOutline();
            Intrinsics.checkNotNull(androidOutline);
            outline.set(androidOutline);
        }
    };

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        super(androidComposeView.getContext());
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver();
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.mTransformOrigin = TransformOrigin.INSTANCE.m2668getCenterSzJe1aQ();
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    /* renamed from: isInvalidated, reason: from getter */
    public final boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    private final void setInvalidated(boolean z) {
        if (z != this.isInvalidated) {
            this.isInvalidated = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.layerId;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    /* compiled from: ViewLayer.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final void setCameraDistancePx(float f) {
        setCameraDistance(f * getResources().getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        Function0<Unit> function0;
        int mutatedFields$ui_release = scope.getMutatedFields() | this.mutatedFields;
        if ((mutatedFields$ui_release & 4096) != 0) {
            long jMo2466getTransformOriginSzJe1aQ = scope.getTransformOrigin();
            this.mTransformOrigin = jMo2466getTransformOriginSzJe1aQ;
            setPivotX(TransformOrigin.m2663getPivotFractionXimpl(jMo2466getTransformOriginSzJe1aQ) * getWidth());
            setPivotY(TransformOrigin.m2664getPivotFractionYimpl(this.mTransformOrigin) * getHeight());
        }
        if ((mutatedFields$ui_release & 1) != 0) {
            setScaleX(scope.getScaleX());
        }
        if ((mutatedFields$ui_release & 2) != 0) {
            setScaleY(scope.getScaleY());
        }
        if ((mutatedFields$ui_release & 4) != 0) {
            setAlpha(scope.getAlpha());
        }
        if ((mutatedFields$ui_release & 8) != 0) {
            setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields$ui_release & 16) != 0) {
            setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields$ui_release & 32) != 0) {
            setElevation(scope.getShadowElevation());
        }
        if ((mutatedFields$ui_release & 1024) != 0) {
            setRotation(scope.getRotationZ());
        }
        if ((mutatedFields$ui_release & 256) != 0) {
            setRotationX(scope.getRotationX());
        }
        if ((mutatedFields$ui_release & 512) != 0) {
            setRotationY(scope.getRotationY());
        }
        if ((mutatedFields$ui_release & 2048) != 0) {
            setCameraDistancePx(scope.getCameraDistance());
        }
        boolean z = false;
        boolean z2 = getManualClipPath() != null;
        boolean z3 = scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields$ui_release & 24576) != 0) {
            this.clipToBounds = scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape();
            resetClipBounds();
            setClipToOutline(z3);
        }
        boolean zM4004updateS_szKao = this.outlineResolver.m4004updateS_szKao(scope.getOutline(), scope.getAlpha(), z3, scope.getShadowElevation(), scope.getSize());
        if (this.outlineResolver.getCacheIsDirty()) {
            updateOutlineResolver();
        }
        boolean z4 = getManualClipPath() != null;
        if (z2 != z4 || (z4 && zM4004updateS_szKao)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields$ui_release & Fields.MatrixAffectingFields) != 0) {
            this.matrixCache.invalidate();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if ((mutatedFields$ui_release & 64) != 0) {
                ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this, ColorKt.m2330toArgb8_81llA(scope.getAmbientShadowColor()));
            }
            if ((mutatedFields$ui_release & 128) != 0) {
                ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this, ColorKt.m2330toArgb8_81llA(scope.getSpotShadowColor()));
            }
        }
        if (Build.VERSION.SDK_INT >= 31 && (131072 & mutatedFields$ui_release) != 0) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, scope.getRenderEffect());
        }
        if ((mutatedFields$ui_release & 32768) != 0) {
            int iMo2463getCompositingStrategyNrFUSI = scope.getCompositingStrategy();
            if (CompositingStrategy.m2362equalsimpl0(iMo2463getCompositingStrategyNrFUSI, CompositingStrategy.INSTANCE.m2368getOffscreenNrFUSI())) {
                setLayerType(2, null);
            } else if (CompositingStrategy.m2362equalsimpl0(iMo2463getCompositingStrategyNrFUSI, CompositingStrategy.INSTANCE.m2367getModulateAlphaNrFUSI())) {
                setLayerType(0, null);
                this.mHasOverlappingRendering = z;
            } else {
                setLayerType(0, null);
            }
            z = true;
            this.mHasOverlappingRendering = z;
        }
        this.mutatedFields = scope.getMutatedFields();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo3896isInLayerk4lQ0M(long position) {
        float fM2035getXimpl = Offset.m2035getXimpl(position);
        float fM2036getYimpl = Offset.m2036getYimpl(position);
        if (this.clipToBounds) {
            return 0.0f <= fM2035getXimpl && fM2035getXimpl < ((float) getWidth()) && 0.0f <= fM2036getYimpl && fM2036getYimpl < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.m4003isInOutlinek4lQ0M(position);
        }
        return true;
    }

    private final void updateOutlineResolver() {
        setOutlineProvider(this.outlineResolver.getAndroidOutline() != null ? OutlineProvider : null);
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo3899resizeozmzZPI(long size) {
        int iM4907getWidthimpl = IntSize.m4907getWidthimpl(size);
        int iM4906getHeightimpl = IntSize.m4906getHeightimpl(size);
        if (iM4907getWidthimpl == getWidth() && iM4906getHeightimpl == getHeight()) {
            return;
        }
        setPivotX(TransformOrigin.m2663getPivotFractionXimpl(this.mTransformOrigin) * iM4907getWidthimpl);
        setPivotY(TransformOrigin.m2664getPivotFractionYimpl(this.mTransformOrigin) * iM4906getHeightimpl);
        updateOutlineResolver();
        layout(getLeft(), getTop(), getLeft() + iM4907getWidthimpl, getTop() + iM4906getHeightimpl);
        resetClipBounds();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo3898movegyyYBs(long position) {
        int iM4865getXimpl = IntOffset.m4865getXimpl(position);
        if (iM4865getXimpl != getLeft()) {
            offsetLeftAndRight(iM4865getXimpl - getLeft());
            this.matrixCache.invalidate();
        }
        int iM4866getYimpl = IntOffset.m4866getYimpl(position);
        if (iM4866getYimpl != getTop()) {
            offsetTopAndBottom(iM4866getYimpl - getTop());
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        boolean z = getElevation() > 0.0f;
        this.drawnWithZ = z;
        if (z) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        boolean z;
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (getManualClipPath() == null && canvas.isHardwareAccelerated()) {
            z = false;
        } else {
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
            z = true;
        }
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(androidCanvas, null);
        }
        if (z) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        setInvalidated(false);
    }

    @Override // android.view.View, androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.ownerView.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (!this.isInvalidated || shouldUseDispatchDraw) {
            return;
        }
        INSTANCE.updateDisplayList(this);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo3897mapOffset8S9VItk(long point, boolean inverse) {
        if (inverse) {
            float[] fArrM3980calculateInverseMatrixbWbORWo = this.matrixCache.m3980calculateInverseMatrixbWbORWo(this);
            return fArrM3980calculateInverseMatrixbWbORWo != null ? androidx.compose.ui.graphics.Matrix.m2514mapMKHz9U(fArrM3980calculateInverseMatrixbWbORWo, point) : Offset.INSTANCE.m2049getInfiniteF1C5BW0();
        }
        return androidx.compose.ui.graphics.Matrix.m2514mapMKHz9U(this.matrixCache.m3981calculateMatrixGrdbGEg(this), point);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        if (inverse) {
            float[] fArrM3980calculateInverseMatrixbWbORWo = this.matrixCache.m3980calculateInverseMatrixbWbORWo(this);
            if (fArrM3980calculateInverseMatrixbWbORWo != null) {
                androidx.compose.ui.graphics.Matrix.m2516mapimpl(fArrM3980calculateInverseMatrixbWbORWo, rect);
                return;
            } else {
                rect.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            }
        }
        androidx.compose.ui.graphics.Matrix.m2516mapimpl(this.matrixCache.m3981calculateMatrixGrdbGEg(this), rect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.INSTANCE.m2668getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo3900transform58bKbWc(float[] matrix) {
        androidx.compose.ui.graphics.Matrix.m2525timesAssign58bKbWc(matrix, this.matrixCache.m3981calculateMatrixGrdbGEg(this));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo3895inverseTransform58bKbWc(float[] matrix) {
        float[] fArrM3980calculateInverseMatrixbWbORWo = this.matrixCache.m3980calculateInverseMatrixbWbORWo(this);
        if (fArrM3980calculateInverseMatrixbWbORWo != null) {
            androidx.compose.ui.graphics.Matrix.m2525timesAssign58bKbWc(matrix, fArrM3980calculateInverseMatrixbWbORWo);
        }
    }

    /* compiled from: ViewLayer.android.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", ViewHierarchyConstants.VIEW_KEY, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z) {
            ViewLayer.shouldUseDispatchDraw = z;
        }

        public final void updateDisplayList(View view) {
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.recreateDisplayList;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.recreateDisplayList;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (method2 != null) {
                    method2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }
}
