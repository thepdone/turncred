package com.facebook.react.common.futures;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.ProfilingTraceData;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleSettableFuture.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000f\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0011J \u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0002¢\u0006\u0002\u0010\u0016J\r\u0010\u0017\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0015\u0010\u001a\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006R\u0016\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/facebook/react/common/futures/SimpleSettableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Future;", "()V", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "readyLatch", "Ljava/util/concurrent/CountDownLatch;", "result", "Ljava/lang/Object;", "cancel", "", "mayInterruptIfRunning", "checkNotSet", "", "get", "()Ljava/lang/Object;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "getOrThrow", "isCancelled", "isDone", "set", "(Ljava/lang/Object;)V", "setException", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SimpleSettableFuture<T> implements Future<T> {
    private Exception exception;
    private final CountDownLatch readyLatch = new CountDownLatch(1);
    private T result;

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    public final void set(T result) {
        checkNotSet();
        this.result = result;
        this.readyLatch.countDown();
    }

    public final void setException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        checkNotSet();
        this.exception = exception;
        this.readyLatch.countDown();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.readyLatch.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        this.readyLatch.await();
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!this.readyLatch.await(timeout, unit)) {
            throw new TimeoutException("Timed out waiting for result");
        }
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        return this.result;
    }

    public final T getOrThrow() {
        try {
            return get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final T getOrThrow(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            return get(timeout, unit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException e3) {
            throw new RuntimeException(e3);
        }
    }

    private final void checkNotSet() {
        if (this.readyLatch.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }
}
