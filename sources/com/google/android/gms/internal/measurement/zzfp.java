package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzfp extends zzed.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzed.zzc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfp(zzed.zzc zzcVar, Activity activity) {
        super(zzed.this);
        this.zzc = activity;
        this.zzd = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        ((zzdl) Preconditions.checkNotNull(zzed.this.zzj)).onActivityStartedByScionActivityInfo(zzeb.zza(this.zzc), this.zzb);
    }
}
