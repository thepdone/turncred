package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzbj implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzbg zzb;

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    zzbj(zzbg zzbgVar) {
        this.zzb = zzbgVar;
        this.zza = zzbgVar.zza.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
