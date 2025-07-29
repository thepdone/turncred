package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zztr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zztr> CREATOR = new zzts();
    private final int zza;
    private final PointF zzb;

    public zztr(int i, PointF pointF) {
        this.zza = i;
        this.zzb = pointF;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
