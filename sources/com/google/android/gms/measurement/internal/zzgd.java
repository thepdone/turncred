package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzgd extends com.google.android.gms.internal.measurement.zzbx implements zzga {
    public zzgd() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzog.CREATOR);
        com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
        zza(arrayListCreateTypedArrayList);
        return true;
    }
}
