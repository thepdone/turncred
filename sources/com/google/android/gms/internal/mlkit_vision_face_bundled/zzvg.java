package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzvg implements zzwq {
    private static final zzvg zza = new zzvg();

    private zzvg() {
    }

    public static zzvg zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwq
    public final zzwp zzb(Class cls) {
        if (!zzvn.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzwp) zzvn.zzx(cls.asSubclass(zzvn.class)).zzf(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwq
    public final boolean zzc(Class cls) {
        return zzvn.class.isAssignableFrom(cls);
    }
}
