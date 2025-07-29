package com.facebook.react.internal.featureflags;

import com.facebook.react.config.ReactFeatureFlags;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReactNativeNewArchitectureFeatureFlagsDefaults.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeNewArchitectureFeatureFlagsDefaults;", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsDefaults;", "newArchitectureEnabled", "", "(Z)V", "batchRenderingUpdatesInEventLoop", "enableMicrotasks", "useModernRuntimeScheduler", "useNativeViewConfigsInBridgelessMode", "useTurboModuleInterop", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ReactNativeNewArchitectureFeatureFlagsDefaults extends ReactNativeFeatureFlagsDefaults {
    private final boolean newArchitectureEnabled;

    public ReactNativeNewArchitectureFeatureFlagsDefaults() {
        this(false, 1, null);
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMicrotasks() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useModernRuntimeScheduler() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeViewConfigsInBridgelessMode() {
        return true;
    }

    public /* synthetic */ ReactNativeNewArchitectureFeatureFlagsDefaults(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public ReactNativeNewArchitectureFeatureFlagsDefaults(boolean z) {
        this.newArchitectureEnabled = z;
        if (z) {
            ReactFeatureFlags.enableFabricRenderer = true;
            ReactFeatureFlags.useTurboModules = true;
            ReactFeatureFlags.enableBridgelessArchitecture = true;
        }
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean batchRenderingUpdatesInEventLoop() {
        return this.newArchitectureEnabled || super.batchRenderingUpdatesInEventLoop();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModuleInterop() {
        return this.newArchitectureEnabled || super.useTurboModuleInterop();
    }
}
