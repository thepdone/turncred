package io.sentry.hints;

/* loaded from: classes5.dex */
public interface AbnormalExit {
    boolean ignoreCurrentThread();

    String mechanism();

    Long timestamp();
}
