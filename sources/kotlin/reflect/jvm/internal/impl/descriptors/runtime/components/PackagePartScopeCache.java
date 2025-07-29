package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* compiled from: PackagePartScopeCache.kt */
/* loaded from: classes5.dex */
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache;
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver resolver, ReflectKotlinClassFinder kotlinClassFinder) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.resolver = resolver;
        this.kotlinClassFinder = kotlinClassFinder;
        this.cache = new ConcurrentHashMap<>();
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass fileClass) {
        ArrayList arrayListListOf;
        Intrinsics.checkNotNullParameter(fileClass, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope> concurrentHashMap = this.cache;
        ClassId classId = fileClass.getClassId();
        MemberScope memberScope = concurrentHashMap.get(classId);
        if (memberScope == null) {
            FqName packageFqName = fileClass.getClassId().getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "getPackageFqName(...)");
            if (fileClass.getClassHeader().getKind() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> multifilePartNames = fileClass.getClassHeader().getMultifilePartNames();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = multifilePartNames.iterator();
                while (it.hasNext()) {
                    ClassId classId2 = ClassId.topLevel(JvmClassName.byInternalName((String) it.next()).getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(...)");
                    KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId2, DeserializationHelpersKt.jvmMetadataVersionOrDefault(this.resolver.getComponents().getConfiguration()));
                    if (kotlinJvmBinaryClassFindKotlinClass != null) {
                        arrayList.add(kotlinJvmBinaryClassFindKotlinClass);
                    }
                }
                arrayListListOf = arrayList;
            } else {
                arrayListListOf = CollectionsKt.listOf(fileClass);
            }
            EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayListListOf.iterator();
            while (it2.hasNext()) {
                MemberScope memberScopeCreateKotlinPackagePartScope = this.resolver.createKotlinPackagePartScope(emptyPackageFragmentDescriptor, (KotlinJvmBinaryClass) it2.next());
                if (memberScopeCreateKotlinPackagePartScope != null) {
                    arrayList2.add(memberScopeCreateKotlinPackagePartScope);
                }
            }
            MemberScope memberScopeCreate = ChainedMemberScope.Companion.create("package " + packageFqName + " (" + fileClass + ')', CollectionsKt.toList(arrayList2));
            MemberScope memberScopePutIfAbsent = concurrentHashMap.putIfAbsent(classId, memberScopeCreate);
            memberScope = memberScopePutIfAbsent == null ? memberScopeCreate : memberScopePutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(memberScope, "getOrPut(...)");
        return memberScope;
    }
}
