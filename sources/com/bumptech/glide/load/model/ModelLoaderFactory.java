package com.bumptech.glide.load.model;

/* loaded from: classes4.dex */
public interface ModelLoaderFactory<T, Y> {
    ModelLoader<T, Y> build(MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
