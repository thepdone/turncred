package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzp extends zzvn implements zzwt {
    private static final zzp zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private long zzj;
    private String zzk = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzvn.zzF(zzp.class, zzpVar);
    }

    private zzp() {
    }

    public static zzo zza() {
        return (zzo) zzb.zzv();
    }

    static /* synthetic */ void zzc(zzp zzpVar, int i) {
        zzpVar.zzd |= 1;
        zzpVar.zze = i;
    }

    static /* synthetic */ void zzd(zzp zzpVar, long j) {
        zzpVar.zzd |= 32;
        zzpVar.zzj = j;
    }

    static /* synthetic */ void zze(zzp zzpVar, int i) {
        zzpVar.zzd |= 2;
        zzpVar.zzf = i;
    }

    static /* synthetic */ void zzg(zzp zzpVar, int i) {
        zzpVar.zzg = i - 1;
        zzpVar.zzd |= 4;
    }

    static /* synthetic */ void zzh(zzp zzpVar, int i) {
        zzpVar.zzh = i - 1;
        zzpVar.zzd |= 8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဇ\u0004\u0006ဂ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", zzm.zza, "zzh", zzq.zza, "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzo(zznVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
