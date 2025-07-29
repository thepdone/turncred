package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zznw implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zznx zzb;

    zznw(zznx zznxVar, long j) {
        this.zza = j;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zznx.zzb(this.zzb, this.zza);
    }
}
