package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public enum zzlu {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);

    private final int zzh;

    public final int zza() {
        return this.zzh;
    }

    zzlu(int i) {
        this.zzh = i;
    }
}
