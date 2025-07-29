package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zziz implements Runnable {
    private final /* synthetic */ zzbl zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ zzig zzc;

    zziz(zzig zzigVar, zzbl zzblVar, zzp zzpVar) {
        this.zza = zzblVar;
        this.zzb = zzpVar;
        this.zzc = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzc.zzc(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
