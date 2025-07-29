package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public enum zznu implements zzbz {
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    TYPE_GMV(3);

    private final int zzf;

    zznu(int i) {
        this.zzf = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbz
    public final int zza() {
        return this.zzf;
    }
}
