package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGFeColorMatrixManagerInterface;

/* loaded from: classes4.dex */
public class RNSVGFeColorMatrixManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGFeColorMatrixManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGFeColorMatrixManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
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
            case -823812830:
                if (str.equals("values")) {
                    c = 2;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c = 3;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c = 4;
                    break;
                }
                break;
            case 104364:
                if (str.equals("in1")) {
                    c = 5;
                    break;
                }
                break;
            case 3575610:
                if (str.equals("type")) {
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
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setResult(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setValues(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 5:
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setIn1(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setType(t, (String) obj);
                break;
            case 7:
                ((RNSVGFeColorMatrixManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
