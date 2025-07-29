package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: StateFlow.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0015\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\"H\u0016J\u001c\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0096@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0003H\u0014J\u001d\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030,2\u0006\u0010-\u001a\u00020\u000eH\u0014¢\u0006\u0002\u0010.J&\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0000002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u000205H\u0016R\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\nR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00066"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "<init>", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "sequence", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "tryEmit", "(Ljava/lang/Object;)Z", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSlot", "createSlotArray", "", RRWebVideoEvent.JsonKeys.SIZE, "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    private int sequence;

    /* compiled from: StateFlow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {389, 401, 406}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StateFlowImpl<T> stateFlowImpl, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = stateFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) _state$volatile$FU.get(this);
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T expect, T update) {
        if (expect == null) {
            expect = (T) NullSurrogateKt.NULL;
        }
        if (update == null) {
            update = (T) NullSurrogateKt.NULL;
        }
        return updateState(expect, update);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        setValue(value);
        return true;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:38:0x00b8, B:40:0x00be], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:40:0x00be, B:38:0x00b8], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[Catch: all -> 0x0074, TryCatch #1 {all -> 0x0074, blocks: (B:14:0x003f, B:34:0x00a9, B:36:0x00b3, B:38:0x00b8, B:48:0x00d9, B:50:0x00df, B:40:0x00be, B:44:0x00c5, B:19:0x005d, B:22:0x0070, B:33:0x0098), top: B:59:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b8 A[Catch: all -> 0x0074, TryCatch #1 {all -> 0x0074, blocks: (B:14:0x003f, B:34:0x00a9, B:36:0x00b3, B:38:0x00b8, B:48:0x00d9, B:50:0x00df, B:40:0x00be, B:44:0x00c5, B:19:0x005d, B:22:0x0070, B:33:0x0098), top: B:59:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00df A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #1 {all -> 0x0074, blocks: (B:14:0x003f, B:34:0x00a9, B:36:0x00b3, B:38:0x00b8, B:48:0x00d9, B:50:0x00df, B:40:0x00be, B:44:0x00c5, B:19:0x005d, B:22:0x0070, B:33:0x0098), top: B:59:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00dd -> B:34:0x00a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ef -> B:34:0x00a9). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r11, kotlin.coroutines.Continuation<?> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }

    private final boolean updateState(Object expectedState, Object newState) {
        int i;
        StateFlowSlot[] slots;
        synchronized (this) {
            Object obj = _state$volatile$FU.get(this);
            if (expectedState != null && !Intrinsics.areEqual(obj, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(obj, newState)) {
                return true;
            }
            _state$volatile$FU.set(this, newState);
            int i2 = this.sequence;
            if ((i2 & 1) == 0) {
                int i3 = i2 + 1;
                this.sequence = i3;
                StateFlowSlot[] slots2 = getSlots();
                Unit unit = Unit.INSTANCE;
                while (true) {
                    StateFlowSlot[] stateFlowSlotArr = slots2;
                    if (stateFlowSlotArr != null) {
                        for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                            if (stateFlowSlot != null) {
                                stateFlowSlot.makePending();
                            }
                        }
                    }
                    synchronized (this) {
                        i = this.sequence;
                        if (i == i3) {
                            this.sequence = i3 + 1;
                            return true;
                        }
                        slots = getSlots();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    slots2 = slots;
                    i3 = i;
                }
            } else {
                this.sequence = i2 + 2;
                return true;
            }
        }
    }
}
