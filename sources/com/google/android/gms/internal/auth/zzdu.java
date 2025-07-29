package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzdu {
    static int zza(byte[] bArr, int i, zzdt zzdtVar) throws zzfb {
        int iZzh = zzh(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 < 0) {
            throw zzfb.zzc();
        }
        if (i2 > bArr.length - iZzh) {
            throw zzfb.zzf();
        }
        if (i2 == 0) {
            zzdtVar.zzc = zzef.zzb;
            return iZzh;
        }
        zzdtVar.zzc = zzef.zzk(bArr, iZzh, i2);
        return iZzh + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzgi zzgiVar, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        Object objZzd = zzgiVar.zzd();
        int iZzl = zzl(objZzd, zzgiVar, bArr, i, i2, i3, zzdtVar);
        zzgiVar.zze(objZzd);
        zzdtVar.zzc = objZzd;
        return iZzl;
    }

    static int zzd(zzgi zzgiVar, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        Object objZzd = zzgiVar.zzd();
        int iZzm = zzm(objZzd, zzgiVar, bArr, i, i2, zzdtVar);
        zzgiVar.zze(objZzd);
        zzdtVar.zzc = objZzd;
        return iZzm;
    }

    static int zze(zzgi zzgiVar, int i, byte[] bArr, int i2, int i3, zzez zzezVar, zzdt zzdtVar) throws IOException {
        int iZzd = zzd(zzgiVar, bArr, i2, i3, zzdtVar);
        zzezVar.add(zzdtVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            iZzd = zzd(zzgiVar, bArr, iZzh, i3, zzdtVar);
            zzezVar.add(zzdtVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzez zzezVar, zzdt zzdtVar) throws IOException {
        zzew zzewVar = (zzew) zzezVar;
        int iZzh = zzh(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzdtVar);
            zzewVar.zze(zzdtVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw zzfb.zzf();
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzha zzhaVar, zzdt zzdtVar) throws zzfb {
        if ((i >>> 3) == 0) {
            throw zzfb.zza();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzdtVar);
            zzhaVar.zzh(i, Long.valueOf(zzdtVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzhaVar.zzh(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzdtVar);
            int i5 = zzdtVar.zza;
            if (i5 < 0) {
                throw zzfb.zzc();
            }
            if (i5 > bArr.length - iZzh) {
                throw zzfb.zzf();
            }
            if (i5 == 0) {
                zzhaVar.zzh(i, zzef.zzb);
            } else {
                zzhaVar.zzh(i, zzef.zzk(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzfb.zza();
            }
            zzhaVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzha zzhaVarZzd = zzha.zzd();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzh2 = zzh(bArr, i2, zzdtVar);
            int i8 = zzdtVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzh2;
                break;
            }
            int iZzg = zzg(i7, bArr, iZzh2, i3, zzhaVarZzd, zzdtVar);
            i7 = i8;
            i2 = iZzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzfb.zzd();
        }
        zzhaVar.zzh(i, zzhaVarZzd);
        return i2;
    }

    static int zzh(byte[] bArr, int i, zzdt zzdtVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzdtVar);
        }
        zzdtVar.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzdt zzdtVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzdtVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzdtVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdtVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdtVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdtVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzez zzezVar, zzdt zzdtVar) {
        zzew zzewVar = (zzew) zzezVar;
        int iZzh = zzh(bArr, i2, zzdtVar);
        zzewVar.zze(zzdtVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzdtVar);
            zzewVar.zze(zzdtVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i, zzdt zzdtVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzdtVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzdtVar.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzgi zzgiVar, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        int iZzb = ((zzga) zzgiVar).zzb(obj, bArr, i, i2, i3, zzdtVar);
        zzdtVar.zzc = obj;
        return iZzb;
    }

    static int zzm(Object obj, zzgi zzgiVar, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzdtVar);
            i3 = zzdtVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzfb.zzf();
        }
        int i5 = i3 + i4;
        zzgiVar.zzg(obj, bArr, i4, i5, zzdtVar);
        zzdtVar.zzc = obj;
        return i5;
    }

    static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
