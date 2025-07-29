package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoq implements Parcelable.Creator<zzor> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzor createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 1) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzon.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzor(arrayListCreateTypedList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzor[] newArray(int i) {
        return new zzor[i];
    }
}
