package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzob implements Runnable {
    private long zza;
    private long zzb;
    private final /* synthetic */ zzny zzc;

    public static /* synthetic */ void zza(zzob zzobVar) throws IllegalStateException {
        zzny zznyVar = zzobVar.zzc;
        long j = zzobVar.zza;
        long j2 = zzobVar.zzb;
        zznyVar.zza.zzv();
        zznyVar.zza.zzj().zzc().zza("Application going to the background");
        zznyVar.zza.zzk().zzn.zza(true);
        zznyVar.zza.zza(true);
        if (!zznyVar.zza.zze().zzx()) {
            zznyVar.zza.zza(false, false, j2);
            zznyVar.zza.zzb.zzb(j2);
        }
        zznyVar.zza.zzj().zzp().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j));
        zznyVar.zza.zzm().zzao();
        if (zznyVar.zza.zze().zza(zzbn.zzcm)) {
            long jZzc = zznyVar.zza.zzs().zzd(zznyVar.zza.zza().getPackageName(), zznyVar.zza.zze().zzr()) ? 1000L : zznyVar.zza.zze().zzc(zznyVar.zza.zza().getPackageName(), zzbn.zzz);
            zznyVar.zza.zzj().zzq().zza("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(jZzc));
            zznyVar.zza.zzo().zza(jZzc);
        }
    }

    zzob(zzny zznyVar, long j, long j2) {
        this.zzc = zznyVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzc.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzoa
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzob.zza(this.zza);
            }
        });
    }
}
