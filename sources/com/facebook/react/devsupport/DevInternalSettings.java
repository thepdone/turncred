package com.facebook.react.devsupport;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevInternalSettings.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002/0B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u001a\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020'2\b\u0010.\u001a\u0004\u0018\u00010+H\u0016R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR$\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR$\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR$\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR$\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR$\u0010\u001e\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001e\u0010\u000b\"\u0004\b!\u0010\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/react/devsupport/DevInternalSettings;", "Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "applicationContext", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/devsupport/DevInternalSettings$Listener;", "(Landroid/content/Context;Lcom/facebook/react/devsupport/DevInternalSettings$Listener;)V", "<anonymous parameter 0>", "", "isAnimationFpsDebugEnabled", "()Z", "setAnimationFpsDebugEnabled", "(Z)V", "isDeviceDebugEnabled", "setDeviceDebugEnabled", "value", "isElementInspectorEnabled", "setElementInspectorEnabled", "isFpsDebugEnabled", "setFpsDebugEnabled", ViewProps.ENABLED, "isHotModuleReplacementEnabled", "setHotModuleReplacementEnabled", "isJSDevModeEnabled", "setJSDevModeEnabled", "isJSMinifyEnabled", "setJSMinifyEnabled", "isRemoteJSDebugEnabled", "setRemoteJSDebugEnabled", "isStartSamplingProfilerOnInit", "isStartSamplingProfilerOnInit$annotations", "()V", "setStartSamplingProfilerOnInit", "packagerConnectionSettings", "Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;", "getPackagerConnectionSettings", "()Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;", "preferences", "Landroid/content/SharedPreferences;", "addMenuItem", "", "title", "", "onSharedPreferenceChanged", "sharedPreferences", SDKConstants.PARAM_KEY, "Companion", "Listener", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DevInternalSettings implements DeveloperSettings, SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String PREFS_ANIMATIONS_DEBUG_KEY = "animations_debug";
    private static final String PREFS_FPS_DEBUG_KEY = "fps_debug";
    private static final String PREFS_HOT_MODULE_REPLACEMENT_KEY = "hot_module_replacement";
    private static final String PREFS_INSPECTOR_DEBUG_KEY = "inspector_debug";
    private static final String PREFS_JS_DEV_MODE_DEBUG_KEY = "js_dev_mode_debug";
    private static final String PREFS_JS_MINIFY_DEBUG_KEY = "js_minify_debug";
    private static final String PREFS_REMOTE_JS_DEBUG_KEY = "remote_js_debug";
    private boolean isDeviceDebugEnabled;
    private boolean isStartSamplingProfilerOnInit;
    private final Listener listener;
    private final PackagerConnectionSettings packagerConnectionSettings;
    private final SharedPreferences preferences;

    /* compiled from: DevInternalSettings.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/DevInternalSettings$Listener;", "", "onInternalSettingsChanged", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onInternalSettingsChanged();
    }

    @Deprecated(message = "Legacy sampling profiler is no longer supported - This field will be removed in React Native 0.77")
    public static /* synthetic */ void isStartSamplingProfilerOnInit$annotations() {
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void addMenuItem(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setAnimationFpsDebugEnabled(boolean z) {
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setJSMinifyEnabled(boolean z) {
    }

    public DevInternalSettings(Context applicationContext, Listener listener) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.listener = listener;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.preferences = defaultSharedPreferences;
        this.packagerConnectionSettings = new PackagerConnectionSettings(applicationContext);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.isDeviceDebugEnabled = ReactBuildConfig.DEBUG;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public PackagerConnectionSettings getPackagerConnectionSettings() {
        return this.packagerConnectionSettings;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isFpsDebugEnabled() {
        return this.preferences.getBoolean(PREFS_FPS_DEBUG_KEY, false);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setFpsDebugEnabled(boolean z) {
        this.preferences.edit().putBoolean(PREFS_FPS_DEBUG_KEY, z).apply();
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isAnimationFpsDebugEnabled() {
        return this.preferences.getBoolean(PREFS_ANIMATIONS_DEBUG_KEY, false);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSDevModeEnabled() {
        return this.preferences.getBoolean(PREFS_JS_DEV_MODE_DEBUG_KEY, true);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setJSDevModeEnabled(boolean z) {
        this.preferences.edit().putBoolean(PREFS_JS_DEV_MODE_DEBUG_KEY, z).apply();
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSMinifyEnabled() {
        return this.preferences.getBoolean(PREFS_JS_MINIFY_DEBUG_KEY, false);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        if (this.listener != null) {
            if (Intrinsics.areEqual(PREFS_FPS_DEBUG_KEY, key) || Intrinsics.areEqual(PREFS_JS_DEV_MODE_DEBUG_KEY, key) || Intrinsics.areEqual(PREFS_JS_MINIFY_DEBUG_KEY, key)) {
                this.listener.onInternalSettingsChanged();
            }
        }
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isElementInspectorEnabled() {
        return this.preferences.getBoolean(PREFS_INSPECTOR_DEBUG_KEY, false);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setElementInspectorEnabled(boolean z) {
        this.preferences.edit().putBoolean(PREFS_INSPECTOR_DEBUG_KEY, z).apply();
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    /* renamed from: isDeviceDebugEnabled, reason: from getter */
    public boolean getIsDeviceDebugEnabled() {
        return this.isDeviceDebugEnabled;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setDeviceDebugEnabled(boolean z) {
        this.isDeviceDebugEnabled = z;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isRemoteJSDebugEnabled() {
        return this.preferences.getBoolean(PREFS_REMOTE_JS_DEBUG_KEY, false);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setRemoteJSDebugEnabled(boolean z) {
        this.preferences.edit().putBoolean(PREFS_REMOTE_JS_DEBUG_KEY, z).apply();
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    /* renamed from: isStartSamplingProfilerOnInit, reason: from getter */
    public boolean getIsStartSamplingProfilerOnInit() {
        return this.isStartSamplingProfilerOnInit;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setStartSamplingProfilerOnInit(boolean z) {
        this.isStartSamplingProfilerOnInit = z;
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isHotModuleReplacementEnabled() {
        return this.preferences.getBoolean(PREFS_HOT_MODULE_REPLACEMENT_KEY, true);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setHotModuleReplacementEnabled(boolean z) {
        this.preferences.edit().putBoolean(PREFS_HOT_MODULE_REPLACEMENT_KEY, z).apply();
    }
}
