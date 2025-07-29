package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import io.sentry.ProfilingTraceData;
import io.sentry.protocol.App;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpj extends zzot {
    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    static int zza(zzgf.zzk.zza zzaVar, String str) {
        if (zzaVar == null) {
            return -1;
        }
        for (int i = 0; i < zzaVar.zzd(); i++) {
            if (str.equals(zzaVar.zzk(i).zzg())) {
                return i;
            }
        }
        return -1;
    }

    final long zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zza(str.getBytes(Charset.forName("UTF-8")));
    }

    final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzs().zzv();
        MessageDigest messageDigestZzr = zzpn.zzr();
        if (messageDigestZzr == null) {
            zzj().zzg().zza("Failed to get MD5");
            return 0L;
        }
        return zzpn.zza(messageDigestZzr.digest(bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static Bundle zza(List<zzgf.zzh> list) {
        Bundle bundle = new Bundle();
        for (zzgf.zzh zzhVar : list) {
            String strZzg = zzhVar.zzg();
            if (zzhVar.zzj()) {
                bundle.putDouble(strZzg, zzhVar.zza());
            } else if (zzhVar.zzk()) {
                bundle.putFloat(strZzg, zzhVar.zzb());
            } else if (zzhVar.zzn()) {
                bundle.putString(strZzg, zzhVar.zzh());
            } else if (zzhVar.zzl()) {
                bundle.putLong(strZzg, zzhVar.zzd());
            }
        }
        return bundle;
    }

    private final Bundle zza(Map<String, Object> map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    arrayList2.add(zza((Map<String, Object>) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            zzj().zzg().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
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

    final zzbl zza(com.google.android.gms.internal.measurement.zzad zzadVar) {
        String string;
        Object obj;
        Bundle bundleZza = zza(zzadVar.zzc(), true);
        if (bundleZza.containsKey("_o") && (obj = bundleZza.get("_o")) != null) {
            string = obj.toString();
        } else {
            string = App.TYPE;
        }
        String str = string;
        String strZzb = zzjp.zzb(zzadVar.zzb());
        if (strZzb == null) {
            strZzb = zzadVar.zzb();
        }
        return new zzbl(strZzb, new zzbg(bundleZza), str, zzadVar.zza());
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

    final zzog zza(String str, zzgf.zzk.zza zzaVar, zzgf.zzf.zza zzaVar2, String str2) throws IllegalStateException {
        int iIndexOf;
        if (!com.google.android.gms.internal.measurement.zzoy.zza() || !zze().zze(str, zzbn.zzcp)) {
            return null;
        }
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        String[] strArrSplit = zze().zzd(str, zzbn.zzbo).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            if (!hashSet.add(Objects.requireNonNull(str3))) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        zzos zzosVarZzp = zzp();
        String strZzf = zzosVarZzp.zzm().zzf(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(zzosVarZzp.zze().zzd(str, zzbn.zzbh));
        if (!TextUtils.isEmpty(strZzf)) {
            builder.authority(strZzf + "." + zzosVarZzp.zze().zzd(str, zzbn.zzbi));
        } else {
            builder.authority(zzosVarZzp.zze().zzd(str, zzbn.zzbi));
        }
        builder.path(zzosVarZzp.zze().zzd(str, zzbn.zzbj));
        zza(builder, "gmp_app_id", zzaVar.zzy(), (Set<String>) setUnmodifiableSet);
        zza(builder, "gmp_version", "114010", (Set<String>) setUnmodifiableSet);
        String strZzv = zzaVar.zzv();
        if (zze().zze(str, zzbn.zzcs) && zzm().zzo(str)) {
            strZzv = "";
        }
        zza(builder, "app_instance_id", strZzv, (Set<String>) setUnmodifiableSet);
        zza(builder, "rdid", zzaVar.zzaa(), (Set<String>) setUnmodifiableSet);
        zza(builder, "bundle_id", zzaVar.zzu(), (Set<String>) setUnmodifiableSet);
        String strZze = zzaVar2.zze();
        String strZza = zzjp.zza(strZze);
        if (!TextUtils.isEmpty(strZza)) {
            strZze = strZza;
        }
        zza(builder, "app_event_name", strZze, (Set<String>) setUnmodifiableSet);
        zza(builder, App.JsonKeys.APP_VERSION, String.valueOf(zzaVar.zzb()), (Set<String>) setUnmodifiableSet);
        String strZzz = zzaVar.zzz();
        if (zze().zze(str, zzbn.zzcs) && zzm().zzs(str) && !TextUtils.isEmpty(strZzz) && (iIndexOf = strZzz.indexOf(".")) != -1) {
            strZzz = strZzz.substring(0, iIndexOf);
        }
        zza(builder, "os_version", strZzz, (Set<String>) setUnmodifiableSet);
        zza(builder, "timestamp", String.valueOf(zzaVar2.zzc()), (Set<String>) setUnmodifiableSet);
        boolean zZzae = zzaVar.zzae();
        String str4 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        if (zZzae) {
            zza(builder, "lat", AppEventsConstants.EVENT_PARAM_VALUE_YES, (Set<String>) setUnmodifiableSet);
        }
        zza(builder, "privacy_sandbox_version", String.valueOf(zzaVar.zza()), (Set<String>) setUnmodifiableSet);
        zza(builder, "trigger_uri_source", AppEventsConstants.EVENT_PARAM_VALUE_YES, (Set<String>) setUnmodifiableSet);
        zza(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), (Set<String>) setUnmodifiableSet);
        zza(builder, "request_uuid", str2, (Set<String>) setUnmodifiableSet);
        List<zzgf.zzh> listZzf = zzaVar2.zzf();
        Bundle bundle = new Bundle();
        for (zzgf.zzh zzhVar : listZzf) {
            String strZzg = zzhVar.zzg();
            if (zzhVar.zzj()) {
                bundle.putString(strZzg, String.valueOf(zzhVar.zza()));
            } else if (zzhVar.zzk()) {
                bundle.putString(strZzg, String.valueOf(zzhVar.zzb()));
            } else if (zzhVar.zzn()) {
                bundle.putString(strZzg, zzhVar.zzh());
            } else if (zzhVar.zzl()) {
                bundle.putString(strZzg, String.valueOf(zzhVar.zzd()));
            }
        }
        zza(builder, zze().zzd(str, zzbn.zzbn).split("\\|"), bundle, (Set<String>) setUnmodifiableSet);
        List<zzgf.zzp> listZzac = zzaVar.zzac();
        Bundle bundle2 = new Bundle();
        for (zzgf.zzp zzpVar : listZzac) {
            String strZzg2 = zzpVar.zzg();
            if (zzpVar.zzi()) {
                bundle2.putString(strZzg2, String.valueOf(zzpVar.zza()));
            } else if (zzpVar.zzj()) {
                bundle2.putString(strZzg2, String.valueOf(zzpVar.zzb()));
            } else if (zzpVar.zzm()) {
                bundle2.putString(strZzg2, zzpVar.zzh());
            } else if (zzpVar.zzk()) {
                bundle2.putString(strZzg2, String.valueOf(zzpVar.zzc()));
            }
        }
        zza(builder, zze().zzd(str, zzbn.zzbm).split("\\|"), bundle2, (Set<String>) setUnmodifiableSet);
        if (!zzaVar.zzad()) {
            str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        zza(builder, "dma", str4, (Set<String>) setUnmodifiableSet);
        if (!zzaVar.zzx().isEmpty()) {
            zza(builder, "dma_cps", zzaVar.zzx(), (Set<String>) setUnmodifiableSet);
        }
        if (zze().zza(zzbn.zzcu) && zzaVar.zzaf()) {
            zzgf.zza zzaVarZzg = zzaVar.zzg();
            if (!zzaVarZzg.zzh().isEmpty()) {
                zza(builder, "dl_gclid", zzaVarZzg.zzh(), (Set<String>) setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzg().isEmpty()) {
                zza(builder, "dl_gbraid", zzaVarZzg.zzg(), (Set<String>) setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzf().isEmpty()) {
                zza(builder, "dl_gs", zzaVarZzg.zzf(), (Set<String>) setUnmodifiableSet);
            }
            if (zzaVarZzg.zza() > 0) {
                zza(builder, "dl_ss_ts", String.valueOf(zzaVarZzg.zza()), (Set<String>) setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzk().isEmpty()) {
                zza(builder, "mr_gclid", zzaVarZzg.zzk(), (Set<String>) setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzj().isEmpty()) {
                zza(builder, "mr_gbraid", zzaVarZzg.zzj(), (Set<String>) setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzi().isEmpty()) {
                zza(builder, "mr_gs", zzaVarZzg.zzi(), (Set<String>) setUnmodifiableSet);
            }
            if (zzaVarZzg.zzb() > 0) {
                zza(builder, "mr_click_ts", String.valueOf(zzaVarZzg.zzb()), (Set<String>) setUnmodifiableSet);
            }
        }
        return new zzog(builder.build().toString(), jCurrentTimeMillis, 1);
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

    final zzgf.zzf zza(zzbe zzbeVar) throws IllegalStateException {
        zzgf.zzf.zza zzaVarZza = zzgf.zzf.zze().zza(zzbeVar.zze);
        Iterator<String> it = zzbeVar.zzf.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzgf.zzh.zza zzaVarZza2 = zzgf.zzh.zze().zza(next);
            Object objZzc = zzbeVar.zzf.zzc(next);
            Preconditions.checkNotNull(objZzc);
            zza(zzaVarZza2, objZzc);
            zzaVarZza.zza(zzaVarZza2);
        }
        if (!TextUtils.isEmpty(zzbeVar.zzc) && zzbeVar.zzf.zzc("_o") == null) {
            zzaVarZza.zza((zzgf.zzh) ((com.google.android.gms.internal.measurement.zzkg) zzgf.zzh.zze().zza("_o").zzb(zzbeVar.zzc).zzaj()));
        }
        return (zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZza.zzaj());
    }

    static zzgf.zzh zza(zzgf.zzf zzfVar, String str) {
        for (zzgf.zzh zzhVar : zzfVar.zzh()) {
            if (zzhVar.zzg().equals(str)) {
                return zzhVar;
            }
        }
        return null;
    }

    static <BuilderT extends com.google.android.gms.internal.measurement.zzlp> BuilderT zza(BuilderT buildert, byte[] bArr) throws com.google.android.gms.internal.measurement.zzkp {
        com.google.android.gms.internal.measurement.zzjt zzjtVarZza = com.google.android.gms.internal.measurement.zzjt.zza();
        if (zzjtVarZza != null) {
            return (BuilderT) buildert.zza(bArr, zzjtVarZza);
        }
        return (BuilderT) buildert.zza(bArr);
    }

    static Object zzb(zzgf.zzf zzfVar, String str) {
        zzgf.zzh zzhVarZza = zza(zzfVar, str);
        if (zzhVarZza == null) {
            return null;
        }
        if (zzhVarZza.zzn()) {
            return zzhVarZza.zzh();
        }
        if (zzhVarZza.zzl()) {
            return Long.valueOf(zzhVarZza.zzd());
        }
        if (zzhVarZza.zzj()) {
            return Double.valueOf(zzhVarZza.zza());
        }
        if (zzhVarZza.zzc() > 0) {
            return zzb(zzhVarZza.zzi());
        }
        return null;
    }

    static Object zza(zzgf.zzf zzfVar, String str, Object obj) {
        Object objZzb = zzb(zzfVar, str);
        return objZzb == null ? obj : objZzb;
    }

    final String zza(zzgf.zzj zzjVar) {
        zzgf.zzc zzcVarZzw;
        if (zzjVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzjVar.zzh()) {
            zza(sb, 0, "upload_subdomain", zzjVar.zze());
        }
        if (zzjVar.zzg()) {
            zza(sb, 0, "sgtm_join_id", zzjVar.zzd());
        }
        for (zzgf.zzk zzkVar : zzjVar.zzf()) {
            if (zzkVar != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (zzkVar.zzbs()) {
                    zza(sb, 1, "protocol_version", Integer.valueOf(zzkVar.zzf()));
                }
                if (com.google.android.gms.internal.measurement.zzpf.zza() && zze().zze(zzkVar.zzab(), zzbn.zzcg) && zzkVar.zzbv()) {
                    zza(sb, 1, "session_stitching_token", zzkVar.zzaq());
                }
                zza(sb, 1, "platform", zzkVar.zzao());
                if (zzkVar.zzbn()) {
                    zza(sb, 1, "gmp_version", Long.valueOf(zzkVar.zzo()));
                }
                if (zzkVar.zzcb()) {
                    zza(sb, 1, "uploading_gmp_version", Long.valueOf(zzkVar.zzu()));
                }
                if (zzkVar.zzbl()) {
                    zza(sb, 1, "dynamite_version", Long.valueOf(zzkVar.zzm()));
                }
                if (zzkVar.zzbe()) {
                    zza(sb, 1, "config_version", Long.valueOf(zzkVar.zzk()));
                }
                zza(sb, 1, "gmp_app_id", zzkVar.i_());
                zza(sb, 1, "admob_app_id", zzkVar.zzaa());
                zza(sb, 1, "app_id", zzkVar.zzab());
                zza(sb, 1, App.JsonKeys.APP_VERSION, zzkVar.zzae());
                if (zzkVar.zzba()) {
                    zza(sb, 1, "app_version_major", Integer.valueOf(zzkVar.zzb()));
                }
                zza(sb, 1, "firebase_instance_id", zzkVar.zzak());
                if (zzkVar.zzbj()) {
                    zza(sb, 1, "dev_cert_hash", Long.valueOf(zzkVar.zzl()));
                }
                zza(sb, 1, "app_store", zzkVar.zzad());
                if (zzkVar.zzca()) {
                    zza(sb, 1, "upload_timestamp_millis", Long.valueOf(zzkVar.zzt()));
                }
                if (zzkVar.zzbx()) {
                    zza(sb, 1, "start_timestamp_millis", Long.valueOf(zzkVar.zzr()));
                }
                if (zzkVar.zzbm()) {
                    zza(sb, 1, "end_timestamp_millis", Long.valueOf(zzkVar.zzn()));
                }
                if (zzkVar.zzbr()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzkVar.zzq()));
                }
                if (zzkVar.zzbq()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzkVar.zzp()));
                }
                zza(sb, 1, "app_instance_id", zzkVar.zzac());
                zza(sb, 1, "resettable_device_id", zzkVar.zzap());
                zza(sb, 1, "ds_id", zzkVar.zzaj());
                if (zzkVar.zzbp()) {
                    zza(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzkVar.zzax()));
                }
                zza(sb, 1, "os_version", zzkVar.zzan());
                zza(sb, 1, ProfilingTraceData.JsonKeys.DEVICE_MODEL, zzkVar.zzai());
                zza(sb, 1, "user_default_language", zzkVar.zzar());
                if (zzkVar.zzbz()) {
                    zza(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzkVar.zzh()));
                }
                if (zzkVar.zzbd()) {
                    zza(sb, 1, "bundle_sequential_index", Integer.valueOf(zzkVar.zzc()));
                }
                if (zzkVar.zzbi()) {
                    zza(sb, 1, "delivery_index", Integer.valueOf(zzkVar.zzd()));
                }
                if (zzkVar.zzbu()) {
                    zza(sb, 1, "service_upload", Boolean.valueOf(zzkVar.zzay()));
                }
                zza(sb, 1, "health_monitor", zzkVar.zzam());
                if (zzkVar.zzbt()) {
                    zza(sb, 1, "retry_counter", Integer.valueOf(zzkVar.zzg()));
                }
                if (zzkVar.zzbg()) {
                    zza(sb, 1, "consent_signals", zzkVar.zzag());
                }
                if (zzkVar.zzbo()) {
                    zza(sb, 1, "is_dma_region", Boolean.valueOf(zzkVar.zzaw()));
                }
                if (zzkVar.zzbh()) {
                    zza(sb, 1, "core_platform_services", zzkVar.zzah());
                }
                if (zzkVar.zzbf()) {
                    zza(sb, 1, "consent_diagnostics", zzkVar.zzaf());
                }
                if (zzkVar.zzby()) {
                    zza(sb, 1, "target_os_version", Long.valueOf(zzkVar.zzs()));
                }
                if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(zzkVar.zzab(), zzbn.zzcp)) {
                    zza(sb, 1, "ad_services_version", Integer.valueOf(zzkVar.zza()));
                    if (zzkVar.zzbb() && (zzcVarZzw = zzkVar.zzw()) != null) {
                        zza(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        zza(sb, 2, "eligible", Boolean.valueOf(zzcVarZzw.zzf()));
                        zza(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzcVarZzw.zzh()));
                        zza(sb, 2, "pre_r", Boolean.valueOf(zzcVarZzw.zzi()));
                        zza(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzcVarZzw.zzj()));
                        zza(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzcVarZzw.zze()));
                        zza(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzcVarZzw.zzd()));
                        zza(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzcVarZzw.zzg()));
                        zza(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (zzkVar.zzaz()) {
                    zzgf.zza zzaVarZzv = zzkVar.zzv();
                    zza(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (zzaVarZzv.zzn()) {
                        zza(sb, 2, "deep_link_gclid", zzaVarZzv.zzh());
                    }
                    if (zzaVarZzv.zzm()) {
                        zza(sb, 2, "deep_link_gbraid", zzaVarZzv.zzg());
                    }
                    if (zzaVarZzv.zzl()) {
                        zza(sb, 2, "deep_link_gad_source", zzaVarZzv.zzf());
                    }
                    if (zzaVarZzv.zzo()) {
                        zza(sb, 2, "deep_link_session_millis", Long.valueOf(zzaVarZzv.zza()));
                    }
                    if (zzaVarZzv.zzs()) {
                        zza(sb, 2, "market_referrer_gclid", zzaVarZzv.zzk());
                    }
                    if (zzaVarZzv.zzr()) {
                        zza(sb, 2, "market_referrer_gbraid", zzaVarZzv.zzj());
                    }
                    if (zzaVarZzv.zzq()) {
                        zza(sb, 2, "market_referrer_gad_source", zzaVarZzv.zzi());
                    }
                    if (zzaVarZzv.zzp()) {
                        zza(sb, 2, "market_referrer_click_millis", Long.valueOf(zzaVarZzv.zzb()));
                    }
                    zza(sb, 2);
                    sb.append("}\n");
                }
                if (zzkVar.zzbc()) {
                    zza(sb, 1, "batching_timestamp_millis", Long.valueOf(zzkVar.zzj()));
                }
                if (zzkVar.zzbw()) {
                    zzgf.zzo zzoVarZzz = zzkVar.zzz();
                    zza(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    zza(sb, 2, "upload_type", zzoVarZzz.zzd().name());
                    zza(sb, 2, "client_upload_eligibility", zzoVarZzz.zzb().name());
                    zza(sb, 2, "service_upload_eligibility", zzoVarZzz.zzc().name());
                    zza(sb, 2);
                    sb.append("}\n");
                }
                List<zzgf.zzp> listZzau = zzkVar.zzau();
                if (listZzau != null) {
                    for (zzgf.zzp zzpVar : listZzau) {
                        if (zzpVar != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            zza(sb, 2, "set_timestamp_millis", zzpVar.zzl() ? Long.valueOf(zzpVar.zzd()) : null);
                            zza(sb, 2, "name", zzi().zzc(zzpVar.zzg()));
                            zza(sb, 2, "string_value", zzpVar.zzh());
                            zza(sb, 2, "int_value", zzpVar.zzk() ? Long.valueOf(zzpVar.zzc()) : null);
                            zza(sb, 2, "double_value", zzpVar.zzi() ? Double.valueOf(zzpVar.zza()) : null);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzgf.zzd> listZzas = zzkVar.zzas();
                zzkVar.zzab();
                if (listZzas != null) {
                    for (zzgf.zzd zzdVar : listZzas) {
                        if (zzdVar != null) {
                            zza(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzdVar.zzg()) {
                                zza(sb, 2, "audience_id", Integer.valueOf(zzdVar.zza()));
                            }
                            if (zzdVar.zzh()) {
                                zza(sb, 2, "new_audience", Boolean.valueOf(zzdVar.zzf()));
                            }
                            zza(sb, 2, "current_data", zzdVar.zzd());
                            if (zzdVar.zzi()) {
                                zza(sb, 2, "previous_data", zzdVar.zze());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzgf.zzf> listZzat = zzkVar.zzat();
                if (listZzat != null) {
                    for (zzgf.zzf zzfVar : listZzat) {
                        if (zzfVar != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, "name", zzi().zza(zzfVar.zzg()));
                            if (zzfVar.zzk()) {
                                zza(sb, 2, "timestamp_millis", Long.valueOf(zzfVar.zzd()));
                            }
                            if (zzfVar.zzj()) {
                                zza(sb, 2, "previous_timestamp_millis", Long.valueOf(zzfVar.zzc()));
                            }
                            if (zzfVar.zzi()) {
                                zza(sb, 2, "count", Integer.valueOf(zzfVar.zza()));
                            }
                            if (zzfVar.zzb() != 0) {
                                zza(sb, 2, zzfVar.zzh());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    final String zza(zzfw.zzb zzbVar) {
        if (zzbVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzbVar.zzl()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzbVar.zzb()));
        }
        zza(sb, 0, "event_name", zzi().zza(zzbVar.zzf()));
        String strZza = zza(zzbVar.zzh(), zzbVar.zzi(), zzbVar.zzj());
        if (!strZza.isEmpty()) {
            zza(sb, 0, "filter_type", strZza);
        }
        if (zzbVar.zzk()) {
            zza(sb, 1, "event_count_filter", zzbVar.zze());
        }
        if (zzbVar.zza() > 0) {
            sb.append("  filters {\n");
            Iterator<zzfw.zzc> it = zzbVar.zzg().iterator();
            while (it.hasNext()) {
                zza(sb, 2, it.next());
            }
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    final String zza(zzfw.zze zzeVar) {
        if (zzeVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzeVar.zzi()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzeVar.zza()));
        }
        zza(sb, 0, "property_name", zzi().zzc(zzeVar.zze()));
        String strZza = zza(zzeVar.zzf(), zzeVar.zzg(), zzeVar.zzh());
        if (!strZza.isEmpty()) {
            zza(sb, 0, "filter_type", strZza);
        }
        zza(sb, 1, zzeVar.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    final List<Long> zza(List<Long> list, List<Integer> list2) throws IllegalStateException {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzj().zzr().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    zzj().zzr().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    final List<Integer> zzr() throws IllegalStateException, NumberFormatException {
        Map<String, String> mapZza = zzbn.zza(this.zzg.zza());
        if (mapZza == null || mapZza.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = zzbn.zzaz.zza(null).intValue();
        for (Map.Entry<String, String> entry : mapZza.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i = Integer.parseInt(entry.getValue());
                    if (i != 0) {
                        arrayList.add(Integer.valueOf(i));
                        if (arrayList.size() >= iIntValue) {
                            zzj().zzr().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzj().zzr().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 < bitSet.length()) {
                    if (bitSet.get(i3)) {
                        j |= 1 << i2;
                    }
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    final Map<String, Object> zza(Bundle bundle, boolean z) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zza((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayList2.get(i);
                            i++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zza((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zza((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    zzpj(zzou zzouVar) {
        super(zzouVar);
    }

    static void zza(zzgf.zzf.zza zzaVar, String str, Object obj) {
        List<zzgf.zzh> listZzf = zzaVar.zzf();
        int i = 0;
        while (true) {
            if (i >= listZzf.size()) {
                i = -1;
                break;
            } else if (str.equals(listZzf.get(i).zzg())) {
                break;
            } else {
                i++;
            }
        }
        zzgf.zzh.zza zzaVarZza = zzgf.zzh.zze().zza(str);
        if (obj instanceof Long) {
            zzaVarZza.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzaVarZza.zzb((String) obj);
        } else if (obj instanceof Double) {
            zzaVarZza.zza(((Double) obj).doubleValue());
        }
        if (i >= 0) {
            zzaVar.zza(i, zzaVarZza);
        } else {
            zzaVar.zza(zzaVarZza);
        }
    }

    private static void zza(Uri.Builder builder, String[] strArr, Bundle bundle, Set<String> set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zza(builder, str3, string, set);
            }
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzgf.zzm zzmVar) {
        if (zzmVar == null) {
            return;
        }
        zza(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzmVar.zzb() != 0) {
            zza(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : zzmVar.zzi()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zzmVar.zzd() != 0) {
            zza(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : zzmVar.zzk()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zzmVar.zza() != 0) {
            zza(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (zzgf.zze zzeVar : zzmVar.zzh()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(zzeVar.zzf() ? Integer.valueOf(zzeVar.zza()) : null).append(":").append(zzeVar.zze() ? Long.valueOf(zzeVar.zzb()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (zzmVar.zzc() != 0) {
            zza(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (zzgf.zzn zznVar : zzmVar.zzj()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zznVar.zzf() ? Integer.valueOf(zznVar.zzb()) : null).append(": [");
                Iterator<Long> it = zznVar.zze().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        zza(sb, 3);
        sb.append("}\n");
    }

    private final void zza(StringBuilder sb, int i, List<zzgf.zzh> list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        for (zzgf.zzh zzhVar : list) {
            if (zzhVar != null) {
                zza(sb, i2);
                sb.append("param {\n");
                zza(sb, i2, "name", zzhVar.zzm() ? zzi().zzb(zzhVar.zzg()) : null);
                zza(sb, i2, "string_value", zzhVar.zzn() ? zzhVar.zzh() : null);
                zza(sb, i2, "int_value", zzhVar.zzl() ? Long.valueOf(zzhVar.zzd()) : null);
                zza(sb, i2, "double_value", zzhVar.zzj() ? Double.valueOf(zzhVar.zza()) : null);
                if (zzhVar.zzc() > 0) {
                    zza(sb, i2, zzhVar.zzi());
                }
                zza(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private final void zza(StringBuilder sb, int i, zzfw.zzc zzcVar) {
        if (zzcVar == null) {
            return;
        }
        zza(sb, i);
        sb.append("filter {\n");
        if (zzcVar.zzg()) {
            zza(sb, i, "complement", Boolean.valueOf(zzcVar.zzf()));
        }
        if (zzcVar.zzi()) {
            zza(sb, i, "param_name", zzi().zzb(zzcVar.zze()));
        }
        if (zzcVar.zzj()) {
            int i2 = i + 1;
            zzfw.zzf zzfVarZzd = zzcVar.zzd();
            if (zzfVarZzd != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzfVarZzd.zzj()) {
                    zza(sb, i2, "match_type", zzfVarZzd.zzb().name());
                }
                if (zzfVarZzd.zzi()) {
                    zza(sb, i2, "expression", zzfVarZzd.zze());
                }
                if (zzfVarZzd.zzh()) {
                    zza(sb, i2, "case_sensitive", Boolean.valueOf(zzfVarZzd.zzg()));
                }
                if (zzfVarZzd.zza() > 0) {
                    zza(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str : zzfVarZzd.zzf()) {
                        zza(sb, i + 3);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzcVar.zzh()) {
            zza(sb, i + 1, "number_filter", zzcVar.zzc());
        }
        zza(sb, i);
        sb.append("}\n");
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzfw.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        zza(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzdVar.zzh()) {
            zza(sb, i, "comparison_type", zzdVar.zza().name());
        }
        if (zzdVar.zzj()) {
            zza(sb, i, "match_as_float", Boolean.valueOf(zzdVar.zzg()));
        }
        if (zzdVar.zzi()) {
            zza(sb, i, "comparison_value", zzdVar.zzd());
        }
        if (zzdVar.zzl()) {
            zza(sb, i, "min_comparison_value", zzdVar.zzf());
        }
        if (zzdVar.zzk()) {
            zza(sb, i, "max_comparison_value", zzdVar.zze());
        }
        zza(sb, i);
        sb.append("}\n");
    }

    private static void zza(Uri.Builder builder, String str, String str2, Set<String> set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zza(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
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

    final void zza(zzgf.zzh.zza zzaVar, Object obj) throws IllegalStateException {
        Preconditions.checkNotNull(obj);
        zzaVar.zze().zzc().zzb().zzd();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzgf.zzh.zza zzaVarZze = zzgf.zzh.zze();
                    for (String str : bundle.keySet()) {
                        zzgf.zzh.zza zzaVarZza = zzgf.zzh.zze().zza(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zzaVarZza.zza(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zzaVarZza.zzb((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zzaVarZza.zza(((Double) obj2).doubleValue());
                        }
                        zzaVarZze.zza(zzaVarZza);
                    }
                    if (zzaVarZze.zza() > 0) {
                        arrayList.add((zzgf.zzh) ((com.google.android.gms.internal.measurement.zzkg) zzaVarZze.zzaj()));
                    }
                }
            }
            zzaVar.zza(arrayList);
            return;
        }
        zzj().zzg().zza("Ignoring invalid (type) event param value", obj);
    }

    final void zza(zzgf.zzp.zza zzaVar, Object obj) throws IllegalStateException {
        Preconditions.checkNotNull(obj);
        zzaVar.zzc().zzb().zza();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
        } else {
            zzj().zzg().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    static boolean zza(zzbl zzblVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzblVar);
        Preconditions.checkNotNull(zzpVar);
        return (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzp)) ? false : true;
    }

    static boolean zza(List<Long> list, int i) {
        if (i < (list.size() << 6)) {
            return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
        }
        return false;
    }

    final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzb().currentTimeMillis() - j) > j2;
    }

    static boolean zzb(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzj().zzg().zza("Failed to gzip content", e);
            throw e;
        }
    }

    final byte[] zzc(byte[] bArr) throws IllegalStateException, IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzj().zzg().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    static Bundle[] zzb(List<zzgf.zzh> list) {
        ArrayList arrayList = new ArrayList();
        for (zzgf.zzh zzhVar : list) {
            if (zzhVar != null) {
                Bundle bundle = new Bundle();
                for (zzgf.zzh zzhVar2 : zzhVar.zzi()) {
                    if (zzhVar2.zzn()) {
                        bundle.putString(zzhVar2.zzg(), zzhVar2.zzh());
                    } else if (zzhVar2.zzl()) {
                        bundle.putLong(zzhVar2.zzg(), zzhVar2.zzd());
                    } else if (zzhVar2.zzj()) {
                        bundle.putDouble(zzhVar2.zzg(), zzhVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }
}
