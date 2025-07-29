package expo.modules.core.interfaces;

import expo.modules.core.ModuleRegistry;

/* loaded from: classes5.dex */
public interface RegistryLifecycleListener {
    default void onCreate(ModuleRegistry moduleRegistry) {
    }

    default void onDestroy() {
    }
}
