package com.swmansion.reanimated.nativeProxy;

import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.soloader.SoLoader;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.reanimated.AndroidUIScheduler;
import com.swmansion.reanimated.BuildConfig;
import com.swmansion.reanimated.DevMenuUtils;
import com.swmansion.reanimated.NativeProxy;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.ReanimatedModule;
import com.swmansion.reanimated.Utils;
import com.swmansion.reanimated.keyboard.KeyboardAnimationManager;
import com.swmansion.reanimated.keyboard.KeyboardWorkletWrapper;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.sensor.ReanimatedSensorContainer;
import com.swmansion.reanimated.sensor.ReanimatedSensorType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes5.dex */
public abstract class NativeProxyCommon {
    private final GestureHandlerStateManager gestureHandlerStateManager;
    private final KeyboardAnimationManager keyboardAnimationManager;
    protected final AndroidUIScheduler mAndroidUIScheduler;
    protected final WeakReference<ReactApplicationContext> mContext;
    protected NodesManager mNodesManager;
    private final ReanimatedSensorContainer reanimatedSensorContainer;
    private Long firstUptime = Long.valueOf(SystemClock.uptimeMillis());
    private boolean slowAnimationsEnabled = false;
    private final int ANIMATIONS_DRAG_FACTOR = 10;
    protected String cppVersion = null;

    protected abstract HybridData getHybridData();

    protected native void installJSIBindings();

    static {
        SoLoader.loadLibrary("reanimated");
    }

