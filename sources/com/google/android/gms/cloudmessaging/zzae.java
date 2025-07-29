package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
/* loaded from: classes3.dex */
final class zzae extends com.google.android.gms.internal.cloudmessaging.zzf {
    final /* synthetic */ Rpc zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzae(Rpc rpc, Looper looper) {
        super(looper);
        this.zza = rpc;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Rpc.zzc(this.zza, message);
    }
}
