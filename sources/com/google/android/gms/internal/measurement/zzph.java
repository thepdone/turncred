package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzph implements zzpi {
    private static final zzhx<Boolean> zza;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zzifVarZza.zza("measurement.collection.enable_session_stitching_token.client.dev", true);
        zzifVarZza.zza("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zza = zzifVarZza.zza("measurement.session_stitching_token_enabled", false);
        zzifVarZza.zza("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpi
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpi
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
