package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzxb {
    private static final zzxb zza = new zzxb();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzxg zzb = new zzwk();

    private zzxb() {
    }

    public static zzxb zza() {
        return zza;
    }

    public final zzxf zzb(Class cls) {
        zzvt.zzc(cls, "messageType");
        zzxf zzxfVarZza = (zzxf) this.zzc.get(cls);
        if (zzxfVarZza == null) {
            zzxfVarZza = this.zzb.zza(cls);
            zzvt.zzc(cls, "messageType");
            zzxf zzxfVar = (zzxf) this.zzc.putIfAbsent(cls, zzxfVarZza);
            if (zzxfVar != null) {
                return zzxfVar;
            }
        }
        return zzxfVarZza;
    }
}
