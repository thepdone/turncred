package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzgf;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzov {
    private final String zza;
    private final Map<String, String> zzb;
    private final zzlu zzc;
    private final zzgf.zzo zzd;

    public final zzlu zza() {
        return this.zzc;
    }

    public final zzgf.zzo zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final Map<String, String> zzd() {
        Map<String, String> map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    zzov(String str, zzlu zzluVar) {
        this(str, Collections.emptyMap(), zzluVar, null);
    }

    zzov(String str, Map<String, String> map, zzlu zzluVar) {
        this(str, map, zzluVar, null);
    }

    zzov(String str, Map<String, String> map, zzlu zzluVar, zzgf.zzo zzoVar) {
        this.zza = str;
        this.zzb = map;
        this.zzc = zzluVar;
        this.zzd = zzoVar;
    }
}
