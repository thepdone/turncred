package expo.modules.kotlin.allocators;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;

/* compiled from: ObjectConstructorFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007J$\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0002J(\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0002J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0002¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "", "()V", "get", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "tryToUseDefaultConstructor", "Ljava/lang/Class;", "tryToUseDefaultKotlinConstructor", "useUnsafeAllocator", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ObjectConstructorFactory {
    public static final int $stable = 0;

    public final <T> ObjectConstructor<T> get(KClass<T> clazz) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ObjectConstructor<T> objectConstructorTryToUseDefaultConstructor = tryToUseDefaultConstructor(JvmClassMappingKt.getJavaClass((KClass) clazz));
        if (objectConstructorTryToUseDefaultConstructor != null) {
            return objectConstructorTryToUseDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorTryToUseDefaultKotlinConstructor = tryToUseDefaultKotlinConstructor(clazz);
        return objectConstructorTryToUseDefaultKotlinConstructor == null ? useUnsafeAllocator(JvmClassMappingKt.getJavaClass((KClass) clazz)) : objectConstructorTryToUseDefaultKotlinConstructor;
    }

    private final <T> ObjectConstructor<T> tryToUseDefaultConstructor(Class<T> clazz) throws NoSuchMethodException, SecurityException {
        try {
            final Constructor<T> declaredConstructor = clazz.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda1
                @Override // expo.modules.kotlin.allocators.ObjectConstructor
                public final Object construct() {
                    return ObjectConstructorFactory.tryToUseDefaultConstructor$lambda$0(declaredConstructor);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultConstructor$lambda$0(Constructor constructor) {
        return constructor.newInstance(new Object[0]);
    }

    private final <T> ObjectConstructor<T> tryToUseDefaultKotlinConstructor(KClass<T> clazz) {
        Iterator<T> it = clazz.getConstructors().iterator();
        boolean z = false;
        T t = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
            } else {
                T next = it.next();
                List<KParameter> parameters = ((KFunction) next).getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator<T> it2 = parameters.iterator();
                    while (it2.hasNext()) {
                        if (!((KParameter) it2.next()).isOptional()) {
                            break;
                        }
                    }
                }
                if (z) {
                    break;
                }
                z = true;
                t = next;
            }
        }
        t = null;
        final KFunction kFunction = (KFunction) t;
        if (kFunction == null) {
            return null;
        }
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda2
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return ObjectConstructorFactory.tryToUseDefaultKotlinConstructor$lambda$2(kFunction);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultKotlinConstructor$lambda$2(KFunction noArgsConstructor) {
        Intrinsics.checkNotNullParameter(noArgsConstructor, "$noArgsConstructor");
        return noArgsConstructor.callBy(MapsKt.emptyMap());
    }

    private final <T> ObjectConstructor<T> useUnsafeAllocator(Class<T> clazz) {
        final UnsafeAllocator<T> unsafeAllocatorCreateAllocator = UnsafeAllocator.INSTANCE.createAllocator(clazz);
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return ObjectConstructorFactory.useUnsafeAllocator$lambda$3(unsafeAllocatorCreateAllocator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object useUnsafeAllocator$lambda$3(UnsafeAllocator allocator) {
        Intrinsics.checkNotNullParameter(allocator, "$allocator");
        return allocator.newInstance();
    }
}
