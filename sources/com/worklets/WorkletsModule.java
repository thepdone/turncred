package com.worklets;

import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import java.lang.ref.WeakReference;

@ReactModule(name = WorkletsModule.NAME)
/* loaded from: classes5.dex */
public class WorkletsModule extends WorkletsSpec {
    public static final String NAME = "Worklets";
    private final WeakReference<ReactApplicationContext> weakReactContext;

    public static native boolean nativeInstall(long j, CallInvokerHolder callInvokerHolder);

    WorkletsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.weakReactContext = new WeakReference<>(reactApplicationContext);
    }

    static {
        System.loadLibrary("rnworklets");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.worklets.WorkletsSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean install() {
        try {
            ReactApplicationContext reactApplicationContext = this.weakReactContext.get();
            if (reactApplicationContext == null) {
                Log.e(NAME, "React Application Context was null!");
                return false;
            }
            return nativeInstall(reactApplicationContext.getJavaScriptContextHolder().get(), reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder());
        } catch (Exception e) {
            Log.e(NAME, "Failed to initialize react-native-worklets-core!", e);
            return false;
        }
    }
}
