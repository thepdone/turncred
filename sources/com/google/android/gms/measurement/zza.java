package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzjt;
import com.google.android.gms.measurement.internal.zzlm;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zza extends AppMeasurement.zza {
    private final zzlm zza;

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final int zza(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final long zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Boolean zza() {
        return (Boolean) this.zza.zza(4);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Double zzb() {
        return (Double) this.zza.zza(2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Integer zzc() {
        return (Integer) this.zza.zza(3);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Long zzd() {
        return (Long) this.zza.zza(1);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final String zze() {
        return (String) this.zza.zza(0);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final List<Bundle> zza(String str, String str2) {
        return this.zza.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Map<String, Object> zza(boolean z) {
        return this.zza.zza((String) null, (String) null, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public zza(zzlm zzlmVar) {
        super();
        Preconditions.checkNotNull(zzlmVar);
        this.zza = zzlmVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str) {
        this.zza.zzb(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzc(String str) {
        this.zza.zzc(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(zzjt zzjtVar) {
        this.zza.zza(zzjtVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(zzjq zzjqVar) {
        this.zza.zza(zzjqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(zzjt zzjtVar) {
        this.zza.zzb(zzjtVar);
    }
}
