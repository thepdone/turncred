package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* compiled from: IntersectionTypeConstructor.kt */
/* loaded from: classes5.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    private KotlinType alternative;
    private final int hashCode;
    private final LinkedHashSet<KotlinType> intersectedTypes;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo7216getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public IntersectionTypeConstructor(Collection<? extends KotlinType> typesToIntersect) {
        Intrinsics.checkNotNullParameter(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(typesToIntersect);
        this.intersectedTypes = linkedHashSet;
        this.hashCode = linkedHashSet.hashCode();
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> collection, KotlinType kotlinType) {
        this(collection);
        this.alternative = kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public Collection<KotlinType> mo7217getSupertypes() {
        return this.intersectedTypes;
    }

    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
        return builtIns;
    }

    public String toString() {
        return makeDebugNameForIntersectionType$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<KotlinType, String>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.makeDebugNameForIntersectionType.1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(KotlinType it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.toString();
                }
            };
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    public final String makeDebugNameForIntersectionType(final Function1<? super KotlinType, ? extends Object> getProperTypeRelatedToStringify) {
        Intrinsics.checkNotNullParameter(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(this.intersectedTypes, new Comparator() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                KotlinType kotlinType = (KotlinType) t;
                Function1 function1 = getProperTypeRelatedToStringify;
                Intrinsics.checkNotNull(kotlinType);
                String string = function1.invoke(kotlinType).toString();
                KotlinType kotlinType2 = (KotlinType) t2;
                Function1 function12 = getProperTypeRelatedToStringify;
                Intrinsics.checkNotNull(kotlinType2);
                return ComparisonsKt.compareValues(string, function12.invoke(kotlinType2).toString());
            }
        }), " & ", "{", "}", 0, null, new Function1<KotlinType, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.makeDebugNameForIntersectionType.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(KotlinType kotlinType) {
                Function1<KotlinType, Object> function1 = getProperTypeRelatedToStringify;
                Intrinsics.checkNotNull(kotlinType);
                return function1.invoke(kotlinType).toString();
            }
        }, 24, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntersectionTypeConstructor) {
            return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) obj).intersectedTypes);
        }
        return false;
    }

    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt.emptyList(), false, createScopeForKotlinType(), new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.createType.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                return IntersectionTypeConstructor.this.refine(kotlinTypeRefiner).createType();
            }
        });
    }

    public int hashCode() {
        return this.hashCode;
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType kotlinType) {
        return new IntersectionTypeConstructor(this.intersectedTypes, kotlinType);
    }

    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<KotlinType> collectionMo7217getSupertypes = mo7217getSupertypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionMo7217getSupertypes, 10));
        Iterator<T> it = collectionMo7217getSupertypes.iterator();
        boolean z = false;
        while (it.hasNext()) {
            arrayList.add(((KotlinType) it.next()).refine(kotlinTypeRefiner));
            z = true;
        }
        ArrayList arrayList2 = arrayList;
        IntersectionTypeConstructor alternative = null;
        if (z) {
            KotlinType alternativeType = getAlternativeType();
            alternative = new IntersectionTypeConstructor(arrayList2).setAlternative(alternativeType != null ? alternativeType.refine(kotlinTypeRefiner) : null);
        }
        return alternative == null ? this : alternative;
    }
}
