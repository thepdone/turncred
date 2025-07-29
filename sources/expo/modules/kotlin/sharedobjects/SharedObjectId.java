package expo.modules.kotlin.sharedobjects;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedObjectRegistry.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toJavaScriptObjectNull", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "toJavaScriptObjectNull-impl", "(ILexpo/modules/kotlin/RuntimeContext;)Lexpo/modules/kotlin/jni/JavaScriptObject;", "toNativeObject", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "toNativeObject-impl", "(ILexpo/modules/kotlin/RuntimeContext;)Lexpo/modules/kotlin/sharedobjects/SharedObject;", "toNativeObjectOrNull", "toNativeObjectOrNull-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "toWeakJavaScriptObjectNull", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "toWeakJavaScriptObjectNull-impl", "(ILexpo/modules/kotlin/RuntimeContext;)Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class SharedObjectId {
    private final int value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SharedObjectId m5737boximpl(int i) {
        return new SharedObjectId(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m5738constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5739equalsimpl(int i, Object obj) {
        return (obj instanceof SharedObjectId) && i == ((SharedObjectId) obj).m5747unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5740equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5741hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5745toStringimpl(int i) {
        return "SharedObjectId(value=" + i + ")";
    }

    public boolean equals(Object obj) {
        return m5739equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5741hashCodeimpl(this.value);
    }

    public String toString() {
        return m5745toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5747unboximpl() {
        return this.value;
    }

    private /* synthetic */ SharedObjectId(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: toNativeObject-impl, reason: not valid java name */
    public static final SharedObject m5743toNativeObjectimpl(int i, RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        return runtimeContext.getSharedObjectRegistry().m5752toNativeObjectkyJHjyY$expo_modules_core_release(i);
    }

    /* renamed from: toNativeObjectOrNull-impl, reason: not valid java name */
    public static final SharedObject m5744toNativeObjectOrNullimpl(int i, RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        return runtimeContext.getSharedObjectRegistry().m5753toNativeObjectOrNullkyJHjyY$expo_modules_core_release(i);
    }

    /* renamed from: toJavaScriptObjectNull-impl, reason: not valid java name */
    public static final JavaScriptObject m5742toJavaScriptObjectNullimpl(int i, RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        SharedObject sharedObjectM5744toNativeObjectOrNullimpl = m5744toNativeObjectOrNullimpl(i, runtimeContext);
        if (sharedObjectM5744toNativeObjectOrNullimpl == null) {
            return null;
        }
        return runtimeContext.getSharedObjectRegistry().toJavaScriptObjectOrNull$expo_modules_core_release(sharedObjectM5744toNativeObjectOrNullimpl);
    }

    /* renamed from: toWeakJavaScriptObjectNull-impl, reason: not valid java name */
    public static final JavaScriptWeakObject m5746toWeakJavaScriptObjectNullimpl(int i, RuntimeContext runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        SharedObject sharedObjectM5744toNativeObjectOrNullimpl = m5744toNativeObjectOrNullimpl(i, runtimeContext);
        if (sharedObjectM5744toNativeObjectOrNullimpl == null) {
            return null;
        }
        return runtimeContext.getSharedObjectRegistry().toWeakJavaScriptObjectOrNull$expo_modules_core_release(sharedObjectM5744toNativeObjectOrNullimpl);
    }
}
