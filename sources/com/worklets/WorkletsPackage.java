package com.worklets;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class WorkletsPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(WorkletsModule.NAME)) {
            return new WorkletsModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.worklets.WorkletsPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return WorkletsPackage.lambda$getReactModuleInfoProvider$0();
            }
        };
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap map = new HashMap();
        ReactModule reactModule = (ReactModule) WorkletsModule.class.getAnnotation(ReactModule.class);
        map.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), WorkletsModule.class.getName(), true, reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(WorkletsModule.class)));
        return map;
    }
}
