package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzpb extends zzbb {
    private final /* synthetic */ zzou zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzpb(zzou zzouVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzouVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() throws IllegalStateException {
        this.zza.zzr();
        String str = (String) this.zza.zzr.pollFirst();
        if (str != null) {
            zzou zzouVar = this.zza;
            zzouVar.zzaj = zzouVar.zzb().elapsedRealtime();
            this.zza.zzj().zzq().zza("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            this.zza.zza().sendBroadcast(intent);
        }
        this.zza.zzae();
    }
}
