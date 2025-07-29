package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzod implements zzoe {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzifVarZza.zza("measurement.set_default_event_parameters_propagate_clear.client.dev", false);
        zzb = zzifVarZza.zza("measurement.set_default_event_parameters_propagate_clear.service", false);
        zzifVarZza.zza("measurement.id.set_default_event_parameters_propagate_clear.experiment_id", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoe
    public final boolean zza() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoe
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }
}
