package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzeq extends zzed.zzb {
    private final /* synthetic */ zzed zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzeq(zzed zzedVar) {
        super(zzedVar);
        this.zzc = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(this.zzc.zzj)).resetAnalyticsData(this.zza);
    }
}
