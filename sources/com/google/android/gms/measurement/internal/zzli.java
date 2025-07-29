package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzli implements Runnable {
    private final /* synthetic */ zzjj zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzju zzd;

    zzli(zzju zzjuVar, zzjj zzjjVar, long j, boolean z) {
        this.zza = zzjjVar;
        this.zzb = j;
        this.zzc = z;
        this.zzd = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzd.zza(this.zza);
        zzju.zza(this.zzd, this.zza, this.zzb, false, this.zzc);
    }
}
