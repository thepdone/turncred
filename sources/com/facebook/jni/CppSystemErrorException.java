package com.facebook.jni;

/* loaded from: classes4.dex */
public class CppSystemErrorException extends CppException {
    int errorCode;

    public CppSystemErrorException(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
