package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhf extends zzie {
    private final Context zza;

    @Nullable
    private final Supplier<Optional<zzhr>> zzb;

    public final int hashCode() {
        int iHashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        Supplier<Optional<zzhr>> supplier = this.zzb;
        return iHashCode ^ (supplier == null ? 0 : supplier.hashCode());
    }

    @Override // com.google.android.gms.internal.measurement.zzie
    final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzie
    @Nullable
    final Supplier<Optional<zzhr>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    zzhf(Context context, @Nullable Supplier<Optional<zzhr>> supplier) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = supplier;
    }

    public final boolean equals(Object obj) {
        Supplier<Optional<zzhr>> supplier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzie) {
            zzie zzieVar = (zzie) obj;
            if (this.zza.equals(zzieVar.zza()) && ((supplier = this.zzb) != null ? supplier.equals(zzieVar.zzb()) : zzieVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }
}
