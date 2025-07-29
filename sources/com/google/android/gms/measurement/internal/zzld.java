package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzld implements zzpp {
    private final /* synthetic */ zzju zza;

    zzld(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpp
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzb("auto", str2, bundle);
        } else {
            this.zza.zza("auto", str2, bundle, str);
        }
    }
}
