package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzow implements Runnable {
    private final /* synthetic */ zzpf zza;
    private final /* synthetic */ zzou zzb;

    zzow(zzou zzouVar, zzpf zzpfVar) {
        this.zza = zzpfVar;
        this.zzb = zzouVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzou.zza(this.zzb, this.zza);
        this.zzb.zzw();
    }
}
