package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzil implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzig zzb;

    zzil(zzig zzigVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzs();
        zzou zzouVar = this.zzb.zza;
        zzp zzpVar = this.zza;
        zzouVar.zzl().zzv();
        zzouVar.zzt();
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzouVar.zza(zzpVar);
    }
}
