package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zznm implements Runnable {
    private final /* synthetic */ zznj zza;

    zznm(zznj zznjVar) {
        this.zza = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zza.zza.zzb = null;
        this.zza.zza.zzaq();
    }
}
