package io.sentry.util;

import io.sentry.SentryIntegrationPackageStorage;

/* loaded from: classes5.dex */
public final class IntegrationUtils {
    public static void addIntegrationToSdkVersion(String str) {
        SentryIntegrationPackageStorage.getInstance().addIntegration(str);
    }
}
