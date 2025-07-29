package com.facebook.fresco.animation.bitmap.preparation.loadframe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationLoaderExecutor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/AnimationLoaderExecutor;", "", "()V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "frameThreadFactory", "Ljava/util/concurrent/ThreadFactory;", "execute", "", "task", "Ljava/lang/Runnable;", "animated-drawable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimationLoaderExecutor {
    public static final AnimationLoaderExecutor INSTANCE = new AnimationLoaderExecutor();
    private static final ExecutorService executor;
    private static final ThreadFactory frameThreadFactory;

    private AnimationLoaderExecutor() {
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AnimationLoaderExecutor.frameThreadFactory$lambda$0(runnable);
            }
        };
        frameThreadFactory = threadFactory;
        executor = Executors.newCachedThreadPool(threadFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread frameThreadFactory$lambda$0(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        return thread;
    }

    public final void execute(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        executor.execute(task);
    }
}
