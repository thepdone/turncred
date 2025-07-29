package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmy implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzme zzc;

    zzmy(zzme zzmeVar, zzp zzpVar, Bundle bundle) {
        this.zza = zzpVar;
        this.zzb = bundle;
        this.zzc = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzfz zzfzVar = this.zzc.zzb;
        if (zzfzVar == null) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfzVar.zza(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service", e);
        }
    }
}
