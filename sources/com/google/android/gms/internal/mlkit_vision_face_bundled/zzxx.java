package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzxx {
    private static final zzxx zza = new zzxx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzxx() {
        this(0, new int[8], new Object[8], true);
    }

    private zzxx(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzxx zzc() {
        return zza;
    }

    static zzxx zze(zzxx zzxxVar, zzxx zzxxVar2) {
        int i = zzxxVar.zzb + zzxxVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzxxVar.zzc, i);
        System.arraycopy(zzxxVar2.zzc, 0, iArrCopyOf, zzxxVar.zzb, zzxxVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzxxVar.zzd, i);
        System.arraycopy(zzxxVar2.zzd, 0, objArrCopyOf, zzxxVar.zzb, zzxxVar2.zzb);
        return new zzxx(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzxx zzf() {
        return new zzxx(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzxx)) {
            return false;
        }
        zzxx zzxxVar = (zzxx) obj;
        int i = this.zzb;
        if (i == zzxxVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzxxVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzxxVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzw;
        int iZzx;
        int iZzw2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzw2 = zzut.zzw(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzul zzulVar = (zzul) this.zzd[i3];
                    int iZzw3 = zzut.zzw(i7);
                    int iZzd = zzulVar.zzd();
                    iZzw2 = iZzw3 + zzut.zzw(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int iZzw4 = zzut.zzw(i5 << 3);
                    iZzw = iZzw4 + iZzw4;
                    iZzx = ((zzxx) this.zzd[i3]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzvv.zza());
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzw2 = zzut.zzw(i5 << 3) + 4;
                }
                i2 += iZzw2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzw = zzut.zzw(i8);
                iZzx = zzut.zzx(jLongValue);
            }
            iZzw2 = iZzw + iZzx;
            i2 += iZzw2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzw = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzul zzulVar = (zzul) this.zzd[i2];
            int iZzw2 = zzut.zzw(8);
            int iZzw3 = zzut.zzw(16) + zzut.zzw(i3);
            int iZzw4 = zzut.zzw(24);
            int iZzd = zzulVar.zzd();
            iZzw += iZzw2 + iZzw2 + iZzw3 + iZzw4 + zzut.zzw(iZzd) + iZzd;
        }
        this.zze = iZzw;
        return iZzw;
    }

    final zzxx zzd(zzxx zzxxVar) {
        if (zzxxVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzxxVar.zzb;
        zzm(i);
        System.arraycopy(zzxxVar.zzc, 0, this.zzc, this.zzb, zzxxVar.zzb);
        System.arraycopy(zzxxVar.zzd, 0, this.zzd, this.zzb, zzxxVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzwu.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zzk(zzyo zzyoVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzyoVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzyo zzyoVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzyoVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzyoVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzyoVar.zzd(i4, (zzul) obj);
                } else if (i3 == 3) {
                    zzyoVar.zzF(i4);
                    ((zzxx) obj).zzl(zzyoVar);
                    zzyoVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzvv.zza());
                    }
                    zzyoVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
