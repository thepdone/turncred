package com.nimbusds.jose;

/* loaded from: classes5.dex */
public class KeyLengthException extends KeyException {
    private final Algorithm alg;
    private final int expectedLength;

    public KeyLengthException(String str) {
        super(str);
        this.expectedLength = 0;
        this.alg = null;
    }

    public KeyLengthException(Algorithm algorithm) {
        this(0, algorithm);
    }

    public KeyLengthException(int i, Algorithm algorithm) {
        super((i > 0 ? "The expected key length is " + i + " bits" : "Unexpected key length") + (algorithm != null ? " (for " + algorithm + " algorithm)" : ""));
        this.expectedLength = i;
        this.alg = algorithm;
    }

    public int getExpectedKeyLength() {
        return this.expectedLength;
    }

    public Algorithm getAlgorithm() {
        return this.alg;
    }
}
