package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzid implements Runnable {
    private final /* synthetic */ zzjs zza;
    private final /* synthetic */ zzic zzb;

    zzid(zzic zzicVar, zzjs zzjsVar) {
        this.zza = zzjsVar;
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzic.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
