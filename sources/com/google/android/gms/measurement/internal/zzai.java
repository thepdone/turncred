package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzai extends zzjf {
    private Boolean zza;
    private String zzb;
    private zzak zzc;
    private Boolean zzd;

    public final double zza(String str, zzfx<Double> zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return zzfxVar.zza(null).doubleValue();
        }
        String strZza = this.zzc.zza(str, zzfxVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfxVar.zza(null).doubleValue();
        }
        try {
            return zzfxVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzfxVar.zza(null).doubleValue();
        }
    }

    final int zza(String str) {
        return zza(str, zzbn.zzar, 500, 2000);
    }

    final int zza(String str, boolean z) {
        if (z) {
            return zza(str, zzbn.zzbb, 100, 500);
        }
        return 500;
    }

    final int zzb(String str, boolean z) {
        return Math.max(zza(str, z), 256);
    }

    public final int zzc() {
        return zzs().zza(201500000, true) ? 100 : 25;
    }

    public final int zzb(String str) {
        return zza(str, zzbn.zzas, 25, 100);
    }

    public final int zzc(String str) {
        return zzb(str, zzbn.zzo);
    }

    public final int zzb(String str, zzfx<Integer> zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return zzfxVar.zza(null).intValue();
        }
        String strZza = this.zzc.zza(str, zzfxVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfxVar.zza(null).intValue();
        }
        try {
            return zzfxVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzfxVar.zza(null).intValue();
        }
    }

    public final int zza(String str, zzfx<Integer> zzfxVar, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzfxVar), i2), i);
    }

    final long zzd(String str) {
        return zzc(str, zzbn.zza);
    }

    public static long zzg() {
        return zzbn.zzd.zza(null).longValue();
    }

    public static long zzh() {
        return zzbn.zzk.zza(null).intValue();
    }

    public static long zzm() {
        return zzbn.zzam.zza(null).longValue();
    }

    public final long zzc(String str, zzfx<Long> zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return zzfxVar.zza(null).longValue();
        }
        String strZza = this.zzc.zza(str, zzfxVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfxVar.zza(null).longValue();
        }
        try {
            return zzfxVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzfxVar.zza(null).longValue();
        }
    }

    public static long zzo() {
        return zzbn.zzah.zza(null).longValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    private final Bundle zzac() throws IllegalStateException {
        try {
            if (zza().getPackageManager() == null) {
                zzj().zzg().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(zza().getPackageName(), 128);
            if (applicationInfo == null) {
                zzj().zzg().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzj().zzg().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    public final zzjm zzc(String str, boolean z) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzac = zzac();
        if (bundleZzac == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleZzac.get(str);
        }
        if (obj == null) {
            return zzjm.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzjm.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzjm.DENIED;
        }
        if (z && "eu_consent_policy".equals(obj)) {
            return zzjm.POLICY;
        }
        zzj().zzr().zza("Invalid manifest metadata for", str);
        return zzjm.UNINITIALIZED;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    final Boolean zze(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzac = zzac();
        if (bundleZzac == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzac.containsKey(str)) {
            return Boolean.valueOf(bundleZzac.getBoolean(str));
        }
        return null;
    }

    public final String zzp() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzq() {
        return zza("debug.deferred.deeplink", "");
    }

    public final String zzd(String str, zzfx<String> zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return zzfxVar.zza(null);
        }
        return zzfxVar.zza(this.zzc.zza(str, zzfxVar.zza()));
    }

    public final String zzr() {
        return this.zzb;
    }

    final String zzf(String str) {
        return zzd(str, zzbn.zzav);
    }

    private final String zza(String str, String str2) throws IllegalStateException {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            zzj().zzg().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            zzj().zzg().zza("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzj().zzg().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzj().zzg().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List<java.lang.String> zzg(java.lang.String r4) throws java.lang.IllegalStateException, android.content.res.Resources.NotFoundException {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzac()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.zzgo r4 = r3.zzj()
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzg()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.zza()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzgo r0 = r3.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzg()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzg(java.lang.String):java.util.List");
    }

    zzai(zzic zzicVar) {
        super(zzicVar);
        this.zzc = new zzak() { // from class: com.google.android.gms.measurement.internal.zzal
            @Override // com.google.android.gms.measurement.internal.zzak
            public final String zza(String str, String str2) {
                return null;
            }
        };
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

    final void zza(zzak zzakVar) {
        this.zzc = zzakVar;
    }

    public final void zzh(String str) {
        this.zzb = str;
    }

    public final boolean zzw() {
        Boolean boolZze = zze("google_analytics_adid_collection_enabled");
        return boolZze == null || boolZze.booleanValue();
    }

    final boolean zzi(String str) {
        return zzf(str, zzbn.zzau);
    }

    public final boolean zza(zzfx<Boolean> zzfxVar) {
        return zzf(null, zzfxVar);
    }

    public final boolean zze(String str, zzfx<Boolean> zzfxVar) {
        return zzf(str, zzfxVar);
    }

    public final boolean zzf(String str, zzfx<Boolean> zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return zzfxVar.zza(null).booleanValue();
        }
        String strZza = this.zzc.zza(str, zzfxVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfxVar.zza(null).booleanValue();
        }
        return zzfxVar.zza(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strZza))).booleanValue();
    }

    public final boolean zzj(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzx() {
        Boolean boolZze = zze("google_analytics_automatic_screen_reporting_enabled");
        return boolZze == null || boolZze.booleanValue();
    }

    public final boolean zzy() {
        Boolean boolZze = zze("firebase_analytics_collection_deactivated");
        return boolZze != null && boolZze.booleanValue();
    }

    public final boolean zzk(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzz() {
        if (this.zza == null) {
            Boolean boolZze = zze("app_measurement_lite");
            this.zza = boolZze;
            if (boolZze == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzu.zzai();
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzaa() {
        if (this.zzd == null) {
            synchronized (this) {
                if (this.zzd == null) {
                    ApplicationInfo applicationInfo = zza().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzd = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzd == null) {
                        this.zzd = Boolean.TRUE;
                        zzj().zzg().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzd.booleanValue();
    }

    public final boolean zzab() {
        Boolean boolZze = zze("google_analytics_sgtm_upload_enabled");
        if (boolZze == null) {
            return false;
        }
        return boolZze.booleanValue();
    }
}
