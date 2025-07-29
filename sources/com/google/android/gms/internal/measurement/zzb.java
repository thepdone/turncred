package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import com.google.android.gms.internal.measurement.zzgr;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzb {
    private final zzf zza;
    private zzh zzb;
    private zzac zzc;
    private final zzaa zzd;

    public final zzac zza() {
        return this.zzc;
    }

    public static /* synthetic */ zzal zza(zzb zzbVar) {
        return new zzk(zzbVar.zzc);
    }

    public static /* synthetic */ zzal zzb(zzb zzbVar) {
        return new zzw(zzbVar.zzd);
    }

    public zzb() {
        this(new zzf());
    }

    private zzb(zzf zzfVar) {
        this.zza = zzfVar;
        this.zzb = zzfVar.zza.zza();
        this.zzc = new zzac();
        this.zzd = new zzaa();
        zzfVar.zza("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzb.zzb(this.zza);
            }
        });
        zzfVar.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zzd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzb.zza(this.zza);
            }
        });
    }

    public final void zza(zzgr.zzc zzcVar) throws zzc {
        zzal zzalVar;
        try {
            this.zzb = this.zza.zza.zza();
            if (this.zza.zza(this.zzb, (zzgr.zzd[]) zzcVar.zzc().toArray(new zzgr.zzd[0])) instanceof zzaj) {
                throw new IllegalStateException("Program loading failed");
            }
            for (zzgr.zzb zzbVar : zzcVar.zza().zzd()) {
                List<zzgr.zzd> listZzc = zzbVar.zzc();
                String strZzb = zzbVar.zzb();
                Iterator<zzgr.zzd> it = listZzc.iterator();
                while (it.hasNext()) {
                    zzaq zzaqVarZza = this.zza.zza(this.zzb, it.next());
                    if (!(zzaqVarZza instanceof zzap)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    zzh zzhVar = this.zzb;
                    if (zzhVar.zzb(strZzb)) {
                        zzaq zzaqVarZza2 = zzhVar.zza(strZzb);
                        if (!(zzaqVarZza2 instanceof zzal)) {
                            throw new IllegalStateException("Invalid function name: " + strZzb);
                        }
                        zzalVar = (zzal) zzaqVarZza2;
                    } else {
                        zzalVar = null;
                    }
                    if (zzalVar == null) {
                        throw new IllegalStateException("Rule function is undefined: " + strZzb);
                    }
                    zzalVar.zza(this.zzb, Collections.singletonList(zzaqVarZza));
                }
            }
        } catch (Throwable th) {
            throw new zzc(th);
        }
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zza.zza(str, callable);
    }

    public final boolean zza(zzad zzadVar) throws zzc {
        try {
            this.zzc.zza(zzadVar);
            this.zza.zzb.zzc("runtime.counter", new zzai(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)));
            this.zzd.zza(this.zzb.zza(), this.zzc);
            if (zzc()) {
                return true;
            }
            return zzb();
        } catch (Throwable th) {
            throw new zzc(th);
        }
    }

    public final boolean zzb() {
        return !this.zzc.zzc().isEmpty();
    }

    public final boolean zzc() {
        return !this.zzc.zzb().equals(this.zzc.zza());
    }
}
