package io.sentry.metrics;

/* loaded from: classes5.dex */
public enum MetricType {
    Counter("c"),
    Gauge("g"),
    Distribution("d"),
    Set("s");

    final String statsdCode;

    MetricType(String str) {
        this.statsdCode = str;
    }
}
