package com.google.android.gms.internal.p000authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* loaded from: classes3.dex */
final class zby extends zbh {
    final /* synthetic */ TaskCompletionSource zba;

    zby(zbz zbzVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbi
    public final void zbb(Status status, AuthorizationResult authorizationResult) throws RemoteException {
        if (status.isSuccess()) {
            this.zba.setResult(authorizationResult);
        } else {
            this.zba.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
