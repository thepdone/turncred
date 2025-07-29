package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zznf implements Runnable {
    private final /* synthetic */ boolean zza = true;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzag zzd;
    private final /* synthetic */ zzag zze;
    private final /* synthetic */ zzme zzf;

    zznf(zzme zzmeVar, boolean z, zzp zzpVar, boolean z2, zzag zzagVar, zzag zzagVar2) {
        this.zzb = zzpVar;
        this.zzc = z2;
        this.zzd = zzagVar;
        this.zze = zzagVar2;
        this.zzf = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfz zzfzVar = this.zzf.zzb;
        if (zzfzVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfzVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    Preconditions.checkNotNull(this.zzb);
                    zzfzVar.zza(this.zzd, this.zzb);
                } else {
                    zzfzVar.zza(this.zzd);
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzar();
    }
}
