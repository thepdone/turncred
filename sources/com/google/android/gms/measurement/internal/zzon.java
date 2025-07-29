package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzon extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzon> CREATOR = new zzom();
    public final long zza;
    public byte[] zzb;
    public final String zzc;
    public final Bundle zzd;
    public final long zze;
    public String zzf;
    private final int zzg;

    zzon(long j, byte[] bArr, String str, Bundle bundle, int i, long j2) {
        this(j, bArr, str, bundle, i, j2, "");
    }

    zzon(long j, byte[] bArr, String str, Bundle bundle, int i, long j2, String str2) {
        this.zza = j;
        this.zzb = bArr;
        this.zzc = str;
        this.zzd = bundle;
        this.zzg = i;
        this.zze = j2;
        this.zzf = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
