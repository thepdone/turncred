package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzif {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;

    @Nullable
    final Function<Context, Boolean> zzh;
    private final boolean zzi;

    public final zzif zza() {
        return new zzif(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, true, this.zzg, this.zzh);
    }

    public final zzif zzb() {
        if (!this.zzc.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        Function<Context, Boolean> function = this.zzh;
        if (function == null) {
            return new zzif(this.zza, this.zzb, this.zzc, this.zzd, true, this.zzf, this.zzi, this.zzg, function);
        }
        throw new IllegalStateException("Cannot skip gservices both always and conditionally");
    }

    public final zzhx<Double> zza(String str, double d) {
        return zzhx.zza(this, str, Double.valueOf(-3.0d), true);
    }

    public final zzhx<Long> zza(String str, long j) {
        return zzhx.zza(this, str, Long.valueOf(j), true);
    }

    public final zzhx<String> zza(String str, String str2) {
        return zzhx.zza(this, str, str2, true);
    }

    public final zzhx<Boolean> zza(String str, boolean z) {
        return zzhx.zza(this, str, Boolean.valueOf(z), true);
    }

    public zzif(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzif(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Function<Context, Boolean> function) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = z2;
        this.zzi = z3;
        this.zzg = z4;
        this.zzh = function;
    }
}
