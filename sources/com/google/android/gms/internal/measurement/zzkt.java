package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkt<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzkq> zza;

    public final zzkq zza() {
        return this.zza.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzlm)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.zza.getValue().zza((zzlm) obj);
    }

    private zzkt(Map.Entry<K, zzkq> entry) {
        this.zza = entry;
    }
}
