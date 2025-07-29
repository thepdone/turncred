package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzdk implements zzdf {
    @Override // com.google.android.gms.internal.measurement.zzdf
    public final Runnable zza(Runnable runnable) {
        return runnable;
    }

    @Override // com.google.android.gms.internal.measurement.zzdf
    public final <V> Callable<V> zza(Callable<V> callable) {
        return callable;
    }

    zzdk() {
    }
}
