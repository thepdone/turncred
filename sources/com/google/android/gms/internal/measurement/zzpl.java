package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpl implements Supplier<zzpo> {
    private static zzpl zza = new zzpl();
    private final Supplier<zzpo> zzb = Suppliers.ofInstance(new zzpn());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpo get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpo) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzpo) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzpo) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzpo) zza.get()).zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return ((zzpo) zza.get()).zze();
    }

    @SideEffectFree
    public static boolean zzf() {
        return ((zzpo) zza.get()).zzf();
    }

    @SideEffectFree
    public static boolean zzg() {
        return ((zzpo) zza.get()).zzg();
    }
}
