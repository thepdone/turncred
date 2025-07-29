package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzsk extends zzso {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zzsk(String str, boolean z, int i, zzsj zzsjVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzso) {
            zzso zzsoVar = (zzso) obj;
            if (this.zza.equals(zzsoVar.zzb()) && this.zzb == zzsoVar.zzc() && this.zzc == zzsoVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.zza + ", enableFirelog=" + this.zzb + ", firelogEventType=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzso
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzso
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzso
    public final boolean zzc() {
        return this.zzb;
    }
}
