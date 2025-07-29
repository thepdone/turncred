package com.swmansion.rnscreens;

import android.util.Log;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.events.HeaderAttachedEvent;
import com.swmansion.rnscreens.events.HeaderDetachedEvent;
import java.util.Map;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenStackHeaderConfigViewManager.kt */
@ReactModule(name = ScreenStackHeaderConfigViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001XB\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0012\u0010\"\u001a\u00020\b2\b\b\u0001\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010&\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020 H\u0017J\u001c\u0010+\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010,\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010-\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\rH\u0016J\u001a\u0010.\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020 H\u0016J\u001f\u0010/\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0002\u00101J\u001c\u00102\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0016J\u001f\u00103\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0002\u00101J\u001a\u00105\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u001aH\u0017J\u001a\u00107\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020 H\u0016J\u0018\u00108\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u00109\u001a\u00020 H\u0017J\u0018\u0010:\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010;\u001a\u00020 H\u0017J\u0018\u0010<\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010=\u001a\u00020 H\u0017J\u001a\u0010>\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020 H\u0016J!\u0010?\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u00101J!\u0010@\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u00101J\u001c\u0010A\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010B\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\rH\u0016J\u001c\u0010C\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010D\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020 H\u0016J\u001a\u0010E\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\b\u0010F\u001a\u0004\u0018\u00010\u001aH\u0017J\u001f\u0010G\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0002\u00101J\u001a\u0010I\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\b\u0010J\u001a\u0004\u0018\u00010\u001aH\u0017J\u0018\u0010K\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\rH\u0017J\u001a\u0010M\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\b\u0010N\u001a\u0004\u0018\u00010\u001aH\u0017J\u0018\u0010O\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010P\u001a\u00020 H\u0017J\u0018\u0010Q\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010R\u001a\u00020 H\u0017J&\u0010S\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\u00022\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfigViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "Lcom/facebook/react/viewmanagers/RNSScreenStackHeaderConfigManagerInterface;", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "addView", "", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "createShadowNodeInstance", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "getChildCount", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "logNotAvailable", "propName", "needsCustomLayoutForChildren", "", "onAfterUpdateTransaction", "onDropViewInstance", ViewHierarchyConstants.VIEW_KEY, "removeAllViews", "removeViewAt", "setBackButtonDisplayMode", "value", "setBackButtonInCustomView", "config", "backButtonInCustomView", "setBackTitle", "setBackTitleFontFamily", "setBackTitleFontSize", "setBackTitleVisible", "setBackgroundColor", ViewProps.BACKGROUND_COLOR, "(Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;Ljava/lang/Integer;)V", "setBlurEffect", "setColor", ViewProps.COLOR, "setDirection", "direction", "setDisableBackButtonMenu", "setHidden", ViewProps.HIDDEN, "setHideBackButton", "hideBackButton", "setHideShadow", "hideShadow", "setLargeTitle", "setLargeTitleBackgroundColor", "setLargeTitleColor", "setLargeTitleFontFamily", "setLargeTitleFontSize", "setLargeTitleFontWeight", "setLargeTitleHideShadow", "setTitle", "title", "setTitleColor", "titleColor", "setTitleFontFamily", "titleFontFamily", "setTitleFontSize", "titleFontSize", "setTitleFontWeight", "titleFontWeight", "setTopInsetEnabled", "topInsetEnabled", "setTranslucent", "translucent", "updateState", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenStackHeaderConfigViewManager extends ViewGroupManager<ScreenStackHeaderConfig> implements RNSScreenStackHeaderConfigManagerInterface<ScreenStackHeaderConfig> {
    public static final String REACT_CLASS = "RNSScreenStackHeaderConfig";
    private final ViewManagerDelegate<ScreenStackHeaderConfig> delegate = new RNSScreenStackHeaderConfigManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenStackHeaderConfig createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenStackHeaderConfig(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreenStackHeaderConfigShadowNode(context);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(ScreenStackHeaderConfig parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof ScreenStackHeaderSubview)) {
            throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
        }
        parent.addConfigSubview((ScreenStackHeaderSubview) child, index);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ScreenStackHeaderConfig view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        return super.updateState((ScreenStackHeaderConfigViewManager) view, props, stateWrapper);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@Nonnull ScreenStackHeaderConfig view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.destroy();
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(ScreenStackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeAllConfigSubviews();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(ScreenStackHeaderConfig parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeConfigSubview(index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(ScreenStackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubviewsCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(ScreenStackHeaderConfig parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubview(index);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ScreenStackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        super.onAfterUpdateTransaction((ScreenStackHeaderConfigViewManager) parent);
        parent.onUpdate();
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "title")
    public void setTitle(ScreenStackHeaderConfig config, String title) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitle(title);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "titleFontFamily")
    public void setTitleFontFamily(ScreenStackHeaderConfig config, String titleFontFamily) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitleFontFamily(titleFontFamily);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "titleFontSize")
    public void setTitleFontSize(ScreenStackHeaderConfig config, int titleFontSize) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitleFontSize(titleFontSize);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "titleFontWeight")
    public void setTitleFontWeight(ScreenStackHeaderConfig config, String titleFontWeight) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTitleFontWeight(titleFontWeight);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(customType = "Color", name = "titleColor")
    public void setTitleColor(ScreenStackHeaderConfig config, Integer titleColor) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (titleColor != null) {
            config.setTitleColor(titleColor.intValue());
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(customType = "Color", name = ViewProps.BACKGROUND_COLOR)
    public void setBackgroundColor(ScreenStackHeaderConfig config, Integer backgroundColor) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setBackgroundColor(backgroundColor);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "hideShadow")
    public void setHideShadow(ScreenStackHeaderConfig config, boolean hideShadow) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setHideShadow(hideShadow);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "hideBackButton")
    public void setHideBackButton(ScreenStackHeaderConfig config, boolean hideBackButton) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setHideBackButton(hideBackButton);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "topInsetEnabled")
    public void setTopInsetEnabled(ScreenStackHeaderConfig config, boolean topInsetEnabled) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTopInsetEnabled(topInsetEnabled);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(customType = "Color", name = ViewProps.COLOR)
    public void setColor(ScreenStackHeaderConfig config, Integer color) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTintColor(color != null ? color.intValue() : 0);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = ViewProps.HIDDEN)
    public void setHidden(ScreenStackHeaderConfig config, boolean hidden) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setHidden(hidden);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "translucent")
    public void setTranslucent(ScreenStackHeaderConfig config, boolean translucent) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setTranslucent(translucent);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "backButtonInCustomView")
    public void setBackButtonInCustomView(ScreenStackHeaderConfig config, boolean backButtonInCustomView) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setBackButtonInCustomView(backButtonInCustomView);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    @ReactProp(name = "direction")
    public void setDirection(ScreenStackHeaderConfig config, String direction) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setDirection(direction);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(HeaderAttachedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAttached"), HeaderDetachedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDetached"));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ScreenStackHeaderConfig> getDelegate() {
        return this.delegate;
    }

    private final void logNotAvailable(String propName) {
        Log.w("[RNScreens]", propName + " prop is not available on Android");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitle(ScreenStackHeaderConfig view, String value) {
        logNotAvailable("backTitle");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitleFontFamily(ScreenStackHeaderConfig view, String value) {
        logNotAvailable("backTitleFontFamily");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitleFontSize(ScreenStackHeaderConfig view, int value) {
        logNotAvailable("backTitleFontSize");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackTitleVisible(ScreenStackHeaderConfig view, boolean value) {
        logNotAvailable("backTitleVisible");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitle(ScreenStackHeaderConfig view, boolean value) {
        logNotAvailable("largeTitle");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleFontFamily(ScreenStackHeaderConfig view, String value) {
        logNotAvailable("largeTitleFontFamily");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleFontSize(ScreenStackHeaderConfig view, int value) {
        logNotAvailable("largeTitleFontSize");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleFontWeight(ScreenStackHeaderConfig view, String value) {
        logNotAvailable("largeTitleFontWeight");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleBackgroundColor(ScreenStackHeaderConfig view, Integer value) {
        logNotAvailable("largeTitleBackgroundColor");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleHideShadow(ScreenStackHeaderConfig view, boolean value) {
        logNotAvailable("largeTitleHideShadow");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setLargeTitleColor(ScreenStackHeaderConfig view, Integer value) {
        logNotAvailable("largeTitleColor");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setDisableBackButtonMenu(ScreenStackHeaderConfig view, boolean value) {
        logNotAvailable("disableBackButtonMenu");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBackButtonDisplayMode(ScreenStackHeaderConfig view, String value) {
        logNotAvailable("backButtonDisplayMode");
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface
    public void setBlurEffect(ScreenStackHeaderConfig view, String value) {
        logNotAvailable("blurEffect");
    }
}
