package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;

/* compiled from: modifierChecks.kt */
/* loaded from: classes5.dex */
public final class OperatorChecks extends AbstractModifierChecks {
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    private static final List<Checks> checks = CollectionsKt.listOf((Object[]) new Checks[]{new Checks(OperatorNameConventions.GET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(1)}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(2)}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
            List<ValueParameterDescriptor> valueParameters = $receiver.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt.lastOrNull((List) valueParameters);
            boolean z = false;
            if (valueParameterDescriptor != null && !DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null) {
                z = true;
            }
            OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
            if (z) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }), new Checks(OperatorNameConventions.GET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(2), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(3), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.PROVIDE_DELEGATE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.Equals(2), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.INVOKE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.CONTAINS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.ITERATOR, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.HAS_NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.RANGE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.RANGE_UNTIL, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.EQUALS, new Check[]{MemberKindCheck.Member.INSTANCE}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2
        private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
            return (declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) declarationDescriptor);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[EDGE_INSN: B:26:0x0054->B:17:0x0054 BREAK  A[LOOP:0: B:8:0x0031->B:27:?]] */
        @Override // kotlin.jvm.functions.Function1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4) {
            /*
                r3 = this;
                java.lang.String r0 = "$this$$receiver"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                kotlin.reflect.jvm.internal.impl.util.OperatorChecks r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
                kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks r0 = (kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks) r0
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r4.getContainingDeclaration()
                java.lang.String r1 = "getContainingDeclaration(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                boolean r0 = invoke$isAny(r0)
                if (r0 != 0) goto L54
                java.util.Collection r0 = r4.getOverriddenDescriptors()
                java.lang.String r2 = "getOverriddenDescriptors(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                r2 = r0
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L2d
                goto L4b
            L2d:
                java.util.Iterator r0 = r0.iterator()
            L31:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L4b
                java.lang.Object r2 = r0.next()
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r2.getContainingDeclaration()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
                boolean r2 = invoke$isAny(r2)
                if (r2 == 0) goto L31
                goto L54
            L4b:
                boolean r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt.isTypedEqualsInValueClass(r4)
                if (r0 == 0) goto L52
                goto L54
            L52:
                r0 = 0
                goto L55
            L54:
                r0 = 1
            L55:
                if (r0 != 0) goto Lad
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r2 = "must override ''equals()'' in Any"
                r0.<init>(r2)
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r4.getContainingDeclaration()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
                boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(r2)
                if (r1 == 0) goto La3
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer r1 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.SHORT_NAMES_IN_TYPES
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r4.getContainingDeclaration()
                java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r2)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
                kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getDefaultType()
                java.lang.String r2 = "getDefaultType(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r4)
                java.lang.String r4 = r1.renderType(r4)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = " or define ''equals(other: "
                r1.<init>(r2)
                java.lang.StringBuilder r4 = r1.append(r4)
                java.lang.String r1 = "): Boolean''"
                java.lang.StringBuilder r4 = r4.append(r1)
                java.lang.String r4 = r4.toString()
                r0.append(r4)
            La3:
                java.lang.String r4 = r0.toString()
                java.lang.String r0 = "toString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                goto Lae
            Lad:
                r4 = 0
            Lae:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):java.lang.String");
        }
    }), new Checks(OperatorNameConventions.COMPARE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsInt.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(CollectionsKt.listOf((Object[]) new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$3
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor $receiver) {
            boolean zIsSubtypeOf;
            Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
            ReceiverParameterDescriptor dispatchReceiverParameter = $receiver.getDispatchReceiverParameter();
            if (dispatchReceiverParameter == null) {
                dispatchReceiverParameter = $receiver.getExtensionReceiverParameter();
            }
            OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
            boolean z = false;
            if (dispatchReceiverParameter != null) {
                KotlinType returnType = $receiver.getReturnType();
                if (returnType != null) {
                    KotlinType type = dispatchReceiverParameter.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    zIsSubtypeOf = TypeUtilsKt.isSubtypeOf(returnType, type);
                } else {
                    zIsSubtypeOf = false;
                }
                if (zIsSubtypeOf || OperatorChecks.INSTANCE.incDecCheckForExpectClass($receiver, dispatchReceiverParameter)) {
                    z = true;
                }
            }
            if (z) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }), new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsUnit.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null)});

    private OperatorChecks() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    public List<Checks> getChecks$descriptors() {
        return checks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean incDecCheckForExpectClass(FunctionDescriptor functionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor) {
        ClassId classId;
        KotlinType returnType;
        ReceiverValue value = receiverParameterDescriptor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        if (!(value instanceof ImplicitClassReceiver)) {
            return false;
        }
        ClassDescriptor classDescriptor = ((ImplicitClassReceiver) value).getClassDescriptor();
        if (!classDescriptor.isExpect() || (classId = DescriptorUtilsKt.getClassId(classDescriptor)) == null) {
            return false;
        }
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = FindClassInModuleKt.findClassifierAcrossModuleDependencies(DescriptorUtilsKt.getModule(classDescriptor), classId);
        TypeAliasDescriptor typeAliasDescriptor = classifierDescriptorFindClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor ? (TypeAliasDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies : null;
        if (typeAliasDescriptor == null || (returnType = functionDescriptor.getReturnType()) == null) {
            return false;
        }
        return TypeUtilsKt.isSubtypeOf(returnType, typeAliasDescriptor.getExpandedType());
    }
}
