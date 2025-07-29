package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkz implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzju zzb;

    zzkz(zzju zzjuVar, Bundle bundle) {
        this.zza = bundle;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzju.zzb(this.zzb, this.zza);
    }
}
