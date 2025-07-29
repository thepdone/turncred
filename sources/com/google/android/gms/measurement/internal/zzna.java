package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzna implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzme zzb;

    zzna(zzme zzmeVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzfz zzfzVar = this.zzb.zzb;
        if (zzfzVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfzVar.zzh(this.zza);
            this.zzb.zzar();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
