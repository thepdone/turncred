package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
abstract class zzbb {
    private static volatile Handler zza;
    private final zzjh zzb;
    private final Runnable zzc;
    private volatile long zzd;

    private final Handler zzd() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzbb.class) {
            if (zza == null) {
                zza = new com.google.android.gms.internal.measurement.zzdj(this.zzb.zza().getMainLooper());
            }
            handler = zza;
        }
        return handler;
    }

    public abstract void zzb();

    zzbb(zzjh zzjhVar) {
        Preconditions.checkNotNull(zzjhVar);
        this.zzb = zzjhVar;
        this.zzc = new zzba(this, zzjhVar);
    }

    final void zza() {
        this.zzd = 0L;
        zzd().removeCallbacks(this.zzc);
    }

    public final void zza(long j) {
        zza();
        if (j >= 0) {
            this.zzd = this.zzb.zzb().currentTimeMillis();
            if (zzd().postDelayed(this.zzc, j)) {
                return;
            }
            this.zzb.zzj().zzg().zza("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean zzc() {
        return this.zzd != 0;
    }
}
