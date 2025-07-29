package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public class GoogleSignatureVerifier {

    @Nullable
    private static GoogleSignatureVerifier zza;

    @Nullable
    private static volatile Set zzb;

    @Nullable
    private static volatile Set zzc;
    private final Context zzd;
    private volatile String zze;

    public GoogleSignatureVerifier(Context context) {
        this.zzd = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzn.zze(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjVarArr.length; i++) {
                if (zzjVarArr[i].equals(zzkVar)) {
                    return zzjVarArr[i];
                }
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z ? zza(packageInfo2, zzm.zza) : zza(packageInfo2, zzm.zza[0])) != null) {
                return true;
            }
        }
        return false;
    }

    private final zzw zzc(@Nullable String str, boolean z, boolean z2) throws PackageManager.NameNotFoundException {
        zzw zzwVarZzc;
        if (str == null) {
            return zzw.zzc("null pkg");
        }
        if (str.equals(this.zze)) {
            return zzw.zzb();
        }
        if (zzn.zzg()) {
            zzwVarZzc = zzn.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzd.getPackageManager().getPackageInfo(str, 64);
                boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd);
                if (packageInfo == null) {
                    zzwVarZzc = zzw.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzwVarZzc = zzw.zzc("single cert required");
                } else {
                    zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzw zzwVarZza = zzn.zza(str2, zzkVar, zHonorsDebugCertificates, false);
                    zzwVarZzc = (!zzwVarZza.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzn.zza(str2, zzkVar, false, true).zza) ? zzwVarZza : zzw.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzw.zzd("no pkg ".concat(str), e);
            }
        }
        if (zzwVarZzc.zza) {
            this.zze = str;
        }
        return zzwVarZzc;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String str) throws PackageManager.NameNotFoundException {
        zzw zzwVarZzc = zzc(str, false, false);
        zzwVarZzc.zze();
        return zzwVarZzc.zza;
    }

    public boolean isUidGoogleSigned(int i) throws PackageManager.NameNotFoundException {
        zzw zzwVarZzc;
        int length;
        String[] packagesForUid = this.zzd.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzwVarZzc = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzwVarZzc);
                    break;
                }
                zzwVarZzc = zzc(packagesForUid[i2], false, false);
                if (zzwVarZzc.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzwVarZzc = zzw.zzc("no pkgs");
        }
        zzwVarZzc.zze();
        return zzwVarZzc.zza;
    }
}
