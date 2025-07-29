package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzos implements Supplier<zzor> {
    private static zzos zza = new zzos();
    private final Supplier<zzor> zzb = Suppliers.ofInstance(new zzou());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzor get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzor) zza.get()).zza();
    }
}
