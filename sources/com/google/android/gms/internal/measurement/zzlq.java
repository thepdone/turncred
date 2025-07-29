package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.soloader.Elf64;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlq<T> implements zzme<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmz.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlu zzn;
    private final zzkw zzo;
    private final zzmu<?, ?> zzp;
    private final zzjv<?> zzq;
    private final zzlj zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzmz.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzmz.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzng zzngVar, Class<?> cls, zzit zzitVar) throws IOException {
        switch (zzlt.zza[zzngVar.ordinal()]) {
            case 1:
                int iZzd = zziu.zzd(bArr, i, zzitVar);
                zzitVar.zzc = Boolean.valueOf(zzitVar.zzb != 0);
                return iZzd;
            case 2:
                return zziu.zza(bArr, i, zzitVar);
            case 3:
                zzitVar.zzc = Double.valueOf(zziu.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzitVar.zzc = Integer.valueOf(zziu.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzitVar.zzc = Long.valueOf(zziu.zzd(bArr, i));
                return i + 8;
            case 8:
                zzitVar.zzc = Float.valueOf(zziu.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zziu.zzc(bArr, i, zzitVar);
                zzitVar.zzc = Integer.valueOf(zzitVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zziu.zzd(bArr, i, zzitVar);
                zzitVar.zzc = Long.valueOf(zzitVar.zzb);
                return iZzd2;
            case 14:
                return zziu.zza(zzma.zza().zza((Class) cls), bArr, i, i2, zzitVar);
            case 15:
                int iZzc2 = zziu.zzc(bArr, i, zzitVar);
                zzitVar.zzc = Integer.valueOf(zzjk.zze(zzitVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zziu.zzd(bArr, i, zzitVar);
                zzitVar.zzc = Long.valueOf(zzjk.zza(zzitVar.zzb));
                return iZzd3;
            case 17:
                return zziu.zzb(bArr, i, zzitVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v19 */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zza(T t) {
        int i;
        int i2;
        int i3;
        boolean z;
        int iZza;
        int iZza2;
        int iZzd;
        int iZzd2;
        int iZzf;
        int iZzg;
        Unsafe unsafe = zzb;
        ?? r9 = 0;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int iZzd3 = 0;
        int i7 = 1048575;
        while (i6 < this.zzc.length) {
            int iZzc = zzc(i6);
            int i8 = (267386880 & iZzc) >>> 20;
            int[] iArr = this.zzc;
            int i9 = iArr[i6];
            int i10 = iArr[i6 + 2];
            int i11 = i10 & i4;
            if (i8 <= 17) {
                if (i11 != i7) {
                    i5 = i11 == i4 ? r9 : unsafe.getInt(t, i11);
                    i7 = i11;
                }
                i = i7;
                i2 = i5;
                i3 = 1 << (i10 >>> 20);
            } else {
                i = i7;
                i2 = i5;
                i3 = r9;
            }
            long j = iZzc & i4;
            if (i8 >= zzkb.DOUBLE_LIST_PACKED.zza()) {
                zzkb.SINT64_LIST_PACKED.zza();
            }
            int i12 = i3;
            switch (i8) {
                case 0:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza = zzjn.zza(i9, AudioStats.AUDIO_AMPLITUDE_NONE);
                        iZzd3 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza = zzjn.zza(i9, 0.0f);
                        iZzd3 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza = zzjn.zzb(i9, unsafe.getLong(t, j));
                        iZzd3 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza = zzjn.zze(i9, unsafe.getLong(t, j));
                        iZzd3 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza = zzjn.zzc(i9, unsafe.getInt(t, j));
                        iZzd3 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza = zzjn.zza(i9, 0L);
                        iZzd3 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        z = false;
                        iZza = zzjn.zzb(i9, 0);
                        iZzd3 += iZza;
                        break;
                    }
                    z = false;
                    break;
                case 7:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zza(i9, true);
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 8:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zziy) {
                            iZza2 = zzjn.zza(i9, (zziy) object);
                        } else {
                            iZza2 = zzjn.zza(i9, (String) object);
                        }
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 9:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzmg.zza(i9, unsafe.getObject(t, j), (zzme<?>) zze(i6));
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 10:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zza(i9, (zziy) unsafe.getObject(t, j));
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 11:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zzf(i9, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 12:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zza(i9, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 13:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZzd3 += zzjn.zzd(i9, 0);
                    }
                    z = false;
                    break;
                case 14:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zzc(i9, 0L);
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 15:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zze(i9, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 16:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zzd(i9, unsafe.getLong(t, j));
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 17:
                    if (zza((zzlq<T>) t, i6, i, i2, i12)) {
                        iZza2 = zzjn.zza(i9, (zzlm) unsafe.getObject(t, j), zze(i6));
                        iZzd3 += iZza2;
                    }
                    z = false;
                    break;
                case 18:
                    iZzd = zzmg.zzd(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 19:
                    iZzd = zzmg.zzc(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 20:
                    iZzd = zzmg.zzf(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 21:
                    iZzd = zzmg.zzj(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 22:
                    iZzd = zzmg.zze(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 23:
                    iZzd = zzmg.zzd(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 24:
                    iZzd = zzmg.zzc(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 25:
                    iZzd = zzmg.zza(i9, (List<?>) unsafe.getObject(t, j), (boolean) r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 26:
                    iZzd = zzmg.zzb(i9, (List) unsafe.getObject(t, j));
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 27:
                    iZzd = zzmg.zzb(i9, (List<?>) unsafe.getObject(t, j), (zzme<?>) zze(i6));
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 28:
                    iZzd = zzmg.zza(i9, (List<zziy>) unsafe.getObject(t, j));
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 29:
                    iZzd = zzmg.zzi(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 30:
                    iZzd = zzmg.zzb(i9, (List<Integer>) unsafe.getObject(t, j), (boolean) r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 31:
                    iZzd = zzmg.zzc(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 32:
                    iZzd = zzmg.zzd(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 33:
                    iZzd = zzmg.zzg(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 34:
                    iZzd = zzmg.zzh(i9, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 35:
                    iZzd2 = zzmg.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 36:
                    iZzd2 = zzmg.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 37:
                    iZzd2 = zzmg.zzf((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 38:
                    iZzd2 = zzmg.zzj((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 39:
                    iZzd2 = zzmg.zze((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 40:
                    iZzd2 = zzmg.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 41:
                    iZzd2 = zzmg.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 42:
                    iZzd2 = zzmg.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 43:
                    iZzd2 = zzmg.zzi((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 44:
                    iZzd2 = zzmg.zzb((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 45:
                    iZzd2 = zzmg.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 46:
                    iZzd2 = zzmg.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 47:
                    iZzd2 = zzmg.zzg((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case 48:
                    iZzd2 = zzmg.zzh((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzjn.zzf(i9);
                        iZzg = zzjn.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iZzd = zzmg.zza(i9, (List<zzlm>) unsafe.getObject(t, j), (zzme<?>) zze(i6));
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case 50:
                    iZzd = this.zzr.zza(i9, unsafe.getObject(t, j), zzf(i6));
                    iZzd3 += iZzd;
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zza(i9, AudioStats.AUDIO_AMPLITUDE_NONE);
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case Elf64.Ehdr.E_EHSIZE /* 52 */:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zza(i9, 0.0f);
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 53:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zzb(i9, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case Elf64.Ehdr.E_PHENTSIZE /* 54 */:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zze(i9, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 55:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zzc(i9, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 56:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zza(i9, 0L);
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 57:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zzb(i9, (int) r9);
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zza(i9, true);
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 59:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zziy) {
                            iZzd = zzjn.zza(i9, (zziy) object2);
                        } else {
                            iZzd = zzjn.zza(i9, (String) object2);
                        }
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 60:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzmg.zza(i9, unsafe.getObject(t, j), (zzme<?>) zze(i6));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zza(i9, (zziy) unsafe.getObject(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zzf(i9, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 63:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zza(i9, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 64:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zzd(i9, (int) r9);
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zzc(i9, 0L);
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 66:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zze(i9, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 67:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zzd(i9, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                case 68:
                    if (zzc((zzlq<T>) t, i9, i6)) {
                        iZzd = zzjn.zza(i9, (zzlm) unsafe.getObject(t, j), zze(i6));
                        iZzd3 += iZzd;
                    }
                    z = r9;
                    break;
                default:
                    z = r9;
                    break;
            }
            i6 += 3;
            i7 = i;
            r9 = z;
            i5 = i2;
            i4 = 1048575;
        }
        int iZza3 = r9;
        zzmu<?, ?> zzmuVar = this.zzp;
        int iZza4 = iZzd3 + zzmuVar.zza((zzmu<?, ?>) zzmuVar.zzd(t));
        if (!this.zzh) {
            return iZza4;
        }
        zzjw<T> zzjwVarZza = this.zzq.zza(t);
        int iZzb = zzjwVarZza.zza.zzb();
        for (int i13 = iZza3; i13 < iZzb; i13++) {
            Map.Entry entryZza = zzjwVarZza.zza.zza(i13);
            iZza3 += zzjw.zza((zzjy<?>) entryZza.getKey(), entryZza.getValue());
        }
        for (Map.Entry entry : zzjwVarZza.zza.zzc()) {
            iZza3 += zzjw.zza((zzjy<?>) entry.getKey(), entry.getValue());
        }
        return iZza4 + iZza3;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            int iHashCode = 37;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzkj.zza(Double.doubleToLongBits(zzmz.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzmz.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzmz.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzmz.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzkj.zza(zzmz.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzmz.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzmz.zze(t, j);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzmz.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzmz.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzmz.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzmz.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzmz.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzmz.zze(t, j);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
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
                    i = i2 * 53;
                    iZza = zzmz.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzmz.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzkj.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_EHSIZE /* 52 */:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzkj.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_PHENTSIZE /* 54 */:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzkj.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzkj.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_SHENTSIZE /* 58 */:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzkj.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzmz.zze(t, j)).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmz.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmz.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzkj.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzkj.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmz.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzq.zza(t).hashCode() : iHashCode2;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzmz.zze(t, j)).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:435:0x0a76, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkp.zzi();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:588:0x094b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:594:0x0d22 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0cb7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:638:0x093c A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v59, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.measurement.zzit r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzit):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
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

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzmz.zze(t, j)).longValue();
    }

    private final zzkl zzd(int i) {
        return (zzkl) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0387  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.android.gms.internal.measurement.zzlq<T> zza(java.lang.Class<T> r32, com.google.android.gms.internal.measurement.zzlk r33, com.google.android.gms.internal.measurement.zzlu r34, com.google.android.gms.internal.measurement.zzkw r35, com.google.android.gms.internal.measurement.zzmu<?, ?> r36, com.google.android.gms.internal.measurement.zzjv<?> r37, com.google.android.gms.internal.measurement.zzlj r38) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzlk, com.google.android.gms.internal.measurement.zzlu, com.google.android.gms.internal.measurement.zzkw, com.google.android.gms.internal.measurement.zzmu, com.google.android.gms.internal.measurement.zzjv, com.google.android.gms.internal.measurement.zzlj):com.google.android.gms.internal.measurement.zzlq");
    }

    private final zzme zze(int i) {
        int i2 = (i / 3) << 1;
        zzme zzmeVar = (zzme) this.zzd[i2];
        if (zzmeVar != null) {
            return zzmeVar;
        }
        zzme<T> zzmeVarZza = zzma.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzmeVarZza;
        return zzmeVarZza;
    }

    static zzmx zzc(Object obj) {
        zzkg zzkgVar = (zzkg) obj;
        zzmx zzmxVar = zzkgVar.zzb;
        if (zzmxVar != zzmx.zzc()) {
            return zzmxVar;
        }
        zzmx zzmxVarZzd = zzmx.zzd();
        zzkgVar.zzb = zzmxVarZzd;
        return zzmxVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmu<UT, UB> zzmuVar, Object obj2) {
        zzkl zzklVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzmz.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzklVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzklVarZzd, (zzkl) ub, (zzmu<UT, zzkl>) zzmuVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzkl zzklVar, UB ub, zzmu<UT, UB> zzmuVar, Object obj) {
        zzlh<?, ?> zzlhVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzklVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmuVar.zzc(obj);
                }
                zzjd zzjdVarZzc = zziy.zzc(zzle.zza(zzlhVarZza, next.getKey(), next.getValue()));
                try {
                    zzle.zza(zzjdVarZzc.zzb(), zzlhVarZza, next.getKey(), next.getValue());
                    zzmuVar.zza((zzmu<UT, UB>) ub, i2, zzjdVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzme zzmeVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc((zzlq<T>) t, i)) {
            return zzmeVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzmeVarZze.zza();
        if (object != null) {
            zzmeVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzme zzmeVarZze = zze(i2);
        if (!zzc((zzlq<T>) t, i, i2)) {
            return zzmeVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzmeVarZze.zza();
        if (object != null) {
            zzmeVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
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

    private zzlq(int[] iArr, Object[] objArr, int i, int i2, zzlm zzlmVar, boolean z, int[] iArr2, int i3, int i4, zzlu zzluVar, zzkw zzkwVar, zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlj zzljVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzlmVar instanceof zzkg;
        this.zzh = zzjvVar != null && zzjvVar.zza(zzlmVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzluVar;
        this.zzo = zzkwVar;
        this.zzp = zzmuVar;
        this.zzq = zzjvVar;
        this.zzg = zzlmVar;
        this.zzr = zzljVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(T r8) {
        /*
            r7 = this;
            boolean r0 = zzg(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.zzkg
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.measurement.zzkg r0 = (com.google.android.gms.internal.measurement.zzkg) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzc(r2)
            r0.zza = r1
            r0.zzcp()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L83
            int r2 = r7.zzc(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            long r3 = (long) r3
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r5
            int r2 = r2 >>> 20
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
            sun.misc.Unsafe r2 = com.google.android.gms.internal.measurement.zzlq.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            com.google.android.gms.internal.measurement.zzlj r6 = r7.zzr
            java.lang.Object r5 = r6.zzc(r5)
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.android.gms.internal.measurement.zzkw r2 = r7.zzo
            r2.zzb(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzc(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzme r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzlq.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzd(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzc(r8, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzme r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzlq.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzd(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.android.gms.internal.measurement.zzmu<?, ?> r0 = r7.zzp
            r0.zzf(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L91
            com.google.android.gms.internal.measurement.zzjv<?> r0 = r7.zzq
            r0.zzc(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zzd(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza(t, j, zzmz.zza(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzb(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zzc(t, j, zzmz.zzh(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
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
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzmg.zza(this.zzr, t, t2, j);
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
                    if (zzc((zzlq<T>) t2, i2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64.Ehdr.E_SHSTRNDX /* 62 */:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzc((zzlq<T>) t2, i2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzmg.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzmg.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0625 A[Catch: all -> 0x0297, TryCatch #3 {all -> 0x0297, blocks: (B:153:0x05f6, B:163:0x0620, B:165:0x0625, B:166:0x062a, B:50:0x00cc, B:51:0x00de, B:52:0x00f0, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:57:0x012e, B:60:0x0135, B:61:0x013b, B:62:0x0148, B:63:0x0159, B:64:0x0166, B:65:0x0177, B:67:0x0182, B:68:0x0193, B:69:0x01a4, B:70:0x01b5, B:71:0x01c6, B:72:0x01d7, B:73:0x01e8, B:74:0x01f9, B:75:0x020b, B:77:0x021b, B:81:0x023c, B:78:0x0225, B:80:0x022d, B:82:0x024d, B:83:0x025f, B:84:0x026d, B:85:0x027b, B:86:0x0289), top: B:195:0x05f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x065b A[LOOP:3: B:181:0x0657->B:183:0x065b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0630 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzmf] */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzmf r19, com.google.android.gms.internal.measurement.zzjt r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzmf, com.google.android.gms.internal.measurement.zzjt):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t, byte[] bArr, int i, int i2, zzit zzitVar) throws IOException {
        zza((zzlq<T>) t, bArr, i, i2, 0, zzitVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((zzlq<T>) t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzme zzmeVarZze = zze(i);
            if (!zzc((zzlq<T>) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzmeVarZze.zza();
                    zzmeVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzlq<T>) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzmeVarZze.zza();
                zzmeVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzmeVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc((zzlq<T>) t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzme zzmeVarZze = zze(i);
            if (!zzc((zzlq<T>) t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzmeVarZze.zza();
                    zzmeVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzlq<T>) t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzmeVarZze.zza();
                zzmeVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzmeVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzmf zzmfVar) throws IOException {
        if (zzg(i)) {
            zzmz.zza(obj, i & 1048575, zzmfVar.zzr());
        } else if (this.zzi) {
            zzmz.zza(obj, i & 1048575, zzmfVar.zzq());
        } else {
            zzmz.zza(obj, i & 1048575, zzmfVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzmz.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzmz.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzmz.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((zzlq<T>) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb((zzlq<T>) t, i, i2);
    }

    private final <K, V> void zza(zznl zznlVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznlVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zznl zznlVar) throws IOException {
        if (obj instanceof String) {
            zznlVar.zza(i, (String) obj);
        } else {
            zznlVar.zza(i, (zziy) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:176:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r24, com.google.android.gms.internal.measurement.zznl r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Object, com.google.android.gms.internal.measurement.zznl):void");
    }

    private static <UT, UB> void zza(zzmu<UT, UB> zzmuVar, T t, zznl zznlVar) throws IOException {
        zzmuVar.zzb((zzmu<UT, UB>) zzmuVar.zzd(t), zznlVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((zzlq<T>) t, i) == zzc((zzlq<T>) t2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return (zzmz.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmz.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmz.zzb(t, j2)) != 0;
            case 2:
                return zzmz.zzd(t, j2) != 0;
            case 3:
                return zzmz.zzd(t, j2) != 0;
            case 4:
                return zzmz.zzc(t, j2) != 0;
            case 5:
                return zzmz.zzd(t, j2) != 0;
            case 6:
                return zzmz.zzc(t, j2) != 0;
            case 7:
                return zzmz.zzh(t, j2);
            case 8:
                Object objZze = zzmz.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zziy) {
                    return !zziy.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmz.zze(t, j2) != null;
            case 10:
                return !zziy.zza.equals(zzmz.zze(t, j2));
            case 11:
                return zzmz.zzc(t, j2) != 0;
            case 12:
                return zzmz.zzc(t, j2) != 0;
            case 13:
                return zzmz.zzc(t, j2) != 0;
            case 14:
                return zzmz.zzd(t, j2) != 0;
            case 15:
                return zzmz.zzc(t, j2) != 0;
            case 16:
                return zzmz.zzd(t, j2) != 0;
            case 17:
                return zzmz.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((zzlq<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzme] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzme] */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zze(T r18) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zze(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzme zzmeVar) {
        return zzmeVar.zze(zzmz.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkg) {
            return ((zzkg) obj).zzcq();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzmz.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzmz.zze(t, j)).booleanValue();
    }
}
