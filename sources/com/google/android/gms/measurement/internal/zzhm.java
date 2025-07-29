package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.measurement.internal.zzjj;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.ProfilingTraceData;
import io.sentry.SentryLockReason;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzhm extends zzot implements zzak {
    final LruCache<String, com.google.android.gms.internal.measurement.zzb> zza;
    private final Map<String, Map<String, String>> zzb;
    private final Map<String, Set<String>> zzc;
    private final Map<String, Map<String, Boolean>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, zzgc.zzd> zzf;
    private final Map<String, Map<String, Integer>> zzh;
    private final com.google.android.gms.internal.measurement.zzv zzi;
    private final Map<String, String> zzj;
    private final Map<String, String> zzk;
    private final Map<String, String> zzl;

    final int zzb(String str, String str2) throws IllegalStateException {
        Integer num;
        zzv();
        zzu(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    final long zza(String str) throws IllegalStateException {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e) {
            zzj().zzr().zza("Unable to parse timezone offset. appId", zzgo.zza(str), e);
            return 0L;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static /* synthetic */ com.google.android.gms.internal.measurement.zzb zza(zzhm zzhmVar, String str) throws IllegalStateException {
        zzhmVar.zzam();
        Preconditions.checkNotEmpty(str);
        if (!zzhmVar.zzk(str)) {
            return null;
        }
        if (zzhmVar.zzf.containsKey(str) && zzhmVar.zzf.get(str) != null) {
            zzhmVar.zza(str, zzhmVar.zzf.get(str));
        } else {
            zzhmVar.zzu(str);
        }
        return zzhmVar.zza.snapshot().get(str);
    }

    public static /* synthetic */ com.google.android.gms.internal.measurement.zzal zza(zzhm zzhmVar) {
        return new com.google.android.gms.internal.measurement.zzr(zzhmVar.zzi);
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

    final zzjm zza(String str, zzjj.zza zzaVar) throws IllegalStateException {
        zzv();
        zzu(str);
        zzgc.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return zzjm.UNINITIALIZED;
        }
        for (zzgc.zza.zzb zzbVar : zzaVarZzb.zzf()) {
            if (zza(zzbVar.zzc()) == zzaVar) {
                int i = zzht.zzc[zzbVar.zzb().ordinal()];
                if (i == 1) {
                    return zzjm.DENIED;
                }
                if (i == 2) {
                    return zzjm.GRANTED;
                }
                return zzjm.UNINITIALIZED;
            }
        }
        return zzjm.UNINITIALIZED;
    }

    final zzjj.zza zzb(String str, zzjj.zza zzaVar) throws IllegalStateException {
        zzv();
        zzu(str);
        zzgc.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return null;
        }
        for (zzgc.zza.zzc zzcVar : zzaVarZzb.zze()) {
            if (zzaVar == zza(zzcVar.zzc())) {
                return zza(zzcVar.zzb());
            }
        }
        return null;
    }

    private static zzjj.zza zza(zzgc.zza.zze zzeVar) {
        int i = zzht.zzb[zzeVar.ordinal()];
        if (i == 1) {
            return zzjj.zza.AD_STORAGE;
        }
        if (i == 2) {
            return zzjj.zza.ANALYTICS_STORAGE;
        }
        if (i == 3) {
            return zzjj.zza.AD_USER_DATA;
        }
        if (i != 4) {
            return null;
        }
        return zzjj.zza.AD_PERSONALIZATION;
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

    final zzgc.zza zzb(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        zzgc.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null || !zzdVarZzc.zzo()) {
            return null;
        }
        return zzdVarZzc.zzd();
    }

    protected final zzgc.zzd zzc(String str) throws IllegalStateException {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        zzu(str);
        return this.zzf.get(str);
    }

    private final zzgc.zzd zza(String str, byte[] bArr) throws IllegalStateException {
        if (bArr == null) {
            return zzgc.zzd.zzg();
        }
        try {
            zzgc.zzd zzdVar = (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) ((zzgc.zzd.zza) zzpj.zza(zzgc.zzd.zze(), bArr)).zzaj());
            zzj().zzq().zza("Parsed config. version, gmp_app_id", zzdVar.zzr() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzp() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzkp e) {
            zzj().zzr().zza("Unable to merge remote config. appId", zzgo.zza(str), e);
            return zzgc.zzd.zzg();
        } catch (RuntimeException e2) {
            zzj().zzr().zza("Unable to merge remote config. appId", zzgo.zza(str), e2);
            return zzgc.zzd.zzg();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzak
    public final String zza(String str, String str2) throws IllegalStateException {
        zzv();
        zzu(str);
        Map<String, String> map = this.zzb.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    protected final String zzd(String str) {
        zzv();
        return this.zzl.get(str);
    }

    protected final String zze(String str) {
        zzv();
        return this.zzk.get(str);
    }

    final String zzf(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        return this.zzj.get(str);
    }

    private static Map<String, String> zza(zzgc.zzd zzdVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzdVar != null) {
            for (zzgc.zzh zzhVar : zzdVar.zzn()) {
                arrayMap.put(zzhVar.zzb(), zzhVar.zzc());
            }
        }
        return arrayMap;
    }

    final Set<String> zzg(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        return this.zzc.get(str);
    }

    final SortedSet<String> zzh(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        TreeSet treeSet = new TreeSet();
        zzgc.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return treeSet;
        }
        Iterator<zzgc.zza.zzf> it = zzaVarZzb.zzc().iterator();
        while (it.hasNext()) {
            treeSet.add(it.next().zzb());
        }
        return treeSet;
    }

    zzhm(zzou zzouVar) {
        super(zzouVar);
        this.zzb = new ArrayMap();
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzf = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zza = new zzhs(this, 20);
        this.zzi = new zzhr(this);
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

    protected final void zzi(String str) {
        zzv();
        this.zzk.put(str, null);
    }

    private final void zza(String str, zzgc.zzd.zza zzaVar) throws IllegalStateException {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            Iterator<zzgc.zzb> it = zzaVar.zze().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().zzb());
            }
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzgc.zzc.zza zzaVarZzch = zzaVar.zza(i).zzch();
                if (zzaVarZzch.zzb().isEmpty()) {
                    zzj().zzr().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzaVarZzch.zzb();
                    String strZzb2 = zzjp.zzb(zzaVarZzch.zzb());
                    if (!TextUtils.isEmpty(strZzb2)) {
                        zzaVarZzch = zzaVarZzch.zza(strZzb2);
                        zzaVar.zza(i, zzaVarZzch);
                    }
                    if (zzaVarZzch.zze() && zzaVarZzch.zzc()) {
                        arrayMap.put(strZzb, true);
                    }
                    if (zzaVarZzch.zzf() && zzaVarZzch.zzd()) {
                        arrayMap2.put(zzaVarZzch.zzb(), true);
                    }
                    if (zzaVarZzch.zzg()) {
                        if (zzaVarZzch.zza() < 2 || zzaVarZzch.zza() > 65535) {
                            zzj().zzr().zza("Invalid sampling rate. Event name, sample rate", zzaVarZzch.zzb(), Integer.valueOf(zzaVarZzch.zza()));
                        } else {
                            arrayMap3.put(zzaVarZzch.zzb(), Integer.valueOf(zzaVarZzch.zza()));
                        }
                    }
                }
            }
        }
        this.zzc.put(str, hashSet);
        this.zzd.put(str, arrayMap);
        this.zze.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    private final void zzu(String str) throws IllegalStateException {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        if (this.zzf.get(str) == null) {
            zzat zzatVarZze = zzh().zze(str);
            if (zzatVarZze == null) {
                this.zzb.put(str, null);
                this.zzd.put(str, null);
                this.zzc.put(str, null);
                this.zze.put(str, null);
                this.zzf.put(str, null);
                this.zzj.put(str, null);
                this.zzk.put(str, null);
                this.zzl.put(str, null);
                this.zzh.put(str, null);
                return;
            }
            zzgc.zzd.zza zzaVarZzch = zza(str, zzatVarZze.zza).zzch();
            zza(str, zzaVarZzch);
            this.zzb.put(str, zza((zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj())));
            this.zzf.put(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj()));
            zza(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj()));
            this.zzj.put(str, zzaVarZzch.zzc());
            this.zzk.put(str, zzatVarZze.zzb);
            this.zzl.put(str, zzatVarZze.zzc);
        }
    }

    private final void zza(final String str, zzgc.zzd zzdVar) throws IllegalStateException {
        if (zzdVar.zza() == 0) {
            this.zza.remove(str);
            return;
        }
        zzj().zzq().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzgr.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzho
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzhu(this.zza, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhn
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzhm zzhmVar = this.zza;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhp
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzhm zzhmVar2 = zzhmVar;
                            String str3 = str2;
                            zzh zzhVarZzd = zzhmVar2.zzh().zzd(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put(SentryLockReason.JsonKeys.PACKAGE_NAME, str3);
                            map.put("gmp_version", 114010L);
                            if (zzhVarZzd != null) {
                                String strZzaf = zzhVarZzd.zzaf();
                                if (strZzaf != null) {
                                    map.put(App.JsonKeys.APP_VERSION, strZzaf);
                                }
                                map.put("app_version_int", Long.valueOf(zzhVarZzd.zze()));
                                map.put("dynamite_version", Long.valueOf(zzhVarZzd.zzo()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzhm.zza(this.zza);
                }
            });
            zzbVar.zza(zzcVar);
            this.zza.put(str, zzbVar);
            zzj().zzq().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<zzgr.zzb> it = zzcVar.zza().zzd().iterator();
            while (it.hasNext()) {
                zzj().zzq().zza("EES program activity", it.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    final void zzj(String str) {
        zzv();
        this.zzf.remove(str);
    }

    public final boolean zzk(String str) {
        zzgc.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.zzf.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    final boolean zzl(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzc(String str, zzjj.zza zzaVar) throws IllegalStateException {
        zzv();
        zzu(str);
        zzgc.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return false;
        }
        Iterator<zzgc.zza.zzb> it = zzaVarZzb.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzgc.zza.zzb next = it.next();
            if (zzaVar == zza(next.zzc())) {
                if (next.zzb() == zzgc.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    final boolean zzm(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        zzgc.zza zzaVarZzb = zzb(str);
        return zzaVarZzb == null || !zzaVarZzb.zzh() || zzaVarZzb.zzg();
    }

    final boolean zzc(String str, String str2) throws IllegalStateException {
        Boolean bool;
        zzv();
        zzu(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzd(String str, String str2) throws IllegalStateException {
        Boolean bool;
        zzv();
        zzu(str);
        if (zzl(str) && zzpn.zzf(str2)) {
            return true;
        }
        if (zzn(str) && zzpn.zzg(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzd.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzn(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    protected final boolean zza(String str, byte[] bArr, String str2, String str3) throws IllegalStateException {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        zzgc.zzd.zza zzaVarZzch = zza(str, bArr).zzch();
        if (zzaVarZzch == null) {
            return false;
        }
        zza(str, zzaVarZzch);
        zza(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj()));
        this.zzf.put(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj()));
        this.zzj.put(str, zzaVarZzch.zzc());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzb.put(str, zza((zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj())));
        zzh().zza(str, new ArrayList(zzaVarZzch.zzd()));
        try {
            zzaVarZzch.zzb();
            bArr = ((zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj())).zzce();
        } catch (RuntimeException e) {
            zzj().zzr().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzgo.zza(str), e);
        }
        zzar zzarVarZzh = zzh();
        Preconditions.checkNotEmpty(str);
        zzarVarZzh.zzv();
        zzarVarZzh.zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzarVarZzh.f_().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzarVarZzh.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzgo.zza(str));
            }
        } catch (SQLiteException e2) {
            zzarVarZzh.zzj().zzg().zza("Error storing remote config. appId", zzgo.zza(str), e2);
        }
        this.zzf.put(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZzch.zzaj()));
        return true;
    }

    final boolean zzo(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("app_instance_id");
    }

    final boolean zzp(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        if (this.zzc.get(str) != null) {
            return this.zzc.get(str).contains(ProfilingTraceData.JsonKeys.DEVICE_MODEL) || this.zzc.get(str).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    final boolean zzq(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("enhanced_user_id");
    }

    final boolean zzr(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("google_signals");
    }

    final boolean zzs(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        if (this.zzc.get(str) != null) {
            return this.zzc.get(str).contains("os_version") || this.zzc.get(str).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    final boolean zzt(String str) throws IllegalStateException {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("user_id");
    }
}
