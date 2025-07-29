package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmv implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzb;
    private final /* synthetic */ zzme zzc;

    zzmv(zzme zzmeVar, zzp zzpVar, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = zzpVar;
        this.zzb = zzdqVar;
        this.zzc = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        try {
            if (!this.zzc.zzk().zzp().zzh()) {
                this.zzc.zzj().zzw().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zzb((String) null);
                this.zzc.zzk().zze.zza(null);
                return;
            }
            zzfz zzfzVar = this.zzc.zzb;
            if (zzfzVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(this.zza);
            String strZzb = zzfzVar.zzb(this.zza);
            if (strZzb != null) {
                this.zzc.zzm().zzb(strZzb);
                this.zzc.zzk().zze.zza(strZzb);
            }
            this.zzc.zzar();
            this.zzc.zzs().zza(this.zzb, strZzb);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzs().zza(this.zzb, (String) null);
        }
    }
}
