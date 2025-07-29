package io.sentry.react;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class RNSentryPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(RNSentryModuleImpl.NAME)) {
            return new RNSentryModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: io.sentry.react.RNSentryPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNSentryPackage.lambda$getReactModuleInfoProvider$0();
            }
        };
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap map = new HashMap();
        map.put(RNSentryModuleImpl.NAME, new ReactModuleInfo(RNSentryModuleImpl.NAME, RNSentryModuleImpl.NAME, false, false, true, false, false));
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNSentryOnDrawReporterManager(reactApplicationContext));
    }
}
