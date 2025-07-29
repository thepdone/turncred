package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public class zzvy {
    private static final zzuy zzb = zzuy.zza;
    protected volatile zzws zza;
    private volatile zzul zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvy)) {
            return false;
        }
        zzvy zzvyVar = (zzvy) obj;
        zzws zzwsVar = this.zza;
        zzws zzwsVar2 = zzvyVar.zza;
        if (zzwsVar == null && zzwsVar2 == null) {
            return zzb().equals(zzvyVar.zzb());
        }
        if (zzwsVar != null && zzwsVar2 != null) {
            return zzwsVar.equals(zzwsVar2);
        }
        if (zzwsVar != null) {
            zzvyVar.zzc(zzwsVar.zzq());
            return zzwsVar.equals(zzvyVar.zza);
        }
        zzc(zzwsVar2.zzq());
        return this.zza.equals(zzwsVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzui) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzu();
        }
        return 0;
    }

    public final zzul zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzul.zzb;
            } else {
                this.zzc = this.zza.zzM();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzws zzwsVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzwsVar;
                this.zzc = zzul.zzb;
            } catch (zzvv unused) {
                this.zza = zzwsVar;
                this.zzc = zzul.zzb;
            }
        }
    }
}
