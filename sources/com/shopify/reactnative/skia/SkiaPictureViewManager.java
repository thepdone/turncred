package com.shopify.reactnative.skia;

import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.SkiaPictureViewManagerDelegate;
import com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface;

/* loaded from: classes5.dex */
public class SkiaPictureViewManager extends SkiaBaseViewManager<SkiaPictureView> implements SkiaPictureViewManagerInterface<SkiaPictureView> {
    protected SkiaPictureViewManagerDelegate mDelegate = new SkiaPictureViewManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface
    @ReactProp(name = "debug")
    public /* bridge */ /* synthetic */ void setDebug(View view, boolean z) {
        super.setDebug((SkiaPictureViewManager) view, z);
    }

    @Override // com.facebook.react.viewmanagers.SkiaPictureViewManagerInterface
    @ReactProp(name = "mode")
    public /* bridge */ /* synthetic */ void setMode(View view, String str) {
        super.setMode((SkiaPictureViewManager) view, str);
    }

    SkiaPictureViewManager() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public SkiaPictureViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "SkiaPictureView";
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public SkiaPictureView createViewInstance(ThemedReactContext themedReactContext) {
        return new SkiaPictureView(themedReactContext);
    }
}
