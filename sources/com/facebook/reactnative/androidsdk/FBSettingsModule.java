package com.facebook.reactnative.androidsdk;

import com.facebook.FacebookSdk;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = FBSettingsModule.NAME)
/* loaded from: classes3.dex */
public class FBSettingsModule extends BaseJavaModule {
    public static final String NAME = "FBSettings";

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setDataProcessingOptions(ReadableArray readableArray, int i, int i2) {
        FacebookSdk.setDataProcessingOptions((String[]) Utility.reactArrayToStringList(readableArray).toArray(new String[0]), i, i2);
    }

    @ReactMethod
    public void initializeSDK() {
        FacebookSdk.fullyInitialize();
    }

    @ReactMethod
    public void setAppID(String str) {
        FacebookSdk.setApplicationId(str);
    }

    @ReactMethod
    public void setClientToken(String str) {
        FacebookSdk.setClientToken(str);
    }

    @ReactMethod
    public void setAppName(String str) {
        FacebookSdk.setApplicationName(str);
    }

    @ReactMethod
    public void setGraphAPIVersion(String str) {
        FacebookSdk.setGraphApiVersion(str);
    }

    @ReactMethod
    public void setAutoLogAppEventsEnabled(Boolean bool) {
        FacebookSdk.setAutoLogAppEventsEnabled(bool.booleanValue());
    }

    @ReactMethod
    public void setAdvertiserIDCollectionEnabled(Boolean bool) {
        FacebookSdk.setAdvertiserIDCollectionEnabled(bool.booleanValue());
    }
}
