package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmp extends zzgd {
    private final /* synthetic */ AtomicReference zza;

    zzmp(zzme zzmeVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void zza(List<zzog> list) {
        synchronized (this.zza) {
            this.zza.set(list);
            this.zza.notifyAll();
        }
    }
}
