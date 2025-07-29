package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzme extends zzf {
    private final zznj zza;
    private zzfz zzb;
    private volatile Boolean zzc;
    private final zzbb zzd;
    private final zzoh zze;
    private final List<Runnable> zzf;
    private final zzbb zzg;

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
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

    private final zzp zzc(boolean z) {
        return zzg().zza(z ? zzj().zzy() : null);
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

    protected final zzap zzac() throws IllegalStateException {
        zzv();
        zzw();
        zzfz zzfzVar = this.zzb;
        if (zzfzVar == null) {
            zzag();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzp zzpVarZzc = zzc(false);
        Preconditions.checkNotNull(zzpVarZzc);
        try {
            zzap zzapVarZza = zzfzVar.zza(zzpVarZzc);
            zzar();
            return zzapVarZza;
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to get consents; remote exception", e);
            return null;
        }
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

    final Boolean zzad() {
        return this.zzc;
    }

    public static /* synthetic */ void zzc(zzme zzmeVar) throws IllegalStateException {
        zzfz zzfzVar = zzmeVar.zzb;
        if (zzfzVar == null) {
            zzmeVar.zzj().zzg().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzp zzpVarZzc = zzmeVar.zzc(false);
            Preconditions.checkNotNull(zzpVarZzc);
            zzfzVar.zzi(zzpVarZzc);
            zzmeVar.zzar();
        } catch (RemoteException e) {
            zzmeVar.zzj().zzg().zza("Failed to send storage consent settings to the service", e);
        }
    }

    public static /* synthetic */ void zza(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar, zzop zzopVar) {
        zzfz zzfzVar;
        synchronized (atomicReference) {
            try {
                zzfzVar = zzmeVar.zzb;
            } catch (RemoteException e) {
                zzmeVar.zzj().zzg().zza("[sgtm] Failed to get upload batches; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzfzVar == null) {
                zzmeVar.zzj().zzg().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzpVar);
            zzfzVar.zza(zzpVar, zzopVar, new zzmr(zzmeVar, atomicReference));
            zzmeVar.zzar();
        }
    }

    public static /* synthetic */ void zza(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar, Bundle bundle) {
        zzfz zzfzVar;
        synchronized (atomicReference) {
            try {
                zzfzVar = zzmeVar.zzb;
            } catch (RemoteException e) {
                zzmeVar.zzj().zzg().zza("Failed to request trigger URIs; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzfzVar == null) {
                zzmeVar.zzj().zzg().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzpVar);
            zzfzVar.zza(zzpVar, bundle, new zzmp(zzmeVar, atomicReference));
            zzmeVar.zzar();
        }
    }

    public static /* synthetic */ void zza(zzme zzmeVar, zzp zzpVar, zzae zzaeVar) throws IllegalStateException {
        zzfz zzfzVar = zzmeVar.zzb;
        if (zzfzVar == null) {
            zzmeVar.zzj().zzg().zza("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzfzVar.zza(zzpVar, zzaeVar);
            zzmeVar.zzar();
        } catch (RemoteException e) {
            zzmeVar.zzj().zzg().zza("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzaeVar.zza), e);
        }
    }

    public static /* synthetic */ void zzd(zzme zzmeVar) throws IllegalStateException {
        zzfz zzfzVar = zzmeVar.zzb;
        if (zzfzVar == null) {
            zzmeVar.zzj().zzg().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzp zzpVarZzc = zzmeVar.zzc(false);
            Preconditions.checkNotNull(zzpVarZzc);
            zzfzVar.zzg(zzpVarZzc);
            zzmeVar.zzar();
        } catch (RemoteException e) {
            zzmeVar.zzj().zzg().zza("Failed to send Dma consent settings to the service", e);
        }
    }

    static /* synthetic */ void zzf(zzme zzmeVar) throws IllegalStateException {
        zzmeVar.zzv();
        if (zzmeVar.zzal()) {
            zzmeVar.zzj().zzq().zza("Inactivity, disconnecting from the service");
            zzmeVar.zzah();
        }
    }

    static /* synthetic */ void zza(zzme zzmeVar, ComponentName componentName) throws IllegalStateException {
        zzmeVar.zzv();
        if (zzmeVar.zzb != null) {
            zzmeVar.zzb = null;
            zzmeVar.zzj().zzq().zza("Disconnected from device MeasurementService", componentName);
            zzmeVar.zzv();
            zzmeVar.zzag();
        }
    }

    protected zzme(zzic zzicVar) {
        super(zzicVar);
        this.zzf = new ArrayList();
        this.zze = new zzoh(zzicVar.zzb());
        this.zza = new zznj(this);
        this.zzd = new zzmk(this, zzicVar);
        this.zzg = new zzmx(this, zzicVar);
    }

    protected final void zzae() {
        zzv();
        zzw();
        zza(new zzmw(this, zzc(true)));
    }

    protected final void zzaf() throws IllegalStateException {
        zzv();
        zzw();
        zzp zzpVarZzc = zzc(true);
        zzh().zzad();
        zza(new zzmu(this, zzpVarZzc));
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

    final void zzag() {
        zzv();
        zzw();
        if (zzal()) {
            return;
        }
        if (zzap()) {
            this.zza.zza();
            return;
        }
        if (zze().zzz()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    public final void zzah() {
        zzv();
        zzw();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaq() throws IllegalStateException {
        zzv();
        zzj().zzq().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (RuntimeException e) {
                zzj().zzg().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zza();
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException {
        zzv();
        zzw();
        zza(new zzmv(this, zzc(false), zzdqVar));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzv();
        zzw();
        zza(new zzms(this, atomicReference, zzc(false)));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2) throws IllegalStateException {
        zzv();
        zzw();
        zza(new zznh(this, str, str2, zzc(false), zzdqVar));
    }

    protected final void zza(AtomicReference<List<zzag>> atomicReference, String str, String str2, String str3) throws IllegalStateException {
        zzv();
        zzw();
        zza(new zzne(this, atomicReference, str, str2, str3, zzc(false)));
    }

    protected final void zza(final AtomicReference<List<zzog>> atomicReference, final Bundle bundle) {
        zzv();
        zzw();
        final zzp zzpVarZzc = zzc(false);
        if (zze().zza(zzbn.zzdd)) {
            zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmi
                @Override // java.lang.Runnable
                public final void run() {
                    zzme.zza(this.zza, atomicReference, zzpVarZzc, bundle);
                }
            });
        } else {
            zza(new zzmo(this, atomicReference, zzpVarZzc, bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(final AtomicReference<zzor> atomicReference, final zzop zzopVar) {
        zzv();
        zzw();
        final zzp zzpVarZzc = zzc(false);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzml
            @Override // java.lang.Runnable
            public final void run() {
                zzme.zza(this.zza, atomicReference, zzpVarZzc, zzopVar);
            }
        });
    }

    protected final void zza(AtomicReference<List<zzpm>> atomicReference, boolean z) throws IllegalStateException {
        zzv();
        zzw();
        zza(new zzmm(this, atomicReference, zzc(false), z));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2, boolean z) throws IllegalStateException {
        zzv();
        zzw();
        zza(new zzmn(this, str, str2, zzc(false), z, zzdqVar));
    }

    protected final void zza(AtomicReference<List<zzpm>> atomicReference, String str, String str2, String str3, boolean z) throws IllegalStateException {
        zzv();
        zzw();
        zza(new zzng(this, atomicReference, str, str2, str3, zzc(false), z));
    }

    protected final void zza(zzbl zzblVar, String str) {
        Preconditions.checkNotNull(zzblVar);
        zzv();
        zzw();
        zza(new zznc(this, true, zzc(true), zzh().zza(zzblVar), zzblVar, str));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, zzbl zzblVar, String str) throws IllegalStateException {
        zzv();
        zzw();
        if (zzs().zza(12451000) != 0) {
            zzj().zzr().zza("Not bundling data. Service unavailable or out of date");
            zzs().zza(zzdqVar, new byte[0]);
        } else {
            zza(new zznb(this, zzblVar, str, zzdqVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzar() {
        zzv();
        this.zze.zzb();
        this.zzd.zza(zzbn.zzat.zza(null).longValue());
    }

    protected final void zzai() {
        zzv();
        zzw();
        zzp zzpVarZzc = zzc(false);
        zzh().zzac();
        zza(new zzmt(this, zzpVarZzc));
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzv();
        if (zzal()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzj().zzg().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzag();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(com.google.android.gms.measurement.internal.zzfz r37, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r38, com.google.android.gms.measurement.internal.zzp r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzme.zza(com.google.android.gms.measurement.internal.zzfz, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzp):void");
    }

    protected final void zza(zzag zzagVar) {
        Preconditions.checkNotNull(zzagVar);
        zzv();
        zzw();
        zza(new zznf(this, true, zzc(true), zzh().zza(zzagVar), new zzag(zzagVar), zzagVar));
    }

    protected final void zza(boolean z) {
        zzv();
        zzw();
        if (zzan()) {
            zza(new zznd(this, zzc(false)));
        }
    }

    protected final void zza(zzlw zzlwVar) {
        zzv();
        zzw();
        zza(new zzmz(this, zzlwVar));
    }

    public final void zza(Bundle bundle) {
        zzv();
        zzw();
        zza(new zzmy(this, zzc(false), bundle));
    }

    protected final void zzaj() throws IllegalStateException {
        zzv();
        zzw();
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmg
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzme.zzd(this.zza);
            }
        });
    }

    protected final void zzak() {
        zzv();
        zzw();
        zza(new zzna(this, zzc(true)));
    }

    protected final void zza(zzfz zzfzVar) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(zzfzVar);
        this.zzb = zzfzVar;
        zzar();
        zzaq();
    }

    protected final void zzb(boolean z) {
        zzv();
        zzw();
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmh
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzme.zzc(this.zza);
            }
        });
    }

    protected final void zza(zzpm zzpmVar) {
        zzv();
        zzw();
        zza(new zzmq(this, zzc(true), zzh().zza(zzpmVar), zzpmVar));
    }

    protected final void zza(final zzae zzaeVar) {
        zzv();
        zzw();
        final zzp zzpVarZzc = zzc(true);
        Preconditions.checkNotNull(zzpVarZzc);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmj
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzme.zza(this.zza, zzpVarZzc, zzaeVar);
            }
        });
    }

    public final boolean zzal() {
        zzv();
        zzw();
        return this.zzb != null;
    }

    final boolean zzam() {
        zzv();
        zzw();
        return !zzap() || zzs().zzg() >= 200900;
    }

    final boolean zzan() {
        zzv();
        zzw();
        return !zzap() || zzs().zzg() >= zzbn.zzcd.zza(null).intValue();
    }

    final boolean zzao() {
        zzv();
        zzw();
        return !zzap() || zzs().zzg() >= 241200;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean zzap() throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzme.zzap():boolean");
    }
}
