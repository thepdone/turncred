package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkl implements Executor {
    private final /* synthetic */ zzju zza;

    zzkl(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) throws IllegalStateException {
        this.zza.zzl().zzb(runnable);
    }
}
