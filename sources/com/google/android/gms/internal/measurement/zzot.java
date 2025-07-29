package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzot implements Supplier<zzow> {
    private static zzot zza = new zzot();
    private final Supplier<zzow> zzb = Suppliers.ofInstance(new zzov());

    @SideEffectFree
    public static double zza() {
        return ((zzow) zza.get()).zza();
    }

    @SideEffectFree
    public static long zzb() {
        return ((zzow) zza.get()).zzb();
    }

    @SideEffectFree
    public static long zzc() {
        return ((zzow) zza.get()).zzc();
    }

    @SideEffectFree
    public static long zzd() {
        return ((zzow) zza.get()).zzd();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzow get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static String zze() {
        return ((zzow) zza.get()).zze();
    }

    @SideEffectFree
    public static boolean zzf() {
        return ((zzow) zza.get()).zzf();
    }
}
