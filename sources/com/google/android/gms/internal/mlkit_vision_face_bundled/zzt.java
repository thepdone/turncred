package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzt extends zzvn implements zzwt {
    private static final zzt zzb;
    private int zzd;
    private zzar zze;
    private zzar zzf;

    static {
        zzt zztVar = new zzt();
        zzb = zztVar;
        zzvn.zzF(zzt.class, zztVar);
    }

    private zzt() {
    }

    public static zzs zza() {
        return (zzs) zzb.zzv();
    }

    static /* synthetic */ void zzc(zzt zztVar, zzar zzarVar) {
        zzarVar.getClass();
        zztVar.zze = zzarVar;
        zztVar.zzd |= 1;
    }

    static /* synthetic */ void zzd(zzt zztVar, zzar zzarVar) {
        zzarVar.getClass();
        zztVar.zzf = zzarVar;
        zztVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzt();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzs(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
