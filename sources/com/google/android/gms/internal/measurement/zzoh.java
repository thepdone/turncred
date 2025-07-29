package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoh implements Supplier<zzok> {
    private static zzoh zza = new zzoh();
    private final Supplier<zzok> zzb = Suppliers.ofInstance(new zzoj());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzok get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzok) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzok) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzok) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzok) zza.get()).zzd();
    }
}
