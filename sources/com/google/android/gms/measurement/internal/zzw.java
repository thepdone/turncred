package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfw;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzw {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzfw.zzd.zza.values().length];
        zzb = iArr;
        try {
            iArr[zzfw.zzd.zza.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzb[zzfw.zzd.zza.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzb[zzfw.zzd.zza.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzb[zzfw.zzd.zza.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[zzfw.zzf.zza.values().length];
        zza = iArr2;
        try {
            iArr2[zzfw.zzf.zza.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zza[zzfw.zzf.zza.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            zza[zzfw.zzf.zza.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zza[zzfw.zzf.zza.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zza[zzfw.zzf.zza.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            zza[zzfw.zzf.zza.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
