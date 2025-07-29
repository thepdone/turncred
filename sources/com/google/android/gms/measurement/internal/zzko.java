package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzko implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzju zzb;

    zzko(zzju zzjuVar, long j) {
        this.zza = j;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzk().zzf.zza(this.zza);
        this.zzb.zzj().zzc().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
