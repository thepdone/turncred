package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgf;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlt extends zzot {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    public zzlt(zzou zzouVar) {
        super(zzouVar);
    }

    public final byte[] zza(zzbl zzblVar, String str) throws IllegalStateException {
        zzpo next;
        zzgf.zzk.zza zzaVar;
        Bundle bundle;
        zzh zzhVar;
        zzgf.zzj.zzb zzbVar;
        byte[] bArr;
        long j;
        zzbh zzbhVarZza;
        zzv();
        this.zzu.zzaa();
        Preconditions.checkNotNull(zzblVar);
        Preconditions.checkNotEmpty(str);
        if (!"_iap".equals(zzblVar.zza) && !"_iapx".equals(zzblVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzblVar.zza);
            return null;
        }
        zzgf.zzj.zzb zzbVarZzb = zzgf.zzj.zzb();
        zzh().zzq();
        try {
            zzh zzhVarZzd = zzh().zzd(str);
            if (zzhVarZzd == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzhVarZzd.zzar()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzgf.zzk.zza zzaVarZzp = zzgf.zzk.zzx().zzh(1).zzp("android");
            if (!TextUtils.isEmpty(zzhVarZzd.zzac())) {
                zzaVarZzp.zzb(zzhVarZzd.zzac());
            }
            if (!TextUtils.isEmpty(zzhVarZzd.zzae())) {
                zzaVarZzp.zzd((String) Preconditions.checkNotNull(zzhVarZzd.zzae()));
            }
            if (!TextUtils.isEmpty(zzhVarZzd.zzaf())) {
                zzaVarZzp.zze((String) Preconditions.checkNotNull(zzhVarZzd.zzaf()));
            }
            if (zzhVarZzd.zze() != -2147483648L) {
                zzaVarZzp.zze((int) zzhVarZzd.zze());
            }
            zzaVarZzp.zzg(zzhVarZzd.zzq()).zze(zzhVarZzd.zzo());
            String strZzah = zzhVarZzd.zzah();
            String strZzaa = zzhVarZzd.zzaa();
            if (!TextUtils.isEmpty(strZzah)) {
                zzaVarZzp.zzm(strZzah);
            } else if (!TextUtils.isEmpty(strZzaa)) {
                zzaVarZzp.zza(strZzaa);
            }
            zzaVarZzp.zzk(zzhVarZzd.zzw());
            zzjj zzjjVarZzb = this.zzg.zzb(str);
            zzaVarZzp.zzd(zzhVarZzd.zzn());
            if (this.zzu.zzae() && zze().zzj(zzaVarZzp.zzu()) && zzjjVarZzb.zzg() && !TextUtils.isEmpty(null)) {
                zzaVarZzp.zzj((String) null);
            }
            zzaVarZzp.zzg(zzjjVarZzb.zze());
            if (zzjjVarZzb.zzg() && zzhVarZzd.zzaq()) {
                Pair<String, Boolean> pairZza = zzo().zza(zzhVarZzd.zzac(), zzjjVarZzb);
                if (zzhVarZzd.zzaq() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                    zzaVarZzp.zzq(zza((String) pairZza.first, Long.toString(zzblVar.zzd)));
                    if (pairZza.second != null) {
                        zzaVarZzp.zzc(((Boolean) pairZza.second).booleanValue());
                    }
                }
            }
            zzf().zzad();
            zzgf.zzk.zza zzaVarZzi = zzaVarZzp.zzi(Build.MODEL);
            zzf().zzad();
            zzaVarZzi.zzo(Build.VERSION.RELEASE).zzj((int) zzf().zzc()).zzs(zzf().zzg());
            if (zzjjVarZzb.zzh() && zzhVarZzd.zzad() != null) {
                zzaVarZzp.zzc(zza((String) Preconditions.checkNotNull(zzhVarZzd.zzad()), Long.toString(zzblVar.zzd)));
            }
            if (!TextUtils.isEmpty(zzhVarZzd.zzag())) {
                zzaVarZzp.zzl((String) Preconditions.checkNotNull(zzhVarZzd.zzag()));
            }
            String strZzac = zzhVarZzd.zzac();
            List<zzpo> listZzk = zzh().zzk(strZzac);
            Iterator<zzpo> it = listZzk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if ("_lte".equals(next.zzc)) {
                    break;
                }
            }
            if (next == null || next.zze == null) {
                zzpo zzpoVar = new zzpo(strZzac, "auto", "_lte", zzb().currentTimeMillis(), 0L);
                listZzk.add(zzpoVar);
                zzh().zza(zzpoVar);
            }
            zzgf.zzp[] zzpVarArr = new zzgf.zzp[listZzk.size()];
            for (int i = 0; i < listZzk.size(); i++) {
                zzgf.zzp.zza zzaVarZzb = zzgf.zzp.zze().zza(listZzk.get(i).zzc).zzb(listZzk.get(i).zzd);
                h_().zza(zzaVarZzb, listZzk.get(i).zze);
                zzpVarArr[i] = (zzgf.zzp) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzb.zzaj());
            }
            zzaVarZzp.zze(Arrays.asList(zzpVarArr));
            this.zzg.zza(zzhVarZzd, zzaVarZzp);
            this.zzg.zzb(zzhVarZzd, zzaVarZzp);
            zzgs zzgsVarZza = zzgs.zza(zzblVar);
            zzs().zza(zzgsVarZza.zzc, zzh().zzc(str));
            zzs().zza(zzgsVarZza, zze().zzb(str));
            Bundle bundle2 = zzgsVarZza.zzc;
            bundle2.putLong("_c", 1L);
            zzj().zzc().zza("Marking in-app purchase as real-time");
            bundle2.putLong("_r", 1L);
            bundle2.putString("_o", zzblVar.zzc);
            if (zzs().zzd(zzaVarZzp.zzu(), zzhVarZzd.zzam())) {
                zzs().zza(bundle2, "_dbg", (Object) 1L);
                zzs().zza(bundle2, "_r", (Object) 1L);
            }
            zzbh zzbhVarZzd = zzh().zzd(str, zzblVar.zza);
            if (zzbhVarZzd == null) {
                zzaVar = zzaVarZzp;
                bundle = bundle2;
                zzhVar = zzhVarZzd;
                zzbVar = zzbVarZzb;
                bArr = null;
                zzbhVarZza = new zzbh(str, zzblVar.zza, 0L, 0L, zzblVar.zzd, 0L, null, null, null, null);
                j = 0;
            } else {
                zzaVar = zzaVarZzp;
                bundle = bundle2;
                zzhVar = zzhVarZzd;
                zzbVar = zzbVarZzb;
                bArr = null;
                j = zzbhVarZzd.zzf;
                zzbhVarZza = zzbhVarZzd.zza(zzblVar.zzd);
            }
            zzh().zza(zzbhVarZza);
            zzbe zzbeVar = new zzbe(this.zzu, zzblVar.zzc, str, zzblVar.zza, zzblVar.zzd, j, bundle);
            zzgf.zzf.zza zzaVarZza = zzgf.zzf.zze().zzb(zzbeVar.zzd).zza(zzbeVar.zzb).zza(zzbeVar.zze);
            Iterator<String> it2 = zzbeVar.zzf.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                zzgf.zzh.zza zzaVarZza2 = zzgf.zzh.zze().zza(next2);
                Object objZzc = zzbeVar.zzf.zzc(next2);
                if (objZzc != null) {
                    h_().zza(zzaVarZza2, objZzc);
                    zzaVarZza.zza(zzaVarZza2);
                }
            }
            zzgf.zzk.zza zzaVar2 = zzaVar;
            zzaVar2.zza(zzaVarZza).zza(zzgf.zzl.zza().zza(zzgf.zzg.zza().zza(zzbhVarZza.zzc).zza(zzblVar.zza)));
            zzaVar2.zza(zzg().zza(zzhVar.zzac(), Collections.emptyList(), zzaVar2.zzac(), Long.valueOf(zzaVarZza.zzc()), Long.valueOf(zzaVarZza.zzc()), false));
            if (zzaVarZza.zzg()) {
                zzaVar2.zzj(zzaVarZza.zzc()).zzf(zzaVarZza.zzc());
            }
            long jZzs = zzhVar.zzs();
            if (jZzs != 0) {
                zzaVar2.zzh(jZzs);
            }
            long jZzu = zzhVar.zzu();
            if (jZzu != 0) {
                zzaVar2.zzi(jZzu);
            } else if (jZzs != 0) {
                zzaVar2.zzi(jZzs);
            }
            String strZzal = zzhVar.zzal();
            if (com.google.android.gms.internal.measurement.zzpf.zza() && zze().zze(str, zzbn.zzcg) && strZzal != null) {
                zzaVar2.zzr(strZzal);
            }
            zzhVar.zzap();
            zzaVar2.zzf((int) zzhVar.zzt()).zzm(114010L).zzl(zzb().currentTimeMillis()).zzd(Boolean.TRUE.booleanValue());
            this.zzg.zza(zzaVar2.zzu(), zzaVar2);
            zzgf.zzj.zzb zzbVar2 = zzbVar;
            zzbVar2.zza(zzaVar2);
            zzh zzhVar2 = zzhVar;
            zzhVar2.zzr(zzaVar2.zzf());
            zzhVar2.zzp(zzaVar2.zze());
            zzh().zza(zzhVar2, false, false);
            zzh().zzx();
            try {
                return h_().zzb(((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzbVar2.zzaj())).zzce());
            } catch (IOException e) {
                zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzgo.zza(str), e);
                return bArr;
            }
        } catch (SecurityException e2) {
            zzj().zzc().zza("Resettable device id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzj().zzc().zza("app instance id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzh().zzr();
        }
    }
}
