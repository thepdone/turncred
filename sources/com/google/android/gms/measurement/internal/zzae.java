package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzah();
    public final long zza;
    public final int zzb;
    public final long zzc;

    zzae(long j, int i, long j2) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
