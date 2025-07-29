package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzc implements zza {
    Set<String> zza;
    private AnalyticsConnector.AnalyticsConnectorListener zzb;
    private AppMeasurementSdk zzc;
    private zzf zzd;

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    public zzc(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzf zzfVar = new zzf(this);
        this.zzd = zzfVar;
        this.zzc.registerOnMeasurementEventListener(zzfVar);
        this.zza = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
        this.zza.clear();
        Set<String> set2 = this.zza;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            }
            if (zzd.zzc(str) && zzd.zzd(str)) {
                String strZzb = zzd.zzb(str);
                Preconditions.checkNotNull(strZzb);
                hashSet.add(strZzb);
            }
        }
        set2.addAll(hashSet);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
        this.zza.clear();
    }
}
