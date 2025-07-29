package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzhc implements zzhe {
    @Override // com.google.android.gms.internal.measurement.zzhe
    public final String zza(ContentResolver contentResolver, String str) throws zzhd {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(zzgw.zza);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                throw new zzhd("Unable to acquire ContentProviderClient");
            }
            try {
                Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(zzgw.zza, null, null, new String[]{str}, null);
                try {
                    if (cursorQuery == null) {
                        throw new zzhd("ContentProvider query returned null cursor");
                    }
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(1);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return null;
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
                throw new zzhd("ContentProvider query failed", e);
            }
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhe
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzhb<T> zzhbVar) throws zzhd {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(zzgw.zzb);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                throw new zzhd("Unable to acquire ContentProviderClient");
            }
            try {
                Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(zzgw.zzb, null, null, strArr, null);
                try {
                    if (cursorQuery == null) {
                        throw new zzhd("ContentProvider query returned null cursor");
                    }
                    T t = (T) zzhbVar.zza(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        t.put(cursorQuery.getString(0), cursorQuery.getString(1));
                    }
                    if (!cursorQuery.isAfterLast()) {
                        throw new zzhd("Cursor read incomplete (ContentProvider dead?)");
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return t;
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
                throw new zzhd("ContentProvider query failed", e);
            }
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }
}
