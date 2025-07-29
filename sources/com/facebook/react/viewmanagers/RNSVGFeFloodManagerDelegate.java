package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeFloodManagerInterface;

/* loaded from: classes4.dex */
public class RNSVGFeFloodManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGFeFloodManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeFloodManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "floodColor":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setFloodColor(t, new DynamicFromObject(obj));
                break;
            case "height":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case "floodOpacity":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setFloodOpacity(t, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case "result":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setResult(t, obj == null ? null : (String) obj);
                break;
            case "x":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case "width":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
