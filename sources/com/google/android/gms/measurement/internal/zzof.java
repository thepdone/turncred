package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzof {
    final /* synthetic */ zznx zza;

    zzof(zznx zznxVar) {
        this.zza = zznxVar;
    }

    final void zza() {
        this.zza.zzv();
        if (this.zza.zzk().zza(this.zza.zzb().currentTimeMillis())) {
            this.zza.zzk().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzj().zzq().zza("Detected application was in foreground");
                zzb(this.zza.zzb().currentTimeMillis(), false);
            }
        }
    }

    final void zza(long j, boolean z) {
        this.zza.zzv();
        this.zza.zzad();
        if (this.zza.zzk().zza(j)) {
            this.zza.zzk().zzg.zza(true);
            this.zza.zzg().zzaj();
        }
        this.zza.zzk().zzk.zza(j);
        if (this.zza.zzk().zzg.zza()) {
            zzb(j, z);
        }
    }

    private final void zzb(long j, boolean z) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.zza.zzv();
        if (this.zza.zzu.zzae()) {
            this.zza.zzk().zzk.zza(j);
            this.zza.zzj().zzq().zza("Session started, time", Long.valueOf(this.zza.zzb().elapsedRealtime()));
            Long lValueOf = Long.valueOf(j / 1000);
            this.zza.zzm().zza("auto", "_sid", lValueOf, j);
            this.zza.zzk().zzl.zza(lValueOf.longValue());
            this.zza.zzk().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", lValueOf.longValue());
            this.zza.zzm().zza("auto", "_s", j, bundle);
            String strZza = this.zza.zzk().zzq.zza();
            if (TextUtils.isEmpty(strZza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strZza);
            this.zza.zzm().zza("auto", "_ssr", j, bundle2);
        }
    }
}
