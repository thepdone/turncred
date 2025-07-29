package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareButton;

/* loaded from: classes3.dex */
public class FBShareButtonManager extends SimpleViewManager<ShareButton> {
    public static final String REACT_CLASS = "RCTFBShareButton";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ShareButton createViewInstance(ThemedReactContext themedReactContext) {
        return new ShareButton(themedReactContext);
    }

    @ReactProp(name = "shareContent")
    public void setShareContent(ShareButton shareButton, ReadableMap readableMap) {
        ShareContent shareContentBuildShareContent = Utility.buildShareContent(readableMap);
        if (shareContentBuildShareContent != null) {
            shareButton.setShareContent(shareContentBuildShareContent);
        }
    }
}
