package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzuy {
    static final zzuy zza = new zzuy(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzuy() {
        this.zzd = new HashMap();
    }

    public static zzuy zza() {
        return new zzuy();
    }

    public final zzvl zzb(zzws zzwsVar, int i) {
        return (zzvl) this.zzd.get(new zzux(zzwsVar, i));
    }

    public final void zzc(zzvl zzvlVar) {
        this.zzd.put(new zzux(zzvlVar.zza, 202056002), zzvlVar);
    }

    zzuy(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
