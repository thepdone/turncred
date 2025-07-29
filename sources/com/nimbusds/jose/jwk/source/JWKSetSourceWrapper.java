package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.proc.SecurityContext;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes5.dex */
public abstract class JWKSetSourceWrapper<C extends SecurityContext> implements JWKSetSource<C> {
    private final JWKSetSource<C> source;

    public JWKSetSourceWrapper(JWKSetSource<C> jWKSetSource) {
        Objects.requireNonNull(jWKSetSource);
        this.source = jWKSetSource;
    }

    public JWKSetSource<C> getSource() {
        return this.source;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }
}
