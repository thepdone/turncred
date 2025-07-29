package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzpd implements zzpp {
    final /* synthetic */ zzou zza;

    zzpd(zzou zzouVar) {
        this.zza = zzouVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpp
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzl().zzb(new zzpc(this, str, str2, bundle));
        } else if (this.zza.zzm != null) {
            this.zza.zzm.zzj().zzg().zza("AppId not known when logging event", str2);
        }
    }
}
