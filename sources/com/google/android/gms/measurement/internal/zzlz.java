package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.protocol.App;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzlz extends zzf {
    protected zzlw zza;
    private volatile zzlw zzb;
    private volatile zzlw zzc;
    private final Map<Integer, zzlw> zzd;
    private com.google.android.gms.internal.measurement.zzeb zze;
    private volatile boolean zzf;
    private volatile zzlw zzg;
    private zzlw zzh;
    private boolean zzi;
    private final Object zzj;

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

    private final zzlw zzd(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        Preconditions.checkNotNull(zzebVar);
        zzlw zzlwVar = this.zzd.get(Integer.valueOf(zzebVar.zza));
        if (zzlwVar == null) {
            zzlw zzlwVar2 = new zzlw(null, zza(zzebVar.zzb, "Activity"), zzs().zzo());
            this.zzd.put(Integer.valueOf(zzebVar.zza), zzlwVar2);
            zzlwVar = zzlwVar2;
        }
        return this.zzg != null ? this.zzg : zzlwVar;
    }

    public final zzlw zzac() {
        return this.zzb;
    }

    public final zzlw zza(boolean z) {
        zzw();
        zzv();
        if (!z) {
            return this.zza;
        }
        zzlw zzlwVar = this.zza;
        return zzlwVar != null ? zzlwVar : this.zzh;
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

    private final String zza(String str, String str2) {
        String str3;
        if (str == null) {
            return str2;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length > 0) {
            str3 = strArrSplit[strArrSplit.length - 1];
        } else {
            str3 = "";
        }
        return str3.length() > zze().zza((String) null, false) ? str3.substring(0, zze().zza((String) null, false)) : str3;
    }

    static /* synthetic */ void zza(zzlz zzlzVar, Bundle bundle, zzlw zzlwVar, zzlw zzlwVar2, long j) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zzlzVar.zza(zzlwVar, zzlwVar2, j, true, zzlzVar.zzs().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, false));
    }

    public zzlz(zzic zzicVar) {
        super(zzicVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zza(String str, zzlw zzlwVar, boolean z) throws IllegalStateException {
        zzlw zzlwVar2;
        zzlw zzlwVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzlwVar.zzb == null) {
            zzlwVar2 = new zzlw(zzlwVar.zza, str != null ? zza(str, "Activity") : null, zzlwVar.zzc, zzlwVar.zze, zzlwVar.zzf);
        } else {
            zzlwVar2 = zzlwVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzlwVar2;
        zzl().zzb(new zzmb(this, zzlwVar2, zzlwVar3, zzb().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzlw zzlwVar, zzlw zzlwVar2, long j, boolean z, Bundle bundle) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String str;
        zzv();
        boolean z2 = false;
        boolean z3 = (zzlwVar2 != null && zzlwVar2.zzc == zzlwVar.zzc && Objects.equals(zzlwVar2.zzb, zzlwVar.zzb) && Objects.equals(zzlwVar2.zza, zzlwVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzpn.zza(zzlwVar, bundle2, true);
            if (zzlwVar2 != null) {
                if (zzlwVar2.zza != null) {
                    bundle2.putString("_pn", zzlwVar2.zza);
                }
                if (zzlwVar2.zzb != null) {
                    bundle2.putString("_pc", zzlwVar2.zzb);
                }
                bundle2.putLong("_pi", zzlwVar2.zzc);
            }
            if (z2) {
                long jZza = zzr().zzb.zza(j);
                if (jZza > 0) {
                    zzs().zza(bundle2, jZza);
                }
            }
            if (!zze().zzx()) {
                bundle2.putLong("_mst", 1L);
            }
            if (zzlwVar.zze) {
                str = App.TYPE;
            } else {
                str = "auto";
            }
            zzm().zza(str, "_vs", (!zzlwVar.zze || zzlwVar.zzf == 0) ? zzb().currentTimeMillis() : zzlwVar.zzf, bundle2);
        }
        if (z2) {
            zza(this.zza, true, j);
        }
        this.zza = zzlwVar;
        if (zzlwVar.zze) {
            this.zzh = zzlwVar;
        }
        zzq().zza(zzlwVar);
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

    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzx() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(Integer.valueOf(zzebVar.zza), new zzlw(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        synchronized (this.zzj) {
            if (Objects.equals(this.zze, zzebVar)) {
                this.zze = null;
            }
        }
        if (zze().zzx()) {
            this.zzd.remove(Integer.valueOf(zzebVar.zza));
        }
    }

    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar) throws IllegalStateException {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzx()) {
            this.zzb = null;
            zzl().zzb(new zzmd(this, jElapsedRealtime));
        } else {
            zzlw zzlwVarZzd = zzd(zzebVar);
            this.zzc = this.zzb;
            this.zzb = null;
            zzl().zzb(new zzmc(this, zzlwVarZzd, jElapsedRealtime));
        }
    }

    public final void zzc(com.google.android.gms.internal.measurement.zzeb zzebVar) throws IllegalStateException {
        synchronized (this.zzj) {
            this.zzi = true;
            if (!Objects.equals(zzebVar, this.zze)) {
                synchronized (this.zzj) {
                    this.zze = zzebVar;
                    this.zzf = false;
                }
                if (zze().zzx()) {
                    this.zzg = null;
                    zzl().zzb(new zzmf(this));
                }
            }
        }
        if (!zze().zzx()) {
            this.zzb = this.zzg;
            zzl().zzb(new zzma(this));
            return;
        }
        zza(zzebVar.zzb, zzd(zzebVar), false);
        zza zzaVarZzc = zzc();
        zzaVarZzc.zzl().zzb(new zze(zzaVarZzc, zzaVarZzc.zzb().elapsedRealtime()));
    }

    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        zzlw zzlwVar;
        if (!zze().zzx() || bundle == null || (zzlwVar = this.zzd.get(Integer.valueOf(zzebVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzlwVar.zzc);
        bundle2.putString("name", zzlwVar.zza);
        bundle2.putString("referrer_name", zzlwVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzlw zzlwVar, boolean z, long j) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzr().zza(zzlwVar != null && zzlwVar.zzd, z, j) || zzlwVar == null) {
            return;
        }
        zzlwVar.zzd = false;
    }

    @Deprecated
    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar, String str, String str2) throws IllegalStateException {
        if (!zze().zzx()) {
            zzj().zzw().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlw zzlwVar = this.zzb;
        if (zzlwVar == null) {
            zzj().zzw().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(Integer.valueOf(zzebVar.zza)) == null) {
            zzj().zzw().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(zzebVar.zzb, "Activity");
        }
        boolean zEquals = Objects.equals(zzlwVar.zzb, str2);
        boolean zEquals2 = Objects.equals(zzlwVar.zza, str);
        if (zEquals && zEquals2) {
            zzj().zzw().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
            zzj().zzw().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().zza((String) null, false))) {
            zzj().zzw().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzq().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzlw zzlwVar2 = new zzlw(str, str2, zzs().zzo());
        this.zzd.put(Integer.valueOf(zzebVar.zza), zzlwVar2);
        zza(zzebVar.zzb, zzlwVar2, true);
    }

    public final void zza(Bundle bundle, long j) {
        String str;
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzj().zzw().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String strZza = null;
            if (bundle != null) {
                String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                if (string != null && (string.length() <= 0 || string.length() > zze().zza((String) null, false))) {
                    zzj().zzw().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > zze().zza((String) null, false))) {
                    zzj().zzw().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    strZza = string2;
                }
            } else {
                str = null;
            }
            if (strZza == null) {
                com.google.android.gms.internal.measurement.zzeb zzebVar = this.zze;
                if (zzebVar != null) {
                    strZza = zza(zzebVar.zzb, "Activity");
                } else {
                    strZza = "Activity";
                }
            }
            String str2 = strZza;
            zzlw zzlwVar = this.zzb;
            if (this.zzf && zzlwVar != null) {
                this.zzf = false;
                boolean zEquals = Objects.equals(zzlwVar.zzb, str2);
                boolean zEquals2 = Objects.equals(zzlwVar.zza, str);
                if (zEquals && zEquals2) {
                    zzj().zzw().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzj().zzq().zza("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
            zzlw zzlwVar2 = this.zzb == null ? this.zzc : this.zzb;
            zzlw zzlwVar3 = new zzlw(str, str2, zzs().zzo(), true, j);
            this.zzb = zzlwVar3;
            this.zzc = zzlwVar2;
            this.zzg = zzlwVar3;
            zzl().zzb(new zzly(this, bundle, zzlwVar3, zzlwVar2, zzb().elapsedRealtime()));
        }
    }
}
