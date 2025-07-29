package com.nimbusds.jose;

/* loaded from: classes5.dex */
public interface PayloadTransformer<T> {
    T transform(Payload payload);
}
