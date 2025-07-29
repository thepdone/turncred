package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public enum zznc implements zzbz {
    UNKNOWN_PERFORMANCE(0),
    FAST(1),
    ACCURATE(2);

    private final int zze;

    zznc(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbz
    public final int zza() {
        return this.zze;
    }
}
