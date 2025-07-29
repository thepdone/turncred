package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmd implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzlz zzb;

    zzmd(zzlz zzlzVar, long j) {
        this.zza = j;
        this.zzb = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zza(this.zza);
        this.zzb.zza = null;
    }
}
