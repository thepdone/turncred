package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes3.dex */
public final class zzad extends zzeh implements zzfn {
    private static final zzad zzb;
    private int zzd;
    private int zze = 4369;
    private String zzf = "";

    static {
        zzad zzadVar = new zzad();
        zzb = zzadVar;
        zzeh.zzV(zzad.class, zzadVar);
    }

    private zzad() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzq.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzad();
        }
        zzab zzabVar = null;
        if (i2 == 4) {
            return new zzac(zzabVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
