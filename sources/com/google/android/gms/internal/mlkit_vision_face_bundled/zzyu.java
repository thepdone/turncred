package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzyu extends zzvn implements zzwt {
    private static final zzyu zzb;
    private int zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;

    static {
        zzyu zzyuVar = new zzyu();
        zzb = zzyuVar;
        zzvn.zzF(zzyu.class, zzyuVar);
    }

    private zzyu() {
    }

    public static zzyu zzi() {
        return zzb;
    }

    public final float zzb() {
        return this.zze;
    }

    public final float zzd() {
        return this.zzg;
    }

    public final float zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzyu();
        }
        zzyp zzypVar = null;
        if (i2 == 4) {
            return new zzyt(zzypVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final float zzg() {
        return this.zzh;
    }
}
