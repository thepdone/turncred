package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceInfoModule.kt */
@ReactModule(name = NativeDeviceInfoSpec.NAME)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/modules/deviceinfo/DeviceInfoModule;", "Lcom/facebook/fbreact/specs/NativeDeviceInfoSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fontScale", "", "previousDisplayMetrics", "Lcom/facebook/react/bridge/ReadableMap;", "reactApplicationContext", "emitUpdateDimensionsEvent", "", "getTypedExportedConstants", "", "", "", "invalidate", "onHostDestroy", "onHostPause", "onHostResume", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeviceInfoModule extends NativeDeviceInfoSpec implements LifecycleEventListener {
    private float fontScale;
    private ReadableMap previousDisplayMetrics;
    private ReactApplicationContext reactApplicationContext;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactContext);
        this.fontScale = reactContext.getResources().getConfiguration().fontScale;
        reactContext.addLifecycleEventListener(this);
        this.reactApplicationContext = reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(Context context) {
        super(null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reactApplicationContext = null;
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.fontScale = context.getResources().getConfiguration().fontScale;
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceInfoSpec
    public Map<String, Object> getTypedExportedConstants() {
        WritableMap displayMetricsWritableMap = DisplayMetricsHolder.getDisplayMetricsWritableMap(this.fontScale);
        this.previousDisplayMetrics = displayMetricsWritableMap.copy();
        return MapsKt.mapOf(TuplesKt.to("Dimensions", displayMetricsWritableMap.toHashMap()));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        Resources resources;
        Configuration configuration;
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        Float fValueOf = (reactApplicationContext == null || (resources = reactApplicationContext.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Float.valueOf(configuration.fontScale);
        if (fValueOf == null || Intrinsics.areEqual(fValueOf, this.fontScale)) {
            return;
        }
        this.fontScale = fValueOf.floatValue();
        emitUpdateDimensionsEvent();
    }

    public final void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        if (reactApplicationContext != null) {
            if (reactApplicationContext.hasActiveReactInstance()) {
                WritableMap displayMetricsWritableMap = DisplayMetricsHolder.getDisplayMetricsWritableMap(this.fontScale);
                ReadableMap readableMap = this.previousDisplayMetrics;
                if (readableMap == null) {
                    this.previousDisplayMetrics = displayMetricsWritableMap.copy();
                    return;
                } else {
                    if (Intrinsics.areEqual(displayMetricsWritableMap, readableMap)) {
                        return;
                    }
                    this.previousDisplayMetrics = displayMetricsWritableMap.copy();
                    reactApplicationContext.emitDeviceEvent("didUpdateDimensions", displayMetricsWritableMap);
                    return;
                }
            }
            ReactSoftExceptionLogger.logSoftException(NativeDeviceInfoSpec.NAME, new ReactNoCrashSoftException("No active CatalystInstance, cannot emitUpdateDimensionsEvent"));
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        ReactApplicationContext reactApplicationContext = this.reactApplicationContext;
        if (reactApplicationContext != null) {
            reactApplicationContext.removeLifecycleEventListener(this);
        }
    }
}
