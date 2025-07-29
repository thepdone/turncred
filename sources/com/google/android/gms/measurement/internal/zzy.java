package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgf;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzy {
    private zzgf.zzf zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzx zzd;

    final zzgf.zzf zza(String str, zzgf.zzf zzfVar) {
        String strZzg = zzfVar.zzg();
        List<zzgf.zzh> listZzh = zzfVar.zzh();
        this.zzd.h_();
        Long l = (Long) zzpj.zzb(zzfVar, "_eid");
        boolean z = l != null;
        if (z && strZzg.equals("_ep")) {
            Preconditions.checkNotNull(l);
            this.zzd.h_();
            strZzg = (String) zzpj.zzb(zzfVar, "_en");
            if (TextUtils.isEmpty(strZzg)) {
                this.zzd.zzj().zzo().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzgf.zzf, Long> pairZza = this.zzd.zzh().zza(str, l);
                if (pairZza == null || pairZza.first == null) {
                    this.zzd.zzj().zzo().zza("Extra parameter without existing main event. eventName, eventId", strZzg, l);
                    return null;
                }
                this.zza = (zzgf.zzf) pairZza.first;
                this.zzc = ((Long) pairZza.second).longValue();
                this.zzd.h_();
                this.zzb = (Long) zzpj.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzar zzarVarZzh = this.zzd.zzh();
                zzarVarZzh.zzv();
                zzarVarZzh.zzj().zzq().zza("Clearing complex main event info. appId", str);
                try {
                    zzarVarZzh.f_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzarVarZzh.zzj().zzg().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzh().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzgf.zzh zzhVar : this.zza.zzh()) {
                this.zzd.h_();
                if (zzpj.zza(zzfVar, zzhVar.zzg()) == null) {
                    arrayList.add(zzhVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzj().zzo().zza("No unique parameters in main event. eventName", strZzg);
            } else {
                arrayList.addAll(listZzh);
                listZzh = arrayList;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzfVar;
            this.zzd.h_();
            long jLongValue = ((Long) zzpj.zza(zzfVar, "_epc", (Object) 0L)).longValue();
            this.zzc = jLongValue;
            if (jLongValue <= 0) {
                this.zzd.zzj().zzo().zza("Complex event with zero extra param count. eventName", strZzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l), this.zzc, zzfVar);
            }
        }
        return (zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzfVar.zzch().zza(strZzg).zzd().zza(listZzh).zzaj());
    }

    private zzy(zzx zzxVar) {
        this.zzd = zzxVar;
    }
}
