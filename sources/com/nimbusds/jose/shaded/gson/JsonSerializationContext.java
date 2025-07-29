package com.nimbusds.jose.shaded.gson;

import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object obj);

    JsonElement serialize(Object obj, Type type);
}
