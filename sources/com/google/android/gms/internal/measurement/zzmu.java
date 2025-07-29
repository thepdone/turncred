package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
abstract class zzmu<T, B> {
    private static volatile int zza = 100;

    abstract int zza(T t);

    abstract B zza();

    abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zziy zziyVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zznl zznlVar) throws IOException;

    abstract boolean zza(zzmf zzmfVar);

    abstract int zzb(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zznl zznlVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t);

    abstract T zzd(Object obj);

    abstract T zze(B b);

    abstract void zzf(Object obj);

    zzmu() {
    }

    final boolean zza(B b, zzmf zzmfVar, int i) throws IOException {
        int iZzd = zzmfVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzb(b, i2, zzmfVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zza((zzmu<T, B>) b, i2, zzmfVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zza((zzmu<T, B>) b, i2, zzmfVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw zzkp.zzb();
            }
            if (i3 == 5) {
                zza((zzmu<T, B>) b, i2, zzmfVar.zzf());
                return true;
            }
            throw zzkp.zza();
        }
        B bZza = zza();
        int i4 = 4 | (i2 << 3);
        int i5 = i + 1;
        if (i5 >= zza) {
            throw zzkp.zzh();
        }
        while (zzmfVar.zzc() != Integer.MAX_VALUE && zza((zzmu<T, B>) bZza, zzmfVar, i5)) {
        }
        if (i4 != zzmfVar.zzd()) {
            throw zzkp.zzb();
        }
        zza((zzmu<T, B>) b, i2, (int) zze(bZza));
        return true;
    }
}
