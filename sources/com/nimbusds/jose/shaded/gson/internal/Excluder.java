package com.nimbusds.jose.shaded.gson.internal;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.nimbusds.jose.shaded.gson.ExclusionStrategy;
import com.nimbusds.jose.shaded.gson.FieldAttributes;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.TypeAdapter;
import com.nimbusds.jose.shaded.gson.TypeAdapterFactory;
import com.nimbusds.jose.shaded.gson.annotations.Expose;
import com.nimbusds.jose.shaded.gson.annotations.Since;
import com.nimbusds.jose.shaded.gson.annotations.Until;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import com.nimbusds.jose.shaded.gson.stream.JsonReader;
import com.nimbusds.jose.shaded.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = -1.0d;
    private int modifiers = ModuleDescriptor.MODULE_VERSION;
    private boolean serializeInnerClasses = true;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m5675clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder withVersion(double d) {
        Excluder excluderM5675clone = m5675clone();
        excluderM5675clone.version = d;
        return excluderM5675clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder excluderM5675clone = m5675clone();
        excluderM5675clone.modifiers = 0;
        for (int i : iArr) {
            excluderM5675clone.modifiers = i | excluderM5675clone.modifiers;
        }
        return excluderM5675clone;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluderM5675clone = m5675clone();
        excluderM5675clone.serializeInnerClasses = false;
        return excluderM5675clone;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluderM5675clone = m5675clone();
        excluderM5675clone.requireExpose = true;
        return excluderM5675clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder excluderM5675clone = m5675clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            excluderM5675clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            excluderM5675clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return excluderM5675clone;
    }

    @Override // com.nimbusds.jose.shaded.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zExcludeClassChecks = excludeClassChecks(rawType);
        final boolean z = zExcludeClassChecks || excludeClassInStrategy(rawType, true);
        final boolean z2 = zExcludeClassChecks || excludeClassInStrategy(rawType, false);
        if (z || z2) {
            return new TypeAdapter<T>() { // from class: com.nimbusds.jose.shaded.gson.internal.Excluder.1
                private TypeAdapter<T> delegate;

                @Override // com.nimbusds.jose.shaded.gson.TypeAdapter
                /* renamed from: read */
                public T read2(JsonReader jsonReader) throws IOException {
                    if (z2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    return delegate().read2(jsonReader);
                }

                @Override // com.nimbusds.jose.shaded.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    if (z) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, t);
                    }
                }

                private TypeAdapter<T> delegate() {
                    TypeAdapter<T> typeAdapter = this.delegate;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
            };
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != -1.0d && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrNonStaticLocal(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version != -1.0d && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (this.serializeInnerClasses || !isInnerClass(cls)) {
            return isAnonymousOrNonStaticLocal(cls);
        }
        return true;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        return excludeClassChecks(cls) || excludeClassInStrategy(cls, z);
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z) {
        Iterator<ExclusionStrategy> it = (z ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || isStatic(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(Since since) {
        if (since != null) {
            return this.version >= since.value();
        }
        return true;
    }

    private boolean isValidUntil(Until until) {
        if (until != null) {
            return this.version < until.value();
        }
        return true;
    }
}
