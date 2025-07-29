package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import com.google.android.gms.internal.measurement.zzgr;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzf {
    final zzh zza;
    final zzh zzb;
    private final zzbb zzc;
    private final zzl zzd;

    public final zzaq zza(zzh zzhVar, zzgr.zzd... zzdVarArr) {
        zzaq zzaqVarZza = zzaq.zzc;
        for (zzgr.zzd zzdVar : zzdVarArr) {
            zzaqVarZza = zzj.zza(zzdVar);
            zzg.zza(this.zzb);
            if ((zzaqVarZza instanceof zzat) || (zzaqVarZza instanceof zzar)) {
                zzaqVarZza = this.zzc.zza(zzhVar, zzaqVarZza);
            }
        }
        return zzaqVarZza;
    }

    public zzf() {
        zzbb zzbbVar = new zzbb();
        this.zzc = zzbbVar;
        zzh zzhVar = new zzh(null, zzbbVar);
        this.zzb = zzhVar;
        this.zza = zzhVar.zza();
        zzl zzlVar = new zzl();
        this.zzd = zzlVar;
        zzhVar.zzc("require", new zzz(zzlVar));
        zzlVar.zza("internal.platform", new Callable() { // from class: com.google.android.gms.internal.measurement.zze
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzy();
            }
        });
        zzhVar.zzc("runtime.counter", new zzai(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)));
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zzd.zza(str, callable);
    }
}
