package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {

    @CheckForNull
    private ListenableFuture<V> delegateRef;

    @CheckForNull
    private ScheduledFuture<?> timer;

    static <V> ListenableFuture<V> create(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.timer = scheduledExecutorService.schedule(fire, j, timeUnit);
        listenableFuture.addListener(fire, MoreExecutors.directExecutor());
        return timeoutFuture;
    }

    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    private static final class Fire<V> implements Runnable {

        @CheckForNull
        TimeoutFuture<V> timeoutFutureRef;

        Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<? extends V> listenableFuture;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null || (listenableFuture = ((TimeoutFuture) timeoutFuture).delegateRef) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (!listenableFuture.isDone()) {
                try {
                    ScheduledFuture scheduledFuture = ((TimeoutFuture) timeoutFuture).timer;
                    ((TimeoutFuture) timeoutFuture).timer = null;
                    String string = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (jAbs > 10) {
                                String strValueOf = String.valueOf("Timed out");
                                string = new StringBuilder(String.valueOf(strValueOf).length() + 66).append(strValueOf).append(" (timeout delayed by ").append(jAbs).append(" ms after scheduled time)").toString();
                            }
                        } catch (Throwable th) {
                            timeoutFuture.setException(new TimeoutFutureException(string));
                            throw th;
                        }
                    }
                    String strValueOf2 = String.valueOf(string);
                    String strValueOf3 = String.valueOf(listenableFuture);
                    timeoutFuture.setException(new TimeoutFutureException(new StringBuilder(String.valueOf(strValueOf2).length() + 2 + String.valueOf(strValueOf3).length()).append(strValueOf2).append(": ").append(strValueOf3).toString()));
                    return;
                } finally {
                    listenableFuture.cancel(true);
                }
            }
            timeoutFuture.setFuture(listenableFuture);
        }
    }

    private static final class TimeoutFutureException extends TimeoutException {
        private TimeoutFutureException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    protected String pendingToString() {
        ListenableFuture<V> listenableFuture = this.delegateRef;
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (listenableFuture == null) {
            return null;
        }
        String strValueOf = String.valueOf(listenableFuture);
        String string = new StringBuilder(String.valueOf(strValueOf).length() + 14).append("inputFuture=[").append(strValueOf).append("]").toString();
        if (scheduledFuture == null) {
            return string;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return string;
        }
        String strValueOf2 = String.valueOf(string);
        return new StringBuilder(String.valueOf(strValueOf2).length() + 43).append(strValueOf2).append(", remaining delay=[").append(delay).append(" ms]").toString();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }
}
