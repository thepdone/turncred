package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzfd extends zzed.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzdm zzd;
    private final /* synthetic */ zzed zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfd(zzed zzedVar, Bundle bundle, zzdm zzdmVar) {
        super(zzedVar);
        this.zzc = bundle;
        this.zzd = zzdmVar;
        this.zze = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    protected final void zzb() {
        this.zzd.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(this.zze.zzj)).performAction(this.zzc, this.zzd, this.zza);
    }
}
