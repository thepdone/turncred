package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriorityThreadFactory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/core/PriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadPriority", "", "prefix", "", "addThreadNumber", "", "(ILjava/lang/String;Z)V", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PriorityThreadFactory implements ThreadFactory {
    private final boolean addThreadNumber;
    private final String prefix;
    private final AtomicInteger threadNumber;
    private final int threadPriority;

    public PriorityThreadFactory(int i) {
        this(i, null, false, 6, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriorityThreadFactory(int i, String prefix) {
        this(i, prefix, false, 4, null);
        Intrinsics.checkNotNullParameter(prefix, "prefix");
    }

    public PriorityThreadFactory(int i, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.threadPriority = i;
        this.prefix = prefix;
        this.addThreadNumber = z;
        this.threadNumber = new AtomicInteger(1);
    }

    public /* synthetic */ PriorityThreadFactory(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "PriorityThreadFactory" : str, (i2 & 4) != 0 ? true : z);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.core.PriorityThreadFactory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PriorityThreadFactory.newThread$lambda$0(this.f$0, runnable);
            }
        };
        if (this.addThreadNumber) {
            str = this.prefix + "-" + this.threadNumber.getAndIncrement();
        } else {
            str = this.prefix;
        }
        return new Thread(runnable2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newThread$lambda$0(PriorityThreadFactory this$0, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        try {
            Process.setThreadPriority(this$0.threadPriority);
        } catch (Throwable unused) {
        }
        runnable.run();
    }
}
