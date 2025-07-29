package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzfq extends zzed.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ Activity zzd;
    private final /* synthetic */ zzed.zzc zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfq(zzed.zzc zzcVar, Bundle bundle, Activity activity) {
        super(zzed.this);
        this.zzc = bundle;
        this.zzd = activity;
        this.zze = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        Bundle bundle;
        if (this.zzc != null) {
            bundle = new Bundle();
            if (this.zzc.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.zzc.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((zzdl) Preconditions.checkNotNull(zzed.this.zzj)).onActivityCreatedByScionActivityInfo(zzeb.zza(this.zzd), bundle, this.zzb);
    }
}
