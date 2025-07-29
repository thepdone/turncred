package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzvb {
    private static final zzuz zza = new zzva();
    private static final zzuz zzb;

    static {
        zzuz zzuzVar;
        try {
            zzuzVar = (zzuz) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzuzVar = null;
        }
        zzb = zzuzVar;
    }

    static zzuz zza() {
        zzuz zzuzVar = zzb;
        if (zzuzVar != null) {
            return zzuzVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzuz zzb() {
        return zza;
    }
}
