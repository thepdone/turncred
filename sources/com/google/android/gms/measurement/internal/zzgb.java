package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzgb extends com.google.android.gms.internal.measurement.zzbu implements zzfz {
    @Override // com.google.android.gms.measurement.internal.zzfz
    public final zzap zza(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        Parcel parcelZza = zza(21, parcelB_);
        zzap zzapVar = (zzap) com.google.android.gms.internal.measurement.zzbw.zza(parcelZza, zzap.CREATOR);
        parcelZza.recycle();
        return zzapVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final String zzb(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        Parcel parcelZza = zza(11, parcelB_);
        String string = parcelZza.readString();
        parcelZza.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzog> zza(zzp zzpVar, Bundle bundle) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, bundle);
        Parcel parcelZza = zza(24, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzog.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(zzp zzpVar, boolean z) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, z);
        Parcel parcelZza = zza(7, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzpm.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzag> zza(String str, String str2, zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        Parcel parcelZza = zza(16, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzag.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzag> zza(String str, String str2, String str3) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeString(str3);
        Parcel parcelZza = zza(17, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzag.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(String str, String str2, boolean z, zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, z);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        Parcel parcelZza = zza(14, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzpm.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeString(str3);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, z);
        Parcel parcelZza = zza(15, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzpm.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    zzgb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzc(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(27, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzd(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(4, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzp zzpVar, zzop zzopVar, zzgf zzgfVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzopVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzgfVar);
        zzb(29, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzbl zzblVar, zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzblVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(1, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzbl zzblVar, String str, String str2) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzblVar);
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzb(5, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzp zzpVar, Bundle bundle, zzga zzgaVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, bundle);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzgaVar);
        zzb(31, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zze(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(18, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzag zzagVar, zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzagVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(12, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzag zzagVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzagVar);
        zzb(13, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzf(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(20, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeLong(j);
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeString(str3);
        zzb(10, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(Bundle bundle, zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, bundle);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(19, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzg(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(26, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzh(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(6, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzi(zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(25, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzpm zzpmVar, zzp zzpVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpmVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        zzb(2, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzp zzpVar, zzae zzaeVar) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzaeVar);
        zzb(30, parcelB_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final byte[] zza(zzbl zzblVar, String str) throws RemoteException {
        Parcel parcelB_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelB_, zzblVar);
        parcelB_.writeString(str);
        Parcel parcelZza = zza(9, parcelB_);
        byte[] bArrCreateByteArray = parcelZza.createByteArray();
        parcelZza.recycle();
        return bArrCreateByteArray;
    }
}
