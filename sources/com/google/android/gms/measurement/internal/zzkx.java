package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkx implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzju zzb;

    zzkx(zzju zzjuVar, long j) {
        this.zza = j;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzb(this.zza);
        this.zzb.zzq().zza(new AtomicReference<>());
    }
}
