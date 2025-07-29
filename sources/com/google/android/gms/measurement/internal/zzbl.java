package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzbl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbl> CREATOR = new zzbk();
    public final String zza;
    public final zzbg zzb;
    public final String zzc;
    public final long zzd;

    public final String toString() {
        return "origin=" + this.zzc + ",name=" + this.zza + ",params=" + String.valueOf(this.zzb);
    }

    zzbl(zzbl zzblVar, long j) {
        Preconditions.checkNotNull(zzblVar);
        this.zza = zzblVar.zza;
        this.zzb = zzblVar.zzb;
        this.zzc = zzblVar.zzc;
        this.zzd = j;
    }

    public zzbl(String str, zzbg zzbgVar, String str2, long j) {
        this.zza = str;
        this.zzb = zzbgVar;
        this.zzc = str2;
        this.zzd = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
