package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbq extends zzbm {
    private final transient zzbl zza;
    private final transient zzbj zzb;

    zzbq(zzbl zzblVar, zzbj zzbjVar) {
        this.zza = zzblVar;
        this.zzb = zzbjVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbm, com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbm, com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    /* renamed from: zzd */
    public final zzbu iterator() {
        return this.zzb.listIterator(0);
    }
}
