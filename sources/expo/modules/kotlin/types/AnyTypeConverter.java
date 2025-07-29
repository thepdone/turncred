package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnyTypeConverter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/AnyTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "isOptional", "", "(Z)V", "convertFromAny", "value", "context", "Lexpo/modules/kotlin/AppContext;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnyTypeConverter extends DynamicAwareTypeConverters<Object> {
    public static final int $stable = 0;

    /* compiled from: AnyTypeConverter.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object convertFromAny(Object value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    public AnyTypeConverter(boolean z) {
        super(z);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object convertFromDynamic(Dynamic value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        int i = WhenMappings.$EnumSwitchMapping$0[value.getType().ordinal()];
        if (i == 1) {
            return Boolean.valueOf(value.asBoolean());
        }
        if (i == 2) {
            return Double.valueOf(value.asDouble());
        }
        if (i == 3) {
            return value.asString();
        }
        if (i == 4) {
            return value.asMap().toHashMap();
        }
        if (i == 5) {
            return value.asArray().toArrayList();
        }
        throw new IllegalStateException(("Unknown dynamic type: " + value.getType()).toString());
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.ANY);
    }
}
