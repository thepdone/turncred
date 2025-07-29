package com.nimbusds.jose.shaded.gson.internal;

import com.nimbusds.jose.shaded.gson.InstanceCreator;
import com.nimbusds.jose.shaded.gson.JsonIOException;
import com.nimbusds.jose.shaded.gson.ReflectionAccessFilter;
import com.nimbusds.jose.shaded.gson.internal.reflect.ReflectionHelper;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes5.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z;
        this.reflectionFilters = list;
    }

    static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
        return null;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) throws NoSuchMethodException, SecurityException {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.1
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.2
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> objectConstructorNewSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (objectConstructorNewSpecialCollectionConstructor != null) {
            return objectConstructorNewSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (objectConstructorNewDefaultImplementationConstructor != null) {
            return objectConstructorNewDefaultImplementationConstructor;
        }
        final String strCheckInstantiable = checkInstantiable(rawType);
        if (strCheckInstantiable != null) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.3
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    throw new JsonIOException(strCheckInstantiable);
                }
            };
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        final String str = "Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.4
            @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
            public T construct() {
                throw new JsonIOException(str);
            }
        };
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(final Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.5
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    Type type2 = type;
                    if (type2 instanceof ParameterizedType) {
                        Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                        if (type3 instanceof Class) {
                            return (T) EnumSet.noneOf((Class) type3);
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                    throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                }
            };
        }
        if (cls == EnumMap.class) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.6
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    Type type2 = type;
                    if (type2 instanceof ParameterizedType) {
                        Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                        if (type3 instanceof Class) {
                            return (T) new EnumMap((Class) type3);
                        }
                        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                }
            };
        }
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) throws NoSuchMethodException, SecurityException {
        final String strTryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (filterResult != ReflectionAccessFilter.FilterResult.ALLOW && (!ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) || (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                final String str = "Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
                return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.7
                    @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                    public T construct() {
                        throw new JsonIOException(str);
                    }
                };
            }
            if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW && (strTryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) != null) {
                return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.8
                    @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                    public T construct() {
                        throw new JsonIOException(strTryMakeAccessible);
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.9
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) declaredConstructor.newInstance(new Object[0]);
                    } catch (IllegalAccessException e) {
                        throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(declaredConstructor) + "' with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(declaredConstructor) + "' with no args", e3.getCause());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.10
                    @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.11
                    @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.12
                    @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.13
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ArrayList();
                }
            };
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.14
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentSkipListMap();
                }
            };
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.15
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentHashMap();
                }
            };
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.16
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new TreeMap();
                }
            };
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.17
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.18
            @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
            public T construct() {
                return (T) new LinkedTreeMap();
            }
        };
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.19
                @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) UnsafeAllocator.INSTANCE.newInstance(cls);
                    } catch (Exception e) {
                        throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
                    }
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        return new ObjectConstructor<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.ConstructorConstructor.20
            @Override // com.nimbusds.jose.shaded.gson.internal.ObjectConstructor
            public T construct() {
                throw new JsonIOException(str);
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
