package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzbg extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbi();
    private final Bundle zza;

    public final int zza() {
        return this.zza.size();
    }

    public final Bundle zzb() {
        return new Bundle(this.zza);
    }

    final Double zza(String str) {
        return Double.valueOf(this.zza.getDouble(str));
    }

    final Long zzb(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    final Object zzc(String str) {
        return this.zza.get(str);
    }

    final String zzd(String str) {
        return this.zza.getString(str);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbj(this);
    }

    zzbg(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
