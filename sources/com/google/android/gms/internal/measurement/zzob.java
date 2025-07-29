package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzob implements Supplier<zzoe> {
    private static zzob zza = new zzob();
    private final Supplier<zzoe> zzb = Suppliers.ofInstance(new zzod());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoe get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzoe) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzoe) zza.get()).zzb();
    }
}
