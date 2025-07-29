package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlh implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zzju zzb;

    zzlh(zzju zzjuVar, Boolean bool) {
        this.zza = bool;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza(this.zza, true);
    }
}
