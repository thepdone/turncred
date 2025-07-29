package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zztl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Rect rect = null;
        ArrayList arrayListCreateTypedList = null;
        ArrayList arrayListCreateTypedList2 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    rect = (Rect) SafeParcelReader.createParcelable(parcel, header, Rect.CREATOR);
                    break;
                case 3:
                    f = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 4:
                    f2 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 5:
                    f3 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 6:
                    f4 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 7:
                    f5 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    f6 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 9:
                    f7 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 10:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zztr.CREATOR);
                    break;
                case 11:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, zztg.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zztk(i, rect, f, f2, f3, f4, f5, f6, f7, arrayListCreateTypedList, arrayListCreateTypedList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zztk[i];
    }
}
