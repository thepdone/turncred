package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbn extends zzbj {
    static final zzbj zza = new zzbn(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzbn(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzav.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbj, com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final Object[] zze() {
        return this.zzb;
    }
}
