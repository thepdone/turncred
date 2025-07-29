package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmb implements Runnable {
    private final /* synthetic */ zzlw zza;
    private final /* synthetic */ zzlw zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzlz zze;

    zzmb(zzlz zzlzVar, zzlw zzlwVar, zzlw zzlwVar2, long j, boolean z) {
        this.zza = zzlwVar;
        this.zzb = zzlwVar2;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
