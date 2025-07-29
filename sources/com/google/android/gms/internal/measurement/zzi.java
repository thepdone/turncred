package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzi {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzgr.zzd.zzb.values().length];
        zza = iArr;
        try {
            iArr[zzgr.zzd.zzb.STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzgr.zzd.zzb.NUMBER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzgr.zzd.zzb.BOOLEAN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zza[zzgr.zzd.zzb.STATEMENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zza[zzgr.zzd.zzb.UNKNOWN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
