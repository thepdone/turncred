package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkj extends zzbb {
    private final /* synthetic */ zzju zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkj(zzju zzjuVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzjuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() {
        final zzju zzjuVarZzm = this.zza.zzm();
        Objects.requireNonNull(zzjuVarZzm);
        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzki
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzjuVarZzm.zzas();
            }
        }).start();
    }
}
