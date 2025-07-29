package com.google.firebase.analytics;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.zza.zzb.zze();
    }

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }
}
