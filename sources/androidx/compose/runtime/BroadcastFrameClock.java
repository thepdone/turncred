package androidx.compose.runtime;

import androidx.compose.runtime.MonotonicFrameClock;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: BroadcastFrameClock.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0014\u001a\u00020\u00042\f\b\u0002\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ(\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u0002H\u001e0 H\u0096@¢\u0006\u0002\u0010!R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "awaiters", "", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "failureCause", "", "hasAwaiters", "", "getHasAwaiters", "()Z", "hasAwaitersUnlocked", "Landroidx/compose/runtime/AtomicInt;", SentryStackFrame.JsonKeys.LOCK, "", "spareList", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fail", "cause", "sendFrame", "timeNanos", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FrameAwaiter", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private List<FrameAwaiter<?>> awaiters;
    private Throwable failureCause;
    private final AtomicInt hasAwaitersUnlocked;
    private final Object lock;
    private final Function0<Unit> onNewAwaiters;
    private List<FrameAwaiter<?>> spareList;

    public BroadcastFrameClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BroadcastFrameClock(Function0<Unit> function0) {
        this.onNewAwaiters = function0;
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
        this.hasAwaitersUnlocked = new AtomicInt(0);
    }

    public /* synthetic */ BroadcastFrameClock(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BroadcastFrameClock.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "getContinuation", "()Lkotlin/coroutines/Continuation;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "resume", "", "timeNanos", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class FrameAwaiter<R> {
        private final Continuation<R> continuation;
        private final Function1<Long, R> onFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public FrameAwaiter(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
            this.onFrame = function1;
            this.continuation = continuation;
        }

        public final Continuation<R> getContinuation() {
            return this.continuation;
        }

        public final Function1<Long, R> getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long timeNanos) {
            Object objM5937constructorimpl;
            Continuation<R> continuation = this.continuation;
            try {
                Result.Companion companion = Result.INSTANCE;
                FrameAwaiter<R> frameAwaiter = this;
                objM5937constructorimpl = Result.m5937constructorimpl(this.onFrame.invoke(Long.valueOf(timeNanos)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM5937constructorimpl = Result.m5937constructorimpl(ResultKt.createFailure(th));
            }
            continuation.resumeWith(objM5937constructorimpl);
        }
    }

    public final boolean getHasAwaiters() {
        return this.hasAwaitersUnlocked.get() != 0;
    }

    public final void sendFrame(long timeNanos) {
        synchronized (this.lock) {
            List<FrameAwaiter<?>> list = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = list;
            this.hasAwaitersUnlocked.set(0);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).resume(timeNanos);
            }
            list.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Throwable cause) {
        synchronized (this.lock) {
            if (this.failureCause != null) {
                return;
            }
            this.failureCause = cause;
            List<FrameAwaiter<?>> list = this.awaiters;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Continuation<?> continuation = list.get(i).getContinuation();
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(cause)));
            }
            this.awaiters.clear();
            this.hasAwaitersUnlocked.set(0);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(cancellationException);
    }

    public final void cancel(CancellationException cancellationException) {
        fail(cancellationException);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final FrameAwaiter frameAwaiter = new FrameAwaiter(function1, cancellableContinuationImpl2);
        synchronized (this.lock) {
            Throwable th = this.failureCause;
            if (th == null) {
                boolean zIsEmpty = this.awaiters.isEmpty();
                this.awaiters.add(frameAwaiter);
                if (zIsEmpty) {
                    this.hasAwaitersUnlocked.set(1);
                }
                cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th2) {
                        Object obj = this.this$0.lock;
                        BroadcastFrameClock broadcastFrameClock = this.this$0;
                        Object obj2 = frameAwaiter;
                        synchronized (obj) {
                            broadcastFrameClock.awaiters.remove(obj2);
                            if (broadcastFrameClock.awaiters.isEmpty()) {
                                broadcastFrameClock.hasAwaitersUnlocked.set(0);
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
                if (zIsEmpty && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                }
            } else {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(th)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
