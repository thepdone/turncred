package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzjc extends zzjf {
    private final int zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.measurement.zzjf, com.google.android.gms.internal.measurement.zziy
    public final byte zza(int i) {
        int iZzb = zzb();
        if (((iZzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzjf, com.google.android.gms.internal.measurement.zziy
    final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.measurement.zzjf
    protected final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjf, com.google.android.gms.internal.measurement.zziy
    public final int zzb() {
        return this.zzd;
    }

    zzjc(byte[] bArr, int i, int i2) {
        super(bArr);
        zza(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }
}
