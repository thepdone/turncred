package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzin implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzig zzb;

    zzin(zzig zzigVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza.zzs();
        this.zzb.zza.zzd(this.zza);
    }
}
