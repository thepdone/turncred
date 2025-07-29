package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import io.sentry.SentryLockReason;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzhj {
    final zzic zza;

    final Bundle zza(String str, com.google.android.gms.internal.measurement.zzbz zzbzVar) throws IllegalStateException {
        this.zza.zzl().zzv();
        if (zzbzVar == null) {
            this.zza.zzj().zzr().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(SentryLockReason.JsonKeys.PACKAGE_NAME, str);
        try {
            Bundle bundleZza = zzbzVar.zza(bundle);
            if (bundleZza != null) {
                return bundleZza;
            }
            this.zza.zzj().zzg().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zza.zzj().zzg().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    zzhj(zzou zzouVar) {
        this.zza = zzouVar.zzk();
    }

    final boolean zza() throws IllegalStateException {
        try {
            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(this.zza.zza());
            if (packageManagerWrapperPackageManager != null) {
                return packageManagerWrapperPackageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.zza.zzj().zzq().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.zza.zzj().zzq().zza("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
