package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.yoga.YogaMeasureMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes4.dex */
public abstract class ViewManager<T extends View, C extends ReactShadowNode> extends BaseJavaModule {
    private static final String NAME = "ViewManager";
    private HashMap<Integer, Stack<T>> mRecyclableViews;

    protected void addEventEmitters(ThemedReactContext themedReactContext, T t) {
    }

    protected abstract T createViewInstance(ThemedReactContext themedReactContext);

    public Map<String, Integer> getCommandsMap() {
        return null;
    }

    protected ViewManagerDelegate<T> getDelegate() {
        return null;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedViewConstants() {
        return null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public abstract String getName();

    public abstract Class<? extends C> getShadowNodeClass();

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        return 0L;
    }

    public long measure(Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, MapBuffer mapBuffer3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        return 0L;
    }

    protected void onAfterUpdateTransaction(T t) {
    }

    protected abstract T prepareToRecycleView(ThemedReactContext themedReactContext, T t);

    @Deprecated
    public void receiveCommand(T t, int i, ReadableArray readableArray) {
    }

    protected T recycleView(ThemedReactContext themedReactContext, T t) {
        return t;
    }

    public void setPadding(T t, int i, int i2, int i3, int i4) {
    }

    public abstract void updateExtraData(T t, Object obj);

    public Object updateState(T t, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        return null;
    }

    public ViewManager() {
        super(null);
        this.mRecyclableViews = null;
    }

    public ViewManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRecyclableViews = null;
    }

    protected void setupViewRecycling() {
        if (ReactNativeFeatureFlags.enableViewRecycling()) {
            this.mRecyclableViews = new HashMap<>();
        }
    }

    private Stack<T> getRecyclableViewStack(int i, boolean z) {
        HashMap<Integer, Stack<T>> map = this.mRecyclableViews;
        if (map == null) {
            return null;
        }
        if (z && !map.containsKey(Integer.valueOf(i))) {
            this.mRecyclableViews.put(Integer.valueOf(i), new Stack<>());
        }
        return this.mRecyclableViews.get(Integer.valueOf(i));
    }

    public void updateProperties(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerDelegate<T> delegate = getDelegate();
        if (delegate != null) {
            ViewManagerPropertyUpdater.updateProps(delegate, t, reactStylesDiffMap);
        } else {
            ViewManagerPropertyUpdater.updateProps(this, t, reactStylesDiffMap);
        }
        onAfterUpdateTransaction(t);
    }

    public T createView(int i, ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
        T t = (T) createViewInstance(i, themedReactContext, reactStylesDiffMap, stateWrapper);
        if (t instanceof ReactInterceptingViewGroup) {
            ((ReactInterceptingViewGroup) t).setOnInterceptTouchEventListener(jSResponderHandler);
        }
        return t;
    }

    public C createShadowNodeInstance() {
        throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
    }

    public C createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        return (C) createShadowNodeInstance();
    }

    protected T createViewInstance(int i, ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        T t;
        Object objUpdateState;
        Stack<T> recyclableViewStack = getRecyclableViewStack(themedReactContext.getSurfaceId(), true);
        if (recyclableViewStack != null && !recyclableViewStack.empty()) {
            t = (T) recycleView(themedReactContext, recyclableViewStack.pop());
        } else {
            t = (T) createViewInstance(themedReactContext);
        }
        t.setId(i);
        addEventEmitters(themedReactContext, t);
        if (reactStylesDiffMap != null) {
            updateProperties(t, reactStylesDiffMap);
        }
        if (stateWrapper != null && (objUpdateState = updateState(t, reactStylesDiffMap, stateWrapper)) != null) {
            updateExtraData(t, objUpdateState);
        }
        return t;
    }

    public void onDropViewInstance(T t) {
        View viewPrepareToRecycleView;
        Context context = t.getContext();
        if (context == null) {
            FLog.e(NAME, "onDropViewInstance: view [" + t.getId() + "] has a null context");
            return;
        }
        if (!(context instanceof ThemedReactContext)) {
            FLog.e(NAME, "onDropViewInstance: view [" + t.getId() + "] has a context that is not a ThemedReactContext: " + context);
            return;
        }
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        Stack<T> recyclableViewStack = getRecyclableViewStack(themedReactContext.getSurfaceId(), false);
        if (recyclableViewStack == null || (viewPrepareToRecycleView = prepareToRecycleView(themedReactContext, t)) == null) {
            return;
        }
        recyclableViewStack.push(viewPrepareToRecycleView);
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        ViewManagerDelegate<T> delegate = getDelegate();
        if (delegate != null) {
            delegate.receiveCommand(t, str, readableArray);
        }
    }

    public Map<String, String> getNativeProps() {
        return ViewManagerPropertyUpdater.getNativeProps(getClass(), getShadowNodeClass());
    }

    public void onSurfaceStopped(int i) {
        HashMap<Integer, Stack<T>> map = this.mRecyclableViews;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    void trimMemory() {
        if (this.mRecyclableViews != null) {
            this.mRecyclableViews = new HashMap<>();
        }
    }
}
