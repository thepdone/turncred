package com.facebook.reactnative.androidsdk;

import androidx.autofill.HintConstants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.nimbusds.jose.HeaderParameterNames;
import io.sentry.protocol.Geo;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = FBAppEventsLoggerModule.NAME)
/* loaded from: classes3.dex */
public class FBAppEventsLoggerModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBAppEventsLogger";
    private AppEventsLogger mAppEventLogger;
    private AttributionIdentifiers mAttributionIdentifiers;
    private ReactApplicationContext mReactContext;

    public FBAppEventsLoggerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        this.mAppEventLogger = AppEventsLogger.newLogger(this.mReactContext);
        this.mAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(this.mReactContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setFlushBehavior(String str) {
        AppEventsLogger.setFlushBehavior(AppEventsLogger.FlushBehavior.valueOf(str.toUpperCase(Locale.ROOT)));
    }

    @ReactMethod
    public void logEvent(String str, double d, ReadableMap readableMap) {
        this.mAppEventLogger.logEvent(str, d, Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logPurchase(double d, String str, ReadableMap readableMap) {
        this.mAppEventLogger.logPurchase(BigDecimal.valueOf(d), Currency.getInstance(str), Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logPushNotificationOpen(ReadableMap readableMap) {
        this.mAppEventLogger.logPushNotificationOpen(Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logProductItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, double d, String str8, String str9, String str10, String str11, ReadableMap readableMap) {
        this.mAppEventLogger.logProductItem(str, AppEventsLogger.ProductAvailability.valueOf(str2.toUpperCase(Locale.ROOT)), AppEventsLogger.ProductCondition.valueOf(str3.toUpperCase(Locale.ROOT)), str4, str5, str6, str7, BigDecimal.valueOf(d), Currency.getInstance(str8), str9, str10, str11, Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void setUserID(String str) {
        AppEventsLogger.setUserID(str);
    }

    @ReactMethod
    public void clearUserID() {
        AppEventsLogger.clearUserID();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getUserID() {
        return AppEventsLogger.getUserID();
    }

    @ReactMethod
    public void getAnonymousID(Promise promise) {
        try {
            promise.resolve(AppEventsLogger.getAnonymousAppDeviceGUID(this.mReactContext));
        } catch (Exception e) {
            promise.reject("E_ANONYMOUS_ID_ERROR", "Can not get anonymousID", e);
        }
    }

    @ReactMethod
    public void getAdvertiserID(Promise promise) {
        try {
            promise.resolve(this.mAttributionIdentifiers.getAndroidAdvertiserId());
        } catch (Exception e) {
            promise.reject("E_ADVERTISER_ID_ERROR", "Can not get advertiserID", e);
        }
    }

    @ReactMethod
    public void getAttributionID(Promise promise) {
        try {
            promise.resolve(this.mAttributionIdentifiers.getAttributionId());
        } catch (Exception e) {
            promise.reject("E_ATTRIBUTION_ID_ERROR", "Can not get attributionID", e);
        }
    }

    private String getNullableString(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    @ReactMethod
    public void setUserData(ReadableMap readableMap) {
        AppEventsLogger.setUserData(getNullableString(readableMap, "email"), getNullableString(readableMap, "firstName"), getNullableString(readableMap, "lastName"), getNullableString(readableMap, HintConstants.AUTOFILL_HINT_PHONE), getNullableString(readableMap, "dateOfBirth"), getNullableString(readableMap, HintConstants.AUTOFILL_HINT_GENDER), getNullableString(readableMap, Geo.JsonKeys.CITY), getNullableString(readableMap, "state"), getNullableString(readableMap, HeaderParameterNames.COMPRESSION_ALGORITHM), getNullableString(readableMap, UserDataStore.COUNTRY));
    }

    @ReactMethod
    public void flush() {
        this.mAppEventLogger.flush();
    }

    @ReactMethod
    public void setPushNotificationsRegistrationId(String str) {
        AppEventsLogger.setPushNotificationsRegistrationId(str);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("AchievedLevel", AppEventsConstants.EVENT_NAME_ACHIEVED_LEVEL);
        map2.put(AppEventsConstants.EVENT_NAME_AD_CLICK, AppEventsConstants.EVENT_NAME_AD_CLICK);
        map2.put(AppEventsConstants.EVENT_NAME_AD_IMPRESSION, AppEventsConstants.EVENT_NAME_AD_IMPRESSION);
        map2.put("AddedPaymentInfo", AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO);
        map2.put("AddedToCart", AppEventsConstants.EVENT_NAME_ADDED_TO_CART);
        map2.put("AddedToWishlist", AppEventsConstants.EVENT_NAME_ADDED_TO_WISHLIST);
        map2.put("CompletedRegistration", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION);
        map2.put("CompletedTutorial", AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL);
        map2.put(AppEventsConstants.EVENT_NAME_CONTACT, AppEventsConstants.EVENT_NAME_CONTACT);
        map2.put(AppEventsConstants.EVENT_NAME_CUSTOMIZE_PRODUCT, AppEventsConstants.EVENT_NAME_CUSTOMIZE_PRODUCT);
        map2.put(AppEventsConstants.EVENT_NAME_DONATE, AppEventsConstants.EVENT_NAME_DONATE);
        map2.put(AppEventsConstants.EVENT_NAME_FIND_LOCATION, AppEventsConstants.EVENT_NAME_FIND_LOCATION);
        map2.put("InitiatedCheckout", AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
        map2.put("Purchased", AppEventsConstants.EVENT_NAME_PURCHASED);
        map2.put("Rated", AppEventsConstants.EVENT_NAME_RATED);
        map2.put("Searched", AppEventsConstants.EVENT_NAME_SEARCHED);
        map2.put("SpentCredits", AppEventsConstants.EVENT_NAME_SPENT_CREDITS);
        map2.put(AppEventsConstants.EVENT_NAME_SCHEDULE, AppEventsConstants.EVENT_NAME_SCHEDULE);
        map2.put(AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_START_TRIAL);
        map2.put(AppEventsConstants.EVENT_NAME_SUBMIT_APPLICATION, AppEventsConstants.EVENT_NAME_SUBMIT_APPLICATION);
        map2.put(AppEventsConstants.EVENT_NAME_SUBSCRIBE, AppEventsConstants.EVENT_NAME_SUBSCRIBE);
        map2.put("UnlockedAchievement", AppEventsConstants.EVENT_NAME_UNLOCKED_ACHIEVEMENT);
        map2.put("ViewedContent", AppEventsConstants.EVENT_NAME_VIEWED_CONTENT);
        map.put("AppEvents", map2);
        HashMap map3 = new HashMap();
        map3.put("AddType", AppEventsConstants.EVENT_PARAM_AD_TYPE);
        map3.put("Content", AppEventsConstants.EVENT_PARAM_CONTENT);
        map3.put("ContentID", AppEventsConstants.EVENT_PARAM_CONTENT_ID);
        map3.put("ContentType", AppEventsConstants.EVENT_PARAM_CONTENT_TYPE);
        map3.put("Currency", AppEventsConstants.EVENT_PARAM_CURRENCY);
        map3.put("Description", AppEventsConstants.EVENT_PARAM_DESCRIPTION);
        map3.put("Level", AppEventsConstants.EVENT_PARAM_LEVEL);
        map3.put("NumItems", AppEventsConstants.EVENT_PARAM_NUM_ITEMS);
        map3.put("MaxRatingValue", AppEventsConstants.EVENT_PARAM_MAX_RATING_VALUE);
        map3.put("OrderId", AppEventsConstants.EVENT_PARAM_ORDER_ID);
        map3.put("PaymentInfoAvailable", AppEventsConstants.EVENT_PARAM_PAYMENT_INFO_AVAILABLE);
        map3.put("RegistrationMethod", AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD);
        map3.put("SearchString", AppEventsConstants.EVENT_PARAM_SEARCH_STRING);
        map3.put("Success", AppEventsConstants.EVENT_PARAM_SUCCESS);
        map3.put("ValueNo", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        map3.put("ValueYes", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        map.put("AppEventParams", map3);
        return map;
    }
}
