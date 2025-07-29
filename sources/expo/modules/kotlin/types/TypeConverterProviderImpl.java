package expo.modules.kotlin.types;

import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.exception.UnsupportedClass;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptFunction;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectTypeConverter;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.sharedobjects.SharedRefTypeConverter;
import expo.modules.kotlin.typedarray.BigInt64Array;
import expo.modules.kotlin.typedarray.BigUint64Array;
import expo.modules.kotlin.typedarray.Float32Array;
import expo.modules.kotlin.typedarray.Float64Array;
import expo.modules.kotlin.typedarray.Int16Array;
import expo.modules.kotlin.typedarray.Int32Array;
import expo.modules.kotlin.typedarray.Int8Array;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import expo.modules.kotlin.typedarray.Uint32Array;
import expo.modules.kotlin.typedarray.Uint8Array;
import expo.modules.kotlin.typedarray.Uint8ClampedArray;
import expo.modules.kotlin.types.io.FileTypeConverter;
import expo.modules.kotlin.types.io.PathTypeConverter;
import expo.modules.kotlin.types.net.JavaURITypeConverter;
import expo.modules.kotlin.types.net.URLTypConverter;
import expo.modules.kotlin.types.net.UriTypeConverter;
import expo.modules.kotlin.views.ViewTypeConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.time.Duration;

