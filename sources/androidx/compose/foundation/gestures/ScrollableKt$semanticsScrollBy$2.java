package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2", f = "Scrollable.kt", i = {}, l = {967}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class ScrollableKt$semanticsScrollBy$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref.FloatRef $previousValue;
    final /* synthetic */ ScrollingLogic $this_semanticsScrollBy;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableKt$semanticsScrollBy$2(ScrollingLogic scrollingLogic, long j, Ref.FloatRef floatRef, Continuation<? super ScrollableKt$semanticsScrollBy$2> continuation) {
        super(2, continuation);
        this.$this_semanticsScrollBy = scrollingLogic;
        this.$offset = j;
        this.$previousValue = floatRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(this.$this_semanticsScrollBy, this.$offset, this.$previousValue, continuation);
        scrollableKt$semanticsScrollBy$2.L$0 = obj;
        return scrollableKt$semanticsScrollBy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollableKt$semanticsScrollBy$2) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
            float fM819toFloatk4lQ0M = this.$this_semanticsScrollBy.m819toFloatk4lQ0M(this.$offset);
            final Ref.FloatRef floatRef = this.$previousValue;
            final ScrollingLogic scrollingLogic = this.$this_semanticsScrollBy;
            this.label = 1;
            if (SuspendAnimationKt.animate$default(0.0f, fM819toFloatk4lQ0M, 0.0f, null, new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2) {
                    invoke(f.floatValue(), f2.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f, float f2) {
                    float f3 = f - floatRef.element;
                    ScrollingLogic scrollingLogic2 = scrollingLogic;
                    floatRef.element += scrollingLogic2.reverseIfNeeded(scrollingLogic2.m819toFloatk4lQ0M(nestedScrollScope.mo775scrollByOzD1aCk(scrollingLogic2.m820toOffsettuRUvjQ(scrollingLogic2.reverseIfNeeded(f3)), NestedScrollSource.INSTANCE.m3379getUserInputWNlRxjI())));
                }
            }, this, 12, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
