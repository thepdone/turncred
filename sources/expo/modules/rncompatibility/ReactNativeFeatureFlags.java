package expo.modules.rncompatibility;

import com.facebook.react.config.ReactFeatureFlags;
import kotlin.Metadata;

/* compiled from: ReactNativeFeatureFlags.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/rncompatibility/ReactNativeFeatureFlags;", "", "()V", "enableBridgelessArchitecture", "", "getEnableBridgelessArchitecture", "()Z", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactNativeFeatureFlags {
    public static final int $stable = 0;
    public static final ReactNativeFeatureFlags INSTANCE = new ReactNativeFeatureFlags();
    private static final boolean enableBridgelessArchitecture = ReactFeatureFlags.enableBridgelessArchitecture;

    private ReactNativeFeatureFlags() {
    }

    public final boolean getEnableBridgelessArchitecture() {
        return enableBridgelessArchitecture;
    }
}
