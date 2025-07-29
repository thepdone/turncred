package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public enum zznb implements zzbz {
    UNKNOWN_LANDMARKS(0),
    NO_LANDMARKS(1),
    ALL_LANDMARKS(2);

    private final int zze;

    zznb(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbz
    public final int zza() {
        return this.zze;
    }
}
