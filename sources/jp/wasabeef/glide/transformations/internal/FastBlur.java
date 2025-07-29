package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class FastBlur {
    public static Bitmap blur(Bitmap sentBitmap, int radius, boolean canReuseInBitmap) {
        int[] iArr;
        int i = radius;
        Bitmap bitmapCopy = canReuseInBitmap ? sentBitmap : sentBitmap.copy(sentBitmap.getConfig(), true);
        if (i < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i + i;
        int i6 = i5 + 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i5 + 2) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i6, 3);
        int i11 = i + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap = bitmapCopy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i;
            int i25 = 0;
            while (i24 <= i) {
                int i26 = i4;
                int[] iArr9 = iArr6;
                int i27 = iArr2[i13 + Math.min(i3, Math.max(i24, 0))];
                int[] iArr10 = iArr8[i24 + i];
                iArr10[0] = (i27 & 16711680) >> 16;
                iArr10[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i27 & 255;
                int iAbs = i11 - Math.abs(i24);
                int i28 = iArr10[0];
                i25 += i28 * iAbs;
                int i29 = iArr10[1];
                i16 += i29 * iAbs;
                int i30 = iArr10[2];
                i17 += iAbs * i30;
                if (i24 > 0) {
                    i21 += i28;
                    i22 += i29;
                    i23 += i30;
                } else {
                    i18 += i28;
                    i19 += i29;
                    i20 += i30;
                }
                i24++;
                i4 = i26;
                iArr6 = iArr9;
            }
            int i31 = i4;
            int[] iArr11 = iArr6;
            int i32 = i;
            int i33 = i25;
            int i34 = 0;
            while (i34 < width) {
                iArr3[i13] = iArr7[i33];
                iArr4[i13] = iArr7[i16];
                iArr5[i13] = iArr7[i17];
                int i35 = i33 - i18;
                int i36 = i16 - i19;
                int i37 = i17 - i20;
                int[] iArr12 = iArr8[((i32 - i) + i6) % i6];
                int i38 = i18 - iArr12[0];
                int i39 = i19 - iArr12[1];
                int i40 = i20 - iArr12[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr11[i34] = Math.min(i34 + i + 1, i3);
                } else {
                    iArr = iArr7;
                }
                int i41 = iArr2[i14 + iArr11[i34]];
                int i42 = (i41 & 16711680) >> 16;
                iArr12[0] = i42;
                int i43 = (i41 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i43;
                int i44 = i41 & 255;
                iArr12[2] = i44;
                int i45 = i21 + i42;
                int i46 = i22 + i43;
                int i47 = i23 + i44;
                i33 = i35 + i45;
                i16 = i36 + i46;
                i17 = i37 + i47;
                i32 = (i32 + 1) % i6;
                int[] iArr13 = iArr8[i32 % i6];
                int i48 = iArr13[0];
                i18 = i38 + i48;
                int i49 = iArr13[1];
                i19 = i39 + i49;
                int i50 = iArr13[2];
                i20 = i40 + i50;
                i21 = i45 - i48;
                i22 = i46 - i49;
                i23 = i47 - i50;
                i13++;
                i34++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap;
            height = i15;
            i4 = i31;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap2 = bitmapCopy;
        int i51 = i4;
        int[] iArr15 = iArr6;
        int i52 = height;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i;
            int i55 = i6;
            int[] iArr16 = iArr2;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i) {
                int i67 = width;
                int iMax = Math.max(0, i64) + i53;
                int[] iArr17 = iArr8[i63 + i];
                iArr17[0] = iArr3[iMax];
                iArr17[1] = iArr4[iMax];
                iArr17[2] = iArr5[iMax];
                int iAbs2 = i11 - Math.abs(i63);
                i65 += iArr3[iMax] * iAbs2;
                i66 += iArr4[iMax] * iAbs2;
                i56 += iArr5[iMax] * iAbs2;
                if (i63 > 0) {
                    i60 += iArr17[0];
                    i61 += iArr17[1];
                    i62 += iArr17[2];
                } else {
                    i57 += iArr17[0];
                    i58 += iArr17[1];
                    i59 += iArr17[2];
                }
                int i68 = i51;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i51 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i51;
            int i71 = i;
            int i72 = i53;
            int i73 = i52;
            int i74 = 0;
            while (i74 < i73) {
                iArr16[i72] = (iArr16[i72] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i65] << 16) | (iArr14[i66] << 8) | iArr14[i56];
                int i75 = i65 - i57;
                int i76 = i66 - i58;
                int i77 = i56 - i59;
                int[] iArr18 = iArr8[((i71 - i) + i55) % i55];
                int i78 = i57 - iArr18[0];
                int i79 = i58 - iArr18[1];
                int i80 = i59 - iArr18[2];
                if (i53 == 0) {
                    iArr15[i74] = Math.min(i74 + i11, i70) * i69;
                }
                int i81 = iArr15[i74] + i53;
                int i82 = iArr3[i81];
                iArr18[0] = i82;
                int i83 = iArr4[i81];
                iArr18[1] = i83;
                int i84 = iArr5[i81];
                iArr18[2] = i84;
                int i85 = i60 + i82;
                int i86 = i61 + i83;
                int i87 = i62 + i84;
                i65 = i75 + i85;
                i66 = i76 + i86;
                i56 = i77 + i87;
                i71 = (i71 + 1) % i55;
                int[] iArr19 = iArr8[i71];
                int i88 = iArr19[0];
                i57 = i78 + i88;
                int i89 = iArr19[1];
                i58 = i79 + i89;
                int i90 = iArr19[2];
                i59 = i80 + i90;
                i60 = i85 - i88;
                i61 = i86 - i89;
                i62 = i87 - i90;
                i72 += i69;
                i74++;
                i = radius;
            }
            i53++;
            i = radius;
            i51 = i70;
            i52 = i73;
            i6 = i55;
            iArr2 = iArr16;
            width = i69;
        }
        int i91 = width;
        bitmap2.setPixels(iArr2, 0, i91, 0, 0, i91, i52);
        return bitmap2;
    }
}
