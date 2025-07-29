package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.SendButton;

/* loaded from: classes3.dex */
public class FBSendButtonManager extends SimpleViewManager<SendButton> {
    public static final String REACT_CLASS = "RCTFBSendButton";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public SendButton createViewInstance(ThemedReactContext themedReactContext) {
        return new SendButton(themedReactContext);
    }

    @ReactProp(name = "shareContent")
    public void setShareContent(SendButton sendButton, ReadableMap readableMap) {
        ShareContent shareContentBuildShareContent = Utility.buildShareContent(readableMap);
        if (shareContentBuildShareContent != null) {
            sendButton.setShareContent(shareContentBuildShareContent);
        }
    }
}
