package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpq implements Supplier<zzpp> {
    private static zzpq zza = new zzpq();
    private final Supplier<zzpp> zzb = Suppliers.ofInstance(new zzps());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpp get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpp) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzpp) zza.get()).zzb();
    }
}
