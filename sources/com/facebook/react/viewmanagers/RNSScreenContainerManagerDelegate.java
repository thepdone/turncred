package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSScreenContainerManagerInterface;

/* loaded from: classes4.dex */
public class RNSScreenContainerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSScreenContainerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSScreenContainerManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        super.setProperty(t, str, obj);
    }
}
