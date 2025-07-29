package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzys extends zzvn implements zzwt {
    private static final zzys zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private float zzg;
    private float zzh;

    static {
        zzys zzysVar = new zzys();
        zzb = zzysVar;
        zzvn.zzF(zzys.class, zzysVar);
    }

    private zzys() {
    }

    public final float zzb() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zzd", "zze", zzyr.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzys();
        }
        zzyp zzypVar = null;
        if (i2 == 4) {
            return new zzyq(zzypVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
