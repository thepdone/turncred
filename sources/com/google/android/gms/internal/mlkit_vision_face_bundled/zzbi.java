package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbi extends zzbj {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbj zzc;

    zzbi(zzbj zzbjVar, int i, int i2) {
        this.zzc = zzbjVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzav.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbj, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    @CheckForNull
    final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbj
    /* renamed from: zzf */
    public final zzbj subList(int i, int i2) {
        zzav.zzc(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
