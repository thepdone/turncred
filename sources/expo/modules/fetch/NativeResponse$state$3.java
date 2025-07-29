package expo.modules.fetch;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NativeResponse.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.fetch.NativeResponse$state$3", f = "NativeResponse.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class NativeResponse$state$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseState $value;
    int label;
    final /* synthetic */ NativeResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeResponse$state$3(NativeResponse nativeResponse, ResponseState responseState, Continuation<? super NativeResponse$state$3> continuation) {
        super(2, continuation);
        this.this$0 = nativeResponse;
        this.$value = responseState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeResponse$state$3(this.this$0, this.$value, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NativeResponse$state$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = this.this$0.stateChangeOnceListeners;
            final ResponseState responseState = this.$value;
            CollectionsKt.removeAll(list, (Function1) new Function1<Function1<? super ResponseState, ? extends Boolean>, Boolean>() { // from class: expo.modules.fetch.NativeResponse$state$3.1
                {
                    super(1);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Boolean invoke2(Function1<? super ResponseState, Boolean> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.invoke(responseState);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Function1<? super ResponseState, ? extends Boolean> function1) {
                    return invoke2((Function1<? super ResponseState, Boolean>) function1);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
