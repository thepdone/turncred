package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.ECDH;
import com.nimbusds.jose.crypto.impl.ECDHCryptoProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes5.dex */
public class ECDHEncrypter extends ECDHCryptoProvider implements JWEEncrypter {
    public static final Set<Curve> SUPPORTED_ELLIPTIC_CURVES;
    private final ECPublicKey publicKey;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Curve.P_256);
        linkedHashSet.add(Curve.P_384);
        linkedHashSet.add(Curve.P_521);
        SUPPORTED_ELLIPTIC_CURVES = Collections.unmodifiableSet(linkedHashSet);
    }

    public ECDHEncrypter(ECPublicKey eCPublicKey) throws JOSEException {
        this(eCPublicKey, null);
    }

    public ECDHEncrypter(ECKey eCKey) throws JOSEException {
        this(eCKey.toECPublicKey(), null);
    }

    public ECDHEncrypter(ECPublicKey eCPublicKey, SecretKey secretKey) throws JOSEException {
        super(Curve.forECParameterSpec(eCPublicKey.getParams()), secretKey);
        this.publicKey = eCPublicKey;
    }

    public ECPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.nimbusds.jose.crypto.impl.ECDHCryptoProvider
    public Set<Curve> supportedEllipticCurves() {
        return SUPPORTED_ELLIPTIC_CURVES;
    }

    @Deprecated
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        return encrypt(jWEHeader, bArr, AAD.compute(jWEHeader));
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr, byte[] bArr2) throws IllegalStateException, NoSuchAlgorithmException, JOSEException, InvalidKeyException, InvalidAlgorithmParameterException {
        KeyPair keyPairGenerateEphemeralKeyPair = generateEphemeralKeyPair(this.publicKey.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateEphemeralKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateEphemeralKeyPair.getPrivate();
        JWEHeader jWEHeaderBuild = new JWEHeader.Builder(jWEHeader).ephemeralPublicKey(new ECKey.Builder(getCurve(), eCPublicKey).build()).build();
        SecretKey secretKeyDeriveSharedSecret = ECDH.deriveSharedSecret(this.publicKey, eCPrivateKey, getJCAContext().getKeyEncryptionProvider());
        if (Arrays.equals(AAD.compute(jWEHeader), bArr2)) {
            bArr2 = AAD.compute(jWEHeaderBuild);
        }
        return encryptWithZ(jWEHeaderBuild, secretKeyDeriveSharedSecret, bArr, bArr2);
    }

    private KeyPair generateEphemeralKeyPair(ECParameterSpec eCParameterSpec) throws NoSuchAlgorithmException, JOSEException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator;
        Provider keyEncryptionProvider = getJCAContext().getKeyEncryptionProvider();
        try {
            if (keyEncryptionProvider != null) {
                keyPairGenerator = KeyPairGenerator.getInstance("EC", keyEncryptionProvider);
            } else {
                keyPairGenerator = KeyPairGenerator.getInstance("EC");
            }
            keyPairGenerator.initialize(eCParameterSpec);
            return keyPairGenerator.generateKeyPair();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e) {
            throw new JOSEException("Couldn't generate ephemeral EC key pair: " + e.getMessage(), e);
        }
    }
}
