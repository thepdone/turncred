package com.nimbusds.jwt.proc;

import com.nimbusds.jose.proc.BadJOSEException;

/* loaded from: classes5.dex */
public class BadJWTException extends BadJOSEException {
    public BadJWTException(String str) {
        super(str);
    }

    public BadJWTException(String str, Throwable th) {
        super(str, th);
    }
}
