package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzar extends zzvn implements zzwt {
    private static final zzar zzb;
    private int zzd;
    private zzul zze = zzul.zzb;
    private String zzf = "";
    private String zzg = "";

    static {
        zzar zzarVar = new zzar();
        zzb = zzarVar;
        zzvn.zzF(zzar.class, zzarVar);
    }

    private zzar() {
    }

    public static zzaq zza() {
        return (zzaq) zzb.zzv();
    }

    static /* synthetic */ void zzc(zzar zzarVar, String str) {
        zzarVar.zzd |= 2;
        zzarVar.zzf = str;
    }

    static /* synthetic */ void zzd(zzar zzarVar, String str) {
        zzarVar.zzd |= 4;
        zzarVar.zzg = str;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
    protected final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzC(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzar();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzaq(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