/* compiled from: TypeConverterProvider.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0002J\"\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\t2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0016R\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverterProviderImpl;", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "()V", "cachedConverters", "", "Lkotlin/reflect/KClass;", "Lexpo/modules/kotlin/types/TypeConverter;", "cachedRecordConverters", "", "Lkotlin/reflect/KType;", "nullableCachedConverters", "createCachedConverters", "isOptional", "", "getCachedConverter", "inputType", "handelEither", "type", "jClass", "Ljava/lang/Class;", "obtainTypeConverter", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TypeConverterProviderImpl implements TypeConverterProvider {
    public static final int $stable;
    public static final TypeConverterProviderImpl INSTANCE;
    private static final Map<KClass<?>, TypeConverter<?>> cachedConverters;
    private static final Map<KType, TypeConverter<?>> cachedRecordConverters;
    private static final Map<KClass<?>, TypeConverter<?>> nullableCachedConverters;

    private TypeConverterProviderImpl() {
    }

    static {
        TypeConverterProviderImpl typeConverterProviderImpl = new TypeConverterProviderImpl();
        INSTANCE = typeConverterProviderImpl;
        cachedConverters = typeConverterProviderImpl.createCachedConverters(false);
        nullableCachedConverters = typeConverterProviderImpl.createCachedConverters(true);
        cachedRecordConverters = new LinkedHashMap();
        $stable = 8;
    }

    private final TypeConverter<?> getCachedConverter(KType inputType) {
        if (inputType.getIsMarkedNullable()) {
            return nullableCachedConverters.get(inputType.getClassifier());
        }
        return cachedConverters.get(inputType.getClassifier());
    }

    @Override // expo.modules.kotlin.types.TypeConverterProvider
    public TypeConverter<?> obtainTypeConverter(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TypeConverter<?> cachedConverter = getCachedConverter(type);
        if (cachedConverter != null) {
            return cachedConverter;
        }
        KClassifier classifier = type.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            throw new MissingTypeConverter(type);
        }
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(kClass);
        if (javaClass.isArray() || Object[].class.isAssignableFrom(javaClass)) {
            return new ArrayTypeConverter(this, type);
        }
        if (List.class.isAssignableFrom(javaClass)) {
            return new ListTypeConverter(this, type);
        }
        if (Map.class.isAssignableFrom(javaClass)) {
            return new MapTypeConverter(this, type);
        }
        if (Pair.class.isAssignableFrom(javaClass)) {
            return new PairTypeConverter(this, type);
        }
        if (Set.class.isAssignableFrom(javaClass)) {
            return new SetTypeConverter(this, type);
        }
        if (javaClass.isEnum()) {
            return new EnumTypeConverter(kClass, type.getIsMarkedNullable());
        }
        Map<KType, TypeConverter<?>> map = cachedRecordConverters;
        TypeConverter<?> typeConverter = map.get(type);
        if (typeConverter != null) {
            return typeConverter;
        }
        if (Record.class.isAssignableFrom(javaClass)) {
            RecordTypeConverter recordTypeConverter = new RecordTypeConverter(this, type);
            map.put(type, recordTypeConverter);
            return recordTypeConverter;
        }
        if (View.class.isAssignableFrom(javaClass)) {
            return new ViewTypeConverter(type);
        }
        if (SharedRef.class.isAssignableFrom(javaClass)) {
            return new SharedRefTypeConverter(type);
        }
        if (SharedObject.class.isAssignableFrom(javaClass)) {
            return new SharedObjectTypeConverter(type);
        }
        if (JavaScriptFunction.class.isAssignableFrom(javaClass)) {
            return new JavaScriptFunctionTypeConverter(type);
        }
        TypeConverter<?> typeConverterHandelEither = handelEither(type, javaClass);
        if (typeConverterHandelEither != null) {
            return typeConverterHandelEither;
        }
        throw new MissingTypeConverter(type);
    }

    private final TypeConverter<?> handelEither(KType type, Class<?> jClass) {
        if (!Either.class.isAssignableFrom(jClass)) {
            return null;
        }
        if (EitherOfFour.class.isAssignableFrom(jClass)) {
            return new EitherOfFourTypeConverter(this, type);
        }
        if (EitherOfThree.class.isAssignableFrom(jClass)) {
            return new EitherOfThreeTypeConverter(this, type);
        }
        return new EitherTypeConverter(this, type);
    }

    private final Map<KClass<?>, TypeConverter<?>> createCachedConverters(final boolean isOptional) {
        final ExpectedType expectedType = new ExpectedType(CppType.INT);
        DynamicAwareTypeConverters<Integer> dynamicAwareTypeConverters = new DynamicAwareTypeConverters<Integer>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Integer convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Integer) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Integer convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Integer.valueOf((int) value.asDouble());
            }
        };
        final ExpectedType expectedType2 = new ExpectedType(CppType.LONG);
        DynamicAwareTypeConverters<Long> dynamicAwareTypeConverters2 = new DynamicAwareTypeConverters<Long>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Long convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Long) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType2;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Long convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Long.valueOf((long) value.asDouble());
            }
        };
        final ExpectedType expectedType3 = new ExpectedType(CppType.DOUBLE);
        DynamicAwareTypeConverters<Double> dynamicAwareTypeConverters3 = new DynamicAwareTypeConverters<Double>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$3
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Double convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Double) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType3;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Double convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Double.valueOf(value.asDouble());
            }
        };
        final ExpectedType expectedType4 = new ExpectedType(CppType.FLOAT);
        DynamicAwareTypeConverters<Float> dynamicAwareTypeConverters4 = new DynamicAwareTypeConverters<Float>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$4
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Float convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Float) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType4;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Float convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Float.valueOf((float) value.asDouble());
            }
        };
        final ExpectedType expectedType5 = new ExpectedType(CppType.BOOLEAN);
        DynamicAwareTypeConverters<Boolean> dynamicAwareTypeConverters5 = new DynamicAwareTypeConverters<Boolean>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$5
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Boolean convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (Boolean) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType5;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Boolean convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return Boolean.valueOf(value.asBoolean());
            }
        };
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        final ExpectedType expectedType6 = new ExpectedType(CppType.STRING);
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ReadableArray.class);
        final ExpectedType expectedType7 = new ExpectedType(CppType.READABLE_ARRAY);
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ReadableMap.class);
        final ExpectedType expectedType8 = new ExpectedType(CppType.READABLE_MAP);
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(int[].class);
        final ExpectedType expectedTypeForPrimitiveArray = ExpectedType.INSTANCE.forPrimitiveArray(CppType.INT);
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(long[].class);
        final ExpectedType expectedTypeForPrimitiveArray2 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.LONG);
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(double[].class);
        final ExpectedType expectedTypeForPrimitiveArray3 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.DOUBLE);
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(float[].class);
        final ExpectedType expectedTypeForPrimitiveArray4 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.FLOAT);
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(boolean[].class);
        final ExpectedType expectedTypeForPrimitiveArray5 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.BOOLEAN);
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(JavaScriptValue.class);
        final ExpectedType expectedType9 = new ExpectedType(CppType.JS_VALUE);
        KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(JavaScriptObject.class);
        final ExpectedType expectedType10 = new ExpectedType(CppType.JS_OBJECT);
        return MapsKt.plus(MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), dynamicAwareTypeConverters), TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.class), dynamicAwareTypeConverters), TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), dynamicAwareTypeConverters2), TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.class), dynamicAwareTypeConverters2), TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), dynamicAwareTypeConverters3), TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.class), dynamicAwareTypeConverters3), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), dynamicAwareTypeConverters4), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.class), dynamicAwareTypeConverters4), TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), dynamicAwareTypeConverters5), TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.class), dynamicAwareTypeConverters5), TuplesKt.to(orCreateKotlinClass, new DynamicAwareTypeConverters<String>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$6
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public String convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (String) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType6;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public String convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.asString();
            }
        }), TuplesKt.to(orCreateKotlinClass2, new DynamicAwareTypeConverters<ReadableArray>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$7
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableArray convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (ReadableArray) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType7;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableArray convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.asArray();
            }
        }), TuplesKt.to(orCreateKotlinClass3, new DynamicAwareTypeConverters<ReadableMap>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$8
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableMap convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (ReadableMap) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType8;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableMap convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.asMap();
            }
        }), TuplesKt.to(orCreateKotlinClass4, new DynamicAwareTypeConverters<int[]>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$9
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public int[] convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (int[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public int[] convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                int size = readableArrayAsArray.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = readableArrayAsArray.getInt(i);
                }
                return iArr;
            }
        }), TuplesKt.to(orCreateKotlinClass5, new DynamicAwareTypeConverters<long[]>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$10
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public long[] convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (long[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray2;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public long[] convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                int size = readableArrayAsArray.size();
                long[] jArr = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = (long) readableArrayAsArray.getDouble(i);
                }
                return jArr;
            }
        }), TuplesKt.to(orCreateKotlinClass6, new DynamicAwareTypeConverters<double[]>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$11
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public double[] convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (double[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray3;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public double[] convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                int size = readableArrayAsArray.size();
                double[] dArr = new double[size];
                for (int i = 0; i < size; i++) {
                    dArr[i] = readableArrayAsArray.getDouble(i);
                }
                return dArr;
            }
        }), TuplesKt.to(orCreateKotlinClass7, new DynamicAwareTypeConverters<float[]>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$12
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public float[] convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (float[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray4;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public float[] convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                int size = readableArrayAsArray.size();
                float[] fArr = new float[size];
                for (int i = 0; i < size; i++) {
                    fArr[i] = (float) readableArrayAsArray.getDouble(i);
                }
                return fArr;
            }
        }), TuplesKt.to(orCreateKotlinClass8, new DynamicAwareTypeConverters<boolean[]>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$13
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public boolean[] convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (boolean[]) value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray5;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public boolean[] convertFromDynamic(Dynamic value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                ReadableArray readableArrayAsArray = value.asArray();
                int size = readableArrayAsArray.size();
                boolean[] zArr = new boolean[size];
                for (int i = 0; i < size; i++) {
                    zArr[i] = readableArrayAsArray.getBoolean(i);
                }
                return zArr;
            }
        }), TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), new ByteArrayTypeConverter(isOptional)), TuplesKt.to(orCreateKotlinClass9, new DynamicAwareTypeConverters<Object>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType9;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext context) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }
        }), TuplesKt.to(orCreateKotlinClass10, new DynamicAwareTypeConverters<Object>(isOptional) { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, AppContext context) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // expo.modules.kotlin.types.TypeConverter
            /* renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType10;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, AppContext context) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }
        }), TuplesKt.to(Reflection.getOrCreateKotlinClass(Int8Array.class), new Int8ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Int16Array.class), new Int16ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Int32Array.class), new Int32ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8Array.class), new Uint8ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8ClampedArray.class), new Uint8ClampedArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint16Array.class), new Uint16ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint32Array.class), new Uint32ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float32Array.class), new Float32ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float64Array.class), new Float64ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BigInt64Array.class), new BigInt64ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BigUint64Array.class), new BigUint64ArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(TypedArray.class), new TypedArrayTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(URL.class), new URLTypConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Uri.class), new UriTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(URI.class), new JavaURITypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(File.class), new FileTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Duration.class), new DurationTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Object.class), new AnyTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), new UnitTypeConverter()), TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableArguments.class), new ReadableArgumentsTypeConverter(isOptional))), MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(Path.class), new PathTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Color.class), new ColorTypeConverter(isOptional)), TuplesKt.to(Reflection.getOrCreateKotlinClass(LocalDate.class), new DateTypeConverter(isOptional))));
    }
}
