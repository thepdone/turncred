package com.nimbusds.jose.util;

import javax.crypto.SecretKey;

/* loaded from: classes5.dex */
public class KeyUtils {
    public static SecretKey toAESKey(final SecretKey secretKey) {
        return (secretKey == null || secretKey.getAlgorithm().equals("AES")) ? secretKey : new SecretKey() { // from class: com.nimbusds.jose.util.KeyUtils.1
            @Override // java.security.Key
            public String getAlgorithm() {
                return "AES";
            }

            @Override // java.security.Key
            public String getFormat() {
                return secretKey.getFormat();
            }

            @Override // java.security.Key
            public byte[] getEncoded() {
                return secretKey.getEncoded();
            }
        };
    }

    private KeyUtils() {
    }
}
