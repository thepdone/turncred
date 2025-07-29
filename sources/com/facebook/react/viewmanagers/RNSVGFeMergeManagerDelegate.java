package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeMergeManagerInterface;

/* loaded from: classes4.dex */
public class RNSVGFeMergeManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGFeMergeManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeMergeManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "height":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setResult(t, obj == null ? null : (String) obj);
                break;
            case "x":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case "nodes":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setNodes(t, (ReadableArray) obj);
                break;
            case "width":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
