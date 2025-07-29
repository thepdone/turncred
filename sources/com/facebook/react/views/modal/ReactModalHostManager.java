package com.facebook.react.views.modal;

import android.content.DialogInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.ModalHostViewManagerDelegate;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;
import com.facebook.react.views.modal.ReactModalHostView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReactModalHostManager.kt */
@ReactModule(name = ReactModalHostManager.REACT_CLASS)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001,B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0017J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u001dH\u0017J\u001a\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0017H\u0017J\u001a\u0010!\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\"H\u0017J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0017H\u0017J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0017H\u0017J\"\u0010'\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/facebook/react/views/modal/ReactModalHostManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/facebook/react/views/modal/ReactModalHostView;", "Lcom/facebook/react/viewmanagers/ModalHostViewManagerInterface;", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "addEventEmitters", "", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", ViewHierarchyConstants.VIEW_KEY, "createViewInstance", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onAfterUpdateTransaction", "onDropViewInstance", "setAnimated", "value", "", "setAnimationType", "animationType", "setHardwareAccelerated", "hardwareAccelerated", "setIdentifier", "", "setPresentationStyle", "setStatusBarTranslucent", "statusBarTranslucent", "setSupportedOrientations", "Lcom/facebook/react/bridge/ReadableArray;", "setTransparent", "transparent", "setVisible", ViewProps.VISIBLE, "updateState", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactModalHostManager extends ViewGroupManager<ReactModalHostView> implements ModalHostViewManagerInterface<ReactModalHostView> {
    public static final String REACT_CLASS = "RCTModalHostView";
    private final ViewManagerDelegate<ReactModalHostView> delegate = new ModalHostViewManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "animated")
    public void setAnimated(ReactModalHostView view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "identifier")
    public void setIdentifier(ReactModalHostView view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "presentationStyle")
    public void setPresentationStyle(ReactModalHostView view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "supportedOrientations")
    public void setSupportedOrientations(ReactModalHostView view, ReadableArray value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = ViewProps.VISIBLE)
    public void setVisible(ReactModalHostView view, boolean visible) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactModalHostView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ReactModalHostView(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ReactModalHostView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onDropViewInstance((ReactModalHostManager) view);
        view.onDropInstance();
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "animationType")
    public void setAnimationType(ReactModalHostView view, String animationType) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (animationType != null) {
            view.setAnimationType(animationType);
        }
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "transparent")
    public void setTransparent(ReactModalHostView view, boolean transparent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTransparent(transparent);
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(ReactModalHostView view, boolean statusBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(statusBarTranslucent);
    }

    @Override // com.facebook.react.viewmanagers.ModalHostViewManagerInterface
    @ReactProp(name = "hardwareAccelerated")
    public void setHardwareAccelerated(ReactModalHostView view, boolean hardwareAccelerated) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHardwareAccelerated(hardwareAccelerated);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(final ThemedReactContext reactContext, final ReactModalHostView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        final EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        if (eventDispatcherForReactTag != null) {
            view.setOnRequestCloseListener(new ReactModalHostView.OnRequestCloseListener() { // from class: com.facebook.react.views.modal.ReactModalHostManager$$ExternalSyntheticLambda0
                @Override // com.facebook.react.views.modal.ReactModalHostView.OnRequestCloseListener
                public final void onRequestClose(DialogInterface dialogInterface) {
                    ReactModalHostManager.addEventEmitters$lambda$0(eventDispatcherForReactTag, reactContext, view, dialogInterface);
                }
            });
            view.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.facebook.react.views.modal.ReactModalHostManager$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ReactModalHostManager.addEventEmitters$lambda$1(eventDispatcherForReactTag, reactContext, view, dialogInterface);
                }
            });
            view.setEventDispatcher(eventDispatcherForReactTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventEmitters$lambda$0(EventDispatcher eventDispatcher, ThemedReactContext reactContext, ReactModalHostView view, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(reactContext, "$reactContext");
        Intrinsics.checkNotNullParameter(view, "$view");
        eventDispatcher.dispatchEvent(new RequestCloseEvent(UIManagerHelper.getSurfaceId(reactContext), view.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventEmitters$lambda$1(EventDispatcher eventDispatcher, ThemedReactContext reactContext, ReactModalHostView view, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(reactContext, "$reactContext");
        Intrinsics.checkNotNullParameter(view, "$view");
        eventDispatcher.dispatchEvent(new ShowEvent(UIManagerHelper.getSurfaceId(reactContext), view.getId()));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        LinkedHashMap exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new LinkedHashMap();
        }
        exportedCustomDirectEventTypeConstants.put(RequestCloseEvent.EVENT_NAME, MapsKt.mapOf(TuplesKt.to("registrationName", "onRequestClose")));
        exportedCustomDirectEventTypeConstants.put(ShowEvent.EVENT_NAME, MapsKt.mapOf(TuplesKt.to("registrationName", "onShow")));
        exportedCustomDirectEventTypeConstants.put("topDismiss", MapsKt.mapOf(TuplesKt.to("registrationName", "onDismiss")));
        exportedCustomDirectEventTypeConstants.put("topOrientationChange", MapsKt.mapOf(TuplesKt.to("registrationName", "onOrientationChange")));
        return exportedCustomDirectEventTypeConstants;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactModalHostView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((ReactModalHostManager) view);
        view.showOrUpdate();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactModalHostView view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        view.setStateWrapper(stateWrapper);
        return null;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ReactModalHostView> getDelegate() {
        return this.delegate;
    }
}
