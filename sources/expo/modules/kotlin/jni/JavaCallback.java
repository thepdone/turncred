package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.JSTypeConverterHelperKt;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JavaCallback.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0082\bJ\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0004J\t\u0010\u000b\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0010H\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0011H\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0012H\u0086\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013H\u0086\u0002J\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0086\u0002J\u0019\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0016H\u0086\u0002J\u001f\u0010\u000b\u001a\u00020\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0017H\u0086\u0002J\u0011\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0019H\u0082 J\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001bH\u0082 J\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001dH\u0082 J\u0011\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001fH\u0082 J\t\u0010 \u001a\u00020\u0006H\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020!H\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\"H\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020#H\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0010H\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0011H\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0012H\u0082 J\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013H\u0082 J\u0019\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0082 J\u0019\u0010 \u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0016H\u0082 J\u001f\u0010 \u001a\u00020\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0017H\u0082 R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/jni/JavaCallback;", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "checkIfValid", "", "body", "Lkotlin/Function0;", "deallocate", "finalize", "invoke", "value", "", "result", "", "", "", "", "", "code", "errorMessage", "", "", "invokeDoubleArray", "", "invokeFloatArray", "", "invokeIntArray", "", "invokeLongArray", "", "invokeNative", "Lcom/facebook/react/bridge/WritableNativeArray;", "Lcom/facebook/react/bridge/WritableNativeMap;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JavaCallback implements Destructible {
    public static final int $stable = 8;
    private final HybridData mHybridData;

    private final native void invokeDoubleArray(double[] result);

    private final native void invokeFloatArray(float[] result);

    private final native void invokeIntArray(int[] result);

    private final native void invokeLongArray(long[] result);

    private final native void invokeNative();

    private final native void invokeNative(double result);

    private final native void invokeNative(float result);

    private final native void invokeNative(int result);

    private final native void invokeNative(WritableNativeArray result);

    private final native void invokeNative(WritableNativeMap result);

    private final native void invokeNative(SharedObject result);

    private final native void invokeNative(String result);

    private final native void invokeNative(String code, String errorMessage);

    private final native void invokeNative(Collection<? extends Object> result);

    private final native void invokeNative(Map<String, ? extends Object> result);

    private final native void invokeNative(boolean result);

    public JavaCallback(HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }

    public final void invoke(Object value) {
        try {
            Object objConvertToJSValue$default = JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, value, null, true, 2, null);
            if (objConvertToJSValue$default == null) {
                invokeNative();
                return;
            }
            if (objConvertToJSValue$default instanceof Integer) {
                invokeNative(((Number) objConvertToJSValue$default).intValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Boolean) {
                invokeNative(((Boolean) objConvertToJSValue$default).booleanValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Double) {
                invokeNative(((Number) objConvertToJSValue$default).doubleValue());
                return;
            }
            if (objConvertToJSValue$default instanceof Float) {
                invokeNative(((Number) objConvertToJSValue$default).floatValue());
                return;
            }
            if (objConvertToJSValue$default instanceof String) {
                invokeNative((String) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof Collection) {
                invokeNative((Collection<? extends Object>) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof Map) {
                invokeNative((Map<String, ? extends Object>) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof WritableNativeArray) {
                invokeNative((WritableNativeArray) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof WritableNativeMap) {
                invokeNative((WritableNativeMap) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof SharedObject) {
                invokeNative((SharedObject) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof int[]) {
                invokeIntArray((int[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof long[]) {
                invokeLongArray((long[]) objConvertToJSValue$default);
                return;
            }
            if (objConvertToJSValue$default instanceof float[]) {
                invokeFloatArray((float[]) objConvertToJSValue$default);
            } else if (objConvertToJSValue$default instanceof double[]) {
                invokeDoubleArray((double[]) objConvertToJSValue$default);
            } else {
                throw new UnexpectedException("Unknown type: " + objConvertToJSValue$default.getClass());
            }
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke() {
        try {
            invokeNative();
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(int result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(boolean result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(double result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(float result) {
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(result);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(Collection<? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(JSTypeConverterHelperKt.toJSValueExperimental(result));
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            invokeNative(JSTypeConverterHelperKt.toJSValueExperimental(result));
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(String code, String errorMessage) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        try {
            invokeNative(code, errorMessage);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    private final void checkIfValid(Function0<Unit> body) {
        try {
            body.invoke();
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }
}
