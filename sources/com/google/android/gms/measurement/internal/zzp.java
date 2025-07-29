package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzr();
    public final String zza;
    public final int zzaa;
    public final long zzab;
    public final String zzac;
    public final String zzad;
    public final long zzae;
    public final int zzaf;
    private final String zzag;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;
    public final long zzf;
    public final String zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final long zzj;
    public final String zzk;
    public final long zzl;
    public final int zzm;
    public final boolean zzn;
    public final boolean zzo;
    public final String zzp;
    public final Boolean zzq;
    public final long zzr;
    public final List<String> zzs;
    public final String zzt;
    public final String zzu;
    public final String zzv;
    public final boolean zzw;
    public final long zzx;
    public final int zzy;
    public final String zzz;

    zzp(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, int i, boolean z3, boolean z4, String str7, Boolean bool, long j5, List<String> list, String str8, String str9, String str10, String str11, boolean z5, long j6, int i2, String str12, int i3, long j7, String str13, String str14, long j8, int i4) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = i;
        this.zzn = z3;
        this.zzo = z4;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j5;
        this.zzs = list;
        this.zzag = null;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z5;
        this.zzx = j6;
        this.zzy = i2;
        this.zzz = str12;
        this.zzaa = i3;
        this.zzab = j7;
        this.zzac = str13;
        this.zzad = str14;
        this.zzae = j8;
        this.zzaf = i4;
    }

    zzp(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, int i, boolean z3, boolean z4, String str7, Boolean bool, long j5, List<String> list, String str8, String str9, String str10, String str11, boolean z5, long j6, int i2, String str12, int i3, long j7, String str13, String str14, long j8, int i4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j3;
        this.zzd = str4;
        this.zze = j;
        this.zzf = j2;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = i;
        this.zzn = z3;
        this.zzo = z4;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j5;
        this.zzs = list;
        this.zzag = str8;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z5;
        this.zzx = j6;
        this.zzy = i2;
        this.zzz = str12;
        this.zzaa = i3;
        this.zzab = j7;
        this.zzac = str13;
        this.zzad = str14;
        this.zzae = j8;
        this.zzaf = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzl);
        SafeParcelWriter.writeInt(parcel, 15, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.writeString(parcel, 19, this.zzp, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzq, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzr);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzs, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzag, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzv, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.zzw);
        SafeParcelWriter.writeLong(parcel, 29, this.zzx);
        SafeParcelWriter.writeInt(parcel, 30, this.zzy);
        SafeParcelWriter.writeString(parcel, 31, this.zzz, false);
        SafeParcelWriter.writeInt(parcel, 32, this.zzaa);
        SafeParcelWriter.writeLong(parcel, 34, this.zzab);
        SafeParcelWriter.writeString(parcel, 35, this.zzac, false);
        SafeParcelWriter.writeString(parcel, 36, this.zzad, false);
        SafeParcelWriter.writeLong(parcel, 37, this.zzae);
        SafeParcelWriter.writeInt(parcel, 38, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
