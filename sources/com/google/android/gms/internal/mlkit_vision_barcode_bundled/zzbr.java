package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes3.dex */
public final class zzbr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbr> CREATOR = new zzbs();
    private final boolean zza;
    private final byte[] zzb;
    private final boolean zzc;
    private final float zzd;
    private final boolean zze;

    public zzbr(boolean z, byte[] bArr, boolean z2, float f, boolean z3) {
        this.zza = z;
        this.zzb = bArr;
        this.zzc = z2;
        this.zzd = f;
        this.zze = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, z);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeFloat(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
