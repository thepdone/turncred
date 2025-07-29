package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.2.0 */
/* loaded from: classes3.dex */
final class zzl implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zza;
    private final /* synthetic */ zzbl zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdq zzdqVar, zzbl zzblVar, String str) {
        this.zza = zzdqVar;
        this.zzb = zzblVar;
        this.zzc = str;
        this.zzd = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzd.zza.zzt().zza(this.zza, this.zzb, this.zzc);
    }
}
