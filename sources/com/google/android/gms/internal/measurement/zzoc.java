package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoc implements zznz {
    private static final zzhx<Boolean> zza;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zzifVarZza.zza("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        zzifVarZza.zza("measurement.defensively_copy_bundles_validate_default_params", true);
        zzifVarZza.zza("measurement.set_default_event_parameters_with_backfill.service", true);
        zza = zzifVarZza.zza("measurement.set_default_event_parameters.fix_deferred_analytics_collection", false);
        zzifVarZza.zza("measurement.id.set_default_event_parameters.fix_deferred_analytics_collection", 0L);
        zzifVarZza.zza("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
