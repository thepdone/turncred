package com.shopify.reactnative.skia;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class RNSkiaPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNSkiaModule(reactApplicationContext));
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (str.equals("RNSkiaModule")) {
            return new RNSkiaModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new SkiaPictureViewManager(), new SkiaDomViewManager());
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.shopify.reactnative.skia.RNSkiaPackage.1
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public Map<String, ReactModuleInfo> getReactModuleInfos() {
                HashMap map = new HashMap();
                Class[] clsArr = new Class[1];
                ReactModule reactModule = (ReactModule) RNSkiaModule.class.getAnnotation(ReactModule.class);
                map.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), RNSkiaModule.class.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(RNSkiaModule.class)));
                return map;
            }
        };
    }
}
