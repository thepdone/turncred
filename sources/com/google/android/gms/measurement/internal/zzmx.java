package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmx extends zzbb {
    private final /* synthetic */ zzme zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzmx(zzme zzmeVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzmeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() throws IllegalStateException {
        this.zza.zzj().zzr().zza("Tasks have been queued for a long time");
    }
}
