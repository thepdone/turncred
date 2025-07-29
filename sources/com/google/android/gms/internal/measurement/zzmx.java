package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzmx {
    private static final zzmx zza = new zzmx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public final int zza() {
        int iZze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZze = zzjn.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                iZze = zzjn.zza(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                iZze = zzjn.zza(i5, (zziy) this.zzd[i3]);
            } else if (i6 == 3) {
                iZze = (zzjn.zzf(i5) << 1) + ((zzmx) this.zzd[i3]).zza();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzkp.zza());
                }
                iZze = zzjn.zzb(i5, ((Integer) this.zzd[i3]).intValue());
            }
            i2 += iZze;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzb = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            iZzb += zzjn.zzb(this.zzc[i2] >>> 3, (zziy) this.zzd[i2]);
        }
        this.zze = iZzb;
        return iZzb;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public static zzmx zzc() {
        return zza;
    }

    final zzmx zza(zzmx zzmxVar) {
        if (zzmxVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzmxVar.zzb;
        zza(i);
        System.arraycopy(zzmxVar.zzc, 0, this.zzc, this.zzb, zzmxVar.zzb);
        System.arraycopy(zzmxVar.zzd, 0, this.zzd, this.zzb, zzmxVar.zzb);
        this.zzb = i;
        return this;
    }

    static zzmx zza(zzmx zzmxVar, zzmx zzmxVar2) {
        int i = zzmxVar.zzb + zzmxVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzmxVar.zzc, i);
        System.arraycopy(zzmxVar2.zzc, 0, iArrCopyOf, zzmxVar.zzb, zzmxVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzmxVar.zzd, i);
        System.arraycopy(zzmxVar2.zzd, 0, objArrCopyOf, zzmxVar.zzb, zzmxVar2.zzb);
        return new zzmx(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzmx zzd() {
        return new zzmx();
    }

    private zzmx() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmx(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    private final void zza(int i) {
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

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzlr.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zza(zznl zznlVar) throws IOException {
        if (zznlVar.zza() == 2) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zznlVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zznlVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zznl zznlVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zznlVar.zzb(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zznlVar.zza(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zznlVar.zza(i2, (zziy) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zznlVar.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzkp.zza());
        }
        if (zznlVar.zza() == 1) {
            zznlVar.zzb(i2);
            ((zzmx) obj).zzb(zznlVar);
            zznlVar.zza(i2);
        } else {
            zznlVar.zza(i2);
            ((zzmx) obj).zzb(zznlVar);
            zznlVar.zzb(i2);
        }
    }

    public final void zzb(zznl zznlVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zznlVar.zza() == 1) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zznlVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zznlVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmx)) {
            return false;
        }
        zzmx zzmxVar = (zzmx) obj;
        int i = this.zzb;
        if (i == zzmxVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmxVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmxVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
