package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* compiled from: DrawScope.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001ab\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aP\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\\\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a!\u0010#\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\bH\u0086\b\u001a.\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001a:\u0010$\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001aF\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001aB\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aB\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b/\u0010,\u001aB\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00100\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u0010,\u001aJ\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a:\u00106\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001a?\u00107\u001a\u00020\u0001*\u00020\u00022\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", ViewProps.RIGHT, ViewProps.BOTTOM, "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "draw", "density", "Landroidx/compose/ui/unit/Density;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", RRWebVideoEvent.JsonKeys.SIZE, "Landroidx/compose/ui/geometry/Size;", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-ymL40Pk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", ViewProps.SCALE_X, ViewProps.SCALE_Y, "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawScopeKt {
    public static final void inset(DrawScope drawScope, float f, float f2, float f3, float f4, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f2, f3, f4);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawScope.getDrawContext().getTransform().inset(-f, -f2, -f3, -f4);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void inset(DrawScope drawScope, float f, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f, f, f);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            float f2 = -f;
            drawScope.getDrawContext().getTransform().inset(f2, f2, f2, f2);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void translate(DrawScope drawScope, float f, float f2, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().translate(f, f2);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawScope.getDrawContext().getTransform().translate(-f, -f2);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().translate(f, f2);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawScope.getDrawContext().getTransform().translate(-f, -f2);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m2881rotateRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo2832getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2760rotateUv8p0NA(f, j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m2883rotateRadRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo2832getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2760rotateUv8p0NA(DegreesKt.degrees(f), j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m2885scaleFgt4K4Q$default(DrawScope drawScope, float f, float f2, long j, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            j = drawScope.mo2832getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2761scale0AR0LA0(f, f2, j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m2887scaleRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo2832getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2761scale0AR0LA0(f, f, j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m2876clipRectrOu3jXo$default(DrawScope drawScope, float f, float f2, float f3, float f4, int i, Function1 function1, int i2, Object obj) {
        float f5 = (i2 & 1) != 0 ? 0.0f : f;
        float f6 = (i2 & 2) != 0 ? 0.0f : f2;
        if ((i2 & 4) != 0) {
            f3 = Size.m2104getWidthimpl(drawScope.mo2833getSizeNHjbRc());
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = Size.m2101getHeightimpl(drawScope.mo2833getSizeNHjbRc());
        }
        float f8 = f4;
        if ((i2 & 16) != 0) {
            i = ClipOp.INSTANCE.m2265getIntersectrtfAjoo();
        }
        int i3 = i;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2757clipRectN_I0leg(f5, f6, f7, f8, i3);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m2874clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m2265getIntersectrtfAjoo();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2756clipPathmtrdDE(path, i);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void drawIntoCanvas(DrawScope drawScope, Function1<? super Canvas, Unit> function1) {
        function1.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void withTransform(DrawScope drawScope, Function1<? super DrawTransform, Unit> function1, Function1<? super DrawScope, Unit> function12) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            function1.invoke(drawContext.getTransform());
            function12.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: draw-ymL40Pk, reason: not valid java name */
    public static final void m2878drawymL40Pk(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo2754getSizeNHjbRc = drawScope.getDrawContext().mo2754getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo2755setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: draw-ymL40Pk$default, reason: not valid java name */
    public static /* synthetic */ void m2879drawymL40Pk$default(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, GraphicsLayer graphicsLayer, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            graphicsLayer = null;
        }
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo2754getSizeNHjbRc = drawScope.getDrawContext().mo2754getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo2755setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void inset(DrawScope drawScope, float f, float f2, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            float f3 = -f;
            float f4 = -f2;
            drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            float f3 = -f;
            float f4 = -f2;
            drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m2880rotateRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2760rotateUv8p0NA(f, j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m2882rotateRadRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2760rotateUv8p0NA(DegreesKt.degrees(f), j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m2884scaleFgt4K4Q(DrawScope drawScope, float f, float f2, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2761scale0AR0LA0(f, f2, j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m2886scaleRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2761scale0AR0LA0(f, f, j);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m2875clipRectrOu3jXo(DrawScope drawScope, float f, float f2, float f3, float f4, int i, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2757clipRectN_I0leg(f, f2, f3, f4, i);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m2873clipPathKD09W0M(DrawScope drawScope, Path path, int i, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2754getSizeNHjbRc = drawContext.mo2754getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo2756clipPathmtrdDE(path, i);
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawContext.getCanvas().restore();
            drawContext.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use a new overload accepting nullable GraphicsLayer")
    /* renamed from: draw-GRGpd60, reason: not valid java name */
    public static final /* synthetic */ void m2877drawGRGpd60(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, Function1<? super DrawScope, Unit> function1) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo2754getSizeNHjbRc = drawScope.getDrawContext().mo2754getSizeNHjbRc();
        GraphicsLayer graphicsLayer = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo2755setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(null);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo2755setSizeuvyYCjk(jMo2754getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
            InlineMarker.finallyEnd(1);
        }
    }
}
