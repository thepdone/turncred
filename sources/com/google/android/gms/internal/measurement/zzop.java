package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzop implements zzoq {
    private static final zzhx<Boolean> zza;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zzifVarZza.zza("measurement.gmscore_feature_tracking", true);
        zza = zzifVarZza.zza("measurement.gmscore_client_telemetry", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzoq
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
