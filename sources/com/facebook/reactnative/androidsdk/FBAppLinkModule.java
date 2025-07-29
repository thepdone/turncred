package com.facebook.reactnative.androidsdk;

import com.facebook.applinks.AppLinkData;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = FBAppLinkModule.NAME)
/* loaded from: classes3.dex */
public class FBAppLinkModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBAppLink";
    private final ReactApplicationContext mReactContext;

    public FBAppLinkModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private AppLinkData.CompletionHandler createCompletionHandler(final Promise promise) {
        return new AppLinkData.CompletionHandler() { // from class: com.facebook.reactnative.androidsdk.FBAppLinkModule.1
            @Override // com.facebook.applinks.AppLinkData.CompletionHandler
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                if (appLinkData == null) {
                    promise.resolve(null);
                } else {
                    promise.resolve(appLinkData.getTargetUri().toString());
                }
            }
        };
    }

    @ReactMethod
    public void fetchDeferredAppLink(Promise promise) {
        try {
            AppLinkData.fetchDeferredAppLinkData(this.mReactContext.getApplicationContext(), createCompletionHandler(promise));
        } catch (Exception e) {
            promise.resolve(null);
            com.facebook.internal.Utility.logd(getName(), "Received error while fetching deferred app link", e);
        }
    }
}
