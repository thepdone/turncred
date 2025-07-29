package io.sentry;

import java.util.List;

/* loaded from: classes5.dex */
public final class NoOpTransactionPerformanceCollector implements TransactionPerformanceCollector {
    private static final NoOpTransactionPerformanceCollector instance = new NoOpTransactionPerformanceCollector();

    @Override // io.sentry.TransactionPerformanceCollector
    public void close() {
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public void onSpanFinished(ISpan iSpan) {
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public void onSpanStarted(ISpan iSpan) {
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public void start(ITransaction iTransaction) {
    }

    @Override // io.sentry.TransactionPerformanceCollector
    public List<PerformanceCollectionData> stop(ITransaction iTransaction) {
        return null;
    }

    public static NoOpTransactionPerformanceCollector getInstance() {
        return instance;
    }

    private NoOpTransactionPerformanceCollector() {
    }
}
