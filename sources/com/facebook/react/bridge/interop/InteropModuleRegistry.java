package com.facebook.react.bridge.interop;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class InteropModuleRegistry {
    private final HashMap<Class, Object> supportedModules = new HashMap<>();

    public <T extends JavaScriptModule> boolean shouldReturnInteropModule(Class<T> cls) {
        return checkReactFeatureFlagsConditions() && this.supportedModules.containsKey(cls);
    }

    public <T extends JavaScriptModule> T getInteropModule(Class<T> cls) {
        if (checkReactFeatureFlagsConditions()) {
            return (T) this.supportedModules.get(cls);
        }
        return null;
    }

    public <T extends JavaScriptModule> void registerInteropModule(Class<T> cls, Object obj) {
        if (checkReactFeatureFlagsConditions()) {
            this.supportedModules.put(cls, obj);
        }
    }

    private boolean checkReactFeatureFlagsConditions() {
        return ReactFeatureFlags.enableFabricRenderer && ReactNativeFeatureFlags.useFabricInterop();
    }
}
