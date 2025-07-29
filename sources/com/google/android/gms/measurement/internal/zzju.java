package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.contacts.Columns;
import io.sentry.protocol.App;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzju extends zzf {
    final zzu zza;
    private zzlk zzb;
    private zzjq zzc;
    private final Set<zzjt> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private int zzi;
    private zzbb zzj;
    private zzbb zzk;
    private PriorityQueue<zzog> zzl;
    private boolean zzm;
    private zzjj zzn;
    private final AtomicLong zzo;
    private long zzp;
    private boolean zzq;
    private zzbb zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzbb zzt;
    private final zzpp zzv;

    public static int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
    }

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

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
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

    public final zzap zzac() {
        zzv();
        return zzq().zzac();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
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

    static /* synthetic */ int zza(zzju zzjuVar, Throwable th) {
        String message = th.getMessage();
        zzjuVar.zzm = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (message.contains("Background")) {
            zzjuVar.zzm = true;
        }
        return 1;
    }

    public final zzll zzad() {
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    public final Boolean zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzkg(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzle(this, atomicReference));
    }

    public final Integer zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzlf(this, atomicReference));
    }

    public final Long zzah() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzlc(this, atomicReference));
    }

    public final String zzai() {
        return this.zzf.get();
    }

    public final String zzaj() {
        zzlw zzlwVarZzac = this.zzu.zzs().zzac();
        if (zzlwVarZzac != null) {
            return zzlwVarZzac.zzb;
        }
        return null;
    }

    public final String zzak() {
        zzlw zzlwVarZzac = this.zzu.zzs().zzac();
        if (zzlwVarZzac != null) {
            return zzlwVarZzac.zza;
        }
        return null;
    }

    public final String zzal() throws IllegalStateException {
        if (this.zzu.zzw() != null) {
            return this.zzu.zzw();
        }
        try {
            return new zzhw(zza(), this.zzu.zzz()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String zzam() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzks(this, atomicReference));
    }

    public final ArrayList<Bundle> zza(String str, String str2) throws IllegalStateException {
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get conditional user properties", new zzky(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return zzpn.zzb((List<zzag>) list);
    }

    public final List<zzpm> zza(boolean z) throws IllegalStateException {
        zzw();
        zzj().zzq().zza("Getting user properties (FE)");
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzkv(this, atomicReference, z));
        List<zzpm> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) throws IllegalStateException {
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzlb(this, atomicReference, null, str, str2, z));
        List<zzpm> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzpm zzpmVar : list) {
            Object objZza = zzpmVar.zza();
            if (objZza != null) {
                arrayMap.put(zzpmVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    final PriorityQueue<zzog> zzan() {
        if (this.zzl == null) {
            this.zzl = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzog) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzjw
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.zzl;
    }

    public static /* synthetic */ void zza(zzju zzjuVar, AtomicReference atomicReference) {
        Bundle bundleZza = zzjuVar.zzk().zzi.zza();
        zzme zzmeVarZzq = zzjuVar.zzq();
        if (bundleZza == null) {
            bundleZza = new Bundle();
        }
        zzmeVarZzq.zza((AtomicReference<List<zzog>>) atomicReference, bundleZza);
    }

    public static /* synthetic */ void zza(zzju zzjuVar, List list) throws IllegalStateException {
        zzjuVar.zzv();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> sparseArrayZzm = zzjuVar.zzk().zzm();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzog zzogVar = (zzog) it.next();
                if (!sparseArrayZzm.contains(zzogVar.zzc) || sparseArrayZzm.get(zzogVar.zzc).longValue() < zzogVar.zzb) {
                    zzjuVar.zzan().add(zzogVar);
                }
            }
            zzjuVar.zzav();
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, Bundle bundle, long j) throws IllegalStateException {
        if (TextUtils.isEmpty(zzjuVar.zzg().zzah())) {
            zzjuVar.zza(bundle, 0, j);
        } else {
            zzjuVar.zzj().zzw().zza("Using developer consent only; google app id found");
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, Bundle bundle) throws IllegalStateException {
        Bundle bundle2;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            bundle2 = new Bundle(zzjuVar.zzk().zzt.zza());
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzjuVar.zzs();
                    if (zzpn.zza(obj)) {
                        zzjuVar.zzs();
                        zzpn.zza(zzjuVar.zzv, 27, (String) null, (String) null, 0);
                    }
                    zzjuVar.zzj().zzw().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzpn.zzf(str)) {
                    zzjuVar.zzj().zzw().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundle2.remove(str);
                } else if (zzjuVar.zzs().zza("param", str, zzjuVar.zze().zza((String) null, false), obj)) {
                    zzjuVar.zzs().zza(bundle2, str, obj);
                }
            }
            zzjuVar.zzs();
            if (zzpn.zza(bundle2, zzjuVar.zze().zzc())) {
                zzjuVar.zzs();
                zzpn.zza(zzjuVar.zzv, 26, (String) null, (String) null, 0);
                zzjuVar.zzj().zzw().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzjuVar.zzk().zzt.zza(bundle2);
        if (!bundle.isEmpty() || zzjuVar.zze().zza(zzbn.zzcy)) {
            zzjuVar.zzq().zza(bundle2);
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, AtomicReference atomicReference, zzon zzonVar, String str, int i, Throwable th, byte[] bArr, Map map) throws IllegalStateException {
        int iZza;
        zzjuVar.zzv();
        boolean z = (i == 200 || i == 204 || i == 304) && th == null;
        if (z) {
            zzjuVar.zzj().zzq().zza("[sgtm] Upload succeeded for row_id", Long.valueOf(zzonVar.zza));
        } else {
            zzjuVar.zzj().zzr().zza("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzonVar.zza), Integer.valueOf(i), th);
        }
        zzme zzmeVarZzq = zzjuVar.zzq();
        long j = zzonVar.zza;
        if (z) {
            iZza = zzlv.SUCCESS.zza();
        } else {
            iZza = zzlv.FAILURE.zza();
        }
        zzmeVarZzq.zza(new zzae(j, iZza, zzonVar.zze));
        zzjuVar.zzj().zzq().zza("[sgtm] Updated status for row_id", Long.valueOf(zzonVar.zza), z ? "SUCCESS" : "FAILURE");
        synchronized (atomicReference) {
            atomicReference.set(Boolean.valueOf(z));
            atomicReference.notifyAll();
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, SharedPreferences sharedPreferences, String str) throws IllegalStateException {
        if ("IABTCF_TCString".equals(str)) {
            zzjuVar.zzj().zzq().zza("IABTCF_TCString change picked up in listener.");
            ((zzbb) Preconditions.checkNotNull(zzjuVar.zzt)).zza(500L);
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, String str) {
        if (zzjuVar.zzg().zzb(str)) {
            zzjuVar.zzg().zzaj();
        }
    }

    static /* synthetic */ void zzb(zzju zzjuVar, Bundle bundle) throws IllegalStateException {
        zzjuVar.zzv();
        zzjuVar.zzw();
        Preconditions.checkNotNull(bundle);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzjuVar.zzu.zzae()) {
            zzjuVar.zzj().zzq().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzjuVar.zzq().zza(new zzag(bundle.getString("app_id"), "", new zzpm(strCheckNotEmpty, 0L, null, ""), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean("active"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zzc(zzju zzjuVar, Bundle bundle) throws IllegalStateException {
        zzjuVar.zzv();
        zzjuVar.zzw();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzjuVar.zzu.zzae()) {
            zzjuVar.zzj().zzq().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpm zzpmVar = new zzpm(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string2);
        try {
            zzbl zzblVarZza = zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0L, true, true);
            zzjuVar.zzq().zza(new zzag(bundle.getString("app_id"), string2, zzpmVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0L, true, true), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzblVarZza, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zza(zzju zzjuVar, zzjj zzjjVar, long j, boolean z, boolean z2) throws IllegalStateException {
        zzjuVar.zzv();
        zzjuVar.zzw();
        zzjj zzjjVarZzp = zzjuVar.zzk().zzp();
        if (j <= zzjuVar.zzp && zzjj.zza(zzjjVarZzp.zza(), zzjjVar.zza())) {
            zzjuVar.zzj().zzp().zza("Dropped out-of-date consent setting, proposed settings", zzjjVar);
            return;
        }
        if (zzjuVar.zzk().zza(zzjjVar)) {
            zzjuVar.zzj().zzq().zza("Setting storage consent(FE)", zzjjVar);
            zzjuVar.zzp = j;
            if (zzjuVar.zzq().zzao()) {
                zzjuVar.zzq().zzb(z);
            } else {
                zzjuVar.zzq().zza(z);
            }
            if (z2) {
                zzjuVar.zzq().zza(new AtomicReference<>());
                return;
            }
            return;
        }
        zzjuVar.zzj().zzp().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjjVar.zza()));
    }

    static /* synthetic */ void zzb(zzju zzjuVar, int i) {
        if (zzjuVar.zzj == null) {
            zzjuVar.zzj = new zzkn(zzjuVar, zzjuVar.zzu);
        }
        zzjuVar.zzj.zza(i * 1000);
    }

    protected zzju(zzic zzicVar) {
        super(zzicVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzi = 1;
        this.zzq = true;
        this.zzv = new zzld(this);
        this.zzf = new AtomicReference<>();
        this.zzn = zzjj.zza;
        this.zzp = -1L;
        this.zzo = new AtomicLong(0L);
        this.zza = new zzu(zzicVar);
    }

    public final void zzao() {
        zzv();
        zzw();
        zzme zzmeVarZzq = zzq();
        zzmeVarZzq.zzv();
        zzmeVarZzq.zzw();
        if (zzmeVarZzq.zzap() && zzmeVarZzq.zzs().zzg() < 242600) {
            return;
        }
        zzq().zzae();
    }

    public final void zzap() {
        zzv();
        zzw();
        if (this.zzu.zzah()) {
            Boolean boolZze = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (boolZze != null && boolZze.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzke
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        this.zza.zzat();
                    }
                });
            }
            zzq().zzaf();
            this.zzq = false;
            String strZzx = zzk().zzx();
            if (TextUtils.isEmpty(strZzx)) {
                return;
            }
            zzf().zzad();
            if (strZzx.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzx);
            zzc("auto", "_ou", bundle);
        }
    }

    final void zzaq() {
        zzv();
        zzbb zzbbVar = this.zzk;
        if (zzbbVar != null) {
            zzbbVar.zza();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzkz(this, bundle2));
    }

    public final void zzar() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zzb == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzb);
    }

    final void zzas() throws IllegalStateException {
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zza(zzbn.zzcq)) {
            if (zzl().zzm()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzaf.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzw();
            zzj().zzq().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjy
                @Override // java.lang.Runnable
                public final void run() {
                    zzju.zza(this.zza, atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkb
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        zzju.zza(this.zza, list);
                    }
                });
            }
        }
    }

    public final void zzat() throws IllegalStateException {
        zzv();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jZza = zzk().zzp.zza();
        zzk().zzp.zza(1 + jZza);
        if (jZza >= 5) {
            zzj().zzr().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (this.zzr == null) {
                this.zzr = new zzku(this, this.zzu);
            }
            this.zzr.zza(0L);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zzl().zzb(new zzla(this, zzdqVar));
    }

    public final void zzau() {
        zzv();
        zzj().zzc().zza("Handle tcf update.");
        zzoe zzoeVarZza = zzoe.zza(zzk().zzc());
        zzj().zzq().zza("Tcf preferences read", zzoeVarZza);
        if (zzk().zza(zzoeVarZza)) {
            Bundle bundleZza = zzoeVarZza.zza();
            zzj().zzq().zza("Consent generated from Tcf", bundleZza);
            if (bundleZza != Bundle.EMPTY) {
                zza(bundleZza, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zzoeVarZza.zzb());
            zzc("auto", "_tcf", bundle);
        }
    }

    public final void zzb(String str, String str2, Bundle bundle) throws IllegalStateException {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException {
        String str3 = str == null ? App.TYPE : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzp().zza(bundle2, j);
        } else {
            zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zzpn.zzf(str2), z, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) throws IllegalStateException {
        zzu();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) throws IllegalStateException {
        zza(str, str2, bundle, true, false, j);
    }

    final void zzc(String str, String str2, Bundle bundle) {
        zzv();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    final void zza(String str, String str2, long j, Bundle bundle) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzv();
        zza(str, str2, j, bundle, true, this.zzc == null || zzpn.zzf(str2), true, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zza(java.lang.String r22, java.lang.String r23, long r24, android.os.Bundle r26, boolean r27, boolean r28, boolean r29, java.lang.String r30) throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1084
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzju.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    final void zzav() throws IllegalStateException {
        zzog zzogVarPoll;
        MeasurementManagerFutures measurementManagerFuturesZzp;
        zzv();
        this.zzm = false;
        if (zzan().isEmpty() || this.zzh || (zzogVarPoll = zzan().poll()) == null || (measurementManagerFuturesZzp = zzs().zzp()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzq().zza("Registering trigger URI", zzogVarPoll.zza);
        ListenableFuture<Unit> listenableFutureRegisterTriggerAsync = measurementManagerFuturesZzp.registerTriggerAsync(Uri.parse(zzogVarPoll.zza));
        if (listenableFutureRegisterTriggerAsync == null) {
            this.zzh = false;
            zzan().add(zzogVarPoll);
        } else {
            Futures.addCallback(listenableFutureRegisterTriggerAsync, new zzkk(this, zzogVarPoll), new zzkl(this));
        }
    }

    public final void zza(zzjt zzjtVar) throws IllegalStateException {
        zzw();
        Preconditions.checkNotNull(zzjtVar);
        if (this.zzd.add(zzjtVar)) {
            return;
        }
        zzj().zzr().zza("OnEventListener already registered");
    }

    public final void zzaw() {
        zzv();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzkr(this, this.zzu);
            this.zzs = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzkh
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws IllegalStateException {
                    zzju.zza(this.zza, sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    public final void zza(long j) throws IllegalStateException {
        zzb((String) null);
        zzl().zzb(new zzkx(this, j));
    }

    final void zzb(long j) throws IllegalStateException {
        zzv();
        zzw();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zznx zznxVarZzr = zzr();
        zznxVarZzr.zzv();
        zznxVarZzr.zzb.zza();
        zzg().zzaj();
        boolean zZzae = this.zzu.zzae();
        zzha zzhaVarZzk = zzk();
        zzhaVarZzk.zzc.zza(j);
        if (!TextUtils.isEmpty(zzhaVarZzk.zzk().zzq.zza())) {
            zzhaVarZzk.zzq.zza(null);
        }
        zzhaVarZzk.zzk.zza(0L);
        zzhaVarZzk.zzl.zza(0L);
        if (!zzhaVarZzk.zze().zzy()) {
            zzhaVarZzk.zzb(!zZzae);
        }
        zzhaVarZzk.zzr.zza(null);
        zzhaVarZzk.zzs.zza(0L);
        zzhaVarZzk.zzt.zza(null);
        zzq().zzai();
        zzr().zza.zza();
        this.zzq = !zZzae;
    }

    final void zza(Runnable runnable) throws IllegalStateException {
        if (zze().zza(zzbn.zzcl)) {
            zzw();
            if (zzl().zzm()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from analytics worker thread");
                return;
            }
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from analytics network thread");
                return;
            }
            if (zzaf.zza()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzj().zzq().zza("[sgtm] Started client-side batch upload work.");
            boolean z = false;
            int size = 0;
            int i = 0;
            while (!z) {
                zzj().zzq().zza("[sgtm] Getting upload batches from service (FE)");
                final AtomicReference atomicReference = new AtomicReference();
                zzl().zza(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkd
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzq().zza((AtomicReference<zzor>) atomicReference, zzop.zza(zzlu.SGTM_CLIENT));
                    }
                });
                zzor zzorVar = (zzor) atomicReference.get();
                if (zzorVar != null && !zzorVar.zza.isEmpty()) {
                    zzj().zzq().zza("[sgtm] Retrieved upload batches. count", Integer.valueOf(zzorVar.zza.size()));
                    size += zzorVar.zza.size();
                    Iterator<zzon> it = zzorVar.zza.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!zza(it.next())) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                } else {
                    break;
                }
            }
            zzj().zzq().zza("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i));
            runnable.run();
        }
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalStateException {
        zzl().zzb(new zzkq(this, str, str2, j, zzpn.zza(bundle), z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) throws IllegalStateException {
        zzl().zzb(new zzkt(this, str, str2, obj, j));
    }

    final void zzc(long j) {
        zzv();
        if (this.zzk == null) {
            this.zzk = new zzkj(this, this.zzu);
        }
        this.zzk.zza(j);
    }

    public final void zzb(boolean z) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.zzb == null) {
                this.zzb = new zzlk(this);
            }
            if (z) {
                application.unregisterActivityLifecycleCallbacks(this.zzb);
                application.registerActivityLifecycleCallbacks(this.zzb);
                zzj().zzq().zza("Registered activity lifecycle callback");
            }
        }
    }

    final void zzb(String str) {
        this.zzf.set(str);
    }

    public final void zza(Bundle bundle) throws IllegalStateException {
        zza(bundle, zzb().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) throws IllegalStateException {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzr().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjk.zza(bundle2, "app_id", String.class, null);
        zzjk.zza(bundle2, "origin", String.class, null);
        zzjk.zza(bundle2, "name", String.class, null);
        zzjk.zza(bundle2, "value", Object.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzs().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzs().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object objZzc = zzs().zzc(string, obj);
        if (objZzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzjk.zza(bundle2, objZzc);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
        } else {
            zzl().zzb(new zzkw(this, bundle2));
        }
    }

    public final void zzb(final Bundle bundle, final long j) throws IllegalStateException {
        zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkf
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzju.zza(this.zza, bundle, j);
            }
        });
    }

    private final void zza(Bundle bundle, int i, long j) throws IllegalStateException {
        String str;
        zzw();
        String strZza = zzjj.zza(bundle);
        if (strZza != null) {
            zzj().zzw().zza("Ignoring invalid consent setting", strZza);
            zzj().zzw().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zZzm = zzl().zzm();
        zzjj zzjjVarZza = zzjj.zza(bundle, i);
        if (zzjjVarZza.zzi()) {
            zza(zzjjVarZza, zZzm);
        }
        zzbd zzbdVarZza = zzbd.zza(bundle, i);
        if (zzbdVarZza.zzg()) {
            zza(zzbdVarZza, zZzm);
        }
        Boolean boolZza = zzbd.zza(bundle);
        if (boolZza != null) {
            if (i == -30) {
                str = "tcf";
            } else {
                str = App.TYPE;
            }
            String str2 = str;
            if (zZzm) {
                zza(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, boolZza.toString(), j);
            } else {
                zza(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) boolZza.toString(), false, j);
            }
        }
    }

    public final void zzc(Bundle bundle, long j) throws IllegalStateException {
        zza(bundle, -20, j);
    }

    public final void zzc(boolean z) throws IllegalStateException {
        zzw();
        zzl().zzb(new zzkm(this, z));
    }

    public final void zzb(Bundle bundle) throws IllegalStateException {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzka
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzju.zza(this.zza, bundle2);
            }
        });
    }

    final void zza(zzbd zzbdVar, boolean z) {
        zzlg zzlgVar = new zzlg(this, zzbdVar);
        if (z) {
            zzv();
            zzlgVar.run();
        } else {
            zzl().zzb(zzlgVar);
        }
    }

    public final void zza(zzjq zzjqVar) {
        zzjq zzjqVar2;
        zzv();
        zzw();
        if (zzjqVar != null && zzjqVar != (zzjqVar2 = this.zzc)) {
            Preconditions.checkState(zzjqVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzjqVar;
    }

    public final void zza(Boolean bool) throws IllegalStateException {
        zzw();
        zzl().zzb(new zzlh(this, bool));
    }

    final void zza(zzjj zzjjVar) {
        zzv();
        boolean z = (zzjjVar.zzh() && zzjjVar.zzg()) || zzq().zzan();
        if (z != this.zzu.zzaf()) {
            this.zzu.zzb(z);
            Boolean boolZzr = zzk().zzr();
            if (!z || boolZzr == null || boolZzr.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) throws IllegalStateException {
        zzv();
        zzw();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzaf() || !(bool == null || bool.booleanValue())) {
            zzay();
        }
    }

    public final void zzd(long j) throws IllegalStateException {
        zzl().zzb(new zzko(this, j));
    }

    public final void zza(Intent intent) throws IllegalStateException {
        Uri data = intent.getData();
        if (data == null) {
            zzj().zzp().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            zzj().zzp().zza("Preview Mode was not enabled.");
            zze().zzh(null);
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        zzj().zzp().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
        zze().zzh(queryParameter2);
    }

    public final void zza(zzjj zzjjVar, boolean z) {
        boolean z2;
        zzjj zzjjVar2;
        boolean zZzc;
        boolean z3;
        zzw();
        int iZza = zzjjVar.zza();
        if (iZza != -10 && zzjjVar.zzc() == zzjm.UNINITIALIZED && zzjjVar.zzd() == zzjm.UNINITIALIZED) {
            zzj().zzw().zza("Ignoring empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            z2 = false;
            if (zzjj.zza(iZza, this.zzn.zza())) {
                zZzc = zzjjVar.zzc(this.zzn);
                if (zzjjVar.zzh() && !this.zzn.zzh()) {
                    z2 = true;
                }
                zzjj zzjjVarZzb = zzjjVar.zzb(this.zzn);
                this.zzn = zzjjVarZzb;
                zzjjVar2 = zzjjVarZzb;
                z3 = z2;
                z2 = true;
            } else {
                zzjjVar2 = zzjjVar;
                zZzc = false;
                z3 = false;
            }
        }
        if (!z2) {
            zzj().zzp().zza("Ignoring lower-priority consent settings, proposed settings", zzjjVar2);
            return;
        }
        long andIncrement = this.zzo.getAndIncrement();
        if (zZzc) {
            zzb((String) null);
            zzlj zzljVar = new zzlj(this, zzjjVar2, andIncrement, z3);
            if (z) {
                zzv();
                zzljVar.run();
                return;
            } else {
                zzl().zzc(zzljVar);
                return;
            }
        }
        zzli zzliVar = new zzli(this, zzjjVar2, andIncrement, z3);
        if (z) {
            zzv();
            zzliVar.run();
        } else if (iZza == 30 || iZza == -10) {
            zzl().zzc(zzliVar);
        } else {
            zzl().zzb(zzliVar);
        }
    }

    public final void zza(final String str, long j) throws IllegalStateException {
        if (str != null && TextUtils.isEmpty(str)) {
            this.zzu.zzj().zzr().zza("User ID must be non-empty or null");
        } else {
            zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjz
                @Override // java.lang.Runnable
                public final void run() {
                    zzju.zza(this.zza, str);
                }
            });
            zza((String) null, Columns.ID, (Object) str, true, j);
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r7, java.lang.String r8, java.lang.Object r9, boolean r10, long r11) throws java.lang.IllegalStateException {
        /*
            r6 = this;
            if (r7 != 0) goto L4
            java.lang.String r7 = "app"
        L4:
            r1 = r7
            r7 = 0
            r0 = 24
            if (r10 == 0) goto L13
            com.google.android.gms.measurement.internal.zzpn r10 = r6.zzs()
            int r10 = r10.zzb(r8)
            goto L35
        L13:
            com.google.android.gms.measurement.internal.zzpn r10 = r6.zzs()
            java.lang.String r2 = "user property"
            boolean r3 = r10.zzc(r2, r8)
            r4 = 6
            if (r3 != 0) goto L22
        L20:
            r10 = r4
            goto L35
        L22:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzjr.zza
            boolean r3 = r10.zza(r2, r3, r8)
            if (r3 != 0) goto L2d
            r10 = 15
            goto L35
        L2d:
            boolean r10 = r10.zza(r2, r0, r8)
            if (r10 != 0) goto L34
            goto L20
        L34:
            r10 = r7
        L35:
            java.lang.String r2 = "_ev"
            r3 = 1
            if (r10 == 0) goto L52
            r6.zzs()
            java.lang.String r9 = com.google.android.gms.measurement.internal.zzpn.zza(r8, r0, r3)
            if (r8 == 0) goto L47
            int r7 = r8.length()
        L47:
            com.google.android.gms.measurement.internal.zzic r8 = r6.zzu
            r8.zzv()
            com.google.android.gms.measurement.internal.zzpp r8 = r6.zzv
            com.google.android.gms.measurement.internal.zzpn.zza(r8, r10, r2, r9, r7)
            return
        L52:
            if (r9 == 0) goto L91
            com.google.android.gms.measurement.internal.zzpn r10 = r6.zzs()
            int r10 = r10.zza(r8, r9)
            if (r10 == 0) goto L80
            r6.zzs()
            java.lang.String r8 = com.google.android.gms.measurement.internal.zzpn.zza(r8, r0, r3)
            boolean r11 = r9 instanceof java.lang.String
            if (r11 != 0) goto L6d
            boolean r11 = r9 instanceof java.lang.CharSequence
            if (r11 == 0) goto L75
        L6d:
            java.lang.String r7 = java.lang.String.valueOf(r9)
            int r7 = r7.length()
        L75:
            com.google.android.gms.measurement.internal.zzic r9 = r6.zzu
            r9.zzv()
            com.google.android.gms.measurement.internal.zzpp r9 = r6.zzv
            com.google.android.gms.measurement.internal.zzpn.zza(r9, r10, r2, r8, r7)
            return
        L80:
            com.google.android.gms.measurement.internal.zzpn r7 = r6.zzs()
            java.lang.Object r5 = r7.zzc(r8, r9)
            if (r5 == 0) goto L90
            r0 = r6
            r2 = r8
            r3 = r11
            r0.zza(r1, r2, r3, r5)
        L90:
            return
        L91:
            r5 = 0
            r0 = r6
            r2 = r8
            r3 = r11
            r0.zza(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzju.zza(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(java.lang.String r10, java.lang.String r11, java.lang.Object r12, long r13) throws java.lang.IllegalStateException {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r9.zzv()
            r9.zzw()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L70
            boolean r0 = r12 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L53
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L53
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r12 = "false"
            boolean r11 = r12.equals(r11)
            r2 = 1
            if (r11 == 0) goto L35
            r4 = r2
            goto L37
        L35:
            r4 = 0
        L37:
            java.lang.Long r11 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzha r0 = r9.zzk()
            com.google.android.gms.measurement.internal.zzhh r0 = r0.zzh
            r4 = r11
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r11.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4e
            java.lang.String r12 = "true"
        L4e:
            r0.zza(r12)
            r12 = r11
            goto L60
        L53:
            if (r12 != 0) goto L61
            com.google.android.gms.measurement.internal.zzha r11 = r9.zzk()
            com.google.android.gms.measurement.internal.zzhh r11 = r11.zzh
            java.lang.String r0 = "unset"
            r11.zza(r0)
        L60:
            r11 = r1
        L61:
            com.google.android.gms.measurement.internal.zzgo r0 = r9.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzq()
            java.lang.String r1 = "Setting user property(FE)"
            java.lang.String r2 = "non_personalized_ads(_npa)"
            r0.zza(r1, r2, r12)
        L70:
            r4 = r11
            r7 = r12
            com.google.android.gms.measurement.internal.zzic r11 = r9.zzu
            boolean r11 = r11.zzae()
            if (r11 != 0) goto L88
            com.google.android.gms.measurement.internal.zzgo r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzgq r10 = r10.zzq()
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.zza(r11)
            return
        L88:
            com.google.android.gms.measurement.internal.zzic r11 = r9.zzu
            boolean r11 = r11.zzah()
            if (r11 != 0) goto L91
            return
        L91:
            com.google.android.gms.measurement.internal.zzpm r11 = new com.google.android.gms.measurement.internal.zzpm
            r3 = r11
            r5 = r13
            r8 = r10
            r3.<init>(r4, r5, r7, r8)
            com.google.android.gms.measurement.internal.zzme r10 = r9.zzq()
            r10.zza(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzju.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzb(zzjt zzjtVar) throws IllegalStateException {
        zzw();
        Preconditions.checkNotNull(zzjtVar);
        if (this.zzd.remove(zzjtVar)) {
            return;
        }
        zzj().zzr().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzay() throws IllegalStateException {
        zzv();
        String strZza = zzk().zzh.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                zza(App.TYPE, "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza(App.TYPE, "_npa", Long.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(strZza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (this.zzu.zzae() && this.zzq) {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzap();
            zzr().zza.zza();
            zzl().zzb(new zzkp(this));
            return;
        }
        zzj().zzc().zza("Updating Scion state (FE)");
        zzq().zzak();
    }

    final boolean zzax() {
        return this.zzm;
    }

    private final boolean zza(final zzon zzonVar) throws IllegalStateException, MalformedURLException {
        try {
            URL url = new URI(zzonVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String strZzag = zzg().zzag();
            zzj().zzq().zza("[sgtm] Uploading data from app. row_id, url, uncompressed size", Long.valueOf(zzonVar.zza), zzonVar.zzc, Integer.valueOf(zzonVar.zzb.length));
            if (!TextUtils.isEmpty(zzonVar.zzf)) {
                zzj().zzq().zza("[sgtm] Uploading data from app. row_id", Long.valueOf(zzonVar.zza), zzonVar.zzf);
            }
            HashMap map = new HashMap();
            for (String str : zzonVar.zzd.keySet()) {
                String string = zzonVar.zzd.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    map.put(str, string);
                }
            }
            zzlp zzlpVarZzn = zzn();
            byte[] bArr = zzonVar.zzb;
            zzlo zzloVar = new zzlo() { // from class: com.google.android.gms.measurement.internal.zzkc
                @Override // com.google.android.gms.measurement.internal.zzlo
                public final void zza(String str2, int i, Throwable th, byte[] bArr2, Map map2) throws IllegalStateException {
                    zzju.zza(this.zza, atomicReference, zzonVar, str2, i, th, bArr2, map2);
                }
            };
            zzlpVarZzn.zzad();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzloVar);
            zzlpVarZzn.zzl().zza(new zzlr(zzlpVarZzn, strZzag, url, bArr, map, zzloVar));
            try {
                zzpn zzpnVarZzs = zzs();
                long jCurrentTimeMillis = zzpnVarZzs.zzb().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long jCurrentTimeMillis2 = 60000; atomicReference.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = jCurrentTimeMillis - zzpnVarZzs.zzb().currentTimeMillis()) {
                        atomicReference.wait(jCurrentTimeMillis2);
                    }
                }
            } catch (InterruptedException unused) {
                zzj().zzr().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == Boolean.TRUE;
        } catch (MalformedURLException | URISyntaxException e) {
            zzj().zzg().zza("[sgtm] Bad upload url for row_id", zzonVar.zzc, Long.valueOf(zzonVar.zza), e);
            return false;
        }
    }
}
