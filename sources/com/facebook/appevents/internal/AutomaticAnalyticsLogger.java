package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.iap.InAppPurchase;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AutomaticAnalyticsLogger.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J>\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J0\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J0\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\u001e\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020#H\u0007J\u001a\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020'H\u0007J4\u0010(\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010)\u001a\u00020!2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010*\u001a\u00020!H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger;", "", "()V", "APP_EVENTS_IF_AUTO_LOG_SUBS", "", "TAG", "kotlin.jvm.PlatformType", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "getPurchaseDedupeParameters", "Landroid/os/Bundle;", "purchaseLoggingParametersList", "", "Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "getPurchaseLoggingParameters", FirebaseAnalytics.Event.PURCHASE, "skuDetails", "billingClientVersion", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "extraParameter", "", "getPurchaseParametersGPBLV2V4", "type", "params", "operationalData", "Lcom/facebook/appevents/OperationalData;", "purchaseJSON", "Lorg/json/JSONObject;", "skuDetailsJSON", "getPurchaseParametersGPBLV5V7", "getSubscriptionDedupeParameters", "eventName", "isImplicitPurchaseLoggingEnabled", "", "logActivateAppEvent", "", "logActivityTimeSpentEvent", "activityName", "timeSpentInSeconds", "", "logPurchase", "isSubscription", "isFirstAppLaunch", "PurchaseLoggingParameters", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AutomaticAnalyticsLogger {
    private static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    private AutomaticAnalyticsLogger() {
    }

    @JvmStatic
    public static final void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            if (applicationContext instanceof Application) {
                AppEventsLogger.INSTANCE.activateApp((Application) applicationContext, applicationId);
            } else {
                Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    @JvmStatic
    public static final void logActivityTimeSpentEvent(String activityName, long timeSpentInSeconds) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (fetchedAppSettingsQueryAppSettings == null || !fetchedAppSettingsQueryAppSettings.getAutomaticLoggingEnabled() || timeSpentInSeconds <= 0) {
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, activityName);
        internalAppEventsLogger2.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, timeSpentInSeconds, bundle);
    }

    public static /* synthetic */ void logPurchase$default(String str, String str2, boolean z, InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean z2, int i, Object obj) {
        if ((i & 16) != 0) {
            z2 = false;
        }
        logPurchase(str, str2, z, billingClientVersion, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void logPurchase(java.lang.String r7, java.lang.String r8, boolean r9, com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion r10, boolean r11) {
        /*
            java.lang.String r0 = "purchase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "skuDetails"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger r0 = com.facebook.appevents.internal.AutomaticAnalyticsLogger.INSTANCE
            boolean r1 = isImplicitPurchaseLoggingEnabled()
            if (r1 != 0) goto L15
            return
        L15:
            java.util.List r7 = r0.getPurchaseLoggingParameters(r7, r8, r10)
            if (r7 != 0) goto L1c
            return
        L1c:
            boolean r10 = r7.isEmpty()
            if (r10 == 0) goto L23
            return
        L23:
            java.lang.String r10 = "fb_mobile_purchase"
            r0 = 0
            if (r9 == 0) goto L47
            java.lang.String r1 = "app_events_if_auto_log_subs"
            java.lang.String r2 = com.facebook.FacebookSdk.getApplicationId()
            boolean r1 = com.facebook.internal.FetchedAppGateKeepersManager.getGateKeeperForKey(r1, r2, r0)
            if (r1 == 0) goto L47
            if (r11 == 0) goto L39
            java.lang.String r8 = "SubscriptionRestore"
            goto L4b
        L39:
            com.facebook.appevents.iap.InAppPurchaseEventManager r11 = com.facebook.appevents.iap.InAppPurchaseEventManager.INSTANCE
            boolean r8 = r11.hasFreeTrialPeirod(r8)
            if (r8 == 0) goto L44
            java.lang.String r8 = "StartTrial"
            goto L4b
        L44:
            java.lang.String r8 = "Subscribe"
            goto L4b
        L47:
            if (r11 == 0) goto L4d
            java.lang.String r8 = "fb_mobile_purchase_restored"
        L4b:
            r2 = r8
            goto L4e
        L4d:
            r2 = r10
        L4e:
            if (r9 == 0) goto L5d
            com.facebook.internal.FeatureManager$Feature r8 = com.facebook.internal.FeatureManager.Feature.AndroidManualImplicitSubsDedupe
            boolean r8 = com.facebook.internal.FeatureManager.isEnabled(r8)
            if (r8 == 0) goto L5d
            android.os.Bundle r8 = getSubscriptionDedupeParameters(r7, r2)
            goto L6d
        L5d:
            if (r9 != 0) goto L6c
            com.facebook.internal.FeatureManager$Feature r8 = com.facebook.internal.FeatureManager.Feature.AndroidManualImplicitPurchaseDedupe
            boolean r8 = com.facebook.internal.FeatureManager.isEnabled(r8)
            if (r8 == 0) goto L6c
            android.os.Bundle r8 = getPurchaseDedupeParameters(r7)
            goto L6d
        L6c:
            r8 = 0
        L6d:
            com.facebook.appevents.iap.InAppPurchaseDedupeConfig r9 = com.facebook.appevents.iap.InAppPurchaseDedupeConfig.INSTANCE
            java.lang.Object r11 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r11 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r11
            android.os.Bundle r11 = r11.getParam()
            java.lang.Object r1 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r1 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r1
            com.facebook.appevents.OperationalData r1 = r1.getOperationalData()
            r9.addDedupeParameters(r8, r11, r1)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r10)
            if (r8 != 0) goto Lba
            com.facebook.appevents.InternalAppEventsLogger r1 = com.facebook.appevents.internal.AutomaticAnalyticsLogger.internalAppEventsLogger
            java.lang.Object r8 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r8 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r8
            java.math.BigDecimal r3 = r8.getPurchaseAmount()
            java.lang.Object r8 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r8 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r8
            java.util.Currency r4 = r8.getCurrency()
            java.lang.Object r8 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r8 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r8
            android.os.Bundle r5 = r8.getParam()
            java.lang.Object r7 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r7 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r7
            com.facebook.appevents.OperationalData r6 = r7.getOperationalData()
            r1.logEventImplicitly(r2, r3, r4, r5, r6)
            goto Le7
        Lba:
            com.facebook.appevents.InternalAppEventsLogger r8 = com.facebook.appevents.internal.AutomaticAnalyticsLogger.internalAppEventsLogger
            java.lang.Object r9 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r9 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r9
            java.math.BigDecimal r9 = r9.getPurchaseAmount()
            java.lang.Object r10 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r10 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r10
            java.util.Currency r10 = r10.getCurrency()
            java.lang.Object r11 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r11 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r11
            android.os.Bundle r11 = r11.getParam()
            java.lang.Object r7 = r7.get(r0)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r7 = (com.facebook.appevents.internal.AutomaticAnalyticsLogger.PurchaseLoggingParameters) r7
            com.facebook.appevents.OperationalData r7 = r7.getOperationalData()
            r8.logPurchaseImplicitly(r9, r10, r11, r7)
        Le7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AutomaticAnalyticsLogger.logPurchase(java.lang.String, java.lang.String, boolean, com.facebook.appevents.iap.InAppPurchaseUtils$BillingClientVersion, boolean):void");
    }

    @JvmStatic
    public static final synchronized Bundle getPurchaseDedupeParameters(List<PurchaseLoggingParameters> purchaseLoggingParametersList) {
        PurchaseLoggingParameters purchaseLoggingParameters;
        Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
        purchaseLoggingParameters = purchaseLoggingParametersList.get(0);
        return InAppPurchaseManager.performDedupe(CollectionsKt.listOf(new InAppPurchase(AppEventsConstants.EVENT_NAME_PURCHASED, purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency())), System.currentTimeMillis(), true, CollectionsKt.listOf(new Pair(purchaseLoggingParameters.getParam(), purchaseLoggingParameters.getOperationalData())));
    }

    @JvmStatic
    public static final synchronized Bundle getSubscriptionDedupeParameters(List<PurchaseLoggingParameters> purchaseLoggingParametersList, String eventName) {
        ArrayList arrayList;
        long jCurrentTimeMillis;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ArrayList arrayList3 = new ArrayList();
        for (PurchaseLoggingParameters purchaseLoggingParameters : purchaseLoggingParametersList) {
            arrayList3.add(new InAppPurchase(eventName, purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency()));
        }
        arrayList = arrayList3;
        jCurrentTimeMillis = System.currentTimeMillis();
        List<PurchaseLoggingParameters> list = purchaseLoggingParametersList;
        arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PurchaseLoggingParameters purchaseLoggingParameters2 : list) {
            arrayList2.add(new Pair(purchaseLoggingParameters2.getParam(), purchaseLoggingParameters2.getOperationalData()));
        }
        return InAppPurchaseManager.performDedupe(arrayList, jCurrentTimeMillis, true, arrayList2);
    }

    @JvmStatic
    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled();
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String purchase, String skuDetails, InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        return getPurchaseLoggingParameters(purchase, skuDetails, new HashMap(), billingClientVersion);
    }

    private final PurchaseLoggingParameters getPurchaseParametersGPBLV2V4(String type, Bundle params, OperationalData operationalData, JSONObject purchaseJSON, JSONObject skuDetailsJSON) {
        if (Intrinsics.areEqual(type, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            OperationalData.Companion companion = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String string = Boolean.toString(purchaseJSON.optBoolean(Constants.GP_IAP_AUTORENEWING, false));
            Intrinsics.checkNotNullExpressionValue(string, "toString(\n              …      )\n                )");
            companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_AUTORENEWING, string, params, operationalData);
            OperationalData.Companion companion2 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum2 = OperationalDataEnum.IAPParameters;
            String strOptString = skuDetailsJSON.optString(Constants.GP_IAP_SUBSCRIPTION_PERIOD);
            Intrinsics.checkNotNullExpressionValue(strOptString, "skuDetailsJSON.optString…_IAP_SUBSCRIPTION_PERIOD)");
            companion2.addParameter(operationalDataEnum2, Constants.IAP_SUBSCRIPTION_PERIOD, strOptString, params, operationalData);
            OperationalData.Companion companion3 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum3 = OperationalDataEnum.IAPParameters;
            String strOptString2 = skuDetailsJSON.optString(Constants.GP_IAP_FREE_TRIAL_PERIOD);
            Intrinsics.checkNotNullExpressionValue(strOptString2, "skuDetailsJSON.optString…GP_IAP_FREE_TRIAL_PERIOD)");
            companion3.addParameter(operationalDataEnum3, Constants.IAP_FREE_TRIAL_PERIOD, strOptString2, params, operationalData);
            String introductoryPriceCycles = skuDetailsJSON.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_CYCLES);
            Intrinsics.checkNotNullExpressionValue(introductoryPriceCycles, "introductoryPriceCycles");
            if (introductoryPriceCycles.length() > 0) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_INTRO_PRICE_CYCLES, introductoryPriceCycles, params, operationalData);
            }
            String introductoryPricePeriod = skuDetailsJSON.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_PERIOD);
            Intrinsics.checkNotNullExpressionValue(introductoryPricePeriod, "introductoryPricePeriod");
            if (introductoryPricePeriod.length() > 0) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_INTRO_PERIOD, introductoryPricePeriod, params, operationalData);
            }
            String introductoryPriceAmountMicros = skuDetailsJSON.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS);
            Intrinsics.checkNotNullExpressionValue(introductoryPriceAmountMicros, "introductoryPriceAmountMicros");
            if (introductoryPriceAmountMicros.length() > 0) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, introductoryPriceAmountMicros, params, operationalData);
            }
        }
        BigDecimal bigDecimal = new BigDecimal(skuDetailsJSON.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4) / 1000000.0d);
        Currency currency = Currency.getInstance(skuDetailsJSON.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V2V4));
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(skuDetailsJS…RICE_CURRENCY_CODE_V2V4))");
        return new PurchaseLoggingParameters(bigDecimal, currency, params, operationalData);
    }

    private final List<PurchaseLoggingParameters> getPurchaseParametersGPBLV5V7(String type, Bundle params, OperationalData operationalData, JSONObject skuDetailsJSON) throws JSONException {
        if (Intrinsics.areEqual(type, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = skuDetailsJSON.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS);
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = skuDetailsJSON.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS).getJSONObject(i);
                if (jSONObject == null) {
                    return null;
                }
                Bundle bundle = new Bundle(params);
                OperationalData operationalDataCopy = operationalData.copy();
                String basePlanId = jSONObject.getString(Constants.GP_IAP_BASE_PLAN_ID);
                OperationalData.Companion companion = OperationalData.INSTANCE;
                OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
                Intrinsics.checkNotNullExpressionValue(basePlanId, "basePlanId");
                companion.addParameter(operationalDataEnum, Constants.IAP_BASE_PLAN, basePlanId, bundle, operationalDataCopy);
                JSONArray jSONArray2 = jSONObject.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES);
                JSONObject jSONObject2 = jSONArray2.getJSONObject(jSONArray2.length() - 1);
                if (jSONObject2 == null) {
                    return null;
                }
                OperationalData.Companion companion2 = OperationalData.INSTANCE;
                OperationalDataEnum operationalDataEnum2 = OperationalDataEnum.IAPParameters;
                String strOptString = jSONObject2.optString(Constants.GP_IAP_BILLING_PERIOD);
                Intrinsics.checkNotNullExpressionValue(strOptString, "subscriptionJSON.optStri…IOD\n                    )");
                companion2.addParameter(operationalDataEnum2, Constants.IAP_SUBSCRIPTION_PERIOD, strOptString, bundle, operationalDataCopy);
                if (jSONObject2.has(Constants.GP_IAP_RECURRENCE_MODE) && jSONObject2.getInt(Constants.GP_IAP_RECURRENCE_MODE) != 3) {
                    OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_SUBSCRIPTION_AUTORENEWING, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, bundle, operationalDataCopy);
                } else {
                    OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_SUBSCRIPTION_AUTORENEWING, com.facebook.hermes.intl.Constants.CASEFIRST_FALSE, bundle, operationalDataCopy);
                }
                BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7) / 1000000.0d);
                Currency currency = Currency.getInstance(jSONObject2.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7));
                Intrinsics.checkNotNullExpressionValue(currency, "getInstance(subscription…RICE_CURRENCY_CODE_V5V7))");
                arrayList.add(new PurchaseLoggingParameters(bigDecimal, currency, bundle, operationalDataCopy));
            }
            return arrayList;
        }
        JSONObject jSONObject3 = skuDetailsJSON.getJSONObject(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS);
        if (jSONObject3 == null) {
            return null;
        }
        BigDecimal bigDecimal2 = new BigDecimal(jSONObject3.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7) / 1000000.0d);
        Currency currency2 = Currency.getInstance(jSONObject3.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7));
        Intrinsics.checkNotNullExpressionValue(currency2, "getInstance(oneTimePurch…RICE_CURRENCY_CODE_V5V7))");
        return CollectionsKt.mutableListOf(new PurchaseLoggingParameters(bigDecimal2, currency2, params, operationalData));
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String purchase, String skuDetails, Map<String, String> extraParameter, InAppPurchaseUtils.BillingClientVersion billingClientVersion) throws JSONException {
        List<PurchaseLoggingParameters> listMutableListOf = null;
        try {
            JSONObject jSONObject = new JSONObject(purchase);
            JSONObject jSONObject2 = new JSONObject(skuDetails);
            Bundle bundle = new Bundle(1);
            OperationalData operationalData = new OperationalData();
            if (billingClientVersion != null) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_AUTOLOG_IMPLEMENTATION, billingClientVersion.getType(), bundle, operationalData);
            }
            OperationalData.Companion companion = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String string = jSONObject.getString("productId");
            Intrinsics.checkNotNullExpressionValue(string, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_ID, string, bundle, operationalData);
            OperationalData.Companion companion2 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum2 = OperationalDataEnum.IAPParameters;
            String string2 = jSONObject.getString("productId");
            Intrinsics.checkNotNullExpressionValue(string2, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            companion2.addParameter(operationalDataEnum2, AppEventsConstants.EVENT_PARAM_CONTENT_ID, string2, bundle, operationalData);
            OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.ANDROID_DYNAMIC_ADS_CONTENT_ID, "client_implicit", bundle, operationalData);
            OperationalData.Companion companion3 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum3 = OperationalDataEnum.IAPParameters;
            String string3 = jSONObject.getString(Constants.GP_IAP_PURCHASE_TIME);
            Intrinsics.checkNotNullExpressionValue(string3, "purchaseJSON.getString(C…nts.GP_IAP_PURCHASE_TIME)");
            companion3.addParameter(operationalDataEnum3, Constants.IAP_PURCHASE_TIME, string3, bundle, operationalData);
            OperationalData.Companion companion4 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum4 = OperationalDataEnum.IAPParameters;
            String string4 = jSONObject.getString("purchaseToken");
            Intrinsics.checkNotNullExpressionValue(string4, "purchaseJSON.getString(C…ts.GP_IAP_PURCHASE_TOKEN)");
            companion4.addParameter(operationalDataEnum4, Constants.IAP_PURCHASE_TOKEN, string4, bundle, operationalData);
            OperationalData.Companion companion5 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum5 = OperationalDataEnum.IAPParameters;
            String strOptString = jSONObject.optString("packageName");
            Intrinsics.checkNotNullExpressionValue(strOptString, "purchaseJSON.optString(C…ants.GP_IAP_PACKAGE_NAME)");
            companion5.addParameter(operationalDataEnum5, Constants.IAP_PACKAGE_NAME, strOptString, bundle, operationalData);
            OperationalData.Companion companion6 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum6 = OperationalDataEnum.IAPParameters;
            String strOptString2 = jSONObject2.optString("title");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "skuDetailsJSON.optString(Constants.GP_IAP_TITLE)");
            companion6.addParameter(operationalDataEnum6, Constants.IAP_PRODUCT_TITLE, strOptString2, bundle, operationalData);
            OperationalData.Companion companion7 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum7 = OperationalDataEnum.IAPParameters;
            String strOptString3 = jSONObject2.optString("description");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "skuDetailsJSON.optString…tants.GP_IAP_DESCRIPTION)");
            companion7.addParameter(operationalDataEnum7, Constants.IAP_PRODUCT_DESCRIPTION, strOptString3, bundle, operationalData);
            String type = jSONObject2.optString("type");
            OperationalData.Companion companion8 = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum8 = OperationalDataEnum.IAPParameters;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            companion8.addParameter(operationalDataEnum8, Constants.IAP_PRODUCT_TYPE, type, bundle, operationalData);
            String specificBillingLibraryVersion = InAppPurchaseManager.getSpecificBillingLibraryVersion();
            if (specificBillingLibraryVersion != null) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_BILLING_LIBRARY_VERSION, specificBillingLibraryVersion, bundle, operationalData);
            }
            for (Map.Entry<String, String> entry : extraParameter.entrySet()) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, entry.getKey(), entry.getValue(), bundle, operationalData);
            }
            if (jSONObject2.has(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4)) {
                listMutableListOf = CollectionsKt.mutableListOf(getPurchaseParametersGPBLV2V4(type, bundle, operationalData, jSONObject, jSONObject2));
            } else if (jSONObject2.has(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS) || jSONObject2.has(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS)) {
                try {
                    return getPurchaseParametersGPBLV5V7(type, bundle, operationalData, jSONObject2);
                } catch (JSONException e) {
                    e = e;
                    Log.e(TAG, "Error parsing in-app purchase/subscription data.", e);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    Log.e(TAG, "Failed to get purchase logging parameters,", e);
                    return null;
                }
            }
            return listMutableListOf;
        } catch (JSONException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* compiled from: AutomaticAnalyticsLogger.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "", "purchaseAmount", "Ljava/math/BigDecimal;", FirebaseAnalytics.Param.CURRENCY, "Ljava/util/Currency;", "param", "Landroid/os/Bundle;", "operationalData", "Lcom/facebook/appevents/OperationalData;", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "getCurrency", "()Ljava/util/Currency;", "setCurrency", "(Ljava/util/Currency;)V", "getOperationalData", "()Lcom/facebook/appevents/OperationalData;", "setOperationalData", "(Lcom/facebook/appevents/OperationalData;)V", "getParam", "()Landroid/os/Bundle;", "setParam", "(Landroid/os/Bundle;)V", "getPurchaseAmount", "()Ljava/math/BigDecimal;", "setPurchaseAmount", "(Ljava/math/BigDecimal;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PurchaseLoggingParameters {
        private Currency currency;
        private OperationalData operationalData;
        private Bundle param;
        private BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(BigDecimal purchaseAmount, Currency currency, Bundle param, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(purchaseAmount, "purchaseAmount");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(operationalData, "operationalData");
            this.purchaseAmount = purchaseAmount;
            this.currency = currency;
            this.param = param;
            this.operationalData = operationalData;
        }

        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }

        public final void setPurchaseAmount(BigDecimal bigDecimal) {
            Intrinsics.checkNotNullParameter(bigDecimal, "<set-?>");
            this.purchaseAmount = bigDecimal;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final void setCurrency(Currency currency) {
            Intrinsics.checkNotNullParameter(currency, "<set-?>");
            this.currency = currency;
        }

        public final Bundle getParam() {
            return this.param;
        }

        public final void setParam(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.param = bundle;
        }

        public final OperationalData getOperationalData() {
            return this.operationalData;
        }

        public final void setOperationalData(OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(operationalData, "<set-?>");
            this.operationalData = operationalData;
        }
    }
}
