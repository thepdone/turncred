package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.InvalidSharedObjectIdException;
import expo.modules.kotlin.exception.UsingReleasedSharedObjectException;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedObjectRegistry.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u0006H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u000bH\u0000¢\u0006\u0002\b#J\u001a\u0010$\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b(J\u001c\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010&J\u0017\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010+\u001a\u00020\u000bH\u0000¢\u0006\u0002\b,J\u0016\u0010-\u001a\u00020\u0006*\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R6\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "(Lexpo/modules/kotlin/RuntimeContext;)V", "currentId", "Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "I", "pairs", "", "Lkotlin/Pair;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "Lexpo/modules/kotlin/sharedobjects/SharedObjectPair;", "getPairs$expo_modules_core_release", "()Ljava/util/Map;", "setPairs$expo_modules_core_release", "(Ljava/util/Map;)V", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "add", "native", "js", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "add-5WKnsLU$expo_modules_core_release", "(Lexpo/modules/kotlin/sharedobjects/SharedObject;Lexpo/modules/kotlin/jni/JavaScriptObject;)I", "delete", "", "id", "delete-kyJHjyY$expo_modules_core_release", "(I)V", "pullNextId", "pullNextId-HSeVr_g", "()I", "toJavaScriptObjectOrNull", "toJavaScriptObjectOrNull$expo_modules_core_release", "toNativeObject", "toNativeObject-kyJHjyY$expo_modules_core_release", "(I)Lexpo/modules/kotlin/sharedobjects/SharedObject;", "toNativeObjectOrNull", "toNativeObjectOrNull$expo_modules_core_release", "toNativeObjectOrNull-kyJHjyY$expo_modules_core_release", "toWeakJavaScriptObjectOrNull", "nativeObject", "toWeakJavaScriptObjectOrNull$expo_modules_core_release", "ensureWasNotRelease", "ensureWasNotRelease-tuC-2VU", "(I)I", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharedObjectRegistry {
    public static final int $stable = 8;
    private int currentId;
    private Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> pairs;
    private final WeakReference<RuntimeContext> runtimeContextHolder;

    public SharedObjectRegistry(RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        this.runtimeContextHolder = UtilsKt.weak(runtimeContext);
        this.currentId = SharedObjectId.m5738constructorimpl(1);
        this.pairs = new LinkedHashMap();
    }

    public final Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> getPairs$expo_modules_core_release() {
        return this.pairs;
    }

    public final void setPairs$expo_modules_core_release(Map<SharedObjectId, Pair<SharedObject, JavaScriptWeakObject>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.pairs = map;
    }

    /* renamed from: pullNextId-HSeVr_g, reason: not valid java name */
    private final int m5749pullNextIdHSeVr_g() {
        int i;
        synchronized (this) {
            i = this.currentId;
            this.currentId = SharedObjectId.m5738constructorimpl(i + 1);
        }
        return i;
    }

    /* renamed from: add-5WKnsLU$expo_modules_core_release, reason: not valid java name */
    public final int m5750add5WKnsLU$expo_modules_core_release(SharedObject sharedObject, JavaScriptObject js) throws Exceptions.AppContextLost {
        Intrinsics.checkNotNullParameter(sharedObject, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        int iM5749pullNextIdHSeVr_g = m5749pullNextIdHSeVr_g();
        sharedObject.m5736setSharedObjectIdkyJHjyY$expo_modules_core_release(iM5749pullNextIdHSeVr_g);
        JavaScriptObject.defineProperty$default(js, SharedObjectRegistryKt.sharedObjectIdPropertyName, iM5749pullNextIdHSeVr_g, (List) null, 4, (Object) null);
        RuntimeContext runtimeContext = this.runtimeContextHolder.get();
        if (runtimeContext == null) {
            throw new Exceptions.AppContextLost();
        }
        runtimeContext.getJsiContext$expo_modules_core_release().setNativeStateForSharedObject(iM5749pullNextIdHSeVr_g, js);
        int additionalMemoryPressure = sharedObject.getAdditionalMemoryPressure();
        if (additionalMemoryPressure > 0) {
            js.setExternalMemoryPressure(additionalMemoryPressure);
        }
        if (sharedObject instanceof SharedRef) {
            JavaScriptObject.defineProperty$default(js, "nativeRefType", ((SharedRef) sharedObject).getNativeRefType(), (List) null, 4, (Object) null);
        }
        JavaScriptWeakObject javaScriptWeakObjectCreateWeak = js.createWeak();
        synchronized (this) {
            this.pairs.put(SharedObjectId.m5737boximpl(iM5749pullNextIdHSeVr_g), TuplesKt.to(sharedObject, javaScriptWeakObjectCreateWeak));
            Unit unit = Unit.INSTANCE;
        }
        if (sharedObject.getRuntimeContextHolder().get() == null) {
            sharedObject.setRuntimeContextHolder(UtilsKt.weak(runtimeContext));
        }
        return iM5749pullNextIdHSeVr_g;
    }

    /* renamed from: delete-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final void m5751deletekyJHjyY$expo_modules_core_release(int id) {
        Pair<SharedObject, JavaScriptWeakObject> pairRemove;
        synchronized (this) {
            pairRemove = this.pairs.remove(SharedObjectId.m5737boximpl(id));
        }
        if (pairRemove != null) {
            SharedObject sharedObjectComponent1 = pairRemove.component1();
            sharedObjectComponent1.m5736setSharedObjectIdkyJHjyY$expo_modules_core_release(SharedObjectId.m5738constructorimpl(0));
            sharedObjectComponent1.sharedObjectDidRelease();
        }
    }

    /* renamed from: toNativeObject-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final SharedObject m5752toNativeObjectkyJHjyY$expo_modules_core_release(int id) throws InvalidSharedObjectIdException {
        Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m5737boximpl(m5748ensureWasNotReleasetuC2VU(id)));
        SharedObject first = pair != null ? pair.getFirst() : null;
        if (first != null) {
            return first;
        }
        throw new InvalidSharedObjectIdException();
    }

    /* renamed from: toNativeObjectOrNull-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final SharedObject m5753toNativeObjectOrNullkyJHjyY$expo_modules_core_release(int id) {
        SharedObject first;
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m5737boximpl(id));
            first = pair != null ? pair.getFirst() : null;
        }
        return first;
    }

    public final SharedObject toNativeObjectOrNull$expo_modules_core_release(JavaScriptObject js) {
        Intrinsics.checkNotNullParameter(js, "js");
        if (!js.hasProperty(SharedObjectRegistryKt.sharedObjectIdPropertyName)) {
            return null;
        }
        Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m5737boximpl(SharedObjectId.m5738constructorimpl(js.getProperty(SharedObjectRegistryKt.sharedObjectIdPropertyName).getInt())));
        if (pair != null) {
            return pair.getFirst();
        }
        return null;
    }

    public final JavaScriptObject toJavaScriptObjectOrNull$expo_modules_core_release(SharedObject sharedObject) {
        JavaScriptObject javaScriptObjectLock;
        JavaScriptWeakObject second;
        Intrinsics.checkNotNullParameter(sharedObject, "native");
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m5737boximpl(sharedObject.m5735getSharedObjectIdHSeVr_g$expo_modules_core_release()));
            javaScriptObjectLock = (pair == null || (second = pair.getSecond()) == null) ? null : second.lock();
        }
        return javaScriptObjectLock;
    }

    public final JavaScriptWeakObject toWeakJavaScriptObjectOrNull$expo_modules_core_release(SharedObject nativeObject) {
        JavaScriptWeakObject second;
        Intrinsics.checkNotNullParameter(nativeObject, "nativeObject");
        synchronized (this) {
            Pair<SharedObject, JavaScriptWeakObject> pair = this.pairs.get(SharedObjectId.m5737boximpl(nativeObject.m5735getSharedObjectIdHSeVr_g$expo_modules_core_release()));
            second = pair != null ? pair.getSecond() : null;
        }
        return second;
    }

    /* renamed from: ensureWasNotRelease-tuC-2VU, reason: not valid java name */
    private final int m5748ensureWasNotReleasetuC2VU(int i) throws UsingReleasedSharedObjectException {
        if (this.pairs.containsKey(SharedObjectId.m5737boximpl(i)) || i == 0 || i >= this.currentId) {
            return i;
        }
        throw new UsingReleasedSharedObjectException();
    }
}
