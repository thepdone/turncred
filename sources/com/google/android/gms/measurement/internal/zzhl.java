package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzhl implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzbz zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzhi zzc;

    zzhl(zzhi zzhiVar, com.google.android.gms.internal.measurement.zzbz zzbzVar, ServiceConnection serviceConnection) {
        this.zza = zzbzVar;
        this.zzb = serviceConnection;
        this.zzc = zzhiVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzhj zzhjVar = this.zzc.zza;
        String str = this.zzc.zzb;
        com.google.android.gms.internal.measurement.zzbz zzbzVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle bundleZza = zzhjVar.zza(str, zzbzVar);
        zzhjVar.zza.zzl().zzv();
        zzhjVar.zza.zzaa();
        if (bundleZza != null) {
            long j = bundleZza.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzhjVar.zza.zzj().zzr().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleZza.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzhjVar.zza.zzj().zzg().zza("No referrer defined in Install Referrer response");
                } else {
                    zzhjVar.zza.zzj().zzq().zza("InstallReferrer API result", string);
                    Bundle bundleZza2 = zzhjVar.zza.zzv().zza(Uri.parse("?" + string));
                    if (bundleZza2 == null) {
                        zzhjVar.zza.zzj().zzg().zza("No campaign params defined in Install Referrer result");
                    } else {
                        if (bundleZza2.containsKey("gclid") || bundleZza2.containsKey("gbraid")) {
                            long j2 = bundleZza.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                            if (j2 > 0) {
                                bundleZza2.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzhjVar.zza.zzn().zzd.zza()) {
                            zzhjVar.zza.zzj().zzq().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzhjVar.zza.zzae()) {
                            zzhjVar.zza.zzn().zzd.zza(j);
                            zzhjVar.zza.zzj().zzq().zza("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            bundleZza2.putString("_cis", "referrer API v2");
                            zzhjVar.zza.zzp().zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza2, str);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzhjVar.zza.zza(), serviceConnection);
        }
    }
}
