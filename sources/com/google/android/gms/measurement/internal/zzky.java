package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzky implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb = null;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzju zze;

    zzky(zzju zzjuVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zze.zzu.zzt().zza(this.zza, (String) null, this.zzc, this.zzd);
    }
}
