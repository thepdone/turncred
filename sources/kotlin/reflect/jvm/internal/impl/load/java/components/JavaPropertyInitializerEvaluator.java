package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: JavaPropertyInitializerEvaluator.kt */
/* loaded from: classes5.dex */
public interface JavaPropertyInitializerEvaluator {
    ConstantValue<?> getInitializerConstant(JavaField javaField, PropertyDescriptor propertyDescriptor);

    /* compiled from: JavaPropertyInitializerEvaluator.kt */
    public static final class DoNothing implements JavaPropertyInitializerEvaluator {
        public static final DoNothing INSTANCE = new DoNothing();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator
        public ConstantValue<?> getInitializerConstant(JavaField field, PropertyDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(field, "field");
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return null;
        }

        private DoNothing() {
        }
    }
}
