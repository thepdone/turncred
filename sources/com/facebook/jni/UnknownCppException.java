package com.facebook.jni;

import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes4.dex */
public class UnknownCppException extends CppException {
    public UnknownCppException() {
        super(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
    }

    public UnknownCppException(String str) {
        super(str);
    }
}
