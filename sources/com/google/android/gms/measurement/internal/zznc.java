package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zznc implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzbl zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzme zzf;

    zznc(zzme zzmeVar, boolean z, zzp zzpVar, boolean z2, zzbl zzblVar, String str) {
        this.zza = z;
        this.zzb = zzpVar;
        this.zzc = z2;
        this.zzd = zzblVar;
        this.zze = str;
        this.zzf = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long jElapsedRealtime;
        long j;
        long jCurrentTimeMillis;
        zzfz zzfzVar = this.zzf.zzb;
        if (zzfzVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfzVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            boolean zZza = this.zzf.zze().zza(zzbn.zzco);
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    Preconditions.checkNotNull(this.zzb);
                    if (zZza) {
                        jCurrentTimeMillis = this.zzf.zzu.zzb().currentTimeMillis();
                        try {
                            jElapsedRealtime = this.zzf.zzu.zzb().elapsedRealtime();
                        } catch (RemoteException e) {
                            e = e;
                            jElapsedRealtime = 0;
                            j = jCurrentTimeMillis;
                            this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
                            if (zZza && j != 0) {
                                zzgm.zza(this.zzf.zzu).zza(36301, 13, j, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - jElapsedRealtime));
                            }
                            this.zzf.zzar();
                        }
                    } else {
                        jCurrentTimeMillis = 0;
                        jElapsedRealtime = 0;
                    }
                    try {
                        zzfzVar.zza(this.zzd, this.zzb);
                        if (zZza) {
                            this.zzf.zzj().zzq().zza("Logging telemetry for logEvent");
                            zzgm.zza(this.zzf.zzu).zza(36301, 0, jCurrentTimeMillis, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - jElapsedRealtime));
                        }
                    } catch (RemoteException e2) {
                        e = e2;
                        j = jCurrentTimeMillis;
                        this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
                        if (zZza) {
                            zzgm.zza(this.zzf.zzu).zza(36301, 13, j, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - jElapsedRealtime));
                        }
                        this.zzf.zzar();
                    }
                } else {
                    zzfzVar.zza(this.zzd, this.zze, this.zzf.zzj().zzy());
                }
            } catch (RemoteException e3) {
                e = e3;
                jElapsedRealtime = 0;
                j = 0;
            }
        }
        this.zzf.zzar();
    }
}
