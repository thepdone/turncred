package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzbs extends zzbj {
    zzbs(zzbt zzbtVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.internal.auth.zzbj
    protected final void zza(Context context, zzbh zzbhVar) throws RemoteException {
        zzbhVar.zzd(new zzbr(this));
    }
}
