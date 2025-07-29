package com.facebook.react.bridge;

/* loaded from: classes4.dex */
public final class CallbackImpl implements Callback {
    private final int mCallbackId;
    private boolean mInvoked = false;
    private final JSInstance mJSInstance;

    public CallbackImpl(JSInstance jSInstance, int i) {
        this.mJSInstance = jSInstance;
        this.mCallbackId = i;
    }

    @Override // com.facebook.react.bridge.Callback
    public void invoke(Object... objArr) {
        if (this.mInvoked) {
            throw new RuntimeException("Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
        }
        this.mJSInstance.invokeCallback(this.mCallbackId, Arguments.fromJavaArgs(objArr));
        this.mInvoked = true;
    }
}
