package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzke implements zzln {
    private static final zzke zza = new zzke();

    public static zzke zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final zzlk zza(Class<?> cls) {
        if (!zzkg.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (zzlk) zzkg.zza(cls.asSubclass(zzkg.class)).zza(zzkg.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    private zzke() {
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzb(Class<?> cls) {
        return zzkg.class.isAssignableFrom(cls);
    }
}
