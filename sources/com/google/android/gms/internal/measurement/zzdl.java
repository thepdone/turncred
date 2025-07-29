package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public interface zzdl extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(zzdq zzdqVar) throws RemoteException;

    void getAppInstanceId(zzdq zzdqVar) throws RemoteException;

    void getCachedAppInstanceId(zzdq zzdqVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzdq zzdqVar) throws RemoteException;

    void getCurrentScreenClass(zzdq zzdqVar) throws RemoteException;

    void getCurrentScreenName(zzdq zzdqVar) throws RemoteException;

    void getGmpAppId(zzdq zzdqVar) throws RemoteException;

    void getMaxUserProperties(String str, zzdq zzdqVar) throws RemoteException;

    void getSessionId(zzdq zzdqVar) throws RemoteException;

    void getTestFlag(zzdq zzdqVar, int i) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, zzdq zzdqVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(IObjectWrapper iObjectWrapper, zzdz zzdzVar, long j) throws RemoteException;

    void isDataCollectionEnabled(zzdq zzdqVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzdq zzdqVar, long j) throws RemoteException;

    void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException;

    void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException;

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException;

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException;

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdq zzdqVar, long j) throws RemoteException;

    void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, zzdq zzdqVar, long j) throws RemoteException;

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException;

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException;

    void performAction(Bundle bundle, zzdq zzdqVar, long j) throws RemoteException;

    void registerOnMeasurementEventListener(zzdw zzdwVar) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void retrieveAndUploadBatches(zzdr zzdrVar) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setConsent(Bundle bundle, long j) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException;

    void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzdw zzdwVar) throws RemoteException;

    void setInstanceIdProvider(zzdx zzdxVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setSgtmDebugInfo(Intent intent) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzdw zzdwVar) throws RemoteException;
}
