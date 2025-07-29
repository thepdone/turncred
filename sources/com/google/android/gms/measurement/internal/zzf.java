package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
abstract class zzf extends zzg {
    private boolean zza;

    zzf(zzic zzicVar) {
        super(zzicVar);
        this.zzu.zzac();
    }

    protected abstract boolean zzab();

    protected void zzz() {
    }

    protected final void zzw() {
        if (!zzaa()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzab()) {
            return;
        }
        this.zzu.zzab();
        this.zza = true;
    }

    public final void zzy() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzz();
        this.zzu.zzab();
        this.zza = true;
    }

    final boolean zzaa() {
        return this.zza;
    }
}
