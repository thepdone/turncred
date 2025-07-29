package expo.modules.kotlin.records;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.allocators.ObjectConstructor;
import expo.modules.kotlin.allocators.ObjectConstructorFactory;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FieldCastException;
import expo.modules.kotlin.exception.FieldRequiredException;
import expo.modules.kotlin.exception.RecordCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt;

/* compiled from: RecordTypeConverter.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001.B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016J&\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010%\"\b\b\u0001\u0010\u0001*\u00020\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00010'H\u0002J&\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)2\u0012\u0010+\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0002\b\u00030\rH\u0002J\b\u0010,\u001a\u00020-H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006/"}, d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "objectConstructorFactory", "Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "propertyDescriptors", "", "Lkotlin/reflect/KProperty1;", "", "Lexpo/modules/kotlin/records/RecordTypeConverter$PropertyDescriptor;", "getPropertyDescriptors", "()Ljava/util/Map;", "propertyDescriptors$delegate", "Lkotlin/Lazy;", "getType", "()Lkotlin/reflect/KType;", "convertFromAny", "value", "context", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Lexpo/modules/kotlin/records/Record;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/AppContext;)Lexpo/modules/kotlin/records/Record;", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;Lexpo/modules/kotlin/AppContext;)Lexpo/modules/kotlin/records/Record;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "getObjectConstructor", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", "clazz", "Lkotlin/reflect/KClass;", "getValidators", "", "Lexpo/modules/kotlin/records/FieldValidator;", "property", "isTrivial", "", "PropertyDescriptor", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecordTypeConverter<T extends Record> extends DynamicAwareTypeConverters<T> {
    public static final int $stable = 8;
    private final TypeConverterProvider converterProvider;
    private final ObjectConstructorFactory objectConstructorFactory;

    /* renamed from: propertyDescriptors$delegate, reason: from kotlin metadata */
    private final Lazy propertyDescriptors;
    private final KType type;

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public final KType getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordTypeConverter(TypeConverterProvider converterProvider, KType type) {
        super(type.getIsMarkedNullable());
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(type, "type");
        this.converterProvider = converterProvider;
        this.type = type;
        this.objectConstructorFactory = new ObjectConstructorFactory();
        this.propertyDescriptors = LazyKt.lazy(new Function0<Map<KProperty1<? extends Object, ?>, ? extends PropertyDescriptor>>(this) { // from class: expo.modules.kotlin.records.RecordTypeConverter$propertyDescriptors$2
            final /* synthetic */ RecordTypeConverter<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<KProperty1<? extends Object, ?>, ? extends RecordTypeConverter.PropertyDescriptor> invoke() {
                Object obj;
                Object next;
                KClassifier classifier = this.this$0.getType().getClassifier();
                Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
                Collection<KProperty1> memberProperties = KClasses.getMemberProperties((KClass) classifier);
                RecordTypeConverter<T> recordTypeConverter = this.this$0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(memberProperties, 10));
                for (KProperty1 kProperty1 : memberProperties) {
                    KProperty1 kProperty12 = kProperty1;
                    Iterator<T> it = kProperty12.getAnnotations().iterator();
                    while (true) {
                        obj = null;
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((Annotation) next) instanceof Field) {
                            break;
                        }
                    }
                    Field field = (Field) next;
                    if (field != null) {
                        TypeConverter<?> typeConverterObtainTypeConverter = ((RecordTypeConverter) recordTypeConverter).converterProvider.obtainTypeConverter(kProperty1.getReturnType());
                        Iterator<T> it2 = kProperty12.getAnnotations().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next2 = it2.next();
                            if (((Annotation) next2) instanceof Required) {
                                obj = next2;
                                break;
                            }
                        }
                        obj = TuplesKt.to(kProperty1, new RecordTypeConverter.PropertyDescriptor(typeConverterObtainTypeConverter, field, ((Required) obj) != null, recordTypeConverter.getValidators(kProperty1)));
                    }
                    arrayList.add(obj);
                }
                return MapsKt.toMap(CollectionsKt.filterNotNull(arrayList));
            }
        });
    }

    private final Map<KProperty1<? extends Object, ?>, PropertyDescriptor> getPropertyDescriptors() {
        return (Map) this.propertyDescriptors.getValue();
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public T convertFromDynamic(Dynamic value, AppContext context) throws RecordCastException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            return (T) convertFromReadableMap(value.asMap(), context);
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
            throw new RecordCastException(this.type, unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public T convertFromAny(Object value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof ReadableMap) {
            return (T) convertFromReadableMap((ReadableMap) value, context);
        }
        return (T) value;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.READABLE_MAP);
    }

    private final T convertFromReadableMap(ReadableMap jsMap, AppContext context) throws FieldRequiredException {
        FieldCastException fieldCastException;
        KClassifier classifier = this.type.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        T tConstruct = getObjectConstructor((KClass) classifier).construct();
        for (Map.Entry<KProperty1<? extends Object, ?>, PropertyDescriptor> entry : getPropertyDescriptors().entrySet()) {
            KProperty1<? extends Object, ?> key = entry.getKey();
            PropertyDescriptor value = entry.getValue();
            String strKey = value.getFieldAnnotation().key();
            if (StringsKt.isBlank(strKey)) {
                strKey = null;
            }
            if (strKey == null) {
                strKey = key.getName();
            }
            if (!jsMap.hasKey(strKey)) {
                if (value.isRequired()) {
                    throw new FieldRequiredException(key);
                }
            } else {
                Dynamic dynamic = jsMap.getDynamic(strKey);
                try {
                    java.lang.reflect.Field javaField = ReflectJvmMapping.getJavaField(key);
                    Intrinsics.checkNotNull(javaField);
                    try {
                        Object objConvert = value.getTypeConverter().convert(dynamic, context);
                        if (objConvert != null) {
                            Iterator<T> it = value.getValidators().iterator();
                            while (it.hasNext()) {
                                FieldValidator fieldValidator = (FieldValidator) it.next();
                                Intrinsics.checkNotNull(fieldValidator, "null cannot be cast to non-null type expo.modules.kotlin.records.FieldValidator<kotlin.Any>");
                                fieldValidator.validate(objConvert);
                            }
                        }
                        javaField.setAccessible(true);
                        javaField.set(tConstruct, objConvert);
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                } finally {
                    dynamic.recycle();
                }
            }
        }
        Intrinsics.checkNotNull(tConstruct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.RecordTypeConverter");
        return tConstruct;
    }

    private final <T> ObjectConstructor<T> getObjectConstructor(KClass<T> clazz) {
        return this.objectConstructorFactory.get(clazz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<FieldValidator<?>> getValidators(KProperty1<? extends Object, ?> property) {
        Pair pair;
        Object next;
        List<Annotation> annotations = property.getAnnotations();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(annotations, 10));
        for (Annotation annotation : annotations) {
            Iterator<T> it = JvmClassMappingKt.getAnnotationClass(annotation).getAnnotations().iterator();
            while (true) {
                pair = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Annotation) next) instanceof BindUsing) {
                    break;
                }
            }
            BindUsing bindUsing = (BindUsing) next;
            if (bindUsing != null) {
                pair = TuplesKt.to(annotation, bindUsing);
            }
            arrayList.add(pair);
        }
        List<Pair> listFilterNotNull = CollectionsKt.filterNotNull(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
        for (Pair pair2 : listFilterNotNull) {
            Annotation annotation2 = (Annotation) pair2.component1();
            Object objCreateInstance = KClasses.createInstance(Reflection.getOrCreateKotlinClass(((BindUsing) pair2.component2()).binder()));
            Intrinsics.checkNotNull(objCreateInstance, "null cannot be cast to non-null type expo.modules.kotlin.records.ValidationBinder");
            arrayList2.add(((ValidationBinder) objCreateInstance).bind(annotation2, property.getReturnType()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RecordTypeConverter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0002\u0010\u000bJ\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter$PropertyDescriptor;", "", "typeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "fieldAnnotation", "Lexpo/modules/kotlin/records/Field;", "isRequired", "", "validators", "", "Lexpo/modules/kotlin/records/FieldValidator;", "(Lexpo/modules/kotlin/types/TypeConverter;Lexpo/modules/kotlin/records/Field;ZLjava/util/List;)V", "getFieldAnnotation", "()Lexpo/modules/kotlin/records/Field;", "()Z", "getTypeConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "getValidators", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final /* data */ class PropertyDescriptor {
        private final Field fieldAnnotation;
        private final boolean isRequired;
        private final TypeConverter<?> typeConverter;
        private final List<FieldValidator<?>> validators;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PropertyDescriptor copy$default(PropertyDescriptor propertyDescriptor, TypeConverter typeConverter, Field field, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                typeConverter = propertyDescriptor.typeConverter;
            }
            if ((i & 2) != 0) {
                field = propertyDescriptor.fieldAnnotation;
            }
            if ((i & 4) != 0) {
                z = propertyDescriptor.isRequired;
            }
            if ((i & 8) != 0) {
                list = propertyDescriptor.validators;
            }
            return propertyDescriptor.copy(typeConverter, field, z, list);
        }

        public final TypeConverter<?> component1() {
            return this.typeConverter;
        }

        /* renamed from: component2, reason: from getter */
        public final Field getFieldAnnotation() {
            return this.fieldAnnotation;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsRequired() {
            return this.isRequired;
        }

        public final List<FieldValidator<?>> component4() {
            return this.validators;
        }

        public final PropertyDescriptor copy(TypeConverter<?> typeConverter, Field fieldAnnotation, boolean isRequired, List<? extends FieldValidator<?>> validators) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(fieldAnnotation, "fieldAnnotation");
            Intrinsics.checkNotNullParameter(validators, "validators");
            return new PropertyDescriptor(typeConverter, fieldAnnotation, isRequired, validators);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PropertyDescriptor)) {
                return false;
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) other;
            return Intrinsics.areEqual(this.typeConverter, propertyDescriptor.typeConverter) && Intrinsics.areEqual(this.fieldAnnotation, propertyDescriptor.fieldAnnotation) && this.isRequired == propertyDescriptor.isRequired && Intrinsics.areEqual(this.validators, propertyDescriptor.validators);
        }

        public int hashCode() {
            return (((((this.typeConverter.hashCode() * 31) + this.fieldAnnotation.hashCode()) * 31) + Boolean.hashCode(this.isRequired)) * 31) + this.validators.hashCode();
        }

        public String toString() {
            return "PropertyDescriptor(typeConverter=" + this.typeConverter + ", fieldAnnotation=" + this.fieldAnnotation + ", isRequired=" + this.isRequired + ", validators=" + this.validators + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PropertyDescriptor(TypeConverter<?> typeConverter, Field fieldAnnotation, boolean z, List<? extends FieldValidator<?>> validators) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(fieldAnnotation, "fieldAnnotation");
            Intrinsics.checkNotNullParameter(validators, "validators");
            this.typeConverter = typeConverter;
            this.fieldAnnotation = fieldAnnotation;
            this.isRequired = z;
            this.validators = validators;
        }

        public final TypeConverter<?> getTypeConverter() {
            return this.typeConverter;
        }

        public final Field getFieldAnnotation() {
            return this.fieldAnnotation;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }

        public final List<FieldValidator<?>> getValidators() {
            return this.validators;
        }
    }
}
