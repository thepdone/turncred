package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzya implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzyb zzb;

    zzya(zzyb zzybVar) {
        this.zzb = zzybVar;
        this.zza = zzybVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
