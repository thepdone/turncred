package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.2.0 */
/* loaded from: classes3.dex */
final class zzn implements Runnable {
    private final /* synthetic */ AppMeasurementDynamiteService.zza zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.zza zzaVar) {
        this.zza = zzaVar;
        this.zzb = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzp().zza(this.zza);
    }
}
