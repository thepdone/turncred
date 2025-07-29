package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.ContentResolver;
import android.database.ContentObserver;
import androidx.collection.ArrayMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzf {
    private final ContentResolver zzc;
    private final ContentObserver zzd;
    private static final Map zzb = new ArrayMap();
    public static final String[] zza = {SDKConstants.PARAM_KEY, "value"};

    static synchronized void zza() {
        Map map = zzb;
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            zzf zzfVar = (zzf) it.next();
            ContentResolver contentResolver = zzfVar.zzc;
            ContentObserver contentObserver = zzfVar.zzd;
            throw null;
        }
        map.clear();
    }
}
