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
import com.facebook.share.widget.ShareDialog;
import java.util.Locale;

@ReactModule(name = FBShareDialogModule.NAME)
/* loaded from: classes3.dex */
public class FBShareDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBShareDialog";
    private ShareDialog.Mode mShareDialogMode;
    private boolean mShouldFailOnError;

    private class ShareDialogCallback extends ReactNativeFacebookSDKCallback<Sharer.Result> {
        public ShareDialogCallback(Promise promise) {
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

    public FBShareDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void canShow(ReadableMap readableMap, Promise promise) {
        boolean zCanShow;
        if (getCurrentActivity() != null) {
            ShareDialog shareDialog = new ShareDialog(getCurrentActivity());
            if (this.mShareDialogMode == null) {
                zCanShow = shareDialog.canShow((ShareDialog) Utility.buildShareContent(readableMap));
            } else {
                zCanShow = shareDialog.canShow(Utility.buildShareContent(readableMap), this.mShareDialogMode);
            }
            promise.resolve(Boolean.valueOf(zCanShow));
            return;
        }
        promise.reject("No current activity.");
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            ShareDialog shareDialog = new ShareDialog(getCurrentActivity());
            shareDialog.registerCallback(getCallbackManager(), new ShareDialogCallback(promise));
            shareDialog.setShouldFailOnDataError(this.mShouldFailOnError);
            if (this.mShareDialogMode != null) {
                shareDialog.show(Utility.buildShareContent(readableMap), this.mShareDialogMode);
                return;
            } else {
                shareDialog.show(Utility.buildShareContent(readableMap));
                return;
            }
        }
        promise.reject("No current activity.");
    }

    @ReactMethod
    public void setMode(String str) {
        this.mShareDialogMode = ShareDialog.Mode.valueOf(str.toUpperCase(Locale.ROOT));
    }

    @ReactMethod
    public void setShouldFailOnError(boolean z) {
        this.mShouldFailOnError = z;
    }
}
