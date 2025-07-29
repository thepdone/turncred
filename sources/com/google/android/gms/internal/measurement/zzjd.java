package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzjd {
    private final zzjn zza;
    private final byte[] zzb;

    public final zziy zza() {
        this.zza.zzb();
        return new zzjf(this.zzb);
    }

    public final zzjn zzb() {
        return this.zza;
    }

    private zzjd(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzjn.zzb(bArr);
    }
}
