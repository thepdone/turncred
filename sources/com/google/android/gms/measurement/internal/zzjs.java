package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzjs {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    com.google.android.gms.internal.measurement.zzdz zzg;
    boolean zzh;
    Long zzi;
    String zzj;

    public zzjs(Context context, com.google.android.gms.internal.measurement.zzdz zzdzVar, Long l) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzdzVar != null) {
            this.zzg = zzdzVar;
            this.zzb = zzdzVar.zzf;
            this.zzc = zzdzVar.zze;
            this.zzd = zzdzVar.zzd;
            this.zzh = zzdzVar.zzc;
            this.zzf = zzdzVar.zzb;
            this.zzj = zzdzVar.zzh;
            if (zzdzVar.zzg != null) {
                this.zze = Boolean.valueOf(zzdzVar.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
