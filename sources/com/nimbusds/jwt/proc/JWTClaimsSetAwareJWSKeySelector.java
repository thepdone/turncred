package com.nimbusds.jwt.proc;

import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import java.security.Key;
import java.util.List;

/* loaded from: classes5.dex */
public interface JWTClaimsSetAwareJWSKeySelector<C extends SecurityContext> {
    List<? extends Key> selectKeys(JWSHeader jWSHeader, JWTClaimsSet jWTClaimsSet, C c) throws KeySourceException;
}
