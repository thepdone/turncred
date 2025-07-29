package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: ImageManipulatorModule.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagemanipulator.ImageManipulatorModule$createManipulatorContext$task$1", f = "ImageManipulatorModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ImageManipulatorModule$createManipulatorContext$task$1 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageManipulatorModule$createManipulatorContext$task$1(Bitmap bitmap, Continuation<? super ImageManipulatorModule$createManipulatorContext$task$1> continuation) {
        super(1, continuation);
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImageManipulatorModule$createManipulatorContext$task$1(this.$bitmap, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Bitmap> continuation) {
        return ((ImageManipulatorModule$createManipulatorContext$task$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$bitmap;
    }
}
