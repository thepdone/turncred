package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzaz implements zzax {
    private static final zzax zza = new zzax() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzay
    };
    private volatile zzax zzb;

    zzaz(zzax zzaxVar) {
        this.zzb = zzaxVar;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned null>";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }
}
