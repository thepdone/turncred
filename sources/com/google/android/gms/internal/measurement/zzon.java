package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzon implements Supplier<zzoq> {
    private static zzon zza = new zzon();
    private final Supplier<zzoq> zzb = Suppliers.ofInstance(new zzop());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoq get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzoq) zza.get()).zza();
    }
}
