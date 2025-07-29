package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkm implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzju zzb;

    zzkm(zzju zzjuVar, boolean z) {
        this.zza = z;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        boolean zZzae = this.zzb.zzu.zzae();
        boolean zZzad = this.zzb.zzu.zzad();
        this.zzb.zzu.zza(this.zza);
        if (zZzad == this.zza) {
            this.zzb.zzu.zzj().zzq().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzu.zzae() == zZzae || this.zzb.zzu.zzae() != this.zzb.zzu.zzad()) {
            this.zzb.zzu.zzj().zzw().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zZzae));
        }
        this.zzb.zzay();
    }
}
