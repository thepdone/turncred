package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;

/* compiled from: JavaClassesTracker.kt */
/* loaded from: classes5.dex */
public interface JavaClassesTracker {
    void reportClass(JavaClassDescriptor javaClassDescriptor);

    /* compiled from: JavaClassesTracker.kt */
    public static final class Default implements JavaClassesTracker {
        public static final Default INSTANCE = new Default();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public void reportClass(JavaClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        }

        private Default() {
        }
    }
}
