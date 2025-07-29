package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpa implements zzox {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;
    private static final zzhx<Boolean> zzc;
    private static final zzhx<Boolean> zzd;
    private static final zzhx<Boolean> zze;
    private static final zzhx<Boolean> zzf;
    private static final zzhx<Boolean> zzg;
    private static final zzhx<Boolean> zzh;
    private static final zzhx<Boolean> zzi;
    private static final zzhx<Boolean> zzj;

    static {
        zzif zzifVarZza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzifVarZza.zza("measurement.rb.attribution.ad_campaign_info", true);
        zzifVarZza.zza("measurement.rb.attribution.client.bundle_on_backgrounded", true);
        zzifVarZza.zza("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        zzb = zzifVarZza.zza("measurement.rb.attribution.client2", true);
        zzifVarZza.zza("measurement.rb.attribution.dma_fix", true);
        zzc = zzifVarZza.zza("measurement.rb.attribution.followup1.service", false);
        zzd = zzifVarZza.zza("measurement.rb.attribution.client.get_trigger_uris_async", false);
        zze = zzifVarZza.zza("measurement.rb.attribution.service.trigger_uris_high_priority", true);
        zzifVarZza.zza("measurement.rb.attribution.index_out_of_bounds_fix", true);
        zzf = zzifVarZza.zza("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        zzg = zzifVarZza.zza("measurement.rb.attribution.retry_disposition", false);
        zzh = zzifVarZza.zza("measurement.rb.attribution.service", true);
        zzi = zzifVarZza.zza("measurement.rb.attribution.enable_trigger_redaction", true);
        zzj = zzifVarZza.zza("measurement.rb.attribution.uuid_generation", true);
        zzifVarZza.zza("measurement.id.rb.attribution.retry_disposition", 0L);
        zzifVarZza.zza("measurement.id.rb.attribution.client.get_trigger_uris_async", 0L);
        zzifVarZza.zza("measurement.rb.attribution.improved_retry", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zze() {
        return zzd.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzf() {
        return zze.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzg() {
        return zzf.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzh() {
        return zzg.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzi() {
        return zzh.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzj() {
        return zzi.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzk() {
        return zzj.zza().booleanValue();
    }
}
