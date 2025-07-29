package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzgc;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzht {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;
    static final /* synthetic */ int[] zzc;

    static {
        int[] iArr = new int[zzgc.zza.zzd.values().length];
        zzc = iArr;
        try {
            iArr[zzgc.zza.zzd.DENIED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzc[zzgc.zza.zzd.GRANTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[zzgc.zza.zze.values().length];
        zzb = iArr2;
        try {
            iArr2[zzgc.zza.zze.AD_STORAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzb[zzgc.zza.zze.ANALYTICS_STORAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzb[zzgc.zza.zze.AD_USER_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzb[zzgc.zza.zze.AD_PERSONALIZATION.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr3 = new int[com.google.android.gms.internal.measurement.zzs.values().length];
        zza = iArr3;
        try {
            iArr3[com.google.android.gms.internal.measurement.zzs.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zza[com.google.android.gms.internal.measurement.zzs.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zza[com.google.android.gms.internal.measurement.zzs.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            zza[com.google.android.gms.internal.measurement.zzs.VERBOSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
