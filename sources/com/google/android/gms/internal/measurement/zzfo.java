package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzfo extends zzed.zzb {
    private final /* synthetic */ zzed.zzd zzc;
    private final /* synthetic */ zzed zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfo(zzed zzedVar, zzed.zzd zzdVar) {
        super(zzedVar);
        this.zzc = zzdVar;
        this.zzd = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(this.zzd.zzj)).unregisterOnMeasurementEventListener(this.zzc);
    }
}
