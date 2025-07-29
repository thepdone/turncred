package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ListIterator;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzxz implements ListIterator {
    final ListIterator zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzyb zzc;

    zzxz(zzyb zzybVar, int i) {
        this.zzb = i;
        this.zzc = zzybVar;
        this.zza = zzybVar.zza.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.zza.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
