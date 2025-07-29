package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.SingleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: PairTypeConverter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/types/PairTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Lkotlin/Pair;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "pairType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "converters", "", "Lexpo/modules/kotlin/types/TypeConverter;", "", "convertElement", "context", "Lexpo/modules/kotlin/AppContext;", "array", "Lcom/facebook/react/bridge/ReadableArray;", FirebaseAnalytics.Param.INDEX, "", "convertFromAny", "value", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "convertFromReadableArray", "jsArray", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PairTypeConverter extends DynamicAwareTypeConverters<Pair<?, ?>> {
    public static final int $stable = 8;
    private final List<TypeConverter<? extends Object>> converters;
    private final KType pairType;

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PairTypeConverter(TypeConverterProvider converterProvider, KType pairType) {
        super(pairType.getIsMarkedNullable());
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(pairType, "pairType");
        this.pairType = pairType;
        TypeConverter[] typeConverterArr = new TypeConverter[2];
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(pairType.getArguments(), 0);
        KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
        if (type != null) {
            typeConverterArr[0] = converterProvider.obtainTypeConverter(type);
            KTypeProjection kTypeProjection2 = (KTypeProjection) CollectionsKt.getOrNull(pairType.getArguments(), 1);
            KType type2 = kTypeProjection2 != null ? kTypeProjection2.getType() : null;
            if (type2 != null) {
                typeConverterArr[1] = converterProvider.obtainTypeConverter(type2);
                this.converters = CollectionsKt.listOf((Object[]) typeConverterArr);
                return;
            }
            throw new IllegalArgumentException("The pair type should contain the type of the second parameter.".toString());
        }
        throw new IllegalArgumentException("The pair type should contain the type of the first parameter.".toString());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Pair<?, ?> convertFromDynamic(Dynamic value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return convertFromReadableArray(value.asArray(), context);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Pair<?, ?> convertFromAny(Object value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof ReadableArray) {
            return convertFromReadableArray((ReadableArray) value, context);
        }
        return (Pair) value;
    }

    private final Pair<?, ?> convertFromReadableArray(ReadableArray jsArray, AppContext context) {
        return new Pair<>(convertElement(context, jsArray, 0), convertElement(context, jsArray, 1));
    }

    private final Object convertElement(AppContext context, ReadableArray array, int index) {
        try {
            return this.converters.get(index).convert(array.getDynamic(index), context);
        } finally {
        }
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(new SingleType(CppType.READABLE_ARRAY, null, 2, null));
    }
}
