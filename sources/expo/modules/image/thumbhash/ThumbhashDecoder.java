package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.codepush.react.CodePushConstants;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThumbhashDecoder.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\u0015"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder;", "", "()V", "rgbaToThumbHash", "", "w", "", "h", "rgba", "thumbHashToApproximateAspectRatio", "", CodePushConstants.PENDING_UPDATE_HASH_KEY, "thumbHashToAverageRGBA", "Lexpo/modules/image/thumbhash/ThumbhashDecoder$RGBA;", "thumbHashToBitmap", "Landroid/graphics/Bitmap;", "thumbHashToRGBA", "Lexpo/modules/image/thumbhash/ThumbhashDecoder$Image;", "Channel", "Image", "RGBA", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThumbhashDecoder {
    public static final ThumbhashDecoder INSTANCE = new ThumbhashDecoder();

    private ThumbhashDecoder() {
    }

    public final byte[] rgbaToThumbHash(int w, int h, byte[] rgba) {
        int i;
        int length;
        Intrinsics.checkNotNullParameter(rgba, "rgba");
        if (w > 100 || h > 100) {
            throw new IllegalArgumentException((w + "x" + h + " doesn't fit in 100x100").toString());
        }
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = w * h;
            if (i2 >= i) {
                break;
            }
            float f5 = (rgba[i3 + 3] & 255) / 255.0f;
            float f6 = f5 / 255.0f;
            f2 += (rgba[i3] & 255) * f6;
            f3 += (rgba[i3 + 1] & 255) * f6;
            f4 += f6 * (rgba[i3 + 2] & 255);
            f += f5;
            i2++;
            i3 += 4;
        }
        if (f > 0.0f) {
            f2 /= f;
            f3 /= f;
            f4 /= f;
        }
        boolean z = f < ((float) i);
        int i4 = z ? 5 : 7;
        int iMax = Math.max(1, Math.round((i4 * w) / Math.max(w, h)));
        int iMax2 = Math.max(1, Math.round((i4 * h) / Math.max(w, h)));
        float[] fArr = new float[i];
        float[] fArr2 = new float[i];
        float[] fArr3 = new float[i];
        float[] fArr4 = new float[i];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            float f7 = (rgba[i6 + 3] & 255) / 255.0f;
            float f8 = 1.0f - f7;
            float f9 = f7 / 255.0f;
            float f10 = f2;
            float f11 = (f2 * f8) + ((rgba[i6] & 255) * f9);
            float f12 = f3;
            float f13 = (f3 * f8) + ((rgba[i6 + 1] & 255) * f9);
            float f14 = (f8 * f4) + (f9 * (rgba[i6 + 2] & 255));
            float f15 = f11 + f13;
            fArr[i5] = (f15 + f14) / 3.0f;
            fArr2[i5] = (f15 / 2.0f) - f14;
            fArr3[i5] = f11 - f13;
            fArr4[i5] = f7;
            i5++;
            i6 += 4;
            f2 = f10;
            f3 = f12;
        }
        Channel channelEncode = new Channel(Math.max(3, iMax), Math.max(3, iMax2)).encode(w, h, fArr);
        Channel channelEncode2 = new Channel(3, 3).encode(w, h, fArr2);
        Channel channelEncode3 = new Channel(3, 3).encode(w, h, fArr3);
        Channel channelEncode4 = z ? new Channel(5, 5).encode(w, h, fArr4) : null;
        boolean z2 = w > h;
        int iRound = Math.round(channelEncode.getDc() * 63.0f) | (Math.round((channelEncode2.getDc() * 31.5f) + 31.5f) << 6) | (Math.round((channelEncode3.getDc() * 31.5f) + 31.5f) << 12) | (Math.round(channelEncode.getScale() * 31.0f) << 18) | (z ? 8388608 : 0);
        if (z2) {
            iMax = iMax2;
        }
        int iRound2 = (z2 ? 32768 : 0) | (Math.round(channelEncode2.getScale() * 63.0f) << 3) | iMax | (Math.round(channelEncode3.getScale() * 63.0f) << 9);
        int i7 = z ? 6 : 5;
        int length2 = channelEncode.getAc().length + channelEncode2.getAc().length + channelEncode3.getAc().length;
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            length = channelEncode4.getAc().length;
        } else {
            length = 0;
        }
        byte[] bArr = new byte[(((length2 + length) + 1) / 2) + i7];
        bArr[0] = (byte) iRound;
        bArr[1] = (byte) (iRound >> 8);
        bArr[2] = (byte) (iRound >> 16);
        bArr[3] = (byte) iRound2;
        bArr[4] = (byte) (iRound2 >> 8);
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            bArr[5] = (byte) (Math.round(channelEncode4.getDc() * 15.0f) | (Math.round(channelEncode4.getScale() * 15.0f) << 4));
        }
        int iWriteTo = channelEncode3.writeTo(bArr, i7, channelEncode2.writeTo(bArr, i7, channelEncode.writeTo(bArr, i7, 0)));
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            channelEncode4.writeTo(bArr, i7, iWriteTo);
        }
        return bArr;
    }

    public final Image thumbHashToRGBA(byte[] hash) {
        Channel channel;
        float f;
        float[] fArr;
        float f2;
        float[] fArr2;
        int i;
        Intrinsics.checkNotNullParameter(hash, "hash");
        int i2 = (hash[0] & 255) | ((hash[1] & 255) << 8) | ((hash[2] & 255) << 16);
        int i3 = (hash[3] & 255) | ((hash[4] & 255) << 8);
        float f3 = (i2 & 63) / 63.0f;
        float f4 = (((i2 >> 6) & 63) / 31.5f) - 1.0f;
        float f5 = (((i2 >> 12) & 63) / 31.5f) - 1.0f;
        float f6 = ((i2 >> 18) & 31) / 31.0f;
        boolean z = (i2 >> 23) != 0;
        float f7 = ((i3 >> 3) & 63) / 63.0f;
        float f8 = ((i3 >> 9) & 63) / 63.0f;
        boolean z2 = (i3 >> 15) != 0;
        int i4 = 7;
        int iMax = Math.max(3, z2 ? z ? 5 : 7 : i3 & 7);
        if (z2) {
            i4 = 7 & i3;
        } else if (z) {
            i4 = 5;
        }
        int iMax2 = Math.max(3, i4);
        float f9 = z ? (hash[5] & Ascii.SI) / 15.0f : 1.0f;
        float f10 = ((hash[5] >> 4) & 15) / 15.0f;
        int i5 = z ? 6 : 5;
        Channel channel2 = new Channel(iMax, iMax2);
        Channel channel3 = new Channel(3, 3);
        Channel channel4 = new Channel(3, 3);
        int iDecode = channel4.decode(hash, i5, channel3.decode(hash, i5, channel2.decode(hash, i5, 0, f6), f7 * 1.25f), f8 * 1.25f);
        float[] ac = null;
        if (z) {
            channel = new Channel(5, 5);
            channel.decode(hash, i5, iDecode, f10);
        } else {
            channel = null;
        }
        float[] ac2 = channel2.getAc();
        float[] ac3 = channel3.getAc();
        float[] ac4 = channel4.getAc();
        if (z) {
            Intrinsics.checkNotNull(channel);
            ac = channel.getAc();
        }
        float fThumbHashToApproximateAspectRatio = thumbHashToApproximateAspectRatio(hash);
        int iRound = Math.round(fThumbHashToApproximateAspectRatio > 1.0f ? 32.0f : fThumbHashToApproximateAspectRatio * 32.0f);
        int iRound2 = Math.round(fThumbHashToApproximateAspectRatio > 1.0f ? 32.0f / fThumbHashToApproximateAspectRatio : 32.0f);
        byte[] bArr = new byte[iRound * iRound2 * 4];
        int iMax3 = Math.max(iMax, z ? 5 : 3);
        int iMax4 = Math.max(iMax2, z ? 5 : 3);
        float[] fArr3 = new float[iMax3];
        float[] fArr4 = new float[iMax4];
        int i6 = 0;
        int i7 = 0;
        while (i6 < iRound2) {
            float f11 = f9;
            int i8 = 0;
            while (i8 < iRound) {
                byte[] bArr2 = bArr;
                int i9 = 0;
                while (i9 < iMax3) {
                    fArr3[i9] = (float) Math.cos((3.141592653589793d / iRound) * (i8 + 0.5f) * i9);
                    i9++;
                    z = z;
                    ac3 = ac3;
                }
                float[] fArr5 = ac3;
                boolean z3 = z;
                int i10 = 0;
                while (i10 < iMax4) {
                    fArr4[i10] = (float) Math.cos((3.141592653589793d / iRound2) * (i6 + 0.5f) * i10);
                    i10++;
                    iMax3 = iMax3;
                    iMax4 = iMax4;
                    i6 = i6;
                }
                int i11 = iMax3;
                int i12 = i6;
                int i13 = iMax4;
                float f12 = f3;
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    f = 2.0f;
                    if (i14 >= iMax2) {
                        break;
                    }
                    float f13 = fArr4[i14] * 2.0f;
                    int i16 = i14 > 0 ? 0 : 1;
                    while (true) {
                        i = iMax2;
                        if (i16 * iMax2 < iMax * (iMax2 - i14)) {
                            f12 += ac2[i15] * fArr3[i16] * f13;
                            i16++;
                            i15++;
                            iMax2 = i;
                        }
                    }
                    i14++;
                    iMax2 = i;
                }
                int i17 = iMax2;
                float f14 = f4;
                float f15 = f5;
                int i18 = 0;
                int i19 = 0;
                while (i18 < 3) {
                    float f16 = fArr4[i18] * f;
                    int i20 = i18 > 0 ? 0 : 1;
                    while (i20 < 3 - i18) {
                        float f17 = fArr3[i20] * f16;
                        f14 += fArr5[i19] * f17;
                        f15 += ac4[i19] * f17;
                        i20++;
                        i19++;
                    }
                    i18++;
                    f = 2.0f;
                }
                if (z3) {
                    f2 = f11;
                    int i21 = 0;
                    int i22 = 0;
                    while (i21 < 5) {
                        float f18 = fArr4[i21] * 2.0f;
                        int i23 = i21 > 0 ? 0 : 1;
                        while (true) {
                            fArr2 = ac2;
                            if (i23 < 5 - i21) {
                                Intrinsics.checkNotNull(ac);
                                f2 += ac[i22] * fArr3[i23] * f18;
                                i23++;
                                i22++;
                                ac2 = fArr2;
                            }
                        }
                        i21++;
                        ac2 = fArr2;
                    }
                    fArr = ac2;
                } else {
                    fArr = ac2;
                    f2 = f11;
                }
                float f19 = f12 - (f14 * 0.6666667f);
                float f20 = (((f12 * 3.0f) - f19) + f15) / 2.0f;
                bArr2[i7] = (byte) Math.max(0, Math.round(Math.min(1.0f, f20) * 255.0f));
                bArr2[i7 + 1] = (byte) Math.max(0, Math.round(Math.min(1.0f, f20 - f15) * 255.0f));
                bArr2[i7 + 2] = (byte) Math.max(0, Math.round(Math.min(1.0f, f19) * 255.0f));
                bArr2[i7 + 3] = (byte) Math.max(0, Math.round(Math.min(1.0f, f2) * 255.0f));
                i8++;
                i7 += 4;
                bArr = bArr2;
                iMax2 = i17;
                z = z3;
                ac3 = fArr5;
                iMax3 = i11;
                iMax4 = i13;
                i6 = i12;
                ac2 = fArr;
            }
            i6++;
            f9 = f11;
            ac3 = ac3;
            ac2 = ac2;
        }
        return new Image(iRound, iRound2, bArr);
    }

    public final Bitmap thumbHashToBitmap(byte[] hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Image imageThumbHashToRGBA = thumbHashToRGBA(hash);
        int[] iArr = new int[imageThumbHashToRGBA.getWidth() * imageThumbHashToRGBA.getHeight()];
        byte[] rgba = imageThumbHashToRGBA.getRgba();
        ArrayList arrayList = new ArrayList(rgba.length);
        int i = 0;
        for (byte b : rgba) {
            arrayList.add(Integer.valueOf(UByte.m5955constructorimpl(b) & 255));
        }
        ArrayList arrayList2 = arrayList;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, arrayList2.size() - 1, 4);
        if (progressionLastElement >= 0) {
            while (true) {
                iArr[i / 4] = Color.argb(((Number) arrayList2.get(i + 3)).intValue(), ((Number) arrayList2.get(i)).intValue(), ((Number) arrayList2.get(i + 1)).intValue(), ((Number) arrayList2.get(i + 2)).intValue());
                if (i == progressionLastElement) {
                    break;
                }
                i += 4;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, imageThumbHashToRGBA.getWidth(), imageThumbHashToRGBA.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public final RGBA thumbHashToAverageRGBA(byte[] hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        float f = (r0 & 63) / 63.0f;
        float f2 = (((r0 >> 6) & 63) / 31.5f) - 1.0f;
        float f3 = (((r0 >> 12) & 63) / 31.5f) - 1.0f;
        float f4 = f - (f2 * 0.6666667f);
        float f5 = (((f * 3.0f) - f4) + f3) / 2.0f;
        return new RGBA(Math.max(0.0f, Math.min(1.0f, f5)), Math.max(0.0f, Math.min(1.0f, f5 - f3)), Math.max(0.0f, Math.min(1.0f, f4)), ((((hash[0] & 255) | ((hash[1] & 255) << 8)) | ((hash[2] & 255) << 16)) >> 23) != 0 ? (hash[5] & Ascii.SI) / 15.0f : 1.0f);
    }

    public final float thumbHashToApproximateAspectRatio(byte[] hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        byte b = hash[3];
        boolean z = (hash[2] & 128) != 0;
        boolean z2 = (hash[4] & 128) != 0;
        int i = 5;
        int i2 = z2 ? z ? 5 : 7 : b & 7;
        if (z2) {
            i = b & 7;
        } else if (!z) {
            i = 7;
        }
        return i2 / i;
    }

    /* compiled from: ThumbhashDecoder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$Image;", "", "width", "", "height", "rgba", "", "(II[B)V", "getHeight", "()I", "setHeight", "(I)V", "getRgba", "()[B", "setRgba", "([B)V", "getWidth", "setWidth", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Image {
        private int height;
        private byte[] rgba;
        private int width;

        public Image(int i, int i2, byte[] rgba) {
            Intrinsics.checkNotNullParameter(rgba, "rgba");
            this.width = i;
            this.height = i2;
            this.rgba = rgba;
        }

        public final int getHeight() {
            return this.height;
        }

        public final byte[] getRgba() {
            return this.rgba;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setRgba(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.rgba = bArr;
        }

        public final void setWidth(int i) {
            this.width = i;
        }
    }

    /* compiled from: ThumbhashDecoder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$RGBA;", "", JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, "", "g", "b", "a", "(FFFF)V", "getA", "()F", "setA", "(F)V", "getB", "setB", "getG", "setG", "getR", "setR", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RGBA {
        private float a;
        private float b;
        private float g;
        private float r;

        public RGBA(float f, float f2, float f3, float f4) {
            this.r = f;
            this.g = f2;
            this.b = f3;
            this.a = f4;
        }

        public final float getA() {
            return this.a;
        }

        public final float getB() {
            return this.b;
        }

        public final float getG() {
            return this.g;
        }

        public final float getR() {
            return this.r;
        }

        public final void setA(float f) {
            this.a = f;
        }

        public final void setB(float f) {
            this.b = f;
        }

        public final void setG(float f) {
            this.g = f;
        }

        public final void setR(float f) {
            this.r = f;
        }
    }

    /* compiled from: ThumbhashDecoder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J&\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\rJ\u001e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0007J\u001e\u0010$\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006%"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$Channel;", "", "nx", "", "ny", "(II)V", "ac", "", "getAc", "()[F", "setAc", "([F)V", "dc", "", "getDc", "()F", "setDc", "(F)V", "getNx", "()I", "setNx", "(I)V", "getNy", "setNy", "scale", "getScale", "setScale", "decode", CodePushConstants.PENDING_UPDATE_HASH_KEY, "", ViewProps.START, FirebaseAnalytics.Param.INDEX, "encode", "w", "h", "channel", "writeTo", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Channel {
        private float[] ac;
        private float dc;
        private int nx;
        private int ny;
        private float scale;

        public Channel(int i, int i2) {
            this.nx = i;
            this.ny = i2;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i3 > 0 ? 0 : 1;
                while (true) {
                    int i6 = this.ny;
                    if (i5 * i6 < this.nx * (i6 - i3)) {
                        i4++;
                        i5++;
                    }
                }
                i3++;
            }
            this.ac = new float[i4];
        }

        public final int getNx() {
            return this.nx;
        }

        public final int getNy() {
            return this.ny;
        }

        public final void setNx(int i) {
            this.nx = i;
        }

        public final void setNy(int i) {
            this.ny = i;
        }

        public final float getDc() {
            return this.dc;
        }

        public final void setDc(float f) {
            this.dc = f;
        }

        public final float[] getAc() {
            return this.ac;
        }

        public final void setAc(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.ac = fArr;
        }

        public final float getScale() {
            return this.scale;
        }

        public final void setScale(float f) {
            this.scale = f;
        }

        public final Channel encode(int w, int h, float[] channel) {
            double d;
            Intrinsics.checkNotNullParameter(channel, "channel");
            float[] fArr = new float[w];
            int i = this.ny;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                float f = 0.5f;
                if (i2 >= i) {
                    break;
                }
                int i4 = 0;
                while (true) {
                    int i5 = this.ny;
                    if (i4 * i5 < this.nx * (i5 - i2)) {
                        int i6 = 0;
                        while (true) {
                            d = 3.141592653589793d;
                            if (i6 >= w) {
                                break;
                            }
                            fArr[i6] = (float) Math.cos((3.141592653589793d / w) * i4 * (i6 + f));
                            i6++;
                            i2 = i2;
                        }
                        int i7 = i2;
                        int i8 = 0;
                        float f2 = 0.0f;
                        while (i8 < h) {
                            int i9 = i7;
                            float fCos = (float) Math.cos((d / h) * i9 * (i8 + 0.5f));
                            for (int i10 = 0; i10 < w; i10++) {
                                f2 += channel[(i8 * w) + i10] * fArr[i10] * fCos;
                            }
                            i8++;
                            i7 = i9;
                            d = 3.141592653589793d;
                        }
                        int i11 = i7;
                        float f3 = f2 / (w * h);
                        if (i4 > 0 || i11 > 0) {
                            this.ac[i3] = f3;
                            this.scale = Math.max(this.scale, Math.abs(f3));
                            i3++;
                        } else {
                            this.dc = f3;
                        }
                        i4++;
                        i2 = i11;
                        f = 0.5f;
                    }
                }
                i2++;
            }
            if (this.scale > 0.0f) {
                int length = this.ac.length;
                for (int i12 = 0; i12 < length; i12++) {
                    float[] fArr2 = this.ac;
                    fArr2[i12] = ((0.5f / this.scale) * fArr2[i12]) + 0.5f;
                }
            }
            return this;
        }

        public final int decode(byte[] hash, int start, int index, float scale) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            int length = this.ac.length;
            for (int i = 0; i < length; i++) {
                this.ac[i] = ((((hash[(index >> 1) + start] >> ((index & 1) << 2)) & 15) / 7.5f) - 1.0f) * scale;
                index++;
            }
            return index;
        }

        public final int writeTo(byte[] hash, int start, int index) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            for (float f : this.ac) {
                int i = (index >> 1) + start;
                hash[i] = (byte) ((Math.round(f * 15.0f) << ((index & 1) << 2)) | hash[i]);
                index++;
            }
            return index;
        }
    }
}
