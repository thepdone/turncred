package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zznb implements Runnable {
    private final /* synthetic */ zzbl zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzc;
    private final /* synthetic */ zzme zzd;

    zznb(zzme zzmeVar, zzbl zzblVar, String str, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = zzblVar;
        this.zzb = str;
        this.zzc = zzdqVar;
        this.zzd = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        try {
            zzfz zzfzVar = this.zzd.zzb;
            if (zzfzVar == null) {
                this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] bArrZza = zzfzVar.zza(this.zza, this.zzb);
            this.zzd.zzar();
            this.zzd.zzs().zza(this.zzc, bArrZza);
        } catch (RemoteException e) {
            this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzs().zza(this.zzc, (byte[]) null);
        }
    }
}
