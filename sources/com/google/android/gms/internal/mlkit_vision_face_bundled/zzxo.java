package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzxo implements Iterator {
    final /* synthetic */ zzxs zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzxo(zzxs zzxsVar, zzxn zzxnVar) {
        this.zza = zzxsVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb + 1 >= this.zza.zzb.size()) {
            return !this.zza.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return i < this.zza.zzb.size() ? (Map.Entry) this.zza.zzb.get(this.zzb) : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        if (this.zzb >= this.zza.zzb.size()) {
            zza().remove();
            return;
        }
        zzxs zzxsVar = this.zza;
        int i = this.zzb;
        this.zzb = i - 1;
        zzxsVar.zzl(i);
    }
}
