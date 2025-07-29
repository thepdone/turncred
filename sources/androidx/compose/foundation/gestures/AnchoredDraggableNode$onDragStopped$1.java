package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.unit.Velocity;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", i = {}, l = {275, 277}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> anchoredDraggableNode, long j, Continuation<? super AnchoredDraggableNode$onDragStopped$1> continuation) {
        super(2, continuation);
        this.this$0 = anchoredDraggableNode;
        this.$velocity = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AnchoredDraggableNode anchoredDraggableNode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (((AnchoredDraggableNode) this.this$0).overscrollEffect != null) {
                OverscrollEffect overscrollEffect = ((AnchoredDraggableNode) this.this$0).overscrollEffect;
                Intrinsics.checkNotNull(overscrollEffect);
                this.label = 2;
                if (overscrollEffect.mo538applyToFlingBMRW4eQ(this.this$0.m705reverseIfNeededAH228Gc(this.$velocity), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                AnchoredDraggableNode anchoredDraggableNode2 = this.this$0;
                AnchoredDraggableState anchoredDraggableState = anchoredDraggableNode2.state;
                AnchoredDraggableNode<T> anchoredDraggableNode3 = this.this$0;
                this.L$0 = anchoredDraggableNode2;
                this.label = 1;
                Object obj2 = anchoredDraggableState.settle(anchoredDraggableNode3.m707toFloatTH1AsA0(anchoredDraggableNode3.m705reverseIfNeededAH228Gc(this.$velocity)), this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anchoredDraggableNode = anchoredDraggableNode2;
                obj = obj2;
                anchoredDraggableNode.m710toVelocityadjELrA(((Number) obj).floatValue());
            }
        } else if (i == 1) {
            anchoredDraggableNode = (AnchoredDraggableNode) this.L$0;
            ResultKt.throwOnFailure(obj);
            anchoredDraggableNode.m710toVelocityadjELrA(((Number) obj).floatValue());
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", ExifInterface.GPS_DIRECTION_TRUE, "availableVelocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", i = {0}, l = {280}, m = "invokeSuspend", n = {"availableVelocity"}, s = {"J$0"})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
        /* synthetic */ long J$0;
        Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.J$0 = ((Velocity) obj).getPackedValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
            return m714invokesFctU(velocity.getPackedValue(), continuation);
        }

        /* renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m714invokesFctU(long j, Continuation<? super Velocity> continuation) {
            return ((AnonymousClass1) create(Velocity.m4965boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnchoredDraggableNode anchoredDraggableNode;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j2 = this.J$0;
                AnchoredDraggableNode anchoredDraggableNode2 = this.this$0;
                this.L$0 = anchoredDraggableNode2;
                this.J$0 = j2;
                this.label = 1;
                Object obj2 = anchoredDraggableNode2.state.settle(this.this$0.m707toFloatTH1AsA0(j2), this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anchoredDraggableNode = anchoredDraggableNode2;
                obj = obj2;
                j = j2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                anchoredDraggableNode = (AnchoredDraggableNode) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            long jM710toVelocityadjELrA = anchoredDraggableNode.m710toVelocityadjELrA(((Number) obj).floatValue());
            float fRequireOffset = ((AnchoredDraggableNode) this.this$0).state.requireOffset();
            float fMinAnchor = ((AnchoredDraggableNode) this.this$0).state.getAnchors().minAnchor();
            if (fRequireOffset >= ((AnchoredDraggableNode) this.this$0).state.getAnchors().maxAnchor() || fRequireOffset <= fMinAnchor) {
                j = jM710toVelocityadjELrA;
            }
            return Velocity.m4965boximpl(j);
        }
    }
}
