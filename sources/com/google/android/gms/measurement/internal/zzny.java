package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzny {
    final /* synthetic */ zznx zza;
    private zzob zzb;

    zzny(zznx zznxVar) {
        this.zza = zznxVar;
    }

    final void zza(long j) {
        this.zzb = new zzob(this, this.zza.zzb().currentTimeMillis(), j);
        this.zza.zzc.postDelayed(this.zzb, 2000L);
    }

    final void zza() {
        this.zza.zzv();
        if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
        if (this.zza.zze().zza(zzbn.zzct) && this.zza.zzm().zzax()) {
            this.zza.zzj().zzq().zza("Retrying trigger URI registration in foreground");
            this.zza.zzm().zzav();
        }
    }
}
