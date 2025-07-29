package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes3.dex */
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzaz();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Point[] zze;
    private final int zzf;
    private final zzar zzg;
    private final zzau zzh;
    private final zzav zzi;
    private final zzax zzj;
    private final zzaw zzk;
    private final zzas zzl;
    private final zzao zzm;
    private final zzap zzn;
    private final zzaq zzo;

    public zzay(int i, String str, String str2, byte[] bArr, Point[] pointArr, int i2, zzar zzarVar, zzau zzauVar, zzav zzavVar, zzax zzaxVar, zzaw zzawVar, zzas zzasVar, zzao zzaoVar, zzap zzapVar, zzaq zzaqVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzarVar;
        this.zzh = zzauVar;
        this.zzi = zzavVar;
        this.zzj = zzaxVar;
        this.zzk = zzawVar;
        this.zzl = zzasVar;
        this.zzm = zzaoVar;
        this.zzn = zzapVar;
        this.zzo = zzaqVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
