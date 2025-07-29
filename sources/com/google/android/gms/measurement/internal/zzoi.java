package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzoi extends zzot {
    private final AlarmManager zza;
    private zzbb zzb;
    private Integer zzc;

    private final int zzw() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf(("measurement" + zza().getPackageName()).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzx() {
        Context contextZza = zza();
        return com.google.android.gms.internal.measurement.zzcy.zza(contextZza, 0, new Intent().setClassName(contextZza, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcy.zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzx zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzar zzh() {
        return super.zzh();
    }

    private final zzbb zzy() {
        if (this.zzb == null) {
            this.zzb = new zzol(this, this.zzg.zzk());
        }
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzhm zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zznp zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzos zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzpj h_() {
        return super.h_();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    protected zzoi(zzou zzouVar) {
        super(zzouVar);
        this.zza = (AlarmManager) zza().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    public final void zzr() {
        zzam();
        zzj().zzq().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzx());
        }
        zzy().zza();
        zzz();
    }

    private final void zzz() {
        JobScheduler jobScheduler = (JobScheduler) zza().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzw());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    public final void zza(long j) {
        zzam();
        Context contextZza = zza();
        if (!zzpn.zza(contextZza)) {
            zzj().zzc().zza("Receiver not registered/enabled");
        }
        if (!zzpn.zza(contextZza, false)) {
            zzj().zzc().zza("Service not registered/enabled");
        }
        zzr();
        zzj().zzq().zza("Scheduling upload, millis", Long.valueOf(j));
        zzb().elapsedRealtime();
        if (j < Math.max(0L, zzbn.zzag.zza(null).longValue()) && !zzy().zzc()) {
            zzy().zza(j);
        }
        Context contextZza2 = zza();
        ComponentName componentName = new ComponentName(contextZza2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iZzw = zzw();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.zzcx.zza(contextZza2, new JobInfo.Builder(iZzw, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzx());
        }
        zzz();
        return false;
    }
}
