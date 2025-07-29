package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzad extends zzvn implements zzwt {
    private static final zzad zzb;
    private int zzd;
    private int zze;
    private zzvs zzf = zzA();

    static {
        zzad zzadVar = new zzad();
        zzb = zzadVar;
        zzvn.zzF(zzad.class, zzadVar);
    }

    private zzad() {
    }

    public static zzad zzb() {
        return zzb;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final int zzd() {
        int iZza = zzac.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzd", "zze", zzab.zza, "zzf", zzz.class});
        }
        if (i2 == 3) {
            return new zzad();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzx(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
