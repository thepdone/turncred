package io.sentry;

/* loaded from: classes5.dex */
public interface IPerformanceSnapshotCollector extends IPerformanceCollector {
    void collect(PerformanceCollectionData performanceCollectionData);

    void setup();
}
