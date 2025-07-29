package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzol extends zzbb {
    private final /* synthetic */ zzoi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzol(zzoi zzoiVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzoiVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() throws IllegalStateException {
        this.zza.zzr();
        this.zza.zzj().zzq().zza("Starting upload from DelayedRunnable");
        this.zza.zzg.zzx();
    }
}
