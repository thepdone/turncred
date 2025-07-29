package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzca extends zzbu implements zzbz {
    @Override // com.google.android.gms.internal.measurement.zzbz
    public final Bundle zza(Bundle bundle) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, bundle);
        Parcel parcelZza = zza(1, parcelB_);
        Bundle bundle2 = (Bundle) zzbw.zza(parcelZza, Bundle.CREATOR);
        parcelZza.recycle();
        return bundle2;
    }

    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }
}
