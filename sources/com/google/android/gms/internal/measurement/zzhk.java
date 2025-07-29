package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhk extends ContentObserver {
    private final /* synthetic */ zzhi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhk(zzhi zzhiVar, Handler handler) {
        super(null);
        this.zza = zzhiVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}
