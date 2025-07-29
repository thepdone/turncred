package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzgq {
    private final int zza;
    private final boolean zzb;
    private final boolean zzc;
    private final /* synthetic */ zzgo zzd;

    zzgq(zzgo zzgoVar, int i, boolean z, boolean z2) {
        this.zzd = zzgoVar;
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
    }

    public final void zza(String str) throws IllegalStateException {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, null, null, null);
    }

    public final void zza(String str, Object obj) throws IllegalStateException {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) throws IllegalStateException {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, obj2, null);
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) throws IllegalStateException {
        this.zzd.zza(this.zza, this.zzb, this.zzc, str, obj, obj2, obj3);
    }
}
