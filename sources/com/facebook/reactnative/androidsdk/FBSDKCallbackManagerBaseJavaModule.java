package com.facebook.reactnative.androidsdk;

import com.facebook.CallbackManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/* loaded from: classes3.dex */
public abstract class FBSDKCallbackManagerBaseJavaModule extends ReactContextBaseJavaModule {
    private final FBActivityEventListener mActivityEventListener;

    protected CallbackManager getCallbackManager() {
        return this.mActivityEventListener.getCallbackManager();
    }

    protected FBSDKCallbackManagerBaseJavaModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext);
        this.mActivityEventListener = fBActivityEventListener;
        reactApplicationContext.addActivityEventListener(fBActivityEventListener);
    }
}
