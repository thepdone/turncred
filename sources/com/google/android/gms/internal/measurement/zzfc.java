package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzfc extends zzed.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzdm zzf;
    private final /* synthetic */ zzed zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfc(zzed zzedVar, String str, String str2, boolean z, zzdm zzdmVar) {
        super(zzedVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
        this.zzf = zzdmVar;
        this.zzg = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    protected final void zzb() {
        this.zzf.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(this.zzg.zzj)).getUserProperties(this.zzc, this.zzd, this.zze, this.zzf);
    }
}
