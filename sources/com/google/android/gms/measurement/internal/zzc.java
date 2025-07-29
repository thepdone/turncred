package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzc implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zza zzc;

    zzc(zza zzaVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zza.zza(this.zzc, this.zza, this.zzb);
    }
}
