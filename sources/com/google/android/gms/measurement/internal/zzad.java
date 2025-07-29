package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzad extends zzaa {
    private zzfw.zze zzg;
    private final /* synthetic */ zzx zzh;

    @Override // com.google.android.gms.measurement.internal.zzaa
    final int zza() {
        return this.zzg.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzaa
    final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzaa
    final boolean zzc() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzad(zzx zzxVar, String str, int i, zzfw.zze zzeVar) {
        super(str, i);
        this.zzh = zzxVar;
        this.zzg = zzeVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean zza(Long l, Long l2, zzgf.zzp zzpVar, boolean z) {
        byte b = com.google.android.gms.internal.measurement.zzoh.zza() && this.zzh.zze().zzf(this.zza, zzbn.zzbx);
        boolean zZzf = this.zzg.zzf();
        boolean zZzg = this.zzg.zzg();
        boolean zZzh = this.zzg.zzh();
        byte b2 = zZzf || zZzg || zZzh;
        Boolean boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        if (z && b2 == false) {
            this.zzh.zzj().zzq().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zzi() ? Integer.valueOf(this.zzg.zza()) : null);
            return true;
        }
        zzfw.zzc zzcVarZzb = this.zzg.zzb();
        boolean zZzf2 = zzcVarZzb.zzf();
        if (zzpVar.zzk()) {
            if (!zzcVarZzb.zzh()) {
                this.zzh.zzj().zzr().zza("No number filter for long property. property", this.zzh.zzi().zzc(zzpVar.zzg()));
            } else {
                boolZza = zza(zza(zzpVar.zzc(), zzcVarZzb.zzc()), zZzf2);
            }
        } else if (zzpVar.zzi()) {
            if (!zzcVarZzb.zzh()) {
                this.zzh.zzj().zzr().zza("No number filter for double property. property", this.zzh.zzi().zzc(zzpVar.zzg()));
            } else {
                boolZza = zza(zza(zzpVar.zza(), zzcVarZzb.zzc()), zZzf2);
            }
        } else if (zzpVar.zzm()) {
            if (!zzcVarZzb.zzj()) {
                if (!zzcVarZzb.zzh()) {
                    this.zzh.zzj().zzr().zza("No string or number filter defined. property", this.zzh.zzi().zzc(zzpVar.zzg()));
                } else if (zzpj.zzb(zzpVar.zzh())) {
                    boolZza = zza(zza(zzpVar.zzh(), zzcVarZzb.zzc()), zZzf2);
                } else {
                    this.zzh.zzj().zzr().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzi().zzc(zzpVar.zzg()), zzpVar.zzh());
                }
            } else {
                boolZza = zza(zza(zzpVar.zzh(), zzcVarZzb.zzd(), this.zzh.zzj()), zZzf2);
            }
        } else {
            this.zzh.zzj().zzr().zza("User property has no value, property", this.zzh.zzi().zzc(zzpVar.zzg()));
        }
        this.zzh.zzj().zzq().zza("Property filter result", boolZza == null ? "null" : boolZza);
        if (boolZza == null) {
            return false;
        }
        this.zzc = true;
        if (zZzh && !boolZza.booleanValue()) {
            return true;
        }
        if (!z || this.zzg.zzf()) {
            this.zzd = boolZza;
        }
        if (boolZza.booleanValue() && b2 != false && zzpVar.zzl()) {
            long jZzd = zzpVar.zzd();
            if (l != null) {
                jZzd = l.longValue();
            }
            if (b != false && this.zzg.zzf() && !this.zzg.zzg() && l2 != null) {
                jZzd = l2.longValue();
            }
            if (this.zzg.zzg()) {
                this.zzf = Long.valueOf(jZzd);
            } else {
                this.zze = Long.valueOf(jZzd);
            }
        }
        return true;
    }
}
