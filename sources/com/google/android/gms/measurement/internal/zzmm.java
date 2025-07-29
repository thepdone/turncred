package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmm implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzme zzd;

    zzmm(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar, boolean z) {
        this.zza = atomicReference;
        this.zzb = zzpVar;
        this.zzc = z;
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
                this.zzd.zzj().zzg().zza("Failed to get all user properties; remote exception", e);
            }
            if (zzfzVar == null) {
                this.zzd.zzj().zzg().zza("Failed to get all user properties; not connected to service");
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzfzVar.zza(this.zzb, this.zzc));
            this.zzd.zzar();
            this.zza.notify();
        }
    }
}
