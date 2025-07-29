package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkz implements zzkw {
    private static <E> zzkm<E> zzc(Object obj, long j) {
        return (zzkm) zzmz.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    public final <L> List<L> zza(Object obj, long j) {
        zzkm zzkmVarZzc = zzc(obj, j);
        if (zzkmVarZzc.zzc()) {
            return zzkmVarZzc;
        }
        int size = zzkmVarZzc.size();
        zzkm zzkmVarZza = zzkmVarZzc.zza(size == 0 ? 10 : size << 1);
        zzmz.zza(obj, j, zzkmVarZza);
        return zzkmVarZza;
    }

    zzkz() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzkm zzkmVarZzc = zzc(obj, j);
        zzkm zzkmVarZzc2 = zzc(obj2, j);
        int size = zzkmVarZzc.size();
        int size2 = zzkmVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkmVarZzc.zzc()) {
                zzkmVarZzc = zzkmVarZzc.zza(size2 + size);
            }
            zzkmVarZzc.addAll(zzkmVarZzc2);
        }
        if (size > 0) {
            zzkmVarZzc2 = zzkmVarZzc;
        }
        zzmz.zza(obj, j, zzkmVarZzc2);
    }
}
