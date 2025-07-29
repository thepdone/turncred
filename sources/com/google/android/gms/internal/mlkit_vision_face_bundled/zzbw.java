package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbw implements zzcb {
    private final int zza;
    private final zzca zzb;

    zzbw(int i, zzca zzcaVar) {
        this.zza = i;
        this.zzb = zzcaVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzcb.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcb)) {
            return false;
        }
        zzcb zzcbVar = (zzcb) obj;
        return this.zza == zzcbVar.zza() && this.zzb.equals(zzcbVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzcb
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzcb
    public final zzca zzb() {
        return this.zzb;
    }
}
