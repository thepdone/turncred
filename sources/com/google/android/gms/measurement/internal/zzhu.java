package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhu implements com.google.android.gms.internal.measurement.zzo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzhm zzb;

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.zzb.zzb.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }

    zzhu(zzhm zzhmVar, String str) {
        this.zza = str;
        this.zzb = zzhmVar;
    }
}
