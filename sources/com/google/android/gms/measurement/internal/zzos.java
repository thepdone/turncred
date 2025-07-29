package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgf;
import java.util.Collections;
import java.util.HashMap;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzos extends zzok {
    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzx zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzar zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzhm zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zznp zzo() {
        return super.zzo();
    }

    public final zzov zza(String str) {
        zzov zzovVar = null;
        if (zze().zza(zzbn.zzcj)) {
            zzh zzhVarZzd = zzh().zzd(str);
            if (zzhVarZzd == null || !zzhVarZzd.zzat()) {
                return new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
            }
            zzgf.zzo.zzb zzbVarZza = zzgf.zzo.zza().zza(zzgf.zzo.zzd.GA_UPLOAD).zza((zzgf.zzo.zza) Preconditions.checkNotNull(zzgf.zzo.zza.zza(zzhVarZzd.zzb())));
            if (!zza(str, zzhVarZzd.zzad())) {
                zzbVarZza.zza(zzgf.zzo.zzc.NOT_IN_ROLLOUT);
                return new zzov(zzb(str), Collections.emptyMap(), zzlu.GOOGLE_ANALYTICS, (zzgf.zzo) ((com.google.android.gms.internal.measurement.zzkg) zzbVarZza.zzaj()));
            }
            String strZzac = zzhVarZzd.zzac();
            zzbVarZza.zza(zzgf.zzo.zzd.GA_UPLOAD);
            zzgc.zzd zzdVarZzc = zzm().zzc(zzhVarZzd.zzac());
            if (zzdVarZzc == null || !zzdVarZzc.zzq()) {
                zzj().zzq().zza("[sgtm] Missing sgtm_setting in remote config. appId", strZzac);
                zzbVarZza.zza(zzgf.zzo.zzc.MISSING_SGTM_SETTINGS);
            } else {
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(zzhVarZzd.zzam())) {
                    map.put("x-gtm-server-preview", zzhVarZzd.zzam());
                }
                String strZze = zzdVarZzc.zzh().zze();
                zzgf.zzo.zza zzaVarZza = zzgf.zzo.zza.zza(zzhVarZzd.zzb());
                if (zzaVarZza != null && zzaVarZza != zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE) {
                    zzbVarZza.zza(zzaVarZza);
                } else if (!zze().zza(zzbn.zzcj)) {
                    zzbVarZza.zza(zzgf.zzo.zza.SERVICE_FLAG_OFF);
                } else if (zzc(zzhVarZzd.zzac())) {
                    zzbVarZza.zza(zzgf.zzo.zza.PINNED_TO_SERVICE_UPLOAD);
                } else if (TextUtils.isEmpty(strZze)) {
                    zzbVarZza.zza(zzgf.zzo.zza.MISSING_SGTM_SERVER_URL);
                } else {
                    zzj().zzq().zza("[sgtm] Eligible for client side upload. appId", strZzac);
                    zzbVarZza.zza(zzgf.zzo.zzd.SDK_CLIENT_UPLOAD).zza(zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE);
                    zzovVar = new zzov(strZze, map, zzlu.SGTM_CLIENT, (zzgf.zzo) ((com.google.android.gms.internal.measurement.zzkg) zzbVarZza.zzaj()));
                }
                zzdVarZzc.zzh().zzf();
                zzdVarZzc.zzh().zzd();
                if (!TextUtils.isEmpty(strZze)) {
                    zzj().zzq().zza("[sgtm] Eligible for local service direct upload. appId", strZzac);
                    zzbVarZza.zza(zzgf.zzo.zzd.SDK_SERVICE_UPLOAD).zza(zzgf.zzo.zzc.SERVICE_UPLOAD_ELIGIBLE);
                    zzovVar = new zzov(strZze, map, zzlu.SGTM, (zzgf.zzo) ((com.google.android.gms.internal.measurement.zzkg) zzbVarZza.zzaj()));
                } else {
                    zzbVarZza.zza(zzgf.zzo.zzc.NON_PLAY_MISSING_SGTM_SERVER_URL);
                    zzj().zzq().zza("[sgtm] Local service, missing sgtm_server_url", zzhVarZzd.zzac());
                }
            }
            return zzovVar != null ? zzovVar : new zzov(zzb(str), Collections.emptyMap(), zzlu.GOOGLE_ANALYTICS, (zzgf.zzo) ((com.google.android.gms.internal.measurement.zzkg) zzbVarZza.zzaj()));
        }
        zzh zzhVarZzd2 = zzh().zzd(str);
        if (zzhVarZzd2 == null) {
            return new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
        }
        if (!zza(str, zzhVarZzd2.zzad())) {
            return new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
        }
        if (zzhVarZzd2.zzat()) {
            zzj().zzq().zza("sgtm upload enabled in manifest.");
            zzgc.zzd zzdVarZzc2 = zzm().zzc(zzhVarZzd2.zzac());
            if (zzdVarZzc2 != null && zzdVarZzc2.zzq()) {
                String strZzf = zzdVarZzc2.zzh().zzf();
                if (!TextUtils.isEmpty(strZzf)) {
                    String strZzd = zzdVarZzc2.zzh().zzd();
                    zzj().zzq().zza("sgtm configured with upload_url, server_info", strZzf, TextUtils.isEmpty(strZzd) ? "Y" : "N");
                    if (TextUtils.isEmpty(strZzd)) {
                        zzovVar = new zzov(strZzf, zzlu.SGTM);
                    } else {
                        HashMap map2 = new HashMap();
                        map2.put("x-sgtm-server-info", strZzd);
                        if (!TextUtils.isEmpty(zzhVarZzd2.zzam())) {
                            map2.put("x-gtm-server-preview", zzhVarZzd2.zzam());
                        }
                        zzovVar = new zzov(strZzf, map2, zzlu.SGTM);
                    }
                }
            }
        }
        return zzovVar != null ? zzovVar : new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzos zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzpj h_() {
        return super.h_();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    private final String zzb(String str) throws IllegalStateException {
        String strZzf = zzm().zzf(str);
        if (!TextUtils.isEmpty(strZzf)) {
            Uri uri = Uri.parse(zzbn.zzq.zza(null));
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.authority(strZzf + "." + uri.getAuthority());
            return builderBuildUpon.build().toString();
        }
        return zzbn.zzq.zza(null);
    }

    zzos(zzou zzouVar) {
        super(zzouVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    private final boolean zza(String str, String str2) throws IllegalStateException {
        zzh zzhVarZzd;
        zzgc.zzd zzdVarZzc = zzm().zzc(str);
        if (zzdVarZzc == null || (zzhVarZzd = zzh().zzd(str)) == null) {
            return false;
        }
        if ((zzdVarZzc.zzq() && zzdVarZzc.zzh().zza() == 100) || zzs().zzd(str, zzhVarZzd.zzam())) {
            return true;
        }
        return !TextUtils.isEmpty(str2) && Math.abs(str2.hashCode() % 100) < zzdVarZzc.zzh().zza();
    }

    final boolean zza(String str, zzgf.zzo.zza zzaVar) {
        zzgc.zzd zzdVarZzc;
        zzv();
        return zze().zza(zzbn.zzcj) && zzaVar == zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE && !zzc(str) && (zzdVarZzc = zzm().zzc(str)) != null && zzdVarZzc.zzq() && !zzdVarZzc.zzh().zze().isEmpty();
    }

    private static boolean zzc(String str) {
        String strZza = zzbn.zzs.zza(null);
        if (TextUtils.isEmpty(strZza)) {
            return false;
        }
        for (String str2 : strZza.split(",")) {
            if (str.equalsIgnoreCase(str2.trim())) {
                return true;
            }
        }
        return false;
    }
}
