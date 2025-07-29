package io.sentry;

/* loaded from: classes5.dex */
public final class ExperimentalOptions {
    private SentryReplayOptions sessionReplay;

    public ExperimentalOptions(boolean z) {
        this.sessionReplay = new SentryReplayOptions(z);
    }

    public SentryReplayOptions getSessionReplay() {
        return this.sessionReplay;
    }

    public void setSessionReplay(SentryReplayOptions sentryReplayOptions) {
        this.sessionReplay = sentryReplayOptions;
    }
}
