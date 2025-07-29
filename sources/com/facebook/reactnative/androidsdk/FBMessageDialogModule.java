package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.MessageDialog;

@ReactModule(name = FBMessageDialogModule.NAME)
/* loaded from: classes3.dex */
public class FBMessageDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBMessageDialog";
    private boolean mShouldFailOnDataError;

    private class MessageDialogCallback extends ReactNativeFacebookSDKCallback<Sharer.Result> {
        public MessageDialogCallback(Promise promise) {
            super(promise);
        }

        @Override // com.facebook.FacebookCallback
        public void onSuccess(Sharer.Result result) {
            if (this.mPromise != null) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString(ShareConstants.RESULT_POST_ID, result.getPostId());
                this.mPromise.resolve(writableMapCreateMap);
                this.mPromise = null;
            }
        }
    }

    public FBMessageDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void canShow(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            promise.resolve(Boolean.valueOf(new MessageDialog(getCurrentActivity()).canShow((MessageDialog) Utility.buildShareContent(readableMap))));
        } else {
            promise.reject("No current activity.");
        }
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            ShareContent shareContentBuildShareContent = Utility.buildShareContent(readableMap);
            MessageDialog messageDialog = new MessageDialog(getCurrentActivity());
            messageDialog.setShouldFailOnDataError(this.mShouldFailOnDataError);
            messageDialog.registerCallback(getCallbackManager(), new MessageDialogCallback(promise));
            messageDialog.show(shareContentBuildShareContent);
            return;
        }
        promise.reject("No current activity.");
    }

    @ReactMethod
    public void setShouldFailOnDataError(boolean z) {
        this.mShouldFailOnDataError = z;
    }
}
