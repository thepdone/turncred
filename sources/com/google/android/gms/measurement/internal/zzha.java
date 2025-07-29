package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjj;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzha extends zzji {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private long zzaa;
    public zzhe zzb;
    public final zzhf zzc;
    public final zzhf zzd;
    public final zzhh zze;
    public final zzhf zzf;
    public final zzhd zzg;
    public final zzhh zzh;
    public final zzhc zzi;
    public final zzhd zzj;
    public final zzhf zzk;
    public final zzhf zzl;
    public boolean zzm;
    public zzhd zzn;
    public zzhd zzo;
    public zzhf zzp;
    public final zzhh zzq;
    public final zzhh zzr;
    public final zzhf zzs;
    public final zzhc zzt;
    private SharedPreferences zzv;
    private Object zzw;
    private SharedPreferences zzx;
    private String zzy;
    private boolean zzz;

    protected final SharedPreferences zzc() {
        zzv();
        zzad();
        if (this.zzx == null) {
            synchronized (this.zzw) {
                if (this.zzx == null) {
                    String str = zza().getPackageName() + "_preferences";
                    zzj().zzq().zza("Default prefs file", str);
                    this.zzx = zza().getSharedPreferences(str, 0);
                }
            }
        }
        return this.zzx;
    }

    @Override // com.google.android.gms.measurement.internal.zzji
    protected final boolean zzh() {
        return true;
    }

    protected final SharedPreferences zzg() {
        zzv();
        zzad();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    final Pair<String, Boolean> zza(String str) {
        zzv();
        if (!zzp().zza(zzjj.zza.AD_STORAGE)) {
            return new Pair<>("", false);
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (this.zzy != null && jElapsedRealtime < this.zzaa) {
            return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
        }
        this.zzaa = jElapsedRealtime + zze().zzd(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            this.zzy = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzy = id;
            }
            this.zzz = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            this.zzy = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
    }

    final SparseArray<Long> zzm() {
        Bundle bundleZza = this.zzi.zza();
        if (bundleZza == null) {
            return new SparseArray<>();
        }
        int[] intArray = bundleZza.getIntArray("uriSources");
        long[] longArray = bundleZza.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            zzj().zzg().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    final zzbd zzo() {
        zzv();
        return zzbd.zza(zzg().getString("dma_consent_settings", null));
    }

    final zzjj zzp() {
        zzv();
        return zzjj.zza(zzg().getString("consent_settings", "G1"), zzg().getInt("consent_source", 100));
    }

    final Boolean zzq() {
        zzv();
        if (zzg().contains("use_service")) {
            return Boolean.valueOf(zzg().getBoolean("use_service", false));
        }
        return null;
    }

    final Boolean zzr() {
        zzv();
        if (zzg().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    final Boolean zzw() {
        zzv();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    protected final String zzx() {
        zzv();
        String string = zzg().getString("previous_os_version", null);
        zzf().zzad();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = zzg().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    final String zzy() {
        zzv();
        return zzg().getString("admob_app_id", null);
    }

    final String zzz() {
        zzv();
        return zzg().getString("gmp_app_id", null);
    }

    zzha(zzic zzicVar) {
        super(zzicVar);
        this.zzw = new Object();
        this.zzf = new zzhf(this, "session_timeout", 1800000L);
        this.zzg = new zzhd(this, "start_new_session", true);
        this.zzk = new zzhf(this, "last_pause_time", 0L);
        this.zzl = new zzhf(this, SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0L);
        this.zzh = new zzhh(this, "non_personalized_ads", null);
        this.zzi = new zzhc(this, "last_received_uri_timestamps_by_source", null);
        this.zzj = new zzhd(this, "allow_remote_dynamite", false);
        this.zzc = new zzhf(this, "first_open_time", 0L);
        this.zzd = new zzhf(this, "app_install_time", 0L);
        this.zze = new zzhh(this, "app_instance_id", null);
        this.zzn = new zzhd(this, "app_backgrounded", false);
        this.zzo = new zzhd(this, "deep_link_retrieval_complete", false);
        this.zzp = new zzhf(this, "deep_link_retrieval_attempts", 0L);
        this.zzq = new zzhh(this, "firebase_feature_rollouts", null);
        this.zzr = new zzhh(this, "deferred_attribution_cache", null);
        this.zzs = new zzhf(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzt = new zzhc(this, "default_event_parameters", null);
    }

    final void zzaa() {
        zzv();
        Boolean boolZzw = zzw();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolZzw != null) {
            zza(boolZzw);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzji
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    protected final void zzab() {
        SharedPreferences sharedPreferences = zza().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.zzv.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.zzb = new zzhe(this, "health_monitor", Math.max(0L, zzbn.zzc.zza(null).longValue()));
    }

    final void zzb(String str) {
        zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    final void zzc(String str) {
        zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    final void zza(Boolean bool) {
        zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    final void zzb(Boolean bool) {
        zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled_from_api");
        }
        editorEdit.apply();
    }

    final void zza(boolean z) {
        zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    final void zzb(boolean z) {
        zzv();
        zzj().zzq().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    final boolean zzac() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    final boolean zza(long j) {
        return j - this.zzf.zza() > this.zzk.zza();
    }

    final boolean zza(zzbd zzbdVar) {
        zzv();
        if (!zzjj.zza(zzbdVar.zza(), zzo().zza())) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("dma_consent_settings", zzbdVar.zzf());
        editorEdit.apply();
        return true;
    }

    final boolean zza(zzjj zzjjVar) {
        zzv();
        int iZza = zzjjVar.zza();
        if (!zza(iZza)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("consent_settings", zzjjVar.zzf());
        editorEdit.putInt("consent_source", iZza);
        editorEdit.apply();
        return true;
    }

    final boolean zza(int i) {
        return zzjj.zza(i, zzg().getInt("consent_source", 100));
    }

    protected final boolean zza(zzoe zzoeVar) {
        zzv();
        String string = zzg().getString("stored_tcf_param", "");
        String strZzc = zzoeVar.zzc();
        if (strZzc.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("stored_tcf_param", strZzc);
        editorEdit.apply();
        return true;
    }
}
