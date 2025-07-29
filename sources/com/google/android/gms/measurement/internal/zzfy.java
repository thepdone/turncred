package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzfy extends com.google.android.gms.internal.measurement.zzbx implements zzfz {
    public zzfy() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzgf zzghVar = null;
        zzga zzgcVar = null;
        switch (i) {
            case 1:
                zzbl zzblVar = (zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR);
                zzp zzpVar = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzblVar, zzpVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzpm zzpmVar = (zzpm) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzpm.CREATOR);
                zzp zzpVar2 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpmVar, zzpVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                zzp zzpVar3 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzd(zzpVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbl zzblVar2 = (zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzblVar2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzp zzpVar4 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzh(zzpVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzp zzpVar5 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                boolean zZzc = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> listZza = zza(zzpVar5, zZzc);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza);
                return true;
            case 9:
                zzbl zzblVar3 = (zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR);
                String string3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                byte[] bArrZza = zza(zzblVar3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrZza);
                return true;
            case 10:
                long j = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(j, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzp zzpVar6 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                String strZzb = zzb(zzpVar6);
                parcel2.writeNoException();
                parcel2.writeString(strZzb);
                return true;
            case 12:
                zzag zzagVar = (zzag) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzag.CREATOR);
                zzp zzpVar7 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzagVar, zzpVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzag zzagVar2 = (zzag) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzag.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzagVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZzc2 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                zzp zzpVar8 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> listZza2 = zza(string7, string8, zZzc2, zzpVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza2);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zZzc3 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> listZza3 = zza(string9, string10, string11, zZzc3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza3);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzp zzpVar9 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzag> listZza4 = zza(string12, string13, zzpVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza4);
                return true;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzag> listZza5 = zza(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza5);
                return true;
            case 18:
                zzp zzpVar10 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zze(zzpVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                zzp zzpVar11 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(bundle, zzpVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzp zzpVar12 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzf(zzpVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzp zzpVar13 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzap zzapVarZza = zza(zzpVar13);
                parcel2.writeNoException();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel2, zzapVarZza);
                return true;
            case 24:
                zzp zzpVar14 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzog> listZza6 = zza(zzpVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZza6);
                return true;
            case 25:
                zzp zzpVar15 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzi(zzpVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                zzp zzpVar16 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzg(zzpVar16);
                parcel2.writeNoException();
                return true;
            case 27:
                zzp zzpVar17 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzc(zzpVar17);
                parcel2.writeNoException();
                return true;
            case 29:
                zzp zzpVar18 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                zzop zzopVar = (zzop) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzop.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    if (iInterfaceQueryLocalInterface instanceof zzgf) {
                        zzghVar = (zzgf) iInterfaceQueryLocalInterface;
                    } else {
                        zzghVar = new zzgh(strongBinder);
                    }
                }
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar18, zzopVar, zzghVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzp zzpVar19 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                zzae zzaeVar = (zzae) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzae.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar19, zzaeVar);
                parcel2.writeNoException();
                return true;
            case 31:
                zzp zzpVar20 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    if (iInterfaceQueryLocalInterface2 instanceof zzga) {
                        zzgcVar = (zzga) iInterfaceQueryLocalInterface2;
                    } else {
                        zzgcVar = new zzgc(strongBinder2);
                    }
                }
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar20, bundle3, zzgcVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
