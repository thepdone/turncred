package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhq implements zzhl {
    private static zzhq zza;

    @Nullable
    private final Context zzb;

    @Nullable
    private final ContentObserver zzc;

    static zzhq zza(Context context) {
        zzhq zzhqVar;
        synchronized (zzhq.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhq(context) : new zzhq();
            }
            zzhqVar = zza;
        }
        return zzhqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzhl
    @Nullable
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        Context context = this.zzb;
        if (context != null && !zzhg.zza(context)) {
            try {
                return (String) zzho.zza(new zzhn() { // from class: com.google.android.gms.internal.measurement.zzhp
                    @Override // com.google.android.gms.internal.measurement.zzhn
                    public final Object zza() {
                        return zzgt.zza(this.zza.zzb.getContentResolver(), str, null);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: " + str, e);
            }
        }
        return null;
    }

    private zzhq() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhq(Context context) {
        this.zzb = context;
        zzhs zzhsVar = new zzhs(this, null);
        this.zzc = zzhsVar;
        context.getContentResolver().registerContentObserver(zzgw.zza, true, zzhsVar);
    }

    static synchronized void zza() {
        Context context;
        zzhq zzhqVar = zza;
        if (zzhqVar != null && (context = zzhqVar.zzb) != null && zzhqVar.zzc != null) {
            context.getContentResolver().unregisterContentObserver(zza.zzc);
        }
        zza = null;
    }
}
