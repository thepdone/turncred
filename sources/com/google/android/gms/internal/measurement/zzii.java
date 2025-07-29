package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzii {
    private final boolean zza;

    public zzii(zzil zzilVar) {
        Preconditions.checkNotNull(zzilVar, "BuildInfo must be non-null");
        this.zza = !zzilVar.zza();
    }

    public final boolean zza(String str) {
        Preconditions.checkNotNull(str, "flagName must not be null");
        if (this.zza) {
            return zzik.zza.get().containsValue(str);
        }
        return true;
    }
}
