package com.reactnativecommunity.asyncstorage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class SerialExecutor implements Executor {
    private final Executor executor;
    private Runnable mActive;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    public SerialExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() { // from class: com.reactnativecommunity.asyncstorage.SerialExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    SerialExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    synchronized void scheduleNext() {
        Runnable runnablePoll = this.mTasks.poll();
        this.mActive = runnablePoll;
        if (runnablePoll != null) {
            this.executor.execute(runnablePoll);
        }
    }
}
