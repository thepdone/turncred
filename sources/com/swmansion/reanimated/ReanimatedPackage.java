package com.swmansion.reanimated;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ReanimatedUIManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.systrace.Systrace;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes5.dex */
public class ReanimatedPackage extends TurboReactPackage implements ReactPackage {
    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0(Map map) {
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeReanimatedModuleSpec.NAME)) {
            return new ReanimatedModule(reactApplicationContext);
        }
        if (str.equals(UIManagerModule.NAME)) {
            return createUIManager(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        Class[] clsArr = {ReanimatedModule.class, ReanimatedUIManager.class};
        final HashMap map = new HashMap();
        for (int i = 0; i < 2; i++) {
            Class cls = clsArr[i];
            ReactModule reactModule = (ReactModule) Objects.requireNonNull((ReactModule) cls.getAnnotation(ReactModule.class));
            map.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), true, reactModule.needsEagerInit(), reactModule.isCxxModule(), false));
        }
        return new ReactModuleInfoProvider() { // from class: com.swmansion.reanimated.ReanimatedPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return ReanimatedPackage.lambda$getReactModuleInfoProvider$0(map);
            }
        };
    }

    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        Systrace.beginSection(0L, "createUIManagerModule");
        try {
            return ReanimatedUIManagerFactory.create(reactApplicationContext, getReactInstanceManager(reactApplicationContext).getOrCreateViewManagers(reactApplicationContext), -1);
        } finally {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    public ReactInstanceManager getReactInstanceManager(ReactApplicationContext reactApplicationContext) {
        return ((ReactApplication) reactApplicationContext.getApplicationContext()).getReactNativeHost().getReactInstanceManager();
    }
}
