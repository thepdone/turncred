package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes3.dex */
public final class zzms {
    private static zzmr zza;

    public static synchronized zzmj zza(zzme zzmeVar) {
        if (zza == null) {
            zza = new zzmr(null);
        }
        return (zzmj) zza.get(zzmeVar);
    }

    public static synchronized zzmj zzb(String str) {
        return zza(zzme.zzd("vision-common").zzd());
    }
}
