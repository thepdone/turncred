package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzah extends zzvn implements zzwt {
    private static final zzah zzb;
    private int zzd;
    private boolean zzi;
    private boolean zzj;
    private boolean zzm;
    private zzaj zzn;
    private zzt zzo;
    private zzao zzp;
    private float zze = 0.1f;
    private int zzf = 1;
    private int zzg = 1;
    private int zzh = 1;
    private float zzk = 45.0f;
    private float zzl = 0.5f;

    static {
        zzah zzahVar = new zzah();
        zzb = zzahVar;
        zzvn.zzF(zzah.class, zzahVar);
    }

    private zzah() {
    }

    public static zzag zza() {
        return (zzag) zzb.zzv();
    }

    static /* synthetic */ void zzc(zzah zzahVar, float f) {
        zzahVar.zzd |= 1;
        zzahVar.zze = f;
    }

    static /* synthetic */ void zzd(zzah zzahVar, boolean z) {
        zzahVar.zzd |= 32;
        zzahVar.zzj = z;
    }

    static /* synthetic */ void zze(zzah zzahVar, boolean z) {
        zzahVar.zzd |= 256;
        zzahVar.zzm = true;
    }

    static /* synthetic */ void zzg(zzah zzahVar, zzaj zzajVar) {
        zzajVar.getClass();
        zzahVar.zzn = zzajVar;
        zzahVar.zzd |= 512;
    }

    static /* synthetic */ void zzh(zzah zzahVar, zzt zztVar) {
        zztVar.getClass();
        zzahVar.zzo = zztVar;
        zzahVar.zzd |= 1024;
    }

    static /* synthetic */ void zzi(zzah zzahVar, zzao zzaoVar) {
        zzaoVar.getClass();
        zzahVar.zzp = zzaoVar;
        zzahVar.zzd |= 2048;
    }

    static /* synthetic */ void zzj(zzah zzahVar, boolean z) {
        zzahVar.zzd |= 16;
        zzahVar.zzi = z;
    }

    static /* synthetic */ void zzm(zzah zzahVar, int i) {
        zzahVar.zzf = i - 1;
        zzahVar.zzd |= 2;
    }

    static /* synthetic */ void zzn(zzah zzahVar, int i) {
        zzahVar.zzg = i - 1;
        zzahVar.zzd |= 4;
    }

    static /* synthetic */ void zzo(zzah zzahVar, int i) {
        zzahVar.zzh = i - 1;
        zzahVar.zzd |= 8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ခ\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ခ\u0006\bခ\u0007\tဇ\b\nဉ\t\u000bဉ\n\fဉ\u000b", new Object[]{"zzd", "zze", "zzf", zzal.zza, "zzg", zzv.zza, "zzh", zzap.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzah();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzag(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzk() {
        int iZza = zzw.zza(this.zzg);
        if (iZza == 0) {
            return 2;
        }
        return iZza;
    }

    public final int zzl() {
        int iZza = zzam.zza(this.zzf);
        if (iZza == 0) {
            return 2;
        }
        return iZza;
    }
}
