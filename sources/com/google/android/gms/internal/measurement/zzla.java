package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzla implements zzmh {
    private static final zzln zza = new zzld();
    private final zzln zzb;

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final <T> zzme<T> zza(Class<T> cls) {
        zzmg.zza((Class<?>) cls);
        zzlk zzlkVarZza = this.zzb.zza(cls);
        if (zzlkVarZza.zzc()) {
            return zzls.zza(zzmg.zza(), zzjx.zza(), zzlkVarZza.zza());
        }
        return zzlq.zza(cls, zzlkVarZza, zzlw.zza(), zzky.zza(), zzmg.zza(), zzlc.zza[zzlkVarZza.zzb().ordinal()] != 1 ? zzjx.zza() : null, zzll.zza());
    }

    public zzla() {
        this(new zzlf(zzke.zza(), zza));
    }

    private zzla(zzln zzlnVar) {
        this.zzb = (zzln) zzkj.zza(zzlnVar, "messageInfoFactory");
    }
}
