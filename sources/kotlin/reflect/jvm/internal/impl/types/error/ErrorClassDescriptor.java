package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorClassDescriptor.kt */
/* loaded from: classes5.dex */
public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorClassDescriptor(Name name) {
        super(ErrorUtils.INSTANCE.getErrorModule(), name, Modality.OPEN, ClassKind.CLASS, CollectionsKt.emptyList(), SourceElement.NO_SOURCE, false, LockBasedStorageManager.NO_LOCKS);
        Intrinsics.checkNotNullParameter(name, "name");
        ClassConstructorDescriptorImpl classConstructorDescriptorImplCreate = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, SourceElement.NO_SOURCE);
        classConstructorDescriptorImplCreate.initialize(CollectionsKt.emptyList(), DescriptorVisibilities.INTERNAL);
        Intrinsics.checkNotNullExpressionValue(classConstructorDescriptorImplCreate, "apply(...)");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String string = classConstructorDescriptorImplCreate.getName().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        ErrorScope errorScopeCreateErrorScope = ErrorUtils.createErrorScope(errorScopeKind, string, "");
        classConstructorDescriptorImplCreate.setReturnType(new ErrorType(ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.ERROR_CLASS, new String[0]), errorScopeCreateErrorScope, ErrorTypeKind.ERROR_CLASS, null, false, new String[0], 24, null));
        initialize(errorScopeCreateErrorScope, SetsKt.setOf(classConstructorDescriptorImplCreate), classConstructorDescriptorImplCreate);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor substitutor) {
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String string = getName().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return ErrorUtils.createErrorScope(errorScopeKind, string, typeSubstitution.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    public String toString() {
        String strAsString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }
}
