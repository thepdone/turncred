package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzjb implements Callable<byte[]> {
    private final /* synthetic */ zzbl zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzig zzc;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        this.zzc.zza.zzs();
        return this.zzc.zza.zzm().zza(this.zza, this.zzb);
    }

    zzjb(zzig zzigVar, zzbl zzblVar, String str) {
        this.zza = zzblVar;
        this.zzb = str;
        this.zzc = zzigVar;
    }
}
