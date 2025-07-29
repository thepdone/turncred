package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzio implements Callable<List<zzpo>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzig zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzpo> call() throws Exception {
        this.zzb.zza.zzs();
        return this.zzb.zza.zzf().zzk(this.zza);
    }

    zzio(zzig zzigVar, String str) {
        this.zza = str;
        this.zzb = zzigVar;
    }
}
