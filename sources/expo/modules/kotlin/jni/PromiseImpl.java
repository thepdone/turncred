package expo.modules.kotlin.jni;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PromiseAlreadySettledException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromiseImpl.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\u001e\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0082\bJ$\u0010\u0015\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bJ$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\"H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020#H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0$H\u0016J\u001e\u0010\u001d\u001a\u00020\u00122\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001f0%H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "callback", "Lexpo/modules/kotlin/jni/JavaCallback;", "(Lexpo/modules/kotlin/jni/JavaCallback;)V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "getCallback$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "fullFunctionName", "", "<set-?>", "", "wasSettled", "getWasSettled$expo_modules_core_release", "()Z", "checkIfWasSettled", "", "body", "Lkotlin/Function0;", "decorateWithDebugInformation", "moduleName", "functionName", "reject", "code", "message", "cause", "", "resolve", "value", "", "result", "", "", "", "", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromiseImpl implements Promise {
    public static final int $stable = 8;
    private WeakReference<AppContext> appContextHolder;
    private final JavaCallback callback;
    private String fullFunctionName;
    private boolean wasSettled;

    public PromiseImpl(JavaCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    /* renamed from: getCallback$expo_modules_core_release, reason: from getter */
    public final JavaCallback getCallback() {
        return this.callback;
    }

    /* renamed from: getWasSettled$expo_modules_core_release, reason: from getter */
    public final boolean getWasSettled() {
        return this.wasSettled;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Collection<? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.callback.invoke(result);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.callback.invoke(result);
    }

    private final void checkIfWasSettled(Function0<Unit> body) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = "unknown";
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (weakReference == null || (appContext = weakReference.get()) == null) {
                throw promiseAlreadySettledException;
            }
            appContext.getErrorManager();
            throw promiseAlreadySettledException;
        }
        body.invoke();
        this.wasSettled = true;
    }

    public final void decorateWithDebugInformation(WeakReference<AppContext> appContextHolder, String moduleName, String functionName) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.appContextHolder = appContextHolder;
        this.fullFunctionName = moduleName + "." + functionName;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(value);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke();
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(String result) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(code, "code");
        if (!this.wasSettled) {
            JavaCallback javaCallback = this.callback;
            if (message == null) {
                message = cause != null ? cause.getMessage() : null;
                if (message == null) {
                    message = "unknown";
                }
            }
            javaCallback.invoke(code, message);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str != null ? str : "unknown");
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }
}
