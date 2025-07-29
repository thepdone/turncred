package com.facebook.reactnative.androidsdk;

import com.facebook.gamingservices.GameRequestDialog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.model.GameRequestContent;

@ReactModule(name = FBGameRequestDialogModule.NAME)
/* loaded from: classes3.dex */
public class FBGameRequestDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBGameRequestDialog";

    private class GameRequestDialogCallback extends ReactNativeFacebookSDKCallback<GameRequestDialog.Result> {
        public GameRequestDialogCallback(Promise promise) {
            super(promise);
        }

        @Override // com.facebook.FacebookCallback
        public void onSuccess(GameRequestDialog.Result result) {
            if (this.mPromise != null) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("requestId", result.getRequestId());
                writableMapCreateMap.putArray("to", Utility.listToReactArray(result.getRequestRecipients()));
                this.mPromise.resolve(writableMapCreateMap);
                this.mPromise = null;
            }
        }
    }

    public FBGameRequestDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void canShow(Promise promise) {
        promise.resolve(Boolean.valueOf(GameRequestDialog.canShow()));
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            GameRequestDialog gameRequestDialog = new GameRequestDialog(getCurrentActivity());
            GameRequestContent gameRequestContentBuildGameRequestContent = Utility.buildGameRequestContent(readableMap);
            gameRequestDialog.registerCallback(getCallbackManager(), new GameRequestDialogCallback(promise));
            gameRequestDialog.show(gameRequestContentBuildGameRequestContent);
            return;
        }
        promise.reject("No current activity.");
    }
}
