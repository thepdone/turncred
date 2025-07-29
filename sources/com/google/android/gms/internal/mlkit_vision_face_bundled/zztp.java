package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public abstract class zztp extends zzb implements zztq {
    public zztp() {
        super("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    public static zztq asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
        return iInterfaceQueryLocalInterface instanceof zztq ? (zztq) iInterfaceQueryLocalInterface : new zzto(iBinder);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        zzti zztiVar = (zzti) zzc.zza(parcel, zzti.CREATOR);
        zzc.zzb(parcel);
        zztn zztnVarNewFaceDetector = newFaceDetector(iObjectWrapperAsInterface, zztiVar);
        parcel2.writeNoException();
        if (zztnVarNewFaceDetector == null) {
            parcel2.writeStrongBinder(null);
        } else {
            parcel2.writeStrongBinder(zztnVarNewFaceDetector.asBinder());
        }
        return true;
    }
}
