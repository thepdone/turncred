package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzjp implements zznl {
    private final zzjn zza;

    public static zzjp zza(zzjn zzjnVar) {
        return zzjnVar.zza != null ? zzjnVar.zza : new zzjp(zzjnVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final int zza() {
        return 1;
    }

    private zzjp(zzjn zzjnVar) {
        zzjn zzjnVar2 = (zzjn) zzkj.zza(zzjnVar, "output");
        this.zza = zzjnVar2;
        zzjnVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zziw)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzjn.zza(list.get(i3).booleanValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).booleanValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        zziw zziwVar = (zziw) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zziwVar.size(); i4++) {
                iZza2 += zzjn.zza(zziwVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zziwVar.size()) {
                this.zza.zzb(zziwVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zziwVar.size()) {
            this.zza.zzb(i, zziwVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, zziy zziyVar) throws IOException {
        this.zza.zzc(i, zziyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, List<zziy> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjs)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzjn.zza(list.get(i3).doubleValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).doubleValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        zzjs zzjsVar = (zzjs) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzjsVar.size(); i4++) {
                iZza2 += zzjn.zza(zzjsVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzjsVar.size()) {
                this.zza.zzb(zzjsVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjsVar.size()) {
            this.zza.zzb(i, zzjsVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkh)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzjn.zza(list.get(i3).intValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzi(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzkhVar.size(); i4++) {
                iZza2 += zzjn.zza(zzkhVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzkhVar.size()) {
                this.zza.zzi(zzkhVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkhVar.size()) {
            this.zza.zzh(i, zzkhVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkh)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzb = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzb += zzjn.zzb(list.get(i3).intValue());
                }
                this.zza.zzk(iZzb);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzb2 = 0;
            for (int i4 = 0; i4 < zzkhVar.size(); i4++) {
                iZzb2 += zzjn.zzb(zzkhVar.zzb(i4));
            }
            this.zza.zzk(iZzb2);
            while (i2 < zzkhVar.size()) {
                this.zza.zzh(zzkhVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkhVar.size()) {
            this.zza.zzg(i, zzkhVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlb)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzjn.zza(list.get(i3).longValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzf(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzlbVar.size(); i4++) {
                iZza2 += zzjn.zza(zzlbVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzlbVar.size()) {
                this.zza.zzf(zzlbVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzlbVar.size()) {
            this.zza.zzf(i, zzlbVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkc)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzjn.zza(list.get(i3).floatValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).floatValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        zzkc zzkcVar = (zzkc) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzkcVar.size(); i4++) {
                iZza2 += zzjn.zza(zzkcVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzkcVar.size()) {
                this.zza.zzb(zzkcVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkcVar.size()) {
            this.zza.zzb(i, zzkcVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, Object obj, zzme zzmeVar) throws IOException {
        zzjn zzjnVar = this.zza;
        zzjnVar.zzj(i, 3);
        zzmeVar.zza((zzme) obj, (zznl) zzjnVar.zza);
        zzjnVar.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, List<?> list, zzme zzmeVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzmeVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkh)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzjn.zzc(list.get(i3).intValue());
                }
                this.zza.zzk(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzi(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzkhVar.size(); i4++) {
                iZzc2 += zzjn.zzc(zzkhVar.zzb(i4));
            }
            this.zza.zzk(iZzc2);
            while (i2 < zzkhVar.size()) {
                this.zza.zzi(zzkhVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkhVar.size()) {
            this.zza.zzh(i, zzkhVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlb)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzb = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzb += zzjn.zzb(list.get(i3).longValue());
                }
                this.zza.zzk(iZzb);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzb2 = 0;
            for (int i4 = 0; i4 < zzlbVar.size(); i4++) {
                iZzb2 += zzjn.zzb(zzlbVar.zzb(i4));
            }
            this.zza.zzk(iZzb2);
            while (i2 < zzlbVar.size()) {
                this.zza.zzh(zzlbVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzlbVar.size()) {
            this.zza.zzh(i, zzlbVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final <K, V> void zza(int i, zzlh<K, V> zzlhVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i, 2);
            this.zza.zzk(zzle.zza(zzlhVar, entry.getKey(), entry.getValue()));
            zzle.zza(this.zza, zzlhVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i, Object obj, zzme zzmeVar) throws IOException {
        this.zza.zzc(i, (zzlm) obj, zzmeVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i, List<?> list, zzme zzmeVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzmeVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zziy) {
            this.zza.zzd(i, (zziy) obj);
        } else {
            this.zza.zzb(i, (zzlm) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkh)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzd = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzd += zzjn.zzd(list.get(i3).intValue());
                }
                this.zza.zzk(iZzd);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzd2 = 0;
            for (int i4 = 0; i4 < zzkhVar.size(); i4++) {
                iZzd2 += zzjn.zzd(zzkhVar.zzb(i4));
            }
            this.zza.zzk(iZzd2);
            while (i2 < zzkhVar.size()) {
                this.zza.zzh(zzkhVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkhVar.size()) {
            this.zza.zzg(i, zzkhVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlb)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzjn.zzc(list.get(i3).longValue());
                }
                this.zza.zzk(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzf(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzlbVar.size(); i4++) {
                iZzc2 += zzjn.zzc(zzlbVar.zzb(i4));
            }
            this.zza.zzk(iZzc2);
            while (i2 < zzlbVar.size()) {
                this.zza.zzf(zzlbVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzlbVar.size()) {
            this.zza.zzf(i, zzlbVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkh)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZze = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZze += zzjn.zze(list.get(i3).intValue());
                }
                this.zza.zzk(iZze);
                while (i2 < list.size()) {
                    this.zza.zzj(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzi(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZze2 = 0;
            for (int i4 = 0; i4 < zzkhVar.size(); i4++) {
                iZze2 += zzjn.zze(zzkhVar.zzb(i4));
            }
            this.zza.zzk(iZze2);
            while (i2 < zzkhVar.size()) {
                this.zza.zzj(zzkhVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkhVar.size()) {
            this.zza.zzi(i, zzkhVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlb)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzd = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzd += zzjn.zzd(list.get(i3).longValue());
                }
                this.zza.zzk(iZzd);
                while (i2 < list.size()) {
                    this.zza.zzg(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzd2 = 0;
            for (int i4 = 0; i4 < zzlbVar.size(); i4++) {
                iZzd2 += zzjn.zzd(zzlbVar.zzb(i4));
            }
            this.zza.zzk(iZzd2);
            while (i2 < zzlbVar.size()) {
                this.zza.zzg(zzlbVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzlbVar.size()) {
            this.zza.zzg(i, zzlbVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzj(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzkx) {
            zzkx zzkxVar = (zzkx) list;
            while (i2 < list.size()) {
                Object objZza = zzkxVar.zza(i2);
                if (objZza instanceof String) {
                    this.zza.zzb(i, (String) objZza);
                } else {
                    this.zza.zzc(i, (zziy) objZza);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkh)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzg = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzg += zzjn.zzg(list.get(i3).intValue());
                }
                this.zza.zzk(iZzg);
                while (i2 < list.size()) {
                    this.zza.zzk(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzk(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzg2 = 0;
            for (int i4 = 0; i4 < zzkhVar.size(); i4++) {
                iZzg2 += zzjn.zzg(zzkhVar.zzb(i4));
            }
            this.zza.zzk(iZzg2);
            while (i2 < zzkhVar.size()) {
                this.zza.zzk(zzkhVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkhVar.size()) {
            this.zza.zzk(i, zzkhVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlb)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZze = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZze += zzjn.zze(list.get(i3).longValue());
                }
                this.zza.zzk(iZze);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZze2 = 0;
            for (int i4 = 0; i4 < zzlbVar.size(); i4++) {
                iZze2 += zzjn.zze(zzlbVar.zzb(i4));
            }
            this.zza.zzk(iZze2);
            while (i2 < zzlbVar.size()) {
                this.zza.zzh(zzlbVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzlbVar.size()) {
            this.zza.zzh(i, zzlbVar.zzb(i2));
            i2++;
        }
    }
}
