package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzks<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zza;

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zza.next();
        return next.getValue() instanceof zzkq ? new zzkt(next) : next;
    }

    public zzks(Iterator<Map.Entry<K, Object>> it) {
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
