package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
class zzui extends zzuh {
    protected final byte[] zza;

    zzui(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzul) || zzd() != ((zzul) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzui)) {
            return obj.equals(this);
        }
        zzui zzuiVar = (zzui) obj;
        int iZzk = zzk();
        int iZzk2 = zzuiVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzuiVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzuiVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzuiVar.zzd());
        }
        if (!(zzuiVar instanceof zzui)) {
            return zzuiVar.zzf(0, iZzd).equals(zzf(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzuiVar.zza;
        zzuiVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    protected final int zze(int i, int i2, int i3) {
        return zzvt.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    public final zzul zzf(int i, int i2) {
        int iZzj = zzj(0, i2, zzd());
        return iZzj == 0 ? zzul.zzb : new zzuf(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    final void zzh(zzub zzubVar) throws IOException {
        ((zzuq) zzubVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    public final boolean zzi() {
        return zzyl.zze(this.zza, 0, zzd());
    }
}
