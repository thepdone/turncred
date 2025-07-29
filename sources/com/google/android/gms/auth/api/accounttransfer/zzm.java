package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzm extends zzan {
    final /* synthetic */ zzn zza;

    zzm(zzn zznVar) {
        this.zza = zznVar;
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zzd(Status status) {
        this.zza.zzb.setException(new AccountTransferException(status));
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zze() {
        this.zza.zzb.setResult(null);
    }
}
