package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhr implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzhm zza;

    zzhr(zzhm zzhmVar) {
        this.zza = zzhmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z, boolean z2) throws IllegalStateException {
        int i = zzht.zza[zzsVar.ordinal()];
        zzgq zzgqVarZzp = i != 1 ? i != 2 ? i != 3 ? i != 4 ? this.zza.zzj().zzp() : this.zza.zzj().zzq() : z ? this.zza.zzj().zzx() : !z2 ? this.zza.zzj().zzw() : this.zza.zzj().zzr() : z ? this.zza.zzj().zzo() : !z2 ? this.zza.zzj().zzm() : this.zza.zzj().zzg() : this.zza.zzj().zzc();
        int size = list.size();
        if (size == 1) {
            zzgqVarZzp.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgqVarZzp.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgqVarZzp.zza(str);
        } else {
            zzgqVarZzp.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
