package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: AnnotationDeserializer.kt */
/* loaded from: classes5.dex */
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    /* compiled from: AnnotationDeserializer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor module, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf.Annotation proto, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        ClassDescriptor classDescriptorResolveClass = resolveClass(NameResolverUtilKt.getClassId(nameResolver, proto.getId()));
        Map mapEmptyMap = MapsKt.emptyMap();
        if (proto.getArgumentCount() != 0) {
            ClassDescriptor classDescriptor = classDescriptorResolveClass;
            if (!ErrorUtils.isError(classDescriptor) && DescriptorUtils.isAnnotationClass(classDescriptor)) {
                Collection<ClassConstructorDescriptor> constructors = classDescriptorResolveClass.getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) CollectionsKt.singleOrNull(constructors);
                if (classConstructorDescriptor != null) {
                    List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                    List<ValueParameterDescriptor> list = valueParameters;
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                    for (Object obj : list) {
                        linkedHashMap.put(((ValueParameterDescriptor) obj).getName(), obj);
                    }
                    List<ProtoBuf.Annotation.Argument> argumentList = proto.getArgumentList();
                    Intrinsics.checkNotNullExpressionValue(argumentList, "getArgumentList(...)");
                    ArrayList arrayList = new ArrayList();
                    for (ProtoBuf.Annotation.Argument argument : argumentList) {
                        Intrinsics.checkNotNull(argument);
                        Pair<Name, ConstantValue<?>> pairResolveArgument = resolveArgument(argument, linkedHashMap, nameResolver);
                        if (pairResolveArgument != null) {
                            arrayList.add(pairResolveArgument);
                        }
                    }
                    mapEmptyMap = MapsKt.toMap(arrayList);
                }
            }
        }
        return new AnnotationDescriptorImpl(classDescriptorResolveClass.getDefaultType(), mapEmptyMap, SourceElement.NO_SOURCE);
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument argument, Map<Name, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = map.get(NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        Name name = NameResolverUtilKt.getName(nameResolver, argument.getNameId());
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return new Pair<>(name, resolveValueAndCheckExpectedType(type, value, nameResolver));
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> constantValueResolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(constantValueResolveValue, kotlinType, value)) {
            constantValueResolveValue = null;
        }
        return constantValueResolveValue == null ? ErrorValue.Companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType) : constantValueResolveValue;
    }

    public final ConstantValue<?> resolveValue(KotlinType expectedType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean zBooleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                return zBooleanValue ? new UByteValue(intValue) : new ByteValue(intValue);
            case 2:
                return new CharValue((char) value.getIntValue());
            case 3:
                short intValue2 = (short) value.getIntValue();
                return zBooleanValue ? new UShortValue(intValue2) : new ShortValue(intValue2);
            case 4:
                int intValue3 = (int) value.getIntValue();
                return zBooleanValue ? new UIntValue(intValue3) : new IntValue(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                return zBooleanValue ? new ULongValue(intValue4) : new LongValue(intValue4);
            case 6:
                return new FloatValue(value.getFloatValue());
            case 7:
                return new DoubleValue(value.getDoubleValue());
            case 8:
                return new BooleanValue(value.getIntValue() != 0);
            case 9:
                return new StringValue(nameResolver.getString(value.getStringValue()));
            case 10:
                return new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
            case 11:
                return new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                Intrinsics.checkNotNullExpressionValue(annotation, "getAnnotation(...)");
                return new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                Intrinsics.checkNotNullExpressionValue(arrayElementList, "getArrayElementList(...)");
                List<ProtoBuf.Annotation.Argument.Value> list = arrayElementList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ProtoBuf.Annotation.Argument.Value value2 : list) {
                    SimpleType anyType = getBuiltIns().getAnyType();
                    Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
                    Intrinsics.checkNotNull(value2);
                    arrayList.add(resolveValue(anyType, value2, nameResolver));
                }
                return constantValueFactory.createArrayValue(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + ')').toString());
        }
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 10) {
            ClassifierDescriptor classifierDescriptorMo7216getDeclarationDescriptor = kotlinType.getConstructor().mo7216getDeclarationDescriptor();
            ClassDescriptor classDescriptor = classifierDescriptorMo7216getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo7216getDeclarationDescriptor : null;
            if (classDescriptor != null && !KotlinBuiltIns.isKClass(classDescriptor)) {
                return false;
            }
        } else if (i == 13) {
            if (!(constantValue instanceof ArrayValue) || ((ArrayValue) constantValue).getValue().size() != value.getArrayElementList().size()) {
                throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + constantValue).toString());
            }
            KotlinType arrayElementType = getBuiltIns().getArrayElementType(kotlinType);
            Intrinsics.checkNotNullExpressionValue(arrayElementType, "getArrayElementType(...)");
            ArrayValue arrayValue = (ArrayValue) constantValue;
            Iterable indices = CollectionsKt.getIndices(arrayValue.getValue());
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((IntIterator) it).nextInt();
                    ConstantValue<?> constantValue2 = arrayValue.getValue().get(iNextInt);
                    ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(iNextInt);
                    Intrinsics.checkNotNullExpressionValue(arrayElement, "getArrayElement(...)");
                    if (!doesValueConformToExpectedType(constantValue2, arrayElementType, arrayElement)) {
                        return false;
                    }
                }
            }
        } else {
            return Intrinsics.areEqual(constantValue.getType(this.module), kotlinType);
        }
        return true;
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }
}
