package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmo implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzme zzd;

    zzmo(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar, Bundle bundle) {
        this.zza = atomicReference;
        this.zzb = zzpVar;
        this.zzc = bundle;
        this.zzd = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfzVar = this.zzd.zzb;
                } finally {
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                this.zzd.zzj().zzg().zza("Failed to get trigger URIs; remote exception", e);
            }
            if (zzfzVar == null) {
                this.zzd.zzj().zzg().zza("Failed to get trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzfzVar.zza(this.zzb, this.zzc));
            this.zzd.zzar();
            this.zza.notify();
        }
    }
}
