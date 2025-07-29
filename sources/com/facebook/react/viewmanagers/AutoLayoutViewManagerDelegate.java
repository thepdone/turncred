package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.camera.video.AudioStats;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.AutoLayoutViewManagerInterface;

/* loaded from: classes4.dex */
public class AutoLayoutViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & AutoLayoutViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public AutoLayoutViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1742339391:
                if (str.equals("disableAutoLayout")) {
                    c = 0;
                    break;
                }
                break;
            case -1735873685:
                if (str.equals("enableInstrumentation")) {
                    c = 1;
                    break;
                }
                break;
            case -866440768:
                if (str.equals("scrollOffset")) {
                    c = 2;
                    break;
                }
                break;
            case 1387629604:
                if (str.equals("horizontal")) {
                    c = 3;
                    break;
                }
                break;
            case 1705877054:
                if (str.equals("renderAheadOffset")) {
                    c = 4;
                    break;
                }
                break;
            case 1862514705:
                if (str.equals("windowSize")) {
                    c = 5;
                    break;
                }
                break;
        }
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        switch (c) {
            case 0:
                ((AutoLayoutViewManagerInterface) ((BaseViewManager) this.mViewManager)).setDisableAutoLayout(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((AutoLayoutViewManagerInterface) ((BaseViewManager) this.mViewManager)).setEnableInstrumentation(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 2:
                AutoLayoutViewManagerInterface autoLayoutViewManagerInterface = (AutoLayoutViewManagerInterface) ((BaseViewManager) this.mViewManager);
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                autoLayoutViewManagerInterface.setScrollOffset(t, dDoubleValue);
                break;
            case 3:
                ((AutoLayoutViewManagerInterface) ((BaseViewManager) this.mViewManager)).setHorizontal(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                AutoLayoutViewManagerInterface autoLayoutViewManagerInterface2 = (AutoLayoutViewManagerInterface) ((BaseViewManager) this.mViewManager);
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                autoLayoutViewManagerInterface2.setRenderAheadOffset(t, dDoubleValue);
                break;
            case 5:
                AutoLayoutViewManagerInterface autoLayoutViewManagerInterface3 = (AutoLayoutViewManagerInterface) ((BaseViewManager) this.mViewManager);
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                autoLayoutViewManagerInterface3.setWindowSize(t, dDoubleValue);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
