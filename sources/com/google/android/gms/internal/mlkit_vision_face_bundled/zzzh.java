package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzzh extends zzvn implements zzwt {
    private static final zzzh zzb;
    private byte zze = 2;
    private zzvs zzd = zzA();

    static {
        zzzh zzzhVar = new zzzh();
        zzb = zzzhVar;
        zzvn.zzF(zzzh.class, zzzhVar);
    }

    private zzzh() {
    }

    public static zzzh zzd() {
        return zzb;
    }

    public final List zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzd", zzze.class});
        }
        if (i2 == 3) {
            return new zzzh();
        }
        zzzf zzzfVar = null;
        if (i2 == 4) {
            return new zzzg(zzzfVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
