package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zze implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zza zzb;

    zze(zza zzaVar, long j) {
        this.zza = j;
        this.zzb = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
