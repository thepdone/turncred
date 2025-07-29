package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzgr implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzgo zzf;

    zzgr(zzgo zzgoVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        this.zzf = zzgoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzha zzhaVarZzn = this.zzf.zzu.zzn();
        if (!zzhaVarZzn.zzag()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zze().zzaa()) {
                this.zzf.zza = 'C';
            } else {
                this.zzf.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            this.zzf.zzb = 114010L;
        }
        String strSubstring = ExifInterface.GPS_MEASUREMENT_2D + "01VDIWEA?".charAt(this.zza) + this.zzf.zza + this.zzf.zzb + ":" + zzgo.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        if (strSubstring.length() > 1024) {
            strSubstring = this.zzb.substring(0, 1024);
        }
        if (zzhaVarZzn.zzb != null) {
            zzhaVarZzn.zzb.zza(strSubstring, 1L);
        }
    }
}
