package com.nimbusds.jose.crypto.opts;

import com.nimbusds.jose.JWSSignerOption;
import net.jcip.annotations.Immutable;

@Immutable
/* loaded from: classes5.dex */
public final class UserAuthenticationRequired implements JWSSignerOption {
    private static final UserAuthenticationRequired SINGLETON = new UserAuthenticationRequired();

    public static UserAuthenticationRequired getInstance() {
        return SINGLETON;
    }

    private UserAuthenticationRequired() {
    }

    public String toString() {
        return "UserAuthenticationRequired";
    }
}
