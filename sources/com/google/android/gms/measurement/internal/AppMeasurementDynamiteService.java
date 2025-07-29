package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.nimbusds.jose.jwk.JWKParameterNames;
import io.sentry.protocol.App;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.2.0 */
/* loaded from: classes3.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzdo {
    zzic zza = null;
    private final Map<Integer, zzjt> zzb = new ArrayMap();

    public static /* synthetic */ void $r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdr zzdrVar) throws IllegalStateException {
        try {
            zzdrVar.a_();
        } catch (RemoteException e) {
            ((zzic) Preconditions.checkNotNull(appMeasurementDynamiteService.zza)).zzj().zzr().zza("Failed to call IDynamiteUploadBatchesCallback", e);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.2.0 */
    class zza implements zzjq {
        private com.google.android.gms.internal.measurement.zzdw zza;

        zza(com.google.android.gms.internal.measurement.zzdw zzdwVar) {
            this.zza = zzdwVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzjq
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) throws IllegalStateException {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzr().zza("Event interceptor threw exception", e);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@22.2.0 */
    class zzb implements zzjt {
        private com.google.android.gms.internal.measurement.zzdw zza;

        zzb(com.google.android.gms.internal.measurement.zzdw zzdwVar) {
            this.zza = zzdwVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzjt
        public final void onEvent(String str, String str2, Bundle bundle, long j) throws IllegalStateException {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzr().zza("Event listener threw exception", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void beginAdUnitExposure(String str, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zze().zza(str, j);
    }

    @EnsuresNonNull({"scion"})
    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void clearMeasurementEnabled(long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza((Boolean) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void endAdUnitExposure(String str, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zze().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void generateEventId(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        long jZzo = this.zza.zzv().zzo();
        zza();
        this.zza.zzv().zza(zzdqVar, jZzo);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzl().zzb(new zzi(this, zzdqVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        zza(zzdqVar, this.zza.zzp().zzai());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzl().zzb(new zzm(this, zzdqVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        zza(zzdqVar, this.zza.zzp().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        zza(zzdqVar, this.zza.zzp().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        zza(zzdqVar, this.zza.zzp().zzal());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp();
        zzju.zza(str);
        zza();
        this.zza.zzv().zza(zzdqVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getSessionId(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(zzdqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getTestFlag(com.google.android.gms.internal.measurement.zzdq zzdqVar, int i) throws IllegalStateException, RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzam());
            return;
        }
        if (i == 1) {
            this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzah().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzag().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzae().booleanValue());
                return;
            }
        }
        zzpn zzpnVarZzv = this.zza.zzv();
        double dDoubleValue = this.zza.zzp().zzaf().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, dDoubleValue);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            zzpnVarZzv.zzu.zzj().zzr().zza("Error returning double value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzl().zzb(new zzk(this, zzdqVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdz zzdzVar, long j) throws IllegalStateException, RemoteException {
        zzic zzicVar = this.zza;
        if (zzicVar == null) {
            this.zza = zzic.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdzVar, Long.valueOf(j));
        } else {
            zzicVar.zzj().zzr().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzl().zzb(new zzo(this, zzdqVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j) throws IllegalStateException, RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", App.TYPE);
        this.zza.zzl().zzb(new zzl(this, zzdqVar, new zzbl(str2, new zzbg(bundle), App.TYPE, j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzj().zza(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle, long j) {
        zza();
        zzll zzllVarZzad = this.zza.zzp().zzad();
        if (zzllVarZzad != null) {
            this.zza.zzp().zzar();
            zzllVarZzad.zza(zzebVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j) throws RemoteException {
        zza();
        zzll zzllVarZzad = this.zza.zzp().zzad();
        if (zzllVarZzad != null) {
            this.zza.zzp().zzar();
            zzllVarZzad.zza(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j) throws RemoteException {
        zza();
        zzll zzllVarZzad = this.zza.zzp().zzad();
        if (zzllVarZzad != null) {
            this.zza.zzp().zzar();
            zzllVarZzad.zzb(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j) throws RemoteException {
        zza();
        zzll zzllVarZzad = this.zza.zzp().zzad();
        if (zzllVarZzad != null) {
            this.zza.zzp().zzar();
            zzllVarZzad.zzc(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j) throws IllegalStateException, RemoteException {
        zza();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), zzdqVar, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j) throws IllegalStateException, RemoteException {
        zza();
        zzll zzllVarZzad = this.zza.zzp().zzad();
        Bundle bundle = new Bundle();
        if (zzllVarZzad != null) {
            this.zza.zzp().zzar();
            zzllVarZzad.zzb(zzebVar, bundle);
        }
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzj().zzr().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j) throws RemoteException {
        zza();
        if (this.zza.zzp().zzad() != null) {
            this.zza.zzp().zzar();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j) throws RemoteException {
        zza();
        if (this.zza.zzp().zzad() != null) {
            this.zza.zzp().zzar();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j) throws RemoteException {
        zza();
        zzdqVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdw zzdwVar) throws IllegalStateException, RemoteException {
        zzjt zzbVar;
        zza();
        synchronized (this.zzb) {
            zzbVar = this.zzb.get(Integer.valueOf(zzdwVar.zza()));
            if (zzbVar == null) {
                zzbVar = new zzb(zzdwVar);
                this.zzb.put(Integer.valueOf(zzdwVar.zza()), zzbVar);
            }
        }
        this.zza.zzp().zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void resetAnalyticsData(long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzdr zzdrVar) throws IllegalStateException {
        zza();
        if (this.zza.zzf().zzf(null, zzbn.zzcl)) {
            this.zza.zzp().zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzj
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    AppMeasurementDynamiteService.$r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(this.zza, zzdrVar);
                }
            });
        }
    }

    private final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str) throws IllegalStateException {
        zza();
        this.zza.zzv().zza(zzdqVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setConditionalUserProperty(Bundle bundle, long j) throws IllegalStateException, RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.zza.zzp().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setConsent(Bundle bundle, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zzb(bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setConsentThirdParty(Bundle bundle, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zzc(bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws IllegalStateException, RemoteException {
        zza();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), str, str2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, String str, String str2, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzs().zza(zzebVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setDataCollectionEnabled(boolean z) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zzc(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setDefaultEventParameters(Bundle bundle) throws IllegalStateException {
        zza();
        this.zza.zzp().zzb(bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzdw zzdwVar) throws IllegalStateException, RemoteException {
        zza();
        zza zzaVar = new zza(zzdwVar);
        if (this.zza.zzl().zzm()) {
            this.zza.zzp().zza(zzaVar);
        } else {
            this.zza.zzl().zzb(new zzn(this, zzaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdx zzdxVar) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setMeasurementEnabled(boolean z, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setSessionTimeoutDuration(long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zzd(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setSgtmDebugInfo(Intent intent) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(intent);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setUserId(String str, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws IllegalStateException, RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdw zzdwVar) throws IllegalStateException, RemoteException {
        zzjt zzjtVarRemove;
        zza();
        synchronized (this.zzb) {
            zzjtVarRemove = this.zzb.remove(Integer.valueOf(zzdwVar.zza()));
        }
        if (zzjtVarRemove == null) {
            zzjtVarRemove = new zzb(zzdwVar);
        }
        this.zza.zzp().zzb(zzjtVarRemove);
    }
}
