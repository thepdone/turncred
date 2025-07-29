package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzdi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzb extends ThreadPoolExecutor {
    zzb(FirebaseAnalytics firebaseAnalytics, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30L, timeUnit, blockingQueue);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        super.execute(zzdi.zza().zza(runnable));
    }
}
