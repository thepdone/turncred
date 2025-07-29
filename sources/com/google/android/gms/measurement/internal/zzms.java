package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzms implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ zzme zzc;

    zzms(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar) {
        this.zza = atomicReference;
        this.zzb = zzpVar;
        this.zzc = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                } finally {
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
            }
            if (!this.zzc.zzk().zzp().zzh()) {
                this.zzc.zzj().zzw().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zzb((String) null);
                this.zzc.zzk().zze.zza(null);
                this.zza.set(null);
                return;
            }
            zzfz zzfzVar = this.zzc.zzb;
            if (zzfzVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzfzVar.zzb(this.zzb));
            String str = (String) this.zza.get();
            if (str != null) {
                this.zzc.zzm().zzb(str);
                this.zzc.zzk().zze.zza(str);
            }
            this.zzc.zzar();
            this.zza.notify();
        }
    }
}
