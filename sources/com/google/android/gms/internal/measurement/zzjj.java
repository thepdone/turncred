package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzjj extends zzjk {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final byte zzw() throws IOException {
        int i = this.zzg;
        if (i == this.zze) {
            throw zzkp.zzi();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzz());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzc() {
        return this.zzg - this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zza(int i) throws zzkp {
        if (i < 0) {
            throw zzkp.zzf();
        }
        int iZzc = i + zzc();
        if (iZzc < 0) {
            throw zzkp.zzg();
        }
        int i2 = this.zzj;
        if (iZzc > i2) {
            throw zzkp.zzi();
        }
        this.zzj = iZzc;
        zzab();
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzd() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zze() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzf() throws IOException {
        return zzy();
    }

    private final int zzx() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 4) {
            throw zzkp.zzi();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final int zzy() throws IOException {
        int i;
        int i2 = this.zzg;
        int i3 = this.zze;
        if (i3 != i2) {
            byte[] bArr = this.zzd;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzg = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzg = i5;
                return i;
            }
        }
        return (int) zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzg() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzh() throws IOException {
        return zze(zzy());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzi() throws IOException {
        if (zzt()) {
            this.zzi = 0;
            return 0;
        }
        int iZzy = zzy();
        this.zzi = iZzy;
        if ((iZzy >>> 3) != 0) {
            return iZzy;
        }
        throw zzkp.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzj() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzk() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzl() throws IOException {
        return zzaa();
    }

    private final long zzz() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 8) {
            throw zzkp.zzi();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final long zzaa() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzg;
        int i2 = this.zze;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzg = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (bArr[i8] << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (bArr[i4] << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (bArr[i10] << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (bArr[i4] << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j6 ^ j3;
                        }
                    }
                }
                this.zzg = i4;
                return j;
            }
        }
        return zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzw() & 128) == 0) {
                return j;
            }
        }
        throw zzkp.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzn() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzo() throws IOException {
        return zza(zzaa());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzp() throws IOException {
        return zzaa();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.measurement.zzjk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zziy zzq() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.zzy()
            if (r0 <= 0) goto L19
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zzd
            com.google.android.gms.internal.measurement.zziy r1 = com.google.android.gms.internal.measurement.zziy.zza(r1, r2, r0)
            int r2 = r3.zzg
            int r2 = r2 + r0
            r3.zzg = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.measurement.zziy r0 = com.google.android.gms.internal.measurement.zziy.zza
            return r0
        L1e:
            if (r0 <= 0) goto L31
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L31
            int r0 = r0 + r2
            r3.zzg = r0
            byte[] r1 = r3.zzd
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L37
        L31:
            if (r0 > 0) goto L41
            if (r0 != 0) goto L3c
            byte[] r0 = com.google.android.gms.internal.measurement.zzkj.zzb
        L37:
            com.google.android.gms.internal.measurement.zziy r0 = com.google.android.gms.internal.measurement.zziy.zzb(r0)
            return r0
        L3c:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r0
        L41:
            com.google.android.gms.internal.measurement.zzkp r0 = com.google.android.gms.internal.measurement.zzkp.zzi()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjj.zzq():com.google.android.gms.internal.measurement.zziy");
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final String zzr() throws IOException {
        int iZzy = zzy();
        if (iZzy > 0 && iZzy <= this.zze - this.zzg) {
            String str = new String(this.zzd, this.zzg, iZzy, zzkj.zza);
            this.zzg += iZzy;
            return str;
        }
        if (iZzy == 0) {
            return "";
        }
        if (iZzy < 0) {
            throw zzkp.zzf();
        }
        throw zzkp.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final String zzs() throws IOException {
        int iZzy = zzy();
        if (iZzy > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (iZzy <= i - i2) {
                String strZzb = zzna.zzb(this.zzd, i2, iZzy);
                this.zzg += iZzy;
                return strZzb;
            }
        }
        if (iZzy == 0) {
            return "";
        }
        if (iZzy <= 0) {
            throw zzkp.zzf();
        }
        throw zzkp.zzi();
    }

    private zzjj(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzj = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zze = i2 + i;
        this.zzg = i;
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final void zzb(int i) throws zzkp {
        if (this.zzi != i) {
            throw zzkp.zzb();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final void zzc(int i) {
        this.zzj = i;
        zzab();
    }

    private final void zzab() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i2 = i - this.zzh;
        int i3 = this.zzj;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzf = i4;
            this.zze = i - i4;
            return;
        }
        this.zzf = 0;
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zze;
            int i3 = this.zzg;
            if (i <= i2 - i3) {
                this.zzg = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzkp.zzf();
        }
        throw zzkp.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzt() throws IOException {
        return this.zzg == this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzu() throws IOException {
        return zzaa() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzd(int i) throws IOException {
        boolean zZzd;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zze - this.zzg >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzg;
                    this.zzg = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzkp.zze();
            }
            while (i3 < 10) {
                if (zzw() < 0) {
                    i3++;
                }
            }
            throw zzkp.zze();
            return true;
        }
        if (i2 == 1) {
            zzf(8);
            return true;
        }
        if (i2 == 2) {
            zzf(zzy());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                if (this.zzb == 0) {
                    zzb(0);
                }
                return false;
            }
            if (i2 == 5) {
                zzf(4);
                return true;
            }
            throw zzkp.zza();
        }
        do {
            int iZzi = zzi();
            if (iZzi == 0) {
                break;
            }
            zzv();
            this.zzb++;
            zZzd = zzd(iZzi);
            this.zzb--;
        } while (zZzd);
        zzb(((i >>> 3) << 3) | 4);
        return true;
    }
}
