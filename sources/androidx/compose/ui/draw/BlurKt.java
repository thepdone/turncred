package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Blur.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BlurKt {
    /* renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1911blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m1914boximpl(BlurredEdgeTreatment.INSTANCE.m1921getRectangleGoahg());
        }
        return m1910blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m1920unboximpl());
    }

    /* renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m1910blur1fqSgw(Modifier modifier, final float f, final float f2, final Shape shape) {
        final boolean z;
        final int iM2651getDecal3opZhB0;
        if (shape != null) {
            iM2651getDecal3opZhB0 = TileMode.INSTANCE.m2650getClamp3opZhB0();
            z = true;
        } else {
            z = false;
            iM2651getDecal3opZhB0 = TileMode.INSTANCE.m2651getDecal3opZhB0();
        }
        float f3 = 0;
        return ((Dp.m4736compareTo0680j_4(f, Dp.m4737constructorimpl(f3)) <= 0 || Dp.m4736compareTo0680j_4(f2, Dp.m4737constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                float f4 = graphicsLayerScope.mo694toPx0680j_4(f);
                float f5 = graphicsLayerScope.mo694toPx0680j_4(f2);
                graphicsLayerScope.setRenderEffect((f4 <= 0.0f || f5 <= 0.0f) ? null : RenderEffectKt.m2585BlurEffect3YTHUZs(f4, f5, iM2651getDecal3opZhB0));
                Shape rectangleShape = shape;
                if (rectangleShape == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(rectangleShape);
                graphicsLayerScope.setClip(z);
            }
        });
    }

    /* renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1913blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m1914boximpl(BlurredEdgeTreatment.INSTANCE.m1921getRectangleGoahg());
        }
        return m1912blurF8QBwvs(modifier, f, blurredEdgeTreatment.m1920unboximpl());
    }

    /* renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m1912blurF8QBwvs(Modifier modifier, float f, Shape shape) {
        return m1910blur1fqSgw(modifier, f, f, shape);
    }
}
