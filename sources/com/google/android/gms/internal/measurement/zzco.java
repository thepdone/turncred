package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzco {
    public static final zzco zza = new zzcd().zza("").zza(false).zza(zzcq.ALL_CHECKS).zza(zzcp.READ_AND_WRITE).zza();
    static final zzco zzb = new zzcd().zza("").zza(false).zza(zzcq.NO_CHECKS).zza(zzcp.READ_AND_WRITE).zza();

    static {
        new zzcd().zza("").zza(false).zza(zzcq.SKIP_COMPLIANCE_CHECK).zza(zzcp.READ_AND_WRITE).zza();
    }

    public abstract zzcc zza();

    public abstract zzcb zzb();

    public abstract zzcq zzc();

    public abstract zzcp zzd();

    public abstract String zze();

    public abstract boolean zzf();
}
