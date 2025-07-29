package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: IterativeBoxBlurFilter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J8\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J@\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/imagepipeline/filter/IterativeBoxBlurFilter;", "", "()V", "TAG", "", "bound", "", "x", "l", "h", "boxBlurBitmapInPlace", "", "bitmap", "Landroid/graphics/Bitmap;", "iterations", "radius", "fastBoxBlur", "internalHorizontalBlur", "pixels", "", "outRow", "w", "row", "diameter", "div", "internalVerticalBlur", "outCol", "col", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IterativeBoxBlurFilter {
    public static final IterativeBoxBlurFilter INSTANCE = new IterativeBoxBlurFilter();
    private static final String TAG = "IterativeBoxBlurFilter";

    private final int bound(int x, int l, int h) {
        return x < l ? l : x > h ? h : x;
    }

    private IterativeBoxBlurFilter() {
    }

    @JvmStatic
    public static final void boxBlurBitmapInPlace(Bitmap bitmap, int iterations, int radius) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Preconditions.checkArgument(Boolean.valueOf(bitmap.isMutable()));
        Preconditions.checkArgument(Boolean.valueOf(((float) bitmap.getHeight()) <= 2048.0f));
        Preconditions.checkArgument(Boolean.valueOf(((float) bitmap.getWidth()) <= 2048.0f));
        Preconditions.checkArgument(Boolean.valueOf(radius > 0 && radius <= 25));
        Preconditions.checkArgument(Boolean.valueOf(iterations > 0));
        try {
            INSTANCE.fastBoxBlur(bitmap, iterations, radius);
        } catch (OutOfMemoryError e) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(null, "OOM: %d iterations on %dx%d with %d radius", Arrays.copyOf(new Object[]{Integer.valueOf(iterations), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(radius)}, 4));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            FLog.e(TAG, str);
            throw e;
        }
    }

    private final void fastBoxBlur(Bitmap bitmap, int iterations, int radius) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = radius + 1;
        int i2 = i + radius;
        int[] iArr2 = new int[i2 * 256];
        int i3 = 1;
        while (true) {
            if (i3 >= 256) {
                break;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i] = i3;
                i++;
            }
            i3++;
        }
        int[] iArr3 = new int[Math.max(width, height)];
        int i5 = 0;
        while (i5 < iterations) {
            int i6 = 0;
            while (i6 < height) {
                int i7 = i6;
                internalHorizontalBlur(iArr, iArr3, width, i6, i2, iArr2);
                System.arraycopy(iArr3, 0, iArr, i7 * width, width);
                i6 = i7 + 1;
            }
            int i8 = 0;
            while (i8 < width) {
                int i9 = i8;
                int i10 = i5;
                internalVerticalBlur(iArr, iArr3, width, height, i8, i2, iArr2);
                int i11 = i9;
                for (int i12 = 0; i12 < height; i12++) {
                    iArr[i11] = iArr3[i12];
                    i11 += width;
                }
                i8 = i9 + 1;
                i5 = i10;
            }
            i5++;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    private final void internalHorizontalBlur(int[] pixels, int[] outRow, int w, int row, int diameter, int[] div) {
        int i = w * row;
        int i2 = ((row + 1) * w) - 1;
        int i3 = diameter >> 1;
        int i4 = w + i3;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = -i3; i9 < i4; i9++) {
            int i10 = pixels[bound(i + i9, i, i2)];
            i5 += (i10 >> 16) & 255;
            i6 += (i10 >> 8) & 255;
            i7 += i10 & 255;
            i8 += i10 >>> 24;
            if (i9 >= i3) {
                outRow[i9 - i3] = (div[i8] << 24) | (div[i5] << 16) | (div[i6] << 8) | div[i7];
                int i11 = pixels[bound((i9 - (diameter - 1)) + i, i, i2)];
                i5 -= (i11 >> 16) & 255;
                i6 -= (i11 >> 8) & 255;
                i7 -= i11 & 255;
                i8 -= i11 >>> 24;
            }
        }
    }

    private final void internalVerticalBlur(int[] pixels, int[] outCol, int w, int h, int col, int diameter, int[] div) {
        int i = ((h - 1) * w) + col;
        int i2 = (diameter >> 1) * w;
        int i3 = (diameter - 1) * w;
        int i4 = col - i2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i4 <= i + i2) {
            int i10 = pixels[bound(i4, col, i)];
            i5 += (i10 >> 16) & 255;
            i6 += (i10 >> 8) & 255;
            i7 += i10 & 255;
            i8 += i10 >>> 24;
            if (i4 - i2 >= col) {
                outCol[i9] = (div[i8] << 24) | (div[i5] << 16) | (div[i6] << 8) | div[i7];
                i9++;
                int i11 = pixels[bound(i4 - i3, col, i)];
                i5 -= (i11 >> 16) & 255;
                i6 -= (i11 >> 8) & 255;
                i7 -= i11 & 255;
                i8 -= i11 >>> 24;
            }
            i4 += w;
        }
    }
}
