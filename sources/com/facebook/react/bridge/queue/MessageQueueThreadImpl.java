package com.facebook.react.bridge.queue;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import com.facebook.react.common.futures.SimpleSettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public class MessageQueueThreadImpl implements MessageQueueThread {
    private final String mAssertionErrorMessage;
    private final MessageQueueThreadHandler mHandler;
    private volatile boolean mIsFinished;
    private final Looper mLooper;
    private final String mName;
    private final MessageQueueThreadPerfStats mPerfStats;

    private MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        this(str, looper, queueThreadExceptionHandler, null);
    }

    private MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler, MessageQueueThreadPerfStats messageQueueThreadPerfStats) {
        this.mIsFinished = false;
        this.mName = str;
        this.mLooper = looper;
        this.mHandler = new MessageQueueThreadHandler(looper, queueThreadExceptionHandler);
        this.mPerfStats = messageQueueThreadPerfStats;
        this.mAssertionErrorMessage = "Expected to be called from the '" + getName() + "' thread!";
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public boolean runOnQueue(Runnable runnable) {
        if (this.mIsFinished) {
            FLog.w("ReactNative", "Tried to enqueue runnable on already finished thread: '" + getName() + "... dropping Runnable.");
            return false;
        }
        this.mHandler.post(runnable);
        return true;
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public <T> Future<T> callOnQueue(final Callable<T> callable) {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        runOnQueue(new Runnable() { // from class: com.facebook.react.bridge.queue.MessageQueueThreadImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MessageQueueThreadImpl.lambda$callOnQueue$0(simpleSettableFuture, callable);
            }
        });
        return simpleSettableFuture;
    }

    static /* synthetic */ void lambda$callOnQueue$0(SimpleSettableFuture simpleSettableFuture, Callable callable) {
        try {
            simpleSettableFuture.set(callable.call());
        } catch (Exception e) {
            simpleSettableFuture.setException(e);
        }
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public boolean isOnThread() {
        return this.mLooper.getThread() == Thread.currentThread();
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public void assertIsOnThread() {
        SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage);
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public void assertIsOnThread(String str) {
        SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage + " " + str);
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public void quitSynchronous() throws InterruptedException {
        this.mIsFinished = true;
        this.mLooper.quit();
        if (this.mLooper.getThread() != Thread.currentThread()) {
            try {
                this.mLooper.getThread().join();
            } catch (InterruptedException unused) {
                throw new RuntimeException("Got interrupted waiting to join thread " + this.mName);
            }
        }
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public MessageQueueThreadPerfStats getPerfStats() {
        return this.mPerfStats;
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public void resetPerfStats() {
        assignToPerfStats(this.mPerfStats, -1L, -1L);
        runOnQueue(new Runnable() { // from class: com.facebook.react.bridge.queue.MessageQueueThreadImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetPerfStats$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPerfStats$1() {
        assignToPerfStats(this.mPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    public boolean isIdle() {
        return this.mLooper.getQueue().isIdle();
    }

    private static void assignToPerfStats(MessageQueueThreadPerfStats messageQueueThreadPerfStats, long j, long j2) {
        if (messageQueueThreadPerfStats == null) {
            return;
        }
        messageQueueThreadPerfStats.wallTime = j;
        messageQueueThreadPerfStats.cpuTime = j2;
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public String getName() {
        return this.mName;
    }

    /* renamed from: com.facebook.react.bridge.queue.MessageQueueThreadImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType;

        static {
            int[] iArr = new int[MessageQueueThreadSpec.ThreadType.values().length];
            $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType = iArr;
            try {
                iArr[MessageQueueThreadSpec.ThreadType.MAIN_UI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType[MessageQueueThreadSpec.ThreadType.NEW_BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static MessageQueueThreadImpl create(MessageQueueThreadSpec messageQueueThreadSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType[messageQueueThreadSpec.getThreadType().ordinal()];
        if (i == 1) {
            return createForMainThread(messageQueueThreadSpec.getName(), queueThreadExceptionHandler);
        }
        if (i == 2) {
            return startNewBackgroundThread(messageQueueThreadSpec.getName(), messageQueueThreadSpec.getStackSize(), queueThreadExceptionHandler);
        }
        throw new RuntimeException("Unknown thread type: " + messageQueueThreadSpec.getThreadType());
    }

    private static MessageQueueThreadImpl createForMainThread(String str, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        return new MessageQueueThreadImpl(str, Looper.getMainLooper(), queueThreadExceptionHandler);
    }

    private static MessageQueueThreadImpl startNewBackgroundThread(String str, long j, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        new Thread(null, new Runnable() { // from class: com.facebook.react.bridge.queue.MessageQueueThreadImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                MessageQueueThreadImpl.lambda$startNewBackgroundThread$2(simpleSettableFuture);
            }
        }, "mqt_" + str, j).start();
        Pair pair = (Pair) simpleSettableFuture.getOrThrow();
        return new MessageQueueThreadImpl(str, (Looper) pair.first, queueThreadExceptionHandler, (MessageQueueThreadPerfStats) pair.second);
    }

    static /* synthetic */ void lambda$startNewBackgroundThread$2(SimpleSettableFuture simpleSettableFuture) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(-4);
        Looper.prepare();
        MessageQueueThreadPerfStats messageQueueThreadPerfStats = new MessageQueueThreadPerfStats();
        assignToPerfStats(messageQueueThreadPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
        simpleSettableFuture.set(new Pair(Looper.myLooper(), messageQueueThreadPerfStats));
        Looper.loop();
    }
}
