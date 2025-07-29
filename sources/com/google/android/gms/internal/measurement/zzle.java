package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzle<K, V> {
    static <K, V> int zza(zzlh<K, V> zzlhVar, K k, V v) {
        return zzjw.zza(zzlhVar.zza, 1, k) + zzjw.zza(zzlhVar.zzc, 2, v);
    }

    static <K, V> void zza(zzjn zzjnVar, zzlh<K, V> zzlhVar, K k, V v) throws IOException {
        zzjw.zza(zzjnVar, zzlhVar.zza, 1, k);
        zzjw.zza(zzjnVar, zzlhVar.zzc, 2, v);
    }
}
