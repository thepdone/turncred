package io.sentry.internal.modules;

import java.util.Map;

/* loaded from: classes5.dex */
public final class NoOpModulesLoader implements IModulesLoader {
    private static final NoOpModulesLoader instance = new NoOpModulesLoader();

    @Override // io.sentry.internal.modules.IModulesLoader
    public Map<String, String> getOrLoadModules() {
        return null;
    }

    public static NoOpModulesLoader getInstance() {
        return instance;
    }

    private NoOpModulesLoader() {
    }
}
