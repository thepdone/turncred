package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzma {
    private static final zzma zza = new zzma();
    private final ConcurrentMap<Class<?>, zzme<?>> zzc = new ConcurrentHashMap();
    private final zzmh zzb = new zzla();

    public static zzma zza() {
        return zza;
    }

    public final <T> zzme<T> zza(Class<T> cls) {
        zzkj.zza(cls, "messageType");
        zzme<T> zzmeVar = (zzme) this.zzc.get(cls);
        if (zzmeVar != null) {
            return zzmeVar;
        }
        zzme<T> zzmeVarZza = this.zzb.zza(cls);
        zzkj.zza(cls, "messageType");
        zzkj.zza(zzmeVarZza, "schema");
        zzme<T> zzmeVar2 = (zzme) this.zzc.putIfAbsent(cls, zzmeVarZza);
        return zzmeVar2 != null ? zzmeVar2 : zzmeVarZza;
    }

    public final <T> zzme<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzma() {
    }
}
