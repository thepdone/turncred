package com.facebook.react.views.switchview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidSwitchManagerDelegate;
import com.facebook.react.viewmanagers.AndroidSwitchManagerInterface;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

/* loaded from: classes3.dex */
public class ReactSwitchManager extends SimpleViewManager<ReactSwitch> implements AndroidSwitchManagerInterface<ReactSwitch> {
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener() { // from class: com.facebook.react.views.switchview.ReactSwitchManager.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ReactContext reactContext = (ReactContext) compoundButton.getContext();
            int id = compoundButton.getId();
            UIManagerHelper.getEventDispatcherForReactTag(reactContext, id).dispatchEvent(new ReactSwitchEvent(UIManagerHelper.getSurfaceId(reactContext), id, z));
        }
    };
    public static final String REACT_CLASS = "AndroidSwitch";
    private final ViewManagerDelegate<ReactSwitch> mDelegate = new AndroidSwitchManagerDelegate(this);

    static class ReactSwitchShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSwitchShadowNode() {
            initMeasureFunction();
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        @Override // com.facebook.yoga.YogaMeasureFunction
        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSwitch reactSwitch = new ReactSwitch(getThemedContext());
                reactSwitch.setShowText(false);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                reactSwitch.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                this.mWidth = reactSwitch.getMeasuredWidth();
                this.mHeight = reactSwitch.getMeasuredHeight();
                this.mMeasured = true;
            }
            return YogaMeasureOutput.make(this.mWidth, this.mHeight);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSwitchShadowNode();
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public Class getShadowNodeClass() {
        return ReactSwitchShadowNode.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactSwitch createViewInstance(ThemedReactContext themedReactContext) {
        ReactSwitch reactSwitch = new ReactSwitch(themedReactContext);
        reactSwitch.setShowText(false);
        return reactSwitch;
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(!z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(defaultBoolean = true, name = ViewProps.ENABLED)
    public void setEnabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(name = "on")
    public void setOn(ReactSwitch reactSwitch, boolean z) throws Resources.NotFoundException {
        setValueInternal(reactSwitch, z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(name = "value")
    public void setValue(ReactSwitch reactSwitch, boolean z) throws Resources.NotFoundException {
        setValueInternal(reactSwitch, z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSwitch reactSwitch, Integer num) {
        setThumbColor(reactSwitch, num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "thumbColor")
    public void setThumbColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setThumbColor(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "trackColorForFalse")
    public void setTrackColorForFalse(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColorForFalse(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "trackColorForTrue")
    public void setTrackColorForTrue(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColorForTrue(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    @ReactProp(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColor(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwitchManagerInterface
    public void setNativeValue(ReactSwitch reactSwitch, boolean z) throws Resources.NotFoundException {
        setValueInternal(reactSwitch, z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactSwitch reactSwitch, String str, ReadableArray readableArray) throws Resources.NotFoundException {
        str.hashCode();
        if (str.equals("setNativeValue")) {
            boolean z = false;
            if (readableArray != null && readableArray.getBoolean(0)) {
                z = true;
            }
            setValueInternal(reactSwitch, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSwitch reactSwitch) {
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ReactSwitch> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        ReactSwitch reactSwitch = new ReactSwitch(context);
        reactSwitch.setShowText(false);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        reactSwitch.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(reactSwitch.getMeasuredWidth()), PixelUtil.toDIPFromPixel(reactSwitch.getMeasuredHeight()));
    }

    private static void setValueInternal(ReactSwitch reactSwitch, boolean z) throws Resources.NotFoundException {
        reactSwitch.setOnCheckedChangeListener(null);
        reactSwitch.setOn(z);
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }
}
