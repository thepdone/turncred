package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zznp implements Supplier<zzns> {
    private static zznp zza = new zznp();
    private final Supplier<zzns> zzb = Suppliers.ofInstance(new zznr());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzns get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzns) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzns) zza.get()).zzb();
    }
}
