package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzjt;
import com.google.android.gms.measurement.internal.zzju;
import com.google.android.gms.measurement.internal.zzpm;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzb extends AppMeasurement.zza {
    private final zzic zza;
    private final zzju zzb;

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final int zza(String str) {
        return zzju.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final long zzf() {
        return this.zza.zzv().zzo();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Boolean zza() {
        return this.zzb.zzae();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Double zzb() {
        return this.zzb.zzaf();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Integer zzc() {
        return this.zzb.zzag();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Long zzd() {
        return this.zzb.zzah();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final Object zza(int i) {
        if (i == 0) {
            return zze();
        }
        if (i == 1) {
            return zzd();
        }
        if (i == 2) {
            return zzb();
        }
        if (i == 3) {
            return zzc();
        }
        if (i != 4) {
            return null;
        }
        return zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzg() {
        return this.zzb.zzai();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzh() {
        return this.zzb.zzaj();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzi() {
        return this.zzb.zzak();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzj() {
        return this.zzb.zzai();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final String zze() {
        return this.zzb.zzam();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final List<Bundle> zza(String str, String str2) {
        return this.zzb.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Map<String, Object> zza(boolean z) throws IllegalStateException {
        List<zzpm> listZza = this.zzb.zza(z);
        ArrayMap arrayMap = new ArrayMap(listZza.size());
        for (zzpm zzpmVar : listZza) {
            Object objZza = zzpmVar.zza();
            if (objZza != null) {
                arrayMap.put(zzpmVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zzb.zza(str, str2, z);
    }

    public zzb(zzic zzicVar) {
        super();
        Preconditions.checkNotNull(zzicVar);
        this.zza = zzicVar;
        this.zzb = zzicVar.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str) throws IllegalStateException {
        this.zza.zze().zza(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzc(String str) throws IllegalStateException {
        this.zza.zze().zzb(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str, String str2, Bundle bundle) throws IllegalStateException {
        this.zzb.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle, long j) throws IllegalStateException {
        this.zzb.zza(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(zzjt zzjtVar) throws IllegalStateException {
        this.zzb.zza(zzjtVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(Bundle bundle) throws IllegalStateException {
        this.zzb.zza(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(zzjq zzjqVar) {
        this.zzb.zza(zzjqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(zzjt zzjtVar) throws IllegalStateException {
        this.zzb.zzb(zzjtVar);
    }
}
