package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.exception.JavaScriptEvaluateException;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectId;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSIContext.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0010H\u0086 J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\t\u0010\u0015\u001a\u00020\u000eH\u0086 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086 J\b\u0010\u001a\u001a\u00020\u000eH\u0004J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0019H\u0007J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190 H\u0007¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u0004\u0018\u00010\u00102\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0007J\u0012\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\t\u0010&\u001a\u00020\u0010H\u0086 J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u0019H\u0007J\t\u0010)\u001a\u00020\u0005H\u0082 J\u001e\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J!\u0010*\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u0010.\u001a\u00020/H\u0082 J\u001e\u00102\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\u0006\u00103\u001a\u000204J!\u00102\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u00103\u001a\u000204H\u0082 J\u001c\u00105\u001a\u00020\u000e2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u00106\u001a\u00020\u0010H\u0007J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010#\u001a\u0002082\u0006\u00106\u001a\u00020\u0010H\u0007J\u0019\u00109\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u0010H\u0086 R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006;"}, d2 = {"Lexpo/modules/kotlin/jni/JSIContext;", "Lexpo/modules/kotlin/jni/Destructible;", "Ljava/lang/AutoCloseable;", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/RuntimeContext;", "getRuntimeContextHolder", "()Ljava/lang/ref/WeakReference;", "setRuntimeContextHolder", "(Ljava/lang/ref/WeakReference;)V", "close", "", "createObject", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "deallocate", "deleteSharedObject", "id", "", "drainJSEventLoop", "evaluateScript", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "script", "", "finalize", "getCoreModuleObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "getJavaScriptModuleObject", "name", "getJavaScriptModulesName", "", "()[Ljava/lang/String;", "getJavascriptClass", "native", "Ljava/lang/Class;", "getSharedObject", "global", "hasModule", "", "initHybrid", "installJSI", "runtimeContext", "jsRuntimePointer", "", "jsInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "installJSIForBridgeless", "runtimeExecutor", "Lcom/facebook/react/bridge/RuntimeExecutor;", "registerClass", "js", "registerSharedObject", "", "setNativeStateForSharedObject", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSIContext implements Destructible, AutoCloseable {
    private final HybridData mHybridData = initHybrid();
    public WeakReference<RuntimeContext> runtimeContextHolder;
    public static final int $stable = 8;

    private final native HybridData initHybrid();

    private final native void installJSI(long jsRuntimePointer, JNIDeallocator jniDeallocator, CallInvokerHolderImpl jsInvokerHolder);

    private final native void installJSIForBridgeless(long jsRuntimePointer, JNIDeallocator jniDeallocator, RuntimeExecutor runtimeExecutor);

    public final native JavaScriptObject createObject();

    public final native void drainJSEventLoop();

    public final native JavaScriptValue evaluateScript(String script) throws JavaScriptEvaluateException;

    public final native JavaScriptObject global();

    public final native void setNativeStateForSharedObject(int id, JavaScriptObject js);

    public final WeakReference<RuntimeContext> getRuntimeContextHolder() {
        WeakReference<RuntimeContext> weakReference = this.runtimeContextHolder;
        if (weakReference != null) {
            return weakReference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("runtimeContextHolder");
        return null;
    }

    public final void setRuntimeContextHolder(WeakReference<RuntimeContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.runtimeContextHolder = weakReference;
    }

    public final void installJSI(RuntimeContext runtimeContext, long jsRuntimePointer, CallInvokerHolderImpl jsInvokerHolder) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        Intrinsics.checkNotNullParameter(jsInvokerHolder, "jsInvokerHolder");
        setRuntimeContextHolder(UtilsKt.weak(runtimeContext));
        installJSI(jsRuntimePointer, runtimeContext.getJniDeallocator(), jsInvokerHolder);
    }

    public final void installJSIForBridgeless(RuntimeContext runtimeContext, long jsRuntimePointer, RuntimeExecutor runtimeExecutor) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        Intrinsics.checkNotNullParameter(runtimeExecutor, "runtimeExecutor");
        setRuntimeContextHolder(UtilsKt.weak(runtimeContext));
        installJSIForBridgeless(jsRuntimePointer, runtimeContext.getJniDeallocator(), runtimeExecutor);
    }

    public final JavaScriptModuleObject getJavaScriptModuleObject(String name) {
        ModuleRegistry registry;
        ModuleHolder<?> moduleHolder;
        Intrinsics.checkNotNullParameter(name, "name");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (registry = runtimeContext.getRegistry()) == null || (moduleHolder = registry.getModuleHolder(name)) == null) {
            return null;
        }
        return moduleHolder.getJsObject();
    }

    public final boolean hasModule(String name) {
        ModuleRegistry registry;
        Intrinsics.checkNotNullParameter(name, "name");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (registry = runtimeContext.getRegistry()) == null) {
            return false;
        }
        return registry.hasModule(name);
    }

    public final String[] getJavaScriptModulesName() {
        ModuleRegistry registry;
        Map<String, ModuleHolder<?>> registry2;
        Set<String> setKeySet;
        String[] strArr;
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        return (runtimeContext == null || (registry = runtimeContext.getRegistry()) == null || (registry2 = registry.getRegistry()) == null || (setKeySet = registry2.keySet()) == null || (strArr = (String[]) setKeySet.toArray(new String[0])) == null) ? new String[0] : strArr;
    }

    public final void registerSharedObject(Object obj, JavaScriptObject js) {
        SharedObjectRegistry sharedObjectRegistry;
        Intrinsics.checkNotNullParameter(obj, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (sharedObjectRegistry = runtimeContext.getSharedObjectRegistry()) == null) {
            return;
        }
        SharedObjectId.m5737boximpl(sharedObjectRegistry.m5750add5WKnsLU$expo_modules_core_release((SharedObject) obj, js));
    }

    public final JavaScriptObject getSharedObject(int id) {
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null) {
            return null;
        }
        return SharedObjectId.m5742toJavaScriptObjectNullimpl(SharedObjectId.m5738constructorimpl(id), runtimeContext);
    }

    public final void deleteSharedObject(int id) {
        SharedObjectRegistry sharedObjectRegistry;
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (sharedObjectRegistry = runtimeContext.getSharedObjectRegistry()) == null) {
            return;
        }
        sharedObjectRegistry.m5751deletekyJHjyY$expo_modules_core_release(SharedObjectId.m5738constructorimpl(id));
    }

    public final void registerClass(Class<?> cls, JavaScriptObject js) {
        ClassRegistry classRegistry;
        Intrinsics.checkNotNullParameter(cls, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (classRegistry = runtimeContext.getClassRegistry()) == null) {
            return;
        }
        classRegistry.add$expo_modules_core_release(cls, js);
    }

    public final JavaScriptObject getJavascriptClass(Class<?> cls) {
        ClassRegistry classRegistry;
        Intrinsics.checkNotNullParameter(cls, "native");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (classRegistry = runtimeContext.getClassRegistry()) == null) {
            return null;
        }
        return classRegistry.toJavaScriptObject$expo_modules_core_release(cls);
    }

    public final JavaScriptModuleObject getCoreModuleObject() {
        ModuleHolder<CoreModule> coreModule$expo_modules_core_release;
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (coreModule$expo_modules_core_release = runtimeContext.getCoreModule$expo_modules_core_release()) == null) {
            return null;
        }
        return coreModule$expo_modules_core_release.getJsObject();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        deallocate();
    }
}
