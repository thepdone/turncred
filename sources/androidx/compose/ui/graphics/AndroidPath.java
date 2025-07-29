package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.Path;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPath.android.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J \u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001dH\u0016J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\u0006\u0010%\u001a\u00020&H\u0016J(\u00102\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u001bH\u0016J8\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001fH\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001fH\u0016J\u0018\u0010@\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001fH\u0016J*\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020EH\u0016ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ(\u0010H\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fH\u0016J(\u0010I\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fH\u0016J8\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020\u001fH\u0016J\u0018\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fH\u0016J\u0018\u0010T\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fH\u0016J(\u0010U\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001fH\u0016J(\u0010V\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001fH\u0016J\b\u0010W\u001a\u00020\u001bH\u0016J\b\u0010X\u001a\u00020\u001bH\u0016J\u001a\u0010Y\u001a\u00020\u001b2\u0006\u0010Z\u001a\u00020[H\u0016ø\u0001\u0000¢\u0006\u0004\b\\\u0010]J\u001a\u0010^\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001dH\u0002R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006b"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "getInternalPath", "()Landroid/graphics/Path;", "isConvex", "", "isConvex$annotations", "()V", "()Z", "isEmpty", "mMatrix", "Landroid/graphics/Matrix;", "radii", "", "rectF", "Landroid/graphics/RectF;", "addArc", "", "oval", "Landroidx/compose/ui/geometry/Rect;", "startAngleDegrees", "", "sweepAngleDegrees", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addOval", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addRect", "rect", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "arcTo", "forceMoveTo", "close", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "getBounds", "lineTo", "x", "y", "moveTo", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "quadraticBezierTo", "quadraticTo", "relativeCubicTo", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "relativeLineTo", "dx", "dy", "relativeMoveTo", "relativeQuadraticBezierTo", "relativeQuadraticTo", "reset", "rewind", ViewProps.TRANSFORM, "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "translate-k-4lQ0M", "(J)V", "validateRectangle", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidPath implements Path {
    private final android.graphics.Path internalPath;
    private android.graphics.Matrix mMatrix;
    private float[] radii;
    private RectF rectF;

    public AndroidPath() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void isConvex$annotations() {
    }

    public AndroidPath(android.graphics.Path path) {
        this.internalPath = path;
    }

    public /* synthetic */ AndroidPath(android.graphics.Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new android.graphics.Path() : path);
    }

    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public int mo2167getFillTypeRgk1Os() {
        if (this.internalPath.getFillType() == Path.FillType.EVEN_ODD) {
            return PathFillType.INSTANCE.m2559getEvenOddRgk1Os();
        }
        return PathFillType.INSTANCE.m2560getNonZeroRgk1Os();
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public void mo2169setFillTypeoQ8Xj4U(int i) {
        Path.FillType fillType;
        android.graphics.Path path = this.internalPath;
        if (PathFillType.m2555equalsimpl0(i, PathFillType.INSTANCE.m2559getEvenOddRgk1Os())) {
            fillType = Path.FillType.EVEN_ODD;
        } else {
            fillType = Path.FillType.WINDING;
        }
        path.setFillType(fillType);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void moveTo(float x, float y) {
        this.internalPath.moveTo(x, y);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeMoveTo(float dx, float dy) {
        this.internalPath.rMoveTo(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void lineTo(float x, float y) {
        this.internalPath.lineTo(x, y);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeLineTo(float dx, float dy) {
        this.internalPath.rLineTo(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticBezierTo(float x1, float y1, float x2, float y2) {
        this.internalPath.quadTo(x1, y1, x2, y2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticTo(float x1, float y1, float x2, float y2) {
        this.internalPath.quadTo(x1, y1, x2, y2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticBezierTo(float dx1, float dy1, float dx2, float dy2) {
        this.internalPath.rQuadTo(dx1, dy1, dx2, dy2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticTo(float dx1, float dy1, float dx2, float dy2) {
        this.internalPath.rQuadTo(dx1, dy1, dx2, dy2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.internalPath.cubicTo(x1, y1, x2, y2, x3, y3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeCubicTo(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3) {
        this.internalPath.rCubicTo(dx1, dy1, dx2, dy2, dx3, dy3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void arcTo(Rect rect, float startAngleDegrees, float sweepAngleDegrees, boolean forceMoveTo) {
        float left = rect.getLeft();
        float top = rect.getTop();
        float right = rect.getRight();
        float bottom = rect.getBottom();
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(left, top, right, bottom);
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.arcTo(rectF2, startAngleDegrees, sweepAngleDegrees, forceMoveTo);
    }

    @Override // androidx.compose.ui.graphics.Path
    public /* synthetic */ void addRect(Rect rect) {
        addRect(rect, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(Rect rect, Path.Direction direction) {
        validateRectangle(rect);
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addRect(rectF2, AndroidPath_androidKt.toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public /* synthetic */ void addOval(Rect oval) {
        addOval(oval, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(Rect oval, Path.Direction direction) {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(oval.getLeft(), oval.getTop(), oval.getRight(), oval.getBottom());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addOval(rectF2, AndroidPath_androidKt.toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public /* synthetic */ void addRoundRect(RoundRect roundRect) {
        addRoundRect(roundRect, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(RoundRect roundRect, Path.Direction direction) {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        if (this.radii == null) {
            this.radii = new float[8];
        }
        float[] fArr = this.radii;
        Intrinsics.checkNotNull(fArr);
        fArr[0] = CornerRadius.m2010getXimpl(roundRect.m2085getTopLeftCornerRadiuskKHJgLs());
        fArr[1] = CornerRadius.m2011getYimpl(roundRect.m2085getTopLeftCornerRadiuskKHJgLs());
        fArr[2] = CornerRadius.m2010getXimpl(roundRect.m2086getTopRightCornerRadiuskKHJgLs());
        fArr[3] = CornerRadius.m2011getYimpl(roundRect.m2086getTopRightCornerRadiuskKHJgLs());
        fArr[4] = CornerRadius.m2010getXimpl(roundRect.m2084getBottomRightCornerRadiuskKHJgLs());
        fArr[5] = CornerRadius.m2011getYimpl(roundRect.m2084getBottomRightCornerRadiuskKHJgLs());
        fArr[6] = CornerRadius.m2010getXimpl(roundRect.m2083getBottomLeftCornerRadiuskKHJgLs());
        fArr[7] = CornerRadius.m2011getYimpl(roundRect.m2083getBottomLeftCornerRadiuskKHJgLs());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        float[] fArr2 = this.radii;
        Intrinsics.checkNotNull(fArr2);
        path.addRoundRect(rectF2, fArr2, AndroidPath_androidKt.toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArcRad(Rect oval, float startAngleRadians, float sweepAngleRadians) {
        addArc(oval, DegreesKt.degrees(startAngleRadians), DegreesKt.degrees(sweepAngleRadians));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArc(Rect oval, float startAngleDegrees, float sweepAngleDegrees) {
        validateRectangle(oval);
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(oval.getLeft(), oval.getTop(), oval.getRight(), oval.getBottom());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addArc(rectF2, startAngleDegrees, sweepAngleDegrees);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public void mo2166addPathUv8p0NA(Path path, long offset) {
        android.graphics.Path path2 = this.internalPath;
        if (path instanceof AndroidPath) {
            path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m2035getXimpl(offset), Offset.m2036getYimpl(offset));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void rewind() {
        this.internalPath.rewind();
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void mo2171translatek4lQ0M(long offset) {
        android.graphics.Matrix matrix = this.mMatrix;
        if (matrix == null) {
            this.mMatrix = new android.graphics.Matrix();
        } else {
            Intrinsics.checkNotNull(matrix);
            matrix.reset();
        }
        android.graphics.Matrix matrix2 = this.mMatrix;
        Intrinsics.checkNotNull(matrix2);
        matrix2.setTranslate(Offset.m2035getXimpl(offset), Offset.m2036getYimpl(offset));
        android.graphics.Path path = this.internalPath;
        android.graphics.Matrix matrix3 = this.mMatrix;
        Intrinsics.checkNotNull(matrix3);
        path.transform(matrix3);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: transform-58bKbWc, reason: not valid java name */
    public void mo2170transform58bKbWc(float[] matrix) {
        if (this.mMatrix == null) {
            this.mMatrix = new android.graphics.Matrix();
        }
        android.graphics.Matrix matrix2 = this.mMatrix;
        Intrinsics.checkNotNull(matrix2);
        AndroidMatrixConversions_androidKt.m2146setFromEL8BTi8(matrix2, matrix);
        android.graphics.Path path = this.internalPath;
        android.graphics.Matrix matrix3 = this.mMatrix;
        Intrinsics.checkNotNull(matrix3);
        path.transform(matrix3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public Rect getBounds() {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        this.internalPath.computeBounds(rectF, true);
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: op-N5in7k0, reason: not valid java name */
    public boolean mo2168opN5in7k0(Path path1, Path path2, int operation) {
        Path.Op op;
        if (PathOperation.m2565equalsimpl0(operation, PathOperation.INSTANCE.m2569getDifferenceb3I0S0c())) {
            op = Path.Op.DIFFERENCE;
        } else if (PathOperation.m2565equalsimpl0(operation, PathOperation.INSTANCE.m2570getIntersectb3I0S0c())) {
            op = Path.Op.INTERSECT;
        } else if (PathOperation.m2565equalsimpl0(operation, PathOperation.INSTANCE.m2571getReverseDifferenceb3I0S0c())) {
            op = Path.Op.REVERSE_DIFFERENCE;
        } else {
            op = PathOperation.m2565equalsimpl0(operation, PathOperation.INSTANCE.m2572getUnionb3I0S0c()) ? Path.Op.UNION : Path.Op.XOR;
        }
        android.graphics.Path path = this.internalPath;
        if (!(path1 instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path internalPath = ((AndroidPath) path1).getInternalPath();
        if (path2 instanceof AndroidPath) {
            return path.op(internalPath, ((AndroidPath) path2).getInternalPath(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    private final void validateRectangle(Rect rect) {
        if (Float.isNaN(rect.getLeft()) || Float.isNaN(rect.getTop()) || Float.isNaN(rect.getRight()) || Float.isNaN(rect.getBottom())) {
            AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
        }
    }
}
