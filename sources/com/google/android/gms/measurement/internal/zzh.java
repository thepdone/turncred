package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzh {
    private final zzic zza;
    private Long zzaa;
    private Long zzab;
    private long zzac;
    private String zzad;
    private int zzae;
    private int zzaf;
    private long zzag;
    private String zzah;
    private byte[] zzai;
    private int zzaj;
    private long zzak;
    private long zzal;
    private long zzam;
    private long zzan;
    private long zzao;
    private long zzap;
    private String zzaq;
    private boolean zzar;
    private long zzas;
    private long zzat;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private String zzq;
    private Boolean zzr;
    private long zzs;
    private List<String> zzt;
    private String zzu;
    private boolean zzv;
    private long zzw;
    private long zzx;
    private int zzy;
    private boolean zzz;

    public final int zza() {
        this.zza.zzl().zzv();
        return this.zzy;
    }

    public final int zzb() {
        this.zza.zzl().zzv();
        return this.zzaj;
    }

    public final int zzc() {
        this.zza.zzl().zzv();
        return this.zzaf;
    }

    public final int zzd() {
        this.zza.zzl().zzv();
        return this.zzae;
    }

    public final long zze() {
        this.zza.zzl().zzv();
        return this.zzk;
    }

    public final long zzf() {
        this.zza.zzl().zzv();
        return this.zzac;
    }

    public final long zzg() {
        this.zza.zzl().zzv();
        return this.zzas;
    }

    public final long zzh() {
        this.zza.zzl().zzv();
        return this.zzan;
    }

    public final long zzi() {
        this.zza.zzl().zzv();
        return this.zzao;
    }

    public final long zzj() {
        this.zza.zzl().zzv();
        return this.zzam;
    }

    public final long zzk() {
        this.zza.zzl().zzv();
        return this.zzal;
    }

    public final long zzl() {
        this.zza.zzl().zzv();
        return this.zzap;
    }

    public final long zzm() {
        this.zza.zzl().zzv();
        return this.zzak;
    }

    public final long zzn() {
        this.zza.zzl().zzv();
        return this.zzn;
    }

    public final long zzo() {
        this.zza.zzl().zzv();
        return this.zzs;
    }

    public final long zzp() {
        this.zza.zzl().zzv();
        return this.zzat;
    }

    public final long zzq() {
        this.zza.zzl().zzv();
        return this.zzm;
    }

    public final long zzr() {
        this.zza.zzl().zzv();
        return this.zzag;
    }

    public final long zzs() {
        this.zza.zzl().zzv();
        return this.zzi;
    }

    public final long zzt() {
        this.zza.zzl().zzv();
        return this.zzg;
    }

    public final long zzu() {
        this.zza.zzl().zzv();
        return this.zzh;
    }

    public final long zzv() {
        this.zza.zzl().zzv();
        return this.zzx;
    }

    public final long zzw() {
        this.zza.zzl().zzv();
        return this.zzw;
    }

    public final Boolean zzx() {
        this.zza.zzl().zzv();
        return this.zzr;
    }

    public final Long zzy() {
        this.zza.zzl().zzv();
        return this.zzaa;
    }

    public final Long zzz() {
        this.zza.zzl().zzv();
        return this.zzab;
    }

    public final String zzaa() {
        this.zza.zzl().zzv();
        return this.zzq;
    }

    public final String zzab() {
        this.zza.zzl().zzv();
        String str = this.zzaq;
        zzg((String) null);
        return str;
    }

    public final String zzac() {
        this.zza.zzl().zzv();
        return this.zzb;
    }

    public final String zzad() {
        this.zza.zzl().zzv();
        return this.zzc;
    }

    public final String zzae() {
        this.zza.zzl().zzv();
        return this.zzl;
    }

    public final String zzaf() {
        this.zza.zzl().zzv();
        return this.zzj;
    }

    public final String zzag() {
        this.zza.zzl().zzv();
        return this.zzf;
    }

    public final String zzah() {
        this.zza.zzl().zzv();
        return this.zzd;
    }

    public final String zzai() {
        this.zza.zzl().zzv();
        return this.zzaq;
    }

    public final String zzaj() {
        this.zza.zzl().zzv();
        return this.zze;
    }

    public final String zzak() {
        this.zza.zzl().zzv();
        return this.zzah;
    }

    public final String zzal() {
        this.zza.zzl().zzv();
        return this.zzu;
    }

    public final String zzam() {
        this.zza.zzl().zzv();
        return this.zzad;
    }

    public final List<String> zzan() {
        this.zza.zzl().zzv();
        return this.zzt;
    }

    zzh(zzic zzicVar, String str) {
        Preconditions.checkNotNull(zzicVar);
        Preconditions.checkNotEmpty(str);
        this.zza = zzicVar;
        this.zzb = str;
        zzicVar.zzl().zzv();
    }

    public final void zzao() {
        this.zza.zzl().zzv();
        this.zzar = false;
    }

    public final void zzap() throws IllegalStateException {
        this.zza.zzl().zzv();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzj().zzr().zza("Bundle index overflow. appId", zzgo.zza(this.zzb));
            j = 0;
        }
        this.zzar = true;
        this.zzg = j;
    }

    public final void zza(long j) throws IllegalStateException {
        this.zza.zzl().zzv();
        long j2 = this.zzg + j;
        if (j2 > 2147483647L) {
            this.zza.zzj().zzr().zza("Bundle index overflow. appId", zzgo.zza(this.zzb));
            j2 = j - 1;
        }
        long j3 = this.zzag + 1;
        if (j3 > 2147483647L) {
            this.zza.zzj().zzr().zza("Delivery index overflow. appId", zzgo.zza(this.zzb));
            j3 = 0;
        }
        this.zzar = true;
        this.zzg = j2;
        this.zzag = j3;
    }

    public final void zza(byte[] bArr) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzai != bArr;
        this.zzai = bArr;
    }

    public final void zza(String str) {
        this.zza.zzl().zzv();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzar |= !Objects.equals(this.zzq, str);
        this.zzq = str;
    }

    public final void zza(int i) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzy != i;
        this.zzy = i;
    }

    public final void zza(boolean z) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzp != z;
        this.zzp = z;
    }

    public final void zzb(String str) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzc, str);
        this.zzc = str;
    }

    public final void zzc(String str) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzl, str);
        this.zzl = str;
    }

    public final void zzd(String str) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzj, str);
        this.zzj = str;
    }

    public final void zzb(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzk != j;
        this.zzk = j;
    }

    public final void zzc(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzac != j;
        this.zzac = j;
    }

    public final void zzb(int i) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzaj != i;
        this.zzaj = i;
    }

    public final void zzd(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzas != j;
        this.zzas = j;
    }

    public final void zze(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzan != j;
        this.zzan = j;
    }

    public final void zzf(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzao != j;
        this.zzao = j;
    }

    public final void zzg(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzam != j;
        this.zzam = j;
    }

    public final void zzh(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzal != j;
        this.zzal = j;
    }

    public final void zzc(int i) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzaf != i;
        this.zzaf = i;
    }

    public final void zzi(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzap != j;
        this.zzap = j;
    }

    public final void zzj(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzak != j;
        this.zzak = j;
    }

    public final void zzk(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzn != j;
        this.zzn = j;
    }

    public final void zzd(int i) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzae != i;
        this.zzae = i;
    }

    public final void zzl(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzs != j;
        this.zzs = j;
    }

    public final void zzm(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzat != j;
        this.zzat = j;
    }

    public final void zze(String str) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzf, str);
        this.zzf = str;
    }

    public final void zzf(String str) {
        this.zza.zzl().zzv();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzar |= !Objects.equals(this.zzd, str);
        this.zzd = str;
    }

    public final void zzn(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzm != j;
        this.zzm = j;
    }

    public final void zzg(String str) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzaq, str);
        this.zzaq = str;
    }

    public final void zzo(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzag != j;
        this.zzag = j;
    }

    public final void zzp(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzi != j;
        this.zzi = j;
    }

    public final void zzq(long j) {
        Preconditions.checkArgument(j >= 0);
        this.zza.zzl().zzv();
        this.zzar |= this.zzg != j;
        this.zzg = j;
    }

    public final void zzr(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzh != j;
        this.zzh = j;
    }

    public final void zzb(boolean z) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzo != z;
        this.zzo = z;
    }

    public final void zza(Boolean bool) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzr, bool);
        this.zzr = bool;
    }

    public final void zzh(String str) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zze, str);
        this.zze = str;
    }

    public final void zza(List<String> list) {
        this.zza.zzl().zzv();
        if (Objects.equals(this.zzt, list)) {
            return;
        }
        this.zzar = true;
        this.zzt = list != null ? new ArrayList(list) : null;
    }

    public final void zzi(String str) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzah != str;
        this.zzah = str;
    }

    public final void zzj(String str) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzu, str);
        this.zzu = str;
    }

    public final void zzs(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzx != j;
        this.zzx = j;
    }

    public final void zzk(String str) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzad != str;
        this.zzad = str;
    }

    public final void zzc(boolean z) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzv != z;
        this.zzv = z;
    }

    public final void zzt(long j) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzw != j;
        this.zzw = j;
    }

    public final void zzd(boolean z) {
        this.zza.zzl().zzv();
        this.zzar |= this.zzz != z;
        this.zzz = z;
    }

    public final void zza(Long l) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzaa, l);
        this.zzaa = l;
    }

    public final void zzb(Long l) {
        this.zza.zzl().zzv();
        this.zzar |= !Objects.equals(this.zzab, l);
        this.zzab = l;
    }

    public final boolean zzaq() {
        this.zza.zzl().zzv();
        return this.zzp;
    }

    public final boolean zzar() {
        this.zza.zzl().zzv();
        return this.zzo;
    }

    public final boolean zzas() {
        this.zza.zzl().zzv();
        return this.zzar;
    }

    public final boolean zzat() {
        this.zza.zzl().zzv();
        return this.zzv;
    }

    public final boolean zzau() {
        this.zza.zzl().zzv();
        return this.zzz;
    }

    public final byte[] zzav() {
        this.zza.zzl().zzv();
        return this.zzai;
    }
}
