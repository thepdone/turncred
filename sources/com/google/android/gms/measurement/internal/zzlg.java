package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlg implements Runnable {
    private final /* synthetic */ zzbd zza;
    private final /* synthetic */ zzju zzb;

    zzlg(zzju zzjuVar, zzbd zzbdVar) {
        this.zza = zzbdVar;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        if (!this.zzb.zzk().zza(this.zza)) {
            this.zzb.zzj().zzp().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.zza.zza()));
            return;
        }
        this.zzb.zzj().zzq().zza("Setting DMA consent(FE)", this.zza);
        if (this.zzb.zzq().zzao()) {
            this.zzb.zzq().zzaj();
        } else {
            this.zzb.zzq().zza(false);
        }
    }
}
