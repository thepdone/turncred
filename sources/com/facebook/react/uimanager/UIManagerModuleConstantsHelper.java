package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class UIManagerModuleConstantsHelper {
    private static final String BUBBLING_EVENTS_KEY = "bubblingEventTypes";
    private static final String DIRECT_EVENTS_KEY = "directEventTypes";
    private static final String TAG = "UIManagerModuleConstantsHelper";

    static Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
        Map<String, Object> constants = UIManagerModuleConstants.getConstants();
        constants.put("ViewManagerNames", new ArrayList(viewManagerResolver.getViewManagerNames()));
        constants.put("LazyViewManagersEnabled", true);
        return constants;
    }

    public static Map<String, Object> getDefaultExportableEventTypes() {
        return MapBuilder.of(BUBBLING_EVENTS_KEY, UIManagerModuleConstants.getBubblingEventTypeConstants(), DIRECT_EVENTS_KEY, UIManagerModuleConstants.getDirectEventTypeConstants());
    }

    private static void validateDirectEventNames(String str, Map<String, Object> map) {
        String str2;
        if (!ReactBuildConfig.DEBUG || map == null) {
            return;
        }
        for (String str3 : map.keySet()) {
            Object obj = map.get(str3);
            if (obj != null && (obj instanceof Map) && (str2 = (String) ((Map) obj).get("registrationName")) != null && str3.startsWith("top") && str2.startsWith("on") && !str3.substring(3).equals(str2.substring(2))) {
                FLog.e(TAG, String.format("Direct event name for '%s' doesn't correspond to the naming convention, expected 'topEventName'->'onEventName', got '%s'->'%s'", str, str3, str2));
            }
        }
    }

    static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> constants = UIManagerModuleConstants.getConstants();
        Map<? extends String, ? extends Object> bubblingEventTypeConstants = UIManagerModuleConstants.getBubblingEventTypeConstants();
        Map<? extends String, ? extends Object> directEventTypeConstants = UIManagerModuleConstants.getDirectEventTypeConstants();
        if (map != null) {
            map.putAll(bubblingEventTypeConstants);
        }
        if (map2 != null) {
            map2.putAll(directEventTypeConstants);
        }
        for (ViewManager viewManager : list) {
            String name = viewManager.getName();
            Map<String, Object> mapCreateConstantsForViewManager = createConstantsForViewManager(viewManager, null, null, map, map2);
            if (!mapCreateConstantsForViewManager.isEmpty()) {
                constants.put(name, mapCreateConstantsForViewManager);
            }
        }
        constants.put("genericBubblingEventTypes", bubblingEventTypeConstants);
        constants.put("genericDirectEventTypes", directEventTypeConstants);
        return constants;
    }

    static Map<String, Object> createConstantsForViewManager(ViewManager viewManager, Map map, Map map2, Map map3, Map map4) {
        HashMap mapNewHashMap = MapBuilder.newHashMap();
        Map<String, Object> exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            if (ReactFeatureFlags.enableFabricRenderer && ReactNativeFeatureFlags.useFabricInterop()) {
                exportedCustomBubblingEventTypeConstants = normalizeEventTypes(exportedCustomBubblingEventTypeConstants);
            }
            recursiveMerge(map3, exportedCustomBubblingEventTypeConstants);
            recursiveMerge(exportedCustomBubblingEventTypeConstants, map);
            mapNewHashMap.put(BUBBLING_EVENTS_KEY, exportedCustomBubblingEventTypeConstants);
        } else if (map != null) {
            mapNewHashMap.put(BUBBLING_EVENTS_KEY, map);
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants = viewManager.getExportedCustomDirectEventTypeConstants();
        validateDirectEventNames(viewManager.getName(), exportedCustomDirectEventTypeConstants);
        if (exportedCustomDirectEventTypeConstants != null) {
            if (ReactFeatureFlags.enableFabricRenderer && ReactNativeFeatureFlags.useFabricInterop()) {
                exportedCustomDirectEventTypeConstants = normalizeEventTypes(exportedCustomDirectEventTypeConstants);
            }
            recursiveMerge(map4, exportedCustomDirectEventTypeConstants);
            recursiveMerge(exportedCustomDirectEventTypeConstants, map2);
            mapNewHashMap.put(DIRECT_EVENTS_KEY, exportedCustomDirectEventTypeConstants);
        } else if (map2 != null) {
            mapNewHashMap.put(DIRECT_EVENTS_KEY, map2);
        }
        Map<String, Object> exportedViewConstants = viewManager.getExportedViewConstants();
        if (exportedViewConstants != null) {
            mapNewHashMap.put("Constants", exportedViewConstants);
        }
        Map<String, Integer> commandsMap = viewManager.getCommandsMap();
        if (commandsMap != null) {
            mapNewHashMap.put("Commands", commandsMap);
        }
        Map<String, String> nativeProps = viewManager.getNativeProps();
        if (!nativeProps.isEmpty()) {
            mapNewHashMap.put("NativeProps", nativeProps);
        }
        return mapNewHashMap;
    }

    static Map normalizeEventTypes(Map map) {
        String strSubstring;
        if (map == null) {
            return null;
        }
        HashSet<String> hashSet = new HashSet();
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (!str.startsWith("top")) {
                    hashSet.add(str);
                }
            }
        }
        if (!(map instanceof HashMap)) {
            map = new HashMap(map);
        }
        for (String str2 : hashSet) {
            Object obj2 = map.get(str2);
            if (str2.startsWith("on")) {
                strSubstring = str2.substring(2);
            } else {
                strSubstring = str2.substring(0, 1).toUpperCase() + str2.substring(1);
            }
            map.put("top" + strSubstring, obj2);
        }
        return map;
    }

    private static void recursiveMerge(Map map, Map map2) {
        if (map == null || map2 == null || map2.isEmpty()) {
            return;
        }
        for (Object obj : map2.keySet()) {
            Object obj2 = map2.get(obj);
            Object obj3 = map.get(obj);
            if (obj3 != null && (obj2 instanceof Map) && (obj3 instanceof Map)) {
                if (!(obj3 instanceof HashMap)) {
                    HashMap map3 = new HashMap((Map) obj3);
                    map.replace(obj, map3);
                    obj3 = map3;
                }
                recursiveMerge((Map) obj3, (Map) obj2);
            } else {
                map.put(obj, obj2);
            }
        }
    }
}
