package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeBlendManagerInterface;

/* loaded from: classes4.dex */
public class RNSVGFeBlendManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGFeBlendManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeBlendManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1221029593:
                if (str.equals("height")) {
                    c = 0;
                    break;
                }
                break;
            case -934426595:
                if (str.equals("result")) {
                    c = 1;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c = 2;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c = 3;
                    break;
                }
                break;
            case 104364:
                if (str.equals("in1")) {
                    c = 4;
                    break;
                }
                break;
            case 104365:
                if (str.equals("in2")) {
                    c = 5;
                    break;
                }
                break;
            case 3357091:
                if (str.equals("mode")) {
                    c = 6;
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setResult(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setIn1(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setIn2(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setMode(t, (String) obj);
                break;
            case 7:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
