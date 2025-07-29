package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzyx extends zzvn implements zzwt {
    private static final zzyx zzb;
    private int zzd;
    private int zze;
    private zzul zzf = zzul.zzb;
    private String zzg = "";
    private float zzh;

    static {
        zzyx zzyxVar = new zzyx();
        zzb = zzyxVar;
        zzvn.zzF(zzyx.class, zzyxVar);
    }

    private zzyx() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzyx();
        }
        zzyp zzypVar = null;
        if (i2 == 4) {
            return new zzyw(zzypVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
