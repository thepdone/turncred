package expo.modules.kotlin.types;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: AnyType.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/types/EmptyKType;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClass;", "isMarkedNullable", "", "(Lkotlin/reflect/KClass;Z)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClass;", "()Z", "equals", "other", "", "hashCode", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyKType implements KType {
    public static final int $stable = 8;
    private final KClass<?> classifier;
    private final boolean isMarkedNullable;

    public EmptyKType(KClass<?> classifier, boolean z) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        this.classifier = classifier;
        this.isMarkedNullable = z;
    }

    public /* synthetic */ EmptyKType(KClass kClass, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? false : z);
    }

    @Override // kotlin.reflect.KType
    public KClass<?> getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    /* renamed from: isMarkedNullable, reason: from getter */
    public boolean getIsMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmptyKType)) {
            return false;
        }
        EmptyKType emptyKType = (EmptyKType) other;
        return Intrinsics.areEqual(getClassifier(), emptyKType.getClassifier()) && getIsMarkedNullable() == emptyKType.getIsMarkedNullable();
    }

    public int hashCode() {
        return (getClassifier().hashCode() * 31) + Boolean.hashCode(getIsMarkedNullable());
    }
}
