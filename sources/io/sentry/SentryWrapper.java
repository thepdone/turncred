package io.sentry;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/* loaded from: classes5.dex */
public final class SentryWrapper {
    public static <U> Callable<U> wrapCallable(final Callable<U> callable) {
        final IHub iHubM5833clone = Sentry.getCurrentHub().m5833clone();
        return new Callable() { // from class: io.sentry.SentryWrapper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SentryWrapper.lambda$wrapCallable$0(iHubM5833clone, callable);
            }
        };
    }

    static /* synthetic */ Object lambda$wrapCallable$0(IHub iHub, Callable callable) throws Exception {
        IHub currentHub = Sentry.getCurrentHub();
        Sentry.setCurrentHub(iHub);
        try {
            return callable.call();
        } finally {
            Sentry.setCurrentHub(currentHub);
        }
    }

    public static <U> Supplier<U> wrapSupplier(final Supplier<U> supplier) {
        final IHub iHubM5833clone = Sentry.getCurrentHub().m5833clone();
        return new Supplier() { // from class: io.sentry.SentryWrapper$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return SentryWrapper.lambda$wrapSupplier$1(iHubM5833clone, supplier);
            }
        };
    }

    static /* synthetic */ Object lambda$wrapSupplier$1(IHub iHub, Supplier supplier) {
        IHub currentHub = Sentry.getCurrentHub();
        Sentry.setCurrentHub(iHub);
        try {
            return supplier.get();
        } finally {
            Sentry.setCurrentHub(currentHub);
        }
    }
}
