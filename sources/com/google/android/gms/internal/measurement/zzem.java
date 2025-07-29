package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzem extends zzed.zzb {
    private final /* synthetic */ zzeb zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzed zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzem(zzed zzedVar, zzeb zzebVar, String str, String str2) {
        super(zzedVar);
        this.zzc = zzebVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(this.zzf.zzj)).setCurrentScreenByScionActivityInfo(this.zzc, this.zzd, this.zze, this.zza);
    }
}
