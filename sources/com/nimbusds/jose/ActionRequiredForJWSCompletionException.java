package com.nimbusds.jose;

/* loaded from: classes5.dex */
public class ActionRequiredForJWSCompletionException extends JOSEException {
    private final CompletableJWSObjectSigning completableSigning;
    private final JWSSignerOption option;

    public ActionRequiredForJWSCompletionException(String str, JWSSignerOption jWSSignerOption, CompletableJWSObjectSigning completableJWSObjectSigning) {
        super(str);
        if (jWSSignerOption == null) {
            throw new IllegalArgumentException("The triggering option must not be null");
        }
        this.option = jWSSignerOption;
        if (completableJWSObjectSigning == null) {
            throw new IllegalArgumentException("The completable signing must not be null");
        }
        this.completableSigning = completableJWSObjectSigning;
    }

    public JWSSignerOption getTriggeringOption() {
        return this.option;
    }

    public CompletableJWSObjectSigning getCompletableJWSObjectSigning() {
        return this.completableSigning;
    }
}
