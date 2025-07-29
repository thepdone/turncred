package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzod {
    protected long zza;
    final /* synthetic */ zznx zzb;
    private long zzc;
    private final zzbb zzd;

    final long zza(long j) {
        long j2 = j - this.zza;
        this.zza = j;
        return j2;
    }

    static /* synthetic */ void zza(zzod zzodVar) throws IllegalStateException {
        zzodVar.zzb.zzv();
        zzodVar.zza(false, false, zzodVar.zzb.zzb().elapsedRealtime());
        zzodVar.zzb.zzc().zza(zzodVar.zzb.zzb().elapsedRealtime());
    }

    public zzod(zznx zznxVar) {
        this.zzb = zznxVar;
        this.zzd = new zzoc(this, zznxVar.zzu);
        long jElapsedRealtime = zznxVar.zzb().elapsedRealtime();
        this.zzc = jElapsedRealtime;
        this.zza = jElapsedRealtime;
    }

    final void zza() {
        this.zzd.zza();
        if (this.zzb.zze().zza(zzbn.zzcw)) {
            this.zzc = this.zzb.zzb().elapsedRealtime();
        } else {
            this.zzc = 0L;
        }
        this.zza = this.zzc;
    }

    final void zzb(long j) {
        this.zzd.zza();
    }

    final void zzc(long j) {
        this.zzb.zzv();
        this.zzd.zza();
        this.zzc = j;
        this.zza = j;
    }

    public final boolean zza(boolean z, boolean z2, long j) throws IllegalStateException {
        this.zzb.zzv();
        this.zzb.zzw();
        if (this.zzb.zzu.zzae()) {
            this.zzb.zzk().zzk.zza(this.zzb.zzb().currentTimeMillis());
        }
        long jZza = j - this.zzc;
        if (!z && jZza < 1000) {
            this.zzb.zzj().zzq().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jZza));
            return false;
        }
        if (!z2) {
            jZza = zza(j);
        }
        this.zzb.zzj().zzq().zza("Recording user engagement, ms", Long.valueOf(jZza));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jZza);
        zzpn.zza(this.zzb.zzp().zza(!this.zzb.zze().zzx()), bundle, true);
        if (!z2) {
            this.zzb.zzm().zzc("auto", "_e", bundle);
        }
        this.zzc = j;
        this.zzd.zza();
        this.zzd.zza(zzbn.zzbk.zza(null).longValue());
        return true;
    }
}
