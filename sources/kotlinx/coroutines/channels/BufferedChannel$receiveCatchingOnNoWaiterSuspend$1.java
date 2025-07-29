package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BufferedChannel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {0, 0, 0, 0}, l = {3117}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", n = {"this", "segment", FirebaseAnalytics.Param.INDEX, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR}, s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes2.dex */
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7462receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m7462receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM7462receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7462receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m7471boximpl(objM7462receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
