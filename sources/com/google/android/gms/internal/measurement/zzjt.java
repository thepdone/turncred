package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public class zzjt {
    static final zzjt zza = new zzjt(true);
    private static volatile boolean zzb = false;
    private static volatile zzjt zzc;
    private final Map<zza, zzkg.zzd<?, ?>> zzd;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    private static final class zza {
        private final Object zza;
        private final int zzb;

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    public static zzjt zza() {
        zzjt zzjtVar = zzc;
        if (zzjtVar != null) {
            return zzjtVar;
        }
        synchronized (zzjt.class) {
            zzjt zzjtVar2 = zzc;
            if (zzjtVar2 != null) {
                return zzjtVar2;
            }
            zzjt zzjtVarZza = zzkf.zza(zzjt.class);
            zzc = zzjtVarZza;
            return zzjtVarZza;
        }
    }

    public final <ContainingType extends zzlm> zzkg.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzkg.zzd) this.zzd.get(new zza(containingtype, i));
    }

    zzjt() {
        this.zzd = new HashMap();
    }

    private zzjt(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
