package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: Substitutable.kt */
/* loaded from: classes5.dex */
public interface Substitutable<T extends DeclarationDescriptorNonRoot> {
    T substitute(TypeSubstitutor typeSubstitutor);
}
