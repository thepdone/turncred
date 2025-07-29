package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
abstract class zzji extends zzjf {
    private boolean zza;

    zzji(zzic zzicVar) {
        super(zzicVar);
        this.zzu.zzac();
    }

    protected void zzab() {
    }

    protected abstract boolean zzh();

    protected final void zzad() {
        if (!zzag()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzae() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzh()) {
            return;
        }
        this.zzu.zzab();
        this.zza = true;
    }

    public final void zzaf() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzab();
        this.zzu.zzab();
        this.zza = true;
    }

    final boolean zzag() {
        return this.zza;
    }
}
