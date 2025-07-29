package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzgf;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpi {
    private long zza;
    private zzgf.zzj zzb;
    private String zzc;
    private Map<String, String> zzd;
    private zzlu zze;
    private long zzf;

    public final long zza() {
        return this.zza;
    }

    public final zzon zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.zzd.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return new zzon(this.zza, this.zzb.zzce(), this.zzc, bundle, this.zze.zza(), this.zzf);
    }

    public final zzov zzc() {
        return new zzov(this.zzc, this.zzd, this.zze);
    }

    public final zzgf.zzj zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzc;
    }

    private zzpi(long j, zzgf.zzj zzjVar, String str, Map<String, String> map, zzlu zzluVar, long j2, long j3) {
        this.zza = j;
        this.zzb = zzjVar;
        this.zzc = str;
        this.zzd = map;
        this.zze = zzluVar;
        this.zzf = j3;
    }
}
