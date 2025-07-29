package com.google.android.gms.internal.mlkit_vision_face_bundled;

import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzyd extends zzyf {
    zzyd(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zzc(Object obj, long j, boolean z) {
        if (zzyg.zzb) {
            zzyg.zzD(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzyg.zzE(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zzd(Object obj, long j, byte b) {
        if (zzyg.zzb) {
            zzyg.zzD(obj, j, b);
        } else {
            zzyg.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final boolean zzg(Object obj, long j) {
        return zzyg.zzb ? zzyg.zzt(obj, j) : zzyg.zzu(obj, j);
    }
}
