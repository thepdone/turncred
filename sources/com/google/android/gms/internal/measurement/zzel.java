package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzel extends zzed.zzb {
    private final /* synthetic */ Boolean zzc;
    private final /* synthetic */ zzed zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzel(zzed zzedVar, Boolean bool) {
        super(zzedVar);
        this.zzc = bool;
        this.zzd = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        if (this.zzc != null) {
            ((zzdl) Preconditions.checkNotNull(this.zzd.zzj)).setMeasurementEnabled(this.zzc.booleanValue(), this.zza);
        } else {
            ((zzdl) Preconditions.checkNotNull(this.zzd.zzj)).clearMeasurementEnabled(this.zza);
        }
    }
}
