package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzxv extends RuntimeException {
    public zzxv(zzws zzwsVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzvv zza() {
        return new zzvv(getMessage());
    }
}
