package com.reactnativecommunity.asyncstorage;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* loaded from: classes5.dex */
public class AsyncStoragePackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage
    protected List<ModuleSpec> getViewManagers(ReactApplicationContext reactApplicationContext) {
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, @Nonnull ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (str.equals(AsyncStorageModule.NAME)) {
            return new AsyncStorageModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.reactnativecommunity.asyncstorage.AsyncStoragePackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return new ReactModuleInfoProvider() { // from class: com.reactnativecommunity.asyncstorage.AsyncStoragePackage.1
                @Override // com.facebook.react.module.model.ReactModuleInfoProvider
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    HashMap map = new HashMap();
                    Class[] clsArr = new Class[1];
                    ReactModule reactModule = (ReactModule) AsyncStorageModule.class.getAnnotation(ReactModule.class);
                    map.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), AsyncStorageModule.class.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), false));
                    return map;
                }
            };
        } catch (IllegalAccessException e) {
            e = e;
            throw new RuntimeException("No ReactModuleInfoProvider for com.reactnativecommunity.asyncstorage.AsyncStoragePackage$$ReactModuleInfoProvider", e);
        } catch (InstantiationException e2) {
            e = e2;
            throw new RuntimeException("No ReactModuleInfoProvider for com.reactnativecommunity.asyncstorage.AsyncStoragePackage$$ReactModuleInfoProvider", e);
        }
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
