package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzkj {
    static final Charset zza;
    public static final byte[] zzb;

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static {
        Charset.forName(CharEncoding.US_ASCII);
        zza = Charset.forName("UTF-8");
        Charset.forName(CharEncoding.ISO_8859_1);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzjk.zza(bArr, 0, bArr.length, false);
    }

    static boolean zza(zzlm zzlmVar) {
        if (!(zzlmVar instanceof zziq)) {
            return false;
        }
        return false;
    }
}
