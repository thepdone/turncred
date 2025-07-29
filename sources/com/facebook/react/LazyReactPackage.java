package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated(since = "This class is deprecated, please use BaseReactPackage instead.")
/* loaded from: classes4.dex */
public abstract class LazyReactPackage implements ReactPackage {
    protected abstract List<ModuleSpec> getNativeModules(ReactApplicationContext reactApplicationContext);

    public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

    Iterable<ModuleHolder> getNativeModuleIterator(ReactApplicationContext reactApplicationContext) {
        final Map<String, ReactModuleInfo> reactModuleInfos = getReactModuleInfoProvider().getReactModuleInfos();
        final List<ModuleSpec> nativeModules = getNativeModules(reactApplicationContext);
        return new Iterable() { // from class: com.facebook.react.LazyReactPackage$$ExternalSyntheticLambda0
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return this.f$0.lambda$getNativeModuleIterator$0(nativeModules, reactModuleInfos);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterator lambda$getNativeModuleIterator$0(final List list, final Map map) {
        return new Iterator<ModuleHolder>() { // from class: com.facebook.react.LazyReactPackage.1
            int position = 0;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public ModuleHolder next() {
                List list2 = list;
                int i = this.position;
                this.position = i + 1;
                ModuleSpec moduleSpec = (ModuleSpec) list2.get(i);
                String name = moduleSpec.getName();
                ReactModuleInfo reactModuleInfo = (ReactModuleInfo) map.get(name);
                if (reactModuleInfo == null) {
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, name);
                    try {
                        NativeModule nativeModule = moduleSpec.getProvider().get();
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                        return new ModuleHolder(nativeModule);
                    } catch (Throwable th) {
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                        throw th;
                    }
                }
                return new ModuleHolder(reactModuleInfo, moduleSpec.getProvider());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.position < list.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove native modules from the list");
            }
        };
    }

    @Override // com.facebook.react.ReactPackage
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        for (ModuleSpec moduleSpec : getNativeModules(reactApplicationContext)) {
            SystraceMessage.beginSection(0L, "createNativeModule").flush();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, moduleSpec.getName());
            try {
                NativeModule nativeModule = moduleSpec.getProvider().get();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                SystraceMessage.endSection(0L).flush();
                arrayList.add(nativeModule);
            } catch (Throwable th) {
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                SystraceMessage.endSection(0L).flush();
                throw th;
            }
        }
        return arrayList;
    }

    public List<ModuleSpec> getViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ModuleSpec> viewManagers = getViewManagers(reactApplicationContext);
        if (viewManagers == null || viewManagers.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ModuleSpec> it = viewManagers.iterator();
        while (it.hasNext()) {
            arrayList.add((ViewManager) it.next().getProvider().get());
        }
        return arrayList;
    }
}
