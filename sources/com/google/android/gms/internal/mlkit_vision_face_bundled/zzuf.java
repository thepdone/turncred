package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzuf extends zzui {
    private final int zzc;

    zzuf(byte[] bArr, int i, int i2) {
        super(bArr);
        zzj(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzui, com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzui
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzui, com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzui, com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
