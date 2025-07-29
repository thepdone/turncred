package com.nimbusds.jose.crypto.opts;

import com.nimbusds.jose.JWSSignerOption;
import net.jcip.annotations.Immutable;

@Immutable
/* loaded from: classes5.dex */
public final class AllowWeakRSAKey implements JWSSignerOption {
    private static final AllowWeakRSAKey SINGLETON = new AllowWeakRSAKey();

    public static AllowWeakRSAKey getInstance() {
        return SINGLETON;
    }

    private AllowWeakRSAKey() {
    }

    public String toString() {
        return "AllowWeakRSAKey";
    }
}
