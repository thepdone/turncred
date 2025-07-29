package expo.modules.taskManager;

import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.interfaces.taskManager.TaskInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class Utils {
    private static final String TAG = "taskManager.Utils";

    public static Map<String, Object> exportTaskToMap(TaskInterface taskInterface) {
        HashMap map = new HashMap();
        Class<?> cls = taskInterface.getConsumer().getClass();
        String strUnversionedClassNameForClass = unversionedClassNameForClass(cls);
        map.put("name", taskInterface.getName());
        map.put("consumerClass", strUnversionedClassNameForClass);
        map.put("consumerVersion", Integer.valueOf(getConsumerVersion(cls)));
        map.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, taskInterface.getOptions());
        return map;
    }

    public static Class unversionedClassForClass(Class cls) {
        if (cls == null) {
            return null;
        }
        String strUnversionedClassNameForClass = unversionedClassNameForClass(cls);
        try {
            return Class.forName(strUnversionedClassNameForClass);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Class with name '" + strUnversionedClassNameForClass + "' not found.");
            e.printStackTrace();
            return null;
        }
    }

    public static String unversionedClassNameForClass(Class cls) {
        return cls.getName().replaceFirst("\\^abi\\d+_\\d+_\\d+\\.", "");
    }

    public static int getConsumerVersion(Class cls) {
        try {
            return ((Integer) cls.getDeclaredField("VERSION").get(null)).intValue();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return 0;
        }
    }

    public static Map<String, Object> jsonToMap(String str) {
        try {
            return jsonToMap(new JSONObject(str));
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static Map<String, Object> jsonToMap(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jsonObjectToObject(jSONObject.get(next)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static List<Object> jsonToList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object objJsonToMap = jSONArray.get(i);
                if (objJsonToMap instanceof JSONArray) {
                    objJsonToMap = jsonToList((JSONArray) objJsonToMap);
                } else if (objJsonToMap instanceof JSONObject) {
                    objJsonToMap = jsonToMap((JSONObject) objJsonToMap);
                }
                arrayList.add(objJsonToMap);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static Object jsonObjectToObject(Object obj) {
        if (obj instanceof JSONObject) {
            return jsonToMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? jsonToList((JSONArray) obj) : obj;
    }
}
