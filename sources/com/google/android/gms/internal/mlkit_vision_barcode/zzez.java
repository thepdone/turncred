package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
final class zzez implements zzfe {
    private final int zza;
    private final zzfd zzb;

    zzez(int i, zzfd zzfdVar) {
        this.zza = i;
        this.zzb = zzfdVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzfe.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfe)) {
            return false;
        }
        zzfe zzfeVar = (zzfe) obj;
        return this.zza == zzfeVar.zza() && this.zzb.equals(zzfeVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfe
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfe
    public final zzfd zzb() {
        return this.zzb;
    }
}
