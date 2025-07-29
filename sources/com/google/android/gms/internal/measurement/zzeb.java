package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzeb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeb> CREATOR = new zzee();
    public final int zza;
    public final String zzb;
    public final Intent zzc;

    public final int hashCode() {
        return this.zza;
    }

    public static zzeb zza(Activity activity) {
        return new zzeb(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public zzeb(int i, String str, Intent intent) {
        this.zza = i;
        this.zzb = str;
        this.zzc = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeb)) {
            return false;
        }
        zzeb zzebVar = (zzeb) obj;
        return this.zza == zzebVar.zza && Objects.equals(this.zzb, zzebVar.zzb) && Objects.equals(this.zzc, zzebVar.zzc);
    }
}
