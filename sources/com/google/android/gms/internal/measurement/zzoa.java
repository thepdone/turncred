package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoa implements Supplier<zznz> {
    private static zzoa zza = new zzoa();
    private final Supplier<zznz> zzb = Suppliers.ofInstance(new zzoc());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznz get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zznz) zza.get()).zza();
    }
}
