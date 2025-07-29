package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlf implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzju zzb;

    zzlf(zzju zzjuVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Integer.valueOf(this.zzb.zze().zzb(this.zzb.zzg().zzaf(), zzbn.zzax)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
