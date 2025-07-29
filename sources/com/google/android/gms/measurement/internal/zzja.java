package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzja implements Callable<zzap> {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzig zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzap call() throws Exception {
        this.zzb.zza.zzs();
        return new zzap(this.zzb.zza.zza(this.zza.zza));
    }

    zzja(zzig zzigVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzigVar;
    }
}
