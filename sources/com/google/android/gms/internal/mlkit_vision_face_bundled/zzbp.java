package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbp extends zzbm {
    private final transient zzbl zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzbp(zzbl zzblVar, Object[] objArr, int i, int i2) {
        this.zza = zzblVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbm, com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbm, com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf
    /* renamed from: zzd */
    public final zzbu iterator() {
        return zzf().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbm
    final zzbj zzg() {
        return new zzbo(this);
    }
}
