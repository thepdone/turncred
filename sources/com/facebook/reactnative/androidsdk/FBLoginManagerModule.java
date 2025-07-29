package com.facebook.reactnative.androidsdk;

import android.app.Activity;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

@ReactModule(name = FBLoginManagerModule.NAME)
/* loaded from: classes3.dex */
public class FBLoginManagerModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBLoginManager";

    private class LoginManagerCallback extends ReactNativeFacebookSDKCallback<LoginResult> {
        public LoginManagerCallback(Promise promise) {
            super(promise);
        }

        @Override // com.facebook.FacebookCallback
        public void onSuccess(LoginResult loginResult) {
            if (this.mPromise != null) {
                AccessToken.setCurrentAccessToken(loginResult.getAccessToken());
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putBoolean("isCancelled", false);
                writableMapCreateMap.putArray("grantedPermissions", FBLoginManagerModule.this.setToWritableArray(loginResult.getRecentlyGrantedPermissions()));
                writableMapCreateMap.putArray(SDKConstants.PARAM_DECLINED_PERMISSIONS, FBLoginManagerModule.this.setToWritableArray(loginResult.getRecentlyDeniedPermissions()));
                this.mPromise.resolve(writableMapCreateMap);
                this.mPromise = null;
            }
        }
    }

    public FBLoginManagerModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getLoginBehavior(Promise promise) {
        promise.resolve(LoginManager.getInstance().getLoginBehavior().name().toLowerCase(Locale.ROOT));
    }

    @ReactMethod
    public void setLoginBehavior(String str) {
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.valueOf(str.toUpperCase(Locale.ROOT)));
    }

    @ReactMethod
    public void getDefaultAudience(Promise promise) {
        promise.resolve(LoginManager.getInstance().getDefaultAudience().name().toLowerCase(Locale.ROOT));
    }

    @ReactMethod
    public void setDefaultAudience(String str) {
        LoginManager.getInstance().setDefaultAudience(DefaultAudience.valueOf(str.toUpperCase(Locale.ROOT)));
    }

    @ReactMethod
    public void logOut() {
        LoginManager.getInstance().logOut();
    }

    @ReactMethod
    public void logInWithPermissions(ReadableArray readableArray, Promise promise) throws FacebookException, NoSuchAlgorithmException {
        LoginManager loginManager = LoginManager.getInstance();
        loginManager.registerCallback(getCallbackManager(), new LoginManagerCallback(promise));
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            loginManager.logIn(currentActivity, Utility.reactArrayToStringList(readableArray));
        }
    }

    @ReactMethod
    public void reauthorizeDataAccess(Promise promise) throws FacebookException {
        LoginManager loginManager = LoginManager.getInstance();
        loginManager.registerCallback(getCallbackManager(), new LoginManagerCallback(promise));
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            loginManager.reauthorizeDataAccess(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableArray setToWritableArray(Set<String> set) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString(it.next());
        }
        return writableArrayCreateArray;
    }
}
