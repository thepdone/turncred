package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzia extends zzhx<Boolean> {
    @Override // com.google.android.gms.internal.measurement.zzhx
    @Nullable
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzgw.zzc.matcher(str).matches()) {
                return true;
            }
            if (zzgw.zzd.matcher(str).matches()) {
                return false;
            }
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    zzia(zzif zzifVar, String str, Boolean bool, boolean z) {
        super(zzifVar, str, bool);
    }
}
