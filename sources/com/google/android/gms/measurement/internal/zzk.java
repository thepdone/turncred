package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.2.0 */
/* loaded from: classes3.dex */
final class zzk implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ AppMeasurementDynamiteService zze;

    zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2, boolean z) {
        this.zza = zzdqVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
        this.zze = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zze.zza.zzt().zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
