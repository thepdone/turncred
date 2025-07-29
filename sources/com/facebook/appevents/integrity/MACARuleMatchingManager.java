package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MACARuleMatchingManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", ViewProps.ENABLED, "", "keys", "", "", "[Ljava/lang/String;", "enable", "", "generateInfo", "params", "Landroid/os/Bundle;", NotificationCompat.CATEGORY_EVENT, "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", RRWebVideoEvent.REPLAY_FRAME_RATE_TYPE_VARIABLE, "values", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {NotificationCompat.CATEGORY_EVENT, "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            MACARules = fetchedAppSettingsQueryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> itKeys = logic.keys();
            if (itKeys.hasNext()) {
                return itKeys.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0225 A[Catch: all -> 0x037e, TryCatch #0 {all -> 0x037e, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0095, B:34:0x009f, B:37:0x00af, B:123:0x0225, B:125:0x022b, B:128:0x0235, B:129:0x0239, B:131:0x023f, B:40:0x00b9, B:43:0x00c3, B:44:0x00e3, B:139:0x0270, B:141:0x0276, B:144:0x0281, B:145:0x0285, B:147:0x028b, B:47:0x00ed, B:50:0x00f7, B:51:0x0113, B:99:0x01c1, B:54:0x011d, B:93:0x01a6, B:57:0x0127, B:84:0x0181, B:60:0x0131, B:63:0x013b, B:115:0x0207, B:66:0x0145, B:69:0x014f, B:182:0x0349, B:72:0x0159, B:105:0x01d8, B:75:0x0163, B:78:0x016d, B:111:0x01f3, B:81:0x0177, B:87:0x0192, B:90:0x019c, B:96:0x01b7, B:102:0x01ce, B:108:0x01e9, B:112:0x01fd, B:118:0x0218, B:134:0x0263, B:150:0x02af, B:153:0x02b9, B:156:0x02d7, B:159:0x02e1, B:160:0x02ef, B:176:0x0334, B:163:0x02f9, B:166:0x0304, B:167:0x0315, B:170:0x031f, B:171:0x0328, B:177:0x033d, B:183:0x0352, B:186:0x035b, B:20:0x005b), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0270 A[Catch: all -> 0x037e, TryCatch #0 {all -> 0x037e, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0095, B:34:0x009f, B:37:0x00af, B:123:0x0225, B:125:0x022b, B:128:0x0235, B:129:0x0239, B:131:0x023f, B:40:0x00b9, B:43:0x00c3, B:44:0x00e3, B:139:0x0270, B:141:0x0276, B:144:0x0281, B:145:0x0285, B:147:0x028b, B:47:0x00ed, B:50:0x00f7, B:51:0x0113, B:99:0x01c1, B:54:0x011d, B:93:0x01a6, B:57:0x0127, B:84:0x0181, B:60:0x0131, B:63:0x013b, B:115:0x0207, B:66:0x0145, B:69:0x014f, B:182:0x0349, B:72:0x0159, B:105:0x01d8, B:75:0x0163, B:78:0x016d, B:111:0x01f3, B:81:0x0177, B:87:0x0192, B:90:0x019c, B:96:0x01b7, B:102:0x01ce, B:108:0x01e9, B:112:0x01fd, B:118:0x0218, B:134:0x0263, B:150:0x02af, B:153:0x02b9, B:156:0x02d7, B:159:0x02e1, B:160:0x02ef, B:176:0x0334, B:163:0x02f9, B:166:0x0304, B:167:0x0315, B:170:0x031f, B:171:0x0328, B:177:0x033d, B:183:0x0352, B:186:0x035b, B:20:0x005b), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0334 A[Catch: all -> 0x037e, TryCatch #0 {all -> 0x037e, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0095, B:34:0x009f, B:37:0x00af, B:123:0x0225, B:125:0x022b, B:128:0x0235, B:129:0x0239, B:131:0x023f, B:40:0x00b9, B:43:0x00c3, B:44:0x00e3, B:139:0x0270, B:141:0x0276, B:144:0x0281, B:145:0x0285, B:147:0x028b, B:47:0x00ed, B:50:0x00f7, B:51:0x0113, B:99:0x01c1, B:54:0x011d, B:93:0x01a6, B:57:0x0127, B:84:0x0181, B:60:0x0131, B:63:0x013b, B:115:0x0207, B:66:0x0145, B:69:0x014f, B:182:0x0349, B:72:0x0159, B:105:0x01d8, B:75:0x0163, B:78:0x016d, B:111:0x01f3, B:81:0x0177, B:87:0x0192, B:90:0x019c, B:96:0x01b7, B:102:0x01ce, B:108:0x01e9, B:112:0x01fd, B:118:0x0218, B:134:0x0263, B:150:0x02af, B:153:0x02b9, B:156:0x02d7, B:159:0x02e1, B:160:0x02ef, B:176:0x0334, B:163:0x02f9, B:166:0x0304, B:167:0x0315, B:170:0x031f, B:171:0x0328, B:177:0x033d, B:183:0x0352, B:186:0x035b, B:20:0x005b), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0349 A[Catch: all -> 0x037e, TryCatch #0 {all -> 0x037e, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:31:0x0095, B:34:0x009f, B:37:0x00af, B:123:0x0225, B:125:0x022b, B:128:0x0235, B:129:0x0239, B:131:0x023f, B:40:0x00b9, B:43:0x00c3, B:44:0x00e3, B:139:0x0270, B:141:0x0276, B:144:0x0281, B:145:0x0285, B:147:0x028b, B:47:0x00ed, B:50:0x00f7, B:51:0x0113, B:99:0x01c1, B:54:0x011d, B:93:0x01a6, B:57:0x0127, B:84:0x0181, B:60:0x0131, B:63:0x013b, B:115:0x0207, B:66:0x0145, B:69:0x014f, B:182:0x0349, B:72:0x0159, B:105:0x01d8, B:75:0x0163, B:78:0x016d, B:111:0x01f3, B:81:0x0177, B:87:0x0192, B:90:0x019c, B:96:0x01b7, B:102:0x01ce, B:108:0x01e9, B:112:0x01fd, B:118:0x0218, B:134:0x0263, B:150:0x02af, B:153:0x02b9, B:156:0x02d7, B:159:0x02e1, B:160:0x02ef, B:176:0x0334, B:163:0x02f9, B:166:0x0304, B:167:0x0315, B:170:0x031f, B:171:0x0328, B:177:0x033d, B:183:0x0352, B:186:0x035b, B:20:0x005b), top: B:193:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b6  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean stringComparison(java.lang.String r8, org.json.JSONObject r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.stringComparison(java.lang.String, org.json.JSONObject, android.os.Bundle):boolean");
    }

    @JvmStatic
    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jsonArray.get(i).toString());
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isMatchCCRule(String ruleString, Bundle data) {
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int iHashCode = key.hashCode();
                if (iHashCode != 3555) {
                    if (iHashCode != 96727) {
                        if (iHashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (!isMatchCCRule(jSONArray.get(i).toString(), data)) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 == null) {
                        return false;
                    }
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        if (isMatchCCRule(jSONArray2.get(i2).toString(), data)) {
                            return true;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getMatchPropertyIDs(Bundle params) {
        String strOptString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            if (jSONArray != null && jSONArray.length() == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            JSONArray jSONArray2 = MACARules;
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                String strOptString2 = jSONArray2.optString(i);
                if (strOptString2 != null) {
                    JSONObject jSONObject = new JSONObject(strOptString2);
                    long jOptLong = jSONObject.optLong("id");
                    if (jOptLong != 0 && (strOptString = jSONObject.optString("rule")) != null && isMatchCCRule(strOptString, params)) {
                        arrayList.add(Long.valueOf(jOptLong));
                    }
                }
            }
            String string = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(res).toString()");
            return string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void generateInfo(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString(NotificationCompat.CATEGORY_EVENT, event);
            StringBuilder sb = new StringBuilder();
            Locale locale = Utility.INSTANCE.getLocale();
            String language = locale != null ? locale.getLanguage() : null;
            String str = "";
            if (language == null) {
                language = "";
            }
            StringBuilder sbAppend = sb.append(language).append('_');
            Locale locale2 = Utility.INSTANCE.getLocale();
            String country = locale2 != null ? locale2.getCountry() : null;
            if (country == null) {
                country = "";
            }
            params.putString("_locale", sbAppend.append(country).toString());
            String versionName = Utility.INSTANCE.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", "mobile");
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = Utility.INSTANCE.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", Utility.INSTANCE.getDeviceTimeZoneName());
            params.putString("_carrier", Utility.INSTANCE.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", Utility.INSTANCE.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            for (String str : keys) {
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }
}
