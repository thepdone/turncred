package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zznk implements Runnable {
    private final /* synthetic */ zzfz zza;
    private final /* synthetic */ zznj zzb;

    zznk(zznj zznjVar, zzfz zzfzVar) {
        this.zza = zzfzVar;
        this.zzb = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzal()) {
                this.zzb.zza.zzj().zzc().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
