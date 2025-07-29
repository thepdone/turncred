package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzig implements zzhl {
    private static final Map<String, zzig> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final Runnable zzc;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzd;
    private final Object zze;
    private volatile Map<String, ?> zzf;
    private final List<zzhj> zzg;

    private static SharedPreferences zza(Context context, String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!str.startsWith("direct_boot:")) {
                return zzcw.zza(context, str, 0, zzcs.zza);
            }
            if (zzhg.zza()) {
                context = context.createDeviceProtectedStorageContext();
            }
            return zzcw.zza(context, str.substring(12), 0, zzcs.zza);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static zzig zza(Context context, String str, Runnable runnable) {
        zzig zzigVar;
        if (!((!zzhg.zza() || str.startsWith("direct_boot:")) ? true : zzhg.zzb(context))) {
            return null;
        }
        synchronized (zzig.class) {
            Map<String, zzig> map = zza;
            zzigVar = map.get(str);
            if (zzigVar == null) {
                zzigVar = new zzig(zza(context, str), runnable);
                map.put(str, zzigVar);
            }
        }
        return zzigVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzhl
    public final Object zza(String str) {
        Map<String, ?> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zzf = all;
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static /* synthetic */ void zza(zzig zzigVar, SharedPreferences sharedPreferences, String str) {
        synchronized (zzigVar.zze) {
            zzigVar.zzf = null;
            zzigVar.zzc.run();
        }
        synchronized (zzigVar) {
            Iterator<zzhj> it = zzigVar.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    private zzig(SharedPreferences sharedPreferences, Runnable runnable) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.measurement.zzij
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                zzig.zza(this.zza, sharedPreferences2, str);
            }
        };
        this.zzd = onSharedPreferenceChangeListener;
        this.zze = new Object();
        this.zzg = new ArrayList();
        this.zzb = sharedPreferences;
        this.zzc = runnable;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    static synchronized void zza() {
        for (zzig zzigVar : zza.values()) {
            zzigVar.zzb.unregisterOnSharedPreferenceChangeListener(zzigVar.zzd);
        }
        zza.clear();
    }
}
