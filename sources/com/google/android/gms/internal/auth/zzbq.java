package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzbq extends zzbi {
    final /* synthetic */ ProxyRequest zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbq(zzbt zzbtVar, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        super(googleApiClient);
        this.zza = proxyRequest;
    }

    @Override // com.google.android.gms.internal.auth.zzbi
    protected final void zza(Context context, zzbh zzbhVar) throws RemoteException {
        zzbhVar.zze(new zzbp(this), this.zza);
    }
}
