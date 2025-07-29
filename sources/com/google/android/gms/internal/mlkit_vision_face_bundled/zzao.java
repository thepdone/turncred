package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzao extends zzvn implements zzwt {
    private static final zzao zzb;
    private int zzd;
    private zzar zze;
    private zzar zzf;
    private zzar zzg;
    private zzar zzh;

    static {
        zzao zzaoVar = new zzao();
        zzb = zzaoVar;
        zzvn.zzF(zzao.class, zzaoVar);
    }

    private zzao() {
    }

    public static zzan zza() {
        return (zzan) zzb.zzv();
    }

    static /* synthetic */ void zzc(zzao zzaoVar, zzar zzarVar) {
        zzarVar.getClass();
        zzaoVar.zze = zzarVar;
        zzaoVar.zzd |= 1;
    }

    static /* synthetic */ void zzd(zzao zzaoVar, zzar zzarVar) {
        zzarVar.getClass();
        zzaoVar.zzf = zzarVar;
        zzaoVar.zzd |= 2;
    }

    static /* synthetic */ void zze(zzao zzaoVar, zzar zzarVar) {
        zzarVar.getClass();
        zzaoVar.zzg = zzarVar;
        zzaoVar.zzd |= 4;
    }

    static /* synthetic */ void zzg(zzao zzaoVar, zzar zzarVar) {
        zzarVar.getClass();
        zzaoVar.zzh = zzarVar;
        zzaoVar.zzd |= 8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzao();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzan(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
