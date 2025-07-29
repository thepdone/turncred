package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzew extends zzdu {
    private final /* synthetic */ Runnable zza;

    zzew(zzet zzetVar, Runnable runnable) {
        this.zza = runnable;
    }

    @Override // com.google.android.gms.internal.measurement.zzdr
    public final void a_() {
        this.zza.run();
    }
}
