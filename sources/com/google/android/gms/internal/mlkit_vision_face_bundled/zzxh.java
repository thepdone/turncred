package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzxh {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzxw zzc;
    private static final zzxw zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzxw zzxwVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzxwVar = (zzxw) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzxwVar;
        zzd = new zzxy();
    }

    public static void zzA(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzs(i, list, z);
    }

    public static void zzB(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzu(i, list, z);
    }

    public static void zzC(int i, List list, zzyo zzyoVar, zzxf zzxfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzuu) zzyoVar).zzv(i, list.get(i2), zzxfVar);
        }
    }

    public static void zzD(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzy(i, list, z);
    }

    public static void zzE(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzA(i, list, z);
    }

    public static void zzF(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzC(i, list, z);
    }

    public static void zzG(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzE(i, list, z);
    }

    public static void zzH(int i, List list, zzyo zzyoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzH(i, list);
    }

    public static void zzI(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzJ(i, list, z);
    }

    public static void zzJ(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzL(i, list, z);
    }

    static boolean zzK(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvo) {
            zzvo zzvoVar = (zzvo) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(zzvoVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzut.zzw(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzut.zzw(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvo) {
            zzvo zzvoVar = (zzvo) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(zzvoVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzg(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwh) {
            zzwh zzwhVar = (zzwh) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(zzwhVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzh(int i, Object obj, zzxf zzxfVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzvy)) {
            return zzut.zzw(i2) + zzut.zzu((zzws) obj, zzxfVar);
        }
        int iZzw = zzut.zzw(i2);
        int iZza = ((zzvy) obj).zza();
        return iZzw + zzut.zzw(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzw;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvo) {
            zzvo zzvoVar = (zzvo) list;
            iZzw = 0;
            while (i < size) {
                int iZze = zzvoVar.zze(i);
                iZzw += zzut.zzw((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzw = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzw += zzut.zzw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzw;
    }

    static int zzj(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwh) {
            zzwh zzwhVar = (zzwh) list;
            iZzx = 0;
            while (i < size) {
                long jZze = zzwhVar.zze(i);
                iZzx += zzut.zzx((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzx += zzut.zzx((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzx;
    }

    static int zzk(List list) {
        int iZzw;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvo) {
            zzvo zzvoVar = (zzvo) list;
            iZzw = 0;
            while (i < size) {
                iZzw += zzut.zzw(zzvoVar.zze(i));
                i++;
            }
        } else {
            iZzw = 0;
            while (i < size) {
                iZzw += zzut.zzw(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzw;
    }

    static int zzl(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwh) {
            zzwh zzwhVar = (zzwh) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(zzwhVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzut.zzx(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzx;
    }

    public static zzxw zzm() {
        return zzc;
    }

    public static zzxw zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzxw zzxwVar) {
        if (obj2 == null) {
            obj2 = zzxwVar.zzc(obj);
        }
        zzxwVar.zzf(obj2, i, i2);
        return obj2;
    }

    static void zzp(zzuz zzuzVar, Object obj, Object obj2) {
        zzvd zzvdVarZzb = zzuzVar.zzb(obj2);
        if (zzvdVarZzb.zza.isEmpty()) {
            return;
        }
        zzuzVar.zzc(obj).zzi(zzvdVarZzb);
    }

    static void zzq(zzxw zzxwVar, Object obj, Object obj2) {
        zzxwVar.zzh(obj, zzxwVar.zze(zzxwVar.zzd(obj), zzxwVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzvn.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzs(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzc(i, list, z);
    }

    public static void zzt(int i, List list, zzyo zzyoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zze(i, list);
    }

    public static void zzu(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzg(i, list, z);
    }

    public static void zzv(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzj(i, list, z);
    }

    public static void zzw(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzl(i, list, z);
    }

    public static void zzx(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzn(i, list, z);
    }

    public static void zzy(int i, List list, zzyo zzyoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyoVar.zzp(i, list, z);
    }

    public static void zzz(int i, List list, zzyo zzyoVar, zzxf zzxfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzuu) zzyoVar).zzq(i, list.get(i2), zzxfVar);
        }
    }
}
