package expo.modules.kotlin.modules;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.providers.AppContextProvider;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Module.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H&J3\u0010$\u001a\u00020%\"\u0012\b\u0000\u0010&*\u00020'*\b\u0012\u0004\u0012\u0002H&0(2\u0006\u0010)\u001a\u0002H&2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0002\u0010,JA\u0010$\u001a\u00020%\"\u0012\b\u0000\u0010&*\u00020'*\b\u0012\u0004\u0012\u0002H&0(2\u0006\u0010)\u001a\u0002H&2\u0018\b\u0002\u0010*\u001a\u0012\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010-¢\u0006\u0002\u00100J\u001a\u0010$\u001a\u00020%2\u0006\u00101\u001a\u00020.2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+J$\u0010$\u001a\u00020%2\u0006\u00101\u001a\u00020.2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010/0-R\"\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\u0007¨\u00062"}, d2 = {"Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/kotlin/providers/AppContextProvider;", "()V", "_runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "get_runtimeContext$expo_modules_core_release$annotations", "get_runtimeContext$expo_modules_core_release", "()Lexpo/modules/kotlin/RuntimeContext;", "set_runtimeContext$expo_modules_core_release", "(Lexpo/modules/kotlin/RuntimeContext;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "coroutineScopeDelegate", "Lkotlin/Lazy;", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScopeDelegate$annotations", "getCoroutineScopeDelegate", "()Lkotlin/Lazy;", "setCoroutineScopeDelegate", "(Lkotlin/Lazy;)V", "moduleEventEmitter", "Lexpo/modules/kotlin/events/EventEmitter;", "getModuleEventEmitter", "()Lexpo/modules/kotlin/events/EventEmitter;", "moduleEventEmitter$delegate", "Lkotlin/Lazy;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "runtimeContext", "getRuntimeContext", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "sendEvent", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/types/Enumerable;", "", "enum", "body", "Landroid/os/Bundle;", "(Ljava/lang/Enum;Landroid/os/Bundle;)V", "", "", "", "(Ljava/lang/Enum;Ljava/util/Map;)V", "name", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Module implements AppContextProvider {
    public static final int $stable = 8;
    private RuntimeContext _runtimeContext;
    public Lazy<? extends CoroutineScope> coroutineScopeDelegate;

    /* renamed from: moduleEventEmitter$delegate, reason: from kotlin metadata */
    private final Lazy moduleEventEmitter = LazyKt.lazy(new Function0<EventEmitter>() { // from class: expo.modules.kotlin.modules.Module$moduleEventEmitter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EventEmitter invoke() {
            return this.this$0.getAppContext().eventEmitter(this.this$0);
        }
    });

    public static /* synthetic */ void getCoroutineScopeDelegate$annotations() {
    }

    public static /* synthetic */ void get_runtimeContext$expo_modules_core_release$annotations() {
    }

    public abstract ModuleDefinitionData definition();

    /* renamed from: get_runtimeContext$expo_modules_core_release, reason: from getter */
    public final RuntimeContext get_runtimeContext() {
        return this._runtimeContext;
    }

    public final void set_runtimeContext$expo_modules_core_release(RuntimeContext runtimeContext) {
        this._runtimeContext = runtimeContext;
    }

    public final RuntimeContext getRuntimeContext() {
        RuntimeContext runtimeContext = this._runtimeContext;
        if (runtimeContext != null) {
            return runtimeContext;
        }
        throw new IllegalArgumentException("The module wasn't created! You can't access the runtime context.".toString());
    }

    @Override // expo.modules.kotlin.providers.AppContextProvider
    public AppContext getAppContext() {
        RuntimeContext runtimeContext = this._runtimeContext;
        AppContext appContext = runtimeContext != null ? runtimeContext.getAppContext() : null;
        if (appContext != null) {
            return appContext;
        }
        throw new IllegalArgumentException("You attempted to access the app context before the module was created. Defer accessing the context until after the module initializes.".toString());
    }

    private final EventEmitter getModuleEventEmitter() {
        return (EventEmitter) this.moduleEventEmitter.getValue();
    }

    public final ModuleRegistry getRegistry() {
        return getRuntimeContext().getRegistry();
    }

    public final Lazy<CoroutineScope> getCoroutineScopeDelegate() {
        Lazy lazy = this.coroutineScopeDelegate;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineScopeDelegate");
        return null;
    }

    public final void setCoroutineScopeDelegate(Lazy<? extends CoroutineScope> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.coroutineScopeDelegate = lazy;
    }

    public static /* synthetic */ void sendEvent$default(Module module, String str, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            bundle = Bundle.EMPTY;
        }
        module.sendEvent(str, bundle);
    }

    public final void sendEvent(String name, Bundle body) {
        Intrinsics.checkNotNullParameter(name, "name");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, body);
        }
    }

    public final void sendEvent(String name, Map<String, ? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, body);
        }
    }

    public static /* synthetic */ void sendEvent$default(Module module, Enum r1, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            bundle = Bundle.EMPTY;
        }
        module.sendEvent(r1, bundle);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Landroid/os/Bundle;)V */
    public final void sendEvent(Enum r2, Bundle body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(ModuleUtilsKt.convertEnumToString(r2), body);
        }
    }

    public static /* synthetic */ void sendEvent$default(Module module, Enum r1, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        module.sendEvent(r1, map);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Ljava/util/Map<Ljava/lang/String;+Ljava/lang/Object;>;)V */
    public final void sendEvent(Enum r2, Map body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(ModuleUtilsKt.convertEnumToString(r2), (Map<?, ?>) body);
        }
    }
}
