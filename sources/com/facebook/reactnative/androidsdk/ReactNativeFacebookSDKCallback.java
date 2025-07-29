package com.facebook.reactnative.androidsdk;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes3.dex */
public abstract class ReactNativeFacebookSDKCallback<RESULT> implements FacebookCallback<RESULT> {
    Promise mPromise;

    public ReactNativeFacebookSDKCallback(Promise promise) {
        this.mPromise = promise;
    }

    @Override // com.facebook.FacebookCallback
    public void onCancel() {
        if (this.mPromise != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putBoolean("isCancelled", true);
            this.mPromise.resolve(writableMapCreateMap);
            this.mPromise = null;
        }
    }

    @Override // com.facebook.FacebookCallback
    public void onError(FacebookException facebookException) {
        Promise promise = this.mPromise;
        if (promise != null) {
            promise.reject(facebookException);
            this.mPromise = null;
        }
    }
}
