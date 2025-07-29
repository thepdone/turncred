package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFilterManagerInterface;

/* loaded from: classes4.dex */
public class RNSVGFilterManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGFilterManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFilterManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "primitiveUnits":
                ((RNSVGFilterManagerInterface) this.mViewManager).setPrimitiveUnits(t, (String) obj);
                break;
            case "height":
                ((RNSVGFilterManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case "filterUnits":
                ((RNSVGFilterManagerInterface) this.mViewManager).setFilterUnits(t, (String) obj);
                break;
            case "x":
                ((RNSVGFilterManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFilterManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case "name":
                ((RNSVGFilterManagerInterface) this.mViewManager).setName(t, obj == null ? null : (String) obj);
                break;
            case "width":
                ((RNSVGFilterManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
