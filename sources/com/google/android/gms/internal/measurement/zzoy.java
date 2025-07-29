package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoy implements Supplier<zzox> {
    private static zzoy zza = new zzoy();
    private final Supplier<zzox> zzb = Suppliers.ofInstance(new zzpa());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzox get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzox) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzox) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzox) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzox) zza.get()).zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return ((zzox) zza.get()).zze();
    }

    @SideEffectFree
    public static boolean zzf() {
        return ((zzox) zza.get()).zzf();
    }

    @SideEffectFree
    public static boolean zzg() {
        return ((zzox) zza.get()).zzg();
    }

    @SideEffectFree
    public static boolean zzh() {
        return ((zzox) zza.get()).zzh();
    }

    @SideEffectFree
    public static boolean zzi() {
        return ((zzox) zza.get()).zzi();
    }

    @SideEffectFree
    public static boolean zzj() {
        return ((zzox) zza.get()).zzj();
    }

    @SideEffectFree
    public static boolean zzk() {
        return ((zzox) zza.get()).zzk();
    }
}
