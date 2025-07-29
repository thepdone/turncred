package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoo implements Parcelable.Creator<zzop> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzop createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<Integer> arrayListCreateIntegerList = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 1) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzop(arrayListCreateIntegerList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzop[] newArray(int i) {
        return new zzop[i];
    }
}
