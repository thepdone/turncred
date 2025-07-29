package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zznv implements Runnable {
    private final /* synthetic */ zzou zza;
    private final /* synthetic */ Runnable zzb;

    zznv(zznr zznrVar, zzou zzouVar, Runnable runnable) {
        this.zza = zzouVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzs();
        this.zza.zza(this.zzb);
        this.zza.zzx();
    }
}
