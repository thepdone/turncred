package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmd<E> extends zzis<E> implements RandomAccess {
    private static final Object[] zza;
    private static final zzmd<Object> zzb;
    private E[] zzc;
    private int zzd;

    private static int zzc(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* synthetic */ zzkm zza(int i) {
        if (i < this.zzd) {
            throw new IllegalArgumentException();
        }
        return new zzmd(i == 0 ? zza : Arrays.copyOf(this.zzc, i), this.zzd, true);
    }

    public static <E> zzmd<E> zzd() {
        return (zzmd<E>) zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zze(i);
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zza();
        zze(i);
        E[] eArr = this.zzc;
        E e = eArr[i];
        if (i < this.zzd - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.zzd--;
        this.modCount++;
        return e;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zza();
        zze(i);
        E[] eArr = this.zzc;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    private final String zzd(int i) {
        return "Index:" + i + ", Size:" + this.zzd;
    }

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzmd<>(objArr, 0, false);
    }

    zzmd() {
        this(zza, 0, true);
    }

    private zzmd(E[] eArr, int i, boolean z) {
        super(z);
        this.zzc = eArr;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzd(i));
        }
        E[] eArr = this.zzc;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[zzc(eArr.length)];
            System.arraycopy(this.zzc, 0, eArr2, 0, i);
            System.arraycopy(this.zzc, i, eArr2, i + 1, this.zzd - i);
            this.zzc = eArr2;
        }
        this.zzc[i] = e;
        this.zzd++;
        this.modCount++;
    }

    final void zzb(int i) {
        E[] eArr = this.zzc;
        if (i <= eArr.length) {
            return;
        }
        if (eArr.length == 0) {
            this.zzc = (E[]) new Object[Math.max(i, 10)];
            return;
        }
        int length = eArr.length;
        while (length < i) {
            length = zzc(length);
        }
        this.zzc = (E[]) Arrays.copyOf(this.zzc, length);
    }

    private final void zze(int i) {
        if (i < 0 || i >= this.zzd) {
            throw new IndexOutOfBoundsException(zzd(i));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        zza();
        int i = this.zzd;
        E[] eArr = this.zzc;
        if (i == eArr.length) {
            this.zzc = (E[]) Arrays.copyOf(this.zzc, zzc(eArr.length));
        }
        E[] eArr2 = this.zzc;
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }
}
