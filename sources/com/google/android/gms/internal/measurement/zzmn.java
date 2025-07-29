package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmn<K, V> implements Comparable<zzmn>, Map.Entry<K, V> {

    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable zza;
    private V zzb;
    private final /* synthetic */ zzmj zzc;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzmn zzmnVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzmnVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zza;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.zzb;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.zzb;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzc.zzg();
        V v2 = this.zzb;
        this.zzb = v;
        return v2;
    }

    public final String toString() {
        return String.valueOf(this.zza) + "=" + String.valueOf(this.zzb);
    }

    zzmn(zzmj zzmjVar, Map.Entry<K, V> entry) {
        this(zzmjVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzmn(zzmj zzmjVar, K k, V v) {
        this.zzc = zzmjVar;
        this.zza = k;
        this.zzb = v;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    private static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
