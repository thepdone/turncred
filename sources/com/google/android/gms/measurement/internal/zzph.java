package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzgf;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzph {
    private long zza;
    private zzgf.zzj zzb;
    private String zzc;
    private Map<String, String> zzd;
    private zzlu zze;
    private long zzf;
    private long zzg;

    public final zzph zza(long j) {
        this.zzg = j;
        return this;
    }

    public final zzph zzb(long j) {
        this.zzf = j;
        return this;
    }

    public final zzph zza(zzgf.zzj zzjVar) {
        this.zzb = zzjVar;
        return this;
    }

    public final zzph zzc(long j) {
        this.zza = j;
        return this;
    }

    public final zzph zza(Map<String, String> map) {
        this.zzd = map;
        return this;
    }

    public final zzph zza(zzlu zzluVar) {
        this.zze = zzluVar;
        return this;
    }

    public final zzph zza(String str) {
        this.zzc = str;
        return this;
    }

    public final zzpi zza() {
        return new zzpi(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    zzph() {
    }
}
