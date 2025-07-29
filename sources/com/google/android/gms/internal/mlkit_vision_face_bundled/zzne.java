package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzne {
    private final zznb zza;
    private final zzmz zzb;
    private final zznc zzc;
    private final zzna zzd;
    private final Boolean zze;
    private final Float zzf;

    /* synthetic */ zzne(zzmy zzmyVar, zznd zzndVar) {
        this.zza = zzmyVar.zza;
        this.zzb = zzmyVar.zzb;
        this.zzc = zzmyVar.zzc;
        this.zzd = zzmyVar.zzd;
        this.zze = zzmyVar.zze;
        this.zzf = zzmyVar.zzf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzne)) {
            return false;
        }
        zzne zzneVar = (zzne) obj;
        return Objects.equal(this.zza, zzneVar.zza) && Objects.equal(this.zzb, zzneVar.zzb) && Objects.equal(this.zzc, zzneVar.zzc) && Objects.equal(this.zzd, zzneVar.zzd) && Objects.equal(this.zze, zzneVar.zze) && Objects.equal(this.zzf, zzneVar.zzf);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    public final zzmz zza() {
        return this.zzb;
    }

    public final zzna zzb() {
        return this.zzd;
    }

    public final zznb zzc() {
        return this.zza;
    }

    public final zznc zzd() {
        return this.zzc;
    }

    public final Boolean zze() {
        return this.zze;
    }

    public final Float zzf() {
        return this.zzf;
    }
}
