package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzby extends zzbx implements zzbz {
    public static zzbz zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        if (iInterfaceQueryLocalInterface instanceof zzbz) {
            return (zzbz) iInterfaceQueryLocalInterface;
        }
        return new zzca(iBinder);
    }
}
