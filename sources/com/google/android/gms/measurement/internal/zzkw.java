package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkw implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzju zzb;

    zzkw(zzju zzjuVar, Bundle bundle) {
        this.zza = bundle;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzju.zzc(this.zzb, this.zza);
    }
}
