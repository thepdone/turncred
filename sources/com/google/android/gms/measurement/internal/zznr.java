package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zznu;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zznr<T extends Context & zznu> {
    private final T zza;

    public final int zza(final Intent intent, int i, final int i2) throws IllegalStateException {
        final zzgo zzgoVarZzj = zzic.zza(this.zza, null, null).zzj();
        if (intent == null) {
            zzgoVarZzj.zzr().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzgoVarZzj.zzq().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(zzou.zza(this.zza), new Runnable() { // from class: com.google.android.gms.measurement.internal.zznt
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    zznr.zza(this.zza, i2, zzgoVarZzj, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder zza(Intent intent) throws IllegalStateException {
        if (intent == null) {
            zzc().zzg().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzig(zzou.zza(this.zza));
        }
        zzc().zzr().zza("onBind received unknown action", action);
        return null;
    }

    private final zzgo zzc() {
        return zzic.zza(this.zza, null, null).zzj();
    }

    public static /* synthetic */ void zza(zznr zznrVar, JobParameters jobParameters) {
        Log.v("FA", "AppMeasurementJobService processed last Scion upload request.");
        zznrVar.zza.zza(jobParameters, false);
    }

    public static /* synthetic */ void zza(zznr zznrVar, zzgo zzgoVar, JobParameters jobParameters) throws IllegalStateException {
        zzgoVar.zzq().zza("AppMeasurementJobService processed last upload request.");
        zznrVar.zza.zza(jobParameters, false);
    }

    public static /* synthetic */ void zza(zznr zznrVar, int i, zzgo zzgoVar, Intent intent) throws IllegalStateException {
        if (zznrVar.zza.zza(i)) {
            zzgoVar.zzq().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zznrVar.zzc().zzq().zza("Completed wakeful intent.");
            zznrVar.zza.zza(intent);
        }
    }

    public zznr(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    public final void zza() throws IllegalStateException {
        zzic.zza(this.zza, null, null).zzj().zzq().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() throws IllegalStateException {
        zzic.zza(this.zza, null, null).zzj().zzq().zza("Local AppMeasurementService is shutting down");
    }

    public final void zzb(Intent intent) throws IllegalStateException {
        if (intent == null) {
            zzc().zzg().zza("onRebind called with null intent");
        } else {
            zzc().zzq().zza("onRebind called. action", intent.getAction());
        }
    }

    private final void zza(zzou zzouVar, Runnable runnable) throws IllegalStateException {
        zzouVar.zzl().zzb(new zznv(this, zzouVar, runnable));
    }

    public final boolean zza(final JobParameters jobParameters) throws IllegalStateException {
        String string = jobParameters.getExtras().getString("action");
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            String str = (String) Preconditions.checkNotNull(string);
            zzou zzouVarZza = zzou.zza(this.zza);
            final zzgo zzgoVarZzj = zzouVarZza.zzj();
            zzgoVarZzj.zzq().zza("Local AppMeasurementJobService called. action", str);
            zza(zzouVarZza, new Runnable() { // from class: com.google.android.gms.measurement.internal.zzns
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    zznr.zza(this.zza, zzgoVarZzj, jobParameters);
                }
            });
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        com.google.android.gms.internal.measurement.zzed zzedVarZza = com.google.android.gms.internal.measurement.zzed.zza(this.zza);
        if (!zzbn.zzcn.zza(null).booleanValue()) {
            return true;
        }
        zzedVarZza.zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznq
            @Override // java.lang.Runnable
            public final void run() {
                zznr.zza(this.zza, jobParameters);
            }
        });
        return true;
    }

    public final boolean zzc(Intent intent) throws IllegalStateException {
        if (intent == null) {
            zzc().zzg().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzq().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
