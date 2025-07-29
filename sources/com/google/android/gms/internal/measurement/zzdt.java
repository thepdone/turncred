package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzdt extends zzbu implements zzdr {
    zzdt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzdr
    public final void a_() throws RemoteException {
        zzc(2, b_());
    }
}
