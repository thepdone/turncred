package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes3.dex */
enum zzh implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        MLTaskExecutor.getInstance().zzc.post(runnable);
    }
}
