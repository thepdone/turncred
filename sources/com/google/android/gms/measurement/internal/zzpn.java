package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nimbusds.jose.jwk.JWKParameterNames;
import expo.modules.contacts.Columns;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzpn extends zzji {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd;
    private int zze;
    private MeasurementManagerFutures zzf;
    private Boolean zzg;
    private Integer zzh;

    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zza(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List<java.lang.String> r19, boolean r20, boolean r21) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpn.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    @Override // com.google.android.gms.measurement.internal.zzji
    protected final boolean zzh() {
        return true;
    }

    final int zza(String str, Object obj) {
        boolean zZza;
        if ("_ldl".equals(str)) {
            zZza = zza("user property referrer", str, zzk(str), obj);
        } else {
            zZza = zza("user property", str, zzk(str), obj);
        }
        return zZza ? 0 : 7;
    }

    final int zza(String str) {
        if (!zzb(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (zza(NotificationCompat.CATEGORY_EVENT, zzjp.zza, zzjp.zzb, str)) {
            return !zza(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
        }
        return 13;
    }

    private final int zzi(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private final int zzj(String str) {
        if (!zzc("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    final int zzb(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (zza("user property", zzjr.zza, str)) {
            return !zza("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    static int zzc() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzg() {
        if (this.zzh == null) {
            this.zzh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zza()) / 1000);
        }
        return this.zzh.intValue();
    }

    private static int zzk(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if (Columns.ID.equals(str)) {
            return 256;
        }
        return "_lgclid".equals(str) ? 100 : 36;
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zza(), 12451000);
    }

    final long zzc(String str) throws IllegalStateException {
        if (zza().getPackageManager() == null) {
            return 0L;
        }
        int i = 0;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                i = applicationInfo.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            zzj().zzp().zza("PackageManager failed to find running app: app_id", str);
        }
        return i;
    }

    final long zzm() {
        long j;
        zzv();
        if (!zzd(this.zzu.zzh().zzaf())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j = 8;
        } else {
            j = zzc() < zzbn.zzbf.zza(null).intValue() ? 16L : 0L;
        }
        if (!zze("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0 && !zzz()) {
            j |= 64;
        }
        if (j == 0) {
            return 1L;
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0069 -> B:18:0x0076). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final long zza(android.content.Context r7, java.lang.String r8) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException {
        /*
            r6 = this;
            r6.zzv()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            android.content.pm.PackageManager r0 = r7.getPackageManager()
            java.security.MessageDigest r1 = zzr()
            r2 = -1
            if (r1 != 0) goto L23
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()
            java.lang.String r8 = "Could not get MD5 instance"
            r7.zza(r8)
            goto L77
        L23:
            r4 = 0
            if (r0 == 0) goto L76
            boolean r8 = r6.zzc(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            if (r8 != 0) goto L76
            com.google.android.gms.common.wrappers.PackageManagerWrapper r7 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            android.content.Context r8 = r6.zza()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            java.lang.String r8 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            r0 = 64
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            android.content.pm.Signature[] r8 = r7.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            if (r8 == 0) goto L5a
            android.content.pm.Signature[] r8 = r7.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            int r8 = r8.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            if (r8 <= 0) goto L5a
            android.content.pm.Signature[] r7 = r7.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            r8 = 0
            r7 = r7[r8]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            byte[] r7 = r1.digest(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            long r2 = zza(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            goto L77
        L5a:
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzr()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            java.lang.String r8 = "Could not get signatures"
            r7.zza(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L68
            goto L77
        L68:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzg()
            java.lang.String r0 = "Package name not found"
            r8.zza(r0, r7)
        L76:
            r2 = r4
        L77:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpn.zza(android.content.Context, java.lang.String):long");
    }

    static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (bArr[length] & 255) << i;
            i += 8;
        }
        return j;
    }

    public static long zza(zzbg zzbgVar) {
        long length = 0;
        if (zzbgVar == null) {
            return 0L;
        }
        Iterator<String> it = zzbgVar.iterator();
        while (it.hasNext()) {
            if (zzbgVar.zzc(it.next()) instanceof Parcelable[]) {
                length += ((Parcelable[]) r3).length;
            }
        }
        return length;
    }

    public final long zzo() {
        long andIncrement;
        long j;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long jNextLong = new Random(System.nanoTime() ^ zzb().currentTimeMillis()).nextLong();
                int i = this.zze + 1;
                this.zze = i;
                j = jNextLong + i;
            }
            return j;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1L, 1L);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    public static long zza(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public static Bundle zza(List<zzpm> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzpm zzpmVar : list) {
            if (zzpmVar.zzd != null) {
                bundle.putString(zzpmVar.zza, zzpmVar.zzd);
            } else if (zzpmVar.zzc != null) {
                bundle.putLong(zzpmVar.zza, zzpmVar.zzc.longValue());
            } else if (zzpmVar.zzf != null) {
                bundle.putDouble(zzpmVar.zza, zzpmVar.zzf.doubleValue());
            }
        }
        return bundle;
    }

    final Bundle zza(Uri uri) throws IllegalStateException {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzj().zzr().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public static Bundle zza(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    final Bundle zza(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objZzb = zzb(str2, bundle.get(str2));
                if (objZzb == null) {
                    zzj().zzw().zza("Param value can't be null", zzi().zzb(str2));
                } else {
                    zza(bundle2, str2, objZzb);
                }
            }
        }
        return bundle2;
    }

    final Bundle zza(String str, String str2, Bundle bundle, List<String> list, boolean z) {
        int iZzj;
        int i;
        zzpn zzpnVar = this;
        boolean zZza = zza(str2, zzjp.zzd);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iZzc = zze().zzc();
        int i2 = 0;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str3)) {
                iZzj = !z ? zzpnVar.zzj(str3) : 0;
                if (iZzj == 0) {
                    iZzj = zzpnVar.zzi(str3);
                }
            } else {
                iZzj = 0;
            }
            if (iZzj != 0) {
                zza(bundle2, iZzj, str3, iZzj == 3 ? str3 : null);
                bundle2.remove(str3);
                i = iZzc;
            } else {
                i = iZzc;
                int iZza = zza(str, str2, str3, bundle.get(str3), bundle2, list, z, zZza);
                if (iZza == 17) {
                    zza(bundle2, iZza, str3, (Object) false);
                } else if (iZza != 0 && !"_ev".equals(str3)) {
                    zza(bundle2, iZza, iZza == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (zzg(str3)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        zzj().zzm().zza("Event can't contain more than " + i + " params", zzi().zza(str2), zzi().zza(bundle));
                        zzb(bundle2, 5);
                        bundle2.remove(str3);
                    }
                    i2 = i3;
                }
            }
            iZzc = i;
            zzpnVar = this;
        }
        return bundle2;
    }

    final MeasurementManagerFutures zzp() {
        if (this.zzf == null) {
            this.zzf = MeasurementManagerFutures.from(zza());
        }
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    final zzbl zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zza(str2) != 0) {
            zzj().zzg().zza("Invalid conditional property event name", zzi().zzc(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleZza = zza(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
        if (z) {
            bundleZza = zza(bundleZza, str);
        }
        Preconditions.checkNotNull(bundleZza);
        return new zzbl(str2, new zzbg(bundleZza), str3, j);
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

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    final Object zzb(String str, Object obj) {
        int iZza;
        if ("_ev".equals(str)) {
            return zza(zze().zzb((String) null, false), obj, true, true, (String) null);
        }
        if (zzf(str)) {
            iZza = zze().zzb((String) null, false);
        } else {
            iZza = zze().zza((String) null, false);
        }
        return zza(iZza, obj, false, true, (String) null);
    }

    final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzk(str), obj, true, false, (String) null);
        }
        return zza(zzk(str), obj, false, false, (String) null);
    }

    private final Object zza(int i, Object obj, boolean z, boolean z2, String str) {
        Bundle bundleZza;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zza(String.valueOf(obj), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if ((parcelable instanceof Bundle) && (bundleZza = zza((Bundle) parcelable, (String) null)) != null && !bundleZza.isEmpty()) {
                arrayList.add(bundleZza);
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    final String zzq() {
        byte[] bArr = new byte[16];
        zzw().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (!z) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i)) + "...";
    }

    public final URL zza(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j), Integer.valueOf(zzg())), str2, str, Long.valueOf(j2));
            if (str.equals(zze().zzq())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzj().zzg().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    static MessageDigest zzr() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    @EnsuresNonNull({"this.secureRandom"})
    final SecureRandom zzw() {
        zzv();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public static ArrayList<Bundle> zzb(List<zzag> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzag zzagVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzagVar.zza);
            bundle.putString("origin", zzagVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzagVar.zzd);
            bundle.putString("name", zzagVar.zzc.zza);
            zzjk.zza(bundle, Preconditions.checkNotNull(zzagVar.zzc.zza()));
            bundle.putBoolean("active", zzagVar.zze);
            if (zzagVar.zzf != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzagVar.zzf);
            }
            if (zzagVar.zzg != null) {
                zzbl zzblVar = zzagVar.zzg;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzblVar.zza);
                if (zzblVar.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzblVar.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzagVar.zzh);
            if (zzagVar.zzi != null) {
                zzbl zzblVar2 = zzagVar.zzi;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzblVar2.zza);
                if (zzblVar2.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzblVar2.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzagVar.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzagVar.zzj);
            if (zzagVar.zzk != null) {
                zzbl zzblVar3 = zzagVar.zzk;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzblVar3.zza);
                if (zzblVar3.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzblVar3.zzb.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    zzpn(zzic zzicVar) {
        super(zzicVar);
        this.zzh = null;
        this.zzd = new AtomicLong(0L);
    }

    final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzj().zzr().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    private static void zza(Bundle bundle, int i, String str, Object obj) {
        if (zzb(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if (obj != null) {
                    if ((obj instanceof String) || (obj instanceof CharSequence)) {
                        bundle.putLong("_el", String.valueOf(obj).length());
                    }
                }
            }
        }
    }

    public static void zza(zzlw zzlwVar, Bundle bundle, boolean z) {
        if (bundle == null || zzlwVar == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zzlwVar == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        if (zzlwVar.zza != null) {
            bundle.putString("_sn", zzlwVar.zza);
        } else {
            bundle.remove("_sn");
        }
        if (zzlwVar.zzb != null) {
            bundle.putString("_sc", zzlwVar.zzb);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zzlwVar.zzc);
    }

    final void zza(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                zzs().zza(bundle, str, bundle2.get(str));
            }
        }
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

    final void zza(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i2 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzg(str) && !zza(str, zzjo.zzd) && (i2 = i2 + 1) > i) {
                    zzj().zzm().zza("Param can't contain more than " + i + " item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                    zzb(bundle, 28);
                    bundle.remove(str);
                }
            }
        }
    }

    final void zza(zzgs zzgsVar, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzgsVar.zzc.keySet())) {
            if (zzg(str) && (i2 = i2 + 1) > i) {
                zzj().zzm().zza("Event can't contain more than " + i + " params", zzi().zza(zzgsVar.zza), zzi().zza(zzgsVar.zzc));
                zzb(zzgsVar.zzc, 5);
                zzgsVar.zzc.remove(str);
            }
        }
    }

    public static void zza(zzpp zzppVar, int i, String str, String str2, int i2) {
        zza(zzppVar, (String) null, i, str, str2, i2);
    }

    static void zza(zzpp zzppVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzb(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzppVar.zza(str, "_err", bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzji
    protected final void zzab() throws IllegalStateException {
        zzv();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                zzj().zzr().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(jNextLong);
    }

    final void zza(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            zzj().zzw().zza("Not putting event parameter. Invalid value type. name, type", zzi().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, boolean z) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putBoolean(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, z);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzr().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, ArrayList<Bundle> arrayList) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, arrayList);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzr().zza("Error returning bundle list to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, Bundle bundle) throws IllegalStateException {
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzr().zza("Error returning bundle value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, byte[] bArr) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putByteArray(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, bArr);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzr().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, int i) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putInt(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, i);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzr().zza("Error returning int value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, long j) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putLong(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, j);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzr().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str) throws IllegalStateException {
        Bundle bundle = new Bundle();
        bundle.putString(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, str);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzr().zza("Error returning string value to wrapper", e);
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) throws IllegalStateException {
        int iZzj;
        int i;
        String str4;
        int iZza;
        int i2;
        if (bundle == null) {
            return;
        }
        int i3 = zze().zzs().zza(231100000, true) ? 35 : 0;
        int i4 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                iZzj = !z ? zzj(str5) : 0;
                if (iZzj == 0) {
                    iZzj = zzi(str5);
                }
            } else {
                iZzj = 0;
            }
            if (iZzj != 0) {
                zza(bundle, iZzj, str5, iZzj == 3 ? str5 : null);
                bundle.remove(str5);
                i = i3;
            } else {
                if (zza(bundle.get(str5))) {
                    zzj().zzw().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    iZza = 22;
                    str4 = str5;
                    i = i3;
                } else {
                    str4 = str5;
                    i = i3;
                    iZza = zza(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (iZza != 0 && !"_ev".equals(str4)) {
                    zza(bundle, iZza, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else {
                    if (!zzg(str4) || zza(str4, zzjo.zzd)) {
                        i2 = i;
                    } else {
                        int i5 = i4 + 1;
                        if (zza(231100000, true)) {
                            i2 = i;
                            if (i5 > i2) {
                                zzj().zzm().zza("Item can't contain more than " + i2 + " item-scoped custom params", zzi().zza(str2), zzi().zza(bundle));
                                zzb(bundle, 28);
                                bundle.remove(str4);
                            }
                        } else {
                            zzj().zzm().zza("Item array not supported on client's version of Google Play Services (Android Only)", zzi().zza(str2), zzi().zza(bundle));
                            zzb(bundle, 23);
                            bundle.remove(str4);
                            i2 = i;
                        }
                        i4 = i5;
                    }
                    i3 = i2;
                }
            }
            i3 = i;
        }
    }

    private static boolean zzb(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    static boolean zzd(String str) {
        String strZza = zzbn.zzbl.zza(null);
        return strZza.equals(ProxyConfig.MATCH_ALL_SCHEMES) || Arrays.asList(strZza.split(",")).contains(str);
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    final boolean zza(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzl(str)) {
                return true;
            }
            if (this.zzu.zzag()) {
                zzj().zzm().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgo.zza(str));
            }
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (zzl(str2)) {
                return true;
            }
            zzj().zzm().zza("Invalid admob_app_id. Analytics disabled.", zzgo.zza(str2));
            return false;
        }
        if (this.zzu.zzag()) {
            zzj().zzm().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    final boolean zza(String str, int i, String str2) throws IllegalStateException {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        zzj().zzm().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    final boolean zza(String str, String[] strArr, String str2) {
        return zza(str, strArr, (String[]) null, str2);
    }

    final boolean zza(String str, String[] strArr, String[] strArr2, String str2) throws IllegalStateException {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        for (String str3 : zza) {
            if (str2.startsWith(str3)) {
                zzj().zzm().zza("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zza(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zza(str2, strArr2)) {
            return true;
        }
        zzj().zzm().zza("Name is reserved. Type, name", str, str2);
        return false;
    }

    final boolean zza(String str, String str2, int i, Object obj) throws IllegalStateException {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i) {
                zzj().zzw().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    final boolean zzb(String str, String str2) throws IllegalStateException {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzm().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            zzj().zzm().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().zzm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final boolean zzc(String str, String str2) throws IllegalStateException {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzm().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            zzj().zzm().zza("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().zzm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    static boolean zza(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzz() throws java.lang.IllegalStateException {
        /*
            r7 = this;
            java.lang.Boolean r0 = r7.zzg
            if (r0 != 0) goto L5f
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r0 = r7.zzp()
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            com.google.common.util.concurrent.ListenableFuture r0 = r0.getMeasurementApiStatusAsync()
            r2 = 0
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L35 java.lang.InterruptedException -> L37 java.util.concurrent.ExecutionException -> L39 java.util.concurrent.CancellationException -> L3b
            r4 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r0 = r0.get(r4, r3)     // Catch: java.util.concurrent.TimeoutException -> L35 java.lang.InterruptedException -> L37 java.util.concurrent.ExecutionException -> L39 java.util.concurrent.CancellationException -> L3b
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.util.concurrent.TimeoutException -> L35 java.lang.InterruptedException -> L37 java.util.concurrent.ExecutionException -> L39 java.util.concurrent.CancellationException -> L3b
            if (r0 == 0) goto L2d
            int r2 = r0.intValue()     // Catch: java.util.concurrent.TimeoutException -> L25 java.lang.InterruptedException -> L27 java.util.concurrent.ExecutionException -> L29 java.util.concurrent.CancellationException -> L2b
            r3 = 1
            if (r2 != r3) goto L2d
            goto L2e
        L25:
            r2 = move-exception
            goto L3f
        L27:
            r2 = move-exception
            goto L3f
        L29:
            r2 = move-exception
            goto L3f
        L2b:
            r2 = move-exception
            goto L3f
        L2d:
            r3 = r1
        L2e:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)     // Catch: java.util.concurrent.TimeoutException -> L25 java.lang.InterruptedException -> L27 java.util.concurrent.ExecutionException -> L29 java.util.concurrent.CancellationException -> L2b
            r7.zzg = r2     // Catch: java.util.concurrent.TimeoutException -> L25 java.lang.InterruptedException -> L27 java.util.concurrent.ExecutionException -> L29 java.util.concurrent.CancellationException -> L2b
            goto L52
        L35:
            r0 = move-exception
            goto L3c
        L37:
            r0 = move-exception
            goto L3c
        L39:
            r0 = move-exception
            goto L3c
        L3b:
            r0 = move-exception
        L3c:
            r6 = r2
            r2 = r0
            r0 = r6
        L3f:
            com.google.android.gms.measurement.internal.zzgo r3 = r7.zzj()
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzr()
            java.lang.String r4 = "Measurement manager api exception"
            r3.zza(r4, r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r7.zzg = r1
        L52:
            com.google.android.gms.measurement.internal.zzgo r1 = r7.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzq()
            java.lang.String r2 = "Measurement manager api status result"
            r1.zza(r2, r0)
        L5f:
            java.lang.Boolean r0 = r7.zzg
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpn.zzz():boolean");
    }

    final boolean zze(String str) throws IllegalStateException {
        zzv();
        if (Wrappers.packageManager(zza()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzj().zzc().zza("Permission not granted", str);
        return false;
    }

    final boolean zzd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zze().zzp().equals(str);
    }

    static boolean zza(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    private final boolean zzc(Context context, String str) throws IllegalStateException {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            zzj().zzg().zza("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            zzj().zzg().zza("Error obtaining certificate", e2);
            return true;
        }
    }

    final boolean zzx() {
        zzv();
        return zzm() == 1;
    }

    public final boolean zzy() throws ClassNotFoundException {
        try {
            zza().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean zza(int i, boolean z) {
        Boolean boolZzad = this.zzu.zzt().zzad();
        if (zzg() < i / 1000) {
            return (boolZzad == null || boolZzad.booleanValue()) ? false : true;
        }
        return true;
    }

    static boolean zzf(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzg(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    static boolean zzb(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzb(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    final boolean zza(String str, double d) throws IllegalStateException {
        try {
            SharedPreferences.Editor editorEdit = zza().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return editorEdit.commit();
        } catch (RuntimeException e) {
            zzj().zzg().zza("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean zzh(String str) {
        for (String str2 : zzb) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private static boolean zzl(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    static Bundle[] zzb(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }
}
