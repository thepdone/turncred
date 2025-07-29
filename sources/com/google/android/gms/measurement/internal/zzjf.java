package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
class zzjf implements zzjh {
    protected final zzic zzu;

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public Context zza() {
        return this.zzu.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public Clock zzb() {
        return this.zzu.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public zzaf zzd() {
        return this.zzu.zzd();
    }

    @Pure
    public zzai zze() {
        return this.zzu.zzf();
    }

    @Pure
    public zzbf zzf() {
        return this.zzu.zzg();
    }

    @Pure
    public zzgl zzi() {
        return this.zzu.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public zzgo zzj() {
        return this.zzu.zzj();
    }

    @Pure
    public zzha zzk() {
        return this.zzu.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    @Pure
    public zzhv zzl() {
        return this.zzu.zzl();
    }

    @Pure
    public zzlp zzn() {
        return this.zzu.zzq();
    }

    @Pure
    public zzpn zzs() {
        return this.zzu.zzv();
    }

    zzjf(zzic zzicVar) {
        Preconditions.checkNotNull(zzicVar);
        this.zzu = zzicVar;
    }

    public void zzt() {
        this.zzu.zzl().zzt();
    }

    public void zzu() {
        this.zzu.zzaa();
    }

    public void zzv() {
        this.zzu.zzl().zzv();
    }
}
