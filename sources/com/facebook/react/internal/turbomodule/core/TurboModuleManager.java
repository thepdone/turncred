package com.facebook.react.internal.turbomodule.core;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.internal.turbomodule.core.TurboModuleInteropUtils;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class TurboModuleManager implements TurboModuleRegistry {
    private static final String TAG = "TurboModuleManager";
    private final TurboModuleManagerDelegate mDelegate;
    private final List<String> mEagerInitModuleNames;
    private final HybridData mHybridData;
    private final ModuleProvider mLegacyModuleProvider;
    private final Object mModuleCleanupLock = new Object();
    private boolean mModuleCleanupStarted = false;
    private final Map<String, ModuleHolder> mModuleHolders = new HashMap();
    private final ModuleProvider mTurboModuleProvider;

    /* JADX INFO: Access modifiers changed from: private */
    interface ModuleProvider {
        NativeModule getModule(String str);
    }

    private native HybridData initHybrid(RuntimeExecutor runtimeExecutor, CallInvokerHolderImpl callInvokerHolderImpl, NativeMethodCallInvokerHolderImpl nativeMethodCallInvokerHolderImpl, TurboModuleManagerDelegate turboModuleManagerDelegate);

    private native void installJSIBindings(boolean z);

    static /* synthetic */ NativeModule lambda$new$0(String str) {
        return null;
    }

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    public TurboModuleManager(RuntimeExecutor runtimeExecutor, final TurboModuleManagerDelegate turboModuleManagerDelegate, CallInvokerHolder callInvokerHolder, NativeMethodCallInvokerHolder nativeMethodCallInvokerHolder) {
        this.mDelegate = turboModuleManagerDelegate;
        this.mHybridData = initHybrid(runtimeExecutor, (CallInvokerHolderImpl) callInvokerHolder, (NativeMethodCallInvokerHolderImpl) nativeMethodCallInvokerHolder, turboModuleManagerDelegate);
        installJSIBindings(shouldEnableLegacyModuleInterop());
        this.mEagerInitModuleNames = turboModuleManagerDelegate == null ? Collections.emptyList() : turboModuleManagerDelegate.getEagerInitModuleNames();
        ModuleProvider moduleProvider = new ModuleProvider() { // from class: com.facebook.react.internal.turbomodule.core.TurboModuleManager$$ExternalSyntheticLambda0
            @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleProvider
            public final NativeModule getModule(String str) {
                return TurboModuleManager.lambda$new$0(str);
            }
        };
        this.mTurboModuleProvider = turboModuleManagerDelegate == null ? moduleProvider : new ModuleProvider() { // from class: com.facebook.react.internal.turbomodule.core.TurboModuleManager$$ExternalSyntheticLambda1
            @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleProvider
            public final NativeModule getModule(String str) {
                return TurboModuleManager.lambda$new$1(turboModuleManagerDelegate, str);
            }
        };
        if (turboModuleManagerDelegate != null && shouldEnableLegacyModuleInterop()) {
            moduleProvider = new ModuleProvider() { // from class: com.facebook.react.internal.turbomodule.core.TurboModuleManager$$ExternalSyntheticLambda2
                @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleProvider
                public final NativeModule getModule(String str) {
                    return TurboModuleManager.lambda$new$2(turboModuleManagerDelegate, str);
                }
            };
        }
        this.mLegacyModuleProvider = moduleProvider;
    }

    static /* synthetic */ NativeModule lambda$new$1(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        return (NativeModule) turboModuleManagerDelegate.getModule(str);
    }

    static /* synthetic */ NativeModule lambda$new$2(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        NativeModule legacyModule = turboModuleManagerDelegate.getLegacyModule(str);
        if (legacyModule == null) {
            return null;
        }
        Assertions.assertCondition(!(legacyModule instanceof TurboModule), "NativeModule \"" + str + "\" is a TurboModule");
        return legacyModule;
    }

    private boolean isTurboModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_isModuleRegistered(str);
    }

    private boolean isLegacyModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_isLegacyModuleRegistered(str);
    }

    private boolean shouldEnableLegacyModuleInterop() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_shouldEnableLegacyModuleInterop();
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public List<String> getEagerInitModuleNames() {
        return this.mEagerInitModuleNames;
    }

    private static List<TurboModuleInteropUtils.MethodDescriptor> getMethodDescriptorsFromModule(NativeModule nativeModule) {
        return TurboModuleInteropUtils.getMethodDescriptorsFromModule(nativeModule);
    }

    private NativeModule getLegacyJavaModule(String str) {
        if (!isLegacyModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) || (module instanceof TurboModule)) {
            return null;
        }
        return module;
    }

    private CxxModuleWrapper getLegacyCxxModule(String str) {
        if (!isLegacyModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if (!(module instanceof CxxModuleWrapper) || (module instanceof TurboModule)) {
            return null;
        }
        return (CxxModuleWrapper) module;
    }

    private CxxModuleWrapper getTurboLegacyCxxModule(String str) {
        if (!isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) && (module instanceof TurboModule)) {
            return (CxxModuleWrapper) module;
        }
        return null;
    }

    private TurboModule getTurboJavaModule(String str) {
        if (!isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) || !(module instanceof TurboModule)) {
            return null;
        }
        return (TurboModule) module;
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public NativeModule getModule(String str) {
        synchronized (this.mModuleCleanupLock) {
            if (this.mModuleCleanupStarted) {
                FLog.e(TAG, "getModule(): Tried to get module \"%s\", but TurboModuleManager was tearing down (legacy: %b, turbo: %b)", str, Boolean.valueOf(isLegacyModule(str)), Boolean.valueOf(isTurboModule(str)));
                return null;
            }
            if (!this.mModuleHolders.containsKey(str)) {
                this.mModuleHolders.put(str, new ModuleHolder());
            }
            ModuleHolder moduleHolder = this.mModuleHolders.get(str);
            TurboModulePerfLogger.moduleCreateStart(str, moduleHolder.getModuleId());
            NativeModule orCreateModule = getOrCreateModule(str, moduleHolder, true);
            if (orCreateModule != null) {
                TurboModulePerfLogger.moduleCreateEnd(str, moduleHolder.getModuleId());
            } else {
                TurboModulePerfLogger.moduleCreateFail(str, moduleHolder.getModuleId());
            }
            return orCreateModule;
        }
    }

    private NativeModule getOrCreateModule(String str, ModuleHolder moduleHolder, boolean z) {
        boolean z2;
        NativeModule module;
        synchronized (moduleHolder) {
            if (moduleHolder.isDoneCreatingModule()) {
                if (z) {
                    TurboModulePerfLogger.moduleCreateCacheHit(str, moduleHolder.getModuleId());
                }
                return moduleHolder.getModule();
            }
            boolean z3 = false;
            if (moduleHolder.isCreatingModule()) {
                z2 = false;
            } else {
                moduleHolder.startCreatingModule();
                z2 = true;
            }
            if (z2) {
                TurboModulePerfLogger.moduleCreateConstructStart(str, moduleHolder.getModuleId());
                NativeModule module2 = this.mTurboModuleProvider.getModule(str);
                if (module2 == null) {
                    module2 = this.mLegacyModuleProvider.getModule(str);
                }
                TurboModulePerfLogger.moduleCreateConstructEnd(str, moduleHolder.getModuleId());
                TurboModulePerfLogger.moduleCreateSetUpStart(str, moduleHolder.getModuleId());
                if (module2 != null) {
                    synchronized (moduleHolder) {
                        moduleHolder.setModule(module2);
                    }
                    module2.initialize();
                } else {
                    FLog.e(TAG, "getOrCreateModule(): Unable to create module \"%s\" (legacy: %b, turbo: %b)", str, Boolean.valueOf(isLegacyModule(str)), Boolean.valueOf(isTurboModule(str)));
                }
                TurboModulePerfLogger.moduleCreateSetUpEnd(str, moduleHolder.getModuleId());
                synchronized (moduleHolder) {
                    moduleHolder.endCreatingModule();
                    moduleHolder.notifyAll();
                }
                return module2;
            }
            synchronized (moduleHolder) {
                while (moduleHolder.isCreatingModule()) {
                    try {
                        moduleHolder.wait();
                    } catch (InterruptedException unused) {
                        z3 = true;
                    }
                }
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                module = moduleHolder.getModule();
            }
            return module;
        }
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public Collection<NativeModule> getModules() {
        ArrayList<ModuleHolder> arrayList = new ArrayList();
        synchronized (this.mModuleCleanupLock) {
            arrayList.addAll(this.mModuleHolders.values());
        }
        ArrayList arrayList2 = new ArrayList();
        for (ModuleHolder moduleHolder : arrayList) {
            synchronized (moduleHolder) {
                if (moduleHolder.getModule() != null) {
                    arrayList2.add(moduleHolder.getModule());
                }
            }
        }
        return arrayList2;
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public boolean hasModule(String str) {
        ModuleHolder moduleHolder;
        synchronized (this.mModuleCleanupLock) {
            moduleHolder = this.mModuleHolders.get(str);
        }
        if (moduleHolder == null) {
            return false;
        }
        synchronized (moduleHolder) {
            return moduleHolder.getModule() != null;
        }
    }

    @Override // com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry
    public void invalidate() {
        synchronized (this.mModuleCleanupLock) {
            this.mModuleCleanupStarted = true;
        }
        for (Map.Entry<String, ModuleHolder> entry : this.mModuleHolders.entrySet()) {
            NativeModule orCreateModule = getOrCreateModule(entry.getKey(), entry.getValue(), false);
            if (orCreateModule != null) {
                orCreateModule.invalidate();
            }
        }
        this.mModuleHolders.clear();
        this.mHybridData.resetNative();
    }

    private static class ModuleHolder {
        private static volatile int sHolderCount;
        private volatile NativeModule mModule = null;
        private volatile boolean mIsTryingToCreate = false;
        private volatile boolean mIsDoneCreatingModule = false;
        private volatile int mModuleId = sHolderCount;

        public ModuleHolder() {
            sHolderCount++;
        }

        int getModuleId() {
            return this.mModuleId;
        }

        void setModule(NativeModule nativeModule) {
            this.mModule = nativeModule;
        }

        NativeModule getModule() {
            return this.mModule;
        }

        void startCreatingModule() {
            this.mIsTryingToCreate = true;
        }

        void endCreatingModule() {
            this.mIsTryingToCreate = false;
            this.mIsDoneCreatingModule = true;
        }

        boolean isDoneCreatingModule() {
            return this.mIsDoneCreatingModule;
        }

        boolean isCreatingModule() {
            return this.mIsTryingToCreate;
        }
    }
}
