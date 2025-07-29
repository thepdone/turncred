package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
abstract class zzot extends zzok {
    private boolean zza;

    zzot(zzou zzouVar) {
        super(zzouVar);
        this.zzg.zzv();
    }

    protected abstract boolean zzc();

    protected final void zzam() {
        if (!zzao()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzan() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzc();
        this.zzg.zzu();
        this.zza = true;
    }

    final boolean zzao() {
        return this.zza;
    }
}
