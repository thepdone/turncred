package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
final class zzbi extends zzde {
    final transient Map zza;
    final /* synthetic */ zzbr zzb;

    zzbi(zzbr zzbrVar, Map map) {
        this.zzb = zzbrVar;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzbr zzbrVar = this.zzb;
        if (this.zza == zzbrVar.zza) {
            zzbrVar.zzs();
        } else {
            zzcx.zza(new zzbh(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return zzdf.zzb(this.zza, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzde, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.zzb.zzw();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection collectionZza = this.zzb.zza();
        collectionZza.addAll(collection);
        this.zzb.zzb -= collection.size();
        collection.clear();
        return collectionZza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Collection get(@CheckForNull Object obj) {
        Collection collection = (Collection) zzdf.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzd(obj, collection);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzde
    protected final Set zzb() {
        return new zzbg(this);
    }
}
