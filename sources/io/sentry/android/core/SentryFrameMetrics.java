package io.sentry.android.core;

/* loaded from: classes5.dex */
final class SentryFrameMetrics {
    private int frozenFrameCount;
    private long frozenFrameDelayNanos;
    private int slowFrameCount;
    private long slowFrameDelayNanos;
    private long totalDurationNanos;

    public SentryFrameMetrics() {
    }

    public SentryFrameMetrics(int i, long j, int i2, long j2, long j3) {
        this.slowFrameCount = i;
        this.slowFrameDelayNanos = j;
        this.frozenFrameCount = i2;
        this.frozenFrameDelayNanos = j2;
        this.totalDurationNanos = j3;
    }

    public void addFrame(long j, long j2, boolean z, boolean z2) {
        this.totalDurationNanos += j;
        if (z2) {
            this.frozenFrameDelayNanos += j2;
            this.frozenFrameCount++;
        } else if (z) {
            this.slowFrameDelayNanos += j2;
            this.slowFrameCount++;
        }
    }

    public int getSlowFrameCount() {
        return this.slowFrameCount;
    }

    public int getFrozenFrameCount() {
        return this.frozenFrameCount;
    }

    public long getSlowFrameDelayNanos() {
        return this.slowFrameDelayNanos;
    }

    public long getFrozenFrameDelayNanos() {
        return this.frozenFrameDelayNanos;
    }

    public int getSlowFrozenFrameCount() {
        return this.slowFrameCount + this.frozenFrameCount;
    }

    public long getTotalDurationNanos() {
        return this.totalDurationNanos;
    }

    public void clear() {
        this.slowFrameCount = 0;
        this.slowFrameDelayNanos = 0L;
        this.frozenFrameCount = 0;
        this.frozenFrameDelayNanos = 0L;
        this.totalDurationNanos = 0L;
    }

    public SentryFrameMetrics duplicate() {
        return new SentryFrameMetrics(this.slowFrameCount, this.slowFrameDelayNanos, this.frozenFrameCount, this.frozenFrameDelayNanos, this.totalDurationNanos);
    }

    public SentryFrameMetrics diffTo(SentryFrameMetrics sentryFrameMetrics) {
        return new SentryFrameMetrics(this.slowFrameCount - sentryFrameMetrics.slowFrameCount, this.slowFrameDelayNanos - sentryFrameMetrics.slowFrameDelayNanos, this.frozenFrameCount - sentryFrameMetrics.frozenFrameCount, this.frozenFrameDelayNanos - sentryFrameMetrics.frozenFrameDelayNanos, this.totalDurationNanos - sentryFrameMetrics.totalDurationNanos);
    }

    public boolean containsValidData() {
        return this.slowFrameCount >= 0 && this.slowFrameDelayNanos >= 0 && this.frozenFrameCount >= 0 && this.frozenFrameDelayNanos >= 0 && this.totalDurationNanos >= 0;
    }
}
