package com.facebook.react.modules.core;

import android.net.Uri;
import com.facebook.fbreact.specs.NativeDeviceEventManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceEventManagerModule.kt */
@ReactModule(name = "DeviceEventManager")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/modules/core/DeviceEventManagerModule;", "Lcom/facebook/fbreact/specs/NativeDeviceEventManagerSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "backBtnHandler", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;)V", "invokeDefaultBackPressRunnable", "Ljava/lang/Runnable;", "emitHardwareBackPressed", "", "emitNewIntentReceived", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "invokeDefaultBackPressHandler", "Companion", "RCTDeviceEventEmitter", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public class DeviceEventManagerModule extends NativeDeviceEventManagerSpec {
    public static final String NAME = "DeviceEventManager";
    private final Runnable invokeDefaultBackPressRunnable;

    /* compiled from: DeviceEventManagerModule.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "Lcom/facebook/react/bridge/JavaScriptModule;", "emit", "", "eventName", "", "data", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(String eventName, Object data);
    }

    public DeviceEventManagerModule(ReactApplicationContext reactApplicationContext, final DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        super(reactApplicationContext);
        this.invokeDefaultBackPressRunnable = new Runnable() { // from class: com.facebook.react.modules.core.DeviceEventManagerModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeviceEventManagerModule.invokeDefaultBackPressRunnable$lambda$0(defaultHardwareBackBtnHandler);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeDefaultBackPressRunnable$lambda$0(DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.assertOnUiThread();
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
        }
    }

    public void emitHardwareBackPressed() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("hardwareBackPress", null);
        }
    }

    public void emitNewIntentReceived(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("url", uri.toString());
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("url", writableMapCreateMap);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceEventManagerSpec
    public void invokeDefaultBackPressHandler() {
        getReactApplicationContext().runOnUiQueueThread(this.invokeDefaultBackPressRunnable);
    }
}
