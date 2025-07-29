package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzgs {
    public String zza;
    public String zzb;
    public Bundle zzc;
    private long zzd;

    public final zzbl zza() {
        return new zzbl(this.zza, new zzbg(new Bundle(this.zzc)), this.zzb, this.zzd);
    }

    public static zzgs zza(zzbl zzblVar) {
        return new zzgs(zzblVar.zza, zzblVar.zzc, zzblVar.zzb.zzb(), zzblVar.zzd);
    }

    public final String toString() {
        return "origin=" + this.zzb + ",name=" + this.zza + ",params=" + String.valueOf(this.zzc);
    }

    public zzgs(String str, String str2, Bundle bundle, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle == null ? new Bundle() : bundle;
        this.zzd = j;
    }
}
