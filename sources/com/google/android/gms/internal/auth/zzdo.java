package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public final class zzdo {
    public static zzdj zza(zzdj zzdjVar) {
        return ((zzdjVar instanceof zzdm) || (zzdjVar instanceof zzdk)) ? zzdjVar : zzdjVar instanceof Serializable ? new zzdk(zzdjVar) : new zzdm(zzdjVar);
    }

    public static zzdj zzb(Object obj) {
        return new zzdn(obj);
    }
}
