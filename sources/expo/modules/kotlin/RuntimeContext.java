package expo.modules.kotlin;

import androidx.tracing.Trace;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuntimeContext.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020,J\b\u00102\u001a\u000203H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00064"}, d2 = {"Lexpo/modules/kotlin/RuntimeContext;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/kotlin/AppContext;Ljava/lang/ref/WeakReference;)V", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "appContextHolder", "classRegistry", "Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "getClassRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "coreModule", "Lexpo/modules/kotlin/ModuleHolder;", "Lexpo/modules/kotlin/defaultmodules/CoreModule;", "getCoreModule$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "getJniDeallocator", "()Lexpo/modules/kotlin/jni/JNIDeallocator;", "jsiContext", "Lexpo/modules/kotlin/jni/JSIContext;", "getJsiContext$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JSIContext;", "setJsiContext$expo_modules_core_release", "(Lexpo/modules/kotlin/jni/JSIContext;)V", "reactContext", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "getReactContextHolder", "()Ljava/lang/ref/WeakReference;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "sharedObjectRegistry", "Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "getSharedObjectRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "deallocate", "", "eval", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "source", "", "installJSIContext", "isJSIContextInitialized", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuntimeContext {
    public static final int $stable = 8;
    private final WeakReference<AppContext> appContextHolder;
    private final ClassRegistry classRegistry;
    private final ModuleHolder<CoreModule> coreModule;
    private final JNIDeallocator jniDeallocator;
    public JSIContext jsiContext;
    private final WeakReference<ReactApplicationContext> reactContextHolder;
    private final ModuleRegistry registry;
    private final SharedObjectRegistry sharedObjectRegistry;

    public RuntimeContext(AppContext appContext, WeakReference<ReactApplicationContext> reactContextHolder) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.reactContextHolder = reactContextHolder;
        this.appContextHolder = UtilsKt.weak(appContext);
        this.registry = new ModuleRegistry(UtilsKt.weak(this));
        CoreModule coreModule = new CoreModule();
        coreModule.set_runtimeContext$expo_modules_core_release(this);
        this.coreModule = new ModuleHolder<>(coreModule);
        this.jniDeallocator = new JNIDeallocator(false, 1, null);
        this.sharedObjectRegistry = new SharedObjectRegistry(this);
        this.classRegistry = new ClassRegistry();
    }

    public final WeakReference<ReactApplicationContext> getReactContextHolder() {
        return this.reactContextHolder;
    }

    public final AppContext getAppContext() {
        return this.appContextHolder.get();
    }

    public final ReactApplicationContext getReactContext() {
        return getReactContextHolder().get();
    }

    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    public final JSIContext getJsiContext$expo_modules_core_release() {
        JSIContext jSIContext = this.jsiContext;
        if (jSIContext != null) {
            return jSIContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsiContext");
        return null;
    }

    public final void setJsiContext$expo_modules_core_release(JSIContext jSIContext) {
        Intrinsics.checkNotNullParameter(jSIContext, "<set-?>");
        this.jsiContext = jSIContext;
    }

    private final boolean isJSIContextInitialized() {
        return this.jsiContext != null;
    }

    public final JavaScriptValue eval(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return getJsiContext$expo_modules_core_release().evaluateScript(source);
    }

    public final ModuleHolder<CoreModule> getCoreModule$expo_modules_core_release() {
        return this.coreModule;
    }

    public final JNIDeallocator getJniDeallocator() {
        return this.jniDeallocator;
    }

    /* renamed from: getSharedObjectRegistry$expo_modules_core_release, reason: from getter */
    public final SharedObjectRegistry getSharedObjectRegistry() {
        return this.sharedObjectRegistry;
    }

    /* renamed from: getClassRegistry$expo_modules_core_release, reason: from getter */
    public final ClassRegistry getClassRegistry() {
        return this.classRegistry;
    }

    public final void installJSIContext() {
        synchronized (this) {
            if (isJSIContextInitialized()) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ JSI interop was already installed", null, 2, null);
                return;
            }
            Trace.beginSection("[ExpoModulesCore] " + (this + ".installJSIContext"));
            try {
                try {
                    setJsiContext$expo_modules_core_release(new JSIContext());
                    ReactApplicationContext reactApplicationContext = getReactContextHolder().get();
                    if (reactApplicationContext != null) {
                        Intrinsics.checkNotNull(reactApplicationContext);
                        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
                        if (javaScriptContextHolder != null) {
                            Long lValueOf = Long.valueOf(javaScriptContextHolder.get());
                            if (lValueOf.longValue() == 0) {
                                lValueOf = null;
                            }
                            if (lValueOf != null) {
                                long jLongValue = lValueOf.longValue();
                                if (reactApplicationContext.isBridgeless()) {
                                    JSIContext jsiContext$expo_modules_core_release = getJsiContext$expo_modules_core_release();
                                    RuntimeExecutor runtimeExecutor = reactApplicationContext.getCatalystInstance().getRuntimeExecutor();
                                    Intrinsics.checkNotNull(runtimeExecutor);
                                    jsiContext$expo_modules_core_release.installJSIForBridgeless(this, jLongValue, runtimeExecutor);
                                } else {
                                    JSIContext jsiContext$expo_modules_core_release2 = getJsiContext$expo_modules_core_release();
                                    CallInvokerHolder jSCallInvokerHolder = reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder();
                                    Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
                                    jsiContext$expo_modules_core_release2.installJSI(this, jLongValue, (CallInvokerHolderImpl) jSCallInvokerHolder);
                                }
                                CoreLoggerKt.getLogger().info("✅ JSI interop was installed");
                            } else {
                                Logger.error$default(CoreLoggerKt.getLogger(), "❌ Cannot install JSI interop - JS runtime pointer is null", null, 2, null);
                            }
                        }
                    }
                } finally {
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                    Unit unit2 = Unit.INSTANCE;
                }
                Unit unit3 = Unit.INSTANCE;
                Trace.endSection();
                Unit unit22 = Unit.INSTANCE;
            } catch (Throwable th) {
                Trace.endSection();
            }
        }
    }

    public final void deallocate() {
        ((CoreModule) this.coreModule.getModule()).set_runtimeContext$expo_modules_core_release(null);
        this.jniDeallocator.deallocate$expo_modules_core_release();
    }
}
