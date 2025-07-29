package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzib extends zzhx<Long> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    @Nullable
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        Log.e("PhenotypeFlag", "Invalid long value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    zzib(zzif zzifVar, String str, Long l, boolean z) {
        super(zzifVar, str, l);
    }
}
