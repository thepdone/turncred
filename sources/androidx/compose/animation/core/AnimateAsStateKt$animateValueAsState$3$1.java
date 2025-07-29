package androidx.compose.animation.core;

import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* compiled from: AnimateAsState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", f = "AnimateAsState.kt", i = {0}, l = {419}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
/* loaded from: classes.dex */
final class AnimateAsStateKt$animateValueAsState$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
    final /* synthetic */ Animatable<T, V> $animatable;
    final /* synthetic */ Channel<T> $channel;
    final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AnimateAsStateKt$animateValueAsState$3$1(Channel<T> channel, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super AnimateAsStateKt$animateValueAsState$3$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$animatable = animatable;
        this.$animSpec$delegate = state;
        this.$listener$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimateAsStateKt$animateValueAsState$3$1 animateAsStateKt$animateValueAsState$3$1 = new AnimateAsStateKt$animateValueAsState$3$1(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
        animateAsStateKt$animateValueAsState$3$1.L$0 = obj;
        return animateAsStateKt$animateValueAsState$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimateAsStateKt$animateValueAsState$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003d -> B:12:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 1
            if (r1 == 0) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r1 = r13.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r13.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r14)
            r4 = r14
            goto L40
        L18:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L20:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r1 = r13.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.channels.Channel<T> r3 = r13.$channel
            kotlinx.coroutines.channels.ChannelIterator r3 = r3.iterator()
            r12 = r3
            r3 = r1
            r1 = r12
        L30:
            r4 = r13
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r13.L$0 = r3
            r13.L$1 = r1
            r13.label = r2
            java.lang.Object r4 = r1.hasNext(r4)
            if (r4 != r0) goto L40
            return r0
        L40:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L74
            java.lang.Object r4 = r1.next()
            kotlinx.coroutines.channels.Channel<T> r5 = r13.$channel
            java.lang.Object r5 = r5.mo7464tryReceivePtdJZtk()
            java.lang.Object r5 = kotlinx.coroutines.channels.ChannelResult.m7476getOrNullimpl(r5)
            if (r5 != 0) goto L5a
            r7 = r4
            goto L5b
        L5a:
            r7 = r5
        L5b:
            androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1 r4 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1
            androidx.compose.animation.core.Animatable<T, V> r8 = r13.$animatable
            androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<T>> r9 = r13.$animSpec$delegate
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<T, kotlin.Unit>> r10 = r13.$listener$delegate
            r11 = 0
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11)
            r8 = r4
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            r5 = r3
            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
            goto L30
        L74:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: AnimateAsState.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1", f = "AnimateAsState.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
        final /* synthetic */ Animatable<T, V> $animatable;
        final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
        final /* synthetic */ T $newTarget;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(T t, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newTarget = t;
            this.$animatable = animatable;
            this.$animSpec$delegate = state;
            this.$listener$delegate = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$newTarget, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!Intrinsics.areEqual(this.$newTarget, this.$animatable.getTargetValue())) {
                    this.label = 1;
                    if (Animatable.animateTo$default(this.$animatable, this.$newTarget, AnimateAsStateKt.animateValueAsState$lambda$6(this.$animSpec$delegate), null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Function1 function1AnimateValueAsState$lambda$4 = AnimateAsStateKt.animateValueAsState$lambda$4(this.$listener$delegate);
            if (function1AnimateValueAsState$lambda$4 != null) {
                function1AnimateValueAsState$lambda$4.invoke(this.$animatable.getValue());
            }
            return Unit.INSTANCE;
        }
    }
}
