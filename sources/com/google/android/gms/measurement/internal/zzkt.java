package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkt implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzju zze;

    zzkt(zzju zzjuVar, String str, String str2, Object obj, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
        this.zze = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