    protected NativeProxyCommon(ReactApplicationContext reactApplicationContext) {
        GestureHandlerStateManager gestureHandlerStateManager = null;
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactApplicationContext);
        WeakReference<ReactApplicationContext> weakReference = new WeakReference<>(reactApplicationContext);
        this.mContext = weakReference;
        this.reanimatedSensorContainer = new ReanimatedSensorContainer(weakReference);
        this.keyboardAnimationManager = new KeyboardAnimationManager(weakReference);
        addDevMenuOption();
        try {
            gestureHandlerStateManager = (GestureHandlerStateManager) reactApplicationContext.getNativeModule(Class.forName("com.swmansion.gesturehandler.react.RNGestureHandlerModule"));
        } catch (ClassCastException | ClassNotFoundException unused) {
        }
        this.gestureHandlerStateManager = gestureHandlerStateManager;
    }

    public AndroidUIScheduler getAndroidUIScheduler() {
        return this.mAndroidUIScheduler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleSlowAnimations() {
        boolean z = this.slowAnimationsEnabled;
        this.slowAnimationsEnabled = !z;
        if (!z) {
            this.firstUptime = Long.valueOf(SystemClock.uptimeMillis());
        }
        this.mNodesManager.enableSlowAnimations(this.slowAnimationsEnabled, 10);
    }

    private void addDevMenuOption() {
        DevMenuUtils.addDevMenuOption(this.mContext.get(), new DevOptionHandler() { // from class: com.swmansion.reanimated.nativeProxy.NativeProxyCommon$$ExternalSyntheticLambda0
            @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
            public final void onOptionSelected() {
                this.f$0.toggleSlowAnimations();
            }
        });
    }

    public void requestRender(AnimationFrameCallback animationFrameCallback) {
        this.mNodesManager.postOnAnimation(animationFrameCallback);
    }

    public String getReanimatedJavaVersion() {
        return BuildConfig.REANIMATED_VERSION_JAVA;
    }

    protected void setCppVersion(String str) {
        this.cppVersion = str;
    }

    protected void checkCppVersion() {
        if (this.cppVersion == null) {
            throw new RuntimeException("[Reanimated] Java side failed to resolve C++ code version. See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#java-side-failed-to-resolve-c-code-version for more information.");
        }
        String reanimatedJavaVersion = getReanimatedJavaVersion();
        if (!this.cppVersion.equals(reanimatedJavaVersion)) {
            throw new RuntimeException("[Reanimated] Mismatch between Java code version and C++ code version (" + reanimatedJavaVersion + " vs. " + this.cppVersion + " respectively). See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#mismatch-between-java-code-version-and-c-code-version for more information.");
        }
    }

    public void updateProps(int i, Map<String, Object> map) {
        this.mNodesManager.updateProps(i, map);
    }

    public void synchronouslyUpdateUIProps(int i, ReadableMap readableMap) {
        this.mNodesManager.synchronouslyUpdateUIProps(i, readableMap);
    }

    public String obtainProp(int i, String str) {
        return this.mNodesManager.obtainProp(i, str);
    }

    public void scrollTo(int i, double d, double d2, boolean z) {
        this.mNodesManager.scrollTo(i, d, d2, z);
    }

    public void dispatchCommand(int i, String str, ReadableArray readableArray) {
        this.mNodesManager.dispatchCommand(i, str, readableArray);
    }

    public void setGestureState(int i, int i2) {
        GestureHandlerStateManager gestureHandlerStateManager = this.gestureHandlerStateManager;
        if (gestureHandlerStateManager != null) {
            gestureHandlerStateManager.setGestureHandlerState(i, i2);
        }
    }

    public long getAnimationTimestamp() {
        if (this.slowAnimationsEnabled) {
            return this.firstUptime.longValue() + ((SystemClock.uptimeMillis() - this.firstUptime.longValue()) / 10);
        }
        return SystemClock.uptimeMillis();
    }

    public float[] measure(int i) {
        return this.mNodesManager.measure(i);
    }

    public void configureProps(ReadableNativeArray readableNativeArray, ReadableNativeArray readableNativeArray2) {
        this.mNodesManager.configureProps(convertProps(readableNativeArray), convertProps(readableNativeArray2));
    }

    private Set<String> convertProps(ReadableNativeArray readableNativeArray) {
        HashSet hashSet = new HashSet();
        ArrayList<Object> arrayList = readableNativeArray.toArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            hashSet.add((String) arrayList.get(i));
        }
        return hashSet;
    }

    public void registerEventHandler(EventHandler eventHandler) {
        eventHandler.mCustomEventNamesResolver = this.mNodesManager.getEventNameResolver();
        this.mNodesManager.registerEventHandler(eventHandler);
    }

    public int registerSensor(int i, int i2, SensorSetter sensorSetter) {
        return this.reanimatedSensorContainer.registerSensor(ReanimatedSensorType.getInstanceById(i), i2, sensorSetter);
    }

    public void unregisterSensor(int i) {
        this.reanimatedSensorContainer.unregisterSensor(i);
    }

    public int subscribeForKeyboardEvents(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean z, boolean z2) {
        return this.keyboardAnimationManager.subscribeForKeyboardUpdates(keyboardWorkletWrapper, z, z2);
    }

    public void unsubscribeFromKeyboardEvents(int i) {
        this.keyboardAnimationManager.unsubscribeFromKeyboardUpdates(i);
    }

    public void invalidate() {
        this.mAndroidUIScheduler.deactivate();
    }

    public void prepareLayoutAnimations(LayoutAnimations layoutAnimations) {
        if (Utils.isChromeDebugger) {
            Log.w("[REANIMATED]", "You can not use LayoutAnimation with enabled Chrome Debugger");
        } else {
            this.mNodesManager = ((ReanimatedModule) Objects.requireNonNull((ReanimatedModule) this.mContext.get().getNativeModule(ReanimatedModule.class))).getNodesManager();
            ((ReanimatedModule) Objects.requireNonNull((ReanimatedModule) this.mContext.get().getNativeModule(ReanimatedModule.class))).getNodesManager().getAnimationsManager().setNativeMethods(NativeProxy.createNativeMethodsHolder(layoutAnimations));
        }
    }

    public boolean getIsReducedMotion() {
        String string = Settings.Global.getString(this.mContext.get().getContentResolver(), "transition_animation_scale");
        return (string != null ? Float.parseFloat(string) : 1.0f) == 0.0f;
    }

    void maybeFlushUIUpdatesQueue() {
        if (this.mNodesManager.isAnimationRunning()) {
            return;
        }
        this.mNodesManager.performOperations();
    }
}
