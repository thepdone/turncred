package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: AbstractTypeAliasDescriptor.kt */
/* loaded from: classes5.dex */
public abstract class AbstractTypeAliasDescriptor extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbstractTypeAliasDescriptor.class), "constructors", "getConstructors()Ljava/util/Collection;"))};
    private final NotNullLazyValue constructors$delegate;
    private List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;
    private final StorageManager storageManager;
    private final AbstractTypeAliasDescriptor$typeConstructor$1 typeConstructor;
    private final DescriptorVisibility visibilityImpl;

    protected abstract List<TypeParameterDescriptor> getTypeConstructorTypeParameters();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    protected final StorageManager getStorageManager() {
        return this.storageManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1] */
    public AbstractTypeAliasDescriptor(StorageManager storageManager, DeclarationDescriptor containingDeclaration, Annotations annotations, Name name, SourceElement sourceElement, DescriptorVisibility visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        Intrinsics.checkNotNullParameter(visibilityImpl, "visibilityImpl");
        this.storageManager = storageManager;
        this.visibilityImpl = visibilityImpl;
        this.constructors$delegate = storageManager.createLazyValue(new Function0<Collection<? extends TypeAliasConstructorDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$constructors$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends TypeAliasConstructorDescriptor> invoke() {
                return this.this$0.getTypeAliasConstructors();
            }
        });
        this.typeConstructor = new TypeConstructor() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public boolean isDenotable() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            /* renamed from: getDeclarationDescriptor */
            public TypeAliasDescriptor mo7216getDeclarationDescriptor() {
                return this.this$0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public List<TypeParameterDescriptor> getParameters() {
                return this.this$0.getTypeConstructorTypeParameters();
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            /* renamed from: getSupertypes */
            public Collection<KotlinType> mo7217getSupertypes() {
                Collection<KotlinType> collectionMo7217getSupertypes = mo7216getDeclarationDescriptor().getUnderlyingType().getConstructor().mo7217getSupertypes();
                Intrinsics.checkNotNullExpressionValue(collectionMo7217getSupertypes, "getSupertypes(...)");
                return collectionMo7217getSupertypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public KotlinBuiltIns getBuiltIns() {
                return DescriptorUtilsKt.getBuiltIns(mo7216getDeclarationDescriptor());
            }

            public String toString() {
                return "[typealias " + mo7216getDeclarationDescriptor().getName().asString() + ']';
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                return this;
            }
        };
    }

    public final void initialize(List<? extends TypeParameterDescriptor> declaredTypeParameters) {
        Intrinsics.checkNotNullParameter(declaredTypeParameters, "declaredTypeParameters");
        this.declaredTypeParametersImpl = declaredTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor, D d) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitTypeAliasDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return TypeUtils.contains(getUnderlyingType(), new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.isInner.1
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3) {
                /*
                    r2 = this;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                    r0 = r3
                    kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                    boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r0)
                    if (r0 != 0) goto L28
                    kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor r0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.this
                    kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.getConstructor()
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.mo7216getDeclarationDescriptor()
                    boolean r1 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
                    if (r1 == 0) goto L28
                    kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r3
                    kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r3.getContainingDeclaration()
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
                    if (r3 != 0) goto L28
                    r3 = 1
                    goto L29
                L28:
                    r3 = 0
                L29:
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.C05491.invoke(kotlin.reflect.jvm.internal.impl.types.UnwrappedType):java.lang.Boolean");
            }
        });
    }

    public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        ArrayList arrayList = new ArrayList();
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            Intrinsics.checkNotNull(classConstructorDescriptor);
            TypeAliasConstructorDescriptor typeAliasConstructorDescriptorCreateIfAvailable = TypeAliasConstructorDescriptorImpl.Companion.createIfAvailable(this.storageManager, this, classConstructorDescriptor);
            if (typeAliasConstructorDescriptorCreateIfAvailable != null) {
                arrayList.add(typeAliasConstructorDescriptorCreateIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List list = this.declaredTypeParametersImpl;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return Modality.FINAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        return this.visibilityImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "typealias " + getName().asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasDescriptor getOriginal() {
        DeclarationDescriptorWithSource original = super.getOriginal();
        Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (TypeAliasDescriptor) original;
    }

    protected final SimpleType computeDefaultType() {
        MemberScope.Empty unsubstitutedMemberScope;
        AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this;
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null || (unsubstitutedMemberScope = classDescriptor.getUnsubstitutedMemberScope()) == null) {
            unsubstitutedMemberScope = MemberScope.Empty.INSTANCE;
        }
        SimpleType simpleTypeMakeUnsubstitutedType = TypeUtils.makeUnsubstitutedType(abstractTypeAliasDescriptor, unsubstitutedMemberScope, new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.computeDefaultType.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                ClassifierDescriptor classifierDescriptorRefineDescriptor = kotlinTypeRefiner.refineDescriptor(AbstractTypeAliasDescriptor.this);
                if (classifierDescriptorRefineDescriptor != null) {
                    return classifierDescriptorRefineDescriptor.getDefaultType();
                }
                return null;
            }
        });
        Intrinsics.checkNotNullExpressionValue(simpleTypeMakeUnsubstitutedType, "makeUnsubstitutedType(...)");
        return simpleTypeMakeUnsubstitutedType;
    }
}
