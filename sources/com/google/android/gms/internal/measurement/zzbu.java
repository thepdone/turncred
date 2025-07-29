package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public class zzbu implements IInterface {
    private final IBinder zza;
    private final String zzb;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel b_() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.zzb);
        return parcelObtain;
    }

    protected final Parcel zza(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.zza.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected zzbu(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    protected final void zzb(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.zza.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected final void zzc(int i, Parcel parcel) throws RemoteException {
        try {
            this.zza.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
