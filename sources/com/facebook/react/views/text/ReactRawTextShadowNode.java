package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

/* loaded from: classes3.dex */
public class ReactRawTextShadowNode extends ReactShadowNodeImpl {

    @VisibleForTesting
    public static final String PROP_TEXT = "text";
    private String mText = null;

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        markUpdated();
    }

    public String getText() {
        return this.mText;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public String toString() {
        return getViewClass() + " [text: " + this.mText + "]";
    }
}
