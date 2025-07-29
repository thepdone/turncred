package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
public final class zzao implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 2) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 3) {
                i2 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 4) {
                i3 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 5) {
                j = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                i4 = SafeParcelReader.readInt(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzan(i, i2, i3, j, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzan[i];
    }
}
