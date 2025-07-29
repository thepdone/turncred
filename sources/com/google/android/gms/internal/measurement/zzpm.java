package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpm implements zzpj {
    private static final zzhx<Boolean> zza;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zzifVarZza.zza("measurement.client.sessions.background_sessions_enabled", true);
        zza = zzifVarZza.zza("measurement.client.sessions.enable_fix_background_engagement", false);
        zzifVarZza.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzifVarZza.zza("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzifVarZza.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zzifVarZza.zza("measurement.client.sessions.session_id_enabled", true);
        zzifVarZza.zza("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpj
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
