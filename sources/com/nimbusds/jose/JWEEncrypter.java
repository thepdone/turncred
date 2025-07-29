package com.nimbusds.jose;

/* loaded from: classes5.dex */
public interface JWEEncrypter extends JWEProvider {
    JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr, byte[] bArr2) throws JOSEException;
}
