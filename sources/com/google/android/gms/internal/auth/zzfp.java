package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzfp implements zzgj {
    private static final zzfv zza = new zzfn();
    private final zzfv zzb;

    public zzfp() {
        zzfv zzfvVar;
        zzfv[] zzfvVarArr = new zzfv[2];
        zzfvVarArr[0] = zzes.zza();
        try {
            zzfvVar = (zzfv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzfvVar = zza;
        }
        zzfvVarArr[1] = zzfvVar;
        zzfo zzfoVar = new zzfo(zzfvVarArr);
        byte[] bArr = zzfa.zzd;
        this.zzb = zzfoVar;
    }

    private static boolean zzb(zzfu zzfuVar) {
        return zzfuVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.auth.zzgj
    public final zzgi zza(Class cls) {
        zzgk.zze(cls);
        zzfu zzfuVarZzb = this.zzb.zzb(cls);
        return zzfuVarZzb.zzb() ? zzev.class.isAssignableFrom(cls) ? zzgb.zzb(zzgk.zzb(), zzeo.zzb(), zzfuVarZzb.zza()) : zzgb.zzb(zzgk.zza(), zzeo.zza(), zzfuVarZzb.zza()) : zzev.class.isAssignableFrom(cls) ? zzb(zzfuVarZzb) ? zzga.zzj(cls, zzfuVarZzb, zzgd.zzb(), zzfl.zzd(), zzgk.zzb(), zzeo.zzb(), zzft.zzb()) : zzga.zzj(cls, zzfuVarZzb, zzgd.zzb(), zzfl.zzd(), zzgk.zzb(), null, zzft.zzb()) : zzb(zzfuVarZzb) ? zzga.zzj(cls, zzfuVarZzb, zzgd.zza(), zzfl.zzc(), zzgk.zza(), zzeo.zza(), zzft.zza()) : zzga.zzj(cls, zzfuVarZzb, zzgd.zza(), zzfl.zzc(), zzgk.zza(), null, zzft.zza());
    }
}
