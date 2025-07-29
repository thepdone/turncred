package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zznp extends zzot {
    public final zzhf zza;
    public final zzhf zzb;
    public final zzhf zzc;
    public final zzhf zzd;
    public final zzhf zze;
    public final zzhf zzf;
    private final Map<String, zzno> zzh;

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    @Deprecated
    private final Pair<String, Boolean> zza(String str) throws IllegalStateException {
        zzno zznoVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        zzv();
        long jElapsedRealtime = zzb().elapsedRealtime();
        zzno zznoVar2 = this.zzh.get(str);
        if (zznoVar2 != null && jElapsedRealtime < zznoVar2.zzc) {
            return new Pair<>(zznoVar2.zza, Boolean.valueOf(zznoVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long jZzd = zze().zzd(str) + jElapsedRealtime;
        try {
            try {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            } catch (PackageManager.NameNotFoundException unused) {
                if (zznoVar2 != null && jElapsedRealtime < zznoVar2.zzc + zze().zzc(str, zzbn.zzb)) {
                    return new Pair<>(zznoVar2.zza, Boolean.valueOf(zznoVar2.zzb));
                }
                advertisingIdInfo = null;
            }
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            zznoVar = new zzno("", false, jZzd);
        }
        if (advertisingIdInfo == null) {
            return new Pair<>("00000000-0000-0000-0000-000000000000", false);
        }
        String id = advertisingIdInfo.getId();
        zznoVar = id != null ? new zzno(id, advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd) : new zzno("", advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd);
        this.zzh.put(str, zznoVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(zznoVar.zza, Boolean.valueOf(zznoVar.zzb));
    }

    final Pair<String, Boolean> zza(String str, zzjj zzjjVar) {
        if (zzjjVar.zzg()) {
            return zza(str);
        }
        return new Pair<>("", false);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzx zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzar zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzhm zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zznp zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzos zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzpj h_() {
        return super.h_();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Deprecated
    final String zza(String str, boolean z) {
        String str2;
        zzv();
        if (!z) {
            str2 = "00000000-0000-0000-0000-000000000000";
        } else {
            str2 = (String) zza(str).first;
        }
        MessageDigest messageDigestZzr = zzpn.zzr();
        if (messageDigestZzr == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzr.digest(str2.getBytes())));
    }

    zznp(zzou zzouVar) {
        super(zzouVar);
        this.zzh = new HashMap();
        zzha zzhaVarZzk = zzk();
        Objects.requireNonNull(zzhaVarZzk);
        this.zza = new zzhf(zzhaVarZzk, "last_delete_stale", 0L);
        zzha zzhaVarZzk2 = zzk();
        Objects.requireNonNull(zzhaVarZzk2);
        this.zzb = new zzhf(zzhaVarZzk2, "last_delete_stale_batch", 0L);
        zzha zzhaVarZzk3 = zzk();
        Objects.requireNonNull(zzhaVarZzk3);
        this.zzc = new zzhf(zzhaVarZzk3, "backoff", 0L);
        zzha zzhaVarZzk4 = zzk();
        Objects.requireNonNull(zzhaVarZzk4);
        this.zzd = new zzhf(zzhaVarZzk4, "last_upload", 0L);
        zzha zzhaVarZzk5 = zzk();
        Objects.requireNonNull(zzhaVarZzk5);
        this.zze = new zzhf(zzhaVarZzk5, "last_upload_attempt", 0L);
        zzha zzhaVarZzk6 = zzk();
        Objects.requireNonNull(zzhaVarZzk6);
        this.zzf = new zzhf(zzhaVarZzk6, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }
}
