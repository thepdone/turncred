package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* compiled from: AbstractSharedFlow.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00060\u0004j\u0002`\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0018\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b2\u0006\u0010\u001b\u001a\u00020\rH$¢\u0006\u0002\u0010\u001cJ\r\u0010\u001d\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010!J\u001d\u0010\"\u001a\u00020\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0$H\u0084\bR4\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\b2\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\b@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "<init>", "()V", "value", "", "slots", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "nCollectors", "getNCollectors", "()I", "nextIndex", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlotArray", RRWebVideoEvent.JsonKeys.SIZE, "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "allocateSlot", "freeSlot", "", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "forEachSlotLocked", "block", "Lkotlin/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    private SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private S[] slots;

    protected abstract S createSlot();

    protected abstract S[] createSlotArray(int size);

    protected final S[] getSlots() {
        return this.slots;
    }

    protected final int getNCollectors() {
        return this.nCollectors;
    }

    protected final void forEachSlotLocked(Function1<? super S, Unit> block) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (this.nCollectors == 0 || (abstractSharedFlowSlotArr = this.slots) == null) {
            return;
        }
        for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
            if (abstractSharedFlowSlot != null) {
                block.invoke(abstractSharedFlowSlot);
            }
        }
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this._subscriptionCount;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.nCollectors);
                this._subscriptionCount = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }

    protected final S allocateSlot() {
        S s;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            S[] sArr = this.slots;
            if (sArr == null) {
                sArr = (S[]) createSlotArray(2);
                this.slots = sArr;
            } else if (this.nCollectors >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                this.slots = (S[]) ((AbstractSharedFlowSlot[]) objArrCopyOf);
                sArr = (S[]) ((AbstractSharedFlowSlot[]) objArrCopyOf);
            }
            int i = this.nextIndex;
            do {
                s = sArr[i];
                if (s == null) {
                    s = (S) createSlot();
                    sArr[i] = s;
                }
                i++;
                if (i >= sArr.length) {
                    i = 0;
                }
                Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s.allocateLocked(this));
            this.nextIndex = i;
            this.nCollectors++;
            subscriptionCountStateFlow = this._subscriptionCount;
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(1);
        }
        return s;
    }

    protected final void freeSlot(S slot) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i;
        Continuation<Unit>[] continuationArrFreeLocked;
        synchronized (this) {
            int i2 = this.nCollectors - 1;
            this.nCollectors = i2;
            subscriptionCountStateFlow = this._subscriptionCount;
            if (i2 == 0) {
                this.nextIndex = 0;
            }
            Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            continuationArrFreeLocked = slot.freeLocked(this);
        }
        for (Continuation<Unit> continuation : continuationArrFreeLocked) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(-1);
        }
    }
}
