package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmc implements Runnable {
    private final /* synthetic */ zzlw zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzlz zzc;

    zzmc(zzlz zzlzVar, zzlw zzlwVar, long j) {
        this.zza = zzlwVar;
        this.zzb = j;
        this.zzc = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzq().zza((zzlw) null);
    }
}
