package com.facebook.reactnative.androidsdk;

import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Locale;

/* loaded from: classes3.dex */
public class FBLoginButtonManager extends SimpleViewManager<RCTLoginButton> {
    public static final String REACT_CLASS = "RCTFBLoginButton";
    private final FBActivityEventListener mActivityEventListener;

    public FBLoginButtonManager(ReactApplicationContext reactApplicationContext) {
        FBActivityEventListener fBActivityEventListener = new FBActivityEventListener();
        this.mActivityEventListener = fBActivityEventListener;
        reactApplicationContext.addActivityEventListener(fBActivityEventListener);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RCTLoginButton createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTLoginButton(themedReactContext, this.mActivityEventListener.getCallbackManager());
    }

    @ReactProp(name = "loginBehaviorAndroid")
    public void setLoginBehavior(RCTLoginButton rCTLoginButton, String str) {
        LoginBehavior loginBehaviorValueOf = LoginBehavior.NATIVE_WITH_FALLBACK;
        if (str != null) {
            loginBehaviorValueOf = LoginBehavior.valueOf(str.toUpperCase(Locale.ROOT));
        }
        rCTLoginButton.setLoginBehavior(loginBehaviorValueOf);
    }

    @ReactProp(name = "defaultAudience")
    public void setDefaultAudience(RCTLoginButton rCTLoginButton, String str) {
        DefaultAudience defaultAudienceValueOf = DefaultAudience.FRIENDS;
        if (str != null) {
            defaultAudienceValueOf = DefaultAudience.valueOf(str.toUpperCase(Locale.ROOT));
        }
        rCTLoginButton.setDefaultAudience(defaultAudienceValueOf);
    }

    @ReactProp(name = "permissions")
    public void setPermissions(RCTLoginButton rCTLoginButton, ReadableArray readableArray) {
        rCTLoginButton.setPermissions(Utility.reactArrayToStringList(readableArray));
    }
}
