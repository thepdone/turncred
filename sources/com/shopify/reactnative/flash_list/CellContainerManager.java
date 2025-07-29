package com.shopify.reactnative.flash_list;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.CellContainerManagerDelegate;
import com.facebook.react.viewmanagers.CellContainerManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CellContainerManager.kt */
@ReactModule(name = AutoLayoutViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/shopify/reactnative/flash_list/CellContainerManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/shopify/reactnative/flash_list/CellContainerImpl;", "Lcom/facebook/react/viewmanagers/CellContainerManagerInterface;", "()V", "mDelegate", "Lcom/facebook/react/viewmanagers/CellContainerManagerDelegate;", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "setIndex", "", ViewHierarchyConstants.VIEW_KEY, FirebaseAnalytics.Param.INDEX, "", "Companion", "shopify_flash-list_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CellContainerManager extends ViewGroupManager<CellContainerImpl> implements CellContainerManagerInterface<CellContainerImpl> {
    public static final String REACT_CLASS = "CellContainer";
    private final CellContainerManagerDelegate<CellContainerImpl, CellContainerManager> mDelegate = new CellContainerManagerDelegate<>(this);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<CellContainerImpl> getDelegate() {
        return this.mDelegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public CellContainerImpl createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CellContainerImpl(context);
    }

    @Override // com.facebook.react.viewmanagers.CellContainerManagerInterface
    @ReactProp(name = FirebaseAnalytics.Param.INDEX)
    public void setIndex(CellContainerImpl view, int index) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIndex(index);
    }
}
