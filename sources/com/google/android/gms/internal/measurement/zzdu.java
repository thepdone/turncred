package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzdu extends zzbx implements zzdr {
    public zzdu() {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        a_();
        return true;
    }
}
