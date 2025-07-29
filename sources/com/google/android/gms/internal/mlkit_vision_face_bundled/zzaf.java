package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzaf extends zzvn implements zzwt {
    private static final zzaf zzb;
    private int zzd;
    private zzzh zze;
    private byte zzf = 2;

    static {
        zzaf zzafVar = new zzaf();
        zzb = zzafVar;
        zzvn.zzF(zzaf.class, zzafVar);
    }

    private zzaf() {
    }

    public static zzaf zzb(byte[] bArr, zzuy zzuyVar) throws zzvv {
        return (zzaf) zzvn.zzz(zzb, bArr, zzuyVar);
    }

    public final zzzh zzc() {
        zzzh zzzhVar = this.zze;
        return zzzhVar == null ? zzzh.zzd() : zzzhVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaf();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzae(zzrVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
