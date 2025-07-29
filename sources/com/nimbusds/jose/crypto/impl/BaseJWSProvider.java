package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSProvider;
import com.nimbusds.jose.jca.JCAContext;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes5.dex */
public abstract class BaseJWSProvider implements JWSProvider {
    private final Set<JWSAlgorithm> algs;
    private final JCAContext jcaContext = new JCAContext();

    public BaseJWSProvider(Set<JWSAlgorithm> set) {
        if (set == null) {
            throw new IllegalArgumentException("The supported JWS algorithm set must not be null");
        }
        this.algs = Collections.unmodifiableSet(set);
    }

    @Override // com.nimbusds.jose.JWSProvider
    public Set<JWSAlgorithm> supportedJWSAlgorithms() {
        return this.algs;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JCAContext getJCAContext() {
        return this.jcaContext;
    }
}
