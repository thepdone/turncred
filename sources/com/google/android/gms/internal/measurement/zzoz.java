package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoz implements Supplier<zzpc> {
    private static zzoz zza = new zzoz();
    private final Supplier<zzpc> zzb = Suppliers.ofInstance(new zzpb());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpc get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpc) zza.get()).zza();
    }
}
