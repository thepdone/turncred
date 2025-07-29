package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.measurement.internal.zzjj;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public class zzic implements zzjh {
    private static volatile zzic zzb;
    final long zza;
    private Boolean zzab;
    private long zzac;
    private volatile Boolean zzad;
    private Boolean zzae;
    private Boolean zzaf;
    private volatile boolean zzag;
    private int zzah;
    private int zzai;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzaf zzh;
    private final zzai zzi;
    private final zzha zzj;
    private final zzgo zzk;
    private final zzhv zzl;
    private final zznx zzm;
    private final zzpn zzn;
    private final zzgl zzo;
    private final Clock zzp;
    private final zzlz zzq;
    private final zzju zzr;
    private final zza zzs;
    private final zzlp zzt;
    private final String zzu;
    private zzgj zzv;
    private zzme zzw;
    private zzbf zzx;
    private zzgg zzy;
    private zzls zzz;
    private boolean zzaa = false;
    private AtomicInteger zzaj = new AtomicInteger(0);

    public final int zzc() {
        zzl().zzv();
        if (this.zzi.zzy()) {
            return 1;
        }
        Boolean bool = this.zzaf;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!zzaf()) {
            return 8;
        }
        Boolean boolZzw = zzn().zzw();
        if (boolZzw != null) {
            return boolZzw.booleanValue() ? 0 : 3;
        }
        Boolean boolZze = this.zzi.zze("firebase_analytics_collection_enabled");
        if (boolZze != null) {
            return boolZze.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzae;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.zzad == null || this.zzad.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final Context zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final Clock zzb() {
        return this.zzp;
    }

    @Pure
    public final zza zze() {
        zza((zzg) this.zzs);
        return this.zzs;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final zzaf zzd() {
        return this.zzh;
    }

    @Pure
    public final zzai zzf() {
        return this.zzi;
    }

    @Pure
    public final zzbf zzg() {
        zza((zzji) this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzgg zzh() {
        zza((zzf) this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzgj zzi() {
        zza((zzf) this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzgl zzk() {
        return this.zzo;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final zzgo zzj() {
        zza((zzji) this.zzk);
        return this.zzk;
    }

    public final zzgo zzm() {
        zzgo zzgoVar = this.zzk;
        if (zzgoVar == null || !zzgoVar.zzag()) {
            return null;
        }
        return this.zzk;
    }

    @Pure
    public final zzha zzn() {
        zza((zzjf) this.zzj);
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final zzhv zzl() {
        zza((zzji) this.zzl);
        return this.zzl;
    }

    @SideEffectFree
    final zzhv zzo() {
        return this.zzl;
    }

    public static zzic zza(Context context, com.google.android.gms.internal.measurement.zzdz zzdzVar, Long l) {
        if (zzdzVar != null && (zzdzVar.zze == null || zzdzVar.zzf == null)) {
            zzdzVar = new com.google.android.gms.internal.measurement.zzdz(zzdzVar.zza, zzdzVar.zzb, zzdzVar.zzc, zzdzVar.zzd, null, null, zzdzVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzic.class) {
                if (zzb == null) {
                    zzb = new zzic(new zzjs(context, zzdzVar, l));
                }
            }
        } else if (zzdzVar != null && zzdzVar.zzg != null && zzdzVar.zzg.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zza(zzdzVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    @Pure
    public final zzju zzp() {
        zza((zzf) this.zzr);
        return this.zzr;
    }

    @Pure
    public final zzlp zzq() {
        zza((zzji) this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzls zzr() {
        zza((zzg) this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzlz zzs() {
        zza((zzf) this.zzq);
        return this.zzq;
    }

    @Pure
    public final zzme zzt() {
        zza((zzf) this.zzw);
        return this.zzw;
    }

    @Pure
    public final zznx zzu() {
        zza((zzf) this.zzm);
        return this.zzm;
    }

    @Pure
    public final zzpn zzv() {
        zza((zzjf) this.zzn);
        return this.zzn;
    }

    @Pure
    public final String zzw() {
        return this.zzd;
    }

    @Pure
    public final String zzx() {
        return this.zze;
    }

    @Pure
    public final String zzy() {
        return this.zzf;
    }

    @Pure
    public final String zzz() {
        return this.zzu;
    }

    public static /* synthetic */ void zza(zzic zzicVar, String str, int i, Throwable th, byte[] bArr, Map map) throws IllegalStateException {
        List<ResolveInfo> listQueryIntentActivities;
        if ((i != 200 && i != 204 && i != 304) || th != null) {
            zzicVar.zzj().zzr().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzicVar.zzn().zzo.zza(true);
        if (bArr == null || bArr.length == 0) {
            zzicVar.zzj().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "");
            if (TextUtils.isEmpty(strOptString)) {
                zzicVar.zzj().zzc().zza("Deferred Deep Link is empty.");
                return;
            }
            String strOptString2 = jSONObject.optString("gclid", "");
            String strOptString3 = jSONObject.optString("gbraid", "");
            String strOptString4 = jSONObject.optString("gad_source", "");
            double dOptDouble = jSONObject.optDouble("timestamp", AudioStats.AUDIO_AMPLITUDE_NONE);
            Bundle bundle = new Bundle();
            zzpn zzpnVarZzv = zzicVar.zzv();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = zzpnVarZzv.zza().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                zzicVar.zzj().zzr().zza("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                return;
            }
            if (!TextUtils.isEmpty(strOptString3)) {
                bundle.putString("gbraid", strOptString3);
            }
            if (!TextUtils.isEmpty(strOptString4)) {
                bundle.putString("gad_source", strOptString4);
            }
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            zzicVar.zzr.zzc("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
            zzpn zzpnVarZzv2 = zzicVar.zzv();
            if (TextUtils.isEmpty(strOptString) || !zzpnVarZzv2.zza(strOptString, dOptDouble)) {
                return;
            }
            zzpnVarZzv2.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzicVar.zzj().zzg().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    static /* synthetic */ void zza(zzic zzicVar, zzjs zzjsVar) throws IllegalStateException {
        zzicVar.zzl().zzv();
        zzbf zzbfVar = new zzbf(zzicVar);
        zzbfVar.zzae();
        zzicVar.zzx = zzbfVar;
        zzgg zzggVar = new zzgg(zzicVar, zzjsVar.zzf);
        zzggVar.zzx();
        zzicVar.zzy = zzggVar;
        zzgj zzgjVar = new zzgj(zzicVar);
        zzgjVar.zzx();
        zzicVar.zzv = zzgjVar;
        zzme zzmeVar = new zzme(zzicVar);
        zzmeVar.zzx();
        zzicVar.zzw = zzmeVar;
        zzicVar.zzn.zzaf();
        zzicVar.zzj.zzaf();
        zzicVar.zzy.zzy();
        zzls zzlsVar = new zzls(zzicVar);
        zzlsVar.zzx();
        zzicVar.zzz = zzlsVar;
        zzlsVar.zzy();
        zzicVar.zzj().zzp().zza("App measurement initialized, version", 114010L);
        zzicVar.zzj().zzp().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzaf = zzggVar.zzaf();
        if (TextUtils.isEmpty(zzicVar.zzd)) {
            if (zzicVar.zzv().zzd(strZzaf, zzicVar.zzi.zzr())) {
                zzicVar.zzj().zzp().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzicVar.zzj().zzp().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + strZzaf);
            }
        }
        zzicVar.zzj().zzc().zza("Debug-level message logging enabled");
        if (zzicVar.zzah != zzicVar.zzaj.get()) {
            zzicVar.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzicVar.zzah), Integer.valueOf(zzicVar.zzaj.get()));
        }
        zzicVar.zzaa = true;
    }

    private zzic(zzjs zzjsVar) throws IllegalStateException {
        long jCurrentTimeMillis;
        boolean z = false;
        Preconditions.checkNotNull(zzjsVar);
        zzaf zzafVar = new zzaf(zzjsVar.zza);
        this.zzh = zzafVar;
        zzfu.zza = zzafVar;
        Context context = zzjsVar.zza;
        this.zzc = context;
        this.zzd = zzjsVar.zzb;
        this.zze = zzjsVar.zzc;
        this.zzf = zzjsVar.zzd;
        this.zzg = zzjsVar.zzh;
        this.zzad = zzjsVar.zze;
        this.zzu = zzjsVar.zzj;
        this.zzag = true;
        com.google.android.gms.internal.measurement.zzdz zzdzVar = zzjsVar.zzg;
        if (zzdzVar != null && zzdzVar.zzg != null) {
            Object obj = zzdzVar.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzae = (Boolean) obj;
            }
            Object obj2 = zzdzVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzaf = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzhx.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        if (zzjsVar.zzi != null) {
            jCurrentTimeMillis = zzjsVar.zzi.longValue();
        } else {
            jCurrentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = jCurrentTimeMillis;
        this.zzi = new zzai(this);
        zzha zzhaVar = new zzha(this);
        zzhaVar.zzae();
        this.zzj = zzhaVar;
        zzgo zzgoVar = new zzgo(this);
        zzgoVar.zzae();
        this.zzk = zzgoVar;
        zzpn zzpnVar = new zzpn(this);
        zzpnVar.zzae();
        this.zzn = zzpnVar;
        this.zzo = new zzgl(new zzjv(zzjsVar, this));
        this.zzs = new zza(this);
        zzlz zzlzVar = new zzlz(this);
        zzlzVar.zzx();
        this.zzq = zzlzVar;
        zzju zzjuVar = new zzju(this);
        zzjuVar.zzx();
        this.zzr = zzjuVar;
        zznx zznxVar = new zznx(this);
        zznxVar.zzx();
        this.zzm = zznxVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzae();
        this.zzt = zzlpVar;
        zzhv zzhvVar = new zzhv(this);
        zzhvVar.zzae();
        this.zzl = zzhvVar;
        if (zzjsVar.zzg != null && zzjsVar.zzg.zzb != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            zzp().zzb(z2);
        } else {
            zzj().zzr().zza("Application context is not an Application");
        }
        zzhvVar.zzb(new zzid(this, zzjsVar));
    }

    private static void zza(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzjf zzjfVar) {
        if (zzjfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzfVar.zzaa()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzfVar.getClass()));
    }

    private static void zza(zzji zzjiVar) {
        if (zzjiVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzjiVar.zzag()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzjiVar.getClass()));
    }

    final void zzaa() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zzab() {
        this.zzaj.incrementAndGet();
    }

    final void zzac() {
        this.zzah++;
    }

    final void zza(boolean z) {
        this.zzad = Boolean.valueOf(z);
    }

    public final void zzb(boolean z) {
        zzl().zzv();
        this.zzag = z;
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzdz zzdzVar) throws IllegalStateException {
        zzjj zzjjVarZza;
        Boolean boolZza;
        zzl().zzv();
        boolean z = this.zzi.zza(zzbn.zzcl) && zzr().zzac() == zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE;
        if ((com.google.android.gms.internal.measurement.zzoy.zza() && this.zzi.zza(zzbn.zzcq) && zzv().zzx()) || z) {
            zzpn zzpnVarZzv = zzv();
            zzpnVarZzv.zzv();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            if (zzpnVarZzv.zze().zza(zzbn.zzcl)) {
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            }
            ContextCompat.registerReceiver(zzpnVarZzv.zza(), new zzq(zzpnVarZzv.zzu), intentFilter, 2);
            zzpnVarZzv.zzj().zzc().zza("Registered app receiver");
        }
        if (z) {
            zzr().zza(zzbn.zzx.zza(null).longValue());
        }
        zzjj zzjjVarZzp = zzn().zzp();
        int iZza = zzjjVarZzp.zza();
        zzjm zzjmVarZzc = this.zzi.zzc("google_analytics_default_allow_ad_storage", false);
        zzjm zzjmVarZzc2 = this.zzi.zzc("google_analytics_default_allow_analytics_storage", false);
        if ((zzjmVarZzc != zzjm.UNINITIALIZED || zzjmVarZzc2 != zzjm.UNINITIALIZED) && zzn().zza(-10)) {
            zzjjVarZza = zzjj.zza(zzjmVarZzc, zzjmVarZzc2, -10);
        } else {
            if (!TextUtils.isEmpty(zzh().zzah()) && (iZza == 0 || iZza == 30 || iZza == 10 || iZza == 30 || iZza == 30 || iZza == 40)) {
                zzp().zza(new zzjj(null, null, -10), false);
            } else if (TextUtils.isEmpty(zzh().zzah()) && zzdzVar != null && zzdzVar.zzg != null && zzn().zza(30)) {
                zzjjVarZza = zzjj.zza(zzdzVar.zzg, 30);
                if (!zzjjVarZza.zzi()) {
                }
            }
            zzjjVarZza = null;
        }
        if (zzjjVarZza != null) {
            zzp().zza(zzjjVarZza, true);
            zzjjVarZzp = zzjjVarZza;
        }
        zzp().zza(zzjjVarZzp);
        int iZza2 = zzn().zzo().zza();
        zzjm zzjmVarZzc3 = this.zzi.zzc("google_analytics_default_allow_ad_personalization_signals", true);
        if (zzjmVarZzc3 != zzjm.UNINITIALIZED) {
            zzj().zzq().zza("Default ad personalization consent from Manifest", zzjmVarZzc3);
        }
        zzjm zzjmVarZzc4 = this.zzi.zzc("google_analytics_default_allow_ad_user_data", true);
        if (zzjmVarZzc4 != zzjm.UNINITIALIZED && zzjj.zza(-10, iZza2)) {
            zzp().zza(zzbd.zza(zzjmVarZzc4, -10), true);
        } else if (!TextUtils.isEmpty(zzh().zzah()) && (iZza2 == 0 || iZza2 == 30)) {
            zzp().zza(new zzbd(null, -10), true);
        } else {
            if (TextUtils.isEmpty(zzh().zzah()) && zzdzVar != null && zzdzVar.zzg != null && zzjj.zza(30, iZza2)) {
                zzbd zzbdVarZza = zzbd.zza(zzdzVar.zzg, 30);
                if (zzbdVarZza.zzg()) {
                    zzp().zza(zzbdVarZza, true);
                }
            }
            if (TextUtils.isEmpty(zzh().zzah()) && zzdzVar != null && zzdzVar.zzg != null && zzn().zzh.zza() == null && (boolZza = zzbd.zza(zzdzVar.zzg)) != null) {
                zzp().zza(zzdzVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) boolZza.toString(), false);
            }
        }
        Boolean boolZze = this.zzi.zze("google_analytics_tcf_data_enabled");
        if (boolZze == null ? true : boolZze.booleanValue()) {
            zzj().zzc().zza("TCF client enabled.");
            zzp().zzaw();
            zzp().zzau();
        }
        if (zzn().zzc.zza() == 0) {
            zzj().zzq().zza("Persisting first open", Long.valueOf(this.zza));
            zzn().zzc.zza(this.zza);
        }
        zzp().zza.zzb();
        if (!zzah()) {
            if (zzae()) {
                if (!zzv().zze("android.permission.INTERNET")) {
                    zzj().zzg().zza("App is missing INTERNET permission");
                }
                if (!zzv().zze("android.permission.ACCESS_NETWORK_STATE")) {
                    zzj().zzg().zza("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!Wrappers.packageManager(this.zzc).isCallerInstantApp() && !this.zzi.zzz()) {
                    if (!zzpn.zza(this.zzc)) {
                        zzj().zzg().zza("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzpn.zza(this.zzc, false)) {
                        zzj().zzg().zza("AppMeasurementService not registered/enabled");
                    }
                }
                zzj().zzg().zza("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(zzh().zzah()) || !TextUtils.isEmpty(zzh().zzae())) {
                zzv();
                if (zzpn.zza(zzh().zzah(), zzn().zzz(), zzh().zzae(), zzn().zzy())) {
                    zzj().zzp().zza("Rechecking which service to use due to a GMP App Id change");
                    zzn().zzaa();
                    zzi().zzac();
                    this.zzw.zzah();
                    this.zzw.zzag();
                    zzn().zzc.zza(this.zza);
                    zzn().zze.zza(null);
                }
                zzn().zzc(zzh().zzah());
                zzn().zzb(zzh().zzae());
            }
            if (!zzn().zzp().zza(zzjj.zza.ANALYTICS_STORAGE)) {
                zzn().zze.zza(null);
            }
            zzp().zzb(zzn().zze.zza());
            if (!zzv().zzy() && !TextUtils.isEmpty(zzn().zzq.zza())) {
                zzj().zzr().zza("Remote config removed with active feature rollouts");
                zzn().zzq.zza(null);
            }
            if (!TextUtils.isEmpty(zzh().zzah()) || !TextUtils.isEmpty(zzh().zzae())) {
                boolean zZzae = zzae();
                if (!zzn().zzac() && !this.zzi.zzy()) {
                    zzn().zzb(!zZzae);
                }
                if (zZzae) {
                    zzp().zzap();
                }
                zzu().zza.zza();
                zzt().zza(new AtomicReference<>());
                zzt().zza(zzn().zzt.zza());
            }
        }
        if (com.google.android.gms.internal.measurement.zzoy.zza() && this.zzi.zza(zzbn.zzcq) && zzv().zzx()) {
            if (zzbn.zzbr.zza(null).intValue() > 0) {
                long jMax = Math.max(500L, ((zzbn.zzbr.zza(null).intValue() * 1000) + new Random().nextInt(5000)) - this.zzp.elapsedRealtime());
                if (jMax > 500) {
                    zzj().zzq().zza("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(jMax));
                }
                zzp().zzc(jMax);
            } else {
                final zzju zzjuVarZzp = zzp();
                Objects.requireNonNull(zzjuVarZzp);
                new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzib
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        zzjuVarZzp.zzas();
                    }
                }).start();
            }
        }
        zzn().zzj.zza(true);
    }

    public final boolean zzad() {
        return this.zzad != null && this.zzad.booleanValue();
    }

    public final boolean zzae() {
        return zzc() == 0;
    }

    public final boolean zzaf() {
        zzl().zzv();
        return this.zzag;
    }

    @Pure
    public final boolean zzag() {
        return TextUtils.isEmpty(this.zzd);
    }

    protected final boolean zzah() {
        if (!this.zzaa) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzl().zzv();
        Boolean bool = this.zzab;
        if (bool == null || this.zzac == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzac) > 1000)) {
            this.zzac = this.zzp.elapsedRealtime();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(zzv().zze("android.permission.INTERNET") && zzv().zze("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzz() || (zzpn.zza(this.zzc) && zzpn.zza(this.zzc, false))));
            this.zzab = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!zzv().zza(zzh().zzah(), zzh().zzae()) && TextUtils.isEmpty(zzh().zzae())) {
                    z = false;
                }
                this.zzab = Boolean.valueOf(z);
            }
        }
        return this.zzab.booleanValue();
    }

    @Pure
    public final boolean zzai() {
        return this.zzg;
    }

    public final boolean zzaj() throws IllegalStateException {
        zzl().zzv();
        zza((zzji) zzq());
        String strZzaf = zzh().zzaf();
        if (!this.zzi.zzw()) {
            zzj().zzq().zza("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        Pair<String, Boolean> pairZza = zzn().zza(strZzaf);
        if (((Boolean) pairZza.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZza.first)) {
            zzj().zzq().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!zzq().zzc()) {
            zzj().zzr().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        zzme zzmeVarZzt = zzt();
        zzmeVarZzt.zzv();
        zzmeVarZzt.zzw();
        if (!zzmeVarZzt.zzap() || zzmeVarZzt.zzs().zzg() >= 234200) {
            zzap zzapVarZzac = zzp().zzac();
            Bundle bundle = zzapVarZzac != null ? zzapVarZzac.zza : null;
            if (bundle == null) {
                int i = this.zzai;
                this.zzai = i + 1;
                boolean z = i < 10;
                zzj().zzc().zza("Failed to retrieve DMA consent from the service, " + (z ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.zzai));
                return z;
            }
            sb.append("&gcs=").append(zzjj.zza(bundle, 100).zze());
            zzbd zzbdVarZza = zzbd.zza(bundle, 100);
            sb.append("&dma=").append(zzbdVarZza.zzd() == Boolean.FALSE ? 0 : 1);
            if (!TextUtils.isEmpty(zzbdVarZza.zze())) {
                sb.append("&dma_cps=").append(zzbdVarZza.zze());
            }
            sb.append("&npa=").append(zzbd.zza(bundle) == Boolean.TRUE ? 0 : 1);
            zzj().zzq().zza("Consent query parameters to Bow", sb);
        }
        zzpn zzpnVarZzv = zzv();
        zzh();
        URL urlZza = zzpnVarZzv.zza(114010L, strZzaf, (String) pairZza.first, zzn().zzp.zza() - 1, sb.toString());
        if (urlZza != null) {
            zzlp zzlpVarZzq = zzq();
            zzlo zzloVar = new zzlo() { // from class: com.google.android.gms.measurement.internal.zzie
                @Override // com.google.android.gms.measurement.internal.zzlo
                public final void zza(String str, int i2, Throwable th, byte[] bArr, Map map) throws IllegalStateException {
                    zzic.zza(this.zza, str, i2, th, bArr, map);
                }
            };
            zzlpVarZzq.zzad();
            Preconditions.checkNotNull(urlZza);
            Preconditions.checkNotNull(zzloVar);
            zzlpVarZzq.zzl().zza(new zzlr(zzlpVarZzq, strZzaf, urlZza, null, null, zzloVar));
        }
        return false;
    }
}
