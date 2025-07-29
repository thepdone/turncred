package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzpc implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzpd zzd;

    zzpc(zzpd zzpdVar, String str, String str2, Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
        this.zzd = zzpdVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzd.zza.zza((zzbl) Preconditions.checkNotNull(this.zzd.zza.zzq().zza(this.zza, this.zzb, this.zzc, "auto", this.zzd.zza.zzb().currentTimeMillis(), false, true)), this.zza);
    }
}
