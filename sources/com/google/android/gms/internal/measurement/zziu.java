package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zziu {
    private static volatile int zza = 100;

    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    static int zza(byte[] bArr, int i, zzit zzitVar) throws zzkp {
        int iZzc = zzc(bArr, i, zzitVar);
        int i2 = zzitVar.zza;
        if (i2 < 0) {
            throw zzkp.zzf();
        }
        if (i2 > bArr.length - iZzc) {
            throw zzkp.zzi();
        }
        if (i2 == 0) {
            zzitVar.zzc = zziy.zza;
            return iZzc;
        }
        zzitVar.zzc = zziy.zza(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzlm zzlmVar, zzmu<zzmx, zzmx> zzmuVar, zzit zzitVar) throws IOException {
        if (zzitVar.zzd.zza(zzlmVar, i >>> 3) == null) {
            return zza(i, bArr, i2, i3, zzlq.zzc(obj), zzitVar);
        }
        zzkg.zzb zzbVar = (zzkg.zzb) obj;
        zzbVar.zza();
        zzjw<zzkg.zze> zzjwVar = zzbVar.zzc;
        throw new NoSuchMethodError();
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static <T> int zza(zzme<T> zzmeVar, byte[] bArr, int i, int i2, int i3, zzit zzitVar) throws IOException {
        T tZza = zzmeVar.zza();
        int iZza = zza(tZza, zzmeVar, bArr, i, i2, i3, zzitVar);
        zzmeVar.zzd(tZza);
        zzitVar.zzc = tZza;
        return iZza;
    }

    static int zza(zzme<?> zzmeVar, int i, byte[] bArr, int i2, int i3, zzkm<Object> zzkmVar, zzit zzitVar) throws IOException {
        int i4 = (i & (-8)) | 4;
        int iZza = zza(zzmeVar, bArr, i2, i3, i4, zzitVar);
        zzkmVar.add(zzitVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzitVar);
            if (i != zzitVar.zza) {
                break;
            }
            iZza = zza(zzmeVar, bArr, iZzc, i3, i4, zzitVar);
            zzkmVar.add(zzitVar.zzc);
        }
        return iZza;
    }

    static <T> int zza(zzme<T> zzmeVar, byte[] bArr, int i, int i2, zzit zzitVar) throws IOException {
        T tZza = zzmeVar.zza();
        int iZza = zza(tZza, zzmeVar, bArr, i, i2, zzitVar);
        zzmeVar.zzd(tZza);
        zzitVar.zzc = tZza;
        return iZza;
    }

    static int zzb(zzme<?> zzmeVar, int i, byte[] bArr, int i2, int i3, zzkm<?> zzkmVar, zzit zzitVar) throws IOException {
        int iZza = zza(zzmeVar, bArr, i2, i3, zzitVar);
        zzkmVar.add(zzitVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzitVar);
            if (i != zzitVar.zza) {
                break;
            }
            iZza = zza(zzmeVar, bArr, iZzc, i3, zzitVar);
            zzkmVar.add(zzitVar.zzc);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzkm<?> zzkmVar, zzit zzitVar) throws IOException {
        zzkh zzkhVar = (zzkh) zzkmVar;
        int iZzc = zzc(bArr, i, zzitVar);
        int i2 = zzitVar.zza + iZzc;
        while (iZzc < i2) {
            iZzc = zzc(bArr, iZzc, zzitVar);
            zzkhVar.zzd(zzitVar.zza);
        }
        if (iZzc == i2) {
            return iZzc;
        }
        throw zzkp.zzi();
    }

    static int zzb(byte[] bArr, int i, zzit zzitVar) throws zzkp {
        int iZzc = zzc(bArr, i, zzitVar);
        int i2 = zzitVar.zza;
        if (i2 < 0) {
            throw zzkp.zzf();
        }
        if (i2 == 0) {
            zzitVar.zzc = "";
            return iZzc;
        }
        zzitVar.zzc = zzna.zzb(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzmx zzmxVar, zzit zzitVar) throws zzkp {
        if ((i >>> 3) == 0) {
            throw zzkp.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzd = zzd(bArr, i2, zzitVar);
            zzmxVar.zza(i, Long.valueOf(zzitVar.zzb));
            return iZzd;
        }
        if (i4 == 1) {
            zzmxVar.zza(i, Long.valueOf(zzd(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzc = zzc(bArr, i2, zzitVar);
            int i5 = zzitVar.zza;
            if (i5 < 0) {
                throw zzkp.zzf();
            }
            if (i5 > bArr.length - iZzc) {
                throw zzkp.zzi();
            }
            if (i5 == 0) {
                zzmxVar.zza(i, zziy.zza);
            } else {
                zzmxVar.zza(i, zziy.zza(bArr, iZzc, i5));
            }
            return iZzc + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzmxVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            }
            throw zzkp.zzc();
        }
        zzmx zzmxVarZzd = zzmx.zzd();
        int i6 = (i & (-8)) | 4;
        zzitVar.zze++;
        zza(zzitVar.zze);
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzc2 = zzc(bArr, i2, zzitVar);
            int i8 = zzitVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzc2;
                break;
            }
            int iZza = zza(i7, bArr, iZzc2, i3, zzmxVarZzd, zzitVar);
            i7 = i8;
            i2 = iZza;
        }
        zzitVar.zze--;
        if (i2 > i3 || i7 != i6) {
            throw zzkp.zzg();
        }
        zzmxVar.zza(i, zzmxVarZzd);
        return i2;
    }

    static int zzc(byte[] bArr, int i, zzit zzitVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzitVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzitVar);
    }

    static int zza(int i, byte[] bArr, int i2, zzit zzitVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzitVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzitVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzitVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzitVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzitVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzkm<?> zzkmVar, zzit zzitVar) {
        zzkh zzkhVar = (zzkh) zzkmVar;
        int iZzc = zzc(bArr, i2, zzitVar);
        zzkhVar.zzd(zzitVar.zza);
        while (iZzc < i3) {
            int iZzc2 = zzc(bArr, iZzc, zzitVar);
            if (i != zzitVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzitVar);
            zzkhVar.zzd(zzitVar.zza);
        }
        return iZzc;
    }

    static int zzd(byte[] bArr, int i, zzit zzitVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzitVar.zzb = j;
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
        zzitVar.zzb = j2;
        return i3;
    }

    static <T> int zza(Object obj, zzme<T> zzmeVar, byte[] bArr, int i, int i2, int i3, zzit zzitVar) throws IOException {
        zzitVar.zze++;
        zza(zzitVar.zze);
        int iZza = ((zzlq) zzmeVar).zza((zzlq) obj, bArr, i, i2, i3, zzitVar);
        zzitVar.zze--;
        zzitVar.zzc = obj;
        return iZza;
    }

    static <T> int zza(Object obj, zzme<T> zzmeVar, byte[] bArr, int i, int i2, zzit zzitVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzitVar);
            i3 = zzitVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzkp.zzi();
        }
        zzitVar.zze++;
        zza(zzitVar.zze);
        int i5 = i3 + i4;
        zzmeVar.zza(obj, bArr, i4, i5, zzitVar);
        zzitVar.zze--;
        zzitVar.zzc = obj;
        return i5;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzit zzitVar) throws zzkp {
        if ((i >>> 3) == 0) {
            throw zzkp.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzitVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, zzitVar) + zzitVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzkp.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzc(bArr, i2, zzitVar);
            i6 = zzitVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzitVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzkp.zzg();
        }
        return i2;
    }

    static long zzd(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private static void zza(int i) throws zzkp {
        if (i >= zza) {
            throw zzkp.zzh();
        }
    }
}
