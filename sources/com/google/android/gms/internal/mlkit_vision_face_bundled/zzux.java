package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzux {
    private final Object zza;
    private final int zzb;

    zzux(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzux)) {
            return false;
        }
        zzux zzuxVar = (zzux) obj;
        return this.zza == zzuxVar.zza && this.zzb == zzuxVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
