package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import expo.modules.kotlin.types.folly.FollyDynamicExtensionConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;

/* compiled from: JSTypeConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter;", "", "()V", "convertToJSValue", "value", "containerProvider", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "useExperimentalConverter", "", "legacyConvertToJSValue", "ContainerProvider", "DefaultContainerProvider", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSTypeConverter {
    public static final int $stable = 0;
    public static final JSTypeConverter INSTANCE = new JSTypeConverter();

    /* compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "", "createArray", "Lcom/facebook/react/bridge/WritableArray;", "createMap", "Lcom/facebook/react/bridge/WritableMap;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ContainerProvider {
        WritableArray createArray();

        WritableMap createMap();
    }

    private JSTypeConverter() {
    }

    /* compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$DefaultContainerProvider;", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "()V", "createArray", "Lcom/facebook/react/bridge/WritableArray;", "createMap", "Lcom/facebook/react/bridge/WritableMap;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultContainerProvider implements ContainerProvider {
        public static final int $stable = 0;
        public static final DefaultContainerProvider INSTANCE = new DefaultContainerProvider();

        private DefaultContainerProvider() {
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter.ContainerProvider
        public WritableMap createMap() {
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            return writableMapCreateMap;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter.ContainerProvider
        public WritableArray createArray() {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "createArray(...)");
            return writableArrayCreateArray;
        }
    }

    public static /* synthetic */ Object legacyConvertToJSValue$default(JSTypeConverter jSTypeConverter, Object obj, ContainerProvider containerProvider, int i, Object obj2) {
        if ((i & 2) != 0) {
            containerProvider = DefaultContainerProvider.INSTANCE;
        }
        return jSTypeConverter.legacyConvertToJSValue(obj, containerProvider);
    }

    public final Object legacyConvertToJSValue(Object value, ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        if (value == null ? true : value instanceof Unit) {
            return null;
        }
        return value instanceof Bundle ? JSTypeConverterHelperKt.toJSValue((Bundle) value, containerProvider) : value instanceof Object[] ? JSTypeConverterHelperKt.toJSValue((Object[]) value, containerProvider) : value instanceof int[] ? JSTypeConverterHelperKt.toJSValue((int[]) value, containerProvider) : value instanceof float[] ? JSTypeConverterHelperKt.toJSValue((float[]) value, containerProvider) : value instanceof double[] ? JSTypeConverterHelperKt.toJSValue((double[]) value, containerProvider) : value instanceof boolean[] ? JSTypeConverterHelperKt.toJSValue((boolean[]) value, containerProvider) : value instanceof byte[] ? FollyDynamicExtensionConverter.INSTANCE.put(value) : value instanceof Map ? JSTypeConverterHelperKt.toJSValue((Map) value, containerProvider) : value instanceof Enum ? JSTypeConverterHelperKt.toJSValue((Enum<?>) value) : value instanceof Record ? JSTypeConverterHelperKt.toJSValue((Record) value, containerProvider) : value instanceof URI ? JSTypeConverterHelperKt.toJSValue((URI) value) : value instanceof URL ? JSTypeConverterHelperKt.toJSValue((URL) value) : value instanceof Uri ? JSTypeConverterHelperKt.toJSValue((Uri) value) : value instanceof File ? JSTypeConverterHelperKt.toJSValue((File) value) : value instanceof Pair ? JSTypeConverterHelperKt.toJSValue((Pair<?, ?>) value, containerProvider) : value instanceof Long ? Double.valueOf(((Number) value).longValue()) : value instanceof Duration ? Double.valueOf(Duration.m7321toDoubleimpl(((Duration) value).getRawValue(), DurationUnit.SECONDS)) : value instanceof RawTypedArrayHolder ? ((RawTypedArrayHolder) value).getRawArray() : value instanceof Collection ? JSTypeConverterHelperKt.toJSValue((Collection) value, containerProvider) : value;
    }

    public static /* synthetic */ Object convertToJSValue$default(JSTypeConverter jSTypeConverter, Object obj, ContainerProvider containerProvider, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            containerProvider = DefaultContainerProvider.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return jSTypeConverter.convertToJSValue(obj, containerProvider, z);
    }

    public final Object convertToJSValue(Object value, ContainerProvider containerProvider, boolean useExperimentalConverter) {
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        if (value == null ? true : value instanceof Unit) {
            return null;
        }
        if (value instanceof Bundle) {
            return JSTypeConverterHelperKt.toJSValue((Bundle) value, containerProvider);
        }
        if (value instanceof Object[]) {
            return JSTypeConverterHelperKt.toJSValue((Object[]) value, containerProvider);
        }
        if (value instanceof int[] ? true : value instanceof float[] ? true : value instanceof double[] ? true : value instanceof boolean[] ? true : value instanceof long[]) {
            return value;
        }
        if (value instanceof byte[]) {
            return FollyDynamicExtensionConverter.INSTANCE.put(value);
        }
        if (value instanceof Map) {
            if (useExperimentalConverter) {
                return JSTypeConverterHelperKt.toJSValueExperimental((Map) value);
            }
            return JSTypeConverterHelperKt.toJSValue((Map) value, containerProvider);
        }
        if (value instanceof Enum) {
            return JSTypeConverterHelperKt.toJSValue((Enum<?>) value);
        }
        if (value instanceof Record) {
            return JSTypeConverterHelperKt.toJSValue((Record) value, containerProvider);
        }
        if (value instanceof URI) {
            return JSTypeConverterHelperKt.toJSValue((URI) value);
        }
        if (value instanceof URL) {
            return JSTypeConverterHelperKt.toJSValue((URL) value);
        }
        if (value instanceof Uri) {
            return JSTypeConverterHelperKt.toJSValue((Uri) value);
        }
        if (value instanceof File) {
            return JSTypeConverterHelperKt.toJSValue((File) value);
        }
        if (value instanceof Pair) {
            return JSTypeConverterHelperKt.toJSValue((Pair<?, ?>) value, containerProvider);
        }
        if (value instanceof Long) {
            return Double.valueOf(((Number) value).longValue());
        }
        if (value instanceof Duration) {
            return Double.valueOf(Duration.m7321toDoubleimpl(((Duration) value).getRawValue(), DurationUnit.SECONDS));
        }
        if (value instanceof RawTypedArrayHolder) {
            return ((RawTypedArrayHolder) value).getRawArray();
        }
        if (!(value instanceof Collection)) {
            return value;
        }
        if (useExperimentalConverter) {
            return JSTypeConverterHelperKt.toJSValueExperimental((Collection) value);
        }
        return JSTypeConverterHelperKt.toJSValue((Collection) value, containerProvider);
    }
}
