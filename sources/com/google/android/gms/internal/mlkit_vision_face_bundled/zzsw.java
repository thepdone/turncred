package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzsw implements zzsl {
    private final zznx zza;
    private zzrl zzb = new zzrl();
    private final int zzc;

    private zzsw(zznx zznxVar, int i) {
        this.zza = zznxVar;
        zztc.zza();
        this.zzc = i;
    }

    public static zzsl zzf(zznx zznxVar, int i) {
        return new zzsw(zznxVar, i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsl
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsl
    public final zzsl zzb(zznw zznwVar) {
        this.zza.zze(zznwVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsl
    public final zzsl zzc(zzrl zzrlVar) {
        this.zzb = zzrlVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsl
    public final String zzd() {
        String strZzk;
        zzrn zzrnVarZzd = this.zza.zzh().zzd();
        return (zzrnVarZzd == null || (strZzk = zzrnVarZzd.zzk()) == null || strZzk.isEmpty()) ? "NA" : (String) Preconditions.checkNotNull(zzrnVarZzd.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsl
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzg(this.zzb.zzm());
        try {
            zztc.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzlq.zza).ignoreNullValues(true).build().encode(this.zza.zzh()).getBytes("utf-8");
            }
            zznz zznzVarZzh = this.zza.zzh();
            zzcf zzcfVar = new zzcf();
            zzlq.zza.configure(zzcfVar);
            return zzcfVar.zza().zza(zznzVarZzh);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
