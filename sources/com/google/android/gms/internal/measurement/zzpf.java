package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpf implements Supplier<zzpi> {
    private static zzpf zza = new zzpf();
    private final Supplier<zzpi> zzb = Suppliers.ofInstance(new zzph());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpi get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpi) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzpi) zza.get()).zzb();
    }
}
