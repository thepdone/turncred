package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.jni.JNIUtils;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import expo.modules.kotlin.types.JSTypeConverter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedObject.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0017J+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001f\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\"H\u0003J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u0013X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObject;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)V", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "(Lexpo/modules/kotlin/RuntimeContext;)V", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "getRuntimeContext", "()Lexpo/modules/kotlin/RuntimeContext;", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "getRuntimeContextHolder", "()Ljava/lang/ref/WeakReference;", "setRuntimeContextHolder", "(Ljava/lang/ref/WeakReference;)V", "sharedObjectId", "Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "getSharedObjectId-HSeVr_g$expo_modules_core_release", "()I", "setSharedObjectId-kyJHjyY$expo_modules_core_release", "(I)V", "I", "deallocate", "", "emit", "eventName", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "getAdditionalMemoryPressure", "", "getJavaScriptObject", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "getSharedObjectId", "onStartListeningToEvent", "onStopListeningToEvent", "sharedObjectDidRelease", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SharedObject {
    public static final int $stable = 8;
    private WeakReference<RuntimeContext> runtimeContextHolder;
    private int sharedObjectId;

    public SharedObject() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Deprecated(message = "Use sharedObjectDidRelease() instead.", replaceWith = @ReplaceWith(expression = "sharedObjectDidRelease()", imports = {}))
    public void deallocate() {
    }

    public int getAdditionalMemoryPressure() {
        return 0;
    }

    public void onStartListeningToEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public void onStopListeningToEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public SharedObject(RuntimeContext runtimeContext) {
        this.sharedObjectId = SharedObjectId.m5738constructorimpl(0);
        this.runtimeContextHolder = UtilsKt.weak(runtimeContext);
    }

    public /* synthetic */ SharedObject(RuntimeContext runtimeContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : runtimeContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedObject(AppContext appContext) {
        this(appContext.getHostingRuntimeContext());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    /* renamed from: getSharedObjectId-HSeVr_g$expo_modules_core_release, reason: not valid java name */
    public final int m5735getSharedObjectIdHSeVr_g$expo_modules_core_release() {
        return this.sharedObjectId;
    }

    /* renamed from: setSharedObjectId-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final void m5736setSharedObjectIdkyJHjyY$expo_modules_core_release(int i) {
        this.sharedObjectId = i;
    }

    private final int getSharedObjectId() {
        return this.sharedObjectId;
    }

    public final WeakReference<RuntimeContext> getRuntimeContextHolder() {
        return this.runtimeContextHolder;
    }

    public final void setRuntimeContextHolder(WeakReference<RuntimeContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.runtimeContextHolder = weakReference;
    }

    private final RuntimeContext getRuntimeContext() {
        return this.runtimeContextHolder.get();
    }

    public final AppContext getAppContext() {
        RuntimeContext runtimeContext = getRuntimeContext();
        if (runtimeContext != null) {
            return runtimeContext.getAppContext();
        }
        return null;
    }

    private final JavaScriptWeakObject getJavaScriptObject() {
        int iM5738constructorimpl = SharedObjectId.m5738constructorimpl(this.sharedObjectId);
        RuntimeContext runtimeContext = getRuntimeContext();
        if (runtimeContext == null) {
            return null;
        }
        return SharedObjectId.m5746toWeakJavaScriptObjectNullimpl(iM5738constructorimpl, runtimeContext);
    }

    public final void emit(String eventName, Object... args) {
        RuntimeContext runtimeContext;
        JSIContext jsiContext$expo_modules_core_release;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(args, "args");
        JavaScriptWeakObject javaScriptObject = getJavaScriptObject();
        if (javaScriptObject == null || (runtimeContext = getRuntimeContext()) == null || (jsiContext$expo_modules_core_release = runtimeContext.getJsiContext$expo_modules_core_release()) == null) {
            return;
        }
        try {
            JNIUtils.Companion companion = JNIUtils.INSTANCE;
            ArrayList arrayList = new ArrayList(args.length);
            for (Object obj : args) {
                arrayList.add(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, obj, null, false, 6, null));
            }
            companion.emitEvent(javaScriptObject, jsiContext$expo_modules_core_release, eventName, arrayList.toArray(new Object[0]));
        } catch (Throwable th) {
            CoreLoggerKt.getLogger().error("Unable to send event '" + eventName + "' by shared object of type " + getClass().getSimpleName(), th);
        }
    }

    public void sharedObjectDidRelease() {
        deallocate();
    }
}
