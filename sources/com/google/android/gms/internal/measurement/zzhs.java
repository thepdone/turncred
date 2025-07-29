package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhs extends ContentObserver {
    zzhs(zzhq zzhqVar, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzhx.zzc();
    }
}
