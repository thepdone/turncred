package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzjg implements Callable<List<zzog>> {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzig zzc;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzog> call() throws Exception {
        this.zzc.zza.zzs();
        return this.zzc.zza.zza(this.zza, this.zzb);
    }

    zzjg(zzig zzigVar, zzp zzpVar, Bundle bundle) {
        this.zza = zzpVar;
        this.zzb = bundle;
        this.zzc = zzigVar;
    }
}
