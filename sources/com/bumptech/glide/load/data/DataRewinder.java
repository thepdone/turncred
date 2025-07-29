package com.bumptech.glide.load.data;

import java.io.IOException;

/* loaded from: classes4.dex */
public interface DataRewinder<T> {

    public interface Factory<T> {
        DataRewinder<T> build(T t);

        Class<T> getDataClass();
    }

    void cleanup();

    T rewindAndGet() throws IOException;
}
