package com.nimbusds.jose.shaded.gson.internal.bind;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.TypeAdapter;
import com.nimbusds.jose.shaded.gson.TypeAdapterFactory;
import com.nimbusds.jose.shaded.gson.internal.C$Gson$Types;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import com.nimbusds.jose.shaded.gson.stream.JsonReader;
import com.nimbusds.jose.shaded.gson.stream.JsonToken;
import com.nimbusds.jose.shaded.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.nimbusds.jose.shaded.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.nimbusds.jose.shaded.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type arrayComponentType = C$Gson$Types.getArrayComponentType(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(arrayComponentType)), C$Gson$Types.getRawType(arrayComponentType));
        }
    };
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // com.nimbusds.jose.shaded.gson.TypeAdapter
    /* renamed from: read */
    public Object read2(JsonReader jsonReader) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read2(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        if (this.componentType.isPrimitive()) {
            Object objNewInstance = Array.newInstance((Class<?>) this.componentType, size);
            for (int i = 0; i < size; i++) {
                Array.set(objNewInstance, i, arrayList.get(i));
            }
            return objNewInstance;
        }
        return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.componentType, size));
    }

    @Override // com.nimbusds.jose.shaded.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}
