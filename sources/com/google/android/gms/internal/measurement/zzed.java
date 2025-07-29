package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
public class zzed {
    private static volatile zzed zzb;
    protected final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<com.google.android.gms.measurement.internal.zzjt, zzd>> zzf;
    private int zzg;
    private boolean zzh;
    private String zzi;
    private volatile zzdl zzj;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
    static class zza extends zzdv {
        private final com.google.android.gms.measurement.internal.zzjq zza;

        @Override // com.google.android.gms.internal.measurement.zzdw
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        zza(com.google.android.gms.measurement.internal.zzjq zzjqVar) {
            this.zza = zzjqVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdw
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
    class zzc implements Application.ActivityLifecycleCallbacks {
        zzc() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzed.this.zza((zzb) new zzfq(this, bundle, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzed.this.zza((zzb) new zzfv(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzed.this.zza((zzb) new zzfr(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzed.this.zza((zzb) new zzfs(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzdm zzdmVar = new zzdm();
            zzed.this.zza((zzb) new zzft(this, activity, zzdmVar));
            Bundle bundleZza = zzdmVar.zza(50L);
            if (bundleZza != null) {
                bundle.putAll(bundleZza);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzed.this.zza((zzb) new zzfp(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzed.this.zza((zzb) new zzfu(this, activity));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
    static class zzd extends zzdv {
        private final com.google.android.gms.measurement.internal.zzjt zza;

        @Override // com.google.android.gms.internal.measurement.zzdw
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        zzd(com.google.android.gms.measurement.internal.zzjt zzjtVar) {
            this.zza = zzjtVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdw
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }
    }

    public final int zza(String str) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfg(this, str, zzdmVar));
        Integer num = (Integer) zzdm.zza(zzdmVar.zza(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
    abstract class zzb implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zzb(zzed zzedVar) {
            this(true);
        }

        abstract void zza() throws RemoteException;

        protected void zzb() {
        }

        zzb(boolean z) {
            this.zza = zzed.this.zza.currentTimeMillis();
            this.zzb = zzed.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzed.this.zzh) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzed.this.zza(e, false, this.zzc);
                zzb();
            }
        }
    }

    public final long zza() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzex(this, zzdmVar));
        Long lZzb = zzdmVar.zzb(500L);
        if (lZzb == null) {
            long jNextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i = this.zzg + 1;
            this.zzg = i;
            return jNextLong + i;
        }
        return lZzb.longValue();
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfd(this, bundle, zzdmVar));
        if (z) {
            return zzdmVar.zza(5000L);
        }
        return null;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    protected final zzdl zza(Context context, boolean z) {
        try {
            return zzdo.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zza((Exception) e, true, false);
            return null;
        }
    }

    public static zzed zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzed zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzed.class) {
                if (zzb == null) {
                    zzb = new zzed(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    public final Long zzc() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfi(this, zzdmVar));
        return zzdmVar.zzb(120000L);
    }

    public final Object zza(int i) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfh(this, zzdmVar, i));
        return zzdm.zza(zzdmVar.zza(15000L), Object.class);
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzff(this, zzdmVar));
        return zzdmVar.zzc(120000L);
    }

    public final String zzf() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzey(this, zzdmVar));
        return zzdmVar.zzc(50L);
    }

    public final String zzg() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzez(this, zzdmVar));
        return zzdmVar.zzc(500L);
    }

    public final String zzh() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfa(this, zzdmVar));
        return zzdmVar.zzc(500L);
    }

