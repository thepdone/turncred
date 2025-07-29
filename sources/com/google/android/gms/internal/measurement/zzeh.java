package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzeh extends zzed.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ zzed zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzeh(zzed zzedVar, String str, String str2, Bundle bundle) {
        super(zzedVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = bundle;
        this.zzf = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(this.zzf.zzj)).clearConditionalUserProperty(this.zzc, this.zzd, this.zze);
    }
}
