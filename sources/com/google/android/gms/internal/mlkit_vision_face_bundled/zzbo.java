package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbo extends zzbj {
    final /* synthetic */ zzbp zza;

    zzbo(zzbp zzbpVar) {
        this.zza = zzbpVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzav.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[i2]), Objects.requireNonNull(this.zza.zzb[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
