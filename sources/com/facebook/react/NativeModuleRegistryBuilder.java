package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class NativeModuleRegistryBuilder {
    private final Map<String, ModuleHolder> mModules = new HashMap();
    private final ReactApplicationContext mReactApplicationContext;

    public NativeModuleRegistryBuilder(ReactApplicationContext reactApplicationContext, ReactInstanceManager reactInstanceManager) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    public void processPackage(ReactPackage reactPackage) {
        Iterable<ModuleHolder> nativeModuleIterator;
        if (reactPackage instanceof LazyReactPackage) {
            nativeModuleIterator = ((LazyReactPackage) reactPackage).getNativeModuleIterator(this.mReactApplicationContext);
        } else if (reactPackage instanceof BaseReactPackage) {
            nativeModuleIterator = ((BaseReactPackage) reactPackage).getNativeModuleIterator(this.mReactApplicationContext);
        } else {
            nativeModuleIterator = ReactPackageHelper.getNativeModuleIterator(reactPackage, this.mReactApplicationContext);
        }
        for (ModuleHolder moduleHolder : nativeModuleIterator) {
            String name = moduleHolder.getName();
            if (this.mModules.containsKey(name)) {
                ModuleHolder moduleHolder2 = this.mModules.get(name);
                if (!moduleHolder.getCanOverrideExistingModule()) {
                    throw new IllegalStateException("Native module " + name + " tried to override " + moduleHolder2.getClassName() + ". Check the getPackages() method in MainApplication.java, it might be that module is being created twice. If this was your intention, set canOverrideExistingModule=true. This error may also be present if the package is present only once in getPackages() but is also automatically added later during build time by autolinking. Try removing the existing entry and rebuild.");
                }
                this.mModules.remove(moduleHolder2);
            }
            this.mModules.put(name, moduleHolder);
        }
    }

    public NativeModuleRegistry build() {
        return new NativeModuleRegistry(this.mReactApplicationContext, this.mModules);
    }
}
