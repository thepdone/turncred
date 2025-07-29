package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzhi implements zzhl {
    private static final Map<Uri, zzhi> zza = new ArrayMap();
    private static final String[] zzb = {SDKConstants.PARAM_KEY, "value"};
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map<String, String> zzh;
    private final List<zzhj> zzi;

    public static zzhi zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhi zzhiVar;
        synchronized (zzhi.class) {
            Map<Uri, zzhi> map = zza;
            zzhiVar = map.get(uri);
            if (zzhiVar == null) {
                try {
                    zzhi zzhiVar2 = new zzhi(contentResolver, uri, runnable);
                    try {
                        map.put(uri, zzhiVar2);
                    } catch (SecurityException unused) {
                    }
                    zzhiVar = zzhiVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzhiVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzhl
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzh;
        if (mapZze == null) {
            synchronized (this.zzg) {
                mapZze = this.zzh;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzh = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Map zzd() {
        Map map;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = this.zzc.acquireUnstableContentProviderClient(this.zzd);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(this.zzd, zzb, null, null, null);
            try {
                if (cursorQuery == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    Map mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                int count = cursorQuery.getCount();
                if (count == 0) {
                    Map mapEmptyMap2 = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap2;
                }
                if (count <= 256) {
                    map = new ArrayMap(count);
                } else {
                    map = new HashMap(count, 1.0f);
                }
                while (cursorQuery.moveToNext()) {
                    map.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                if (cursorQuery.isAfterLast()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map mapEmptyMap3 = Collections.emptyMap();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return mapEmptyMap3;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RemoteException e) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
            return Collections.emptyMap();
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzho.zza(new zzhn() { // from class: com.google.android.gms.internal.measurement.zzhh
                    @Override // com.google.android.gms.internal.measurement.zzhn
                    public final Object zza() {
                        return this.zza.zzd();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException e) {
                Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                return Collections.emptyMap();
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private zzhi(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhk zzhkVar = new zzhk(this, null);
        this.zzf = zzhkVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzhkVar);
    }

    static synchronized void zzb() {
        for (zzhi zzhiVar : zza.values()) {
            zzhiVar.zzc.unregisterContentObserver(zzhiVar.zzf);
        }
        zza.clear();
    }

    public final void zzc() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            Iterator<zzhj> it = this.zzi.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }
}
