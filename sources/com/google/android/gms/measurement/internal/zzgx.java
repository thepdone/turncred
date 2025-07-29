package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzgx implements Runnable {
    private final zzgu zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map<String, List<String>> zzf;

    private zzgx(String str, zzgu zzguVar, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(zzguVar);
        this.zza = zzguVar;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
