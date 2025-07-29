package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zztz {
    static int zza(byte[] bArr, int i, zzty zztyVar) throws zzvv {
        int iZzi = zzi(bArr, i, zztyVar);
        int i2 = zztyVar.zza;
        if (i2 < 0) {
            throw zzvv.zzd();
        }
        if (i2 > bArr.length - iZzi) {
            throw zzvv.zzg();
        }
        if (i2 == 0) {
            zztyVar.zzc = zzul.zzb;
            return iZzi;
        }
        zztyVar.zzc = zzul.zzl(bArr, iZzi, i2);
        return iZzi + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzxf zzxfVar, byte[] bArr, int i, int i2, int i3, zzty zztyVar) throws IOException {
        Object objZze = zzxfVar.zze();
        int iZzm = zzm(objZze, zzxfVar, bArr, i, i2, i3, zztyVar);
        zzxfVar.zzf(objZze);
        zztyVar.zzc = objZze;
        return iZzm;
    }

    static int zzd(zzxf zzxfVar, byte[] bArr, int i, int i2, zzty zztyVar) throws IOException {
        Object objZze = zzxfVar.zze();
        int iZzn = zzn(objZze, zzxfVar, bArr, i, i2, zztyVar);
        zzxfVar.zzf(objZze);
        zztyVar.zzc = objZze;
        return iZzn;
    }

    static int zze(zzxf zzxfVar, int i, byte[] bArr, int i2, int i3, zzvs zzvsVar, zzty zztyVar) throws IOException {
        int iZzd = zzd(zzxfVar, bArr, i2, i3, zztyVar);
        zzvsVar.add(zztyVar.zzc);
        while (iZzd < i3) {
            int iZzi = zzi(bArr, iZzd, zztyVar);
            if (i != zztyVar.zza) {
                break;
            }
            iZzd = zzd(zzxfVar, bArr, iZzi, i3, zztyVar);
            zzvsVar.add(zztyVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzvs zzvsVar, zzty zztyVar) throws IOException {
        zzvo zzvoVar = (zzvo) zzvsVar;
        int iZzi = zzi(bArr, i, zztyVar);
        int i2 = zztyVar.zza + iZzi;
        while (iZzi < i2) {
            iZzi = zzi(bArr, iZzi, zztyVar);
            zzvoVar.zzf(zztyVar.zza);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw zzvv.zzg();
    }

    static int zzg(byte[] bArr, int i, zzty zztyVar) throws zzvv {
        int iZzi = zzi(bArr, i, zztyVar);
        int i2 = zztyVar.zza;
        if (i2 < 0) {
            throw zzvv.zzd();
        }
        if (i2 == 0) {
            zztyVar.zzc = "";
            return iZzi;
        }
        zztyVar.zzc = new String(bArr, iZzi, i2, zzvt.zzb);
        return iZzi + i2;
    }

    static int zzh(int i, byte[] bArr, int i2, int i3, zzxx zzxxVar, zzty zztyVar) throws zzvv {
        if ((i >>> 3) == 0) {
            throw zzvv.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzl = zzl(bArr, i2, zztyVar);
            zzxxVar.zzj(i, Long.valueOf(zztyVar.zzb));
            return iZzl;
        }
        if (i4 == 1) {
            zzxxVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzi = zzi(bArr, i2, zztyVar);
            int i5 = zztyVar.zza;
            if (i5 < 0) {
                throw zzvv.zzd();
            }
            if (i5 > bArr.length - iZzi) {
                throw zzvv.zzg();
            }
            if (i5 == 0) {
                zzxxVar.zzj(i, zzul.zzb);
            } else {
                zzxxVar.zzj(i, zzul.zzl(bArr, iZzi, i5));
            }
            return iZzi + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzvv.zzb();
            }
            zzxxVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzxx zzxxVarZzf = zzxx.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzi2 = zzi(bArr, i2, zztyVar);
            int i8 = zztyVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzi2;
                break;
            }
            int iZzh = zzh(i7, bArr, iZzi2, i3, zzxxVarZzf, zztyVar);
            i7 = i8;
            i2 = iZzh;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzvv.zze();
        }
        zzxxVar.zzj(i, zzxxVarZzf);
        return i2;
    }

    static int zzi(byte[] bArr, int i, zzty zztyVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzj(b, bArr, i2, zztyVar);
        }
        zztyVar.zza = b;
        return i2;
    }

    static int zzj(int i, byte[] bArr, int i2, zzty zztyVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zztyVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zztyVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zztyVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zztyVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zztyVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzvs zzvsVar, zzty zztyVar) {
        zzvo zzvoVar = (zzvo) zzvsVar;
        int iZzi = zzi(bArr, i2, zztyVar);
        zzvoVar.zzf(zztyVar.zza);
        while (iZzi < i3) {
            int iZzi2 = zzi(bArr, iZzi, zztyVar);
            if (i != zztyVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zztyVar);
            zzvoVar.zzf(zztyVar.zza);
        }
        return iZzi;
    }

    static int zzl(byte[] bArr, int i, zzty zztyVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zztyVar.zzb = j;
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
        zztyVar.zzb = j2;
        return i3;
    }

    static int zzm(Object obj, zzxf zzxfVar, byte[] bArr, int i, int i2, int i3, zzty zztyVar) throws IOException {
        int iZzc = ((zzwv) zzxfVar).zzc(obj, bArr, i, i2, i3, zztyVar);
        zztyVar.zzc = obj;
        return iZzc;
    }

    static int zzn(Object obj, zzxf zzxfVar, byte[] bArr, int i, int i2, zzty zztyVar) throws IOException {
        int iZzj = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzj = zzj(i3, bArr, iZzj, zztyVar);
            i3 = zztyVar.zza;
        }
        int i4 = iZzj;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzvv.zzg();
        }
        int i5 = i3 + i4;
        zzxfVar.zzh(obj, bArr, i4, i5, zztyVar);
        zztyVar.zzc = obj;
        return i5;
    }

    static long zzp(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    static int zzo(int i, byte[] bArr, int i2, int i3, zzty zztyVar) throws zzvv {
        if ((i >>> 3) == 0) {
            throw zzvv.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzl(bArr, i2, zztyVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzi(bArr, i2, zztyVar) + zztyVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzvv.zzb();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzi(bArr, i2, zztyVar);
            i6 = zztyVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzo(i6, bArr, i2, i3, zztyVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzvv.zze();
        }
        return i2;
    }
}
