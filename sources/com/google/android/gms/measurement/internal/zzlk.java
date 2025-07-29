package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlk implements Application.ActivityLifecycleCallbacks, zzll {
    private final /* synthetic */ zzju zza;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    static /* synthetic */ void zza(zzlk zzlkVar, boolean z, Uri uri, String str, String str2) throws IllegalStateException {
        Bundle bundleZza;
        Bundle bundleZza2;
        zzlkVar.zza.zzv();
        try {
            zzpn zzpnVarZzs = zzlkVar.zza.zzs();
            if (TextUtils.isEmpty(str2)) {
                bundleZza = null;
            } else if (str2.contains("gclid") || str2.contains("gbraid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id")) {
                bundleZza = zzpnVarZzs.zza(Uri.parse("https://google.com/search?" + str2));
                if (bundleZza != null) {
                    bundleZza.putString("_cis", "referrer");
                }
            } else {
                zzpnVarZzs.zzj().zzc().zza("Activity created with data 'referrer' without required params");
                bundleZza = null;
            }
            if (z && (bundleZza2 = zzlkVar.zza.zzs().zza(uri)) != null) {
                bundleZza2.putString("_cis", SDKConstants.PARAM_INTENT);
                if (!bundleZza2.containsKey("gclid") && bundleZza != null && bundleZza.containsKey("gclid")) {
                    bundleZza2.putString("_cer", String.format("gclid=%s", bundleZza.getString("gclid")));
                }
                zzlkVar.zza.zzc(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza2);
                zzlkVar.zza.zza.zza(str, bundleZza2);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            zzlkVar.zza.zzj().zzc().zza("Activity created with referrer", str2);
            if (zzlkVar.zza.zze().zza(zzbn.zzca)) {
                if (bundleZza != null) {
                    zzlkVar.zza.zzc(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza);
                    zzlkVar.zza.zza.zza(str, bundleZza);
                } else {
                    zzlkVar.zza.zzj().zzc().zza("Referrer does not contain valid parameters", str2);
                }
                zzlkVar.zza.zza("auto", "_ldl", (Object) null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                zzlkVar.zza.zzj().zzc().zza("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                zzlkVar.zza.zza("auto", "_ldl", (Object) str2, true);
            }
        } catch (RuntimeException e) {
            zzlkVar.zza.zzj().zzg().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    zzlk(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzeb.zza(activity), bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    @Override // com.google.android.gms.measurement.internal.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.measurement.zzeb r9, android.os.Bundle r10) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzju r0 = r8.zza     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            com.google.android.gms.measurement.internal.zzgo r0 = r0.zzj()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzq()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            java.lang.String r1 = "onActivityCreated"
            r0.zza(r1)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            android.content.Intent r0 = r9.zzc     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r0 != 0) goto L1d
            com.google.android.gms.measurement.internal.zzju r0 = r8.zza
            com.google.android.gms.measurement.internal.zzlz r0 = r0.zzp()
            r0.zza(r9, r10)
            return
        L1d:
            android.net.Uri r1 = r0.getData()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r1 == 0) goto L2a
            boolean r2 = r1.isHierarchical()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r2 == 0) goto L2a
            goto L42
        L2a:
            android.os.Bundle r1 = r0.getExtras()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r1 == 0) goto L41
            java.lang.String r2 = "com.android.vending.referral_url"
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r2 != 0) goto L41
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            goto L42
        L41:
            r1 = 0
        L42:
            r5 = r1
            if (r5 == 0) goto L83
            boolean r1 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r1 != 0) goto L4c
            goto L83
        L4c:
            com.google.android.gms.measurement.internal.zzju r1 = r8.zza     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            r1.zzs()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            boolean r0 = com.google.android.gms.measurement.internal.zzpn.zza(r0)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r0 == 0) goto L5a
            java.lang.String r0 = "gs"
            goto L5c
        L5a:
            java.lang.String r0 = "auto"
        L5c:
            r6 = r0
            java.lang.String r0 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            if (r10 != 0) goto L67
            r0 = 1
            goto L68
        L67:
            r0 = 0
        L68:
            r4 = r0
            com.google.android.gms.measurement.internal.zzju r0 = r8.zza     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            com.google.android.gms.measurement.internal.zzhv r0 = r0.zzl()     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            com.google.android.gms.measurement.internal.zzln r1 = new com.google.android.gms.measurement.internal.zzln     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            r2 = r1
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            r0.zzb(r1)     // Catch: java.lang.Throwable -> L8d java.lang.RuntimeException -> L8f
            com.google.android.gms.measurement.internal.zzju r0 = r8.zza
            com.google.android.gms.measurement.internal.zzlz r0 = r0.zzp()
            r0.zza(r9, r10)
            return
        L83:
            com.google.android.gms.measurement.internal.zzju r0 = r8.zza
            com.google.android.gms.measurement.internal.zzlz r0 = r0.zzp()
            r0.zza(r9, r10)
            return
        L8d:
            r0 = move-exception
            goto La9
        L8f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzju r1 = r8.zza     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.measurement.internal.zzgo r1 = r1.zzj()     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.zza(r2, r0)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.measurement.internal.zzju r0 = r8.zza
            com.google.android.gms.measurement.internal.zzlz r0 = r0.zzp()
            r0.zza(r9, r10)
            return
        La9:
            com.google.android.gms.measurement.internal.zzju r1 = r8.zza
            com.google.android.gms.measurement.internal.zzlz r1 = r1.zzp()
            r1.zza(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlk.zza(com.google.android.gms.internal.measurement.zzeb, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        this.zza.zzp().zza(zzebVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) throws IllegalStateException {
        zzb(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar) throws IllegalStateException {
        this.zza.zzp().zzb(zzebVar);
        zznx zznxVarZzr = this.zza.zzr();
        zznxVarZzr.zzl().zzb(new zznz(zznxVarZzr, zznxVarZzr.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) throws IllegalStateException {
        zzc(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzc(com.google.android.gms.internal.measurement.zzeb zzebVar) throws IllegalStateException {
        zznx zznxVarZzr = this.zza.zzr();
        zznxVarZzr.zzl().zzb(new zznw(zznxVarZzr, zznxVarZzr.zzb().elapsedRealtime()));
        this.zza.zzp().zzc(zzebVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzb(com.google.android.gms.internal.measurement.zzeb.zza(activity), bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        this.zza.zzp().zzb(zzebVar, bundle);
    }
}
