package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzly implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzlw zzb;
    private final /* synthetic */ zzlw zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzlz zze;

    zzly(zzlz zzlzVar, Bundle bundle, zzlw zzlwVar, zzlw zzlwVar2, long j) {
        this.zza = bundle;
        this.zzb = zzlwVar;
        this.zzc = zzlwVar2;
        this.zzd = j;
        this.zze = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzlz.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
