package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzek extends zzed.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzdm zze;
    private final /* synthetic */ zzed zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzek(zzed zzedVar, String str, String str2, zzdm zzdmVar) {
        super(zzedVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzdmVar;
        this.zzf = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    protected final void zzb() {
        this.zze.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(this.zzf.zzj)).getConditionalUserProperties(this.zzc, this.zzd, this.zze);
    }
}
