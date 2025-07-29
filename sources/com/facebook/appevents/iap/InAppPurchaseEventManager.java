package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppPurchaseEventManager.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\b\u0010+\u001a\u00020,H\u0007J0\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001e\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u0004\u0018\u00010\"2\n\u00104\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u00105\u001a\u00020\u0004H\u0002J0\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007JF\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0007JF\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0004JA\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00012\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020A2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J,\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040L2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001c\u0010M\u001a\u00020,2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001ej\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u001ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"` X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseEventManager;", "", "()V", "AS_INTERFACE", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "", InAppPurchaseEventManager.DETAILS_LIST, "GET_PURCHASES", "GET_PURCHASE_HISTORY", "GET_SKU_DETAILS", "INAPP", InAppPurchaseEventManager.INAPP_CONTINUATION_TOKEN, InAppPurchaseEventManager.INAPP_PURCHASE_DATA_LIST, "IN_APP_BILLING_SERVICE", "IN_APP_BILLING_SERVICE_STUB", "IS_BILLING_SUPPORTED", InAppPurchaseEventManager.ITEM_ID_LIST, InAppPurchaseEventManager.LAST_CLEARED_TIME, "MAX_QUERY_PURCHASE_NUM", "PACKAGE_NAME", "kotlin.jvm.PlatformType", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_INAPP_STORE", "PURCHASE_STOP_QUERY_TIME_SEC", InAppPurchaseEventManager.RESPONSE_CODE, "SKU_DETAILS_STORE", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "classMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/lang/reflect/Method;", "purchaseInappSharedPrefs", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", InAppPurchaseEventManager.AS_INTERFACE, "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_SERVICE, "Landroid/os/IBinder;", "clearSkuDetailsCache", "", "filterPurchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchases", "getClass", "className", "getMethod", "classObj", "methodName", InAppPurchaseEventManager.GET_PURCHASE_HISTORY, "inAppBillingObj", "type", "getPurchaseHistoryInapp", InAppPurchaseEventManager.GET_PURCHASES, "getPurchasesInapp", "getPurchasesSubs", InAppPurchaseEventManager.GET_SKU_DETAILS, "", "skuList", "isSubscription", "", "getSkuDetailsFromGoogle", "hasFreeTrialPeirod", "skuDetail", "invokeMethod", "obj", "args", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", InAppPurchaseEventManager.IS_BILLING_SUPPORTED, "readSkuDetailsFromCache", "", "writeSkuDetailsToCache", "skuDetailsMap", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);

    private InAppPurchaseEventManager() {
    }

    @JvmStatic
    public static final Object asInterface(Context context, IBinder service) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            return INSTANCE.invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{service});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final Map<String, String> getSkuDetails(Context context, ArrayList<String> skuList, Object inAppBillingObj, boolean isSubscription) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Map<String, String> skuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(skuList);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = skuList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!skuDetailsFromCache.containsKey(next)) {
                    arrayList.add(next);
                }
            }
            skuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList, inAppBillingObj, isSubscription));
            return skuDetailsFromCache;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> skuList, Object inAppBillingObj, boolean isSubscription) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            if (inAppBillingObj != null && !skuList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(ITEM_ID_LIST, skuList);
                Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, inAppBillingObj, new Object[]{3, PACKAGE_NAME, isSubscription ? SUBSCRIPTION : INAPP, bundle});
                if (objInvokeMethod != null) {
                    Bundle bundle2 = (Bundle) objInvokeMethod;
                    if (bundle2.getInt(RESPONSE_CODE) == 0) {
                        ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                        if (stringArrayList != null && skuList.size() == stringArrayList.size()) {
                            int size = skuList.size();
                            for (int i = 0; i < size; i++) {
                                String str = skuList.get(i);
                                Intrinsics.checkNotNullExpressionValue(str, "skuList[i]");
                                String str2 = stringArrayList.get(i);
                                Intrinsics.checkNotNullExpressionValue(str2, "skuDetailsList[i]");
                                linkedHashMap.put(str, str2);
                            }
                        }
                        writeSkuDetailsToCache(linkedHashMap);
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> skuList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = skuList.iterator();
            while (it.hasNext()) {
                String sku = it.next();
                String string = skuDetailSharedPrefs.getString(sku, null);
                if (string != null) {
                    List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{";"}, false, 2, 2, (Object) null);
                    if (jCurrentTimeMillis - Long.parseLong((String) listSplit$default.get(0)) < 43200) {
                        Intrinsics.checkNotNullExpressionValue(sku, "sku");
                        linkedHashMap.put(sku, listSplit$default.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void writeSkuDetailsToCache(Map<String, String> skuDetailsMap) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences.Editor editorEdit = skuDetailSharedPrefs.edit();
            for (Map.Entry<String, String> entry : skuDetailsMap.entrySet()) {
                editorEdit.putString(entry.getKey(), jCurrentTimeMillis + ';' + entry.getValue());
            }
            editorEdit.apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final boolean isBillingSupported(Context context, Object inAppBillingObj, String type) {
        if (CrashShieldHandler.isObjectCrashing(this) || inAppBillingObj == null) {
            return false;
        }
        try {
            Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, inAppBillingObj, new Object[]{3, PACKAGE_NAME, type});
            if (objInvokeMethod != null) {
                return ((Integer) objInvokeMethod).intValue() == 0;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getPurchasesInapp(Context context, Object inAppBillingObj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, inAppBillingObj, INAPP));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getPurchasesSubs(Context context, Object inAppBillingObj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, inAppBillingObj, SUBSCRIPTION));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r12 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5b
            r0.<init>()     // Catch: java.lang.Throwable -> L5b
            if (r14 != 0) goto L10
            return r0
        L10:
            boolean r2 = r12.isBillingSupported(r13, r14, r15)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L5a
            r2 = 0
            r3 = r1
        L18:
            r4 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L5b
            java.lang.Object[] r11 = new java.lang.Object[]{r4, r5, r15, r3}     // Catch: java.lang.Throwable -> L5b
            java.lang.String r8 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r9 = "getPurchases"
            r6 = r12
            r7 = r13
            r10 = r14
            java.lang.Object r3 = r6.invokeMethod(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L53
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "RESPONSE_CODE"
            int r4 = r3.getInt(r4)     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L53
            java.lang.String r4 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r4 = r3.getStringArrayList(r4)     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L5a
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L5b
            int r2 = r2 + r5
            java.util.Collection r4 = (java.util.Collection) r4     // Catch: java.lang.Throwable -> L5b
            r0.addAll(r4)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r4)     // Catch: java.lang.Throwable -> L5b
            goto L54
        L53:
            r3 = r1
        L54:
            r4 = 30
            if (r2 >= r4) goto L5a
            if (r3 != 0) goto L18
        L5a:
            return r0
        L5b:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public final boolean hasFreeTrialPeirod(String skuDetail) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(skuDetail, "skuDetail");
            try {
                String strOptString = new JSONObject(skuDetail).optString(Constants.GP_IAP_FREE_TRIAL_PERIOD);
                if (strOptString != null) {
                    return strOptString.length() > 0;
                }
                return false;
            } catch (JSONException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getPurchaseHistoryInapp(Context context, Object inAppBillingObj) {
        InAppPurchaseEventManager inAppPurchaseEventManager;
        Class<?> cls;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList<String> arrayList = new ArrayList<>();
            return (inAppBillingObj == null || (cls = (inAppPurchaseEventManager = INSTANCE).getClass(context, IN_APP_BILLING_SERVICE)) == null || inAppPurchaseEventManager.getMethod(cls, GET_PURCHASE_HISTORY) == null) ? arrayList : inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchaseHistory(context, inAppBillingObj, INAPP));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.ArrayList<java.lang.String> getPurchaseHistory(android.content.Context r17, java.lang.Object r18, java.lang.String r19) {
        /*
            r16 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r16)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L90
            r0.<init>()     // Catch: java.lang.Throwable -> L90
            boolean r2 = r16.isBillingSupported(r17, r18, r19)     // Catch: java.lang.Throwable -> L90
            if (r2 == 0) goto L8f
            r2 = 0
            r4 = r1
            r3 = r2
        L16:
            r5 = 6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L90
            java.lang.String r6 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L90
            android.os.Bundle r7 = new android.os.Bundle     // Catch: java.lang.Throwable -> L90
            r7.<init>()     // Catch: java.lang.Throwable -> L90
            r8 = r19
            java.lang.Object[] r14 = new java.lang.Object[]{r5, r6, r8, r4, r7}     // Catch: java.lang.Throwable -> L90
            java.lang.String r11 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r12 = "getPurchaseHistory"
            r9 = r16
            r10 = r17
            r13 = r18
            java.lang.Object r4 = r9.invokeMethod(r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L86
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L90
            r9 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r9
            android.os.Bundle r4 = (android.os.Bundle) r4     // Catch: java.lang.Throwable -> L90
            java.lang.String r7 = "RESPONSE_CODE"
            int r7 = r4.getInt(r7)     // Catch: java.lang.Throwable -> L90
            if (r7 != 0) goto L86
            java.lang.String r7 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r7 = r4.getStringArrayList(r7)     // Catch: java.lang.Throwable -> L90
            if (r7 != 0) goto L52
            goto L86
        L52:
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L90
        L56:
            boolean r11 = r7.hasNext()     // Catch: java.lang.Throwable -> L90
            if (r11 == 0) goto L7f
            java.lang.Object r11 = r7.next()     // Catch: java.lang.Throwable -> L90
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L90
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: org.json.JSONException -> L56 java.lang.Throwable -> L90
            r12.<init>(r11)     // Catch: org.json.JSONException -> L56 java.lang.Throwable -> L90
            java.lang.String r13 = "purchaseTime"
            long r12 = r12.getLong(r13)     // Catch: org.json.JSONException -> L56 java.lang.Throwable -> L90
            long r12 = r12 / r9
            long r12 = r5 - r12
            r14 = 1200(0x4b0, double:5.93E-321)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L79
            r3 = 1
            goto L7f
        L79:
            r0.add(r11)     // Catch: org.json.JSONException -> L56 java.lang.Throwable -> L90
            int r2 = r2 + 1
            goto L56
        L7f:
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r4 = r4.getString(r5)     // Catch: java.lang.Throwable -> L90
            goto L87
        L86:
            r4 = r1
        L87:
            r5 = 30
            if (r2 >= r5) goto L8f
            if (r4 == 0) goto L8f
            if (r3 == 0) goto L16
        L8f:
            return r0
        L90:
            r0 = move-exception
            r2 = r16
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchaseHistory(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> purchases) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            SharedPreferences.Editor editorEdit = purchaseInappSharedPrefs.edit();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = purchases.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject(next);
                    String string = jSONObject.getString("productId");
                    long j = jSONObject.getLong(Constants.GP_IAP_PURCHASE_TIME);
                    String string2 = jSONObject.getString("purchaseToken");
                    if (jCurrentTimeMillis - (j / 1000) <= 86400 && !Intrinsics.areEqual(purchaseInappSharedPrefs.getString(string, ""), string2)) {
                        editorEdit.putString(string, string2);
                        arrayList.add(next);
                    }
                } catch (JSONException unused) {
                }
            }
            editorEdit.apply();
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Method getMethod(Class<?> classObj, String methodName) {
        Class[] clsArr;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Method> map = methodMap;
            Method method = map.get(methodName);
            if (method != null) {
                return method;
            }
            switch (methodName.hashCode()) {
                case -1801122596:
                    if (!methodName.equals(GET_PURCHASES)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE = Integer.TYPE;
                        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
                        clsArr = new Class[]{TYPE, String.class, String.class, String.class};
                        break;
                    }
                case -1450694211:
                    if (!methodName.equals(IS_BILLING_SUPPORTED)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE2 = Integer.TYPE;
                        Intrinsics.checkNotNullExpressionValue(TYPE2, "TYPE");
                        clsArr = new Class[]{TYPE2, String.class, String.class};
                        break;
                    }
                case -1123215065:
                    if (!methodName.equals(AS_INTERFACE)) {
                        clsArr = null;
                        break;
                    } else {
                        clsArr = new Class[]{IBinder.class};
                        break;
                    }
                case -594356707:
                    if (!methodName.equals(GET_PURCHASE_HISTORY)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE3 = Integer.TYPE;
                        Intrinsics.checkNotNullExpressionValue(TYPE3, "TYPE");
                        clsArr = new Class[]{TYPE3, String.class, String.class, String.class, Bundle.class};
                        break;
                    }
                case -573310373:
                    if (!methodName.equals(GET_SKU_DETAILS)) {
                        clsArr = null;
                        break;
                    } else {
                        Class TYPE4 = Integer.TYPE;
                        Intrinsics.checkNotNullExpressionValue(TYPE4, "TYPE");
                        clsArr = new Class[]{TYPE4, String.class, String.class, Bundle.class};
                        break;
                    }
                default:
                    clsArr = null;
                    break;
            }
            Method declaredMethod$facebook_core_release = clsArr == null ? InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(classObj, methodName, null) : InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(classObj, methodName, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (declaredMethod$facebook_core_release != null) {
                map.put(methodName, declaredMethod$facebook_core_release);
            }
            return declaredMethod$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getClass(Context context, String className) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Class<?>> map = classMap;
            Class<?> cls = map.get(className);
            if (cls != null) {
                return cls;
            }
            Class<?> classFromContext$facebook_core_release = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context, className);
            if (classFromContext$facebook_core_release != null) {
                map.put(className, classFromContext$facebook_core_release);
            }
            return classFromContext$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object invokeMethod(Context context, String className, String methodName, Object obj, Object[] args) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, className);
            if (cls == null || (method = getMethod(cls, methodName)) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(args, args.length));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final void clearSkuDetailsCache() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences = skuDetailSharedPrefs;
            long j = sharedPreferences.getLong(LAST_CLEARED_TIME, 0L);
            if (j == 0) {
                sharedPreferences.edit().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
            } else if (jCurrentTimeMillis - j > 604800) {
                sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
        }
    }
}
