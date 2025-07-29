package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhs extends LruCache<String, com.google.android.gms.internal.measurement.zzb> {
    private final /* synthetic */ zzhm zza;

    @Override // androidx.collection.LruCache
    protected final /* synthetic */ com.google.android.gms.internal.measurement.zzb create(String str) {
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        return zzhm.zza(this.zza, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhs(zzhm zzhmVar, int i) {
        super(20);
        this.zza = zzhmVar;
    }
}
