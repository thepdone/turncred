package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import expo.modules.imagemanipulator.transformers.ImageTransformer;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* compiled from: ImageManipulatorContext.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000e\u0010\u0013\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/imagemanipulator/ManipulatorTask;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "loader", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroid/graphics/Bitmap;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "task", "Lkotlinx/coroutines/Deferred;", "Lexpo/modules/imagemanipulator/ManipulatorResult;", "addTransformer", "", "transformer", "Lexpo/modules/imagemanipulator/transformers/ImageTransformer;", "cancel", "launchLoader", "render", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManipulatorTask {
    private final CoroutineScope coroutineScope;
    private final Function1<Continuation<? super Bitmap>, Object> loader;
    private Deferred<ManipulatorResult> task;

    /* compiled from: ImageManipulatorContext.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagemanipulator.ManipulatorTask", f = "ImageManipulatorContext.kt", i = {}, l = {RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH}, m = "render", n = {}, s = {})
    /* renamed from: expo.modules.imagemanipulator.ManipulatorTask$render$1, reason: invalid class name and case insensitive filesystem */
    static final class C04781 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04781(Continuation<? super C04781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ManipulatorTask.this.render(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ManipulatorTask(CoroutineScope coroutineScope, Function1<? super Continuation<? super Bitmap>, ? extends Object> loader) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.coroutineScope = coroutineScope;
        this.loader = loader;
        this.task = launchLoader();
    }

    /* compiled from: ImageManipulatorContext.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lexpo/modules/imagemanipulator/ManipulatorResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagemanipulator.ManipulatorTask$launchLoader$1", f = "ImageManipulatorContext.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.imagemanipulator.ManipulatorTask$launchLoader$1, reason: invalid class name and case insensitive filesystem */
    static final class C04771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManipulatorResult>, Object> {
        int label;

        C04771(Continuation<? super C04771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ManipulatorTask.this.new C04771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ManipulatorResult> continuation) {
            return ((C04771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UnexpectedException unexpectedException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = ManipulatorTask.this.loader;
                    this.label = 1;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return new ManipulatorResult((Bitmap) obj, null);
            } catch (Throwable th) {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    String code = ((expo.modules.core.errors.CodedException) th).getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                    unexpectedException = new CodedException(code, th.getMessage(), th.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                return new ManipulatorResult(null, unexpectedException);
            }
        }
    }

    private final Deferred<ManipulatorResult> launchLoader() {
        return BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new C04771(null), 3, null);
    }

    /* compiled from: ImageManipulatorContext.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lexpo/modules/imagemanipulator/ManipulatorResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagemanipulator.ManipulatorTask$addTransformer$1", f = "ImageManipulatorContext.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.imagemanipulator.ManipulatorTask$addTransformer$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManipulatorResult>, Object> {
        final /* synthetic */ Deferred<ManipulatorResult> $oldTask;
        final /* synthetic */ ImageTransformer $transformer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Deferred<ManipulatorResult> deferred, ImageTransformer imageTransformer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$oldTask = deferred;
            this.$transformer = imageTransformer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$oldTask, this.$transformer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ManipulatorResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.$oldTask.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((ManipulatorResult) obj).map(this.$transformer);
        }
    }

    public final void addTransformer(ImageTransformer transformer) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        this.task = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new AnonymousClass1(this.task, transformer, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object render(kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof expo.modules.imagemanipulator.ManipulatorTask.C04781
            if (r0 == 0) goto L14
            r0 = r5
            expo.modules.imagemanipulator.ManipulatorTask$render$1 r0 = (expo.modules.imagemanipulator.ManipulatorTask.C04781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            expo.modules.imagemanipulator.ManipulatorTask$render$1 r0 = new expo.modules.imagemanipulator.ManipulatorTask$render$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.Deferred<expo.modules.imagemanipulator.ManipulatorResult> r5 = r4.task
            r0.label = r3
            java.lang.Object r5 = r5.await(r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            expo.modules.imagemanipulator.ManipulatorResult r5 = (expo.modules.imagemanipulator.ManipulatorResult) r5
            android.graphics.Bitmap r5 = r5.get()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagemanipulator.ManipulatorTask.render(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void reset() {
        Job.DefaultImpls.cancel$default((Job) this.task, (CancellationException) null, 1, (Object) null);
        this.task = launchLoader();
    }

    public final void cancel() {
        Job.DefaultImpls.cancel$default((Job) this.task, (CancellationException) null, 1, (Object) null);
    }
}
