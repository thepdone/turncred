package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzd {
    private final zzjm zza;

    static zzd zza(String str) {
        return new zzd((TextUtils.isEmpty(str) || str.length() > 1) ? zzjm.UNINITIALIZED : zzjj.zza(str.charAt(0)));
    }

    final zzjm zza() {
        return this.zza;
    }

    final String zzb() {
        return String.valueOf(zzjj.zza(this.zza));
    }

    zzd(zzjm zzjmVar) {
        this.zza = zzjmVar;
    }
}
