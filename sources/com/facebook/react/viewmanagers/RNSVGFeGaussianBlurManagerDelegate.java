package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeGaussianBlurManagerInterface;

/* loaded from: classes4.dex */
public class RNSVGFeGaussianBlurManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGFeGaussianBlurManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeGaussianBlurManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
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
            case 113126854:
                if (str.equals("width")) {
                    c = 5;
                    break;
                }
                break;
            case 1530721536:
                if (str.equals("edgeMode")) {
                    c = 6;
                    break;
                }
                break;
            case 1837475450:
                if (str.equals("stdDeviationX")) {
                    c = 7;
                    break;
                }
                break;
            case 1837475451:
                if (str.equals("stdDeviationY")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setResult(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setIn1(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 6:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setEdgeMode(t, (String) obj);
                break;
            case 7:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setStdDeviationX(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case '\b':
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setStdDeviationY(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
