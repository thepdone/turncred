package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzvt {
    static final Charset zza = Charset.forName(CharEncoding.US_ASCII);
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName(CharEncoding.ISO_8859_1);
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzup zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzup.zza;
        zzun zzunVar = new zzun(bArr, 0, 0, false, null);
        try {
            zzunVar.zza(0);
            zzf = zzunVar;
        } catch (zzvv e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zzc(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
