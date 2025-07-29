package io.sentry.internal.debugmeta;

import java.util.List;
import java.util.Properties;

/* loaded from: classes5.dex */
public final class NoOpDebugMetaLoader implements IDebugMetaLoader {
    private static final NoOpDebugMetaLoader instance = new NoOpDebugMetaLoader();

    @Override // io.sentry.internal.debugmeta.IDebugMetaLoader
    public List<Properties> loadDebugMeta() {
        return null;
    }

    public static NoOpDebugMetaLoader getInstance() {
        return instance;
    }

    private NoOpDebugMetaLoader() {
    }
}
