package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzoz implements zzgu {
    private final /* synthetic */ String zza;
    private final /* synthetic */ List zzb;
    private final /* synthetic */ zzou zzc;

    zzoz(zzou zzouVar, String str, List list) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzouVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) throws IllegalStateException {
        this.zzc.zza(true, i, th, bArr, this.zza, this.zzb);
    }
}
