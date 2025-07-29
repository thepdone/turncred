package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzdn extends zzbu implements zzdl {
    zzdn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeLong(j);
        zzb(23, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, bundle);
        zzb(9, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeLong(j);
        zzb(43, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeLong(j);
        zzb(24, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void generateEventId(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(22, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getAppInstanceId(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(20, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCachedAppInstanceId(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(19, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getConditionalUserProperties(String str, String str2, zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, zzdqVar);
        zzb(10, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCurrentScreenClass(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(17, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCurrentScreenName(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(16, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getGmpAppId(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(21, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getMaxUserProperties(String str, zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        zzbw.zza(parcelB_, zzdqVar);
        zzb(6, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getSessionId(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(46, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getTestFlag(zzdq zzdqVar, int i) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        parcelB_.writeInt(i);
        zzb(38, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getUserProperties(String str, String str2, boolean z, zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, z);
        zzbw.zza(parcelB_, zzdqVar);
        zzb(5, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void initForTests(Map map) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeMap(map);
        zzb(37, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void initialize(IObjectWrapper iObjectWrapper, zzdz zzdzVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        zzbw.zza(parcelB_, zzdzVar);
        parcelB_.writeLong(j);
        zzb(1, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void isDataCollectionEnabled(zzdq zzdqVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdqVar);
        zzb(40, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, bundle);
        zzbw.zza(parcelB_, z);
        zzbw.zza(parcelB_, z2);
        parcelB_.writeLong(j);
        zzb(2, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzdq zzdqVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, bundle);
        zzbw.zza(parcelB_, zzdqVar);
        parcelB_.writeLong(j);
        zzb(3, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeInt(i);
        parcelB_.writeString(str);
        zzbw.zza(parcelB_, iObjectWrapper);
        zzbw.zza(parcelB_, iObjectWrapper2);
        zzbw.zza(parcelB_, iObjectWrapper3);
        zzb(33, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        zzbw.zza(parcelB_, bundle);
        parcelB_.writeLong(j);
        zzb(27, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        zzbw.zza(parcelB_, bundle);
        parcelB_.writeLong(j);
        zzb(53, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        parcelB_.writeLong(j);
        zzb(28, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        parcelB_.writeLong(j);
        zzb(54, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        parcelB_.writeLong(j);
        zzb(29, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        parcelB_.writeLong(j);
        zzb(55, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        parcelB_.writeLong(j);
        zzb(30, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        parcelB_.writeLong(j);
        zzb(56, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdq zzdqVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        zzbw.zza(parcelB_, zzdqVar);
        parcelB_.writeLong(j);
        zzb(31, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, zzdq zzdqVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        zzbw.zza(parcelB_, zzdqVar);
        parcelB_.writeLong(j);
        zzb(57, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        parcelB_.writeLong(j);
        zzb(25, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        parcelB_.writeLong(j);
        zzb(51, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        parcelB_.writeLong(j);
        zzb(26, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        parcelB_.writeLong(j);
        zzb(52, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void performAction(Bundle bundle, zzdq zzdqVar, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, bundle);
        zzbw.zza(parcelB_, zzdqVar);
        parcelB_.writeLong(j);
        zzb(32, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void registerOnMeasurementEventListener(zzdw zzdwVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdwVar);
        zzb(35, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeLong(j);
        zzb(12, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void retrieveAndUploadBatches(zzdr zzdrVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdrVar);
        zzb(58, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, bundle);
        parcelB_.writeLong(j);
        zzb(8, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, bundle);
        parcelB_.writeLong(j);
        zzb(44, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, bundle);
        parcelB_.writeLong(j);
        zzb(45, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, iObjectWrapper);
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeLong(j);
        zzb(15, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzebVar);
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeLong(j);
        zzb(50, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, z);
        zzb(39, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, bundle);
        zzb(42, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setEventInterceptor(zzdw zzdwVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdwVar);
        zzb(34, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setInstanceIdProvider(zzdx zzdxVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdxVar);
        zzb(18, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, z);
        parcelB_.writeLong(j);
        zzb(11, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeLong(j);
        zzb(13, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeLong(j);
        zzb(14, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, intent);
        zzb(48, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeLong(j);
        zzb(7, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, iObjectWrapper);
        zzbw.zza(parcelB_, z);
        parcelB_.writeLong(j);
        zzb(4, parcelB_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void unregisterOnMeasurementEventListener(zzdw zzdwVar) throws RemoteException {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zzdwVar);
        zzb(36, parcelB_);
    }
}
