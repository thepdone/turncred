package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzgc extends com.google.android.gms.internal.measurement.zzbu implements zzga {
    zzgc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void zza(List<zzog> list) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeTypedList(list);
        zzc(2, parcelB_);
    }
}
