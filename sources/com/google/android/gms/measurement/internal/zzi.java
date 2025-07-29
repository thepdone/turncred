package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.2.0 */
/* loaded from: classes3.dex */
final class zzi implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = zzdqVar;
        this.zzb = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza.zzt().zza(this.zza);
    }
}
