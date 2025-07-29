package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzno implements Supplier<zznn> {
    private static zzno zza = new zzno();
    private final Supplier<zznn> zzb = Suppliers.ofInstance(new zznq());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznn get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zznn) zza.get()).zza();
    }
}
