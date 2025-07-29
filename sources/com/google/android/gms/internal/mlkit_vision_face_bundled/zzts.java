package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzts implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PointF pointF = null;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                pointF = (PointF) SafeParcelReader.createParcelable(parcel, header, PointF.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zztr(i, pointF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zztr[i];
    }
}
