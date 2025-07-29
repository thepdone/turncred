package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzmw extends zzmu<zzmx, zzmx> {
    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ int zza(zzmx zzmxVar) {
        return zzmxVar.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final boolean zza(zzmf zzmfVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ int zzb(zzmx zzmxVar) {
        return zzmxVar.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ zzmx zzc(Object obj) {
        zzmx zzmxVar = ((zzkg) obj).zzb;
        if (zzmxVar != zzmx.zzc()) {
            return zzmxVar;
        }
        zzmx zzmxVarZzd = zzmx.zzd();
        zza(obj, zzmxVarZzd);
        return zzmxVarZzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ zzmx zzd(Object obj) {
        return ((zzkg) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ zzmx zza(zzmx zzmxVar, zzmx zzmxVar2) {
        zzmx zzmxVar3 = zzmxVar;
        zzmx zzmxVar4 = zzmxVar2;
        if (zzmx.zzc().equals(zzmxVar4)) {
            return zzmxVar3;
        }
        if (zzmx.zzc().equals(zzmxVar3)) {
            return zzmx.zza(zzmxVar3, zzmxVar4);
        }
        return zzmxVar3.zza(zzmxVar4);
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ zzmx zza() {
        return zzmx.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ zzmx zze(zzmx zzmxVar) {
        zzmx zzmxVar2 = zzmxVar;
        zzmxVar2.zze();
        return zzmxVar2;
    }

    zzmw() {
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zza(zzmx zzmxVar, int i, int i2) {
        zzmxVar.zza((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zza(zzmx zzmxVar, int i, long j) {
        zzmxVar.zza((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zza(zzmx zzmxVar, int i, zzmx zzmxVar2) {
        zzmxVar.zza((i << 3) | 3, zzmxVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zza(zzmx zzmxVar, int i, zziy zziyVar) {
        zzmxVar.zza((i << 3) | 2, zziyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zzb(zzmx zzmxVar, int i, long j) {
        zzmxVar.zza(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final void zzf(Object obj) {
        ((zzkg) obj).zzb.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zzb(Object obj, zzmx zzmxVar) {
        zza(obj, zzmxVar);
    }

    private static void zza(Object obj, zzmx zzmxVar) {
        ((zzkg) obj).zzb = zzmxVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zzc(Object obj, zzmx zzmxVar) {
        zza(obj, zzmxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zza(zzmx zzmxVar, zznl zznlVar) throws IOException {
        zzmxVar.zza(zznlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmu
    final /* synthetic */ void zzb(zzmx zzmxVar, zznl zznlVar) throws IOException {
        zzmxVar.zzb(zznlVar);
    }
}
