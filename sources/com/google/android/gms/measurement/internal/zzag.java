package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzaj();
    public String zza;
    public String zzb;
    public zzpm zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public zzbl zzg;
    public long zzh;
    public zzbl zzi;
    public long zzj;
    public zzbl zzk;

    zzag(zzag zzagVar) {
        Preconditions.checkNotNull(zzagVar);
        this.zza = zzagVar.zza;
        this.zzb = zzagVar.zzb;
        this.zzc = zzagVar.zzc;
        this.zzd = zzagVar.zzd;
        this.zze = zzagVar.zze;
        this.zzf = zzagVar.zzf;
        this.zzg = zzagVar.zzg;
        this.zzh = zzagVar.zzh;
        this.zzi = zzagVar.zzi;
        this.zzj = zzagVar.zzj;
        this.zzk = zzagVar.zzk;
    }

    zzag(String str, String str2, zzpm zzpmVar, long j, boolean z, String str3, zzbl zzblVar, long j2, zzbl zzblVar2, long j3, zzbl zzblVar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpmVar;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzblVar;
        this.zzh = j2;
        this.zzi = zzblVar2;
        this.zzj = j3;
        this.zzk = zzblVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
