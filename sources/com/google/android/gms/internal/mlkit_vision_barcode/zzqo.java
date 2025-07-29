package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
public final class zzqo {
    private Long zza;
    private zzrb zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzqo zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzqo zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzqo zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzqo zzd(zzrb zzrbVar) {
        this.zzb = zzrbVar;
        return this;
    }

    public final zzqo zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzqq zzf() {
        return new zzqq(this, null);
    }
}
