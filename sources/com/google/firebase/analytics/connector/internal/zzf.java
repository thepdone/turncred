package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzf implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ zzc zza;

    public zzf(zzc zzcVar) {
        this.zza = zzcVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzjt
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzd.zza(str2));
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
