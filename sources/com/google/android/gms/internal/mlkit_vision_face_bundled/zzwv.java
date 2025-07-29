package com.google.android.gms.internal.mlkit_vision_face_bundled;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.soloader.Elf64;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzwv<T> implements zzxf<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzyg.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzws zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzwg zzl;
    private final zzxw zzm;
    private final zzuz zzn;
    private final zzwy zzo;
    private final zzwn zzp;

    private zzwv(int[] iArr, Object[] objArr, int i, int i2, zzws zzwsVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzwy zzwyVar, zzwg zzwgVar, zzxw zzxwVar, zzuz zzuzVar, zzwn zzwnVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzuzVar != null && zzuzVar.zzg(zzwsVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzwyVar;
        this.zzl = zzwgVar;
        this.zzm = zzxwVar;
        this.zzn = zzuzVar;
        this.zzg = zzwsVar;
        this.zzp = zzwnVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzxf zzxfVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzxfVarZzv.zze();
                    zzxfVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzxfVarZzv.zze();
                zzxfVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzxfVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzxf zzxfVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzxfVarZzv.zze();
                    zzxfVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzxfVarZzv.zze();
                zzxfVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzxfVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzyg.zzq(obj, j, (1 << (iZzp >>> 20)) | zzyg.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzyg.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzyg.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzyg.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzyg.zzb(obj, j2)) != 0;
            case 2:
                return zzyg.zzd(obj, j2) != 0;
            case 3:
                return zzyg.zzd(obj, j2) != 0;
            case 4:
                return zzyg.zzc(obj, j2) != 0;
            case 5:
                return zzyg.zzd(obj, j2) != 0;
            case 6:
                return zzyg.zzc(obj, j2) != 0;
            case 7:
                return zzyg.zzw(obj, j2);
            case 8:
                Object objZzf = zzyg.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzul) {
                    return !zzul.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzyg.zzf(obj, j2) != null;
            case 10:
                return !zzul.zzb.equals(zzyg.zzf(obj, j2));
            case 11:
                return zzyg.zzc(obj, j2) != 0;
            case 12:
                return zzyg.zzc(obj, j2) != 0;
            case 13:
                return zzyg.zzc(obj, j2) != 0;
            case 14:
                return zzyg.zzd(obj, j2) != 0;
            case 15:
                return zzyg.zzc(obj, j2) != 0;
            case 16:
                return zzyg.zzd(obj, j2) != 0;
            case 17:
                return zzyg.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzxf zzxfVar) {
        return zzxfVar.zzk(zzyg.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzvn) {
            return ((zzvn) obj).zzI();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzyg.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzyg.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzyo zzyoVar) throws IOException {
        if (obj instanceof String) {
            zzyoVar.zzG(i, (String) obj);
        } else {
            zzyoVar.zzd(i, (zzul) obj);
        }
    }

    static zzxx zzd(Object obj) {
        zzvn zzvnVar = (zzvn) obj;
        zzxx zzxxVar = zzvnVar.zzc;
        if (zzxxVar != zzxx.zzc()) {
            return zzxxVar;
        }
        zzxx zzxxVarZzf = zzxx.zzf();
        zzvnVar.zzc = zzxxVarZzf;
        return zzxxVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv zzl(java.lang.Class r33, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwp r34, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwy r35, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwg r36, com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw r37, com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz r38, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwn r39) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzl(java.lang.Class, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwp, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwy, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwg, com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw, com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwn):com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzyg.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzyg.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzyg.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzyg.zzf(obj, j)).longValue();
    }

    private final zzvr zzu(int i) {
        int i2 = i / 3;
        return (zzvr) this.zzd[i2 + i2 + 1];
    }

    private final zzxf zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzxf zzxfVar = (zzxf) objArr[i3];
        if (zzxfVar != null) {
            return zzxfVar;
        }
        zzxf zzxfVarZzb = zzxb.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzxfVarZzb;
        return zzxfVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzxf zzxfVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzxfVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzxfVarZzv.zze();
        if (object != null) {
            zzxfVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzxf zzxfVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzxfVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzxfVarZzv.zze();
        if (object != null) {
            zzxfVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x054e  */
    /* JADX WARN: Type inference failed for: r0v112, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [com.google.android.gms.internal.mlkit_vision_face_bundled.zzwa] */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v117, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r0v182, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v253, types: [int] */
    /* JADX WARN: Type inference failed for: r0v260, types: [int] */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v126, types: [int] */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v169 */
    /* JADX WARN: Type inference failed for: r1v170 */
    /* JADX WARN: Type inference failed for: r1v171 */
    /* JADX WARN: Type inference failed for: r1v83, types: [int] */
    /* JADX WARN: Type inference failed for: r1v85 */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [int] */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 2194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzyg.zza(obj, j));
                    byte[] bArr = zzvt.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzyg.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzyg.zzd(obj, j);
                    byte[] bArr2 = zzvt.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzyg.zzd(obj, j);
                    byte[] bArr3 = zzvt.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzyg.zzd(obj, j);
                    byte[] bArr4 = zzvt.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzvt.zza(zzyg.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzyg.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzyg.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzyg.zzd(obj, j);
                    byte[] bArr5 = zzvt.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzyg.zzd(obj, j);
                    byte[] bArr6 = zzvt.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzyg.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzyg.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzvt.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_EHSIZE /* 52 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzvt.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_PHENTSIZE /* 54 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzvt.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzvt.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzvt.zza(zzN(obj, j));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzyg.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzyg.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzyg.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzvt.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzvt.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzyg.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i3 * 53) + this.zzm.zzd(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzn.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:606:0x0f33, code lost:
    
        if (r6 == 1048575) goto L608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0f35, code lost:
    
        r33.putInt(r0, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x0f3b, code lost:
    
        r3 = r7.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x0f3f, code lost:
    
        if (r3 >= r7.zzk) goto L723;
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x0f41, code lost:
    
        r5 = r7.zzi;
        r6 = r7.zzc;
        r5 = r5[r3];
        r6 = r6[r5];
        r6 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzyg.zzf(r0, r7.zzs(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0f53, code lost:
    
        if (r6 != null) goto L614;
     */
    /* JADX WARN: Code restructure failed: missing block: B:615:0x0f5a, code lost:
    
        if (r7.zzu(r5) != null) goto L724;
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x0f5c, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:617:0x0f5f, code lost:
    
        r6 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzwm) r6;
        r0 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzwl) r7.zzw(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0f67, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:619:0x0f68, code lost:
    
        if (r9 != 0) goto L624;
     */
    /* JADX WARN: Code restructure failed: missing block: B:620:0x0f6a, code lost:
    
        if (r1 != r10) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:623:0x0f71, code lost:
    
        throw com.google.android.gms.internal.mlkit_vision_face_bundled.zzvv.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:624:0x0f72, code lost:
    
        if (r1 > r10) goto L627;
     */
    /* JADX WARN: Code restructure failed: missing block: B:625:0x0f74, code lost:
    
        if (r4 != r9) goto L627;
     */
    /* JADX WARN: Code restructure failed: missing block: B:626:0x0f76, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:628:0x0f7b, code lost:
    
        throw com.google.android.gms.internal.mlkit_vision_face_bundled.zzvv.zze();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0d78  */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0d8d  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x0ef9  */
    /* JADX WARN: Removed duplicated region for block: B:666:0x0a85 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:672:0x005a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:712:0x0a9a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzc(java.lang.Object r37, byte[] r38, int r39, int r40, int r41, com.google.android.gms.internal.mlkit_vision_face_bundled.zzty r42) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 4148
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_face_bundled.zzty):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final Object zze() {
        return ((zzvn) this.zzg).zzy();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzL(r8)
            if (r0 != 0) goto L8
            goto L91
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r8
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn r0 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzG(r2)
            r0.zza = r1
            r0.zzE()
        L1b:
            int[] r0 = r7.zzc
        L1d:
            int r2 = r0.length
            if (r1 >= r2) goto L83
            int r2 = r7.zzs(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzr(r2)
            long r3 = (long) r3
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L80
        L3d:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            r6 = r5
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzwm r6 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzwm) r6
            r6.zzc()
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzwg r2 = r7.zzl
            r2.zza(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzM(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf r2 = r7.zzv(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzI(r8, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf r2 = r7.zzv(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw r0 = r7.zzm
            r0.zzg(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L91
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz r0 = r7.zzn
            r0.zze(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzyg.zzo(obj, j, zzyg.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzyg.zzp(obj, j, zzyg.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzyg.zzr(obj, j, zzyg.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzyg.zzr(obj, j, zzyg.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzyg.zzq(obj, j, zzyg.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzyg.zzr(obj, j, zzyg.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzyg.zzq(obj, j, zzyg.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzyg.zzm(obj, j, zzyg.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzyg.zzs(obj, j, zzyg.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzyg.zzs(obj, j, zzyg.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzyg.zzq(obj, j, zzyg.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzyg.zzq(obj, j, zzyg.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzyg.zzq(obj, j, zzyg.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzyg.zzr(obj, j, zzyg.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzyg.zzq(obj, j, zzyg.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzyg.zzr(obj, j, zzyg.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzxh.zza;
                    zzyg.zzs(obj, j, zzwn.zza(zzyg.zzf(obj, j), zzyg.zzf(obj2, j)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case Elf64.Ehdr.E_EHSIZE /* 52 */:
                case 53:
                case Elf64.Ehdr.E_PHENTSIZE /* 54 */:
                case 55:
                case 56:
                case 57:
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                case 59:
                    if (zzM(obj2, i3, i)) {
                        zzyg.zzs(obj, j, zzyg.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzyg.zzs(obj, j, zzyg.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzxh.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzxh.zzp(this.zzn, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzty zztyVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zztyVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0232  */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r24, com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1842
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzi(java.lang.Object, com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzK;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzyg.zza(obj, j)) != Double.doubleToLongBits(zzyg.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzyg.zzb(obj, j)) != Float.floatToIntBits(zzyg.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzyg.zzd(obj, j) != zzyg.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzyg.zzd(obj, j) != zzyg.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzyg.zzc(obj, j) != zzyg.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzyg.zzd(obj, j) != zzyg.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzyg.zzc(obj, j) != zzyg.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzyg.zzw(obj, j) != zzyg.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzxh.zzK(zzyg.zzf(obj, j), zzyg.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzxh.zzK(zzyg.zzf(obj, j), zzyg.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzxh.zzK(zzyg.zzf(obj, j), zzyg.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzyg.zzc(obj, j) != zzyg.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzyg.zzc(obj, j) != zzyg.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzyg.zzc(obj, j) != zzyg.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzyg.zzd(obj, j) != zzyg.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzyg.zzc(obj, j) != zzyg.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzyg.zzd(obj, j) != zzyg.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzxh.zzK(zzyg.zzf(obj, j), zzyg.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zZzK = zzxh.zzK(zzyg.zzf(obj, j), zzyg.zzf(obj2, j));
                    break;
                case 50:
                    zZzK = zzxh.zzK(zzyg.zzf(obj, j), zzyg.zzf(obj2, j));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case Elf64.Ehdr.E_EHSIZE /* 52 */:
                case 53:
                case Elf64.Ehdr.E_PHENTSIZE /* 54 */:
                case 55:
                case 56:
                case 57:
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                case 59:
                case 60:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                case 68:
                    long jZzp = zzp(i) & 1048575;
                    if (zzyg.zzc(obj, jZzp) != zzyg.zzc(obj2, jZzp) || !zzxh.zzK(zzyg.zzf(obj, j), zzyg.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzK) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzn.zzb(obj).equals(this.zzn.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzk(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzwv.zzk(java.lang.Object):boolean");
    }
}
