package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoi implements zzof {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zzifVarZza.zza("measurement.collection.event_safelist", true);
        zza = zzifVarZza.zza("measurement.service.store_null_safelist", true);
        zzb = zzifVarZza.zza("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
