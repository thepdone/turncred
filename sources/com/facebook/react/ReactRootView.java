package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class ReactRootView extends FrameLayout implements RootView, ReactRoot {
    private static final String TAG = "ReactRootView";
    private final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper;
    private Bundle mAppProperties;
    private CustomGlobalLayoutListener mCustomGlobalLayoutListener;
    private int mHeightMeasureSpec;
    private boolean mIsAttachedToInstance;
    private String mJSModuleName;
    private JSPointerDispatcher mJSPointerDispatcher;
    private JSTouchDispatcher mJSTouchDispatcher;
    private int mLastHeight;
    private int mLastOffsetX;
    private int mLastOffsetY;
    private int mLastWidth;
    private ReactInstanceManager mReactInstanceManager;
    private ReactRootViewEventListener mRootViewEventListener;
    private int mRootViewTag;
    private boolean mShouldLogContentAppeared;
    private final AtomicInteger mState;
    private int mUIManagerType;
    private boolean mWasMeasured;
    private int mWidthMeasureSpec;

    public interface ReactRootViewEventListener {
        void onAttachedToReactInstance(ReactRootView reactRootView);
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public ViewGroup getRootViewGroup() {
        return this;
    }

    public boolean shouldDispatchJSTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public ReactRootView(Context context) {
        super(context);
        this.mRootViewTag = 0;
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mLastOffsetX = Integer.MIN_VALUE;
        this.mLastOffsetY = Integer.MIN_VALUE;
        this.mUIManagerType = 1;
        this.mState = new AtomicInteger(0);
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootViewTag = 0;
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mLastOffsetX = Integer.MIN_VALUE;
        this.mLastOffsetY = Integer.MIN_VALUE;
        this.mUIManagerType = 1;
        this.mState = new AtomicInteger(0);
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootViewTag = 0;
        this.mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mLastOffsetX = Integer.MIN_VALUE;
        this.mLastOffsetY = Integer.MIN_VALUE;
        this.mUIManagerType = 1;
        this.mState = new AtomicInteger(0);
        init();
    }

    private void init() {
        setRootViewTag(ReactRootViewTagGenerator.getNextRootViewTag());
        setClipChildren(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMax;
        int iMax2;
        Systrace.beginSection(0L, "ReactRootView.onMeasure");
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_START);
        try {
            boolean z = (i == this.mWidthMeasureSpec && i2 == this.mHeightMeasureSpec) ? false : true;
            this.mWidthMeasureSpec = i;
            this.mHeightMeasureSpec = i2;
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 0) {
                iMax = 0;
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    iMax = Math.max(iMax, childAt.getLeft() + childAt.getMeasuredWidth() + childAt.getPaddingLeft() + childAt.getPaddingRight());
                }
            } else {
                iMax = View.MeasureSpec.getSize(i);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
                iMax2 = 0;
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    View childAt2 = getChildAt(i4);
                    iMax2 = Math.max(iMax2, childAt2.getTop() + childAt2.getMeasuredHeight() + childAt2.getPaddingTop() + childAt2.getPaddingBottom());
                }
            } else {
                iMax2 = View.MeasureSpec.getSize(i2);
            }
            setMeasuredDimension(iMax, iMax2);
            this.mWasMeasured = true;
            if (hasActiveReactInstance() && !isViewAttachedToReactInstance()) {
                attachToReactInstanceManager();
            } else if (z || this.mLastWidth != iMax || this.mLastHeight != iMax2) {
                updateRootLayoutSpecs(true, this.mWidthMeasureSpec, this.mHeightMeasureSpec);
            }
            this.mLastWidth = iMax;
            this.mLastHeight = iMax2;
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END);
            Systrace.endSection(0L);
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(View view, MotionEvent motionEvent) {
        EventDispatcher eventDispatcher;
        JSPointerDispatcher jSPointerDispatcher;
        if (isDispatcherReady() && (eventDispatcher = UIManagerHelper.getEventDispatcher(getCurrentReactContext(), getUIManagerType())) != null) {
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, eventDispatcher);
            if (view == null || (jSPointerDispatcher = this.mJSPointerDispatcher) == null) {
                return;
            }
            jSPointerDispatcher.onChildStartedNativeGesture(view, motionEvent, eventDispatcher);
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(View view, MotionEvent motionEvent) {
        EventDispatcher eventDispatcher;
        if (isDispatcherReady() && (eventDispatcher = UIManagerHelper.getEventDispatcher(getCurrentReactContext(), getUIManagerType())) != null) {
            this.mJSTouchDispatcher.onChildEndedNativeGesture(motionEvent, eventDispatcher);
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.onChildEndedNativeGesture();
            }
        }
    }

    private boolean isDispatcherReady() {
        if (!hasActiveReactContext() || !isViewAttachedToReactInstance()) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return false;
        }
        if (this.mJSTouchDispatcher == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
            return false;
        }
        if (!ReactFeatureFlags.dispatchPointerEvents || this.mJSPointerDispatcher != null) {
            return true;
        }
        FLog.w(TAG, "Unable to dispatch pointer events to JS before the dispatcher is available");
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (shouldDispatchJSTouchEvent(motionEvent)) {
            dispatchJSTouchEvent(motionEvent);
        }
        dispatchJSPointerEvent(motionEvent, true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (shouldDispatchJSTouchEvent(motionEvent)) {
            dispatchJSTouchEvent(motionEvent);
        }
        dispatchJSPointerEvent(motionEvent, false);
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        dispatchJSPointerEvent(motionEvent, true);
        return super.onInterceptHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        dispatchJSPointerEvent(motionEvent, false);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e) {
            handleException(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!hasActiveReactContext() || !isViewAttachedToReactInstance()) {
            FLog.w(TAG, "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        this.mAndroidHWInputDeviceHelper.handleKeyEvent(keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (!hasActiveReactContext() || !isViewAttachedToReactInstance()) {
            FLog.w(TAG, "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z, i, rect);
        } else {
            this.mAndroidHWInputDeviceHelper.clearFocus();
            super.onFocusChanged(z, i, rect);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!hasActiveReactContext() || !isViewAttachedToReactInstance()) {
            FLog.w(TAG, "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
        } else {
            this.mAndroidHWInputDeviceHelper.onFocusChanged(view2);
            super.requestChildFocus(view, view2);
        }
    }

    protected void dispatchJSPointerEvent(MotionEvent motionEvent, boolean z) {
        if (!hasActiveReactContext() || !isViewAttachedToReactInstance()) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return;
        }
        if (this.mJSPointerDispatcher == null) {
            if (ReactFeatureFlags.dispatchPointerEvents) {
                FLog.w(TAG, "Unable to dispatch pointer events to JS before the dispatcher is available");
            }
        } else {
            EventDispatcher eventDispatcher = UIManagerHelper.getEventDispatcher(getCurrentReactContext(), getUIManagerType());
            if (eventDispatcher != null) {
                this.mJSPointerDispatcher.handleMotionEvent(motionEvent, eventDispatcher, z);
            }
        }
    }

    protected void dispatchJSTouchEvent(MotionEvent motionEvent) {
        if (!hasActiveReactContext() || !isViewAttachedToReactInstance()) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return;
        }
        if (this.mJSTouchDispatcher == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
            return;
        }
        EventDispatcher eventDispatcher = UIManagerHelper.getEventDispatcher(getCurrentReactContext(), getUIManagerType());
        if (eventDispatcher != null) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, eventDispatcher, getCurrentReactContext());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mWasMeasured && isFabric()) {
            updateRootLayoutSpecs(false, this.mWidthMeasureSpec, this.mHeightMeasureSpec);
        }
    }

    private boolean isFabric() {
        return getUIManagerType() == 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isViewAttachedToReactInstance()) {
            removeOnGlobalLayoutListener();
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isViewAttachedToReactInstance()) {
            removeOnGlobalLayoutListener();
        }
    }

    private void removeOnGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(final View view) {
        super.onViewAdded(view);
        if (view instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactRootView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (view.isShown()) {
                        return;
                    }
                    ReactSoftExceptionLogger.logSoftException(ReactRootView.TAG, new ReactNoCrashSoftException("A view was illegally added as a child of a ReactRootView. This View should not be a direct child of a ReactRootView, because it is not visible and will never be reachable. Child: " + view.getClass().getCanonicalName().toString() + " child ID: " + view.getId()));
                }
            });
        }
        if (this.mShouldLogContentAppeared) {
            this.mShouldLogContentAppeared = false;
            ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, getJSModuleName(), this.mRootViewTag);
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str) {
        startReactApplication(reactInstanceManager, str, null);
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        Systrace.beginSection(0L, "startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            Assertions.assertCondition(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = reactInstanceManager;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            reactInstanceManager.createReactContextInBackground();
            if (ReactNativeFeatureFlags.enableEagerRootViewAttachment()) {
                if (!this.mWasMeasured) {
                    setSurfaceConstraintsToScreenSize();
                }
                attachToReactInstanceManager();
            }
        } finally {
            Systrace.endSection(0L);
        }
    }

    private void setSurfaceConstraintsToScreenSize() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void setShouldLogContentAppeared(boolean z) {
        this.mShouldLogContentAppeared = z;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public AtomicInteger getState() {
        return this.mState;
    }

    private void updateRootLayoutSpecs(boolean z, int i, int i2) {
        UIManager uIManager;
        int i3;
        int i4;
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_START);
        if (!hasActiveReactInstance()) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            FLog.w(TAG, "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        boolean zIsFabric = isFabric();
        if (zIsFabric && !isRootViewTagSet()) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            FLog.e(TAG, "Unable to update root layout specs for ReactRootView: no rootViewTag set yet");
            return;
        }
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (uIManager = UIManagerHelper.getUIManager(currentReactContext, getUIManagerType())) != null) {
            if (zIsFabric) {
                Point viewportOffset = RootViewUtil.getViewportOffset(this);
                i3 = viewportOffset.x;
                i4 = viewportOffset.y;
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (z || i3 != this.mLastOffsetX || i4 != this.mLastOffsetY) {
                uIManager.updateRootLayoutSpecs(getRootViewTag(), i, i2, i3, i4);
            }
            this.mLastOffsetX = i3;
            this.mLastOffsetY = i4;
        }
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
    }

    public void unmountReactApplication() {
        UiThreadUtil.assertOnUiThread();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null && this.mIsAttachedToInstance) {
            reactInstanceManager.detachRootView(this);
            this.mIsAttachedToInstance = false;
        }
        this.mReactInstanceManager = null;
        this.mShouldLogContentAppeared = false;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void onStage(int i) {
        if (i != 101) {
            return;
        }
        onAttachedToReactInstance();
    }

    public void onAttachedToReactInstance() {
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.mJSPointerDispatcher = new JSPointerDispatcher(this);
        }
        ReactRootViewEventListener reactRootViewEventListener = this.mRootViewEventListener;
        if (reactRootViewEventListener != null) {
            reactRootViewEventListener.onAttachedToReactInstance(this);
        }
    }

    public void setEventListener(ReactRootViewEventListener reactRootViewEventListener) {
        this.mRootViewEventListener = reactRootViewEventListener;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public String getJSModuleName() {
        return (String) Assertions.assertNotNull(this.mJSModuleName);
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    public void setAppProperties(Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (isRootViewTagSet()) {
            runApplication();
        }
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void runApplication() {
        Systrace.beginSection(0L, "ReactRootView.runApplication");
        try {
            if (hasActiveReactInstance() && isViewAttachedToReactInstance()) {
                ReactContext currentReactContext = getCurrentReactContext();
                if (currentReactContext == null) {
                    return;
                }
                CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                String jSModuleName = getJSModuleName();
                if (this.mWasMeasured) {
                    updateRootLayoutSpecs(true, this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                }
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble("rootTag", getRootViewTag());
                Bundle appProperties = getAppProperties();
                if (appProperties != null) {
                    writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                }
                this.mShouldLogContentAppeared = true;
                ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
            }
        } finally {
            Systrace.endSection(0L);
        }
    }

    @VisibleForTesting
    void simulateAttachForTesting() {
        this.mIsAttachedToInstance = true;
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.mJSPointerDispatcher = new JSPointerDispatcher(this);
        }
    }

    @VisibleForTesting
    void simulateCheckForKeyboardForTesting() {
        if (Build.VERSION.SDK_INT >= 30) {
            getCustomGlobalLayoutListener().checkForKeyboardEvents();
        } else {
            getCustomGlobalLayoutListener().checkForKeyboardEventsLegacy();
        }
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
        }
        return this.mCustomGlobalLayoutListener;
    }

    private void attachToReactInstanceManager() {
        Systrace.beginSection(0L, "attachToReactInstanceManager");
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START);
        if (getId() != -1) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException("Trying to attach a ReactRootView with an explicit id already set to [" + getId() + "]. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID."));
        }
        try {
            if (this.mIsAttachedToInstance) {
                return;
            }
            this.mIsAttachedToInstance = true;
            ((ReactInstanceManager) Assertions.assertNotNull(this.mReactInstanceManager)).attachRootView(this);
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
            Systrace.endSection(0L);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        Assertions.assertCondition(!this.mIsAttachedToInstance, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    private boolean isRootViewTagSet() {
        int i = this.mRootViewTag;
        return (i == 0 || i == -1) ? false : true;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void setRootViewTag(int i) {
        this.mRootViewTag = i;
    }

    @Override // com.facebook.react.uimanager.RootView
    public void handleException(Throwable th) {
        if (!hasActiveReactContext()) {
            throw new RuntimeException(th);
        }
        getCurrentReactContext().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
    }

    public void setIsFabric(boolean z) {
        this.mUIManagerType = z ? 2 : 1;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    void sendEvent(String str, WritableMap writableMap) {
        if (hasActiveReactInstance()) {
            getCurrentReactContext().emitDeviceEvent(str, writableMap);
        }
    }

    public boolean hasActiveReactInstance() {
        return this.mReactInstanceManager != null;
    }

    public boolean hasActiveReactContext() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        return (reactInstanceManager == null || reactInstanceManager.getCurrentReactContext() == null) ? false : true;
    }

    public ReactContext getCurrentReactContext() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null) {
            return null;
        }
        return reactInstanceManager.getCurrentReactContext();
    }

    public boolean isViewAttachedToReactInstance() {
        return this.mIsAttachedToInstance;
    }

    private class CustomGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final int mMinKeyboardHeightDetected;
        private final Rect mVisibleViewArea;
        private boolean mKeyboardIsVisible = false;
        private int mKeyboardHeight = 0;
        private int mDeviceRotation = 0;

        CustomGlobalLayoutListener() {
            DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
            this.mVisibleViewArea = new Rect();
            this.mMinKeyboardHeightDetected = (int) PixelUtil.toPixelFromDIP(60.0f);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ReactRootView.this.hasActiveReactContext() && ReactRootView.this.isViewAttachedToReactInstance()) {
                if (Build.VERSION.SDK_INT >= 30) {
                    checkForKeyboardEvents();
                } else {
                    checkForKeyboardEventsLegacy();
                }
                checkForDeviceOrientationChanges();
                checkForDeviceDimensionsChanges();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkForKeyboardEvents() {
            boolean zIsVisible;
            int i;
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
            WindowInsets rootWindowInsets = ReactRootView.this.getRootView().getRootWindowInsets();
            if (rootWindowInsets == null || (zIsVisible = rootWindowInsets.isVisible(WindowInsets.Type.ime())) == this.mKeyboardIsVisible) {
                return;
            }
            this.mKeyboardIsVisible = zIsVisible;
            if (zIsVisible) {
                int i2 = rootWindowInsets.getInsets(WindowInsets.Type.ime()).bottom - rootWindowInsets.getInsets(WindowInsets.Type.systemBars()).bottom;
                ViewGroup.LayoutParams layoutParams = ReactRootView.this.getRootView().getLayoutParams();
                Assertions.assertCondition(layoutParams instanceof WindowManager.LayoutParams);
                if (((WindowManager.LayoutParams) layoutParams).softInputMode == 48) {
                    i = this.mVisibleViewArea.bottom - i2;
                } else {
                    i = this.mVisibleViewArea.bottom;
                }
                ReactRootView.this.sendEvent("keyboardDidShow", createKeyboardEventPayload(PixelUtil.toDIPFromPixel(i), PixelUtil.toDIPFromPixel(this.mVisibleViewArea.left), PixelUtil.toDIPFromPixel(this.mVisibleViewArea.width()), PixelUtil.toDIPFromPixel(i2)));
                return;
            }
            ReactRootView.this.sendEvent("keyboardDidHide", createKeyboardEventPayload(PixelUtil.toDIPFromPixel(this.mVisibleViewArea.height()), AudioStats.AUDIO_AMPLITUDE_NONE, PixelUtil.toDIPFromPixel(this.mVisibleViewArea.width()), AudioStats.AUDIO_AMPLITUDE_NONE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkForKeyboardEventsLegacy() {
            WindowInsets rootWindowInsets;
            DisplayCutout displayCutout;
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
            int safeInsetTop = (DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels - this.mVisibleViewArea.bottom) + ((Build.VERSION.SDK_INT < 28 || (rootWindowInsets = ReactRootView.this.getRootView().getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) ? 0 : displayCutout.getSafeInsetTop());
            int i = this.mKeyboardHeight;
            if (i != safeInsetTop && safeInsetTop > this.mMinKeyboardHeightDetected) {
                this.mKeyboardHeight = safeInsetTop;
                this.mKeyboardIsVisible = true;
                ReactRootView.this.sendEvent("keyboardDidShow", createKeyboardEventPayload(PixelUtil.toDIPFromPixel(this.mVisibleViewArea.bottom), PixelUtil.toDIPFromPixel(this.mVisibleViewArea.left), PixelUtil.toDIPFromPixel(this.mVisibleViewArea.width()), PixelUtil.toDIPFromPixel(this.mKeyboardHeight)));
            } else {
                if (i == 0 || safeInsetTop > this.mMinKeyboardHeightDetected) {
                    return;
                }
                this.mKeyboardHeight = 0;
                this.mKeyboardIsVisible = false;
                ReactRootView.this.sendEvent("keyboardDidHide", createKeyboardEventPayload(PixelUtil.toDIPFromPixel(this.mVisibleViewArea.height()), AudioStats.AUDIO_AMPLITUDE_NONE, PixelUtil.toDIPFromPixel(this.mVisibleViewArea.width()), AudioStats.AUDIO_AMPLITUDE_NONE));
            }
        }

        private void checkForDeviceOrientationChanges() {
            int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.mDeviceRotation == rotation) {
                return;
            }
            this.mDeviceRotation = rotation;
            DisplayMetricsHolder.initDisplayMetrics(ReactRootView.this.getContext().getApplicationContext());
            emitOrientationChanged(rotation);
        }

        private void checkForDeviceDimensionsChanges() {
            emitUpdateDimensionsEvent();
        }

        private void emitOrientationChanged(int i) {
            String str;
            double d;
            boolean z = false;
            if (i != 0) {
                if (i == 1) {
                    str = "landscape-primary";
                    d = -90.0d;
                } else if (i == 2) {
                    str = "portrait-secondary";
                    d = 180.0d;
                } else {
                    if (i != 3) {
                        return;
                    }
                    str = "landscape-secondary";
                    d = 90.0d;
                }
                z = true;
            } else {
                str = "portrait-primary";
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("name", str);
            writableMapCreateMap.putDouble("rotationDegrees", d);
            writableMapCreateMap.putBoolean("isLandscape", z);
            ReactRootView.this.sendEvent("namedOrientationDidChange", writableMapCreateMap);
        }

        private void emitUpdateDimensionsEvent() {
            DeviceInfoModule deviceInfoModule;
            ReactContext currentReactContext = ReactRootView.this.getCurrentReactContext();
            if (currentReactContext == null || (deviceInfoModule = (DeviceInfoModule) currentReactContext.getNativeModule(DeviceInfoModule.class)) == null) {
                return;
            }
            deviceInfoModule.emitUpdateDimensionsEvent();
        }

        private WritableMap createKeyboardEventPayload(double d, double d2, double d3, double d4) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putDouble("height", d4);
            writableMapCreateMap2.putDouble("screenX", d2);
            writableMapCreateMap2.putDouble("width", d3);
            writableMapCreateMap2.putDouble("screenY", d);
            writableMapCreateMap.putMap("endCoordinates", writableMapCreateMap2);
            writableMapCreateMap.putString("easing", "keyboard");
            writableMapCreateMap.putDouble("duration", AudioStats.AUDIO_AMPLITUDE_NONE);
            return writableMapCreateMap;
        }
    }
}