    public final String zzi() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzev(this, zzdmVar));
        return zzdmVar.zzc(500L);
    }

    public final List<Bundle> zza(String str, String str2) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzek(this, str, str2, zzdmVar));
        List<Bundle> list = (List) zzdm.zza(zzdmVar.zza(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfc(this, str, str2, z, zzdmVar));
        Bundle bundleZza = zzdmVar.zza(5000L);
        if (bundleZza == null || bundleZza.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleZza.size());
        for (String str3 : bundleZza.keySet()) {
            Object obj = bundleZza.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    private zzed(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzde.zza().zza(new zzep(this), 1);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        if (zzb(context) && !zzk()) {
            this.zzi = null;
            this.zzh = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        } else {
            this.zzi = str2;
        }
        zza((zzb) new zzeg(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    public final void zzb(String str) {
        zza((zzb) new zzer(this, str));
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza((zzb) new zzeh(this, str, str2, bundle));
    }

    public final void zzc(String str) {
        zza((zzb) new zzeu(this, str));
    }

    public final void zza(String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza((zzb) new zzfn(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza((zzb) new zzfe(this, false, 5, str, obj, null, null));
    }

    public final void zza(com.google.android.gms.measurement.internal.zzjt zzjtVar) {
        Preconditions.checkNotNull(zzjtVar);
        synchronized (this.zzf) {
            for (int i = 0; i < this.zzf.size(); i++) {
                if (zzjtVar.equals(this.zzf.get(i).first)) {
                    Log.w(this.zzc, "OnEventListener already registered.");
                    return;
                }
            }
            zzd zzdVar = new zzd(zzjtVar);
            this.zzf.add(new Pair<>(zzjtVar, zzdVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzdVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzc, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza((zzb) new zzfl(this, zzdVar));
        }
    }

    public final void zzj() {
        zza((zzb) new zzeq(this));
    }

    public final void zza(Runnable runnable) {
        zza((zzb) new zzet(this, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        this.zzd.execute(zzbVar);
    }

    public final void zza(Bundle bundle) {
        zza((zzb) new zzei(this, bundle));
    }

    public final void zzb(Bundle bundle) {
        zza((zzb) new zzeo(this, bundle));
    }

    public final void zzc(Bundle bundle) {
        zza((zzb) new zzen(this, bundle));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza((zzb) new zzem(this, zzeb.zza(activity), str, str2));
    }

    public final void zza(boolean z) {
        zza((zzb) new zzfk(this, z));
    }

    public final void zzd(Bundle bundle) {
        zza((zzb) new zzfj(this, bundle));
    }

    public final void zza(com.google.android.gms.measurement.internal.zzjq zzjqVar) {
        zza zzaVar = new zza(zzjqVar);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzaVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzc, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zza((zzb) new zzfb(this, zzaVar));
    }

    public final void zza(Boolean bool) {
        zza((zzb) new zzel(this, bool));
    }

    public final void zza(long j) {
        zza((zzb) new zzes(this, j));
    }

    public final void zza(Intent intent) {
        zza((zzb) new zzfm(this, intent));
    }

    public final void zzd(String str) {
        zza((zzb) new zzej(this, str));
    }

    public final void zzb(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza((zzb) new zzef(this, str, str2, obj, z));
    }

    public final void zzb(com.google.android.gms.measurement.internal.zzjt zzjtVar) {
        Pair<com.google.android.gms.measurement.internal.zzjt, zzd> pair;
        Preconditions.checkNotNull(zzjtVar);
        synchronized (this.zzf) {
            int i = 0;
            while (true) {
                if (i >= this.zzf.size()) {
                    pair = null;
                    break;
                } else {
                    if (zzjtVar.equals(this.zzf.get(i).first)) {
                        pair = this.zzf.get(i);
                        break;
                    }
                    i++;
                }
            }
            if (pair == null) {
                Log.w(this.zzc, "OnEventListener had not been registered.");
                return;
            }
            this.zzf.remove(pair);
            zzd zzdVar = (zzd) pair.second;
            if (this.zzj != null) {
                try {
                    this.zzj.unregisterOnMeasurementEventListener(zzdVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzc, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza((zzb) new zzfo(this, zzdVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    private final boolean zzk() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean zzb(Context context) {
        return new com.google.android.gms.measurement.internal.zzhw(context, com.google.android.gms.measurement.internal.zzhw.zza(context)).zza("google_app_id") != null;
    }
}
