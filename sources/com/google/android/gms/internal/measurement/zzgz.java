package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzgz extends ContentObserver {
    private final /* synthetic */ zzgx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgz(zzgx zzgxVar, Handler handler) {
        super(null);
        this.zza = zzgxVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zza.set(true);
    }
}
