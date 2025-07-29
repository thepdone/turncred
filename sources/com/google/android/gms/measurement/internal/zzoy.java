package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzoy implements zzgu {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzpi zzb;
    private final /* synthetic */ zzou zzc;

    zzoy(zzou zzouVar, String str, zzpi zzpiVar) {
        this.zza = str;
        this.zzb = zzpiVar;
        this.zzc = zzouVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) throws IllegalStateException {
        this.zzc.zza(this.zza, i, th, bArr, this.zzb);
    }
}
