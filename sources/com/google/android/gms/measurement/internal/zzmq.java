package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmq implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzpm zzc;
    private final /* synthetic */ zzme zzd;

    zzmq(zzme zzmeVar, zzp zzpVar, boolean z, zzpm zzpmVar) {
        this.zza = zzpVar;
        this.zzb = z;
        this.zzc = zzpmVar;
        this.zzd = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfz zzfzVar = this.zzd.zzb;
        if (zzfzVar == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zza(zzfzVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzar();
    }
}
