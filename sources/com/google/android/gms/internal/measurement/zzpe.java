package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpe implements Supplier<zzpd> {
    private static zzpe zza = new zzpe();
    private final Supplier<zzpd> zzb = Suppliers.ofInstance(new zzpg());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpd get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpd) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzpd) zza.get()).zzb();
    }
}
