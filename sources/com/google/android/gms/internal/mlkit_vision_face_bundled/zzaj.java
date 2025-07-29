package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzaj extends zzvn implements zzwt {
    private static final zzaj zzb;
    private int zzd;
    private zzar zze;
    private zzar zzf;
    private zzar zzg;
    private zzar zzh;

    static {
        zzaj zzajVar = new zzaj();
        zzb = zzajVar;
        zzvn.zzF(zzaj.class, zzajVar);
    }

    private zzaj() {
    }

    public static zzai zza() {
        return (zzai) zzb.zzv();
    }

    static /* synthetic */ void zzc(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zze = zzarVar;
        zzajVar.zzd |= 1;
    }

    static /* synthetic */ void zzd(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zzf = zzarVar;
        zzajVar.zzd |= 2;
    }

    static /* synthetic */ void zze(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zzg = zzarVar;
        zzajVar.zzd |= 4;
    }

    static /* synthetic */ void zzg(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zzh = zzarVar;
        zzajVar.zzd |= 8;
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
            return new zzaj();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzai(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
