package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes3.dex */
final class zzea implements zzfk {
    private static final zzea zza = new zzea();

    private zzea() {
    }

    public static zzea zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public final zzfj zzb(Class cls) {
        if (!zzeh.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzfj) zzeh.zzJ(cls.asSubclass(zzeh.class)).zzg(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public final boolean zzc(Class cls) {
        return zzeh.class.isAssignableFrom(cls);
    }
}
