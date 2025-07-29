package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzis implements Runnable {
    private final /* synthetic */ zzag zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ zzig zzc;

    zzis(zzig zzigVar, zzag zzagVar, zzp zzpVar) {
        this.zza = zzagVar;
        this.zzb = zzpVar;
        this.zzc = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzs();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zza(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzb(this.zza, this.zzb);
        }
    }
}
