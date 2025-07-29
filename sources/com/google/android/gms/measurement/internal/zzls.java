package com.google.android.gms.measurement.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzgf;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzls extends zzf {
    private JobScheduler zza;

    private final int zzad() {
        return ("measurement-client" + zza().getPackageName()).hashCode();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return true;
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

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
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

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
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

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    final zzgf.zzo.zza zzac() {
        zzw();
        zzv();
        if (!zze().zza(zzbn.zzcl)) {
            return zzgf.zzo.zza.CLIENT_FLAG_OFF;
        }
        if (this.zza == null) {
            return zzgf.zzo.zza.MISSING_JOB_SCHEDULER;
        }
        if (!zze().zzab()) {
            return zzgf.zzo.zza.NOT_ENABLED_IN_MANIFEST;
        }
        if (!zze().zza(zzbn.zzcn)) {
            return zzgf.zzo.zza.SDK_TOO_OLD;
        }
        if (!zzpn.zzb(zza(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return zzgf.zzo.zza.MEASUREMENT_SERVICE_NOT_ENABLED;
        }
        if (!zzq().zzap()) {
            return zzgf.zzo.zza.NON_PLAY_MODE;
        }
        return zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE;
    }

    public zzls(zzic zzicVar) {
        super(zzicVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final void zzz() {
        this.zza = (JobScheduler) zza().getSystemService("jobscheduler");
    }

    public final void zza(long j) {
        zzw();
        zzv();
        JobScheduler jobScheduler = this.zza;
        if (jobScheduler != null && jobScheduler.getPendingJob(zzad()) != null) {
            zzj().zzq().zza("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        zzgf.zzo.zza zzaVarZzac = zzac();
        if (zzaVarZzac != zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE) {
            zzj().zzq().zza("[sgtm] Not eligible for Scion upload", zzaVarZzac.name());
            return;
        }
        zzj().zzq().zza("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j));
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        zzj().zzq().zza("[sgtm] Scion upload job scheduled with result", ((JobScheduler) Preconditions.checkNotNull(this.zza)).schedule(new JobInfo.Builder(zzad(), new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build()) == 1 ? "SUCCESS" : "FAILURE");
    }
}
