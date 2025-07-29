package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XferRoundFilter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/filter/XferRoundFilter;", "", "()V", "xferRoundBitmap", "", "output", "Landroid/graphics/Bitmap;", "source", "enableAntiAliasing", "", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class XferRoundFilter {
    public static final XferRoundFilter INSTANCE = new XferRoundFilter();

    private XferRoundFilter() {
    }

    @JvmStatic
    public static final void xferRoundBitmap(Bitmap output, Bitmap source, boolean enableAntiAliasing) {
        Paint paint;
        Paint paint2;
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(source, "source");
        output.setHasAlpha(true);
        if (enableAntiAliasing) {
            paint = new Paint(1);
            paint2 = new Paint(1);
        } else {
            paint = new Paint();
            paint2 = new Paint();
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float width = source.getWidth() / 2.0f;
        float height = source.getHeight() / 2.0f;
        Canvas canvas = new Canvas(output);
        canvas.drawCircle(width, height, Math.min(width, height), paint);
        canvas.drawBitmap(source, 0.0f, 0.0f, paint2);
    }
}
