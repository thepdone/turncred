package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzdy extends zzbu implements zzdw {
    @Override // com.google.android.gms.internal.measurement.zzdw
    public final int zza() throws RemoteException {
        Parcel parcelZza = zza(2, b_());
        int i = parcelZza.readInt();
        parcelZza.recycle();
        return i;
    }

    zzdy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public final void zza(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, bundle);
        parcelB_.writeLong(j);
        zzb(1, parcelB_);
    }
}
