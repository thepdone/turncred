package kotlin.reflect.jvm.internal;

import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* compiled from: KDeclarationContainerImpl.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%H&J\"\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u001a\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010/\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0002JE\u00103\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J(\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\u0006\u0012\u0002\b\u00030\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.H\u0002J=\u0010:\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", FirebaseAnalytics.Param.INDEX, "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", ViewProps.END, "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    private static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int index);

    public abstract Collection<PropertyDescriptor> getProperties(Name name);

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* renamed from: moduleData$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal moduleData;

        public Data() {
            this.moduleData = ReflectProperties.lazySoft(new Function0<RuntimeModuleData>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$moduleData$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final RuntimeModuleData invoke() {
                    return ModuleByClassLoaderKt.getOrCreateModule(kDeclarationContainerImpl.getJClass());
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RuntimeModuleData getModuleData() {
            T value = this.moduleData.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (RuntimeModuleData) value;
        }
    }

    protected Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1 r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            r0.<init>(r7)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope r8 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope) r8
            r1 = 3
            r2 = 0
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, r2, r2, r1, r2)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r8 = r8.iterator()
        L24:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L5c
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L55
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 != 0) goto L55
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L55
            r4 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor) r4
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = r3.accept(r4, r5)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L56
        L55:
            r3 = r2
        L56:
            if (r3 == 0) goto L24
            r1.add(r3)
            goto L24
        L5c:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r8 = kotlin.collections.CollectionsKt.toList(r1)
            java.util.Collection r8 = (java.util.Collection) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    protected static final class MemberBelonginess {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MemberBelonginess[] $VALUES;
        public static final MemberBelonginess DECLARED = new MemberBelonginess("DECLARED", 0);
        public static final MemberBelonginess INHERITED = new MemberBelonginess("INHERITED", 1);

        private static final /* synthetic */ MemberBelonginess[] $values() {
            return new MemberBelonginess[]{DECLARED, INHERITED};
        }

        public static MemberBelonginess valueOf(String str) {
            return (MemberBelonginess) Enum.valueOf(MemberBelonginess.class, str);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[]) $VALUES.clone();
        }

        private MemberBelonginess(String str, int i) {
        }

        static {
            MemberBelonginess[] memberBelonginessArr$values = $values();
            $VALUES = memberBelonginessArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(memberBelonginessArr$values);
        }

        public final boolean accept(CallableMemberDescriptor member) {
            Intrinsics.checkNotNullParameter(member, "member");
            return member.getKind().isReal() == (this == DECLARED);
        }
    }

    public final PropertyDescriptor findPropertyDescriptor(String name, String signature) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        MatchResult matchResultMatchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(signature);
        if (matchResultMatchEntire != null) {
            String str = matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + str + " not found in " + getJClass());
        }
        Name nameIdentifier = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        Collection<PropertyDescriptor> properties = getProperties(nameIdentifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) obj).getString(), signature)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList2.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.single((List) arrayList2);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList2) {
            DescriptorVisibility visibility = ((PropertyDescriptor) obj2).getVisibility();
            Object obj3 = linkedHashMap.get(visibility);
            if (obj3 == null) {
                obj3 = (List) new ArrayList();
                linkedHashMap.put(visibility, obj3);
            }
            ((List) obj3).add(obj2);
        }
        final KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 kDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 = new Function2<DescriptorVisibility, DescriptorVisibility, Integer>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
                Integer numCompare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
                return Integer.valueOf(numCompare == null ? 0 : numCompare.intValue());
            }
        };
        Collection collectionValues = MapsKt.toSortedMap(linkedHashMap, new Comparator(kDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$0
            private final Function2 arg$0;

            {
                this.arg$0 = kDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2;
            }

            @Override // java.util.Comparator
            public int compare(Object obj4, Object obj5) {
                return KDeclarationContainerImpl.findPropertyDescriptor$lambda$3(this.arg$0, obj4, obj5);
            }
        }).values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        List list = (List) CollectionsKt.last(collectionValues);
        if (list.size() == 1) {
            Intrinsics.checkNotNull(list);
            return (PropertyDescriptor) CollectionsKt.first(list);
        }
        Name nameIdentifier2 = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        String strJoinToString$default = CollectionsKt.joinToString$default(getProperties(nameIdentifier2), "\n", null, null, 0, null, new Function1<PropertyDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(PropertyDescriptor descriptor) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                return DescriptorRenderer.DEBUG_TEXT.render(descriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).getString();
            }
        }, 30, null);
        throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this + ':' + (strJoinToString$default.length() == 0 ? " no members found" : "\n" + strJoinToString$default));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$3(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor findFunctionDescriptor(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findFunctionDescriptor(java.lang.String, java.lang.String):kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor");
    }

    private final Method lookupMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) throws NoSuchMethodException, SecurityException {
        Class<?> clsTryLoadClass;
        Method methodLookupMethod;
        if (z) {
            clsArr[0] = cls;
        }
        Method methodTryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (methodTryGetMethod != null) {
            return methodTryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (methodLookupMethod = lookupMethod(superclass, str, clsArr, cls2, z)) != null) {
            return methodLookupMethod;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
        for (Class<?> cls3 : interfaces) {
            Intrinsics.checkNotNull(cls3);
            Method methodLookupMethod2 = lookupMethod(cls3, str, clsArr, cls2, z);
            if (methodLookupMethod2 != null) {
                return methodLookupMethod2;
            }
            if (z && (clsTryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls")) != null) {
                clsArr[0] = cls3;
                Method methodTryGetMethod2 = tryGetMethod(clsTryLoadClass, str, clsArr, cls2);
                if (methodTryGetMethod2 != null) {
                    return methodTryGetMethod2;
                }
            }
        }
        return null;
    }

    private final Method tryGetMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) throws NoSuchMethodException, SecurityException {
        Method method;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (Intrinsics.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            Method[] methodArr = declaredMethods;
            int length = methodArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methodArr[i];
                Method method2 = method;
                if (Intrinsics.areEqual(method2.getName(), str) && Intrinsics.areEqual(method2.getReturnType(), cls2) && Arrays.equals(method2.getParameterTypes(), clsArr)) {
                    break;
                }
                i++;
            }
            return method;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method findMethodBySignature(String name, String desc) throws NoSuchMethodException, SecurityException {
        Method methodLookupMethod;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        Class<?>[] clsArr = (Class[]) loadParameterTypes(desc).toArray(new Class[0]);
        Class<?> clsLoadReturnType = loadReturnType(desc);
        Method methodLookupMethod2 = lookupMethod(getMethodOwner(), name, clsArr, clsLoadReturnType, false);
        if (methodLookupMethod2 != null) {
            return methodLookupMethod2;
        }
        if (!getMethodOwner().isInterface() || (methodLookupMethod = lookupMethod(Object.class, name, clsArr, clsLoadReturnType, false)) == null) {
            return null;
        }
        return methodLookupMethod;
    }

    public final Method findDefaultMethod(String name, String desc, boolean isMember) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (isMember) {
            arrayList.add(getJClass());
        }
        addParametersAndMasks(arrayList, desc, false);
        return lookupMethod(getMethodOwner(), name + "$default", (Class[]) arrayList.toArray(new Class[0]), loadReturnType(desc), isMember);
    }

    public final Constructor<?> findConstructorBySignature(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(desc));
    }

    public final Constructor<?> findDefaultConstructor(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        addParametersAndMasks(arrayList, desc, true);
        Unit unit = Unit.INSTANCE;
        return tryGetConstructor(jClass, arrayList);
    }

    private final void addParametersAndMasks(List<Class<?>> result, String desc, boolean isConstructor) {
        List<Class<?>> listLoadParameterTypes = loadParameterTypes(desc);
        result.addAll(listLoadParameterTypes);
        int size = (listLoadParameterTypes.size() + 31) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> TYPE = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            result.add(TYPE);
        }
        if (isConstructor) {
            Class<?> DEFAULT_CONSTRUCTOR_MARKER2 = DEFAULT_CONSTRUCTOR_MARKER;
            result.remove(DEFAULT_CONSTRUCTOR_MARKER2);
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CONSTRUCTOR_MARKER2, "DEFAULT_CONSTRUCTOR_MARKER");
            result.add(DEFAULT_CONSTRUCTOR_MARKER2);
            return;
        }
        result.add(Object.class);
    }

    private final List<Class<?>> loadParameterTypes(String desc) {
        int iIndexOf$default;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (desc.charAt(i) != ')') {
            int i2 = i;
            while (desc.charAt(i2) == '[') {
                i2++;
            }
            char cCharAt = desc.charAt(i2);
            if (StringsKt.contains$default((CharSequence) "VZCBSIFJD", cCharAt, false, 2, (Object) null)) {
                iIndexOf$default = i2 + 1;
            } else if (cCharAt == 'L') {
                iIndexOf$default = StringsKt.indexOf$default((CharSequence) desc, ';', i, false, 4, (Object) null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
            }
            arrayList.add(parseType(desc, i, iIndexOf$default));
            i = iIndexOf$default;
        }
        return arrayList;
    }

    private final Class<?> parseType(String desc, int begin, int end) throws ClassNotFoundException {
        char cCharAt = desc.charAt(begin);
        if (cCharAt == 'L') {
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
            String strSubstring = desc.substring(begin + 1, end - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Class<?> clsLoadClass = safeClassLoader.loadClass(StringsKt.replace$default(strSubstring, IOUtils.DIR_SEPARATOR_UNIX, FilenameUtils.EXTENSION_SEPARATOR, false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loadClass(...)");
            return clsLoadClass;
        }
        if (cCharAt == '[') {
            return UtilKt.createArrayType(parseType(desc, begin + 1, end));
        }
        if (cCharAt == 'V') {
            Class<?> TYPE = Void.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == 'C') {
            return Character.TYPE;
        }
        if (cCharAt == 'B') {
            return Byte.TYPE;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'D') {
            return Double.TYPE;
        }
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
    }

    private final Class<?> loadReturnType(String desc) {
        return parseType(desc, StringsKt.indexOf$default((CharSequence) desc, ')', 0, false, 6, (Object) null) + 1, desc.length());
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }
}
