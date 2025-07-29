package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zziv implements Callable<List<zzag>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzig zzd;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzag> call() throws Exception {
        this.zzd.zza.zzs();
        return this.zzd.zza.zzf().zza(this.zza, this.zzb, this.zzc);
    }

    zziv(zzig zzigVar, String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzigVar;
    }
}
