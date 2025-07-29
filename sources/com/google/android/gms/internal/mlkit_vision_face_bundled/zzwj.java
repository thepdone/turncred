package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzwj implements zzwq {
    private final zzwq[] zza;

    zzwj(zzwq... zzwqVarArr) {
        this.zza = zzwqVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwq
    public final zzwp zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzwq zzwqVar = this.zza[i];
            if (zzwqVar.zzc(cls)) {
                return zzwqVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwq
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
