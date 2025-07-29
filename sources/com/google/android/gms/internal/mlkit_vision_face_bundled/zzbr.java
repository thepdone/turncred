package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbr extends zzbj {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzbr(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzav.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zza[i + i + this.zzb]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
