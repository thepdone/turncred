package com.google.android.gms.internal.p000authapi;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* loaded from: classes3.dex */
final class zbao extends zbn {
    final /* synthetic */ TaskCompletionSource zba;

    zbao(zbap zbapVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbo
    public final void zbb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.zba);
    }
}
