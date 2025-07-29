package expo.modules.kotlin.jni;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JNIUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lexpo/modules/kotlin/jni/JNIUtils;", "", "()V", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JNIUtils {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final native void emitEvent(JavaScriptModuleObject javaScriptModuleObject, JSIContext jSIContext, String str, Map<String, ? extends Object> map);

    @JvmStatic
    public static final native void emitEvent(JavaScriptObject javaScriptObject, JSIContext jSIContext, String str, Object[] objArr);

    @JvmStatic
    public static final native void emitEvent(JavaScriptWeakObject javaScriptWeakObject, JSIContext jSIContext, String str, Object[] objArr);

    /* compiled from: JNIUtils.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fH\u0087 J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0087 J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0087 ¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/jni/JNIUtils$Companion;", "", "()V", "emitEvent", "", "jsiThis", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "jsiContext", "Lexpo/modules/kotlin/jni/JSIContext;", "eventName", "", "eventBody", "", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void emitEvent(JavaScriptModuleObject jsiThis, JSIContext jsiContext, String eventName, Map<String, ? extends Object> eventBody) {
            JNIUtils.emitEvent(jsiThis, jsiContext, eventName, eventBody);
        }

        @JvmStatic
        public final void emitEvent(JavaScriptObject javaScriptObject, JSIContext jSIContext, String str, Object[] objArr) {
            JNIUtils.emitEvent(javaScriptObject, jSIContext, str, objArr);
        }

        @JvmStatic
        public final void emitEvent(JavaScriptWeakObject javaScriptWeakObject, JSIContext jSIContext, String str, Object[] objArr) {
            JNIUtils.emitEvent(javaScriptWeakObject, jSIContext, str, objArr);
        }

        private Companion() {
        }
    }
}
