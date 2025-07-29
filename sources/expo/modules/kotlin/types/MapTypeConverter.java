package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: MapTypeConverter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/types/MapTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "mapType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "valueConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "convertFromAny", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MapTypeConverter extends DynamicAwareTypeConverters<Map<?, ?>> {
    public static final int $stable = 8;
    private final KType mapType;
    private final TypeConverter<?> valueConverter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapTypeConverter(TypeConverterProvider converterProvider, KType mapType) {
        super(mapType.getIsMarkedNullable());
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(mapType, "mapType");
        this.mapType = mapType;
        KType type = ((KTypeProjection) CollectionsKt.first((List) mapType.getArguments())).getType();
        if (!Intrinsics.areEqual(type != null ? type.getClassifier() : null, Reflection.getOrCreateKotlinClass(String.class))) {
            throw new IllegalArgumentException(("The map key type should be String, but received " + CollectionsKt.first((List) mapType.getArguments()) + ".").toString());
        }
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(mapType.getArguments(), 1);
        KType type2 = kTypeProjection != null ? kTypeProjection.getType() : null;
        if (type2 != null) {
            this.valueConverter = converterProvider.obtainTypeConverter(type2);
            return;
        }
        throw new IllegalArgumentException("The map type should contain the key type.".toString());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Map<?, ?> convertFromDynamic(Dynamic value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return convertFromReadableMap(value.asMap(), context);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Map<?, ?> convertFromAny(Object value, AppContext context) throws CollectionElementCastException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.valueConverter.isTrivial()) {
            return (Map) value;
        }
        Map map = (Map) value;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value2 = entry.getValue();
            try {
                linkedHashMap.put(key, this.valueConverter.convert(value2, context));
            } catch (Throwable th) {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    String code = ((expo.modules.core.errors.CodedException) th).getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                    unexpectedException = new CodedException(code, th.getMessage(), th.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                KType kType = this.mapType;
                KType type = kType.getArguments().get(1).getType();
                Intrinsics.checkNotNull(type);
                Intrinsics.checkNotNull(value2);
                throw new CollectionElementCastException(kType, type, (KClass<?>) Reflection.getOrCreateKotlinClass(value2.getClass()), unexpectedException);
            }
        }
        return linkedHashMap;
    }

    private final Map<?, ?> convertFromReadableMap(ReadableMap jsMap, AppContext context) {
        CollectionElementCastException collectionElementCastException;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> entryIterator = jsMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            String key = next.getKey();
            DynamicFromObject dynamicFromObject = new DynamicFromObject(next.getValue());
            try {
                try {
                    linkedHashMap.put(key, this.valueConverter.convert(dynamicFromObject, context));
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            } finally {
                dynamicFromObject.recycle();
            }
        }
        return linkedHashMap;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return ExpectedType.INSTANCE.forMap(this.valueConverter.get$cppRequireType());
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return this.valueConverter.isTrivial();
    }
}
