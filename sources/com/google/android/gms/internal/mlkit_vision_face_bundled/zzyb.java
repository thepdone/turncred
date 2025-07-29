package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzyb extends AbstractList implements RandomAccess, zzwa {
    private final zzwa zza;

    public zzyb(zzwa zzwaVar) {
        this.zza = zzwaVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzvz) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzya(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new zzxz(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwa
    public final zzwa zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwa
    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwa
    public final List zzh() {
        return this.zza.zzh();
    }
}
