package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zznl implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zznj zzb;

    zznl(zznj zznjVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzme.zza(this.zzb.zza, this.zza);
    }
}
