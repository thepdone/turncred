package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzce extends zzco {
    private final String zzc;
    private final boolean zzd;
    private final zzcq zze;
    private final zzcc zzf;
    private final zzcb zzg;
    private final zzcp zzh;

    public final int hashCode() {
        int iHashCode = (((((this.zzc.hashCode() ^ 1000003) * 1000003) ^ (this.zzd ? 1231 : 1237)) * 1000003) ^ this.zze.hashCode()) * 1000003;
        zzcc zzccVar = this.zzf;
        int iHashCode2 = (iHashCode ^ (zzccVar == null ? 0 : zzccVar.hashCode())) * 1000003;
        zzcb zzcbVar = this.zzg;
        return ((iHashCode2 ^ (zzcbVar != null ? zzcbVar.hashCode() : 0)) * 1000003) ^ this.zzh.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcc zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcb zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcq zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcp zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final String zze() {
        return this.zzc;
    }

    public final String toString() {
        return "FileComplianceOptions{fileOwner=" + this.zzc + ", hasDifferentDmaOwner=" + this.zzd + ", fileChecks=" + String.valueOf(this.zze) + ", dataForwardingNotAllowedResolver=" + String.valueOf(this.zzf) + ", multipleProductIdGroupsResolver=" + String.valueOf(this.zzg) + ", filePurpose=" + String.valueOf(this.zzh) + "}";
    }

    private zzce(String str, boolean z, zzcq zzcqVar, zzcc zzccVar, zzcb zzcbVar, zzcp zzcpVar) {
        this.zzc = str;
        this.zzd = z;
        this.zze = zzcqVar;
        this.zzf = null;
        this.zzg = null;
        this.zzh = zzcpVar;
    }

    public final boolean equals(Object obj) {
        zzcc zzccVar;
        zzcb zzcbVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzco) {
            zzco zzcoVar = (zzco) obj;
            if (this.zzc.equals(zzcoVar.zze()) && this.zzd == zzcoVar.zzf() && this.zze.equals(zzcoVar.zzc()) && ((zzccVar = this.zzf) != null ? zzccVar.equals(zzcoVar.zza()) : zzcoVar.zza() == null) && ((zzcbVar = this.zzg) != null ? zzcbVar.equals(zzcoVar.zzb()) : zzcoVar.zzb() == null) && this.zzh.equals(zzcoVar.zzd())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final boolean zzf() {
        return this.zzd;
    }
}
