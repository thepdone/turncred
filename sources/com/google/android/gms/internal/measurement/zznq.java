package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zznq implements zznn {
    private static final zzhx<Boolean> zza;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzifVarZza.zza("measurement.service.ad_impression.convert_value_to_double", true);
        zzifVarZza.zza("measurement.client.ad_impression", true);
        zzifVarZza.zza("measurement.service.separate_public_internal_event_blacklisting", true);
        zzifVarZza.zza("measurement.service.ad_impression", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
