package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzog implements Supplier<zzof> {
    private static zzog zza = new zzog();
    private final Supplier<zzof> zzb = Suppliers.ofInstance(new zzoi());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzof get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzof) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzof) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzof) zza.get()).zzc();
    }
}
