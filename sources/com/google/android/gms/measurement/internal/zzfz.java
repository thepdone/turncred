package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public interface zzfz extends IInterface {
    zzap zza(zzp zzpVar) throws RemoteException;

    List<zzog> zza(zzp zzpVar, Bundle bundle) throws RemoteException;

    List<zzpm> zza(zzp zzpVar, boolean z) throws RemoteException;

    List<zzag> zza(String str, String str2, zzp zzpVar) throws RemoteException;

    List<zzag> zza(String str, String str2, String str3) throws RemoteException;

    List<zzpm> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzpm> zza(String str, String str2, boolean z, zzp zzpVar) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzp zzpVar) throws RemoteException;

    void zza(zzag zzagVar) throws RemoteException;

    void zza(zzag zzagVar, zzp zzpVar) throws RemoteException;

    void zza(zzbl zzblVar, zzp zzpVar) throws RemoteException;

    void zza(zzbl zzblVar, String str, String str2) throws RemoteException;

    void zza(zzp zzpVar, Bundle bundle, zzga zzgaVar) throws RemoteException;

    void zza(zzp zzpVar, zzae zzaeVar) throws RemoteException;

    void zza(zzp zzpVar, zzop zzopVar, zzgf zzgfVar) throws RemoteException;

    void zza(zzpm zzpmVar, zzp zzpVar) throws RemoteException;

    byte[] zza(zzbl zzblVar, String str) throws RemoteException;

    String zzb(zzp zzpVar) throws RemoteException;

    void zzc(zzp zzpVar) throws RemoteException;

    void zzd(zzp zzpVar) throws RemoteException;

    void zze(zzp zzpVar) throws RemoteException;

    void zzf(zzp zzpVar) throws RemoteException;

    void zzg(zzp zzpVar) throws RemoteException;

    void zzh(zzp zzpVar) throws RemoteException;

    void zzi(zzp zzpVar) throws RemoteException;
}
