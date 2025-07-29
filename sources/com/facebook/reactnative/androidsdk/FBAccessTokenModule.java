package com.facebook.reactnative.androidsdk;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = FBAccessTokenModule.NAME)
/* loaded from: classes3.dex */
public class FBAccessTokenModule extends ReactContextBaseJavaModule {
    public static final String CHANGE_EVENT_NAME = "fbsdk.accessTokenDidChange";
    public static final String NAME = "FBAccessToken";
    private AccessTokenTracker accessTokenTracker;
    private final ReactApplicationContext mReactContext;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public FBAccessTokenModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        this.accessTokenTracker = new AccessTokenTracker() { // from class: com.facebook.reactnative.androidsdk.FBAccessTokenModule.1
            @Override // com.facebook.AccessTokenTracker
            protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                try {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) FBAccessTokenModule.this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(FBAccessTokenModule.CHANGE_EVENT_NAME, accessToken2 == null ? null : Utility.accessTokenToReactMap(accessToken2));
                } catch (RuntimeException unused) {
                }
            }
        };
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        AccessTokenTracker accessTokenTracker = this.accessTokenTracker;
        if (accessTokenTracker != null) {
            accessTokenTracker.stopTracking();
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        AccessTokenTracker accessTokenTracker = this.accessTokenTracker;
        if (accessTokenTracker != null) {
            accessTokenTracker.stopTracking();
        }
    }

    @ReactMethod
    public void getCurrentAccessToken(Callback callback) {
        callback.invoke(AccessToken.getCurrentAccessToken() == null ? null : Utility.accessTokenToReactMap(AccessToken.getCurrentAccessToken()));
    }

    @ReactMethod
    public void setCurrentAccessToken(ReadableMap readableMap) {
        AccessToken.setCurrentAccessToken(Utility.buildAccessToken(readableMap));
    }

    @ReactMethod
    public void refreshCurrentAccessTokenAsync(final Promise promise) {
        AccessToken.refreshCurrentAccessTokenAsync(new AccessToken.AccessTokenRefreshCallback() { // from class: com.facebook.reactnative.androidsdk.FBAccessTokenModule.2
            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshed(AccessToken accessToken) {
                promise.resolve(Utility.accessTokenToReactMap(accessToken));
            }

            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshFailed(FacebookException facebookException) {
                promise.reject(facebookException);
            }
        });
    }
}
