package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmn implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zze;
    private final /* synthetic */ zzme zzf;

    zzmn(zzme zzmeVar, String str, String str2, zzp zzpVar, boolean z, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpVar;
        this.zzd = z;
        this.zze = zzdqVar;
        this.zzf = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        Bundle bundle = new Bundle();
        try {
            zzfz zzfzVar = this.zzf.zzb;
            if (zzfzVar == null) {
                this.zzf.zzj().zzg().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            Bundle bundleZza = zzpn.zza(zzfzVar.zza(this.zza, this.zzb, this.zzd, this.zzc));
            this.zzf.zzar();
            this.zzf.zzs().zza(this.zze, bundleZza);
        } catch (RemoteException e) {
            this.zzf.zzj().zzg().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzs().zza(this.zze, bundle);
        }
    }
}
