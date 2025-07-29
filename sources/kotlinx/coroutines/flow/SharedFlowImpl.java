package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* compiled from: SharedFlow.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001iB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0096@¢\u0006\u0002\u00100J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0016\u00105\u001a\u0002062\u0006\u00103\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u00107J\u0015\u00108\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00104J\u0015\u00109\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00104J\b\u0010:\u001a\u000206H\u0002J\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0012\u0010=\u001a\u0002062\b\u0010>\u001a\u0004\u0018\u00010\u0010H\u0002J7\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0010\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002¢\u0006\u0002\u0010CJ\u0016\u0010D\u001a\u0002062\u0006\u00103\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u00107J\u0010\u0010E\u001a\u0002062\u0006\u0010F\u001a\u00020GH\u0002J\r\u0010H\u001a\u00020\u0013H\u0000¢\u0006\u0002\bIJ%\u0010J\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000f2\u0006\u0010L\u001a\u00020\u0013H\u0000¢\u0006\u0004\bM\u0010NJ(\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u0013H\u0002J\b\u0010T\u001a\u000206H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010\u00102\u0006\u0010V\u001a\u00020\u0003H\u0002J\u0010\u0010W\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0003H\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010\u00102\u0006\u0010Y\u001a\u00020\u0013H\u0002J\u0016\u0010Z\u001a\u0002062\u0006\u0010V\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010[J1\u0010\\\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000f2\u0014\u0010]\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000fH\u0002¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020\u0003H\u0014J\u001d\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000f2\u0006\u0010a\u001a\u00020\bH\u0014¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u000206H\u0016J&\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006j"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "replayIndex", "", "minCollectorIndex", "bufferSize", "queueSize", "head", "getHead", "()J", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "bufferEndIndex", "getBufferEndIndex", "queueEndIndex", "getQueueEndIndex", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", "", "value", "(Ljava/lang/Object;)Z", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmitLocked", "tryEmitNoCollectorsLocked", "dropOldestLocked", "correctCollectorIndexesOnDropOldest", "newHead", "enqueueLocked", "item", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "emitSuspend", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "updateCollectorIndexLocked", "Lkotlin/coroutines/Continuation;", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "cleanupTailLocked", "tryTakeValue", "slot", "tryPeekLocked", "getPeekedValueLockedAt", FirebaseAnalytics.Param.INDEX, "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findSlotsToResumeLocked", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "createSlot", "createSlotArray", RRWebVideoEvent.JsonKeys.SIZE, "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {387, 394, 397}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = sharedFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowImpl.collect$suspendImpl(this.this$0, null, this);
        }
    }

    protected static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return emit$suspendImpl(this, t, continuation);
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    protected final T getLastReplayedLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        return (T) SharedFlowKt.getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ <T> java.lang.Object collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.FlowCollector<? super T> r9, kotlin.coroutines.Continuation<?> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArrFindSlotsToResumeLocked = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(value)) {
                continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArrFindSlotsToResumeLocked) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, T t, Continuation<? super Unit> continuation) {
        Object objEmitSuspend;
        return (!sharedFlowImpl.tryEmit(t) && (objEmitSuspend = sharedFlowImpl.emitSuspend(t, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objEmitSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T value) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        enqueueLocked(value);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        if (DebugKt.getASSERTIONS_ENABLED() && getNCollectors() != 0) {
            throw new AssertionError();
        }
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(value);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
        if (DebugKt.getASSERTIONS_ENABLED() && getHead() != head) {
            throw new AssertionError();
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowImpl<T> sharedFlowImpl = this;
        if (((AbstractSharedFlow) sharedFlowImpl).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) sharedFlowImpl).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    if (sharedFlowSlot.index >= 0 && sharedFlowSlot.index < newHead) {
                        sharedFlowSlot.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object item) {
        int totalSize = getTotalSize();
        Object[] objArrGrowBuffer = this.buffer;
        if (objArrGrowBuffer == null) {
            objArrGrowBuffer = growBuffer(null, 0, 2);
        } else if (totalSize >= objArrGrowBuffer.length) {
            objArrGrowBuffer = growBuffer(objArrGrowBuffer, totalSize, objArrGrowBuffer.length * 2);
        }
        SharedFlowKt.setBufferAt(objArrGrowBuffer, getHead() + totalSize, item);
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        if (newSize <= 0) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer == null) {
            return objArr;
        }
        long head = getHead();
        for (int i = 0; i < curSize; i++) {
            long j = i + head;
            SharedFlowKt.setBufferAt(objArr, j, SharedFlowKt.getBufferAt(curBuffer, j));
        }
        return objArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j = this.replayIndex;
        if (j < this.minCollectorIndex) {
            this.minCollectorIndex = j;
        }
        return j;
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        int iMin;
        long j;
        long j2;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (DebugKt.getASSERTIONS_ENABLED() && oldIndex < this.minCollectorIndex) {
            throw new AssertionError();
        }
        if (oldIndex > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j3 = this.bufferSize + head;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j3++;
        }
        SharedFlowImpl<T> sharedFlowImpl = this;
        if (((AbstractSharedFlow) sharedFlowImpl).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) sharedFlowImpl).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    if (sharedFlowSlot.index >= 0 && sharedFlowSlot.index < j3) {
                        j3 = sharedFlowSlot.index;
                    }
                }
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED() && j3 < this.minCollectorIndex) {
            throw new AssertionError();
        }
        if (j3 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        if (getNCollectors() > 0) {
            iMin = Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j3)));
        } else {
            iMin = this.queueSize;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j4 = this.queueSize + bufferEndIndex;
        if (iMin > 0) {
            continuationArr = new Continuation[iMin];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            long j5 = bufferEndIndex;
            int i = 0;
            while (true) {
                if (bufferEndIndex >= j4) {
                    j = j3;
                    break;
                }
                Object bufferAt = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                j = j3;
                if (bufferAt != SharedFlowKt.NO_VALUE) {
                    Intrinsics.checkNotNull(bufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) bufferAt;
                    int i2 = i + 1;
                    continuationArr[i] = emitter.cont;
                    SharedFlowKt.setBufferAt(objArr, bufferEndIndex, SharedFlowKt.NO_VALUE);
                    SharedFlowKt.setBufferAt(objArr, j5, emitter.value);
                    j2 = 1;
                    j5++;
                    if (i2 >= iMin) {
                        break;
                    }
                    i = i2;
                } else {
                    j2 = 1;
                }
                bufferEndIndex += j2;
                j3 = j;
            }
            bufferEndIndex = j5;
        } else {
            j = j3;
        }
        int i3 = (int) (bufferEndIndex - head);
        long j6 = getNCollectors() == 0 ? bufferEndIndex : j;
        long jMax = Math.max(this.replayIndex, bufferEndIndex - Math.min(this.replay, i3));
        if (this.bufferCapacity == 0 && jMax < j4) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.getBufferAt(objArr2, jMax), SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                jMax++;
            }
        }
        updateBufferLocked(jMax, j6, bufferEndIndex, j4);
        cleanupTailLocked();
        return !(continuationArr.length == 0) ? findSlotsToResumeLocked(continuationArr) : continuationArr;
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long jMin = Math.min(newMinCollectorIndex, newReplayIndex);
        if (DebugKt.getASSERTIONS_ENABLED() && jMin < getHead()) {
            throw new AssertionError();
        }
        for (long head = getHead(); head < jMin; head++) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.setBufferAt(objArr, head, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - jMin);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
        if (DebugKt.getASSERTIONS_ENABLED() && this.bufferSize < 0) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && this.queueSize < 0) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && this.replayIndex > getHead() + this.bufferSize) {
            throw new AssertionError();
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            while (this.queueSize > 0 && SharedFlowKt.getBufferAt(objArr, (getHead() + getTotalSize()) - 1) == SharedFlowKt.NO_VALUE) {
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + getTotalSize(), null);
            }
        }
    }

    private final Object tryTakeValue(SharedFlowSlot slot) {
        Object obj;
        Continuation<Unit>[] continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long jTryPeekLocked = tryPeekLocked(slot);
            if (jTryPeekLocked < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j = slot.index;
                Object peekedValueLockedAt = getPeekedValueLockedAt(jTryPeekLocked);
                slot.index = jTryPeekLocked + 1;
                continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                obj = peekedValueLockedAt;
            }
        }
        for (Continuation<Unit> continuation : continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot slot) {
        long j = slot.index;
        if (j < getBufferEndIndex()) {
            return j;
        }
        if (this.bufferCapacity <= 0 && j <= getHead() && this.queueSize != 0) {
            return j;
        }
        return -1L;
    }

    private final Object getPeekedValueLockedAt(long index) {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        Object bufferAt = SharedFlowKt.getBufferAt(objArr, index);
        return bufferAt instanceof Emitter ? ((Emitter) bufferAt).value : bufferAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] resumesIn) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = resumesIn.length;
        SharedFlowImpl<T> sharedFlowImpl = this;
        if (((AbstractSharedFlow) sharedFlowImpl).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) sharedFlowImpl).slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i = 0;
            resumesIn = resumesIn;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(resumesIn, Math.max(2, resumesIn.length * 2));
                        Intrinsics.checkNotNullExpressionValue(CopyOf, "copyOf(...)");
                        resumesIn = CopyOf;
                    }
                    resumesIn[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                resumesIn = resumesIn;
            }
        }
        return resumesIn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", FirebaseAnalytics.Param.INDEX, "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            for (int i = 0; i < replaySize; i++) {
                arrayList.add(SharedFlowKt.getBufferAt(objArr, this.replayIndex + i));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitSuspend(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArrFindSlotsToResumeLocked;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Continuation<Unit>[] continuationArrFindSlotsToResumeLocked2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t)) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
                continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                emitter = null;
            } else {
                Emitter emitter2 = new Emitter(this, getTotalSize() + getHead(), t, cancellableContinuationImpl2);
                enqueueLocked(emitter2);
                this.queueSize++;
                if (this.bufferCapacity == 0) {
                    continuationArrFindSlotsToResumeLocked2 = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                }
                continuationArrFindSlotsToResumeLocked = continuationArrFindSlotsToResumeLocked2;
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl2, emitter);
        }
        for (Continuation<Unit> continuation2 : continuationArrFindSlotsToResumeLocked) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            if (SharedFlowKt.getBufferAt(objArr, emitter.index) != emitter) {
                return;
            }
            SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        synchronized (this) {
            if (tryPeekLocked(sharedFlowSlot) < 0) {
                sharedFlowSlot.cont = cancellableContinuationImpl2;
                sharedFlowSlot.cont = cancellableContinuationImpl2;
            } else {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }
}
