package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzla implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zza;
    private final /* synthetic */ zzju zzb;

    zzla(zzju zzjuVar, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = zzdqVar;
        this.zzb = zzjuVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.IllegalStateException {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzju r0 = r7.zzb
            com.google.android.gms.measurement.internal.zznx r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzha r1 = r0.zzk()
            com.google.android.gms.measurement.internal.zzjj r1 = r1.zzp()
            boolean r1 = r1.zzh()
            r2 = 0
            if (r1 != 0) goto L24
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzw()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            r0.zza(r1)
        L22:
            r0 = r2
            goto L55
        L24:
            com.google.android.gms.measurement.internal.zzha r1 = r0.zzk()
            com.google.android.gms.common.util.Clock r3 = r0.zzb()
            long r3 = r3.currentTimeMillis()
            boolean r1 = r1.zza(r3)
            if (r1 != 0) goto L22
            com.google.android.gms.measurement.internal.zzha r1 = r0.zzk()
            com.google.android.gms.measurement.internal.zzhf r1 = r1.zzl
            long r3 = r1.zza()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L47
            goto L22
        L47:
            com.google.android.gms.measurement.internal.zzha r0 = r0.zzk()
            com.google.android.gms.measurement.internal.zzhf r0 = r0.zzl
            long r0 = r0.zza()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L55:
            if (r0 == 0) goto L69
            com.google.android.gms.measurement.internal.zzju r1 = r7.zzb
            com.google.android.gms.measurement.internal.zzic r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzpn r1 = r1.zzv()
            com.google.android.gms.internal.measurement.zzdq r2 = r7.zza
            long r3 = r0.longValue()
            r1.zza(r2, r3)
            return
        L69:
            com.google.android.gms.internal.measurement.zzdq r0 = r7.zza     // Catch: android.os.RemoteException -> L6f
            r0.zza(r2)     // Catch: android.os.RemoteException -> L6f
            return
        L6f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzju r1 = r7.zzb
            com.google.android.gms.measurement.internal.zzic r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzgo r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzla.run():void");
    }
}
